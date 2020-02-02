package com.example.doggamore.services;

import com.example.doggamore.models.Animals;
import com.example.doggamore.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    // Retruning animal list
    private List<Animals> animals(){
        List<Animals> animalsList = (List<Animals>) animalRepository.findAll();
        return animalsList;
    }

    // making list public
    public List<Animals> getAllAnimals(){
        return animals();
    }

    // Getting animals to just get one animal
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

    // Getting animals by id
    public Animals getAnimalById(int id){
        Predicate<Animals> byid = a -> a.getId().equals(id);
        return filterAnimals(byid);
    }

    private Animals filterAnimals(Predicate<Animals> strategy){
        return getAllAnimals().stream().filter(strategy).findFirst().orElse(null);
    }

    public Animals addAnimal(Animals newAnimal){
        newAnimal.setId(23);
        newAnimal.setAnimal_name("cow");
        return  newAnimal;
    }
}
