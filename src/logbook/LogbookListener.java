package logbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogbookListener implements ActionListener {
    private Logbook logbook;
    private JTextArea input;
    private JTextArea prompt;
    private Boolean inWorkout;

    public LogbookListener(Logbook logbook, JTextArea input, JTextArea prompt) {
        this.logbook = logbook;
        this.input = input;
        this.prompt = prompt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputted = input.getText();
        if (inputted.equals("1") && inWorkout) {
            input.setText("");


        }

    }
}
