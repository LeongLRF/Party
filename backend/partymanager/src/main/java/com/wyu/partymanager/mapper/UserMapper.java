package com.wyu.partymanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyu.partymanager.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where userName = #{userName}")
    User findUserByUserName(String userName);
}
