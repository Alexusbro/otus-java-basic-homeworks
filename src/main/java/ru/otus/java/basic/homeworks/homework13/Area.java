package ru.otus.java.basic.homeworks.homework13;

public enum Area {
    FOREST("лес"),
    PLAIN("равнина"),
    SWAMP("болото");

    private final String description;
    private Area(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
