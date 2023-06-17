package com.lms.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
