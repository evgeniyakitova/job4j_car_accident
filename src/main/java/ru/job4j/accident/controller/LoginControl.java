package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControl {

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String message = null;
        if (error != null) {
            message = "Username or Password is incorrect!";
        }
        if (logout != null) {
            message = "You have been successfully logged out!";
        }
        model.addAttribute("message", message);
        return "login";
    }
}
