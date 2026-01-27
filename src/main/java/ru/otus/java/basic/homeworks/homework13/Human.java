package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.transport.Transport;

public class Human {
    private String name;
    private Transport currentTransport;
    private int power;

    public Human(String name) {
        this.name = name;
        power = 30;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void inTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже в " + currentTransport);
            return;
        }

        currentTransport = transport;
        currentTransport.assignDriver(this);
        System.out.println(name + " выбрал " + transport);

    }

    public void outTransport() {
        if (currentTransport == null) {
            System.out.println(name + " уже вышел из траснпорта");
            return;
        }
        System.out.println(name + " покинул " + currentTransport);
        currentTransport.removeDriver();
        currentTransport = null;
    }

//    public Transport getCurrentTransport() {
//        return currentTransport;
//    }

    public boolean move(int distance, Area area) {
        if (currentTransport != null) {
            return currentTransport.move(distance, area);
        }

        if (distance > power) {
            System.out.println("Недостаточно сил");
            return false;
        }

        power -= distance;
        System.out.printf("%s прошел %s %d км\n", name, area, distance);
        return true;
    }

    public void info() {
        System.out.println("У человека осталось сил: " + power);
    }
}
