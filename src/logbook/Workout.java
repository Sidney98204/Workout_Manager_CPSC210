package logbook;

// a list of exercises

import Exceptions.InvalidWorkoutException;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Workout {
    private String name;
    private String date;
    private ArrayList<Exercise> workout;


    // REQUIRES: name and date are not empty
    public Workout(String name, String date) {
        this.name = name;
        this.date = date;
        workout = new ArrayList<>();
    }

    // EFFECTS: returns name
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns date
    public String getDate() {
        return this.date;

    }
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: searches through workout for an exercise with a name name and returns it, returns null if not found
    // returns most recently added if there are duplicates
    public Exercise searchExercise(String name) {
        Exercise e = null;
        for (Exercise exercise: workout) {     // loops for every exercise, so it automatically gets last one if duplicates
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
    // MODIFIES: this
    // EFFECTS: removes exercise if found in this, does nothing otherwise
    public void removeExercise(Exercise e) {
        if (workout.contains(e)) {
            workout.remove(e);
        }
        // HEY, note that we use searchExercise to find the exercise, so the exercise might
        // not correspond to the right one in the list if there are duplicates
    }

    public void removeExercise(String name) {
        Exercise e = searchExercise(name);
        removeExercise(e);

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the number of exercises in workout
    public int getSize() {
        return workout.size();
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: checks if size of list fits index, if so, returns exercise at given index, otherwise returns null
    public Exercise getIndexExercise(int index) {
        Exercise e = null;
        if (index <= getSize() -1 && index >= 0) {
            e = workout.get(index);
        }
         return e;

    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: prints each exercise
    public void printWorkout() {
        for (Exercise e : workout) {
            System.out.println(e);
        }
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: returns the string representation of a workout
    public String toString() {
        String listOfExercises = "";
        for (Exercise e: workout) {
            listOfExercises = listOfExercises + e + "\n";
        }

        // HEYYY, I guess this is an area of cohesion, because the implementation
        // of toString for workout is dependent on the toString implementation of Exercise

        return listOfExercises;
    }



    // EFFECTS: return string containing workout information
    public String returnString() {
        String workoutIdentifier = "workout";
        String workoutInfo = workoutIdentifier + " " + this.getSize() + " " + this.name + " " + this.date + "\n";

        for (int i = 0; i < workout.size(); i++) {
            Exercise e = workout.get(i);
            if (i == workout.size()-1) {
                workoutInfo += e.returnStringForSaving();
            } else {
                workoutInfo += e.returnStringForSaving() + "\n";
            }

        }
        // Hey, I think this is another spot with coupling, coupling between saving/loading and returnString();
        return workoutInfo;
    }

}
