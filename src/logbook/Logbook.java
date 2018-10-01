package logbook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Logbook implements Loadable, Saveable {
    private ArrayList<Workout> logbook;

    // EFFECTS: creates new logbook object with empty list
    public Logbook() {
        logbook = new ArrayList<>();

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
        String workoutIdentifier = "workout";
        String cardioIdentifier = "Cardio:";
        String resistanceIdentifier = "Resistance:";

        File file = new File("savefile.text");

        Scanner r = new Scanner(file);
        while (r.hasNextLine()) {
            String line = r.nextLine();
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (partsOfLine.get(0).equals(workoutIdentifier)) {
                Workout workout = new Workout(partsOfLine.get(2), partsOfLine.get(3));
                int numberOfExercises = Integer.parseInt(partsOfLine.get(1));
                for (int i = 0; i < numberOfExercises; i++) {
                    String exerciseLine = r.nextLine();
                    ArrayList<String> partsOfLineExercise = splitOnSpace(exerciseLine);
                    if (partsOfLineExercise.get(0).equals(cardioIdentifier)) {
                        workout.addExercise(new CardioExercise(partsOfLineExercise.get(1),
                                Integer.parseInt(partsOfLineExercise.get(2)), partsOfLineExercise.get(3)));
                    } else if (partsOfLineExercise.get(0).equals(resistanceIdentifier)) {
                        workout.addExercise(new ResistanceExercise(partsOfLineExercise.get(1),
                                Integer.parseInt(partsOfLineExercise.get(2)),
                                Integer.parseInt(partsOfLineExercise.get(3)),
                                Integer.parseInt(partsOfLineExercise.get(4))));
                    }
                }
                this.addWorkout(workout);
            }
        }
        /*List<String> lines = Files.readAllLines(Paths.get("savefile.text"));   // how come this doesn't work?
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (partsOfLine.get(0).equals(workoutIdentifier)) {
                Workout workout = new Workout(partsOfLine.get(2), partsOfLine.get(3));
                int numberOfExercises = Integer.parseInt(partsOfLine.get(1));         // note exception here
                for (int j = 0; j < numberOfExercises; j++) {
                    i++;
                    line = lines.get(i);
                    ArrayList<String> partsOfLineForExercise = splitOnSpace(line);
                    if (partsOfLineForExercise.get(0).equals("Cardio:")) {
                        workout.addExercise(new CardioExercise(partsOfLine.get(1),
                                Integer.parseInt(partsOfLine.get(2)), partsOfLine.get(3)));
                    } else if (partsOfLineForExercise.get(0).equals("Resistance:")) {
                        workout.addExercise(new ResistanceExercise(partsOfLine.get(1),
                                Integer.parseInt(partsOfLine.get(2)),
                                Integer.parseInt(partsOfLine.get(3)),
                                Integer.parseInt(partsOfLine.get(4))));
                    }
                }
                logbook.addWorkout(workout);


            *//*if (partsOfLine.get(0).equals("Cardio:")) {
                workout.addExercise(new CardioExercise(partsOfLine.get(1),
                        Integer.parseInt(partsOfLine.get(2)), partsOfLine.get(3)));
            } else if (partsOfLine.get(0).equals("Resistance:")) {
                workout.addExercise(new ResistanceExercise(partsOfLine.get(1),
                        Integer.parseInt(partsOfLine.get(2)),
                        Integer.parseInt(partsOfLine.get(3)),
                        Integer.parseInt(partsOfLine.get(4))));*//*
            }

        }*/


    }

    // EFFECTS: saves inputted information into a file
    public void save() throws IOException {

        List<String> lines = this.returnStringList();
        PrintWriter writer = new PrintWriter("savefile.text", "UTF-8");
        for (String line: lines) {
            writer.println(line);
        }
        writer.close();


    }

    // EFFECTS: splits up given string by its spaces
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

}
