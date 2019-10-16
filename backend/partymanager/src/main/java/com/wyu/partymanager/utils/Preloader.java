package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.partymanager.entity.IEntity;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Leong
 * @date 2019/9/25 16:44
 */
public class Preloader<T extends IEntity, R extends IEntity> {
    private IService<R> service;
    private List<T> data;

    public Preloader(IService<R> service, List<T> list) {
        this.service = service;
        this.data = list;
    }


    public <F,Q> void preload_many(Function<T, F> getId,Function<R,Q> f, String realKey, BiConsumer<T, List<R>> setter) {
        QueryWrapper<R> queryWrapper = new QueryWrapper<>();
        List<Object> ids = data.stream().map(getId).distinct().collect(Collectors.toList());
        queryWrapper.in(realKey, ids);
        List<R> linkedEntity;
        linkedEntity = service.list(queryWrapper);
        Map<Object, List<R>> map = linkedEntity.stream().collect(Collectors.groupingBy(f));
        for (T entity : data) {
            List<R> r = map.get(entity.getId());
            setter.accept(entity, r);
        }
    }

    public <F,Q> void preload_one(Function<T, F> getId,Function<R,Q> f, String realKey, BiConsumer<T, R> setter) {
        preload_many(getId,f, realKey,(t, list) -> {
            if (!list.isEmpty()) {
                R r = list.get(0);
                setter.accept(t, r);
            }
        });
    }
}
