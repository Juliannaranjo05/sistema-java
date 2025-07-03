package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.user;

public interface Iuser extends JpaRepository<user, Integer> {
    
    Optional<user> findByUsername(String username);
    Optional<user> findByEmail(String email);
    List<user> findAllByEnabled(boolean enabled);
}