package logbook;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Workout> workouts;
    private String name;

    public Person(String name) {
        this.name = name;
        workouts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addWorkout(Workout w) {
        if (!workouts.contains(w)) {
            workouts.add(w);
            w.addPerson(this);
        }
    }

    public void removeWorkout(Workout w) {
        if (workouts.contains(w)) {
            workouts.remove(w);
            w.removePerson(this);
        }
    }



    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
