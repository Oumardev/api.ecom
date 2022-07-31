package com.ecom.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.models.User;
import com.ecom.api.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") final int id){
        return userService.getUser(id);
    }

    @GetMapping("/user")
    public Iterable<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PostMapping("/user")
    public User savedUser(@RequestBody User user){
   
        User saved = userService.saveUser(user);

        return saved;
    }
}
