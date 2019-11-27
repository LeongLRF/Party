package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.servicedao.MenuServiceDao;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
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
public class MenuService implements MenuServiceDao {

    private final IDbConnection db;

    @Autowired
    public MenuService(IDbConnection db) {
        this.db = db;
    }

    @Override
    public Result<?> delete_menu(long id) {
        db.deleteById(Role.class,id);
        return Result.ok();
    }

    @Override
    public Result<Menu> add_menu(Menu menu) {
        db.insert(menu);
        return Result.ok(menu);
    }

    @Override
    public Result<Menu> edit_menu(Menu menu) {
        db.update(menu);
        return Result.ok(menu);
    }

    @Override
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter, User user) {
        return Result.maybe(db.form(Menu.class).apply(filter).toList(), "暂无菜单")
                .andThenCheck(user!=null,"请先登录")
                .andThen(menus -> {
                    if (menus.size() > 0) {
                        menus = menus.stream().filter(m -> m.permissions().contains(user.getRoleId()) && m.isValid()).collect(Collectors.toList());
                        Map<Long, List<Menu>> menuMap = menus.stream().collect(Collectors.groupingBy(Menu::getParentId));
                        if (menuMap.isEmpty()){
                            return Result.error("暂无菜单");
                        }
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
        List<Menu> list = db.form(Menu.class).apply(filter).toList();
        list.forEach(menu -> {
            List<Role> roles =  db.getByIds(Role.class,menu.permissions());
            Menu parent = db.getById(Menu.class,menu.getParentId());
            menu.setRoles(roles);
            menu.setParent(parent);
        });
        return Result.ok(list);
    }
}
