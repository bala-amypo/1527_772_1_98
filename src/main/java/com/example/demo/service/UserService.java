package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;
    public User registerUser(User user){
        return userRepository.save(user);
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
}
