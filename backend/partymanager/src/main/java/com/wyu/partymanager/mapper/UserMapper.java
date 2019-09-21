package com.wyu.partymanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyu.partymanager.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
