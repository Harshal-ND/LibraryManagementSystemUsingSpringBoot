package com.lms.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.model.Author;
import com.lms.librarymanagementsystem.repository.AuthorRepository;

@Service
public class AuthorService {
    
    @Autowired
    public AuthorRepository authorRepository;

     public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).get();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Integer id, Author author) {
        Author existingAuthor = authorRepository.findById(id).get();
        existingAuthor.setName(author.getName());
        // Update other fields as needed

        return authorRepository.save(existingAuthor);
    }

     public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }
}
