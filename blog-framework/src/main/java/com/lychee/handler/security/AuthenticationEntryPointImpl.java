package com.lychee.handler.security;

import com.alibaba.fastjson.JSON;
import com.lychee.domain.ResponseResult;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.utils.WebUtils;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 自定义认证失败处理类
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) {
        // 打印异常信息 方便调试
        e.printStackTrace();
        ResponseResult result = null;
        if (e instanceof org.springframework.security.authentication.BadCredentialsException) {
            result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(),e.getMessage());
        }else if (e instanceof InsufficientAuthenticationException) {
            result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }else {
            result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),"认证或授权失败");
        }
        // 响应给前端需要重新登录
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
    }
}
