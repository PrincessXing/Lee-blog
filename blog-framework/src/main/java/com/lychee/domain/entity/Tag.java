package com.lychee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tag")
public class Tag {
    @TableId
    private Long id;
    // 标签名称
    private String name;
    // 创建人
    private Long createBy;
    // 创建时间
    private String createTime;
    // 修改人
    private Long updateBy;
    // 修改时间
    private String updateTime;
    // 删除标志 0未删除 -1删除
    private Integer delFlag;
    // 备注
    private String remark;
}
