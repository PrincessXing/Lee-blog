package com.lychee.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {

    private Long id;
    // 链接名称
    private String name;
    // 链接图标
    private String logo;
    // 链接描述
    private String description;
    // 链接地址
    private String address;

}
