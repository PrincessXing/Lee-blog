package com.lychee.controller;

import com.lychee.domain.ResponseResult;
import com.lychee.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @PostMapping("/getAllLink")
    public ResponseResult getAllLink() {
        return linkService.getAllLink();
    }

}
