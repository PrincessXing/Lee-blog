package com.lychee.controller;

import com.lychee.domain.ResponseResult;
import com.lychee.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    public ResponseResult<?> uploadTmg(MultipartFile img) {
        return uploadService.uploadImg(img);
    }

}
