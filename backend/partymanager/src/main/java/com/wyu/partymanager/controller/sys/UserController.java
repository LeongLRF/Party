package com.wyu.partymanager.controller.sys;

import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Leong
 * @date 2019/9/21 14:56
 */
@RestController
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加【用户】")
    @PostMapping("/add_user")
    public Result<User> add_user(@RequestBody User user){
        return userService.add_user(user);
    }
}
