package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    @Test
    public void whenOneMax() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(100, 0));
        list.add(new Item(20, 1));
        list.add(new Item(50, 2));
        list.add(new Item(10, 4));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().max(list, comparator), is(new Item(50, 2)));
    }

    @Test
    public void whenTwoMax() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(50, 2));
        list.add(new Item(20, 1));
        list.add(new Item(100, 1));
        list.add(new Item(10, 4));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().max(list, comparator), is(new Item(100, 1)));
    }

    @Test
    public void whenOnlyMax() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(25, 4));
        list.add(new Item(50, 2));
        list.add(new Item(100, 1));
        list.add(new Item(10, 10));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().max(list, comparator), is(new Item(10, 10)));
    }

    @Test
    public void whenOneMin() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(100, 0));
        list.add(new Item(20, 1));
        list.add(new Item(50, 2));
        list.add(new Item(10, 4));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().min(list, comparator), is(new Item(100, 0)));
    }

    @Test
    public void whenTwoMin() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(50, 0));
        list.add(new Item(20, 1));
        list.add(new Item(100, 1));
        list.add(new Item(10, 0));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().max(list, comparator), is(new Item(100, 1)));
    }

    @Test
    public void whenOnlyMin() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(25, 0));
        list.add(new Item(50, 0));
        list.add(new Item(100, 0));
        list.add(new Item(10, 0));
        Comparator<Item> comparator = new CompareItem();
        assertThat(new MaxMin().max(list, comparator), is(new Item(10, 0)));
    }
}
