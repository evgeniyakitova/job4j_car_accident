package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.User;
import ru.job4j.accident.service.UserService;

@Controller
public class RegControl {
    private final UserService userService;

    public RegControl(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/registration")
    public String regSave(@ModelAttribute User user, Model model) {
        if (userService.save(user)) {
            return "redirect:/login";
        }
        model.addAttribute("message", "A user with this username already exists");
        return "registration";
    }

    @GetMapping("/registration")
    public String regPage() {
        return "registration";
    }
}
