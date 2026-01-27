package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Area;
import ru.otus.java.basic.homeworks.homework13.Human;

public class Horse extends AbstractTransport{
    private int power;

    public Horse(int power) {
        super("лошадь");
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean move(int distance, Area area) {

        if (driver == null) {
            System.out.println("лошадь без наездника не скачет");
            return false;
        }

        if (area == Area.SWAMP) {
            System.out.println(super.type + " не проедет");
            return false;
        }
        if (distance > power) {
            System.out.println("Недостаточно сил");
            return false;
        }
        power -= distance;
        System.out.printf("%s проехал %s, %d км\n", super.type, area, distance);
        return true;
    }

    @Override
    public void info() {
        System.out.println("У лошади осталось сил: " + power);
    }

}


