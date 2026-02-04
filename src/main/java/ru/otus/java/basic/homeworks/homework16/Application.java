package ru.otus.java.basic.homeworks.homework16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Виктор", 43),
                new Employee("Алексей", 35),
                new Employee("Никита", 29),
                new Employee("Аристарх", 63))
        );
        System.out.println(fillArrayList(2, 9));
        System.out.println(amountItemMoreFive(Arrays.asList(2, 5, 7, 1, 8)));
        System.out.println(setNewItemList(7, Arrays.asList(1, 3, 4, 7)));
        System.out.println(increaseItemList(3, Arrays.asList(2, 3, 4, 11)));
        System.out.println(listName(employees));
        System.out.println(employeesOverMinAge(employees, 30));
        isAverageAgeOver(employees, 40);
        System.out.println(findYongestEmployee(employees));
    }

    public static List<Integer> fillArrayList(int min, int max) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    public static int amountItemMoreFive(List<Integer> list) {
        int amount = 0;
        for (Integer item : list) {
            if (item > 5) {
                amount += item;
            }
        }
        return amount;
    }

    public static List<Integer> setNewItemList(int item, List<Integer> list) {
        Collections.fill(list, item);
        return list;
    }

    public static List<Integer> increaseItemList(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
        return list;
    }

    public static List<String> listName(List<Employee> list) {
        List<String> listName = new ArrayList<>();
        for (Employee employee : list) {
            listName.add(employee.getName());
        }
        return listName;
    }

    public static List<Employee> employeesOverMinAge(List<Employee> list, int minAge) {
        List<Employee> employeesFilterOfAge = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= minAge) {
                employeesFilterOfAge.add(employee);
            }
        }
        return employeesFilterOfAge;
    }

    public static void isAverageAgeOver(List<Employee> list, int minAverageAge) {
        int averageAge = 0;
        for (Employee employee : list) {
            averageAge += employee.getAge();
        }
        averageAge = averageAge / list.size();
        if (averageAge > minAverageAge) {
            System.out.println("Средний возраст сотрудников превышает " + minAverageAge);
        } else {
            System.out.println("Средний возраст сотрудников не превышает " + minAverageAge);
        }
    }

    public static Employee findYongestEmployee(List<Employee> listEmployee) {
        int indexYongestEmployee = 0;
        for (int i = 1; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getAge() < listEmployee.get(indexYongestEmployee).getAge()) {
                indexYongestEmployee = i;
            }
        }
        return listEmployee.get(indexYongestEmployee);
    }
}
