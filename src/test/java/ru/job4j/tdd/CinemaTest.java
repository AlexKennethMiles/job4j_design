package ru.job4j.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

public class CinemaTest {

    @Disabled
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions).isNull();
    }

    @Test
    public void whenNotFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions).isNull();
    }

    @Disabled
    @Test
    public void whenTheSessionAlreadyExists() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        assertThrows(IllegalArgumentException.class, () -> {
            cinema.add(new Session3D());
        });
    }

    @Disabled
    @Test()
    public void whenInvalidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            cinema.buy(account, -1, 1, date);
        });
    }

    @Disabled
    @Test()
    public void whenInvalidCalendar() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = new GregorianCalendar(2013, Calendar.NOVEMBER, 28);
        assertThrows(IllegalArgumentException.class, () -> {
            cinema.buy(account, 1, 1, date);
        });
    }

    @Disabled
    @Test
    public void whenAlreadyPurchased() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            cinema.buy(account, 1, 1, date);
        });
    }
}
