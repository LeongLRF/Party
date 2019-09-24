package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.servicedao.UserServiceDao;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Leong
 * @date 2019/9/21 13:15
 */
@Service
public class UserService implements UserServiceDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> add_user(User user) {
        userMapper.insert(user);
        return Result.ok(user);
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
