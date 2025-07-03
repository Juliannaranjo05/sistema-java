package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.recoveryRequest;

public interface  Irecovery_request extends JpaRepository<recoveryRequest, Integer> {
    
}
