package com.wyu.partymanager.service.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.MenuMapper;
import com.wyu.partymanager.servicedao.MenuServiceDao;
import com.wyu.partymanager.servicedao.RoleService;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Leong
 * @date 2019/9/25 15:35
 */
@Service
public class MenuService extends ServiceImpl<MenuMapper,Menu> implements MenuServiceDao {

    private final MenuMapper menuMapper;
    private final RoleService roleService;

    @Autowired
    public MenuService(MenuMapper menuMapper, RoleService roleService) {
        this.menuMapper = menuMapper;
        this.roleService = roleService;
    }

    @Override
    public Result<?> delete_menu(long id) {
        menuMapper.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<Menu> add_menu(Menu menu) {
        menuMapper.insert(menu);
        return Result.ok(menu);
    }

    @Override
    public Result<Menu> edit_menu(Menu menu) {
        menuMapper.updateById(menu);
        return Result.ok(menu);
    }

    @Override
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter, User user) {
        return Result.maybe(menuMapper.selectList(filter.apply()), "暂无菜单")
                .andThenCheck(user!=null,"请先登录")
                .andThen(menus -> {
                    if (menus.size() > 0) {
                        menus = menus.stream().filter(m -> m.permissions().contains(user.getRoleId()) && m.isValid()).collect(Collectors.toList());
                        Map<Long, List<Menu>> menuMap = menus.stream().collect(Collectors.groupingBy(Menu::getParentId));
                        List<MenuDTO> menuDTOS = menuMap.get(0L).stream().map(MenuDTO::new).collect(Collectors.toList());
                        menuDTOS.forEach(it -> it.setChildren(menuMap.get(it.getParent().getId())));
                        return Result.ok(menuDTOS);
                    } else {
                        return Result.error("暂无菜单");
                    }
                });
    }

    @Override
    public Result<List<Menu>> menu_list(Menu.Filter filter) {
        List<Menu> list = this.baseMapper.selectList(filter.apply());
        list.forEach(menu -> {
            List<Role> roles = (List<Role>) roleService.listByIds(menu.permissions());
            Menu parent = this.baseMapper.selectById(menu.getParentId());
            menu.setRoles(roles);
            menu.setParent(parent);
        });
        return Result.ok(list);
    }
}
