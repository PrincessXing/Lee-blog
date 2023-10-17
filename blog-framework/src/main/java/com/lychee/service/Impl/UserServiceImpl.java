package com.lychee.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;
import com.lychee.domain.vo.UserInfoVo;
import com.lychee.mapper.UserMapper;
import com.lychee.service.UserService;
import com.lychee.utils.BeanCopyUtils;
import com.lychee.utils.SecurityUtils;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 个人用户信息查询
    @Override
    public ResponseResult<?> userInfo() {
        Long userId = SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copy(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }
}
