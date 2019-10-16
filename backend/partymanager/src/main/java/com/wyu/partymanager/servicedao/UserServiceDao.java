package com.wyu.partymanager.servicedao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.function.Consumer;

public interface UserServiceDao extends IService<User> {

    Result<User> add_user(User user);
    Result<User> getById(Object id);
    Result<?> delete_user(long id);
    Result<User> edit_user(User user);
    Result<User> updateById(long id, Consumer<User> action);
    Result<List<User>> user_list(User.Filter filter);
    User findByUserName(String userName);
    Result<User> login(String userName, String password, HttpSession httpSession);

}
