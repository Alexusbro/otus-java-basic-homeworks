package ru.otus.java.basic.homeworks.homework17;

import java.util.*;

public class PhoneBook {
    private Map<Person, Set<Integer>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(Person person, Integer phoneNumber) {
       Set<Integer> phones = phoneBook.getOrDefault(person, new HashSet<>());
       phones.add(phoneNumber);
       phoneBook.put(person, phones);
    }

    public Set<Integer> find(Person person) {
        return phoneBook.getOrDefault(person, Collections.emptySet());
    }
    public Set<Integer> find(String firstName, String lastName) {
        Person key = new Person(firstName, lastName);
        return phoneBook.getOrDefault(key, Collections.emptySet());
    }

    public boolean containsPhoneNumber(int phoneNumber) {

        for (Map.Entry<Person, Set<Integer>> contact : phoneBook.entrySet()) {
            if (contact.getValue().contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}


