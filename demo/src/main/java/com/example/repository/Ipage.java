package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.pages;

public interface Ipage extends JpaRepository<pages, Integer> {
    
}
