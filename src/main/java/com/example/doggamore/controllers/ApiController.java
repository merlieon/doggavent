package com.example.doggamore.controllers;

import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/api")
    public String getApi(){
        return "api";
    }


}
