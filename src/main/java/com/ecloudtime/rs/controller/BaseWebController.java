package com.ecloudtime.rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eric on 2016/8/13.
 */
@Controller
public class BaseWebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {

        map.addAttribute("head_title", "Admin 资源管理系统");
        map.addAttribute("menu_title", "系统");
        map.addAttribute("breadcrumb", "Index");

        return "index";
    }

}
