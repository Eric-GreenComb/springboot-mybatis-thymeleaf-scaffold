package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.bean.User;
import com.ecloudtime.rs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public void save(User user) {
        mapper.save(user);
    }

    @Override
    public void update(User user) {
        mapper.update(user);
    }

    @Override
    public User find(int id) {
        return mapper.find(id);
    }

    @Override
    public User getByName(String name) {
        return mapper.getByName(name);
    }

    @Override
    public List<User> query() {
        return mapper.query();
    }

    @Override
    public void authorize(User user, List<Role> roles) {
        for (Role role : roles) {
            mapper.authorize(user, role);
        }
    }

    @Override
    public List<Role> getRoles(User user) {
        return mapper.getRoles(user);
    }


}

