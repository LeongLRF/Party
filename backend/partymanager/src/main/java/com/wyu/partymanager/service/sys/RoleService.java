package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService  implements com.wyu.partymanager.servicedao.RoleService {
    private final IDbConnection db;

    @Autowired
    public RoleService(IDbConnection db) {
        this.db = db;
    }

    @Override
    public Result<Role> add_role(Role role) {
        db.insert(role);
        return Result.ok(role);
    }

    @Override
    public Result<Role> edit_role(Role role) {
        db.update(role);
        return Result.ok(role);
    }

    @Override
    public Result<?> delete_role(long id) {
        db.deleteById(Role.class,id);
        return Result.ok();
    }

    @Override
    public Result<Role> getById(long id) {
        return Result.ok(db.getById(Role.class,id));
    }

    @Override
    public Result<List<Role>> role_list(Role.Filter filter) {
        return Result.ok(db.form(Role.class).apply(filter).toList());
    }
}
