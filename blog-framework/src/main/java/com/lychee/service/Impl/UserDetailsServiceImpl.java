package com.lychee.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lychee.domain.entity.LoginUser;
import com.lychee.domain.entity.User;
import com.lychee.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        // 判断用户是否存在 不存在抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("User does not exist");
        }
        // 返回用户信息
        // TODO: 从数据库中查询用户权限信息封装
        return new LoginUser(user);
    }
}
