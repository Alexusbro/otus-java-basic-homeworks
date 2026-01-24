package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Area;
import ru.otus.java.basic.homeworks.homework13.Human;

public class Rover extends AbstractTransport {
    private int fuel;

    public Rover(int fuel) {
        super("вездеход");
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public boolean move(int distance, Area area) {

        if (driver == null) {
            System.out.println("вездеход без водителя не может ехать");
            return false;
        }

        if (distance > fuel) {
            System.out.println("Недостаточно бензина");
            return false;
        }

        fuel -= distance;
        System.out.printf("%s проехал %s, %d км\n", super.type, area, distance);
        return true;
    }

}
