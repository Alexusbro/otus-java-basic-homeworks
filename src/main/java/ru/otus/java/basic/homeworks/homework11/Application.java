package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.animals.Cat;
import ru.otus.java.basic.homeworks.homework11.animals.Dog;
import ru.otus.java.basic.homeworks.homework11.animals.Horse;

public class Application {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Rex", 4, 2, 10);
        Horse horse1 = new Horse("Wind", 6, 3, 15);
        Cat cat1 = new Cat("Kitty", 3, 5);
        dog1.info();
        horse1.info();
        cat1.info();
        dog1.run(3);
        horse1.run(3);
        cat1.run(10);
        dog1.swim(2);
        horse1.swim(10);
        dog1.info();
        horse1.info();
    }
}
