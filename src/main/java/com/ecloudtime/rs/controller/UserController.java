package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.core.bean.User;
import com.ecloudtime.rs.core.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/13.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users() {

        List<User> users = userService.findAll();

        return users;
    }


}