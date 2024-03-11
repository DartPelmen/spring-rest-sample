package edu.festu.ivankuznetsov.eventsapp.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.festu.ivankuznetsov.eventsapp.model.User;
import edu.festu.ivankuznetsov.eventsapp.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(String email, String password) {
        return userService.create(email, password);
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
    
}
