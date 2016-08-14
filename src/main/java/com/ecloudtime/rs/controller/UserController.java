package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.User;
import com.ecloudtime.rs.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by eric on 2016/8/13.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequiresRoles("admin")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User find(@RequestParam(value = "id") int id) {

        User user = userService.find(id);

        return user;
    }

}