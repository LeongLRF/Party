package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.servicedao.TypeServiceDao;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeServiceDao {

    private final IDbConnection db;

    public TypeService(IDbConnection db) {
        this.db = db;
    }

    @Override
    public Result<Type> getById(long id) {
        return Result.ok(db.getById(Type.class, id));
    }

    @Override
    public Result<Type> add_type(Type type) {
        db.insert(type);
        return Result.ok(type);
    }

    @Override
    public Result<Type> edit_type(Type type) {
        db.update(type);
        return Result.ok(type);
    }

    @Override
    public Result<?> delete_type(long id) {
        db.deleteById(Type.class, id);
        return Result.ok();
    }

    @Override
    public Result<List<Type>> type_list(Type.Filter filter) {
        return Result.ok(db.form(Type.class).apply(filter).toList());
    }
}
