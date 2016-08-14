package com.ecloudtime.rs.service;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eric on 2016/8/14.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Override
    public void save(Role role) {
        mapper.save(role);
        for (Permission permission : role.getPermissions()) {
            mapper.savePermission(role, permission);
        }
    }

    @Override
    public void update(Role role) {
        mapper.update(role);
        mapper.deletePermission(role);
        for (Permission permission : role.getPermissions()) {
            mapper.savePermission(role, permission);
        }
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }

    @Override
    public Role find(int id) {
        return mapper.find(id);
    }

    @Override
    public List<Role> query() {
        return mapper.query();
    }


}

