package ui;

import Exceptions.TooHeavyException;
import Exceptions.TooManyRepsException;
import Exceptions.TooManySetsException;
import Exceptions.TooMuchTimeException;
import logbook.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Scanner reader;
    private Logbook logbook;

    public static final int MAX_WEIGHT = 1000;
    public static final int MAX_SETS = 20;
    public static final int MAX_REPS = 100;
    public static final int MAX_TIME = 300;

    // max weight,sets etc constants


    public UserInterface() {
        reader = new Scanner(System.in);

        logbook = new Logbook();
    }

    public UserInterface(Scanner reader) {
        this.reader = reader;
        logbook = new Logbook();

        // THIS CONSTRUCTOR IS FOR TESTING
    }

    public void start() throws IOException {
        printIntro();
        logbook.load();
        String input;

        while (true) {
            System.out.println("What would you like to do?");
            printstartFunctionalities();
            input = reader.nextLine();
            if (input.equals("1")) {
                Workout workout = createNewWorkout();
                while (true) {
                    printWorkoutFunctionalities();
                    input = reader.nextLine();
                    if (input.equals("1")) {                         // hey this is kinda dangerous
                        System.out.println("Specify type: [r for Resistance, c for Cardio]");
                        input = reader.nextLine();
                        if (input.equals("r")) {
                            try {
                                addResistanceExerciseToWorkout(workout);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid entry");
                            } catch (TooHeavyException e) {
                                System.out.println("That's too heavy!");
                            } catch (TooManySetsException e) {
                                System.out.println("That's too many sets!");
                            } catch (TooManyRepsException e) {
                                System.out.println("That's too many reps!");
                            }


                        } else if (input.equals("c")) {
                            try {
                                addCardioExerciseToWorkout(workout);
                            } catch (TooMuchTimeException e) {
                                System.out.println("That's for too long!");

                            } catch (NumberFormatException e) {
                                System.out.println("Invalid entry");

                            }


                        } else {
                            System.out.println("Invalid exercise type, try again");
                        }

                    } else if (input.equals("2")) {
                        searchExerciseFromWorkout(workout);


                    } else if (input.equals("3")) {
                        removeExerciseFromWorkout(workout);


                    } else if (input.equals("4")) {
                        workout.printWorkout();

                    } else if (input.equals("x")) {

                        logbook.addWorkout(workout);         // NOTE: you should be adding workouts in
                        break;                                // chronological order
                    }
                }


            } else if (input.equals("2")) {
                removeWorkoutFromLogbook();

            } else if (input.equals("3")) {
                searchForWorkoutInLogbook();


            } else if (input.equals("4")) {
                searchExerciseInLogbook();

            } else if (input.equals("x")) {
                System.out.println("Would you like to save your changes?");
                input = reader.nextLine();
                if (input.equals("yes")) {
                    try {
                        logbook.save();
                    } catch(Exception e) {

                    }
                } else {

                }
                break;

            } else {

            }


        }
        System.out.println("Thanks for using LogBook!");

    }

    public void printIntro() {
        System.out.println("Welcome to LogBook!");

    }

    public void printstartFunctionalities() {
        printOption("1", "Create new workout");
        printOption("2", "Remove workout");
        printOption("3", "Search for workout");
        printOption("4", "Search for exercise");
        printOption("x", "Quit");


        // COUPLINGGG!!!
        // I changed this from simple sout calls to method calls

    }

    public ArrayList<String> getStartingOptionsList() {
        ArrayList optionsList = new ArrayList<>();
        optionsList.add("1");
        optionsList.add("2");
        optionsList.add("3");
        optionsList.add("4");
        optionsList.add("x");

        return optionsList;
    }

    public ArrayList<String> getStartingInstructionsList() {
        ArrayList instructionsList = new ArrayList<>();
        instructionsList.add("Create new workout");
        instructionsList.add("Remove workout");
        instructionsList.add("Search for workout");
        instructionsList.add("Search for exercise");
        instructionsList.add("Quit");

        return instructionsList;

    }

    public void printWorkoutFunctionalities() {
        printOption("1", "Add exercise");
        printOption("2", "Search for exercise");
        printOption("3", "Remove exercise");
        printOption("4", "Print workout");
        printOption("x", "Done");


        // COUPLINGGGGGGG!!!!!
        // abstracted into method
    }

    public ArrayList<String> getWorkoutOptionsList() {
        ArrayList optionsList = new ArrayList<>();
        optionsList.add("1");
        optionsList.add("2");
        optionsList.add("3");
        optionsList.add("4");
        optionsList.add("x");

        return optionsList;

    }

    public ArrayList<String> getWorkoutInstructionsList() {
        ArrayList instructionsList = new ArrayList<>();
        instructionsList.add("Add exercise");
        instructionsList.add("Search for exercise");
        instructionsList.add("Remove exercise");
        instructionsList.add("Print workout");
        instructionsList.add("Quit");

        return instructionsList;
    }

    public void run() {
        frame = new JFrame("Logbook");
        frame.setPreferredSize(new Dimension(1000  ,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    public void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,3);
        container.setLayout(layout);
        JLabel jlabel1 = new JLabel("");
        JLabel jlabel2 = new JLabel("");
        JLabel jlabel3 = new JLabel("");
        JLabel jlabel4 = new JLabel("");
        JLabel jlabel5 = new JLabel("");
        JLabel jlabel6 = new JLabel("");
        JLabel jlabel7 = new JLabel("");
        JLabel jlabel8 = new JLabel("");
        JLabel jlabel9 = new JLabel("");
        container.add(jlabel1);
        container.add(jlabel2);
        container.add(jlabel3);
        container.add(jlabel4);


        JTextArea options = new JTextArea(returnOptionString(getStartingOptionsList(),getStartingInstructionsList()));
        container.add(options);

        container.add(jlabel6);
        JTextArea input = new JTextArea("");
        container.add(input);
        container.add(jlabel8);
        JButton button = new JButton("Enter");
        button.addActionListener(new LogbookListener(logbook, input ));
        container.add(button);



    }

    //EFFECTS: prompts user for name and date of workout, then creates workout object and returns it
    public Workout createNewWorkout() {
        String workoutName = askUserToProvideInfoToCreate("Name");   // removed duplication here
        System.out.println("Date: (DD/MM/YYYY)");
        String workoutDate = reader.nextLine();
        Workout workout = new Workout(workoutName, workoutDate);
        return workout;
    }


    // EFFECTS: prompts user for exercise info, then adds instantiated exercise to workout
    public void addResistanceExerciseToWorkout(Workout workout) throws TooHeavyException, TooManySetsException,
    TooManyRepsException{

        String name = askUserToProvideInfoToCreate("Name");          // removed duplication here

        int weight = Integer.parseInt(askUserToProvideInfoToCreate("Weight"));
        if (weight > MAX_WEIGHT) {
            throw new TooHeavyException();
        }

        int sets = Integer.parseInt(askUserToProvideInfoToCreate("Sets"));
        if (sets > MAX_SETS) {
            throw new TooManySetsException();
        }

        int reps = Integer.parseInt(askUserToProvideInfoToCreate("Reps"));
        if (reps > MAX_REPS) {
            throw new TooManyRepsException();
        }
        workout.addExercise(new ResistanceExercise(name, weight, sets, reps));
    }

    // EFFECTS:
    public void addCardioExerciseToWorkout(Workout workout) throws TooMuchTimeException {

        String name = askUserToProvideInfoToCreate("Name");              // removed duplication here

        int duration = Integer.parseInt(askUserToProvideInfoToCreate("Duration"));
        if (duration > MAX_TIME) {
            throw new TooMuchTimeException();
        }

        String intensity = askUserToProvideInfoToCreate("Intensity");
        workout.addExercise(new CardioExercise(name, duration, intensity));
    }

    public void searchExerciseFromWorkout(Workout workout) {

        String name = askUserForNameOfToSearch("exercise");
        Exercise exercise = workout.searchExercise(name);
        System.out.println(exercise);

    }

    public void removeExerciseFromWorkout(Workout workout) {

        String name = askUserForNameOfToSearch("exercise");
        Exercise exercise = workout.searchExercise(name);
        workout.removeExercise(exercise);
    }

    public void removeWorkoutFromLogbook() {

        String workoutName = askUserForNameOfToSearch("workout");
        Workout workout = logbook.searchWorkout(workoutName);
        logbook.removeWorkout(workout);
    }

    public void searchForWorkoutInLogbook() {

        String workoutName = askUserForNameOfToSearch("workout");
        Workout workout = logbook.searchWorkout(workoutName);
        System.out.println(workout);
    }

    public void searchExerciseInLogbook() {
        String exerciseName = askUserForNameOfToSearch("exercise");
        Exercise exercise = null;
        for (int i = logbook.getSize() -1; i >= 0; i--) {
            Workout workout = logbook.getLogbook().get(i);
            exercise = workout.searchExercise(exerciseName);
            if (exercise != null) {
                break;
            }
        }
        System.out.println(exercise);
    }

    public String askUserToProvideInfoToCreate(String forWhat) {
        System.out.println(forWhat + ": ");
        return askUserForInput();
    }

    public String askUserForNameOfToSearch(String object) {
        System.out.println("Enter name of " + object + ": ");
        return askUserForInput();

    }

    public String askUserForInput() {
        String input = reader.nextLine();
        return input;
    }

    public void printOption(String option, String instruction) {
        System.out.println("[" + option + "] " + instruction);

        // i abstracted into a method for the printFunctionalities
    }

    public String returnOptionString(ArrayList<String> options, ArrayList<String> instructions) {
        String listOfOptions = "";
        for (int i = 0; i < options.size(); i++) {
            listOfOptions += "[" + options.get(i) + "] " + instructions.get(i) + "\n";
        }

        return listOfOptions;
    }





}
