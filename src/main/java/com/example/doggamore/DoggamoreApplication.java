package com.example.doggamore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DoggamoreApplication {


    @RequestMapping("/db")

    public static void main(String[] args) {
        SpringApplication.run(DoggamoreApplication.class, args);
    }

}
