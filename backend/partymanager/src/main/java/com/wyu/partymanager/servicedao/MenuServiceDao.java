package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.dto.MenuDTO;
import com.wyu.partymanager.entity.sys.Menu;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface MenuServiceDao {

    Result<?> delete_menu(long id);
    Result<Menu> add_menu(Menu menu);
    Result<List<MenuDTO>> menu_list(Menu.Filter filter, User user);
}
