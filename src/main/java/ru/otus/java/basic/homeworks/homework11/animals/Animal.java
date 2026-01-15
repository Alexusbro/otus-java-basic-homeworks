package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class Animal {
    String name;
    int speedRun;
    int endurance;
    final int COST_ENDURANCE_RUN = 1;

    public Animal(String name, int speedRun, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.endurance = endurance;
    }

    protected float calculateActivity (String activity, int distance, int costEndurance, int speed) {
        if ((endurance - costEndurance * distance) < 0) {
            System.out.printf("%s не %s, потому что устал(а)\n", name, activity);
            endurance = 0;
            return -1;
        }
        endurance -= costEndurance * distance;
        float time = (float) distance / speed;
        System.out.printf("%s %s %d м. за %.2f сек.\n", name, activity, distance, time);
        return time;
    }

    public float run(int distance) {
        return calculateActivity("пробежал(а)", distance, COST_ENDURANCE_RUN, speedRun);
    }

    public void info() {
        System.out.printf("%s осталось %d ед. выносливости\n", name, endurance);
    }
}
