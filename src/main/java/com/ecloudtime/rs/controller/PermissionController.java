package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.service.PermissionService;
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
@RequestMapping(value = "/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Permission find(@RequestParam(value = "id") int id) {

        Permission permission = permissionService.find(id);

        return permission;
    }
}
