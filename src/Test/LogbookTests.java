package Test;

import logbook.Logbook;
import logbook.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogbookTests {
    private Logbook logbook;
    private Workout workout;

    // How many tests do I need? Do i really need empty list, single element, multiple elements?
    // Do I really need to test methods like isInsideOf? How would I even test it without using it itself?

    @BeforeEach
    public void setup() {
        logbook = new Logbook();
        workout = new Workout();
    }

    @Test
    public void testGetSize() {
        Workout workout2 = new Workout();
        Workout workout3 = new Workout();

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
        Workout workout2 = new Workout();

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
        Workout workout2 = new Workout();
        Workout workout3 = new Workout();

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
        Workout workout2 = new Workout();
        Workout workout3 = new Workout();

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);
        assertEquals(logbook.getSize(), 3);

        logbook.removeWorkout(new Workout());
        assertEquals(logbook.getSize(), 3);
    }

    @Test
    public void testSearchWorkoutMultipleElementsGivenFound() {
        Workout workout2 = new Workout("legs", "01/10/2018");
        Workout workout3 = new Workout();

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);

        Workout searchedWorkout = logbook.searchWorkout("legs");
        assertEquals(searchedWorkout, workout2);
    }

    @Test
    public void testSearchWorkoutMultipleElementsReturnNull() {
        Workout workout2 = new Workout("legs", "01/10/2018");
        Workout workout3 = new Workout();

        logbook.addWorkout(workout);
        logbook.addWorkout(workout2);
        logbook.addWorkout(workout3);

        Workout searchedWorkout = logbook.searchWorkout("spaghetti and meatballs");
        assertEquals(searchedWorkout, null);
    }

    @Test
    public void testSaving() {                 // my thing is hardcoded to save to savefile.text so...?

    }

    @Test
    public void testLoad() {

    }




}
