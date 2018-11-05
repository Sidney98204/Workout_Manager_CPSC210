package logbook;

public class CardioExercise extends Exercise {

    private int duration;
    private String intensity;
    // make it so that intensity can only be low, med, high


    // REQUIRES: name does not include spaces and intensity do not include spaces
    public CardioExercise(String name, int duration, String intensity) {
        super(name);
        this.duration = duration;
        this.intensity = intensity;

    }

    @Override
    public String getName() {
        return this.name;
    }


    public int getDuration() {
        return duration;
    }


    public String getIntensity() {
        return intensity;
    }


    // EFFECTS: converts string representation of CardioExercise to something intelligible and returns it
    public String toString() {
        return this.name + ": " + duration + " mins (" + intensity + ")";
    }


    // EFFECTS: converts string representation of CardioExercise to something intelligible and returns it
    public String returnStringForSaving() {
        return "Cardio: " + this.name + " " + this.duration + " " + this.intensity;
    }
}
