package logbook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Logbook extends Observable {
    private ArrayList<Workout> logbook;
    private Loader loader;
    private Saver saver;


    // EFFECTS: creates new logbook object with empty list
    public Logbook() {
        logbook = new ArrayList<>();
        loader = new Loader(this);
        saver = new Saver(this);

    }

    // EFFECTS: returns list of workouts
    public ArrayList<Workout> getLogbook() {
        return logbook;
    }

    // EFFECTS: returns size of logbook
    public int getSize() {
        return logbook.size();
    }

    // EFFECTS: returns true if given workout is inside logbook, false otherwise
    public boolean isInsideOf(Workout workout) {
        return logbook.contains(workout);
    }

    // MODIFIES: this
    // EFFECTS: adds workout to the end of the list of logbook
    public void addWorkout(Workout workout) {
        logbook.add(workout);
        setChanged();
        this.notifyObservers(workout);
    }

    // MODIFIES: this
    // EFFECTS: removes workout if found in logbook, otherwise does nothing
    public void removeWorkout(Workout workout) {
        if (logbook.contains(workout)) {
            logbook.remove(workout);
        }
    }

    //EFFECTS: returns most recently added workout with given name, returns null if not found in logbook
    public Workout searchWorkout(String name) {
        Workout workout = null;
        for (Workout w: logbook) {
            if (w.getName().equals(name)) {
                workout = w;
            }
        }
        return workout;
    }

    // EFFECTS: returns list of string representations of workouts in logbook
    public List<String> returnStringList() {
        List<String> list = new ArrayList<>();
        for (Workout w: logbook) {
            list.add(w.returnString());
        }

        return list;
    }


    // EFFECTS: loads previously saved info into the program
    public void load() throws IOException {
        loader.load();
        // THIS METHOD IS HEAVILY DEPENDENT ON SAVE, AND RETURNSTRINGFORSAVING
    }

    // EFFECTS: saves inputted information into a file
    public void save() throws IOException {
        // THIS METHOD IS HEAVILY DEPENDENT ON RETURNSTRINGLIST, LOAD, W.RETURNSTRING() AND OTHERS (?)
        saver.save();
    }



}
