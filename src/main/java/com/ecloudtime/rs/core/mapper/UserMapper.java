package com.ecloudtime.rs.core.mapper;

import com.ecloudtime.rs.core.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by eric on 2016/8/13.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

}
