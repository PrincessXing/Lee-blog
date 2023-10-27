package com.lychee.controller;

import com.lychee.constans.SystemConstants;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.dto.AddCommentDto;
import com.lychee.domain.entity.Comment;
import com.lychee.service.CommentService;
import com.lychee.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api(tags = "评论模块",description = "评论模块相关接口")//swagger分类标题注解
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/commentList")
    public ResponseResult<?> commentList(Long articleId, Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId, pageNum, pageSize);
    }
    @PostMapping
    //使用dto接收参数 以后如果有参数校验，可以在dto中添加校验注解 更加灵活
    public ResponseResult<?> addComment(@RequestBody AddCommentDto addCommentDto) {
        Comment comment = BeanCopyUtils.copy(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }

    @GetMapping("/linkCommentList")
    @ApiOperation(value = "友链评论列表",notes = "获取一页友链评论")//接口描述配置
    //接口参数配置
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",required = true)
    })
    public ResponseResult<?> linkCommentList(Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.LINK_COMMENT,null, pageNum, pageSize);
    }

}
