package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.sys.Dept;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface DeptServiceDao {

    Result<Dept> add_dept(Dept dept);
    Result<Dept> edit_dept(Dept dept);
    Result<?> delete_dept(long id);
    Result<List<Dept>> dept_list(Dept.Filter filter);
}
