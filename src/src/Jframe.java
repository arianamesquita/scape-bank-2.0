import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Jframe extends JFrame {

    private JPanel contentPane;
    /**
     * Launch the application.
     */

    public Jframe(){

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\AULAS_POO (2)\\scapebank2\\src\\src\\Cosmic Fusion.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    }