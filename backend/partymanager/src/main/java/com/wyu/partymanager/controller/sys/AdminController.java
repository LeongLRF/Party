package com.wyu.partymanager.controller.sys;

import com.wyu.partymanager.controller.BaseController;
import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.*;
import com.wyu.partymanager.service.pm.AdminService;
import com.wyu.partymanager.service.sys.MenuService;
import com.wyu.partymanager.service.sys.RoleService;
import com.wyu.partymanager.service.sys.TypeService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/sys")
public class AdminController extends BaseController {

    private final UserService userService;
    private final MenuService menuService;
    private final RoleService roleService;
    private final TypeService typeService;
    private final AdminService adminService;

    @Autowired
    public AdminController(UserService userService, MenuService menuService, RoleService roleService, TypeService typeService, AdminService adminService) {
        this.userService = userService;
        this.menuService = menuService;
        this.roleService = roleService;
        this.typeService = typeService;
        this.adminService = adminService;
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login",method = {RequestMethod.GET, RequestMethod.POST})
    public Result<User> login(String userName, String password, HttpServletResponse response) {
        return userService.login(userName, password, response);
    }

    @ApiOperation("获取当前用户")
    @GetMapping("/current_user")
    public Result<User> getCurrent_user() {
        return Result.maybe(current_user(), "未登录");
    }

    @ApiOperation("初始化菜单")
    @GetMapping("/menu_list")
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter) {
        return menuService.menu_list(filter, current_user());
    }

    @ApiOperation("添加角色")
    @PostMapping("/add_role")
    public Result<Role> add_role(@RequestBody Role role) {
        return roleService.add_role(role);
    }

    @ApiOperation("获取【角色】列表")
    @GetMapping("/role_list")
    public Result<List<Role>> role_list(Role.Filter filter) {
        return roleService.role_list(filter);
    }

    @ApiOperation("添加菜单")
    @GetMapping("/add_menu")
    public Result<Menu> add_menu(@RequestBody Menu menu) {
        return menuService.add_menu(menu);
    }

    @ApiOperation("删除菜单")
    @PostMapping("/delete_menu")
    public Result<?> delete_menu(long id) {
        return menuService.delete_menu(id);
    }

    @ApiOperation("获取所有菜单")
    @GetMapping("/all_menu")
    public Result<List<Menu>> all_menu(Menu.Filter filter) {
        return menuService.menu_list(filter);
    }

    @ApiOperation("修改菜单")
    @PostMapping("/edit_menu")
    public Result<Menu> edit_menu(@RequestBody Menu menu) {
        return menuService.edit_menu(menu);
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Common.CURRENT_USER);
        return Result.ok();
    }

    @ApiOperation("添加活动类别")
    @PostMapping("/add_type")
    public Result<Type> add_type(@RequestBody Type type) {
        return typeService.add_type(type);
    }

    @ApiOperation("删除活动类型")
    @PostMapping("/delete_type")
    public Result<?> delete_type(long id) {
        return typeService.delete_type(id);
    }

    @ApiOperation("修改活动类别")
    @PostMapping("/edit_type")
    public Result<Type> edit_type(@RequestBody Type type) {
        return typeService.edit_type(type);
    }

    @ApiOperation("类别列表")
    @GetMapping("/type_list")
    public Result<List<Type>> type_list(Type.Filter filter){
        return typeService.type_list(filter);
    }

    @ApiOperation("添加班级")
    @PostMapping("/add_clazz")
    public Result<Clazz> add_clazz(@RequestBody Clazz clazz){
        return adminService.add_clazz(clazz);
    }

    @ApiOperation("获取班级列表")
    @GetMapping("clazz_list")
    public Result<List<Clazz>> clazz_list(Clazz.Filter filter){
        return adminService.clazz_list(filter);
    }

    @ApiOperation("删除班级")
    @PostMapping("/delete_clazz")
    public Result<?> delete_clazz(long id){
        return adminService.delete_clazz(id);
    }
}
