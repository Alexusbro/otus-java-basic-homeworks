package ru.otus.java.basic.homeworks.homework15;

public class AppArrayDataException extends Exception {
    public AppArrayDataException(String message) {
        super(message);
    }

    public AppArrayDataException(String message, int i, int j) {
        super(message + " [" + i + "][" + j + "]" );
    }
}
