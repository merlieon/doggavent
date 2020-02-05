package com.example.doggamore.services;

import com.example.doggamore.models.Animal;
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
    private List<Animal> getAnimalsList(){
        List<Animal> animalsList = (List<Animal>) animalRepository.findAll();
        return animalsList;
    }

    // making list public
    public List<Animal> getAllAnimals(){
        return getAnimalsList();
    }

    // Getting animals to just get one animal
    Animal animal;
    public Animal getAnimal(String name){
        for (Animal a : getAnimalsList()){
            if (a.getAnimal_name().toLowerCase().equals(name)){
                name = a.getAnimal_name();
                Long id = a.getId();
                String description = a.getAnimal_description();
                animal = new Animal(id, name, description);
            }
        }
        return animal;
    }

    // Getting animals by id
    public Animal getAnimalById(int id){
        Predicate<Animal> byid = a -> a.getId().equals(id);
        return filterAnimals(byid);
    }

    private Animal filterAnimals(Predicate<Animal> strategy){
        return getAllAnimals().stream().filter(strategy).findFirst().orElse(null);
    }

    public Animal addAnimal(Animal newAnimal){
        return  animalRepository.save(newAnimal);
    }
}
