package ru.otus.java.basic.homeworks.homework21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        final int ARRAY_SIZE = 100_000_000;
        double[] doubleArray1 = new double[ARRAY_SIZE];
        double[] doubleArray2 = new double[ARRAY_SIZE];
        long startTime1 = System.nanoTime();
        fillDoubleArray(doubleArray1, 0, ARRAY_SIZE);
        long endTime1 = System.nanoTime();
        double result1 = (double) (endTime1 - startTime1) / 1_000_000;
        System.out.printf("время заполнения массива: %.2f милисекунд\n", result1);
        System.out.println("многотопочное заполнение");
        System.out.println("введите количество потоков:");
        int amountThread = scan.nextInt();
        scan.close();
        int part = ARRAY_SIZE / amountThread;
        ArrayList<Thread> threads = new ArrayList<>();
        long startTime2 = System.nanoTime();
        for (int i = 0; i < amountThread; i++) {
            final int start = i * part;
            final int end = ((amountThread - i) == 1) ? ARRAY_SIZE : start + part;
            Thread thread = new Thread(() -> {
                fillDoubleArray(doubleArray2, start, end);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime2 = System.nanoTime();
        double result2 = (double) (endTime2 - startTime2) / 1_000_000;
        System.out.printf("время многопоточного заполнения массива:%.2f милисекунд\n", result2);
    }

    public static void fillDoubleArray(double[] doubleArray, int start, int end) {
        for (int i = start; i < end; i++) {
            doubleArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

}

