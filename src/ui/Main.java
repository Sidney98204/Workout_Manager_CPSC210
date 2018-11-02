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


    }

}



