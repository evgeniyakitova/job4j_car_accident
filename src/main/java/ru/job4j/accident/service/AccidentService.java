package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {

    private final AccidentMem mem;

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    public List<Accident> findAll() {
        return mem.findAll();
    }

    public void save(Accident accident) {
        mem.save(accident);
    }

    public Optional<Accident> findById(int id) {
        return mem.findById(id);
    }

    public void update(Accident accident) {
        mem.update(accident);
    }
}
