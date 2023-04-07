import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Jframe extends JFrame {

    private JPanel contentPane;
    /**
     * Launch the application.
     */

    public Jframe(){

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("Cosmic Fusion.jpg")).toURI()));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }


    }