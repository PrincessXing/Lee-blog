package com.lychee.job;

import com.lychee.domain.entity.Article;
import com.lychee.service.ArticleService;
import com.lychee.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateViewCountJob {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ArticleService articleService;
    //定时任务(每5秒执行一次) 同步redis中的浏览量到数据库中
    @Scheduled(cron = "0/5 * * * * ?")
    public void updateViewCount() {
        //获取redis中的浏览量
        Map<String, Object> viewCountMap = redisCache.getCacheMap("article:viewCount");
        List<Article> articleList = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), (Long) entry.getValue()))
                        .collect(Collectors.toList());
        //更新到数据库中
        articleService.updateBatchById(articleList);
    }
}
