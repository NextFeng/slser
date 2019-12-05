package com.lcdz.slser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
@MapperScan("com.lcdz.slser.service.dao.*")
public class SlserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlserApplication.class, args);
    }

}
