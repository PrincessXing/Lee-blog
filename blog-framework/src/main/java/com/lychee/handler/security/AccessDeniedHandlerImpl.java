package com.lychee.handler.security;

import com.alibaba.fastjson.JSON;
import com.lychee.domain.ResponseResult;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 自定义授权失败处理类
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) {
        // 打印异常信息 方便调试
        e.printStackTrace();
        // 响应给前端需要重新登录
        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
    }
}
