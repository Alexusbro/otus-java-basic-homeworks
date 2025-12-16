package ru.otus.java.basic.homeworks.homework5;

import java.util.Arrays;
import java.util.Scanner;

public class AppHomework5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = 0;

        System.out.println("Введите текстовую строку:");
        String text = scan.nextLine();

        System.out.println("Введите через пробел целые числа для массива и нажмите Enter");
        String[] arrayTemp = scan.nextLine().trim().split(" +");
        int[] arrayInt = new int[arrayTemp.length];
        for (int i = 0; i < arrayInt.length; i++) {
            try {
                arrayInt[i] = Integer.parseInt(arrayTemp[i]);
            } catch (NumberFormatException ex) {
                System.err.println("Введено некорректное значение - " + arrayTemp[i] + " В массив будет добавлен 0");
                arrayInt[i] = 0;
            }
        }

        while (true) {
            System.out.println("Введите целое число: ");
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                break;
            } else System.err.println("Неправильный формат данных. Повторите ввод");
            scan.nextLine();
        }

        System.out.println("Печатаем вашу строку " + text + " " + number + " раз(а)");
        printN(number, text);
        System.out.println("\nсуммируем все элементы массива " + Arrays.toString(arrayInt) + " которые больше 5: ");
        printSum(arrayInt);
        System.out.println("\nменяем все элементы массива " + Arrays.toString(arrayInt) + " на число " + number);
        arrPut(number, arrayInt);
        System.out.println("\nувеличиваем все элементы массива " + Arrays.toString(arrayInt) + " на " + number);
        arrPlus(number, arrayInt);
        System.out.println("\nопределяем какая из половин массива " + Arrays.toString(arrayInt) + " больше");
        arrHalfCompare(arrayInt);

    }

    public static void printN(int n, String text) {
        for (int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }

    public static void printSum(int[] arr) {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) summ += arr[i];
        }
        System.out.println("сумма элементов больше 5 = " + summ);
    }

    public static void arrPut(int putNumber, int[] arr) {
        int[] arrNew = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = putNumber;

        }
        System.out.println("Результат: " + Arrays.toString(arrNew));
    }

    public static void arrPlus(int sumNumber, int[] arr) {
        int[] arrNew = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i] + sumNumber;

        }
        System.out.println("Результат: " + Arrays.toString(arrNew));
    }

    public static void arrHalfCompare(int[] arr) {
        int summHalf1 = 0;
        int summHalf2 = 0;
        for (int i = 0; i <= arr.length / 2; i++) {
            summHalf1 += arr[i];
            summHalf2 += arr[arr.length - 1 - i];
        }
        if (summHalf1 > summHalf2) {
            System.out.println("первая половина больше");
        } else if (summHalf1 < summHalf2) {
            System.out.println("вторая половина больше");
        } else System.out.println("половины равны");
    }

}
