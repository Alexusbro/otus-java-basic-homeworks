package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Area;
import ru.otus.java.basic.homeworks.homework13.Human;

public interface Transport {
    public boolean move(int distance, Area area);
    public void assignDriver(Human human);
    public void removeDriver();
}
