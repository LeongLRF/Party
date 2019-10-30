package com.wyu.partymanager.service.pm;

import com.alibaba.druid.sql.visitor.functions.If;
import com.wyu.partymanager.entity.sys.Clazz;
import com.wyu.partymanager.utils.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leong
 * @date 2019/10/30 21:25
 */
@Service
public class AdminService {

    private final ClazzService clazzService;

    public AdminService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    public Result<Clazz> add_clazz(Clazz clazz){
        clazzService.save(clazz);
        return Result.ok(clazz);
    }

    public Result<List<Clazz>> clazz_list(Clazz.Filter filter){
        return Result.ok(clazzService.list(filter.apply()));
    }

    public Result<?> delete_clazz(long id){
        clazzService.removeById(id);
        return Result.ok();
    }
}
