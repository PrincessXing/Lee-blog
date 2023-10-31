package com.lychee.service.impl;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.LoginUser;
import com.lychee.domain.entity.User;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.exception.SystemException;
import com.lychee.service.LoginService;
import com.lychee.utils.JwtUtil;
import com.lychee.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.Objects;

public class SystemLoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        Long userId = loginUser.getUser().getId();
        // 根据userId生成token(jwt)
        String jwt = JwtUtil.createJWT(userId.toString());
        redisCache.setCacheObject("login:" + userId, loginUser);
        HashMap<String, String> map = new HashMap<>();
        // 返回token
        map.put("token", jwt);
        return ResponseResult.okResult(map);
    }
}
