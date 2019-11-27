package com.wyu.partymanager.service.pm;

import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.mapper.TakePartMapper;
import com.wyu.partymanager.servicedao.TakePartServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakePartService implements TakePartServiceDao {
    private final TakePartMapper takePartMapper;

    public TakePartService(TakePartMapper takePartMapper) {
        this.takePartMapper = takePartMapper;
    }

    @Override
    public Result<TakePart> add_takePart(TakePart takePart) {
        return null;
    }

    @Override
    public Result<TakePart> edit_takePart(TakePart takePart) {
        return null;
    }

    @Override
    public Result<?> delete_takePart(long id) {
        return null;
    }

    @Override
    public Result<List<TakePart>> takePart_list(TakePart.Filter filter) {
        return null;
    }
}
