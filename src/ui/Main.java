package ui;


import logbook.CardioExercise;
import logbook.Exercise;
import logbook.ResistanceExercise;
import logbook.Workout;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static logbook.Intensity.LOW;


public class Main {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        //   SwingUtilities.invokeLater(ui);


        ui.start();




     /*   List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));

      *//*  PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add("Trey Coordinator");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Name: " + partsOfLine.get(0) + " ");
            System.out.println("Role: " + partsOfLine.get(1));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.*/
    }


    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }





}



