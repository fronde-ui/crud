package com.example.cruddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//(scanBasePackages="com.example.cruddemo.controller")
@SpringBootApplication
public class CruddemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

}

