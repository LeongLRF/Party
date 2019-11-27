package com.wyu.partymanager.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.partymanager.entity.IEntity;
import core.inerface.IDbConnection;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Leong
 * @date 2019/9/25 16:44
 */
public class Preloader<T> {
    private IDbConnection db;
    private List<T> data;

    public Preloader(IDbConnection db, List<T> list) {
        this.db = db;
        this.data = list;
    }


    public <R> Preloader<R> preload_many(Class<R> cls,Function<T,Object> getId,Function<R,Object> f, String realKey, BiConsumer<T, List<R>> setter) {
        List<Object> ids = data.stream().map(getId).distinct().collect(Collectors.toList());
        if (ids.isEmpty()) ids.add(0);
        List<R> linkedEntity;
        linkedEntity = db.form(cls).in(realKey,(Collection<?>) ids).toList();
        Map<Object, List<R>> map = linkedEntity.stream().collect(Collectors.groupingBy(f));
        for (T entity : data) {
            List<R> r = map.get(getId.apply(entity));
            setter.accept(entity, r);
        }
        return new Preloader<>(db,linkedEntity);
    }

    public <R> void preload_one(Class<R> cls,Function<T, Object> getId,Function<R,Object> f, String realKey, BiConsumer<T, R> setter) {
        preload_many(cls,getId,f, realKey,(t, list) -> {
            if (list!=null&&!list.isEmpty()) {
                R r = list.get(0);
                setter.accept(t, r);
            }
        });
    }
}
