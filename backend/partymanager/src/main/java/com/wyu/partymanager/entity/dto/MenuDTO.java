package com.wyu.partymanager.entity.dto;

import com.wyu.partymanager.entity.sys.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;
import java.util.List;

/**
 * @author Leong
 * @date 2019/9/25 15:26
 */
@Data
public class MenuDTO {
    public MenuDTO(Menu menu){
        this.parent = menu;
    }
    Menu parent;
    List<Menu> children;
}
