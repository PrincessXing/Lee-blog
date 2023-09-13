package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Link;

public interface LinkService extends IService<Link> {
    ResponseResult getAllLink();
}
