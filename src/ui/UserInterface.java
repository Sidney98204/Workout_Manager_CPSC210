package ui;

import Exceptions.TooHeavyException;
import Exceptions.TooManyRepsException;
import Exceptions.TooManySetsException;
import Exceptions.TooMuchTimeException;
import com.sun.org.apache.xpath.internal.SourceTree;
import logbook.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Scanner reader;

    private Logbook logbook;
    private List<Person> persons;


    // max weight,sets etc constants


    public UserInterface() {
        reader = new Scanner(System.in);

        logbook = new Logbook();
        persons = new ArrayList<>();
    }

    public UserInterface(Scanner reader) {
        this.reader = reader;
        logbook = new Logbook();

        // THIS CONSTRUCTOR IS FOR TESTING
    }

    public void start() throws IOException {
        printIntro();
//        logbook.load();
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
                            } catch(NumberFormatException e) {
                                System.out.println("Invalid entry");
                            } catch(TooHeavyException e) {
                                System.out.println("That's too heavy!");
                            } catch(TooManySetsException e) {
                                System.out.println("That's too many sets!");
                            } catch(TooManyRepsException e) {
                                System.out.println("That's too many reps!");
                            }


                        } else if (input.equals("c")) {
                            try {
                                addCardioExerciseToWorkout(workout);
                            } catch(TooMuchTimeException e) {
                                System.out.println("That's for too long!");

                            } catch(NumberFormatException e) {
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

                        logbook.addWorkout(workout);
                        logbook.put(workout.getDate(), workout);                                        // NOTE: you should be adding workouts in
                        break;                                // chronological order
                    } else if (input.equals("p")) {
                        addPersonToWorkout(workout);
                    } else if (input.equals("6")) {
                        printPeople(workout);
                    }
                }




            } else if (input.equals("2")) {
//                removeWorkoutFromLogbook();

            }
            else if (input.equals("3")) {
                searchForWorkoutInLogbook();




            } else if (input.equals("4")) {
                searchExerciseInLogbook();


            } else if (input.equals("p")) {
                searchPerson();

            } else if(input.equals("person")) {
                addWorkoutToPerson();

            } else if (input.equals("a")) {
                removeWorkoutFromPerson();
            } else if (input.equals("b")) {
                removePersonFromWorkout();
            } else if (input.equals("x")) {
                System.out.println("Would you like to save your changes?");
                input = reader.nextLine();
                if (input.equals("yes")) {
                    try {
//                        logbook.save();
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

        System.out.println("[1] Create new workout");
        System.out.println("[2] Remove workout");
        System.out.println("[3] Search for workout");
        System.out.println("[4] Search for exercise");
        System.out.println("[person] Add workout to person");
        System.out.println("[p] Search for person and print their workouts");
        System.out.println("[a] Remove workout from person");
        System.out.println("[b] Remove person from workout");
        System.out.println("[x] Quit");




    }

    public void printWorkoutFunctionalities() {
        System.out.println("[1] Add exercise");
        System.out.println("[2] Search for exercise");
        System.out.println("[3] Remove exercise");
        System.out.println("[4] Print workout");
        System.out.println("[p] Add person to workout");
        System.out.println("[6] print people in workout");
        System.out.println("[x] Done");

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

    }

    //EFFECTS: prompts user for name and date of workout, then creates workout object and returns it
    public Workout createNewWorkout() {
        System.out.println("Name: ");
        String workoutName = reader.nextLine();
        System.out.println("Date: (DD/MM/YYYY)");
        String workoutDate = reader.nextLine();
        ArrayList<String> lines = splitOnSlash(workoutDate);
        Date date = new Date(Integer.parseInt(lines.get(0)),
                Integer.parseInt(lines.get(1)), Integer.parseInt(lines.get(2)));

        Workout workout = new Workout(workoutName, date);
        return workout;
    }


    // EFFECTS: prompts user for exercise info, then adds instantiated exercise to workout
    public void addResistanceExerciseToWorkout(Workout workout) throws TooHeavyException, TooManySetsException,
    TooManyRepsException{
        System.out.println("Name:");
        String name = reader.nextLine();
        System.out.println("Weight:");
        int weight = Integer.parseInt(reader.nextLine());
        if (weight > 1000) {
            throw new TooHeavyException();
        }
        System.out.println("Sets:");
        int sets = Integer.parseInt(reader.nextLine());
        if (sets > 20) {
            throw new TooManySetsException();
        }
        System.out.println("Reps:");
        int reps = Integer.parseInt(reader.nextLine());
        if (reps > 100) {
            throw new TooManyRepsException();
        }
        workout.addExercise(new ResistanceExercise(name, weight, sets, reps));
    }

    // EFFECTS:
    public void addCardioExerciseToWorkout(Workout workout) throws TooMuchTimeException {
        System.out.println("Name: ");
        String name = reader.nextLine();
        System.out.println("Duration:");
        int duration = Integer.parseInt(reader.nextLine());
        if (duration > 300) {
            throw new TooMuchTimeException();
        }
        System.out.println("Intensity:");
        String intensity = reader.nextLine();
        workout.addExercise(new CardioExercise(name, duration, intensity));
    }

    public void searchExerciseFromWorkout(Workout workout) {
        System.out.println("Enter name of exercise: ");
        String name = reader.nextLine();
        Exercise exercise = workout.searchExercise(name);
        System.out.println(exercise);

    }

    public void removeExerciseFromWorkout(Workout workout) {
        System.out.println("Enter name of exercise: ");
        String name = reader.nextLine();
        Exercise exercise = workout.searchExercise(name);
        workout.removeExercise(exercise);
    }

    /*public void removeWorkoutFromLogbook() {
        System.out.println("Enter name of workout: ");
        String workoutName = reader.nextLine();
        Workout workout = logbook.searchWorkout(workoutName);
        logbook.removeWorkout(workout);
    }*/

    /*public void searchForWorkoutInLogbook() {
        System.out.println("Enter name of workout: ");
        String workoutName = reader.nextLine();
        Workout workout = logbook.searchWorkout(workoutName);
        System.out.println(workout);
    }*/

    public void searchForWorkoutInLogbook() {
        System.out.println("Enter date of workout: ");
        String workoutDate = reader.nextLine();
        ArrayList<String> lines = splitOnSlash(workoutDate);
        int day = Integer.parseInt(lines.get(0));
        int month = Integer.parseInt(lines.get(1));
        int year = Integer.parseInt(lines.get(2));
        Workout workout = logbook.searchWorkout(new Date(day,month,year));
        workout.printWorkout();
        System.out.println(workout.getPeople());

    }

    public void searchExerciseInLogbook() {
        System.out.println("Enter name of exercise:");
        String exerciseName = reader.nextLine();
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

    public static ArrayList<String> splitOnSlash(String line) {
        String[] splits = line.split("/");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public void searchPerson() {
        System.out.println("Name? ");
        String name = reader.nextLine();
        for (Person p: persons) {
            if (p.getName().equals(name)) {
                System.out.println(p.getWorkouts());
            }
        }
    }

    public void addPersonToWorkout(Workout workout) {
        System.out.println("Name: ");
        String name = reader.nextLine();
        Person p = new Person(name);
        workout.addPerson(p);
        persons.add(p);

    }



    public void printPeople(Workout workout) {
        System.out.println(workout.getPeople());
    }

    public void addWorkoutToPerson() {
        System.out.println("Name of person:");
        String personName = reader.nextLine();
        Person p = new Person(personName);
        for (Person person: persons) {
            if (person.getName().equals(personName)) {
                p = person;
            }
        }



        System.out.println("Date of workout:");
        String workoutDate = reader.nextLine();
        ArrayList<String> lines = splitOnSlash(workoutDate);
        int day = Integer.parseInt(lines.get(0));
        int month = Integer.parseInt(lines.get(1));
        int year = Integer.parseInt(lines.get(2));
        Workout workout = logbook.searchWorkout(new Date(day,month,year));
        workout.addPerson(p);
        if (!persons.contains(p)) {
            persons.add(p);
        }


    }

    public void removeWorkoutFromPerson() {
        System.out.println("Name of person:");
        String personName = reader.nextLine();
        Person p = null;  // HEEEYYYYYYYY ITS NULLLLLLLL
        for (Person person: persons) {
            if (person.getName().equals(personName)) {
                p = person;
            }
        }

        System.out.println("Date of workout:");
        String workoutDate = reader.nextLine();
        ArrayList<String> lines = splitOnSlash(workoutDate);
        int day = Integer.parseInt(lines.get(0));
        int month = Integer.parseInt(lines.get(1));
        int year = Integer.parseInt(lines.get(2));
        Workout workout = logbook.searchWorkout(new Date(day,month,year));
        p.removeWorkout(workout);

    }

    public void removePersonFromWorkout() {
        System.out.println("Name of person:");
        String personName = reader.nextLine();
        Person p = null;  // HEEEYYYYYYYY ITS NULLLLLLLL
        for (Person person: persons) {
            if (person.getName().equals(personName)) {
                p = person;
            }
        }

        System.out.println("Date of workout:");
        String workoutDate = reader.nextLine();
        ArrayList<String> lines = splitOnSlash(workoutDate);
        int day = Integer.parseInt(lines.get(0));
        int month = Integer.parseInt(lines.get(1));
        int year = Integer.parseInt(lines.get(2));
        Workout workout = logbook.searchWorkout(new Date(day,month,year));
        workout.removePerson(p);

    }





}
