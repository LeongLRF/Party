package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public interface IFilter<T> {
    QueryWrapper<T> getQueryWrapper();
    void setQueryWrapper(QueryWrapper<T> value);

    Wrapper<T> apply();
}
