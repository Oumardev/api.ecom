package com.ecom.api.controllers;

import java.util.HashMap;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.api.errors.ApiRequestException;
import com.ecom.api.models.User;
import com.ecom.api.models.UserAuth;
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

    @DeleteMapping("/del/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PostMapping("/register")
    public User savedUser(@Valid @RequestBody User user){

        User saved = userService.saveUser(user);

        return saved;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserAuth userAuth){

        User userFind = userService.searchUserByLogin(userAuth.getLogin())
        .orElseThrow(()->new ApiRequestException("Mot de passe ou login invalide"));

        boolean isLogin = userService.compareHashPassword(userAuth.getPassword(), userFind.getPassword());

        if (isLogin) {
            return ResponseEntity.ok(userFind);
        } else {
            HashMap<String,String> map = new HashMap<>();

            map.put("message", "Mot de passe ou login invalide");
            map.put("httpStatus", "BAD_REQUEST");
            
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }
        

    }
}
