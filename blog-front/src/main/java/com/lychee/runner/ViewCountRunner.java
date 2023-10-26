package com.lychee.runner;

import com.lychee.domain.entity.Article;
import com.lychee.mapper.ArticleMapper;
import com.lychee.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// 初始化redis中的数据
@Component
public class ViewCountRunner implements CommandLineRunner {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        //查询博客信息 id、viewCount
        List<Article> articles = articleMapper.selectList(null);
        Map<String,Integer> viewCountMap = articles.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(), Article-> Article.getViewCount().intValue()));
        //存入redis中
        redisCache.setCacheMap("article:viewCount",viewCountMap);
    }
}
