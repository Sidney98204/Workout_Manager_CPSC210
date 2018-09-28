package ui;

import com.sun.org.apache.xpath.internal.SourceTree;
import logbook.*;

import javax.swing.*;
import java.awt.*;
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


    public UserInterface() {
        reader = new Scanner(System.in);
        workout = new Workout();
    }

    public void start() throws IOException {
        printIntro();
        load();
        String input;

        while (true) {
            System.out.println("What would you like to do?");
            printFunctionalities();
            input = reader.nextLine();
            if (input.equals("1")) {
                System.out.println("Specify type:");
                input = reader.nextLine();
                if (input.equals("resistance")) {
                    System.out.println("Name:");
                    String name = reader.nextLine();
                    System.out.println("Weight:");
                    int weight = Integer.parseInt(reader.nextLine());
                    System.out.println("Sets:");
                    int sets = Integer.parseInt(reader.nextLine());
                    System.out.println("Reps:");
                    int reps = Integer.parseInt(reader.nextLine());
                    workout.addExercise(new ResistanceExercise(name, weight, sets, reps));
                } else if (input.equals("cardio")) {
                    System.out.println("Name: ");
                    String name = reader.nextLine();
                    System.out.println("Duration:");
                    int duration = Integer.parseInt(reader.nextLine());
                    System.out.println("Intensity:");
                    String intensity = reader.nextLine();
                    workout.addExercise(new CardioExercise(name, duration, intensity));
                }


            } else if (input.equals("2")) {
                System.out.println("Enter name of exercise:");
                String name = reader.nextLine();
                Exercise exercise = workout.searchExercise(name);
                System.out.println(exercise);
            } else if (input.equals("3")) {
                workout.printWorkout();
            } else if (input.equals("quit")) {
                System.out.println("Would you like to save your changes?");
                input = reader.nextLine();
                if (input.equals("yes")) {
                    try {
                        save();
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

    public void save() throws IOException {

        List<String> lines = workout.returnStringList();
        PrintWriter writer = new PrintWriter("savefile.text", "UTF-8");
        for (String line: lines) {
            writer.println(line);
        }
        writer.close();


    }

    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("savefile.text"));
        for (String line: lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (partsOfLine.get(0).equals("Cardio:")) {
                workout.addExercise(new CardioExercise(partsOfLine.get(1),
                        Integer.parseInt(partsOfLine.get(2)), partsOfLine.get(3)));
            } else if (partsOfLine.get(0).equals("Resistance:")) {
                workout.addExercise(new ResistanceExercise(partsOfLine.get(1),
                        Integer.parseInt(partsOfLine.get(2)),
                        Integer.parseInt(partsOfLine.get(3)),
                        Integer.parseInt(partsOfLine.get(4))));
            }

        }
    }
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
