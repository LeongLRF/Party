package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Leong
 * @date 2019/9/25 16:44
 */
public class Preloader<T,R> {
    private BaseMapper<T> baseMapper;
    private List<T> data;

    public Preloader (BaseMapper<T> mapper,List<T> list){
        this.baseMapper =mapper;
        this.data=list;
    }


    public void preload_1(Class<R> cls, Function<Object,T> getId, String realKey,Consumer<R> setter){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(realKey,getId);
        data.forEach(d -> {
            Object o = baseMapper.selectOne(queryWrapper);
            setter.accept((cls.cast(o)));
        });


    }
}
