package ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final Object mon = new Object();
    private static char printLetter = 'A';

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            printLetter('A', 'B', 5);
        });

        executorService.execute(() -> {
            printLetter('B', 'C', 5);
        });

        executorService.execute(() -> {
            printLetter('C', 'A', 5);
        });

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static void printLetter(char currentLetter, char nextLetter, int count) {

            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                synchronized (mon) {
                while (currentLetter != printLetter)
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                System.out.print(currentLetter);
                printLetter = nextLetter;
                mon.notifyAll();
            }
        }
    }
}
