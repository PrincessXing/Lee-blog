package com.lychee.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;
import com.lychee.domain.vo.UserInfoVo;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.exception.SystemException;
import com.lychee.mapper.UserMapper;
import com.lychee.service.UserService;
import com.lychee.utils.BeanCopyUtils;
import com.lychee.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired(required = false)
    public PasswordEncoder passwordEncoder;
    // 个人用户信息查询
    @Override
    public ResponseResult<?> userInfo() {
        Long userId = SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copy(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }
    //更新个人用户信息
    @Override
    public ResponseResult<?> updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }
    //注册
    @Override
    public ResponseResult<?> register(User user) {
        // 判断用户名是否为空
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        // 判断密码是否为空
        if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        // 判断邮箱是否为空
        if (!StringUtils.hasText(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        // 判断昵称是否为空
        if (!StringUtils.hasText(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        // 判断用户名是否存在
        if (usernameIsExist(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        // 判断邮箱是否存在
        if (emailIsExist(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        // 判断昵称是否存在
        if (nickNameIsExist(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //密码加密
        String encodePassWord = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassWord);
        save(user);
        return ResponseResult.okResult();
    }
    //判断用户名是否存在
    public boolean usernameIsExist(String username) {
        User user = getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, username));
        return user != null;
    }
    //判断昵称是否存在
    public boolean nickNameIsExist(String nickName) {
        User user = getOne(Wrappers.<User>lambdaQuery().eq(User::getNickName, nickName));
        return user != null;
    }
    //判断邮箱是否存在
    public boolean emailIsExist(String email) {
        User user = getOne(Wrappers.<User>lambdaQuery().eq(User::getEmail, email));
        return user != null;
    }

}
