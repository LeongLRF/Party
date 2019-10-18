package com.wyu.partymanager.servicedao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface RoleService extends IService<Role> {
    Result<Role> add_role(Role role);
    Result<Role> edit_role(Role role);
    Result<?> delete_role(long id);
    Result<Role> getById(long id);
    Result<List<Role>> role_list(Role.Filter filter);
}
