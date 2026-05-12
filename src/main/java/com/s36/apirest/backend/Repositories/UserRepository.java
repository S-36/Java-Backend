package com.s36.apirest.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s36.apirest.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    

}
