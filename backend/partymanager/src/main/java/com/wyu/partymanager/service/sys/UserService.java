package com.wyu.partymanager.service.sys;

import com.alibaba.fastjson.JSON;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.servicedao.UserServiceDao;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author Leong
 * @date 2019/9/21 13:15
 */
@SuppressWarnings("ALL")
@Service
public class UserService implements UserServiceDao {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Result<User> add_user(User user) {
        if (validSameUser(user)){
            return Result.error("用户已存在");
        }
        user.setSalt(UUID.randomUUID().toString());
        user.setPassword(encryptPassword(user.getSalt(),user.getPassword()));
        userMapper.insert(user);
        String key = User.class.getName() + user.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(user));
        return Result.ok(user);
    }

    @Override
    public Result<User> getById(Object id) {
        String key = User.class.getName() + id;
        if (redisTemplate.hasKey(key)){
            return Result.ok(JSON.parseObject((String) redisTemplate.opsForValue().get(key),User.class));
        }
        return Result.ok(userMapper.selectById(id));
    }

    @Override
    public Result<?> delete_user(User user) {
        userMapper.deleteById(user.getId());
        return Result.ok();
    }

    @Override
    public Result<User> edit_user(User user) {
        userMapper.updateById(user);
        return Result.ok(user);
    }

    @Override
    public Result<User> updateById(long id, Consumer<User> action) {
        return Result.maybe(getById(id).data,"数据不存在")
                .andThen(user -> {
                    action.accept(user);
                    return Result.ok(user);
                });
    }

    @Override
    public Result<List<User>> user_list(User.Filter filter) {
        return Result.ok(userMapper.selectList(filter.apply()));
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public Result<User> login(String userName, String password, HttpSession httpSession) {
        return Result.maybe(userMapper.findUserByUserName(userName),"用户不存在")
                .andThenCheck(user -> validPassword(password,user),"密码错误")
                .andThenCheck(user -> user.isValid(),"对不起，该账号已被冻结")
                .andThen(user -> {
                    httpSession.setAttribute(Common.CURRENT_USER,user);
                    return Result.ok(user);
                });
    }
    // 加密用户密码
    public String encryptPassword(String salt, String password) {
        String str = salt + "---" + password;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] b = str.getBytes();
        byte[] digest = md5.digest(b);
        return Base64.getEncoder().encodeToString(digest);
    }

    boolean validSameUser(User user){
        return findByUserName(user.getUserName()) != null;
    }
    boolean validPassword(String password,User user){
        return encryptPassword(user.getSalt(),password).equals(user.getPassword());
    }
}
