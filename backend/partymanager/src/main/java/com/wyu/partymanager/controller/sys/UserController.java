package com.wyu.partymanager.controller.sys;

import com.wyu.partymanager.controller.BaseController;
import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.MenuService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leong
 * @date 2019/9/21 14:56
 */
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<User> login(String userName, String password) {
        return userService.login(userName, password, getHttpSession());
    }

    @ApiOperation("获取当前用户")
    @GetMapping("/current_user")
    public Result<User> getCurrent_user() {
        return Result.maybe(current_user(),"未登录");
    }

    @ApiOperation("添加【用户】")
    @PostMapping("/add_user")
    public Result<User> add_user(@RequestBody User user) {
        return userService.add_user(user);
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/user_list")
    public Result<List<User>> user_list(User.Filter filter) {
        System.out.println(current_user());
        return userService.user_list(filter);
    }

    @ApiOperation("初始化菜单")
    @GetMapping("/menu_list")
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter){
        return menuService.menu_list(filter,current_user());
    }
}
