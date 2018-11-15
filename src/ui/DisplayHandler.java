package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayHandler implements ActionListener {
    private JFrame frame;
    private JPanel startPanel, workoutPanel, rvcPanel, resPanel, cardioPanel, searchPanel;
    private JButton createNewWorkout, removeWorkout, searchForWorkout,searchForExercise, quit,
    addExercise, searchForExerciseInWorkout, removeExercise, printWorkout, done,
            r, c, addResistanceExercise, addCardioExercise;

    public DisplayHandler() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
