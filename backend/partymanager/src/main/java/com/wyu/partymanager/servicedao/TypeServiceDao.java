package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface TypeServiceDao {

    Result<Type> getById(long id);
    Result<Type> add_type(Type type);
    Result<Type> edit_type(Type type);
    Result<?> delete_type(Type type);
    Result<List<Type>> type_list(Type.Filter filter);
}
