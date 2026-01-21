package ru.otus.java.basic.homeworks.homework12;

public class Cat {
    private String name;
    private int appetite;
    private boolean isSatiety;

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isSatiety = false;
    }

    public void eat(Plate plate) {
        if (isSatiety) return;

        if (!plate.reduceFood(appetite)) return;
        isSatiety = true;
    }

    public void info() {
        if (isSatiety) System.out.println(name + " сытый");
        else System.out.println(name + " голодный");
    }
}

