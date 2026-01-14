package ru.otus.java.basic.homeworks.homework_10;

public class Box {
    private int width;
    private int length;
    private int height;
    private String color;
    private boolean isOpen;
    private String thing;

    public Box(int width, int length, int height, String color) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
        isOpen = false;
        thing = null;
    }

    public String getStatus() {
        if (isOpen) return "открыта";
        else return "закрыта";
    }

    public String getThing() {
        if (thing != null) return thing;
        else return "пусто";
    }

    public void openBox() {
        if (!isOpen) isOpen = true;
        System.out.println("Коробка открыта");
    }

    public void closeBox() {
        if (isOpen) isOpen = false;
        System.out.println("Коробка закрыта");
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Коробка перекрашена в " + color + " цвет");
    }

    public void putThing(String thing) {
        if (isOpen) {
            if (this.thing == null) {
                this.thing = thing;
                System.out.println("Вы положили в коробку " + thing);
            } else System.out.println("Сначала освободите место в коробке");
        } else System.out.println("Вы не можете положить " + thing + " в закрытую коробку");
    }

    public void takeThing() {
        if (isOpen) {
            if (this.thing == null) System.out.println("Коробка пуста");
            else {
                System.out.println("Вы достали " + thing);
                thing = null;
            }
        } else System.out.println("Вы не можете достать " + thing + " из закрытой коробки");
    }

    @Override
    public String toString() {
        return "Информация о коробке:\n"
                + "ширина: " + width + ";"
                + " длина: " + length + ";"
                + " высота: " + height + ";"
                + " цвет: " + color + "\n"
                + "состояние: " + getStatus() + "\n"
                + "наполнение: " + getThing();
    }
}
