package com.lychee.service;

import com.lychee.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult<?> uploadImg(MultipartFile img);

}
