package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface TakePartServiceDao {
    Result<TakePart> add_takePart(TakePart takePart);
    Result<TakePart> edit_takePart(TakePart takePart);
    Result<?> delete_takePart(long id);
    Result<List<TakePart>> takePart_list(TakePart.Filter filter);
}
