package com.example.doggamore.repositories;

import com.example.doggamore.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
