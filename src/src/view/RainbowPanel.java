package view;

import javax.swing.*;

import MainScreen.Components.Custom.ColorPaleta;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class RainbowPanel extends JPanel {

    private static final List<Color> RAINBOW_COLORS = Arrays.asList(
            ColorPaleta.buttonsColor()
          
    );

    private static final String TEXT = "Scape Bank \n     de um scape na burocracia!!";

    public RainbowPanel() {
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10;
        int y = getHeight() / 2;

        Font font = new Font("Arial", Font.BOLD, 35);
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
}
