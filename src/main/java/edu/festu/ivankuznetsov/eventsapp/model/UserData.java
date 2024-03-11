package edu.festu.ivankuznetsov.eventsapp.model;

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
@Table(name = "user_data", schema = "events", catalog = "events_database")
public class UserData {
    @Id
    UUID idUser;
    private String firstName;
    private String lastName;
    @Column(nullable = true)
    private String patronymic;

    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        schema = "events",
        name = "events_users",
        joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "eventId")
    )
    Set<Event> events;
    

    public UserData() {
        idUser = UUID.randomUUID();
    }
    public UUID getIdUser() {
        return idUser;
    }
    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<Event> getEvents() {
        return events;
    }
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
