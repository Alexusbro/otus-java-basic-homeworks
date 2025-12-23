package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class AppHomework7 {
    public static void main(String[] args) {

        int[][] array = {{1, 2, 3}, {2, -3, 4}, {6, 7, 8}, {9, 9, 9}};
        System.out.println(sumOfPositiveElements(array));
        System.out.println();
        printStarSquare(5);
        System.out.println();
        printArr(arrZeroDiag(array));
        System.out.println();
        System.out.println(findMax(array));
        System.out.println();
        System.out.println(summSecondRow(array));

    }

    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }

        return sum;
    }

    public static int[][] copyArr(int[][] arr) {
        int[][] copyArray = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copyArray[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copyArray;
    }

    public static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void printStarSquare(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }

    public static int[][] arrZeroDiag(int[][] arr) {
        int[][] newArray = copyArr(arr);
        for (int i = 0; i < newArray.length; i++) {
            if (i < newArray[i].length) newArray[i][i] = 0;
            if ((arr[i].length - 1 - i) >= 0) newArray[i][arr[i].length - 1 - i] = 0;
        }
        return newArray;

    }

    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int[] row : array) {
            for (int elem : row) {
                if (elem > max) max = elem;
            }

        }
        return max;
    }

    public static int summSecondRow(int[][] array) {
        int sum = 0;
        if (array.length > 1) {
            for (int j = 0; j < array[1].length; j++) {
                sum += array[1][j];
            }
            return sum;
        } else return -1;
    }
}
