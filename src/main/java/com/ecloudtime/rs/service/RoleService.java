package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Role;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
public interface RoleService {

    void save(Role role);

    void update(Role role);

    void delete(int id);

    Role find(int id);

    List<Role> query();

}
