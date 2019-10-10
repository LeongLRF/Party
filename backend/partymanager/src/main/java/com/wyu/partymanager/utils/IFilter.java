package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class IFilter<T> {

    private QueryWrapper<T> queryWrapper = new QueryWrapper<>();

    public abstract Wrapper<T> apply();

    protected QueryWrapper<T> queryWrapper(){
        return queryWrapper;
    }
}
