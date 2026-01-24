package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Area;
import ru.otus.java.basic.homeworks.homework13.Human;

public class Bicycle extends AbstractTransport {

    public Bicycle() {
        super("велосипед");
    }

    @Override
    public boolean move(int distance, Area area) {

        if (driver == null) {
            System.out.println("велосипед без человека не может ехать");
            return false;
        }

        if (area == Area.SWAMP) {
            System.out.println(super.type + " не проедет");
            return false;
        }
        if (distance > driver.getPower()) {
            System.out.println("Недостаточно сил");
            return false;
        }
        driver.setPower(driver.getPower() - distance);
        System.out.printf("%s проехал %s, %d км\n", super.type, area, distance);
        return true;
    }

}
