package com.wyu.partymanager.service.pm;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.sys.Dept;
import com.wyu.partymanager.mapper.DeptMapper;
import com.wyu.partymanager.servicedao.DeptServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService extends ServiceImpl<DeptMapper,Dept> implements DeptServiceDao {
    private final DeptMapper deptMapper;

    public DeptService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public Result<Dept> add_dept(Dept dept) {
        return null;
    }

    @Override
    public Result<Dept> edit_dept(Dept dept) {
        return null;
    }

    @Override
    public Result<?> delete_dept(long id) {
        return null;
    }

    @Override
    public Result<List<Dept>> dept_list(Dept.Filter filter) {
        return null;
    }
}
