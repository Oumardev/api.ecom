package com.ecom.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.api.models.User;
import com.ecom.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    private int strength = 10;

    public Optional<User> getUser(final int id){
        return userRepository.findById(id);
    }

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User saveUser(User user){
        User userSaved;

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(this.strength);
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        userSaved = userRepository.save(user);

        return userSaved;
    }

    public User searchUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean compareHashPassword(String inPassword, String userPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(this.strength);
        
        return bCryptPasswordEncoder.matches(inPassword, userPassword);
    }

}
