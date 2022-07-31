package com.ecom.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.models.User;
import com.ecom.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUser(final int id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User saveUser(User user){
        User userSaved;
        userSaved = userRepository.save(user);

        return userSaved;
    }
}
