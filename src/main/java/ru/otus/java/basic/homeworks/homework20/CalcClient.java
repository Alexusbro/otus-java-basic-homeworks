package ru.otus.java.basic.homeworks.homework20;

import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8080);
             CalculateClient client = new CalculateClient(socket.getInputStream(), socket.getOutputStream())) {
            client.getMessage();
            while (true) {
                System.out.println("Введите данные для вычисления одной строкой");
                String input = scan.nextLine();
                if (input.equals("exit")) break;
                if (input.isEmpty()) {
                    System.out.println("вы ввели пустую строку");
                    continue;
                }
                client.send(input);
            }
        } catch (Exception e) {
            System.out.println("сервер недоступен, подключение невозможно");
            throw new RuntimeException(e);
        }

    }
}

