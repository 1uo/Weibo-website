package com.luo.springboot;

import com.luo.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebCrudApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebCrudApplication.class, args);

    }

}
