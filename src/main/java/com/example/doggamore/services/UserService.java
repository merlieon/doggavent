package com.example.doggamore.services;

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


}
