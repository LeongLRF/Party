package com.wyu.partymanager.service.pm;

import com.wyu.partymanager.entity.sys.Clazz;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leong
 * @date 2019/10/30 21:25
 */
@Service
public class AdminService {

    private final IDbConnection db;

    public AdminService(IDbConnection db) {
        this.db = db;
    }

    public Result<Clazz> add_clazz(Clazz clazz) {
        db.insert(clazz);
        return Result.ok(clazz);
    }

    public Result<List<Clazz>> clazz_list(Clazz.Filter filter) {
        return Result.ok(db.form(Clazz.class).apply(filter).toList());
    }

    public Result<?> delete_clazz(long id) {
        db.deleteById(Clazz.class, id);
        return Result.ok();
    }
}
