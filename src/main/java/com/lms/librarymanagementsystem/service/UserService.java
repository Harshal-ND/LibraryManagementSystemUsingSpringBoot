package com.lms.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.model.User;
import com.lms.librarymanagementsystem.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    public UserRepository userRepository;

     public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    
   public User updateUser(User user)
    {
        return this.userRepository.save(user);
    }

   
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
