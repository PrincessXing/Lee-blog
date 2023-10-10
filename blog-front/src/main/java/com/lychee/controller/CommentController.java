package com.lychee.controller;

import com.lychee.domain.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @GetMapping("/commentList")
    public ResponseResult getAllComment() {
        return null;
    }
}
