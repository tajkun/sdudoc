package com.example.sdudoc.service;

import com.example.sdudoc.mapper.SysPermissionMapper;
import com.example.sdudoc.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }
}
