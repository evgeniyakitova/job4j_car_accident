package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.putAll(Map.of(
                1, new Accident("first accident", "description", "Moscow"),
                2, new Accident("second accident", "description", "Novosibirsk"),
                3, new Accident("third accident", "description", "Samara")));
    }

    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }
}
