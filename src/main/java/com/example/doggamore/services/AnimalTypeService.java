package com.example.doggamore.services;

import com.example.doggamore.models.AnimalType;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.repositories.AnimalTypeRepository;
import com.example.doggamore.repositories.AnimalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AnimalTypeService {

    @Autowired
    AnimalTypeRepository animalTypeRepository;

    // Returning all AnimalTypes to a list
    private List<AnimalType> animalType(){
        List<AnimalType> animalTypeList = (List<AnimalType>) animalTypeRepository.findAll();
        return animalTypeList;
    }

    // Making the list public
    public List<AnimalType> getAllAnimalTypes(){
        return animalType();
    }

    // returning animaltype by id
    public AnimalType getAnimalById(int id){
        Predicate<AnimalType> byid = at -> at.getId().equals(id);
        return filterAnimalType(byid);
    }

    private AnimalType filterAnimalType(Predicate<AnimalType> strategy){
        return getAllAnimalTypes().stream().filter(strategy).findFirst().orElse(null);
    }
}
