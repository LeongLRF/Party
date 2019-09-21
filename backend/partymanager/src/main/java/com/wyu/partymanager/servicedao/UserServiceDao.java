package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface UserServiceDao {

    Result<User> add_user(User user);
    Result<?> delete_user(User user);
    Result<User> edit_user(User user);
    Result<List<User>> user_list(User.Filter filter);
}
