package ru.otus.java.basic.homeworks.homework20;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class CalcServer {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен");
            while (true) {
                try (Socket client = socket.accept();
                     DataInputStream input = new DataInputStream(client.getInputStream());
                     DataOutputStream output = new DataOutputStream(client.getOutputStream())) {
                    System.out.println("клиент: " + client.getPort());
                    output.writeUTF("Вас приветсвует консольный калькулятор\nДопустимые операции: + - * /");
                    output.flush();
                    DecimalFormat df = new DecimalFormat("#.###");

                    while (true) {
                        String userInput = input.readUTF().replaceAll("\\s+", "");
                        String[] task = userInput.split("[+\\-/*]");
                        if (task.length < 2) {
                            output.writeUTF("введены некорректные данные");
                            output.flush();
                            continue;
                        }
                        double number1;
                        double number2;
                        try {
                            number1 = Double.parseDouble(task[0]);
                            number2 = Double.parseDouble(task[1]);
                        } catch (NumberFormatException ex) {
                            output.writeUTF("введен неверный формат чисел");
                            output.flush();
                            continue;
                        }

                        char operate = userInput.charAt(task[0].length());
                        Double result;

                        switch (operate) {
                            case '+' -> result = number1 + number2;
                            case '-' -> result = number1 - number2;
                            case '*' -> result = number1 * number2;
                            case '/' -> {
                                if (number2 == 0) {
                                    output.writeUTF("Делить на ноль нельзя");
                                    output.flush();
                                    continue;
                                }
                                result = number1 / number2;
                            }
                            default -> {
                                output.writeUTF("ошибка вычисления");
                                output.flush();
                                continue;
                            }
                        }
                        System.out.println(result);
                        output.writeUTF(String.valueOf(df.format(result)));
                        output.flush();
                    }
                } catch (IOException ex) {
                    System.out.println("клиент отключился. Ждём нового");
                }
            }
        } catch (IOException ex) {
            System.out.println("Сервер упал");
        }
    }
}