package ru.otus.java.basic.homeworks.homework12;

public class Application {
    public static void main(String[] args) {

        Plate plate = new Plate(20);
        plate.info();

        Cat[] cats = {
                new Cat("Мурзик", 3),
                new Cat("Барсик", 5),
                new Cat("Рыжик", 4),
                new Cat("Васька", 2),
                new Cat("Тимофей", 5),
                new Cat("Басик", 4)
        };

        for (Cat cat : cats) {
            cat.eat(plate);

        }

        for (Cat cat : cats) {
            cat.info();
        }

        System.out.println();

        plate.addFood(10);
        plate.info();

        System.out.println();

        for (Cat cat : cats) {
            cat.eat(plate);
        }

        for (Cat cat : cats) {
            cat.info();
        }

        System.out.println();

        plate.info();

    }
}
