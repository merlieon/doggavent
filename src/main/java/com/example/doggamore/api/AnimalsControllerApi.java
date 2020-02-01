package com.example.doggamore.api;

import com.example.doggamore.models.Animals;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalsControllerApi {

    @Autowired
    AnimalService animalService;

    @GetMapping("/api")
    public String getApi(){
        return "api";
    }


    @GetMapping("/api/animals")
    public List<Animals> getAllAnimals(){
        return animalService.getAnimals();
    }

    @GetMapping("/api/animals/{id}")
    public Animals getAnimalById(@PathVariable int id){
        return animalService.getAnimalById(id);
    }

}
