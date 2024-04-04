package edu.festu.ivankuznetsov.eventsapp.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.festu.ivankuznetsov.eventsapp.service.EventService;

@Controller
public class EventController {
    
    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String get(Model model){
        model.addAttribute("events",
            eventService.getEvents());
        return "events";
    }

    @GetMapping("/byId")
    public String getByUser(@RequestParam(required = true) UUID id, Model model){
        var maybeEvent = eventService.findEventById(id);
        model.addAttribute("maybeEvent", maybeEvent);

        return "event";
    }
    
}
