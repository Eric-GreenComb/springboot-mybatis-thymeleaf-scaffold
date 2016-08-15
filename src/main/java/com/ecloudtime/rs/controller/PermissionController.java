package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Controller
@RequiresRoles("admin")
@RequestMapping(value = "/admin")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public String permissions(ModelMap map) {

        map.addAttribute("head_title", "Admin 资源管理系统");
        map.addAttribute("menu_title", "系统");
        map.addAttribute("breadcrumb", "Permission");

        List<Permission> permissions = permissionService.query();
        map.addAttribute("permissions", permissions);

        return "permission/permission_list";
    }
}
