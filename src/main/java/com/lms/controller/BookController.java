package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lms.service.BookService;

@Controller
public class BookController {
    
    @Autowired
    public BookService bookService;

    @GetMapping("/view")
    public String viewAllBooks(Model model)
    {
        model.addAttribute("viewBooks", this.bookService.getAllBooks());
        return "view.html";
    }
}
