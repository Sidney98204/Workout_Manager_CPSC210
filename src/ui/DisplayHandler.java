package ui;

import logbook.*;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayHandler implements ActionListener {
    private Logbook logbook;
    private JFrame frame;
    private JPanel startPanel, optionsPanelInStart, workoutPanel, optionsPanelInWorkout,
            nameAndDate, rvcPanel, resPanel, cardioPanel, searchPanel, displayPanel, removePanel, searchForExercisePanel;
    private JButton createNewWorkout, removeWorkout, searchForWorkout,searchForExercise, quit,
    addExercise, searchForExerciseInWorkout, removeExercise, printWorkout, done, search,
            r, c, addResistanceExercise, addCardioExercise, createWorkout, back, removeButton, searchExerciseButton;
    private JLabel logbookHeader, logbookHeader2, bottomDisplay, name, date, name2, weight, reps, sets,
    name3, duration, intensity, name4, removeName, searchExerciseByName;
    private JTextArea inputName, inputDate, inputName2, inputWeight, inputSets, inputReps,
            inputName3, inputDuration, inputIntensity, inputName4, display, removeNameInput, searchExerciseByNameInput;
    private Workout currentWorkout;

    public DisplayHandler(Logbook logbook) {
        this.logbook = logbook;
        try {
            logbook.load();
//            PrintWriter pw = new PrintWriter("savefile.text");
//            pw.print("");
//            pw.close();
        } catch(Exception e) {
            bottomDisplay.setText("Unable to load file");
        }

        frame = new JFrame("Logbook");
        frame.setPreferredSize(new Dimension(500  ,500));
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
        createWorkout.addActionListener(this);

        nameAndDate.setLayout(new GridLayout(3,2)); // change this to gridbaglayout after
        nameAndDate.add(name);
        nameAndDate.add(inputName);
        nameAndDate.add(date);
        nameAndDate.add(inputDate);
        nameAndDate.add(new JLabel());
        nameAndDate.add(createWorkout);



        workoutPanel = new JPanel();               // workout panel
        workoutPanel.setLayout(new BorderLayout());

        logbookHeader2 = new JLabel("Logbook");
        logbookHeader2.setHorizontalAlignment(JLabel.CENTER);
        logbookHeader2.setBackground(Color.RED);
        logbookHeader2.setOpaque(true);
        workoutPanel.add(logbookHeader2, BorderLayout.NORTH);

        optionsPanelInWorkout = new JPanel();                      // options panel in workout making buttons
        optionsPanelInWorkout.setLayout(new FlowLayout());
        addExercise = new JButton("Add exercise");
        removeExercise = new JButton("Remove exercise");
        searchForExerciseInWorkout = new JButton("Search for exercise in workout");
        printWorkout = new JButton("Print workout");
        done = new JButton("Done");

        addExercise.addActionListener(this);            // adding listeners to each button
        removeExercise.addActionListener(this);
        searchForExerciseInWorkout.addActionListener(this);
        printWorkout.addActionListener(this);
        done.addActionListener(this);

        optionsPanelInWorkout.add(addExercise);          // adding each button to panel
        optionsPanelInWorkout.add(removeExercise);
        optionsPanelInWorkout.add(searchForExerciseInWorkout);   // eh do i really want this
        optionsPanelInWorkout.add(printWorkout);
        optionsPanelInWorkout.add(done);

        workoutPanel.add(optionsPanelInWorkout, BorderLayout.CENTER);  // added options panel to workout panel



        rvcPanel = new JPanel();                        // Choose resistance or cardio panel
        rvcPanel.setLayout(new FlowLayout());
        r = new JButton("Resistance");
        c = new JButton("Cardio");
        r.addActionListener(this);
        c.addActionListener(this);
        rvcPanel.add(r);
        rvcPanel.add(c);


        resPanel = new JPanel();                                   // resistance input panel
        resPanel.setLayout(new GridLayout(5, 2));

        name2 = new JLabel("Name: ");
        weight = new JLabel("Weight: ");
        sets = new JLabel("Sets: ");
        reps = new JLabel("Reps: ");
        inputName2 = new JTextArea();
        inputWeight = new JTextArea();
        inputSets = new JTextArea();
        inputReps = new JTextArea();

        addResistanceExercise = new JButton("Add resistance exercise");
        addResistanceExercise.addActionListener(this);

        resPanel.add(name2);
        resPanel.add(inputName2);
        resPanel.add(weight);
        resPanel.add(inputWeight);
        resPanel.add(sets);
        resPanel.add(inputSets);
        resPanel.add(reps);
        resPanel.add(inputReps);
        resPanel.add(new JLabel());
        resPanel.add(addResistanceExercise);





        cardioPanel = new JPanel();                             // cardio input panel
        cardioPanel.setLayout(new GridLayout(4, 2));

        name3 = new JLabel("Name: ");
        duration = new JLabel("Duration: ");
        intensity = new JLabel("Intensity: ");
        inputName3 = new JTextArea();
        inputDuration = new JTextArea();
        inputIntensity = new JTextArea();

        addCardioExercise = new JButton("Add cardio exercise");
        addCardioExercise.addActionListener(this);

        cardioPanel.add(name3);
        cardioPanel.add(inputName3);
        cardioPanel.add(duration);
        cardioPanel.add(inputDuration);
        cardioPanel.add(intensity);
        cardioPanel.add(inputIntensity);
        cardioPanel.add(new JLabel());            // ABORT BUTTON?!?!
        cardioPanel.add(addCardioExercise);



        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2,2));
        name4 = new JLabel("Name: ");
        inputName4 = new JTextArea();
        search = new JButton("Search");
        search.addActionListener(this);
        searchPanel.add(name4);
        searchPanel.add(inputName4);
        searchPanel.add(new JLabel());
        searchPanel.add(search);


        displayPanel = new JPanel();
        display = new JTextArea();
        back = new JButton("Back");
        back.addActionListener(this);
        displayPanel.add(display, BorderLayout.CENTER);
        displayPanel.add(back, BorderLayout.SOUTH);


        removePanel = new JPanel();
        removePanel.setLayout(new GridLayout(2,2));
        removeName = new JLabel("Name: ");
        removeNameInput = new JTextArea();
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        removePanel.add(removeName);
        removePanel.add(removeNameInput);
        removePanel.add(new JLabel());
        removePanel.add(removeButton);

        searchForExercisePanel = new JPanel();
        searchForExercisePanel.setLayout(new GridLayout(2,2));
        searchExerciseByName = new JLabel("Name of exercise: ");
        searchExerciseByNameInput = new JTextArea();
        searchExerciseButton = new JButton("Search exercise");
        searchExerciseButton.addActionListener(this);
        searchForExercisePanel.add(searchExerciseByName);
        searchForExercisePanel.add(searchExerciseByNameInput);
        searchForExercisePanel.add(new JLabel());
        searchForExercisePanel.add(searchExerciseButton);




































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
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(inputName);
            inputs.add(inputDate);
            Workout workout = new Workout(inputName.getText(), inputDate.getText());
            logbook.addWorkout(workout);
            clearInputs(inputs);
            removeAndSet(nameAndDate, workoutPanel);
        } else if (e.getActionCommand().equals("Add exercise")) {
            removeAndSet(workoutPanel, rvcPanel);

        } else if (e.getActionCommand().equals("Resistance")) {
            removeAndSet(rvcPanel, resPanel);
        } else if (e.getActionCommand().equals("Cardio")) {
            removeAndSet(rvcPanel, cardioPanel);
        } else if (e.getActionCommand().equals("Add resistance exercise")) {
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(inputName2);
            inputs.add(inputWeight);
            inputs.add(inputSets);
            inputs.add(inputReps);

            Workout workout = logbook.getLogbook().get(logbook.getSize()-1);
            workout.addExercise(new ResistanceExercise(inputName2.getText(),
                    Integer.parseInt(inputWeight.getText()), Integer.parseInt(inputSets.getText()),
                    Integer.parseInt(inputReps.getText())));   // HAVE TO DEAL WITH EXCEPTIONS

            clearInputs(inputs);
            removeAndSet(resPanel, workoutPanel);
        } else if (e.getActionCommand().equals("Add cardio exercise")) {
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(inputName3);
            inputs.add(inputDuration);
            inputs.add(inputIntensity);


            Workout workout = logbook.getLogbook().get(logbook.getSize()-1);
            workout.addExercise(new CardioExercise(inputName3.getText(), Integer.parseInt(inputDuration.getText()),
                    inputIntensity.getText()));           //  HAVE TO DEAL WITH EXCEPTIONS

            clearInputs(inputs);
            removeAndSet(cardioPanel, workoutPanel);
        } else if (e.getActionCommand().equals("Search for workout")) {
            removeAndSet(startPanel, searchPanel);


        } else if (e.getActionCommand().equals("Search")) {
            removeAndSet(searchPanel, displayPanel);
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(inputName4);
            Workout workout = logbook.searchWorkout(inputName4.getText());
            setWorkout(workout);
            clearInputs(inputs);
            display.setText(currentWorkout.toString());
        } else if (e.getActionCommand().equals("Done")) {
            removeAndSet(workoutPanel, startPanel);
        } else if (e.getActionCommand().equals("Back")) {
            removeAndSet(displayPanel, startPanel);

        } else if (e.getActionCommand().equals("Remove workout")) {
            removeAndSet(startPanel, removePanel);
        } else if (e.getActionCommand().equals("Remove")) {
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(removeNameInput);
            inputs.add(display);
            Workout workout = logbook.searchWorkout(removeNameInput.getText());
            logbook.removeWorkout(workout);
            clearInputs(inputs);
            removeAndSet(removePanel, startPanel);

        } else if (e.getActionCommand().equals("Search for exercise")) {
            removeAndSet(startPanel, searchForExercisePanel);

        } else if (e.getActionCommand().equals("Search exercise")) {
            Exercise exercise = logbook.searchForExercise(searchExerciseByNameInput.getText());
            ArrayList<JTextArea> inputs = new ArrayList<>();
            inputs.add(searchExerciseByNameInput);
            inputs.add(display);
            clearInputs(inputs);
            inputs.add(searchExerciseByNameInput);
            removeAndSet(searchForExercisePanel, displayPanel);
            display.setText(exercise.toString());

        } else if (e.getActionCommand().equals("Quit")) {
            try {
                logbook.save();
            } catch(Exception exception) {
                System.out.println("Save was unsuccessful");
            }
        }

        frame.validate();
        frame.repaint();

    }

    public void removeAndSet(JPanel remove, JPanel set) {
        frame.remove(remove);
        frame.setContentPane(set);
    }

    public void clearInputs(ArrayList<JTextArea> inputs) {
        for (JTextArea text: inputs) {
            text.setText("");
        }
    }

    public void setWorkout(Workout workout) {
        this.currentWorkout = workout;
    }

    public void fillInGridLayout() {

    }
}
