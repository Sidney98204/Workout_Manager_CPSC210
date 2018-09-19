package workout;

// a list of exercises

import java.util.ArrayList;

public class Workout {
    private String name;
    private ArrayList<Exercise> workout;

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: creates new Workout object with empty list
    public Workout() {

        workout = new ArrayList<>();

    }
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: searches through workout for an exercise with a name name and returns it, returns null if not found
    public Exercise searchExercise(String name) {
        Exercise e = null;
        for (Exercise exercise: workout) {
            if (exercise.getName().equals(name)) {
                e = exercise;
            }
        }

        return e;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: adds e to the end of the list
    public void addExercise(Exercise e) {
        workout.add(e);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the number of exercises in workout
    public int getSize() {
        return workout.size();
        // haven't written tests for this method!!!
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: checks if size of list fits index, if so, returns exercise at given index, otherwise returns null
    public Exercise getIndexExercise(int index) {
        Exercise e = null;
        if (index <= getSize() -1) {
            e = workout.get(index);
        }
         return e;

    }
    // haven't written tests for this method!!!

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints each exercise
    public void printWorkout() {
        for (Exercise e : workout) {
            System.out.println(e);
        }
    }
}
