package com.wyu.partymanager.service.sys;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.sys.Clazz;
import com.wyu.partymanager.entity.sys.Token;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.service.pm.ClazzService;
import com.wyu.partymanager.servicedao.UserServiceDao;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Preloader;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Service
public class UserService extends ServiceImpl<UserMapper,User> implements UserServiceDao {

    private final RedisTemplate<String,Object> redisTemplate;
    private final TokenService tokenService;
    private final ClazzService clazzService;

    public UserService(RedisTemplate<String, Object> redisTemplate, TokenService tokenService, ClazzService clazzService) {
        this.redisTemplate = redisTemplate;
        this.tokenService = tokenService;
        this.clazzService = clazzService;
    }

    @Override
    public Result<User> add_user(User user) {
        if (validSameUser(user)){
            return Result.error("用户已存在");
        }
        user.setSalt(UUID.randomUUID().toString());
        user.setPassword(encryptPassword(user.getSalt(),user.getPassword()));
        this.getBaseMapper().insert(user);
        String key = User.class.getName() + user.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(user));
        return Result.ok(user);
    }

    @Override
    public Result<User> getById(Object id) {
        String key = User.class.getName() + id;
//        if (redisTemplate.hasKey(key)){
//            return Result.ok(JSON.parseObject((String) redisTemplate.opsForValue().get(key),User.class));
//        }
        return Result.ok(this.getBaseMapper().selectById(id));
    }

    @Override
    public Result<?> delete_user(long id) {
        this.getBaseMapper().deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<User> edit_user(User user) {
        this.getBaseMapper().updateById(user);
        return Result.ok(user);
    }

    @Override
    public Result<User> updateById(long id, Consumer<User> action) {
        return Result.maybe(getById(id),"数据不存在")
                .andThen(user -> {
                    action.accept(user);
                    return Result.ok(user);
                });
    }

    @Override
    public Result<List<User>> user_list(User.Filter filter) {
        List<User> users = this.getBaseMapper().selectList(filter.apply());
        new Preloader<>(clazzService,users)
                .preload_one(User::getClassId, Clazz::getId,"id",User::setClazz);
        return Result.ok(users);
    }

    @Override
    public User findByUserName(String userName) {
        return this.getBaseMapper().findByUserName(userName);
    }

    @Override
    public Result<User> login(String userName, String password, HttpServletResponse response) {
        return Result.maybe(this.getBaseMapper().findUserByUserName(userName),"用户不存在")
                .andThenCheck(user -> validPassword(password,user),"密码错误")
                .andThenCheck(user -> user.isValid(),"对不起，该账号已被冻结")
                .andThen(user -> {
                    Token token = tokenService.lambdaQuery().eq(Token::getUserId,user.getId()).one();
                    if (token!=null) tokenService.removeById(token.getToken());
                    String newToken =UUID.randomUUID().toString().replace("-","");
                    Token token1 = new Token();
                    token1.setToken(newToken);
                    token1.setUserId(user.getId());
                    tokenService.save(token1);
                    Cookie cookie = new Cookie("token",newToken);
                    cookie.setPath("/");
                    cookie.setMaxAge(30*24*3600);
                    response.addCookie(cookie);
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
