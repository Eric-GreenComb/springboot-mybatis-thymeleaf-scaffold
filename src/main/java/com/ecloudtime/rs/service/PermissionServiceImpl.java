package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper mapper;

    @Override
    public void save(Permission permission) {
        mapper.save(permission);
    }

    @Override
    public void update(Permission permission) {
        mapper.update(permission);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }

    @Override
    public Permission find(int id) {
        return mapper.find(id);
    }

    @Override
    public List<Permission> query() {
        return mapper.query();
    }


}

