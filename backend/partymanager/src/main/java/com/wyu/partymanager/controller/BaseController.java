package com.wyu.partymanager.controller;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Common;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Setter
    @Getter
    @Autowired
    HttpSession httpSession;

    public User current_user(){
        User user = (User) httpSession.getAttribute(Common.CURRENT_USER);
        if (user == null){
            logger.info("session超时");
        }
        return user;
    }
}
