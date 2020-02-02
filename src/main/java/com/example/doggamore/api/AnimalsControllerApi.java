package com.example.doggamore.api;

import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalsControllerApi {

    @Autowired
    AnimalService animalService;

    @Autowired
    AnimalRepository animalRepository;

    //Returning Animals to XML format
    @GetMapping(value = "/api/xml/animals", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Animals> getAllAnimalsXml(){
        return animalService.getAllAnimals();
    }

    //Returning one Animal by id to XML format
    @GetMapping(value = "/api/xml/animals/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Animals> getAnimalByIdXml(@PathVariable int id){
        Animals animals = animalService.getAnimalById(id);
        if (animals == null){
            return new ResponseEntity<Animals>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animals>(animals, HttpStatus.OK);
    }

    //Returning Animals to JSON format
    @GetMapping(value = "/api/json/animals", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animals> getAllAnimalsJson(){
        return animalService.getAllAnimals();
    }

    //Returning one Animal by id to JSON format
    @GetMapping(value = "/api/json/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animals> getAnimalByIdJson(@PathVariable int id){
        Animals animals = animalService.getAnimalById(id);
        if (animals == null){
            return new ResponseEntity<Animals>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animals>(animals, HttpStatus.OK);
    }

    Map<Integer, Animals> anidata = new HashMap<Integer, Animals>();

    @PostMapping("/animals/add")
    public Animals addAnimal(@RequestBody  Animals newAnimal){
        anidata.put(newAnimal.getId(), newAnimal);
        return newAnimal;
    }
}
