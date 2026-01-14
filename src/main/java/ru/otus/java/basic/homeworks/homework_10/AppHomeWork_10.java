package ru.otus.java.basic.homeworks.homework_10;

public class AppHomeWork_10 {
    public static void main(String[] args) {
        User[] users = new User[10];
        users[0] = new User("Иванов", "Иван", "Иванович", 1959, "ivan59@gmai.com");
        users[1] = new User("Петров", "Петр", "Иванович", 1989, "petr89@gmai.com");
        users[2] = new User("Иванов", "Николай", "Семенович", 1983, "nick83@gmai.com");
        users[3] = new User("Семнов", "Артем", "Петрович", 2001, "art@gmai.com");
        users[4] = new User("Сидоров", "Иван", "Федорович", 1999, "ivan@gmai.com");
        users[5] = new User("Сидоров", "Сергей", "Иванович", 1979, "serg79@gmai.com");
        users[6] = new User("Иванов", "Григорий", "Иванович", 1985, "grisha@gmai.com");
        users[7] = new User("Артемьев", "Евлампий", "Никонорович", 1999, "eva@gmai.com");
        users[8] = new User("Федоров", "Иван", "Петрович", 1993, "ivan93@gmai.com");
        users[9] = new User("Платонов", "Кирилл", "Алексеевич", 1959, "kirill@gmai.com");

        System.out.println("список пользователей старше 40 лет:");
        for (User item : users) {
            if (item.getAge() > 40) {
                System.out.println(item);
                System.out.println();
            }
        }

        Box box = new Box(20, 30, 10, "синяя");
        System.out.println(box);
        box.setColor("красный");
        box.putThing("яблоко");
        box.openBox();
        box.putThing("яблоко");
        box.closeBox();
        box.takeThing();
        box.openBox();
        box.takeThing();
    }
}
