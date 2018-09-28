package Test;

import logbook.Exercise;
import logbook.ResistanceExercise;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import logbook.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkoutTests {
    private ResistanceExercise e;
    private Workout workout;

    @BeforeAll
    public void setUp() {
        e = new ResistanceExercise("Squat", 225, 3, 12);
        workout = new Workout();

    }

    @Test
    public void testAddingExerciseEmptyList() {
        assertEquals(workout.getSize(), 0);

        workout.addExercise(e);

        assertEquals(workout.getSize(), 1);
        assertEquals(workout.getIndexExercise(0), e);

    }

    @Test
    public void testAddingMultipleExercises() {
        ResistanceExercise e1 = new ResistanceExercise("Deadlift", 225, 3, 12);
        ResistanceExercise e2 = new ResistanceExercise("Bench Press", 225, 3, 12);

        assertEquals(workout.getSize(), 0);

        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);

        assertEquals(workout.getSize(), 3); // should i be using this in my test? should I have separate test for size()?
        assertEquals(workout.getIndexExercise(workout.getSize()-1), e2);
        assertEquals(workout.getIndexExercise(workout.getSize()-2), e1);
        assertEquals(workout.getIndexExercise(workout.getSize()-3), e);



    }



    @Test
    public void testSearchExerciseWhenOnlySingleElement() {
        assertEquals(workout.getSize(), 0);
        workout.addExercise(e);
        String searchWord = "Squat";
        Exercise searched = workout.searchExercise(searchWord);

        assertEquals(e, searched);

    }

    @Test
    public void testSearchExeciseNonEmptyListReturnNull() {
        ResistanceExercise e1 = new ResistanceExercise("Deadlift", 225, 3, 12);
        ResistanceExercise e2 = new ResistanceExercise("Bench Press", 225, 3, 12);
        String exerciseName = "1080TripleBackFlipLungeKickOut";
        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);

        assertEquals(workout.searchExercise(exerciseName), null);


    }

    @Test
    public void testSearchExerciseNonEmptyListFindsExercise() {
        ResistanceExercise e1 = new ResistanceExercise("Deadlift", 225, 3, 12);
        ResistanceExercise e2 = new ResistanceExercise("Bench Press", 225, 3, 12);
        String exerciseName = "Bench Press";
        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);

        assertEquals(workout.searchExercise(exerciseName), e2);




    }

    @Test
    public void testGetSize() {
        assertEquals(workout.getSize(), 0);

        workout.addExercise(e);

        assertEquals(workout.getSize(), 1);

        workout.addExercise(e);

        assertEquals(workout.getSize(), 2);
    }

    @Test
    public void testRemoveExerciseWhenNotInside() {
        ResistanceExercise e1 = new ResistanceExercise("Deadlift", 225, 3, 12);
        ResistanceExercise e2 = new ResistanceExercise("Bench Press", 225, 3, 12);
        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);
        assertEquals(workout.getSize(), 3);


        workout.removeExercise(new ResistanceExercise("Bippity bop", 10, 10, 10));

        assertEquals(workout.getSize(), 3);



    }

    @Test
    public void testtoStringOnlyOneElement() {
        workout.addExercise(e);
        String listOfExercises = "Squat (225 lbs), 3 sets 12 reps\n";
        String stringOfWorkout = workout.toString();

        assertEquals(stringOfWorkout, listOfExercises);

    }

    @Test
    public void testtoStringSeveralElements() {
        ResistanceExercise e1 = new ResistanceExercise("Deadlift", 225, 3, 12);
        ResistanceExercise e2 = new ResistanceExercise("Bench Press", 225, 3, 12);
        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);
        String listOfExercises = "Squat (225 lbs), 3 sets 12 reps\n" + "Deadlift (225 lbs), 3 sets 12 reps\n"
                + "Bench Press (225 lbs), 3 sets 12 reps";
        String workoutToString = workout.toString();

        assertEquals(listOfExercises, workoutToString);


    }


}
