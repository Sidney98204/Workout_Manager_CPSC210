package logbook;


public class ResistanceExercise extends Exercise {
    private int reps;
    private int weight;
    private int sets;

    // REQUIRES: NAME DOES NOT CONTAIN SPACES!!! Otherwise it will be loaded improperly
    // MODIFIES: this
    // EFFECTS: creates new exercise object w/ given parameters
    public ResistanceExercise(String name, int weight, int sets, int reps) {
        super(name);
        this.reps = reps;
        this.weight = weight;
        this.sets = sets;


    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts String representation of ResistanceExercise objects to something intelligible
    public String toString() {

        return this.name + " (" + this.weight + " lbs)" + ", " + this.sets + " sets " + this.reps + " reps";
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns intelligible string representation of this
    public String returnStringForSaving() {
        return "Resistance: " + this.name + " " + this.weight + " " + this.sets + " " + this.reps;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns name of this

    public String getName() {
        return this.name;
    }
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns reps of this

    public int getReps() {
        return reps;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns weight of this
    public int getWeight() {
        return weight;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns sets of this
    public int getSets() {
        return sets;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sets this.name to name
    public void setName(String name) {
        this.name = name;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sets this.reps to reps
    public void setReps(int reps) {
        this.reps = reps;
    }

    // REQUIRES:
    // MODIFIES:this
    // EFFECTS: sets this.weight to weight
    public void setWeight(int weight) {
        this.weight = weight;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: sets this.sets to sets
    public void setSets(int sets) {
        this.sets = sets;
    }
}
