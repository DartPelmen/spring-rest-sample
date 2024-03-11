package edu.festu.ivankuznetsov.eventsapp.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events",
       schema = "events",
       catalog = "events_database")
public class Event {
    @Id
    @Column(name = "idEvent")
    UUID id;
    @Column(name = "startDate", nullable = false)
    LocalDateTime startDate;
    @Column(name = "endDate", nullable = false)
    LocalDateTime endDate;
    @Column(name = "eventName", nullable = false)
    String name;
    @Column(name = "eventDescription", nullable = true)
    String description;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        schema = "events",
        name = "events_users",
        joinColumns = @JoinColumn(name = "eventId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    Set<UserData> users;

    public Event() {
        id = UUID.randomUUID();
    }

    public Event(LocalDateTime startDate,
                 LocalDateTime endDate,
                 String name,
                 String description) {
        this.id = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.description = description;
    }
    public boolean isSameId(Event event){
        return this.getId().equals(event.getId());
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEventDuration(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<UserData> getUsers() {
        return users;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }

}
