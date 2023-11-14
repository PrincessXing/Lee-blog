package com.lychee.controller;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.LoginUser;
import com.lychee.domain.entity.Menu;
import com.lychee.domain.entity.User;
import com.lychee.domain.vo.AdminUserInfoVo;
import com.lychee.domain.vo.RoutersVo;
import com.lychee.domain.vo.UserInfoVo;
import com.lychee.enums.AppHttpCodeEnum;
import com.lychee.exception.SystemException;
import com.lychee.service.LoginService;
import com.lychee.service.MenuService;
import com.lychee.service.RoleService;
import com.lychee.utils.BeanCopyUtils;
import com.lychee.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    // admin登录
    @PostMapping("/user/login")
    public ResponseResult login(User user) {
        if(StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    // 获取用户菜单权限信息 返回adminUserInfoVo(包含菜单权限信息、角色信息、用户信息)
    @GetMapping("/getInfo")
    public ResponseResult<?> getInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 通过用户id查询用户的菜单权限
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());
        // 获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copy(user, UserInfoVo.class);
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms, roleKeyList, userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    // 获取路由信息
    @GetMapping("/getRouters")
    public ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getLoginUser().getUser().getId();
        // 通过用户id查询用户的菜单权限
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        return ResponseResult.okResult(new RoutersVo(menus));
    }

    // 退出登录
    @PostMapping("/user/logout")
    public ResponseResult<?> logout(){
        return loginService.logout();
    }

}