package com.example.doggamore.api;

import com.example.doggamore.models.Animals;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalsControllerApi {

    @Autowired
    AnimalService animalService;

    @GetMapping(value = "/api/animals", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Animals> getAllAnimals(){
        return animalService.getAnimals();
    }

    @GetMapping("/api/animals/{id}")
    public ResponseEntity<Animals> getAnimalById(@PathVariable int id){
        Animals animals = animalService.getAnimalById(id);
        if (animals == null){
            return new ResponseEntity<Animals>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animals>(animals, HttpStatus.OK);
    }

}
