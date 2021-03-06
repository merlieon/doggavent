package com.example.doggamore.services;

import com.example.doggamore.models.Animal;
import com.example.doggamore.models.Event;
import com.example.doggamore.repositories.AnimalRepository;
import com.example.doggamore.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    // Retruning animal list
    private List<Event> getEventList(){
        List<Event> eventList = (List<Event>) eventRepository.findAll();
        return eventList;
    }

    // making list public
    public List<Event> getAllEvents(){
        return getEventList();
    }

    public Event getEventById(int id){
        Predicate<Event> byid = a -> a.getId().equals(id);
        return filterEvents(byid);
    }

    private Event filterEvents(Predicate<Event> strategy){
        return getAllEvents().stream().filter(strategy).findFirst().orElse(null);
    }

    public Event editEvent(Event updatedEvent, int id){
        return eventRepository.findAllById(id).map(e ->{
            e.setEventTitle(updatedEvent.getEventTitle());
            e.setEventContent(updatedEvent.getEventContent());
            e.setLastModifiedBy(updatedEvent.getLastModifiedBy());
            e.setLastModifiedDate(updatedEvent.getLastModifiedDate());
            return eventRepository.save(e);
        }).orElseGet(() -> {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        });
    }



    public Event addEvent(Event event){
        return eventRepository.save(event);
    }

    public void deleteEvent(int id){
        eventRepository.deleteById(id);
    }

}
