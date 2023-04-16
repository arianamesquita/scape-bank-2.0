package AccessScreen.CustomJframe;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Jframe extends JFrame {

    public Jframe(){

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("gradient2.png")).toURI()));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
    
}