package logbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    private Logbook logbook;

    public Loader(Logbook logbook) {
        this.logbook = logbook;
    }

    public void load() throws FileNotFoundException{
        // THIS METHOD IS HEAVILY DEPENDENT ON SAVE, AND RETURNSTRINGFORSAVING
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
                logbook.addWorkout(workout);
            }
        }


    }

    // EFFECTS: splits up given string by its spaces
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

}
