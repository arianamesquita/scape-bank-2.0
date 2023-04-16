import MainScreen.Components.CustomJTextField.JtextField;

import javax.swing.*;
import java.awt.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class testebuuton {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(frame.getMaximumSize());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setResizable(false);

        JtextField jtxt = new JtextField();
        jtxt.setBounds(200,200,300,60);
        jtxt.setText("sóvai");
        jtxt.setBackground(Color.darkGray);
        jtxt.setForeground(Color.white);
        jtxt.setVisible(true);

        frame.add(jtxt);

        frame.setVisible(true);
    }
}
