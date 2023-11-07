package com.lychee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lychee.domain.entity.Role;

import java.util.List;

/**
 * 角色表(Menu)表数据库访问层
 * @author lee
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<String> selectRoleKeyByUserId(Long id );
}
