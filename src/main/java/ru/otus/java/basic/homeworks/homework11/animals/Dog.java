package ru.otus.java.basic.homeworks.homework11.animals;

public class Dog extends Animal implements Swimable {
    private int speedSwim;
    private final int costEnduranceSwim = 2;

    public Dog(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, endurance);
        this.speedSwim = speedSwim;
    }

    @Override
    public float swim(int distance) {
        return calculateActivity("проплыл(а)", distance, costEnduranceSwim, speedSwim);
    }
}
