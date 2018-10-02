package logbook;

public class CardioExercise extends Exercise {

    private int duration;
    private String intensity;
    //private Intensity intensity;


    // REQUIRES: name does not include spaces and intensity do not include spaces
    // MODIFIES:
    // EFFECTS:
    public CardioExercise(String name, int duration, String intensity) {
        super(name);
        this.duration = duration;
        this.intensity = intensity;

    }

    @Override
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns name
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns duration
    public int getDuration() {
        return duration;
    }

    // EFFECTS: returns intensity
    public String getIntensity() {
        return intensity;
    }


    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts string representation of CardioExercise to something intelligible and returns it
    public String toString() {
        return this.name + ": " + duration + " mins (" + intensity + ")";
    }


    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts string representation of CardioExercise to something intelligible and returns it
    public String returnStringForSaving() {
        return "Cardio: " + this.name + " " + this.duration + " " + this.intensity;
    }
}
