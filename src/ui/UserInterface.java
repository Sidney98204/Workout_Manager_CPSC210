package ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {
    private JFrame frame;


    public UserInterface() {
    }

    public void printIntro() {
        System.out.println("Welcome to LogBook!");

    }

    public void printFunctionalities() {
        System.out.println("[1] Create new workout");
        System.out.println("[2] Search for Exercise");
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
