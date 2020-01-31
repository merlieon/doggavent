package com.example.doggamore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String animal_name;
    private String animal_description;
    private Integer animal_type_id;

    public Animals(){

    }

    public Animals(int id, String animal_name, String animal_description){
        this.id = id;
        this.animal_name = animal_name;
        this.animal_description = animal_description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_description() {
        return animal_description;
    }

    public void setAnimal_description(String animal_description) {
        this.animal_description = animal_description;
    }

    public Integer getAnimal_type_id() {
        return animal_type_id;
    }

    public void setAnimal_type_id(Integer animal_type_id) {
        this.animal_type_id = animal_type_id;
    }
}
