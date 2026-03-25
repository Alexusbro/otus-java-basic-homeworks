package ru.otus.java.basic.homeworks.homework29;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите через пробел название файла и искомую последовательность символов: ");
        String strInput = scan.nextLine();
        String[] tokens = strInput.split(" +");
        if (tokens.length !=2) {
            System.out.println("Введены некорректные данные");
            return;
        }
        String fileName = tokens[0];
        int count = getCount(tokens, fileName);

        System.out.println(count);

        scan.close();
    }

    private static int getCount(String[] tokens, String fileName) {
        String findSubStr = tokens[1];
        if (findSubStr == null && findSubStr.isEmpty()) {
            System.out.println("Искомая подстрока не может быть пустой");
            return 0;
        }
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String lineText;
            while ((lineText = br.readLine()) != null) {
                int index = 0;
                while ((index = lineText.indexOf(findSubStr, index)) != -1) {
                    count++;
                    index += findSubStr.length();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода");
            e.printStackTrace();
        }
        return count;
    }
}
