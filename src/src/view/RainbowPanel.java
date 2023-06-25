package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class RainbowPanel extends JPanel {

    private static final List<Color> RAINBOW_COLORS = Arrays.asList(
            new Color(0xFF0018), // Vermelho
            new Color(0xFFA52C), // Laranja
            new Color(0xFFFF00), // Amarelo
            new Color(0x008018), // Verde
            new Color(0x0000F9), // Azul
            new Color(0xA000C8)  // Roxo
    );

    private static final String TEXT = "Scape Bank \n de um scape na burocracia!!";

    public RainbowPanel() {
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10;
        int y = getHeight() / 2;

        Font font = new Font("Arial", Font.BOLD, 30);
        FontMetrics fontMetrics = g.getFontMetrics(font);

        String[] lines = TEXT.split("\n");

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                String letter = String.valueOf(c);

                int colorIndex = i % RAINBOW_COLORS.size();
                Color color = RAINBOW_COLORS.get(colorIndex);

                g.setColor(color);
                g.setFont(font);

                int letterWidth = fontMetrics.stringWidth(letter);
                g.drawString(letter, x, y);

                x += letterWidth;
            }

            x = 10;
            y += fontMetrics.getHeight();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rainbow Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            RainbowPanel panel = new RainbowPanel();
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
