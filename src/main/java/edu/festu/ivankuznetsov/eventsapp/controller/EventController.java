package edu.festu.ivankuznetsov.eventsapp.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/")
    public List<Event> get(){
        return eventService.getEvents();
    }
    @GetMapping("/getByUser")
    public List<Event> getByUser(@RequestBody User user){
        return eventService.getByUser(user);
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event){
        eventService.addEvent(event);
        return event;
    }
    @DeleteMapping("/deleteEvent")
    public void deleteEvent(UUID eventId){
        eventService.deleteById(eventId);
    }
    @PutMapping("/updateEvent")
    public Event updateEvent(@RequestBody Event event){
        eventService.updateEvent(event);
        return event;
    }
}
