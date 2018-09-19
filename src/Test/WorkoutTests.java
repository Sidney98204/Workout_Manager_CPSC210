package Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import workout.Exercise;
import workout.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkoutTests {
    private Exercise e;
    private Workout workout;

    @BeforeAll
    public void setUp() {
        e = new Exercise("Squat", 225, 3, 12);
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
        Exercise e1 = new Exercise("Deadlift", 225, 3, 12);
        Exercise e2 = new Exercise("Bench Press", 225, 3, 12);

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
// is there any value to adding this test???
    }

    @Test
    public void testSearchExeciseNonEmptyListReturnNull() {
        Exercise e1 = new Exercise("Deadlift", 225, 3, 12);
        Exercise e2 = new Exercise("Bench Press", 225, 3, 12);
        String exerciseName = "1080TripleBackFlipLungeKickOut";
        workout.addExercise(e);
        workout.addExercise(e1);
        workout.addExercise(e2);

        assertEquals(workout.searchExercise(exerciseName), null);


    }

    @Test
    public void testSearchExerciseNonEmptyListFindsExercise() {
        Exercise e1 = new Exercise("Deadlift", 225, 3, 12);
        Exercise e2 = new Exercise("Bench Press", 225, 3, 12);
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
    }


}
