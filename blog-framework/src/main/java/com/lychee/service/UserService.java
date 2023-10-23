package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;

public interface UserService extends IService<User> {
    ResponseResult<?> userInfo();

    ResponseResult<?> updateUserInfo(User user);

    ResponseResult<?> register(User user);
}
