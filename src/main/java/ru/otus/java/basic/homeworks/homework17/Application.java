package ru.otus.java.basic.homeworks.homework17;

public class Application {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Person personId1 = new Person("Алексей", "Иванов");
        Person personId2 = new Person("Иван", "Алексеев");
        Person personId3 = new Person("Николай", "Петров");

        phoneBook.add(personId1, 27076);
        phoneBook.add(personId2, 38504);
        phoneBook.add(personId3, 23456);
        phoneBook.add(personId1, 32145);
        System.out.println(phoneBook.find(personId2));
        System.out.println(phoneBook.find(personId1));
        System.out.println(phoneBook.find("Николай", "Петров"));
        System.out.println(phoneBook.containsPhoneNumber(23456));

    }
}
