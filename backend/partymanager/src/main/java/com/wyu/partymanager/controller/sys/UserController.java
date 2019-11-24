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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Leong
 * @date 2019/9/21 14:56
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;
    private final MenuService menuService;

    @Autowired
    public UserController(MenuService menuService, UserService userService) {
        this.menuService = menuService;
        this.userService = userService;
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

    @ApiOperation("修改【用户】")
    @PostMapping("/edit_user")
    public Result<User> edit_user(@RequestBody User user){
        return userService.edit_user(user);
    }

    @ApiOperation("删除【用户】")
    @PostMapping("/delete_user")
    public Result<?> delete_user(long id){
        return userService.delete_user(id);

    }

    @ApiOperation("dbtest")
    @GetMapping("/test")
    public Result<List<User>> test(){
        return userService.getUsers();
    }
}
