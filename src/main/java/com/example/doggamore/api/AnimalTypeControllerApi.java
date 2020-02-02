package com.example.doggamore.api;

import com.example.doggamore.models.AnimalType;
import com.example.doggamore.services.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalTypeControllerApi {

    @Autowired
    AnimalTypeService animalTypeService;

    //Returning all AnimalTypes to XML format
    @GetMapping(value = "/api/xml/animaltypes", produces = MediaType.APPLICATION_XML_VALUE)
    public List<AnimalType> getAllAnimalTypesXml(){
        return animalTypeService.getAllAnimalTypes();
    }

    //Returning one AnimalType by id to XML format
    @GetMapping(value = "/api/xml/AnimalType/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<AnimalType> getAnimalTypeByIdXml(@PathVariable int id){
        AnimalType animalType = animalTypeService.getAnimalById(id);
        if (animalType == null){
            return new ResponseEntity<AnimalType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AnimalType>(animalType, HttpStatus.OK);
    }

    //Returning all AnimalType to JSON format
    @GetMapping(value = "/api/json/animaltypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalType> getAllAnimalTypesJson(){
        return animalTypeService.getAllAnimalTypes();
    }

    //Returning one AnimalType by id to JSON format
    @GetMapping(value = "/api/json/animaltypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnimalType> getAnimalTypeByIdJson(@PathVariable int id){
        AnimalType animalType = animalTypeService.getAnimalById(id);
        if  (animalType== null){
            return new ResponseEntity<AnimalType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AnimalType>(animalType, HttpStatus.OK);
    }

}
