package com.s36.apirest.backend.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s36.apirest.backend.Interface.IUserService;
import com.s36.apirest.backend.Repositories.UserRepository;
import com.s36.apirest.backend.models.User;

@Service
@Transactional
public class LoginService implements IUserService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String Login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password)) {

            return GenerateToken(user.getId().toString(), user.getEmail());
        }
        return "Hola";
    }

    private String GenerateToken(String userId, String email) {
        JwtService jwtService = new JwtService();
        return jwtService.generateToken(userId, email);
    }

}
