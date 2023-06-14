package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Book;
import com.lms.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    public BookRepository bookRepository;

    public Iterable<Book> getAllBooks()
    {
        return this.bookRepository.findAll();
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
