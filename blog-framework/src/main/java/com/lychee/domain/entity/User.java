package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {

    private Long id;
    // 用户名
    private String username;
    // 昵称
    private String nickname;
    // 密码
    private String password;
    // 用户类型 0 普通用户 1 管理员
    private String type;
    // 用户状态 0 正常 1 停用
    private String status;
    // 邮箱
    private String email;
    // 手机号
    private String phonenumber;
    // 性别 0 男 1 女 2 保密
    private String sex;
    // 头像
    private String avatar;
    // 创建者
    private String createBy;
    // 创建时间
    private String createTime;
    // 更新者
    private String updateBy;
    // 更新时间
    private String updateTime;
    // 删除标志 0 未删除 1 删除
    private String delFlag;

}
