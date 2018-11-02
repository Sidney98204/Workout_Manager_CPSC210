package logbook;

// a list of exercises

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private Date date;
    private ArrayList<Exercise> workout;
    private List<Person> persons;

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: creates new Workout object with empty list
    /*public Workout() {
        //this.name = name;
        //this.date = date;

        workout = new ArrayList<>();

    }
*/
    public Workout(String name, Date date) {
        this.name = name;
        this.date = date;
        workout = new ArrayList<>();
        persons = new ArrayList<>();
    }

    // EFFECTS: sets name of workout
    public void setName(String name) {
        this.name = name;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public List<Person> getPeople() {
        return persons;
    }

    public void addPerson(Person p) {
        if (!persons.contains(p)) {
            persons.add(p);
            p.addWorkout(this);
        }
    }

    public void removePerson(Person p) {
        if (persons.contains(p)) {
            persons.remove(p);
            p.removeWorkout(this);
        }
    }

    // EFFECTS: returns name
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns date
    public Date getDate() {
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
        if (index <= getSize() -1 && index >= 0) {
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

        // tests for print methods...?
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: returns the string representation of a workout
    public String toString() {
        String listOfExercises = "";
        for (Exercise e: workout) {
            listOfExercises = listOfExercises + e + "\n";
        }

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

        return workoutInfo;
    }

    // EFFECTS: returns list of string with 1st element being workout info
    //  and the rest being strings of each exercise
    public List<String> returnStringList() {
        String workoutIdentifier = "workout";
        List<String> list = new ArrayList<>();
        list.add(workoutIdentifier+ " " + this.getSize() + " " + this.name + " " + this.date);
        for (Exercise e: workout) {
            list.add(e.returnStringForSaving());
        }

        return list;
    }


}
