package com.example.sdudoc.service;

import com.example.sdudoc.entity.SysUser;
import com.example.sdudoc.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser getById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser getByName(String name) {
        return userMapper.selectByName(name);
    }

    public SysUser getByMobile(String mobile) {
        return userMapper.selectByMobile(mobile);
    }
}
