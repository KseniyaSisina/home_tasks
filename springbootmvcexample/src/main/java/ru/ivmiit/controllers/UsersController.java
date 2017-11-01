package ru.ivmiit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users")
    public String getUsersPage(@ModelAttribute("model") ModelMap model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute User user) {
        usersRepository.save(user);
        return "redirect:/users";
    }

}
