package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.servicedao.RoleServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceDao {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Result<Role> add_role(Role role) {
        return null;
    }

    @Override
    public Result<Role> edit_role(Role role) {
        return null;
    }

    @Override
    public Result<?> delete_role(Role role) {
        return null;
    }

    @Override
    public Result<List<Role>> role_list(Role.Filter filter) {
        return null;
    }
}
