package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by eric on 2016/8/14.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequiresRoles("admin")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(@RequestParam(value = "id") int id) {

        Role role = roleService.find(id);
        System.out.println(role.getId());
        System.out.println(role.getName());
        for(Permission permission : role.getPermissions()) {
            System.out.println(permission.getDescription());
        }

        return "OK";
    }
}
