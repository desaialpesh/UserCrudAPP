package com.example.usercrudapp.controller;

import com.example.usercrudapp.model.User;
import com.example.usercrudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String userList(Model model) {
        model.addAttribute("userData", userService.userList());
        return "userList";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userEntry";
    }

    @GetMapping("/edit/{id}")
    public String addUser(@PathVariable("id") int id, Model model) {
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "userEntry";
    }

    @GetMapping("/delete/{id}")
    public String addUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUpdateUser(user);
        return "redirect:/";
    }

}
