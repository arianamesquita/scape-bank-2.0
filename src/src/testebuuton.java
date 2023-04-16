import MainScreen.Components.JbuttonCustom.Jbutton;
import MainScreen.Components.JbuttonCustom.JbuttonOutLine;

import javax.swing.*;
import java.awt.*;

public class testebuuton {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
/*        JbuttonOutLine b = new JbuttonOutLine(0,0,100,50);*/

/*        b.setBackground(Color.darkGray);
        b.setText("um botão");
        b.setForeground(Color.CYAN);
        b.setVisible(true);*/
        Jbutton jbutton = new Jbutton();
        jbutton.setBounds(0, 0, 100, 40);
        jbutton.setVisible(true);

        frame.add(jbutton);
        frame.setVisible(true);
    }
}
