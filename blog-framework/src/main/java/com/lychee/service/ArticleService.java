package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.entity.Article;
import com.lychee.domain.ResponseResult;

public interface ArticleService extends IService<Article> {


    ResponseResult hotArticleList();
}
