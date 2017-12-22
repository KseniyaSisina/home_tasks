package ru.ivmiit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/users")
    public String getMainAdminPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "admin";
    }

    @GetMapping("/password/temp/{user-id}")
    public String getNewPasswordOfUserPage(@ModelAttribute("model") ModelMap model,
                                           @PathVariable("user-id") Long userId) {
        service.createTempPassword(userId);
        return "temp_password_page";
    }
}