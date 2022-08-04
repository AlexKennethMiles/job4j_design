package ru.job4j.ood.lsp;

import java.util.List;

public class SomeKindergarten extends Kindergarten {
    public SomeKindergarten(List<Child> children) {
        super(children);
    }

    /**
     * В переопределённом методе отсутствует валидация входных данных
     * Это нарушает принцип LSP
     * Этот класс нельзя использовать как замену родительскому
     **/
    @Override
    public void addChild(Child child) {
        children.add(child);
    }
}
