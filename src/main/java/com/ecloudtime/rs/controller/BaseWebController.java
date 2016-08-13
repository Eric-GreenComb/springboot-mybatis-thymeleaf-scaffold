package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.core.bean.User;
import com.ecloudtime.rs.core.service.UserService;
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
public class BaseWebController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/pureadmin", method = RequestMethod.GET)
    public String pureadmin(ModelMap map) {
        List<User> users = userService.findAll();

        map.addAttribute("menu_title", "Pure");
        map.addAttribute("users", users);
        return "pureadmin";
    }

}
