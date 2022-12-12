package com.example.springproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.springproject.dao")
public class SpringprojectApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringprojectApplication.class, args);
  }

}
