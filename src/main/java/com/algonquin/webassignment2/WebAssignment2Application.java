package com.algonquin.webassignment2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.algonquin.webassignment2.demos.repository.mapper")
public class WebAssignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(WebAssignment2Application.class, args);
    }

}
