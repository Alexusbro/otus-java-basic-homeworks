package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File root = new File(".");
        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().toLowerCase().endsWith(".txt");
            }
        };
        File[] files = root.listFiles(txtFilter);
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
        String fileName = "";
        while (true) {
            System.out.println("Введите имя текстового файла: ");
            String input = scan.nextLine();
            if (Arrays.stream(files).anyMatch(file -> file.getName().equalsIgnoreCase(input))) {
                fileName = input;
                break;
            } else {
                System.out.println("Файл отстутствует");

            }

        }
        System.out.println("содержимое файла:");
        String str;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Введите данне для записи в файл:");
        String in = scan.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.newLine();
            bw.write(in);
            System.out.println("Данные записаны в файл " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
