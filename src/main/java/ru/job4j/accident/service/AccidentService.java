package ru.job4j.accident.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

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

    public List<AccidentType> findAllAccidentTypes() {
        return (List<AccidentType>) accidentTypeRepository.findAll();
    }

    public List<Rule> findAllRules() {
        return (List<Rule>) ruleRepository.findAll();
    }
}
