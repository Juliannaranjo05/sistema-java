package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.permission_roles;

public interface Ipermission_role extends JpaRepository<permission_roles, Integer> {
    
}
