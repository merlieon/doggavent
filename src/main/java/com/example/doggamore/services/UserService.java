package com.example.doggamore.services;

import com.example.doggamore.models.Event;
import com.example.doggamore.models.User;
import com.example.doggamore.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    // Retruning animal list
    private List<User> getUserList(){
        List<User> userList = (List<User>) usersRepository.findAll();
        return userList;
    }

    // making list public
    public List<User> getAllUsers(){
        return getUserList();
    }

    public User getUserById(int id){
        Predicate<User> byid = a -> a.getId().equals(id);
        return filterUsers(byid);
    }

    private User filterUsers(Predicate<User> strategy){
        return getAllUsers().stream().filter(strategy).findFirst().orElse(null);
    }

}
