package ru.otus.java.basic.homeworks.homework12;

public class Plate {
    private int maxFood;
    private int currentFood;

    public int getCurrentFood() {
        return currentFood;
    }

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public void addFood(int portionFood) {
        currentFood += portionFood;
        if (currentFood > maxFood) currentFood = maxFood;
        System.out.printf("добавили в тарелку %d е. еды\n", portionFood);
    }

    public boolean reduceFood(int portionFood) {
        int result = currentFood - portionFood;
        if (result < 0) return false;
        currentFood -= portionFood;
        return true;
    }

    public void info() {
        System.out.printf("в тарелке %d ед. еды\n", currentFood);
    }

}

