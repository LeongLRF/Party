package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.mapper.TypeMapper;
import com.wyu.partymanager.servicedao.TypeServiceDao;
import com.wyu.partymanager.utils.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeServiceDao {

    private final TypeMapper typeMapper;

    public TypeService(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Override
    public Result<Type> getById(long id) {
        return Result.ok(typeMapper.selectById(id));
    }

    @Override
    public Result<Type> add_type(Type type) {
        typeMapper.insert(type);
        return Result.ok(type);
    }

    @Override
    public Result<Type> edit_type(Type type) {
        typeMapper.updateById(type);
        return Result.ok(type);
    }

    @Override
    public Result<?> delete_type(long id) {
        typeMapper.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<List<Type>> type_list(Type.Filter filter) {
        return Result.ok(typeMapper.selectList(filter.apply()));
    }
}
