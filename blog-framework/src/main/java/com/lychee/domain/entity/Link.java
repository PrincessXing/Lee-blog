package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("link")
public class Link {
    @TableId
    private Long id;
    // 链接名称
    private String name;
    // 链接图标
    private String logo;
    // 链接描述
    private String description;
    // 链接地址
    private String address;
    // 状态
    private String status;
    // 创建人
    private Long createBy;
    // 创建时间
    private String createTime;
    // 更新人
    private Long updateBy;
    // 更新时间
    private String updateTime;
    // 是否删除
    private Integer del_flag;

}
