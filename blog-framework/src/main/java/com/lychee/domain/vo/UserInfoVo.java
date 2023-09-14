package com.lychee.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {

    private Long id;
    // 昵称
    private String nickname;
    // 头像
    private String avatar;
    // 性别
    private String sex;
    // 邮箱
    private String email;

}
