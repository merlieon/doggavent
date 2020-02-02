package com.example.doggamore.repositories;

import com.example.doggamore.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}
