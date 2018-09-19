package ui;

import workout.Exercise;
import workout.Workout;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Scanner reader;
    private Workout workout;


    public UserInterface() {
        reader = new Scanner(System.in);
        workout = new Workout();
    }

    public void start() {
        printIntro();
        String input;
        while (true) {
            System.out.println("What would you like to do?");
            printFunctionalities();
            input = reader.nextLine();
            if (input.equals("1")) {
                System.out.println("Name:");
                String name = reader.nextLine();
                System.out.println("Weight:");
                int weight = Integer.parseInt(reader.nextLine());
                System.out.println("Sets:");
                int sets = Integer.parseInt(reader.nextLine());
                System.out.println("Reps:");
                int reps = Integer.parseInt(reader.nextLine());
                workout.addExercise(new Exercise(name, weight, sets, reps));

            } else if (input.equals("2")) {
                System.out.println("Enter name of exercise:");
                String name = reader.nextLine();
                Exercise exercise = workout.searchExercise(name);
                System.out.println(exercise);
            } else if (input.equals("3")) {
                workout.printWorkout();
            } else if (input.equals("quit")) {
                break;

            } else {

            }


        }
        System.out.println("Thanks for using LogBook!");

    }

    public void printIntro() {
        System.out.println("Welcome to LogBook!");

    }

    public void printFunctionalities() {
        System.out.println("[1] Add Exercise");
        System.out.println("[2] Search for Exercise");
        System.out.println("[3] Print All Exercises");
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
