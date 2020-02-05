package com.example.doggamore.services;

import com.example.doggamore.models.Users;
import com.example.doggamore.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    private List<Users> users(){
        List<Users> usersList = (List<Users>) usersRepository.findAll();
        return usersList;
    }

    public List<Users> getAllUsers(){
        return users();
    }

    public Users getUserById(int id){
        Predicate<Users> byid = u -> u.getId().equals(id);
        return filterUsers(byid);
    }

    private Users filterUsers(Predicate<Users> strategy){
        return getAllUsers().stream().filter(strategy).findFirst().orElse(null);
    }
}
