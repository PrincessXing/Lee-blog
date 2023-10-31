package com.lychee.controller;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.exception.SystemException;
import com.lychee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(User user) {
        if(StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

}