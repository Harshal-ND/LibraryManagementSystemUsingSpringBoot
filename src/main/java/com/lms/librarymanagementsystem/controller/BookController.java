package com.lms.librarymanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.librarymanagementsystem.model.Book;
import com.lms.librarymanagementsystem.service.AuthorService;
import com.lms.librarymanagementsystem.service.BookService;
import com.lms.librarymanagementsystem.service.CategoryService;

@Controller
public class BookController {
    
    @Autowired
    public BookService bookService;

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public AuthorService authorService;
   

    @GetMapping("/view")
    public String viewAllBooks(@RequestParam(required = false) String search, Model model)
    {
        List <Book> books;
        if(search!=null  && !search.isEmpty())
        {
            books=this.bookService.searchBooks(search);
        }
        else{
            books=this.bookService.getAllBooks();
        }
        model.addAttribute("viewBooks", books);
        model.addAttribute("search", books);
        return "books/view.html";
    }

    @GetMapping("/add")
    public String addBook(Model model)
    {
        model.addAttribute("newBook", new Book());
        // model.addAttribute("categories", this.categoryService.viewAllCategory());
        // model.addAttribute("authors", this.authorService.getAllAuthors());
         return "books/add.html";
    }

    @PostMapping("/add")
    public String addBookSubmit(@ModelAttribute Book book)
    {
        this.bookService.addBook(book);
        return "redirect:/view";
    }

    @GetMapping("/update")
    public String updateBook(@RequestParam Integer id, Model model)
    {
        Book found=this.bookService.getBookById(id);
        model.addAttribute("updatedBook", found);
        return "books/update.html";
    }

    @PostMapping("/update")
    public String updateBookSubmit(@ModelAttribute Book book)
    {
        this.bookService.updateBook(book);
        return "redirect:/view";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id)
    {
        this.bookService.deleteBook(id);
        return "redirect:/view";
    }
}
