package ru.ivmiit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ivmiit.models.Auto;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.AutosRepository;
import ru.ivmiit.repositories.UsersRepository;

import java.util.List;

@Controller
public class AutosController {
    @Autowired
    private AutosRepository autosRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/autos")
    public String getAutosPage(@ModelAttribute("model") ModelMap model) {
        List<Auto> autos = autosRepository.findAll();
        model.addAttribute("autos", autos);
        return "autos_page";
    }

    /*@PostMapping(value = "/autos")
    public String addUser(@ModelAttribute Auto auto) {
        autosRepository.save(auto);
        return "redirect:/autos";
    }*/

    @PostMapping(value = "/autos")
    public String addUser(@ModelAttribute Auto auto) {
        User owner = usersRepository.findOne(auto.getOwnerId());
        auto.setOwner(owner);
        autosRepository.save(auto);
        return "redirect:/autos";
    }

    @GetMapping("/autos/by_owner")
    public String getAutosByOwner(@RequestParam("owner") Long ownerId, @ModelAttribute("model") ModelMap model) {
        User owner = usersRepository.findOne(ownerId);
        List<Auto> autos = owner.getAutos();
        model.addAttribute("autos", autos);
        return "autos_page";
    }

    @GetMapping("/autos/by_color")
    public String getAutosByOwner(@RequestParam("color") String color, @ModelAttribute("model") ModelMap model) {
        List<Auto> autos = autosRepository.findAllByColor(color);
        model.addAttribute("autos", autos);
        return "autos_page";
    }


}
