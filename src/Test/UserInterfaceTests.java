package Test;

import logbook.Date;
import logbook.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.UserInterface;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.fail;

public class UserInterfaceTests {
    private Scanner reader;
    private UserInterface ui;
    private Workout workout;

    // okay we're going to have to remember how to allow for pre written inputs for tests
    // cause this isn't going to work if i have to input everything for each test

    @BeforeEach
    public void test() {
        workout = new Workout("A", new Date(01,10,2018));


    }

    @Test
    public void testAddResistanceThrowTooHeavy() {

        String input ="name\n" +
                "2000\n" + "3\n" + "12\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {

        } catch (TooManySetsException e) {
            fail("threw wrong exception");
        } catch (TooManyRepsException e) {
            fail("threw wrong exception");
        } catch (NumberFormatException e) {
            fail("threw wrong exception");
        }


    }

    @Test
    public void testAddResistanceThrowTooManySets() {
        String input ="name\n" +
                "225\n" + "500\n" + "12\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {
            fail("threw wrong exception");
        } catch (TooManySetsException e) {

        } catch (TooManyRepsException e) {
            fail("threw wrong exception");
        } catch (NumberFormatException e) {
            fail("threw wrong exception");
        }

    }

    @Test
    public void testAddResistanceThrowTooManyReps() {
        String input ="name\n" +
                "225\n" + "3\n" + "500\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {
            fail("threw wrong exception");
        } catch (TooManySetsException e) {
            fail("threw wrong exception");
        } catch (TooManyRepsException e) {

        } catch (NumberFormatException e) {
            fail("threw wrong exception");
        }

    }

    @Test
    public void testAddResistanceThrowNumberFormatExceptionOnWeight() {
        String input ="name\n" +
                "spaghetti\n" + "3\n" + "12\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {
            fail("threw wrong exception");
        } catch (TooManySetsException e) {
            fail("threw wrong exception");
        } catch (TooManyRepsException e) {
            fail("threw wrong exception");
        } catch (NumberFormatException e) {

        }

    }

    @Test
    public void testAddResistanceThrowNumberFormatExceptionOnSets() {
        String input ="name\n" +
                "225\n" + "spaghetti\n" + "12\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {
            fail("threw wrong exception");
        } catch (TooManySetsException e) {
            fail("threw wrong exception");
        } catch (TooManyRepsException e) {
            fail("threw wrong exception");
        } catch (NumberFormatException e) {

        }

    }

    @Test
    public void testAddResistanceThrowNumberFormatExceptionOnReps() {
        String input ="name\n" +
                "225\n" + "3\n" + "spaghetti\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);
            fail("Didn't throw exception");
        } catch (TooHeavyException e) {
            fail("threw wrong exception");
        } catch (TooManySetsException e) {
            fail("threw wrong exception");
        } catch (TooManyRepsException e) {
            fail("threw wrong exception");
        } catch (NumberFormatException e) {

        }

    }

    @Test
    public void testAddResistanceNoneThrown() {
        String input ="name\n" +
                "225\n" + "3\n" + "12\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addResistanceExerciseToWorkout(workout);

        } catch (TooHeavyException e) {
            fail("threw exception");
        } catch (TooManySetsException e) {
            fail("threw exception");
        } catch (TooManyRepsException e) {
            fail("threw exception");
        } catch (NumberFormatException e) {
            fail("threw exception");

        }

    }

    @Test
    public void testAddCardioTooLong() {
        String input ="name\n" +
                "1000\n" + "low\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addCardioExerciseToWorkout(workout);
            fail("No exception thrown");
        } catch (TooMuchTimeException e) {

        } catch (NumberFormatException e) {
            fail("threw wrong exception");
        }



    }

    @Test
    public void testAddCardioNumberFormatException() {
        String input ="name\n" +
                "spaghetti\n" + "low\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addCardioExerciseToWorkout(workout);
            fail("No exception thrown");
        } catch (TooMuchTimeException e) {
            fail("wrong exception thrown");
        } catch (NumberFormatException e) {

        }

    }

    @Test
    public void testAddCardioNoneThrown() {
        String input ="name\n" +
                "20\n" + "low\n";
        reader = new Scanner(input);
        UserInterface ui = new UserInterface(reader);
        try {
            ui.addCardioExerciseToWorkout(workout);

        } catch (TooMuchTimeException e) {
            fail("exception thrown");
        } catch (NumberFormatException e) {
            fail("exception thrown");
        }

    }



}
