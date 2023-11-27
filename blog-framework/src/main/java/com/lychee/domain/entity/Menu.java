package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

// 菜单权限表
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("menu")
@Accessors(chain = true) // 链式调用 使set方法返回当前对象
public class Menu {
    @TableId
    private Long id;
    // 菜单名称
    private String menuName;
    // 父菜单ID
    private Long parentId;
    // 祖级列表
    private List<Menu> children;
    // 显示顺序
    private Integer orderNum;
    // 路由地址
    private String path;
    // 组件路径
    private String component;
    // 是否为外链 0 是 1 否
    private String isFrame;
    // 菜单类型 M目录 C菜单 F按钮
    private String menuType;
    // 菜单状态 0 显示 1 隐藏
    private String visible;
    // 菜单状态 0 正常 1 停用
    private String status;
    // 权限标识
    private String perms;
    // 菜单图标
    private String icon;
    // 创建者
    private String createBy;
    // 创建时间
    private String createTime;
    // 更新者
    private String updateBy;
    // 更新时间
    private String updateTime;
    // 备注
    private String remark;
    // 删除标志 0 未删除 1 删除
    private String delFlag;
}
