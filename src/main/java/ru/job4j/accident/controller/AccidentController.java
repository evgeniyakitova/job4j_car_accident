package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

import java.util.Optional;

@Controller
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String getCreateForm() {
        return "accident/create";
    }

    @PostMapping("/create")
    public String createAccident(Accident accident) {
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable int id, Model model) {
        Optional<Accident> accidentFromDB = accidentService.findById(id);
        if (accidentFromDB.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("accident", accidentFromDB.get());
        return "accident/update";
    }

    @PostMapping("/update")
    public String updateAccident(Accident accident) {
        accidentService.update(accident);
        return "redirect:/";
    }
}
