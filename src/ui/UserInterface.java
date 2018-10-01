package ui;

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
    private Workout workout;
    private Logbook logbook;


    public UserInterface() {
        reader = new Scanner(System.in);
        workout = new Workout();    // gonna remove this when we figure out how to save
        logbook = new Logbook();
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
                System.out.println("Name: ");
                String workoutName = reader.nextLine();
                System.out.println("Date: (DD/MM/YYYY)");
                String workoutDate = reader.nextLine();
                Workout workout = new Workout(workoutName, workoutDate);            // name and date!!!

                while (true) {
                    printWorkoutFunctionalities();
                    input = reader.nextLine();
                    if (input.equals("1")) {                         // hey this is kinda dangerous
                        System.out.println("Specify type:");
                        input = reader.nextLine();
                        if (input.equals("r")) {
                            System.out.println("Name:");
                            String name = reader.nextLine();
                            System.out.println("Weight:");
                            int weight = Integer.parseInt(reader.nextLine());
                            System.out.println("Sets:");
                            int sets = Integer.parseInt(reader.nextLine());
                            System.out.println("Reps:");
                            int reps = Integer.parseInt(reader.nextLine());
                            workout.addExercise(new ResistanceExercise(name, weight, sets, reps));
                        } else if (input.equals("c")) {
                            System.out.println("Name: ");
                            String name = reader.nextLine();
                            System.out.println("Duration:");
                            int duration = Integer.parseInt(reader.nextLine());
                            System.out.println("Intensity:");
                            String intensity = reader.nextLine();
                            workout.addExercise(new CardioExercise(name, duration, intensity));
                        }

                    } else if (input.equals("2")) {
                        System.out.println("Enter name of exercise: ");
                        String name = reader.nextLine();
                        Exercise exercise = workout.searchExercise(name);
                        System.out.println(exercise);

                    } else if (input.equals("3")) {
                        System.out.println("Enter name of exercise: ");
                        String name = reader.nextLine();
                        Exercise exercise = workout.searchExercise(name);
                        workout.removeExercise(exercise);

                    } else if (input.equals("4")) {
                        workout.printWorkout();

                    } else if (input.equals("x")) {

                        logbook.addWorkout(workout);         // NOTE: you should be adding workouts in
                        break;                                // chronological order
                    }
                }




            } else if (input.equals("2")) {
                System.out.println("Enter name of workout: ");
                String workoutName = reader.nextLine();
                Workout workout = logbook.searchWorkout(workoutName);
                logbook.removeWorkout(workout);
            }
            else if (input.equals("3")) {
                System.out.println("Enter name of workout: ");
                String workoutName = reader.nextLine();
                Workout workout = logbook.searchWorkout(workoutName);
                workout.printWorkout();


            } else if (input.equals("4")) {
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

        System.out.println("[1] Create new workout");
        System.out.println("[2] Remove workout");
        System.out.println("[3] Search for workout");
        System.out.println("[4] Search for exercise");
        System.out.println("[x] Quit");




    }

    public void printWorkoutFunctionalities() {
        System.out.println("[1] Add exercise");
        System.out.println("[2] Search for exercise");
        System.out.println("[3] Remove exercise");
        System.out.println("[4] Print workout");
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





}
