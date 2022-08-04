package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Child> children = new ArrayList<>(List.of(new Child("Ivan", LocalDateTime.now())));
        SomeKindergarten sg = new SomeKindergarten(children);
        sg.addChild(new Child("Mihail",
                LocalDateTime.of(2010, Month.MAY, 15, 11, 45))
        );
        System.out.println(sg.getChildren());
    }
}
