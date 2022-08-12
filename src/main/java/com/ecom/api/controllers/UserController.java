package com.ecom.api.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.api.errors.ApiRequestException;
import com.ecom.api.models.User;
import com.ecom.api.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") final int id){
        User savedUser = userService.getUser(id)
        .orElseThrow(()->new ApiRequestException("Cet utilisateur n'existe pas"));

        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user")
    public Iterable<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PostMapping("/register")
    public User savedUser(@Valid @RequestBody User user){

        User saved = userService.saveUser(user);

        return saved;
    }
}
