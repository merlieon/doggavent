package com.example.doggamore.repositories;

import com.example.doggamore.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer> {
}
