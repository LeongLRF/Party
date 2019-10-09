package com.wyu.partymanager.service.sys;

import com.alibaba.fastjson.JSON;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.servicedao.RoleServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceDao {
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
        String key = Role.class.getName() + role.getId();
        redisTemplate.opsForValue().set(key,role.toJson());
        return Result.ok(role);
    }

    @Override
    public Result<Role> edit_role(Role role) {
        return null;
    }

    @Override
    public Result<?> delete_role(Role role) {
        return null;
    }

    @Override
    public Result<Role> getById(long id) {
        String key = Role.class.getName() + id;
        if (redisTemplate.hasKey(key)){
            return Result.ok(JSON.parseObject((String) redisTemplate.opsForValue().get(key),Role.class));
        }
        return Result.ok(roleMapper.selectById(id));
    }

    @Override
    public Result<List<Role>> role_list(Role.Filter filter) {
        return Result.ok(roleMapper.selectList(filter.apply()));
    }
}
