package com.example.doggamore.repositories;

import com.example.doggamore.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    Optional<Event> findAllById(int id);
}
