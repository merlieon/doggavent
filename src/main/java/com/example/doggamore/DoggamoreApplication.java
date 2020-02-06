package com.example.doggamore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class DoggamoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoggamoreApplication.class, args);
    }

}
