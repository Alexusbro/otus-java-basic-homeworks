package ru.otus.java.basic.homeworks.homework18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2, 4, 5, 27, 12, 29, 81));
        Collections.sort(list);
        SearchTreeList<Integer> searchTreeList = new SearchTreeList<>(list);

        System.out.println(searchTreeList.find(5));
        System.out.println(searchTreeList.getSortedList());
    }
}
