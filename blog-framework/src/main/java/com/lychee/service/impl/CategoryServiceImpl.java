package com.lychee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.constans.SystemConstants;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Article;
import com.lychee.domain.entity.Category;
import com.lychee.domain.vo.CategoryVo;
import com.lychee.mapper.CategoryMapper;
import com.lychee.service.ArticleService;
import com.lychee.service.CategoryService;
import com.lychee.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;
    @Override
    public ResponseResult<?> getCategoryList() {
        // 查询文章表 状态已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_PUBLISH);
        List<Article> articleList = articleService.list(articleWrapper);
        // 获取文章的分类id并去重
        Set<Long> categoryIds = articleList.stream().map(Article::getCategoryId)
                .collect(Collectors.toSet());
        // 根据分类id查询分类表 状态正常的分类
        List<Category> categories = listByIds(categoryIds).stream().filter(category -> category.getStatus().equals(SystemConstants.CATEGORY_STATUS_NORMAL))
                .collect(Collectors.toList());
        // 封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyMultiple(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}
