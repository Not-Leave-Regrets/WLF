package com.wlf.interceptor.service;


import com.wlf.interceptor.entity.Role;
import com.wlf.interceptor.entity.User;
import com.wlf.interceptor.mapper.PermissionMapper;
import com.wlf.interceptor.mapper.RoleMapper;
import com.wlf.interceptor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Transactional
//    @Cacheable(value = "user1",key = "'user_'+#phone")
    public User querybyname(String phone) {
        User user =null;
        user = userMapper.selectByUsername(phone);
        if(user==null)
        {
            return user;
        }
        Role role = roleMapper.selectByUserId(user.getId());
        user.setRoles(role);
        return user;
    }
}
