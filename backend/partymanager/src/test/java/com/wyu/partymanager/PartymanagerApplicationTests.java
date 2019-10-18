package com.wyu.partymanager;

import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.RoleMapper;
import com.wyu.partymanager.mapper.TypeMapper;
import com.wyu.partymanager.mapper.UserMapper;
import com.wyu.partymanager.service.pm.TakePartService;
import com.wyu.partymanager.service.sys.RoleService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Preloader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
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
    @Autowired
    TypeMapper typeMapper;
    @Autowired
    TakePartService takePartService;

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
        System.out.println(userService.updateById(1,user -> user.setClassId(3)).data);
    }

    @Test
    public void serviceTest() {
        User user = new User();
        user.setUserName("123456789");
        user.setTrueName("leong");
        user.setPassword("123");
//        System.out.println(userService.add_user(user).data.getTrueName());
    }

    @Test
    public void roleTest() {
        Role role = roleService.getById(7).data;
        System.out.println(role);
    }

    @Test
    public void preloadTest() {
        Role role = new Role() {{
            setName("maintenance");
            setInsertedAt(new Timestamp(new Date().getTime()));
            setUpdatedAt(new Timestamp(new Date().getTime()));
            setValid(true);
            setPermission("1,2");
        }};
        roleService.add_role(role);
        System.out.println(role.toJson());
    }
    @Test
    public void handlerTest(){
        Type type = new Type();
        type.setName("主题班会");
        List<Type.Detail> details = Collections.singletonList(new Type.Detail() {{
            setName("1234");
        }});
        type.setDetails(details);
        typeMapper.insert(type);
    }

    @Test
    public void g(){
        User user = userService.getById(1);
        new Preloader<>(takePartService, Collections.singletonList(user))
                .preload_many(User::getId, TakePart::getUserId,"userId",User::setTakeParts);
        System.out.println(user);
    }
    @Test
    public void p(){
        User user = userService.getById(1);
        new Preloader<>(roleService, Collections.singletonList(user))
                .preload_one(User::getRoleId, Role::getId,"id",User::setRole);
        System.out.println(user);
    }
}
