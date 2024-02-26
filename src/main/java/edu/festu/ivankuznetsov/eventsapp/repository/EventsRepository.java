package edu.festu.ivankuznetsov.eventsapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.festu.ivankuznetsov.eventsapp.model.Event;

@Repository
public interface EventsRepository extends JpaRepository<Event,UUID>{
    
}
