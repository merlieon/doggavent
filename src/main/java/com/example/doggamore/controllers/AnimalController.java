package com.example.doggamore.controllers;

import com.example.doggamore.models.Animal;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalController {
    @Autowired
    AnimalService  animalService;

    @Autowired
    AnimalRepository animalRepository;
   @GetMapping("/animals")
    public  Iterable<Animal> getAllAnimals(Model model){

        model.addAttribute("allAnimals", animalService.getAllAnimals());
        return animalService.getAllAnimals();
    }

    @GetMapping("/animals/{animal_name}")
    public String getAnimal(@PathVariable String animal_name,Model model){
        model.addAttribute("animal", animalService.getAnimal(animal_name));
        return "dog";
    }
}
