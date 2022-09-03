package ru.job4j.accident.editors;

import ru.job4j.accident.model.Rule;

import java.beans.PropertyEditorSupport;

public class RulePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) {
        Rule rule = new Rule();
        rule.setId(Integer.parseInt(id));
        setValue(rule);
    }

    @Override
    public String getAsText() {
        Rule rule = (Rule) getValue();
        return String.valueOf(rule.getId());
    }
}
