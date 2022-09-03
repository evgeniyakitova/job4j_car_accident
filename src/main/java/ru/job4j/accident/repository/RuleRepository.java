package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RuleRepository {
    private final HashMap<Integer, Rule> rules = new HashMap<>();

    public RuleRepository() {
        rules.put(1, Rule.of(1, "Статья 1"));
        rules.put(2, Rule.of(2, "Статья 2"));
        rules.put(3, Rule.of(3, "Статья 3"));
    }

    public List<Rule> findAll() {
        return new ArrayList<>(rules.values());
    }
}
