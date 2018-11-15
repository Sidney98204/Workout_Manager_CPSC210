package ui;

import logbook.Logbook;
import logbook.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayHandler implements ActionListener {
    private Logbook logbook;
    private JFrame frame;
    private JPanel startPanel, optionsPanelInStart, workoutPanel,
            nameAndDate, rvcPanel, resPanel, cardioPanel, searchPanel;
    private JButton createNewWorkout, removeWorkout, searchForWorkout,searchForExercise, quit,
    addExercise, searchForExerciseInWorkout, removeExercise, printWorkout, done,
            r, c, addResistanceExercise, addCardioExercise, createWorkout;
    private JLabel logbookHeader, bottomDisplay, name, date;
    private JTextArea inputName, inputDate, inputWeight, inputSets, inputReps, inputTime, inputIntensity;

    public DisplayHandler(Logbook logbook) {
        this.logbook = logbook;

        frame = new JFrame("Logbook");
        frame.setPreferredSize(new Dimension(1000  ,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        createComponents(frame.getContentPane());

        startPanel = new JPanel();         // create start panel
        startPanel.setLayout(new BorderLayout());

        logbookHeader = new JLabel("Logbook");    // create header and add to start panel
        logbookHeader.setHorizontalAlignment(JTextField.CENTER);
        logbookHeader.setBackground(Color.yellow);
        logbookHeader.setOpaque(true);
        startPanel.add(logbookHeader, BorderLayout.NORTH);


        optionsPanelInStart = new JPanel();          // create middle options panel and things that will go inside
        optionsPanelInStart.setLayout(new FlowLayout());
        createNewWorkout = new JButton("Create new workout");
        removeWorkout = new JButton("Remove workout");
        searchForWorkout = new JButton("Search for workout");
        searchForExercise = new JButton("Search for exercise");
        quit = new JButton("Quit");

        createNewWorkout.addActionListener(this); // action listeners to all buttons
        removeWorkout.addActionListener(this);
        searchForWorkout.addActionListener(this);
        searchForExercise.addActionListener(this);
        quit.addActionListener(this);

        optionsPanelInStart.add(createNewWorkout);  // add each button to optionsPanel
        optionsPanelInStart.add(removeWorkout);
        optionsPanelInStart.add(searchForWorkout);
        optionsPanelInStart.add(searchForExercise);
        optionsPanelInStart.add(quit);

        startPanel.add(optionsPanelInStart, BorderLayout.CENTER); // put options in middle of startpanel

        bottomDisplay = new JLabel("swiggity swoot");  // adding bottomdisplay
        startPanel.add(bottomDisplay, BorderLayout.SOUTH);
        bottomDisplay.setBackground(Color.CYAN);
        bottomDisplay.setOpaque(true);

        nameAndDate = new JPanel();            // name and date panel
        name = new JLabel("Name: ");
        date = new JLabel("Date: ");
        inputName = new JTextArea();
        inputDate = new JTextArea();
        createWorkout = new JButton("Create workout");
        nameAndDate.setLayout(new GridLayout(3,2)); // change this to gridbaglayout after
        nameAndDate.add(name);
        nameAndDate.add(inputName);
        nameAndDate.add(date);
        nameAndDate.add(inputDate);
        nameAndDate.add(new JLabel());
        nameAndDate.add(createWorkout);

        










        frame.setContentPane(startPanel);
        frame.pack();
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create new workout")) {
            frame.remove(startPanel);
            frame.setContentPane(nameAndDate);
        } else if (e.getActionCommand().equals("Create workout")) {
            Workout workout = new Workout(inputName.getText(), inputDate.getText());
            logbook.addWorkout(workout);
            removeAndSet(nameAndDate, workoutPanel);

        }

        frame.validate();
        frame.repaint();

    }

    public void removeAndSet(JPanel remove, JPanel set) {
        frame.remove(remove);
        frame.setContentPane(set);
    }
}
