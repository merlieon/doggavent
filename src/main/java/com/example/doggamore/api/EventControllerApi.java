package com.example.doggamore.api;

import com.example.doggamore.models.Animal;
import com.example.doggamore.models.Event;
import com.example.doggamore.repositories.EventRepository;
import com.example.doggamore.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventControllerApi {

    @Autowired
    EventService eventService;

    @Autowired
    EventRepository eventRepository;
    //Returning Animals to XML format
    @GetMapping(value = "/xml/events", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Event> getAllEventsXml(){
        return eventService.getAllEvents();
    }

    //Returning Animal to XML format
    @GetMapping(value = "/xml/event/{id}",  produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Event> getEventByIdXml(@PathVariable int id){
        Event event = eventService.getEventById(id);
        if (event == null){
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    //Returning Animals to JSON format
    @GetMapping(value = "/json/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEventsJson(){
        return eventService.getAllEvents();
    }

    //Returning Animal to XML format
    @GetMapping(value = "/json/event/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEventByIdJson(@PathVariable int id){
        Event event = eventService.getEventById(id);
        if (event == null){
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @PostMapping(value = "event/add")
    public Event saveEvent(@RequestBody Event newEvent){
        return eventService.addEvent(newEvent);
    }

    @PutMapping(value = "event/{id}")
    public Event editEvent(@Valid @RequestBody Event updatedEvent,@PathVariable int id){
        return eventService.editEvent(updatedEvent, id);
    }

    @DeleteMapping(value = "event/{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }

}
