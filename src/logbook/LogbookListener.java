package logbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogbookListener implements ActionListener {
    private Logbook logbook;
    private JTextArea input;

    public LogbookListener(Logbook logbook, JTextArea input) {
        this.logbook = logbook;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
