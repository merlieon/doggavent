package com.example.doggamore.api;

import com.example.doggamore.models.Event;
import com.example.doggamore.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
