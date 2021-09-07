package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class UserStoreTest {
    @Test
    public void add() {
        UserStore store = new UserStore();
        User user1 = new User("0");
        User user2 = new User("1");
        User user3 = new User("2");
        store.add(user1);
        store.add(user2);
        store.add(user3);
        assertThat(user1, is(store.findById("0")));
        assertThat(user2, is(store.findById("1")));
        assertThat(user3, is(store.findById("2")));
    }

    @Test
    public void replace() {
        UserStore store = new UserStore();
        User user1 = new User("0");
        User user2 = new User("1");
        User user3 = new User("2");
        User userReplaced = new User("3");
        store.add(user1);
        store.add(user2);
        store.add(user3);
        store.replace("1", userReplaced);
        assertThat(user1, is(store.findById("0")));
        assertThat(userReplaced, is(store.findById("1")));
        assertThat(user3, is(store.findById("2")));
    }

    @Test
    public void delete() {
        UserStore store = new UserStore();
        User user1 = new User("0");
        User user2 = new User("1");
        User user3 = new User("2");
        store.add(user1);
        store.add(user2);
        store.add(user3);
        store.delete("1");
        assertThat(user1, is(store.findById("0")));
        assertThat(null, is(store.findById("1")));
        assertThat(user3, is(store.findById("2")));
    }

    @Test
    public void findById() {
        UserStore store = new UserStore();
        User user1 = new User("0");
        User user2 = new User("1");
        User user3 = new User("2");
        store.add(user1);
        store.add(user2);
        store.add(user3);
        User userFound = store.findById("1");
        assertThat(user1, is(store.findById("0")));
        assertEquals(user2, userFound);
        assertThat(user3, is(store.findById("2")));
    }
}
