package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FilmsManagerTest {

    @Test
    public void shouldAddFilms() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");

        String[] expected = {"film1", "film2", "film3"};
        String[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFilms() {
        FilmsManager manager = new FilmsManager();

        for (int i = 1; i <= 11; i++) {
            manager.addFilm("film" + i);
        }

        String[] expected = {
                "film1", "film2", "film3", "film4", "film5", "film6", "film7", "film8", "film9", "film10", "film11"
        };
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsWithLimit() {
        FilmsManager manager = new FilmsManager(5);

        for (int i = 1; i <= 15; i++) {
            manager.addFilm("film" + i);
        }

        String[] expected = {
                "film15", "film14", "film13", "film12", "film11"
        };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsWithLimitByDefault() {
        FilmsManager manager = new FilmsManager();

        for (int i = 1; i <= 15; i++) {
            manager.addFilm("film" + i);
        }

        String[] expected = {
                "film15", "film14", "film13", "film12", "film11", "film10", "film9", "film8", "film7", "film6"
        };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsWithLimitByDefaultAndAmountFilmsLessThanLimit() {
        FilmsManager manager = new FilmsManager();

        for (int i = 1; i <= 8; i++) {
            manager.addFilm("film" + i);
        }

        String[] expected = {
                "film8", "film7", "film6", "film5", "film4", "film3", "film2", "film1"
        };
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}
