package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleMapTest {
    @Test
    public void testPutAndGet() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 2);
        assertThat(map.get(1), is(2));
    }

    @Test
    public void putDuplicate() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertThat(map.put(1, 2), is(true));
        assertThat(map.get(1), is(2));
        assertThat(map.put(1, 2), is(false));
    }

    @Test
    public void whenPutAndTryToRewrite() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertThat(map.put(1, 2), is(true));
        assertThat(map.get(1), is(2));
        assertThat(map.put(1, 3), is(false));
        assertThat(map.get(1), is(2));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertThat(map.get(1), nullValue());
    }

    @Test
    public void whenRemoveIsTrue() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertThat(map.get(1), is(1));
        assertThat(map.get(2), is(2));
        assertThat(map.get(3), is(3));
        assertThat(map.remove(3), is(true));
        assertThat(map.get(3), nullValue());
    }

    @Test
    public void whenRemoveIsFalse() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        assertThat(map.get(1), is(1));
        assertThat(map.get(2), is(2));
        assertThat(map.get(3), nullValue());
        assertThat(map.remove(3), is(false));
    }

    @Test
    public void whenValueIsNull() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, null);
        assertThat(map.get(1), nullValue());
        assertThat(map.remove(1), is(true));
        assertThat(map.get(1), nullValue());
    }

    @Test
    public void whenTheTableExtension() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertThat(map.put(1, 1), is(true));
        assertThat(map.put(2, 2), is(true));
        assertThat(map.put(3, 3), is(true));
        assertThat(map.put(4, 4), is(true));
        assertThat(map.put(5, 5), is(true));
        assertThat(map.put(6, 6), is(true));
        assertThat(map.put(7, 7), is(true));
        assertThat(map.put(8, 8), is(true));
        assertThat(map.put(9, 9), is(true));
        assertThat(map.get(1), is(1));
        assertThat(map.get(2), is(2));
        assertThat(map.get(3), is(3));
        assertThat(map.get(4), is(4));
        assertThat(map.get(5), is(5));
        assertThat(map.get(6), is(6));
        assertThat(map.get(7), is(7));
        assertThat(map.get(8), is(8));
        assertThat(map.get(9), is(9));
    }

    @Test
    public void testIterator() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        Iterator<Integer> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangesAfterIterator() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        Iterator<Integer> iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        map.remove(2);
        assertThat(iterator.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementException() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        Iterator<Integer> iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }
}
