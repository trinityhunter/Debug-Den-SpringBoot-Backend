package com.example.DebugDen.repository;

import com.example.DebugDen.entities.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, String> {
    Optional<Auth> findByEmail(String email);
}