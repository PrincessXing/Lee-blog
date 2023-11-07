package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 角色表
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role {

    private Long id;
    // 角色名称
    private String roleName;
    // 角色权限字符串
    private String roleKey;
    // 显示顺序
    private Integer roleSort;
    // 角色状态 0 正常 1 停用
    private String status;
    // 删除标志 0 未删除 1 删除
    private String delFlag;
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

}
