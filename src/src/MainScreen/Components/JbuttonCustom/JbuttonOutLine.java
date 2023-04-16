package MainScreen.Components.JbuttonCustom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JbuttonOutLine extends JButton {



    public JbuttonOutLine() {
        setBorder(new EmptyBorder(5,0,5,0));
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 40, 40);

        super.paintComponent(g);
    }


}
