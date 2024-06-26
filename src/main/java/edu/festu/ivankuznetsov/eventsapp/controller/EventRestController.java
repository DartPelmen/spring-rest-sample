package edu.festu.ivankuznetsov.eventsapp.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.festu.ivankuznetsov.eventsapp.model.Event;
import edu.festu.ivankuznetsov.eventsapp.model.User;
import edu.festu.ivankuznetsov.eventsapp.service.EventService;





@RestController
public class EventRestController {

    private final EventService eventService;
    public EventRestController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/rest/")
    public List<Event> get(){
        return eventService.getEvents();
    }
    @GetMapping("/rest/getByUser")
    public List<Event> getByUser(@RequestBody User user){
        return eventService.getByUser(user);
    }
    
    @PostMapping("/rest/addEvent")
    public Event addEvent(@RequestBody Event event){
        eventService.addEvent(event);
        return event;
    }
    @DeleteMapping("/rest/deleteEvent")
    public void deleteEvent(UUID eventId){
        eventService.deleteById(eventId);
    }
    @PutMapping("/rest/updateEvent")
    public Event updateEvent(@RequestBody Event event){
        eventService.updateEvent(event);
        return event;
    }
}
