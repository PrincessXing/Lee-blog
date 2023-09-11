package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Category;

public interface CategoryService extends IService<Category> {

    ResponseResult<?> getCategoryList();

}
