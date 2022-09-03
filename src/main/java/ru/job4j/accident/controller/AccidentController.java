package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.editors.RulePropertyEditor;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import java.util.List;
import java.util.Optional;

@Controller
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @InitBinder("accident")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Rule.class, new RulePropertyEditor());
    }

    @ModelAttribute("types")
    public List<AccidentType> getTypes() {
        return accidentService.findAllAccidentTypes();
    }

    @ModelAttribute("rules")
    public List<Rule> getRules() {
        return accidentService.findAllRules();
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
