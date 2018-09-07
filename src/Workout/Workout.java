package Workout;

import java.util.ArrayList;

public class Workout {
    private ArrayList<Exercise> workout;

    public Workout() {
        workout = new ArrayList<>();

    }

    public void addExercise(Exercise e) {
        workout.add(e);
    }
}
