package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Kindergarten {
    protected List<Child> children;

    public Kindergarten(List<Child> children) {
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        if (child.getDayOfBirth().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("!!! Incorrect birthday !!!");
        }
        if (child.getDayOfBirth().isBefore(
                LocalDateTime.of(2015, Month.JANUARY, 1, 0, 0)
        )) {
            throw new IllegalArgumentException("!!! This is already a schoolboy !!!");
        }
        children.add(child);
    }
}
