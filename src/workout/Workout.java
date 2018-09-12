package workout;

import java.util.ArrayList;

public class Workout {
    private ArrayList<Exercise> workout;

    public Workout() {
        workout = new ArrayList<>();

    }

    public Exercise searchExercise(String name) {
        Exercise e = null;
        for (Exercise exercise: workout) {
            if (exercise.getName().equals(name)) {
                e = exercise;
            }
        }

        return e;
    }

    public void addExercise(Exercise e) {
        workout.add(e);
    }
}
