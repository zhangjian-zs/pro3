package com.mynb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mynb.dao")
public class Pro3Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro3Application.class, args);
    }

}
