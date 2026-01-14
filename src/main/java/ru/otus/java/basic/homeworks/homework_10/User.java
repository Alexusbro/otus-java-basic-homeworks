package ru.otus.java.basic.homeworks.homework_10;

import java.time.LocalDate;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int yearOfBirth;
    private String email;

    public User (String surname, String name, String patronymic, int yearOfBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public int getAge() {
        return LocalDate.now().getYear() - yearOfBirth;
    }

    @Override
    public String toString() {
        return "ФИО: " + surname + " " + name + " " + patronymic + "\n"
                + "Год рождения: " + yearOfBirth + "\n"
                + "e-mail: " + email;
    }
}
