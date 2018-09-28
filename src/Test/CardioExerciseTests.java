package Test;

import logbook.CardioExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardioExerciseTests {
    private CardioExercise e;

    @BeforeEach
    public void setup() {
        e = new CardioExercise("Running", 20, "low");
    }

    @Test
    public void testConstructor() {
        assertTrue(e.getName().equals("Running"));
        assertTrue(e.getDuration() == 20);
        assertTrue(e.getIntensity().equals("low"));
    }

    @Test
    public void testToString() {
        String desiredOutput = "Running: 20 mins (low)";

        assertEquals(e.toString(), desiredOutput);
    }

    @Test
    public void testReturnStringForSaving() {
        String desiredOutput = "Cardio: Running 20 low";

        assertEquals(e.returnStringForSaving(), desiredOutput);
    }


}
