package com.ecloudtime.rs.core.service;

import com.ecloudtime.rs.core.bean.User;
import com.ecloudtime.rs.core.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eric on 2016/8/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }
}
