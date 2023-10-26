package com.lychee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.lychee.mapper")
@EnableScheduling
public class BlogFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogFrontApplication.class,args);
    }
}
