package com.s36.apirest.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.s36.apirest.backend.Repositories.UserRepository;
import com.s36.apirest.backend.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Login")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    @PostMapping
    public User postMethodName(@RequestBody User entity) {
        if(entity.getEmail() == null || entity.getPassword() == null) {
            return null;
        }
        else {
            userRepository.save(entity);
        }
        
        return entity;
    }
    
}
