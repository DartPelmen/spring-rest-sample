package edu.festu.ivankuznetsov.eventsapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.festu.ivankuznetsov.eventsapp.model.Event;
import edu.festu.ivankuznetsov.eventsapp.model.User;
import edu.festu.ivankuznetsov.eventsapp.repository.EventsRepository;

@Service
public class EventService {
    private final EventsRepository eventsRepository;
    public EventService(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }

    public void addEvent(Event event){
        eventsRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventsRepository.findAll();
    }

    public Optional<Event> findEventById(UUID id) {
        return eventsRepository.findById(id);
    }

    public void updateEvent(Event event){
        eventsRepository.save(event);
    }

    public void deleteById(UUID id){
        eventsRepository.deleteById(id);
    }

    public List<Event> getByUser(User user) {
        return eventsRepository.findByUsersContaining(user);
    }
}
