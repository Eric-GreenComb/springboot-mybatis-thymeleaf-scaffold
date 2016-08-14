package com.ecloudtime.rs.mapper;

import com.ecloudtime.rs.bean.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Mapper
public interface PermissionMapper {

    void save(Permission permission);

    void update(Permission permission);

    void delete(int id);

    Permission find(int id);

    List<Permission> query();

}
