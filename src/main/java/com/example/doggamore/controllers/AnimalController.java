package com.example.doggamore.controllers;

import com.example.doggamore.database.DBManager;
import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class AnimalController {
    @Autowired
    AnimalService  animalService;

    @Autowired
    AnimalRepository animalRepository;
   @GetMapping("/animals")
    public  Iterable<Animals> getAllAnimals(Model model){

        model.addAttribute("allAnimals", animalService.getAnimals());
        return animalService.getAnimals();
    }

    @GetMapping("/animals/{animal_name}")
    public String getAnimal(@PathVariable String animal_name,Model model){
        model.addAttribute("animal", animalService.getAnimal(animal_name));
        return "dog";
    }
}
