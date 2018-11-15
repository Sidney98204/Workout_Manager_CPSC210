package logbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JustAnActionListener implements ActionListener {
    private JPanel jpanel1, jpanel2;
    private JFrame jframe;
    private JButton jbutton1, jbutton2;


    public JustAnActionListener(JFrame frame, JPanel panel1, JPanel panel2, JButton button1, JButton button2) {

       jpanel1 = panel1;
       jpanel2 = panel2;
       jframe = frame;
       jbutton1 = button1;
       jbutton2 = button2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == jbutton1) {
            jframe.remove(jpanel1);
            jframe.setContentPane(jpanel2);
        } else if (button == jbutton2) {
            jframe.remove(jpanel2);
            jframe.setContentPane(jpanel1);
        }

        jframe.validate();
        jframe.repaint();


    }
}
