package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

@Data
public abstract class BaseFilter<T> {
    QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    public abstract Wrapper<T> apply();
}
