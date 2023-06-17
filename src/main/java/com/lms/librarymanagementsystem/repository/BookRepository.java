package com.lms.librarymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lms.librarymanagementsystem.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{
    
    public List<Book> findByTitleLikeIgnoreCase(String title);
    
}
