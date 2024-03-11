package edu.festu.ivankuznetsov.eventsapp.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles", schema = "auth", catalog = "events_database")
public class Role {
    @Id
    @Column
    private String roleName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        schema = "auth",
        name = "user_roles",
        joinColumns = @JoinColumn(name = "roleName"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    Set<User> users;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
