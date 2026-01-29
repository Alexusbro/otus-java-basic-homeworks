package ru.otus.java.basic.homeworks.homework15;

public class Application {
    public static void main(String[] args) {

        String[][] arr1 = {
                {"3", "2", "3", "1"},
                {"5", "4", "2", "3"},
                {"1", "3", "4", "2"},
                {"3", "0", "3", "4"}
        };

        String[][] arr2 = {
                {"3", "G", "3", "1"},
                {"5", "4", "2", "3"},
                {"1", "3", "4", "2"},
                {"3", "0", "3", "4"}
        };

        String[][] arr3 = {
                {"3", "1", "3", "1"},
                {"5", "4", "2", "3"},
                {"1", "3", "4", "2"},
                {"3", "0", "3", "4"},
                {"3", "0", "3", "4"}
        };

        try {
            System.out.println(calcArraySum(arr1));
        } catch (AppArraySizeException ex) {
            ex.printStackTrace();
        } catch (AppArrayDataException ex) {
            ex.printStackTrace();
        }

        try {
            System.out.println(calcArraySum(arr2));
        } catch (AppArraySizeException ex) {
            ex.printStackTrace();
        } catch (AppArrayDataException ex) {
            ex.printStackTrace();
        }

        try{
            System.out.println(calcArraySum(arr3));
        } catch (AppArraySizeException ex) {
            ex.printStackTrace();
        } catch (AppArrayDataException ex) {
            ex.printStackTrace();
        }
    }

    public static int calcArraySum(String[][] array) throws AppArrayDataException, AppArraySizeException {
        if (array == null || array.length != 4) throw new AppArraySizeException("количество строк не равно 4");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new AppArraySizeException("количество столбцов в строке " + i + "не равно 4");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new AppArrayDataException("некорректные данные в ячейке", i, j);

                }
            }

        }
        return sum;
    }
}