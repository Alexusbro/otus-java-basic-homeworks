package ru.otus.java.basic.homeworks.homework31;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, -7};
        System.out.println(isArrayConsistsOfOneAndTwo(arr));
        System.out.println(Arrays.toString(arrayAfterOne(arr)));

    }

    static int[] arrayAfterOne(int[] currentArray) {
        int index = -1;
        for (int i = currentArray.length - 1; i >= 0; i--) {
            if (currentArray[i] == 1) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException();
        }

        int[] resultArray = new int[currentArray.length - 1 - index];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = currentArray[index + 1 + i];
        }
        return resultArray;
    }

    static boolean isArrayConsistsOfOneAndTwo(int[] array) {
        boolean hasOne = false;
        boolean hasTwo = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 2) {
                return false;
            }
            if (array[i] == 1) {
                hasOne = true;
            }
            if (array[i] == 2) {
                hasTwo = true;
            }
        }
        return hasOne && hasTwo;
    }

}
