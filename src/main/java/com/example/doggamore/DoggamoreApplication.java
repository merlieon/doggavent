package com.example.doggamore;

import com.example.doggamore.database.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DoggamoreApplication {


    @RequestMapping("/db")

    public static void main(String[] args) {
        SpringApplication.run(DoggamoreApplication.class, args);
    }

}
