package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Human;

public abstract class AbstractTransport implements Transport {
    protected String type;
    protected Human driver;

    public AbstractTransport(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public void assignDriver(Human driver) {
        this.driver = driver;
    }

    @Override
    public void removeDriver() {
        driver = null;
    }


}
