package ru.job4j.set;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
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
        System.out.println(map);
        map.put(second, new Object());
        System.out.println(map);
        System.out.println(first);
        System.out.println(second);
        System.out.println(first == second);
        int a = -12;
        int b = a >>> 1;
        System.out.println(b);
    }
}
