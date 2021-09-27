package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void readingFromAnIterator() {
        Set<Integer> set = new SimpleSet<>();
        for (int i = 0; i < 4; i++) {
            set.add(i);
        }
        Iterator<Integer> iter = set.iterator();
        assertThat(iter.next(), is(0));
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangesDuringTheIterator() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        Iterator<Integer> i = set.iterator();
        assertTrue(i.hasNext());
        assertThat(i.next(), is(1));
        assertTrue(set.add(3));
        assertTrue(i.hasNext());
    }
}
