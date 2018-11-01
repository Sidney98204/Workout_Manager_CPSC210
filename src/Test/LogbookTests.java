package Test;

import logbook.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogbookTests {
    private Logbook logbook;
    private Workout workout;
    // just declare several workouts here.....

    // How many tests do I need? Do i really need empty list, single element, multiple elements?
    // Do I really need to test methods like isInsideOf? How would I even test it without using it itself?

  /*  @BeforeEach
    public void setup() {
        logbook = new Logbook();
        workout = new Workout("legs", "00/00/0000");

        // just instantiate several workouts here....
    }

    @Test
    public void testGetSize() {
        Workout workout2 = new Workout("chest", "01/10/2018");
        Workout workout3 = new Workout("back", "01/10/2018");

        logbook.addWorkout(workout);
        assertEquals(logbook.getSize(),1);

        logbook.addWorkout(workout2);
        assertEquals(logbook.getSize(), 2);

        logbook.addWorkout(workout3);
        assertEquals(logbook.getSize(), 3);
    }

    @Test
    public void testaddWorkoutEmptyList() {
        logbook.addWorkout(workout);

        assertEquals(logbook.getSize(), 1);
        assertEquals(workout, logbook.getLogbook().get(0));
    }

    @Test
    public void testAddWorkoutMultipleElements() {
        Workout workout2 = new Workout("chest", "01/10/2018");

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);

        assertEquals(logbook.getSize(), 2);
        assertEquals(logbook.getLogbook().get(0), workout);
        assertEquals(logbook.getLogbook().get(1), workout2);
    }

    @Test
    public void testRemoveWorkoutSingleElement() {
        logbook.addWorkout(workout);
        assertEquals(logbook.getSize(), 1);

        logbook.removeWorkout(workout);
        assertEquals(logbook.getSize(), 0);

    }

    @Test
    public void testRemoveWorkoutMultipleElements() {
        Workout workout2 = new Workout("chest", "01/10/2018");
        Workout workout3 = new Workout("back", "01/10/2018");

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);
        assertEquals(logbook.getSize(), 3);

        logbook.removeWorkout(workout2);
        assertEquals(logbook.getSize(), 2);
        assertFalse(logbook.isInsideOf(workout2));

        logbook.removeWorkout(workout3);
        assertEquals(logbook.getSize(),1);
        assertFalse(logbook.isInsideOf(workout3));

    }

    @Test
    public void testRemoveWorkoutMultipleElementsGivenNotFound() {
        Workout workout2 = new Workout("chest", "01/10/2018");
        Workout workout3 = new Workout("back", "01/10/2018");

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);
        assertEquals(logbook.getSize(), 3);

        logbook.removeWorkout(new Workout("spaghetti", "18/18/8888"));
        assertEquals(logbook.getSize(), 3);
    }

    @Test
    public void testSearchWorkoutMultipleElementsGivenFound() {
        Workout workout2 = new Workout("legs", "01/10/2018");
        Workout workout3 = new Workout("chest", "01/10/2018");

        // NOTE: if workout doesn't have a name, we get a null pointer exception!!!
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);

        Workout searchedWorkout = logbook.searchWorkout("legs");
        assertEquals(searchedWorkout, workout2);
    }

    @Test
    public void testSearchWorkoutMultipleElementsReturnNull() {
        Workout workout2 = new Workout("legs", "01/10/2018");
        Workout workout3 = new Workout("chest", "01/10/2018");


        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);

        Workout searchedWorkout = logbook.searchWorkout("spaghetti and meatballs");   // NOTE:
        assertEquals(searchedWorkout, null);                                        // ALL WORKOUTS NEED NAMES
    }

    @Test
    public void testReturnStringListWithMultipleElementsInLogbook() {
        Workout workout2 = new Workout("chest", "01/10/2018");
        workout.addExercise(new ResistanceExercise("Squat", 225, 3, 12));
        workout.addExercise(new CardioExercise("Running", 20, "low"));
        workout2.addExercise(new CardioExercise("swimming", 30, "low"));
        workout2.addExercise(new ResistanceExercise("pushups", 160, 4,30));
        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);

        List<String> list = logbook.returnStringList();
        assertEquals(list.get(0), workout.returnString());
        assertEquals(list.get(1), workout2.returnString());

    }

    @Test
    public void testSaving() throws IOException {
        Workout workout2 = new Workout("chest", "01/10/2018");
        workout.addExercise(new ResistanceExercise("Squat", 225, 3, 12));
        workout.addExercise(new CardioExercise("Running", 20, "low"));
        workout2.addExercise(new CardioExercise("swimming", 30, "low"));
        workout2.addExercise(new ResistanceExercise("pushups", 160, 4,30));
        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);


        logbook.save();

        List<String> lines = Files.readAllLines(Paths.get("savefile.text"));
        assertEquals(lines.get(0), "workout 2 legs 00/00/0000");
        assertEquals(lines.get(1), "Resistance: Squat 225 3 12");
        assertEquals(lines.get(2), "Cardio: Running 20 low");
        assertEquals(lines.get(3), "workout 2 chest 01/10/2018");
        assertEquals(lines.get(4), "Cardio: swimming 30 low");
        assertEquals(lines.get(5), "Resistance: pushups 160 4 30");


        // my thing is hardcoded to save to savefile.text so...?
        // we can put some items in logbook, run save, then use scanner to check that all the lines are the same
        // won't this test write over whatever I have saved..?


    }

    @Test
    public void testLoad() throws IOException {    // make sure you check what you have in the save file already
        logbook.load();

        assertEquals(logbook.getSize(), 2);
        assertEquals(logbook.getLogbook().get(0).getSize(), 2);
        assertEquals(logbook.getLogbook().get(1).getSize(), 2);




    }*/




}
