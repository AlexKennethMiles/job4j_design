package ru.job4j.set;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User first = new User("Thomas",
                2,
                new GregorianCalendar(1988, Calendar.MARCH, 10)
        );
        User second = new User("Thomas",
                2,
                new GregorianCalendar(1988, Calendar.MARCH, 10)
        );
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }
}
