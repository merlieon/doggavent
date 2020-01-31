package com.example.doggamore.repositories;

import com.example.doggamore.models.Animals;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animals, Integer> {
}
