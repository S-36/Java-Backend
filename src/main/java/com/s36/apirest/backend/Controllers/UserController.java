package com.s36.apirest.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.s36.apirest.backend.Interface.IUserService;
import com.s36.apirest.backend.Repositories.UserRepository;
import com.s36.apirest.backend.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    @PostMapping("/register")
    public User postMethodName(@RequestBody User entity) {
        if(entity.getEmail() == null || entity.getPassword() == null) {
            return null;
        }
        else {
            userRepository.save(entity);
        }
        
        return entity;
    }

    @PostMapping("/login")
    public String login(@RequestBody User entity) {
        if(entity.getEmail() == null || entity.getPassword() == null) {
            return null;
        }
        else {
            return userService.Login(entity.getEmail(), entity.getPassword());
        }
    }
    
}
