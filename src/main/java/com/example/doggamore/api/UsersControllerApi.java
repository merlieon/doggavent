package com.example.doggamore.api;

import com.example.doggamore.models.Users;
import com.example.doggamore.models.Users;
import com.example.doggamore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Creating Rest Controller for Users
@RestController
public class UsersControllerApi {

    //Binding to UserService
    @Autowired
    UserService userService;

//Returning all Users to XML format
    @GetMapping(value = "/api/xml/users", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Users> getAllUsersXml(){
        return userService.getAllUsers();
    }

    //Returning one User by id to XML format
    @GetMapping(value = "/api/xml/users/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Users> getUserByIdXml(@PathVariable int id){
        Users Users = userService.getUserById(id);
        if (Users == null){
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(Users, HttpStatus.OK);
    }

    //Returning all Users to JSON format
    @GetMapping(value = "/api/json/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllUsersJson(){
        return userService.getAllUsers();
    }

    //Returning one User by id to JSON format
    @GetMapping(value = "/api/json/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> getUserByIdJson(@PathVariable int id){
        Users Users = userService.getUserById(id);
        if (Users == null){
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(Users, HttpStatus.OK);
    }
}
