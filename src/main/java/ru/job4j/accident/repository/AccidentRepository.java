package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepository {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger accidentId = new AtomicInteger(0);

    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

    public void save(Accident accident) {
        accident.setId(accidentId.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public Optional<Accident> findById(int id) {
        return Optional.ofNullable(accidents.get(id));
    }

    public void update(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }
}
