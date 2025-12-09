package ru.otus.java.basic.homeworks.homework3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AppHomework3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int number = 0;
        while (true) {
            System.out.println("Введите число от 1 до 5");
            try {
                number = scan.nextInt();
            } catch (InputMismatchException ex) {
                scan.nextLine();
                System.out.println("Необходимо ввести целое число");
            }
            if (number > 0 && number <= 5) break;

        }
        scan.close();
        switch (number) {
            case 1 -> greetings();
            case 2 -> checkSign(random.nextInt(), random.nextInt(), random.nextInt());
            case 3 -> selectColor();
            case 4 -> compareNumbers();
            case 5 -> addOrSubtractAndPrint(random.nextInt(), random.nextInt(), random.nextBoolean());
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int result = a + b + c;
        if (result >= 0) {
            System.out.printf("a = %d, b = %d, c = %d. Сумма положительная", a, b, c);
        } else System.out.printf("a = %d, b = %d, c = %d. Сумма отрицательная", a, b, c);
    }

    public static void selectColor() {
        int data = new Random().nextInt();
        if (data <= 10) {
            System.out.printf("data = %d, Красный", data);
        } else if (data <= 20) {
            System.out.printf("data = %d, Желтый", data);
        } else System.out.printf("data = %d, Зеленый", data);
    }

    public static void compareNumbers() {
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();
        if (a >= b) {
            System.out.printf("a = %d, b = %d\na >= b", a, b);
        } else System.out.printf("a = %d, b = %d\na < b", a, b);
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else System.out.println(initValue - delta);
    }
}

