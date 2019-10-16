package com.example.sdudoc.service;

import com.example.sdudoc.mapper.SysRoleMapper;
import com.example.sdudoc.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole getById(Integer id) {
        return roleMapper.selectById(id);
    }

    public SysRole getByName(String roleName) {
        return roleMapper.selectByName(roleName);
    }
}
