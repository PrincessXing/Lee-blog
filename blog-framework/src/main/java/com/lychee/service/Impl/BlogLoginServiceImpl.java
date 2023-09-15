package com.lychee.service.Impl;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.LoginUser;
import com.lychee.domain.entity.User;
import com.lychee.domain.vo.BlogUserLoginVo;
import com.lychee.domain.vo.UserInfoVo;
import com.lychee.service.BlogLoginService;
import com.lychee.utils.BeanCopyUtils;
import com.lychee.utils.JwtUtil;
import com.lychee.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("Username or password error");
        }
        // 获取UserId 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userId = loginUser.getUser().getId();
        String jwt = JwtUtil.createJWT(userId.toString());
        // 把用户信息存储到redis中 key为blogLogin:userId
        redisCache.setCacheObject("blogLogin:"+userId, loginUser);
        // 把token和UserInfo封装 返回
        UserInfoVo userInfoVo = BeanCopyUtils.copy(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(blogUserLoginVo);
    }
}
