package edu.festu.ivankuznetsov.eventsapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.festu.ivankuznetsov.eventsapp.model.Event;
import edu.festu.ivankuznetsov.eventsapp.model.User;

@Repository
public interface EventsRepository extends JpaRepository<Event,UUID>{

    List<Event> findByUsersContaining(User user);
}
