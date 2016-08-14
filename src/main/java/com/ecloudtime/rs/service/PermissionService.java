package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Permission;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
public interface PermissionService {

    void save(Permission permission);

    void update(Permission permission);

    void delete(int id);

    Permission find(int id);

    List<Permission> query();

}
