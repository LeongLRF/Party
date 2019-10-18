package com.wyu.partymanager.service.sys;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleMapper,Role> implements com.wyu.partymanager.servicedao.RoleService {
    private final RoleMapper roleMapper;
    private final RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public RoleService(RoleMapper roleMapper, RedisTemplate<String, Object> redisTemplate) {
        this.roleMapper = roleMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Result<Role> add_role(Role role) {
        roleMapper.insert(role);
        redisTemplate.opsForValue().set(Role.class.getName()+role.getId(),role.toJson());
        return Result.ok(role);
    }

    @Override
    public Result<Role> edit_role(Role role) {
        return null;
    }

    @Override
    public Result<?> delete_role(long id) {
        return null;
    }

    @Override
    public Result<Role> getById(long id) {
        String key = Role.class.getName() + id;
        if (redisTemplate.hasKey(key)){
            System.out.println("从缓存中读取*******************************");
            return Result.ok(JSON.parseObject((String) redisTemplate.opsForValue().get(key),Role.class));
        }
        return Result.ok(roleMapper.selectById(id));
    }

    @Override
    public Result<List<Role>> role_list(Role.Filter filter) {
        return Result.ok(roleMapper.selectList(filter.apply()));
    }
}
