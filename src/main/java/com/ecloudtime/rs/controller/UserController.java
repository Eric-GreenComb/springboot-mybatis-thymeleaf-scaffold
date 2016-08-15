package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.User;
import com.ecloudtime.rs.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/13.
 */
@Controller
@RequiresRoles("admin")
@RequestMapping(value = "/admin")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String users(ModelMap map) {

        map.addAttribute("head_title", "Admin 资源管理系统");
        map.addAttribute("menu_title", "系统");
        map.addAttribute("breadcrumb", "User");

        List<User> users = userService.query();
        map.addAttribute("users", users);

        return "user/user_list";
    }

}