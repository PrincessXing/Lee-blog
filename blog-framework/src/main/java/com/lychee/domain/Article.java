package com.lychee.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文章表(Article)表实体类
 *
 * @author makejava
 * @since 2023-07-19 22:28:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class Article {
    @TableId
    private Long id;
    //标题
    @TableField("title")
    private String title;
    //文章内容
    @TableField("content")
    private String content;
    //文章摘要
    @TableField("category_id")
    private String summary;
    //所属分类id
    @TableField("category_id")
    private Long categoryId;
    //缩略图
    @TableField("thumbnail")
    private String thumbnail;
    //是否置顶（0否，1是）
    @TableField("is_top")
    private String isTop;
    //状态（0已发布，1草稿）
    @TableField("status")
    private String status;
    //访问量
    @TableField("view_count")
    private Long viewCount;
    //是否允许评论 1是，0否
    @TableField("is_comment")
    private String isComment;
    //创建人
    @TableField("create_by")
    private Long createBy;
    //创建时间
    @TableField("create_time")
    private Date createTime;
    //修改人
    @TableField("update_by")
    private Long updateBy;
    //修改时间
    @TableField("update_time")
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    @TableField("del_flag")
    private Integer delFlag;

}

