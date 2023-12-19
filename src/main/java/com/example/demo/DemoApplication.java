package com.example.demo;

import com.example.demo.bean.test.HandlerManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@MapperScan("com.example.demo.mapper.*")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        HandlerManager handlerManager = (HandlerManager) run.getBean("handlerManager");


    }

}
