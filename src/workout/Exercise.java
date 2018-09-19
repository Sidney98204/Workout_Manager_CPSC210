package workout;

// abstraction of a single exercise (e.g squats, deadlifts, etc.)

public class Exercise {
    private String name;
    private int reps;
    private int weight;
    private int sets;

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: creates new exercise object w/ given parameters
    public Exercise(String name, int weight, int sets, int reps) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.sets = sets;


    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: converts String representation of Exercise objects to something intelligible
    public String toString() {

        return this.name + "(" + this.weight + " lbs)" + ", " + this.sets + " sets " + this.reps + " reps";
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns name of this

    public String getName() {
        return name;
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
