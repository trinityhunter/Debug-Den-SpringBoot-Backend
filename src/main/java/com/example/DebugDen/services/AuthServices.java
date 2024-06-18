package com.example.DebugDen.services;

import com.example.DebugDen.entities.Auth;
import com.example.DebugDen.payload.LoginResponse;
import com.example.DebugDen.repository.AuthRepository;
import com.example.DebugDen.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServices {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public LoginResponse signup(String name, String email, String password) throws Exception {
        if (authRepository.findByEmail(email).isPresent()) {
            throw new Exception("Sorry, a user with this email already exists");
        }

        String hashedPassword = passwordEncoder.encode(password);

        Auth newUser = new Auth();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);
        newUser.setJoinedOn(new Date());

        authRepository.save(newUser);

        String token = tokenProvider.generateToken(email, newUser.getEmail());

        return new LoginResponse(newUser, token);
    }

    public LoginResponse login(String email, String password) throws Exception {
        Auth existingUser = authRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Please login with correct credentials"));

        if (!passwordEncoder.matches(password, existingUser.getPassword())) {
            throw new Exception("Please login with correct credentials");
        }

        String token = tokenProvider.generateToken(email, existingUser.getEmail());

        return new LoginResponse(existingUser, token);
    }
}
