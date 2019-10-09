package com.wyu.partymanager.controller.sys;

import com.wyu.partymanager.controller.BaseController;
import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.MenuService;
import com.wyu.partymanager.service.sys.RoleService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/sys")
public class AdminController extends BaseController {

    private final UserService userService;
    private final MenuService menuService;
    private final RoleService roleService;

    @Autowired
    public AdminController(HttpSession httpSession, UserService userService, MenuService menuService, RoleService roleService) {
        super(httpSession);
        this.userService = userService;
        this.menuService = menuService;
        this.roleService = roleService;
    }
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

    @ApiOperation("初始化菜单")
    @GetMapping("/menu_list")
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter){
        return menuService.menu_list(filter,current_user());
    }

    @ApiOperation("添加角色")
    @PostMapping("/add_role")
    public Result<Role> add_role(@RequestBody Role role){
        return roleService.add_role(role);
    }

    @ApiOperation("获取【角色】列表")
    @GetMapping("/role_list")
    public Result<List<Role>> role_list(Role.Filter filter){
        return roleService.role_list(filter);
    }

    @ApiOperation("添加菜单")
    @GetMapping("/ass_menu")
    public Result<Menu> add_menu(@RequestBody Menu menu){
        return menuService.add_menu(menu);
    }

}
