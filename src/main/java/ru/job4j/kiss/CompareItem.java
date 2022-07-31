package ru.job4j.kiss;

import java.util.Comparator;

public class CompareItem implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return ((o1.getPrice() * o1.getCount()) - (o2.getPrice() * o2.getCount()));
    }
}
