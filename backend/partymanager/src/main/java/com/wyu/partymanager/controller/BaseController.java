package com.wyu.partymanager.controller;

import com.wyu.partymanager.entity.sys.Dept;
import com.wyu.partymanager.entity.sys.Role;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.RoleService;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Preloader;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;


/**
 * @author Leong
 * @date 2019/9/24 23:05
 */
@RestController
@SuppressWarnings("all")
public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private RoleService roleService;
    @Autowired
    IDbConnection db;

    protected User current_user() {
        User user = (User) httpSession.getAttribute(Common.CURRENT_USER);
        new Preloader<>(db, Collections.singletonList(user))
                .preload_one(Role.class, User::getRoleId, Role::getId, "id", User::setRole);
        return user;
    }


    public Dept current_dept() {
        return (Dept) httpSession.getAttribute(Common.CURRENT_DEPT);
    }
}

