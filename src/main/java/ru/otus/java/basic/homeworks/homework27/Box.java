package ru.otus.java.basic.homeworks.homework27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void putFruit(T fruit) {
        if (fruit == null) {
            System.out.println("Вы ничего не положили в коробку");
            return;
        }
        fruits.add(fruit);
    }

    public int weightBox() {
        int weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box) {
        if (box == null) {
            return false;
        }
        return weightBox() == box.weightBox();
    }

    public void replaceFruit(Box<? super T> box) {
        if (fruits.isEmpty()) {
            System.out.println("ваша коробка пустая");
            return;
        }
        List<T> tmp = new ArrayList<>(fruits);
        for (T fruit : tmp) {
        box.putFruit(fruit);
        }
        fruits.clear();

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
