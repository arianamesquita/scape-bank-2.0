import MainScreen.Components.CustomJframe.Jframe;

import javax.swing.*;
import java.awt.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class teste1 {
    JTextField texto;
    public teste1() {

    }
    public static void main(String args[]){
        Jframe frame;
        frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(frame.getMaximumSize());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setResizable(false);


    }
}


