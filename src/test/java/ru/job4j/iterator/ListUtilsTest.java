package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 3));
        ListUtils.addAfter(input, 0, 1);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 3, 2);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, integer -> integer % 2 == 0);
        assertThat(input, is(Arrays.asList(1, 3)));
    }

    @Test
    public void whenRemoveIfButNothingIsDeleted() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, integer -> integer > 5);
        assertThat(input, is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.replaceIf(input, integer -> integer % 2 == 0, 0);
        assertThat(input, is(Arrays.asList(1, 0, 3, 0)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> second = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList()));
    }

    @Test
    public void whenRemoveAllFirstEmpty() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> second = new ArrayList<>(Arrays.asList());
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveAllSecondEmpty() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> second = new ArrayList<>(Arrays.asList());
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveAllButBothEmpty() {
        List<Integer> first = new ArrayList<>(Arrays.asList());
        List<Integer> second = new ArrayList<>(Arrays.asList());
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList()));
    }

    @Test
    public void whenRemoveAllOnlyLast() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> second = new ArrayList<>(Arrays.asList(4));
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenRemoveAllTwoOne() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> second = new ArrayList<>(Arrays.asList(1, 1));
        ListUtils.removeAll(first, second);
        assertThat(first, is(Arrays.asList(2, 3, 4)));
    }
}
