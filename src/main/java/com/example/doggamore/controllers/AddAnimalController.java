package com.example.doggamore.controllers;

import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class AddAnimalController {

    AnimalRepository animalRepository;

    @PostMapping("/addanimal")
    public Animals addAnimals (@RequestBody String id, @RequestBody Map<String, String> body){
        String name = body.get("animal_name");

        return animalRepository.save(new Animals(1,"dog","this is a dog"));
    }

    @GetMapping("/addanimal")
    public String getAnimal(){
        return "addanimal";
    }

}
