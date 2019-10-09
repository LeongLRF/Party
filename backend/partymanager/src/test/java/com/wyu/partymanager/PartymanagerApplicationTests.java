package com.wyu.partymanager;

import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.service.sys.RoleService;
import com.wyu.partymanager.service.sys.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartymanagerApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;

    @Test
    public void get() {
        User user = new User();
        user.setTrueName("wwj");
        user.setUserName("wwj");
        user.setPassword("123");
        userService.add_user(user);
        System.out.println(user);
    }

    @Test
    public void test() {
        Role role = roleMapper.selectById(1);
    }

    @Test
    public void test2() {
        User.Filter filter = new User.Filter();
        filter.setName("梁荣锋");
        List<User> users = userService.user_list(filter).data;
        users.forEach(u -> System.out.println(u.getTrueName()));
    }

    @Test
    public void serviceTest() {
        User user = new User();
        user.setUserName("123456789");
        user.setTrueName("leong");
        user.setPassword("123");
        System.out.println(userService.add_user(user).data.getTrueName());
    }

    @Test
    public void roleTest() {
       List<Integer> integers = Arrays.asList(1,2,2,3);
        System.out.println(integers.stream().filter(it->it == 2).count());
    }

    @Test
    public void preloadTest() {
        Role role = new Role() {{
            setName("admin");
            setInsertedAt(new Timestamp(new Date().getTime()));
            setUpdatedAt(new Timestamp(new Date().getTime()));
            setValid(true);
            setPermission("1,2");
        }};
        roleService.add_role(role);
        System.out.println(role.toJson());
    }

}
