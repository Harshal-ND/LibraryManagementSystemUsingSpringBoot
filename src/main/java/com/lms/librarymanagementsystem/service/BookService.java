package com.lms.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.model.Book;
import com.lms.librarymanagementsystem.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        return this.bookRepository.findAll();
    }

    public List<Book> searchBooks(String searchQuery)
    {
        return this.bookRepository.findByTitleLikeIgnoreCase(searchQuery);
    }

    public Book getBookById (Integer id){

        return this.bookRepository.findById(id).get();
    }

    public Book addBook(Book book)
    {
       return this.bookRepository.save(book);
    }

    public Book updateBook(Book book)
    {
        return this.bookRepository.save(book);
    }

    public void deleteBook(Integer id)
    {
         this.bookRepository.deleteById(id);
    }

}
