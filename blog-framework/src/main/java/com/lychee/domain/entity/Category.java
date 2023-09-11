package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category {
    @TableId
    private Long id;
    // 分类名称
    private String name;
    // 父分类id
    private Long pid;
    // 分类描述
    private String description;
    // 状态 0正常 -1禁用
    private String status;
    // 创建人
    private Long createBy;
    // 创建时间
    private Date createTime;
    // 修改人
    private Long updateBy;
    // 修改时间
    private Date updateTime;
    // 删除标志 0未删除 -1删除
    private Integer delFlag;

}
