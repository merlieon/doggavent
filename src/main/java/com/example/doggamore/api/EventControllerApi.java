package com.example.doggamore.api;

import com.example.doggamore.models.Event;
import com.example.doggamore.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventControllerApi {

    @Autowired
    EventService eventService;

    //Returning Animals to XML format
    @GetMapping(value = "/xml/events", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Event> getAllEventsXml(){
        return eventService.getAllEvents();
    }

    //Returning Animals to JSON format
    @GetMapping(value = "/json/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEventsJson(){
        return eventService.getAllEvents();
    }


    @PostMapping(value = "event/add")
    public Event saveEvent(@RequestBody Event newEvent){
        return eventService.addEvent(newEvent);
    }

}
