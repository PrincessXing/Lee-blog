package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Comment;

public interface CommentService extends IService<Comment> {
    // 查询评论列表
    ResponseResult<?> commentList(Long articleId, Integer pageNum, Integer pageSize);
}
