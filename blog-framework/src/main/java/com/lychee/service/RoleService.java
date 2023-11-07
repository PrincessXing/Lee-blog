package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long userId);
}
