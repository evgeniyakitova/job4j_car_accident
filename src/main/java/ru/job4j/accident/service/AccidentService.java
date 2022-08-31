package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;

    public AccidentService(AccidentRepository accidentRepository,
                           AccidentTypeRepository accidentTypeRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    public void save(Accident accident) {
        accidentRepository.save(accident);
    }

    public Optional<Accident> findById(int id) {
        return accidentRepository.findById(id);
    }

    public void update(Accident accident) {
        accidentRepository.update(accident);
    }

    public List<AccidentType> findAllAccidentTypes() {
        return accidentTypeRepository.findAll();
    }
}
