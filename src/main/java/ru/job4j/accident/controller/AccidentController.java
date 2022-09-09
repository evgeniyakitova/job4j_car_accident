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

    @PostMapping("/save")
    public String createAccident(Accident accident) {
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        return "accident/update";
    }
}
