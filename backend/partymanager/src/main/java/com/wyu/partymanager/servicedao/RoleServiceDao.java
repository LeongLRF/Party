package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface RoleServiceDao{
    Result<Role> add_role(Role role);
    Result<Role> edit_role(Role role);
    Result<?> delete_role(Role role);
    Result<Role> getById(long id);
    Result<List<Role>> role_list(Role.Filter filter);
}
