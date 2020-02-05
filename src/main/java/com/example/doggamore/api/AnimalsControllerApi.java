package com.example.doggamore.api;

import com.example.doggamore.models.Animal;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnimalsControllerApi {

    @Autowired
    AnimalService animalService;

    @Autowired
    AnimalRepository animalRepository;

    //Returning Animals to XML format
    @GetMapping(value = "/xml/animals", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Animal> getAllAnimalsXml(){
        return animalService.getAllAnimals();
    }

    //Returning one Animal by id to XML format
    @GetMapping(value = "/xml/animals/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Animal> getAnimalByIdXml(@PathVariable int id){
        Animal animals = animalService.getAnimalById(id);
        if (animals == null){
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animal>(animals, HttpStatus.OK);
    }

    //Returning Animals to JSON format
    @GetMapping(value = "/json/animals", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animal> getAllAnimalsJson(){
        return animalService.getAllAnimals();
    }

    //Returning one Animal by id to JSON format
    @GetMapping(value = "/json/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> getAnimalByIdJson(@PathVariable int id){
        Animal animals = animalService.getAnimalById(id);
        if (animals == null){
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animal>(animals, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Animal addAnimal(@Valid @RequestBody Animal newAnimal){
        return animalRepository.save(newAnimal);
    }

    @PutMapping("/animals{id}")
    public ResponseEntity<Animal> editAnimal(@Valid @RequestBody Animal animal, @PathVariable long id){
        Optional<Animal> animalOptional = animalRepository.findById(id);

        if (!animalOptional.isPresent())
            return ResponseEntity.notFound().build();

        animal.setId(id);

        animalRepository.save(animal);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable long id){
        animalRepository.deleteById(id);
    }


}
