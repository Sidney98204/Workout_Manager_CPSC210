package logbook;

import java.util.Observer;

public abstract class Exercise {
    protected String name;

    public Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String toString();

    public abstract String returnStringForSaving();


}

