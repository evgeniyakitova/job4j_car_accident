package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import java.util.List;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

    public AccidentService(
            AccidentRepository accidentRepository,
            AccidentTypeRepository accidentTypeRepository,
            RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;
    }

    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    public void save(Accident accident) {
        accidentRepository.save(accident);
    }

    public Accident findById(int id) {
        return accidentRepository
                .findById(id)
                .orElseThrow();
    }

    public void update(Accident accident) {
        accidentRepository.update(accident);
    }

    public List<AccidentType> findAllAccidentTypes() {
        return accidentTypeRepository.findAll();
    }

    public List<Rule> findAllRules() {
        return ruleRepository.findAll();
    }
}
