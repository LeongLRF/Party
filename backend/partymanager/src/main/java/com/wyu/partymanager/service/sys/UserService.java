package com.wyu.partymanager.service.sys;

import com.alibaba.fastjson.JSON;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.servicedao.UserServiceDao;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.RedisUtils;
import com.wyu.partymanager.utils.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public Result<List<User>> user_list(User.Filter filter) {
        return Result.ok(userMapper.selectList(filter.apply()));
    }

    @Override
    public Result<User> login(String userName, String password, HttpSession httpSession) {
        return Result.maybe(userMapper.findUserByUserName(userName),"用户不存在")
                .andThenCheck(user -> user.getPassword().equals(password),"密码错误")
                .andThen(user -> {
                    httpSession.setAttribute(Common.CURRENT_USER,user);
                    return Result.ok(user);
                });
    }
}
