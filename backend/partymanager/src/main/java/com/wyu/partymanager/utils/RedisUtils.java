package com.wyu.partymanager.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyu.partymanager.entity.IEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SuppressWarnings("ConstantConditions")
public class RedisUtils<T extends IEntity> {

    // 默认过期时间
    private static final long DEFAULT_EXPIRE_TIME = 60 * 60 * 24;

    private BaseMapper<T> baseMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtils(BaseMapper<T> baseMapper, RedisTemplate<String, Object> redisTemplate) {
        this.baseMapper = baseMapper;
        this.redisTemplate = redisTemplate;
    }

    public Result<T> getById(Class<T> cls, Object id) {
        String key = cls.getName() + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            T t = (T) redisTemplate.opsForValue().get(key);
            return Result.ok(t);
        }
        return Result.ok(baseMapper.selectById((Serializable) id));
    }

    public Result<?> deleteById(Class<T> cls, Object id) {
        String key = cls.getName() + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        baseMapper.deleteById((Serializable) id);
        return Result.ok();
    }

    public Result<T> insert(Class<T> cls, T t) {
        baseMapper.insert(t);
        String key = cls.getName() + t.getId();
        redisTemplate.opsForValue().set(key, t, DEFAULT_EXPIRE_TIME);
        return Result.ok(t);
    }

    public Result<T> insert(Class<T> cls, T t, long expire) {
        baseMapper.insert(t);
        String key = cls.getName() + t.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(t), expire);
        return Result.ok(t);
    }

    public Result<T> update(Class<T> cls, T t) {
        baseMapper.updateById(t);
        String key = cls.getName() + t.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(t), DEFAULT_EXPIRE_TIME);
        return Result.ok(t);
    }

    public Result<T> update(Class<T> cls, T t, long expire) {
        baseMapper.updateById(t);
        String key = cls.getName() + t.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(t), expire);
        return Result.ok(t);
    }

    public Result<T> updateById(Class<T> cls, Object id, Consumer<T> t) {
        T entity = baseMapper.selectById((Serializable) id);
        if (t!=null){
            t.accept(entity);
            baseMapper.updateById(entity);
            String key = cls.getName() + entity.getId();
            redisTemplate.opsForValue().set(key, JSON.toJSONString(entity), DEFAULT_EXPIRE_TIME);
            return Result.ok(entity);
        }else {
            return Result.error("数据不存在");
        }
    }

    public  Result<List<T>> getByIds(Class<T> cls,List<Object> ids){
        List<T> list = ids.stream().map(id -> getById(cls,id).data).collect(Collectors.toList());
        return Result.ok(list);
    }
}
