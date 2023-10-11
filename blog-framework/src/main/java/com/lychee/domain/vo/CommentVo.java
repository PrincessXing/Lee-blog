package com.lychee.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Long id;
    // 文章id
    private Long articleId;
    // 根评论id 根评论为-1(默认值为-1)
    private String rootId;
    // 评论内容
    private String content;
    // 回复给谁的 用户id 根评论为-1
    private Long toCommentUserId;
    // 回复给谁的 用户名
    private String toCommentUserName;
    // 回复哪个评论的 评论id
    private Long toCommentId;

    private String userName;
    // 评论分组
    private List<CommentVo> children;
    // 创建者
    private Long createBy;
    // 创建时间
    private Date createTime;
}
