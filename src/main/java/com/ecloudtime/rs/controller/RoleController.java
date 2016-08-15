package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Controller
@RequiresRoles("admin")
@RequestMapping(value = "/admin")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String roles(ModelMap map) {

        map.addAttribute("head_title", "Admin 资源管理系统");
        map.addAttribute("menu_title", "系统");
        map.addAttribute("breadcrumb", "Role");

        List<Role> roles = roleService.query();
        map.addAttribute("roles", roles);

        return "role/role_list";
    }
}
