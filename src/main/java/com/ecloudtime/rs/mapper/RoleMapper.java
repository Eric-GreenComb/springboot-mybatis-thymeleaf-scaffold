package com.ecloudtime.rs.mapper;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Mapper
public interface RoleMapper {

    void save(Role role);

    void update(Role role);

    void delete(int id);

    Role find(int id);

    List<Role> query();

    void savePermission(@Param(value = "role") Role role, @Param(value = "permission") Permission permission);

    void deletePermission(@Param(value = "role") Role role);
}

