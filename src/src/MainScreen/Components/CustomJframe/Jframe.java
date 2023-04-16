package MainScreen.Components.CustomJframe;

import MainScreen.Components.Custom.ImageCustom.ImageIcons;

import javax.swing.*;
import java.awt.*;

public class Jframe extends JFrame {

    public Jframe(){

        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(ImageIcons.ImagemJframe(), 0, 0, null);
            }
        });

    }
    
}