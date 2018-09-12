package ui;



import workout.Exercise;
import workout.Workout;

import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);

        Exercise e = new Exercise("Squat", 225, 3, 12);
        System.out.println(e);


        Exercise searched;
        Workout workout = new Workout();
        workout.addExercise(e);
        workout.addExercise(new Exercise("Bench Press", 185, 3, 12));
        searched = workout.searchExercise("Squat");
        System.out.println(searched);
    }


}
