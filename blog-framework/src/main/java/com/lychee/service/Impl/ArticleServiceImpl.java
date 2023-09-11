package com.lychee.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.constans.SystemConstants;
import com.lychee.domain.entity.Article;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.vo.HotArticleVo;
import com.lychee.mapper.ArticleMapper;
import com.lychee.service.ArticleService;
import com.lychee.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    // 热门文章列表
    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_PUBLISH);
        // 按照浏览量倒序
        wrapper.orderByDesc(Article::getViewCount);
        // 每页查询10条
        Page<Article> page = new Page<>(1, 10);
        List<Article> articles = page(page, wrapper).getRecords();
        // 转换成vo
        List<HotArticleVo> hotArticleVos = BeanCopyUtils.copyMultiple(articles, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);
    }



}
