package com.example.doggamore.api;

import com.example.doggamore.models.Event;
import com.example.doggamore.models.User;
import com.example.doggamore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerApi {

    @Autowired
    UserService userService;

    //Returning Animals to XML format
    @GetMapping(value = "/xml/users", produces = MediaType.APPLICATION_XML_VALUE)
    public List<User> getAllUsersXml(){
        return userService.getAllUsers();
    }

    //Returning Animal to XML format
    @GetMapping(value = "/xml/user/{id}",  produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<User> getUserByIdXml(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //Returning Animals to JSON format
    @GetMapping(value = "/json/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsersJson(){
        return userService.getAllUsers();
    }

    //Returning Animal to JSON format
    @GetMapping(value = "/json/user/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByIdJson(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
