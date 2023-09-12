package com.lychee.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.constans.SystemConstants;
import com.lychee.domain.entity.Article;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.vo.ArticleListVo;
import com.lychee.domain.vo.HotArticleVo;
import com.lychee.domain.vo.PageVo;
import com.lychee.mapper.ArticleMapper;
import com.lychee.service.ArticleService;
import com.lychee.service.CategoryService;
import com.lychee.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private CategoryService categoryService;
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

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        // 查询条件
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        // 如果有categoryId，查询该分类id下的文章
        wrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // 状态为已发布的文章
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_PUBLISH);
        // 置顶的文章要显示在最前面
        wrapper.orderByDesc(Article::getIsTop);
        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, wrapper);
        List<Article> articles = page.getRecords();
        // 查询categoryName
        articles = articles.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyMultiple(articles, ArticleListVo.class);
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
