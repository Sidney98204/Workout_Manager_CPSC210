package Test;

import logbook.ResistanceExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResistanceExerciseTests {
    private ResistanceExercise e;

    @BeforeEach
    public void setup() {
        e = new ResistanceExercise("Squat", 225, 3, 12);
    }

    public void testExercise() {
        ResistanceExercise exercise = new ResistanceExercise("Deadlift", 305, 4, 8);

        assertEquals(exercise.getName(), "Deadlift");
        assertEquals(exercise.getWeight(), 305);
        assertEquals(exercise.getSets(), 4);
        assertEquals(exercise.getReps(), 8);
    }

    @Test
    public void testGetName() {
        assertEquals(e.getName(), "Squat");
    }
    @Test
    public void testGetWeight() {
        assertEquals(e.getWeight(), 225);
    }


    @Test
    public void testGetSets() {
        assertEquals(e.getSets(), 3);

    }
    @Test
    public void testGetReps() {
        assertEquals(e.getReps(), 12);
    }

    @Test
    public void testSetName() {
        String newName = "SPAGHETTIIIII";
        assertFalse(e.getName().equals(newName));

        e.setName(newName);

        assertTrue(e.getName().equals(newName));

    }

    @Test
    public void testSetWeight() {
        int newWeight = 10000;
        assertFalse(e.getWeight() == newWeight);

        e.setWeight(newWeight);

        assertTrue(e.getWeight() == newWeight);
    }

    @Test
    public void testSetSets() {
        int newSet = 10;
        assertFalse(e.getSets() == newSet);

        e.setSets(newSet);

        assertTrue(e.getSets() == newSet);
    }

    @Test
    public void testSetReps() {
        int newReps = 80000;
        assertFalse(e.getReps() == newReps);

        e.setReps(newReps);

        assertTrue(e.getReps() == newReps);
    }

    @Test
    public void testtoString() {
        String exercise = "Squat (225 lbs), 3 sets 12 reps";
        String toStringOfe = e.toString();

        assertEquals(exercise, toStringOfe);
    }

    @Test
    public void testReturnStringForSaving() {
        String desiredOutput = "Resistance: Squat 225 3 12";

        assertEquals(e.returnStringForSaving(), desiredOutput);
    }

}
