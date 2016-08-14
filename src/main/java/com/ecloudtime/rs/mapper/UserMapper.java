package com.ecloudtime.rs.mapper;

import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Mapper
public interface UserMapper {

    void save(User user);

    void update(User user);

    User find(int id);

    List<User> query();

    void authorize(@Param(value = "user") User user, @Param(value = "role") Role role);

    List<Role> getRoles(User user);

    User getByName(String name);
}

