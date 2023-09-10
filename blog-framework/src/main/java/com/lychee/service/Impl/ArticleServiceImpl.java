package com.lychee.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.Article;
import com.lychee.mapper.ArticleMapper;
import com.lychee.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
