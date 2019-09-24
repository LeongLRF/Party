package com.wyu.partymanager.controller;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Common;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Leong
 * @date 2019/9/24 23:05
 */
@RestController
public class BaseController {

    @Setter
    @Getter
    @Autowired
    HttpSession httpSession;

    public User current_user(){
        System.out.println(httpSession.getAttribute(Common.CURRENT_USER)+"***********");
        return (User) httpSession.getAttribute(Common.CURRENT_USER);
    }
}
