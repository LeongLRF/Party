package com.wyu.partymanager;

import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Preloader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartymanagerApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleMapper roleMapper;

    @Test
    public void get(){
        redisTemplate.opsForValue().set("456","abc");
        System.out.println(redisTemplate.opsForValue().get("456"));
    }

    @Test
    public void test(){
       Role role = roleMapper.selectById(1);
    }
    @Test
    public void test2(){
        User.Filter filter = new User.Filter();
        filter.setName("梁荣锋");
        List<User> users =userService.user_list(filter).data;
        users.forEach(u -> System.out.println(u.getTrueName()));
    }

    @Test
    public void serviceTest(){
        User user = new User();
        user.setUserName("123456789");
        user.setTrueName("leong");
        user.setPassword("123");
        System.out.println(userService.add_user(user).data.getTrueName());
    }

    @Test
    public void roleTest(){
        Role role = new Role();
        role.setName("学生");
        roleMapper.insert(role);
    }
    @Test
    public void preloadTest(){
        User user = userMapper.selectById(1);
        new Preloader<>(roleMapper, Collections.singletonList(user)).preload_one(User::getRoleId,"id",User::setRole);
        System.out.println(user);
    }

}
