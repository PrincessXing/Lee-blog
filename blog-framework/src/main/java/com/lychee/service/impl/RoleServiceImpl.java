package com.lychee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.entity.Role;
import com.lychee.mapper.RoleMapper;
import com.lychee.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    // 判断用户是否是超级管理员 1L 如果是返回集合中只需要有admin
    @Override
    public List<String> selectRoleKeyByUserId(Long userId) {
        if (userId == 1L) {
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        // 否则查询用户所具有的角色信息
        return getBaseMapper().selectRoleKeyByUserId(userId);
    }

}
