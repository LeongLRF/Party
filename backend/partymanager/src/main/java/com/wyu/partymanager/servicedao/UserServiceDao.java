package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserServiceDao {

    Result<User> add_user(User user);
    Result<User> getById(Object id);
    Result<?> delete_user(long id);
    Result<User> edit_user(User user);
    Result<List<User>> user_list(User.Filter filter);
    User findByUserName(String userName);
    Result<User> login(String userName, String password, HttpServletResponse response);

}
