package com.lms.librarymanagementsystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.lms.librarymanagementsystem.model.User;
import com.lms.librarymanagementsystem.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    public UserService userService;


    @GetMapping("/user/view")
    public String viewAllBooks( Model model)
    {
        
        model.addAttribute("viewUsers", this.userService.getAllUsers());
        return "users/view.html";
    }

    @GetMapping("/user/add")
    public String addUser(Model model)
    {
        model.addAttribute("newUser",new User());
         return "users/add.html";
    }

    @PostMapping("/user/add")
    public String addUserSubmit(@ModelAttribute User user)
    {
        this.userService.addUser(user);
        return "redirect:/users/view";
    }

    @GetMapping("/user/update")
    public String updateBook(@RequestParam Integer id, Model model)
    {
        User found=this.userService.getUserById(id);
        model.addAttribute("updatedBook", found);
        return "users/update.html";
    }

    @PostMapping("/users/update")
    public String updateUserSubmit(@ModelAttribute User user)
    {
        this.userService.updateUser(user);
        return "redirect:/users/view";
    }


    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id)
    {
        this.userService.deleteUser(id);
        return "redirect:/users/view";
    }
}
