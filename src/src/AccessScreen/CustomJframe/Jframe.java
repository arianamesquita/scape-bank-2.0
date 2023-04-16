package AccessScreen.CustomJframe;

import javax.swing.*;

import AccessScreen.Custom.ImageCustom.Images;

import java.awt.*;

public class Jframe extends JFrame {

    public Jframe(){

        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(Images.ImagemJframe(), 0, 0, null);
            }
        });

    }
    
}