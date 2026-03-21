package ru.otus.java.basic.homeworks.homework27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box<T extends Fruit> {
    private List<T> fruits;
    private int weightBox;

    public Box() {
        fruits = new ArrayList<>();
        weightBox = 0;
    }

    public void putFruit(T fruit) {
        if (fruit == null) {
            System.out.println("Вы ничего не положиили в коробку");
            return;
        }
        fruits.add(fruit);
        weightBox += fruit.getWeight();
    }

    public boolean compare(Box<?> box) {
        return this.weightBox == box.weightBox;
    }

    public void replaceFruit(Box<? super T> box) {
        if (fruits.isEmpty()) {
            System.out.println("ваша коробка пустая");
            return;
        }
        T fruit = fruits.removeFirst();
        weightBox -= fruit.getWeight();
        box.putFruit(fruit);
    }

    public void countOfFruits() {
        Map<String, Integer> counts = new HashMap<>();
        for (T fruit : fruits) {
            counts.put(fruit.getName(), counts.getOrDefault(fruit.getName(), 0) + 1);
        }
        if (counts.isEmpty()) {
            System.out.println("коробка пустая");
            return;
        }
        System.out.print("В коробке ");
        counts.forEach((name, count) -> System.out.print(count + " " + name + " "));
        System.out.println();

    }

}
