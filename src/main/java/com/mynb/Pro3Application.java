package com.mynb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.mynb.dao")
@EnableCaching
public class Pro3Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro3Application.class, args);
    }

}
