package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
