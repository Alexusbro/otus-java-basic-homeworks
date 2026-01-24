package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Area;
import ru.otus.java.basic.homeworks.homework13.Human;

public class Car extends AbstractTransport {
    private int fuel;


    public Car(int fuel) {
        super("автомобиль");
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public boolean move(int distance, Area area) {
        if (driver == null) {
            System.out.println("автомобиль без водителя не может ехать");
            return false;
        }

        if (area == Area.FOREST || area == Area.SWAMP) {
            System.out.println(super.type + " не проедет");
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
