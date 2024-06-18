package com.example.DebugDen.services;

import com.example.DebugDen.entities.Auth;
import com.example.DebugDen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Auth> getAllUsers() {
        return (List<Auth>) userRepository.findAll();
    }

    public Auth updateProfile(String id, Auth user) {
        Optional<Auth> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
        	Auth updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setAbout(user.getAbout());
            updatedUser.setTags(user.getTags());
            return userRepository.save(updatedUser);
        } else {
        	
            return null;
        }
    }
}
