package com.lychee.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.entity.Comment;
import com.lychee.mapper.CommentMapper;
import com.lychee.service.CommentService;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
