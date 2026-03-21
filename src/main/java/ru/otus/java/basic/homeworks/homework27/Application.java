package ru.otus.java.basic.homeworks.homework27;

public class Application {
    public static void main(String[] args) {
        Apple apple = new Apple(3);
        Orange orange = new Orange(3);
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        appleBox.putFruit(null);
        appleBox.putFruit(apple);
        appleBox.putFruit(apple);
        orangeBox.putFruit(orange);
        fruitBox.putFruit(orange);
        fruitBox.putFruit(apple);

        System.out.println(appleBox.compare(fruitBox));
        appleBox.countOfFruits();
        orangeBox.countOfFruits();
        fruitBox.countOfFruits();

        System.out.println("перекладываем фрукты");
        orangeBox.replaceFruit(fruitBox);
        orangeBox.replaceFruit(fruitBox);

        appleBox.countOfFruits();
        orangeBox.countOfFruits();
        fruitBox.countOfFruits();
    }
}
