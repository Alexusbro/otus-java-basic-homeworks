package ru.otus.java.basic.homeworks.homework20;

import java.io.*;

public class CalculateClient implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public CalculateClient(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void getMessage() {
        try {
            String message = inputStream.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            System.out.println("не удалось получить сообщение от сервера");
        }
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
        try {
            String result = inputStream.readUTF();
            System.out.println("ответ: " + result);
        } catch (EOFException ex) {
            System.out.println("Сервер закрыл соединение");
            ex.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
