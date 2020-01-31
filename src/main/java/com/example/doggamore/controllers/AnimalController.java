package com.example.doggamore.controllers;

import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalController {
    @Autowired
    AnimalService  animalService;

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
