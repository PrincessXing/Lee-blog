package com.lychee.service;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ResponseResult login(User user);
}
