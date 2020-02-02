package com.example.doggamore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnimalType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String animal_type;

    public AnimalType(){

    }

    public AnimalType(int id, String animal_type){
        this.id = id;
        this.animal_type = animal_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }
}
