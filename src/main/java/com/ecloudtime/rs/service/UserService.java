package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.bean.User;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
public interface UserService {

    void save(User user);

    void update(User user);

    User find(int id);

    User getByName(String name);

    List<User> query();

    void authorize(User user, List<Role> roles);

    List<Role> getRoles(User user);

}
