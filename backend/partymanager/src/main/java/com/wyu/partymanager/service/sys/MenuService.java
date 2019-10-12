package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.MenuMapper;
import com.wyu.partymanager.servicedao.MenuServiceDao;
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
public class MenuService implements MenuServiceDao {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
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
    public Result<List<MenuDTO>> menu_list(Menu.Filter filter, User user) {
        return Result.maybe(menuMapper.selectList(filter.apply()), "暂无菜单")
                .andThenCheck(user!=null,"请先登录")
                .andThen(menus -> {
                    if (menus.size() > 0) {
                        menus = menus.stream().filter(m -> m.getPermissions().contains(user.getRoleId()) && m.isValid()).collect(Collectors.toList());
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
        return Result.ok(menuMapper.selectList(filter.apply()));
    }
}
