package com.example.DebugDen.controller;

import com.example.DebugDen.entities.Auth;
import com.example.DebugDen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Auth>> getAllUsers() {
        List<Auth> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auth> updateProfile(@PathVariable("id") String id, @RequestBody Auth user) {
        Auth updatedProfile = userService.updateProfile(id, user);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
