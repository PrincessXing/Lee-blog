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
@TableName("comment")
public class Comment {
    @TableId
    private Long id;
    // 评论类型 0代表文章评论 1代表友链评论
    private String type;
    // 文章id
    private Long articleId;
    // 根评论id 根评论为-1(默认值为-1)
    private String rootId;
    // 评论内容
    private String content;
    // 回复给谁的 用户id 根评论为-1
    private Long toCommentUserId;
    // 回复哪个评论的 评论id
    private Long toCommentId;
    // 创建者
    private Long createBy;
    // 创建时间
    private Date createTime;
    // 更新者
    private Long updateBy;
    // 更新时间
    private Date updateTime;
    // 删除标志 0 未删除 1 删除
    private int delFlag;

}
