package com.example.doggamore.repositories;

import com.example.doggamore.models.AnimalType;
import org.springframework.data.repository.CrudRepository;

public interface AnimalTypeRepository extends CrudRepository<AnimalType, Integer> {
}
