package com.hbw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hbw.dao")
public class SxpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SxpsApplication.class, args);
    }

}
