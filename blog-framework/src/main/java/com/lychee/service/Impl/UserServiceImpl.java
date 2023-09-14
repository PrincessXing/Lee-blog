package com.lychee.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.entity.User;
import com.lychee.mapper.UserMapper;
import com.lychee.service.UserService;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
