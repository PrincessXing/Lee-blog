package com.lychee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lychee.mapper")
public class BlogFrameworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogFrameworkApplication.class,args);
    }
}