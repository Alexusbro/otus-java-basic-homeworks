package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.transport.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Human men = new Human("Алексей");
        Car car = new Car(15);
        Rover rover = new Rover(70);
        Horse horse = new Horse(50);
        Bicycle bicycle = new Bicycle();
        List<Transport> transportList = new ArrayList<>(Arrays.asList(car, rover, horse, bicycle));

        men.move(5, Area.SWAMP);
        car.move(1, Area.PLAIN);
        men.inTransport(car);
        men.move(1, Area.PLAIN);

        System.out.println();

        for (Transport item : transportList) {
            men.inTransport(item);
            men.move(25, Area.FOREST);
            men.outTransport();
        }

        System.out.println();
        System.out.println("У человека осталось сил: " + men.getPower());
        System.out.println("У автомобиля осталось топлива: " + car.getFuel());
        System.out.println("У вездехода осталось топлива: " + rover.getFuel());
        System.out.println("У лошади осталось сил: " + horse.getPower());
        System.out.println();

        for (Transport item : transportList) {
            men.inTransport(item);
            men.move(20, Area.PLAIN);
            men.outTransport();
        }

        }
}
