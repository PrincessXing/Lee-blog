package com.lychee.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailVo {

    private Long id;
    // 文章标题
    private String title;
    // 文章摘要
    private String summary;
    // 文章内容
    private String content;
    // 分类id
    private Long categoryId;
    // 分类名称
    private String categoryName;
    // 缩略图
    private String thumbnail;
    // 访问量
    private Long viewCount;
    // 是否允许评论
    private String isComment;
    // 创建时间
    private String createTime;

}
