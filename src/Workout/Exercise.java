package Workout;

public class Exercise {
    private String name;
    private int reps;
    private int weight;
    private int sets;

    public Exercise(String name, int reps, int weight, int sets) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.sets = sets;


    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
