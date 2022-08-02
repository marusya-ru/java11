package ru.netology.manager;

public class FilmsManager {
    private String[] films = new String[0];
    private int limitFilms;

    public FilmsManager(int limitFilms) {
        this.limitFilms = limitFilms;
    }

    public FilmsManager() {
        this.limitFilms = 10;
    }

    public String[] getFilms() {
        return films;
    }

    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }

        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;

        if (limitFilms > films.length) {
            resultLength = films.length;
        } else {
            resultLength = limitFilms;
        }

        String[] tmp = new String[resultLength];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }

        return tmp;
    }
}
