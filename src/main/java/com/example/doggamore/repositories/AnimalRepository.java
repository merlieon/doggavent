package com.example.doggamore.repositories;

import com.example.doggamore.models.Animals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animals, Integer> {


}
