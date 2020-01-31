package com.example.doggamore.services;

import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    private List<Animals> animals(){
        List<Animals> animalsList = (List<Animals>) animalRepository.findAll();
        return animalsList;
    }

    public List<Animals> getAnimals(){
        return animals();
    }

    Animals animal;
    public Animals getAnimal(String name){
        for (Animals a : animals()){
            if (a.getAnimal_name().toLowerCase().equals(name)){
                name = a.getAnimal_name();
                int id = a.getId();
                String description = a.getAnimal_description();
                animal = new Animals(id, name, description);
            }
        }
        return animal;
    }
}
