package testesPedro;

import javax.swing.*;
import java.awt.*;

public class Jlist extends JList{
    public Jlist(){
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, -10, getWidth()-1, getHeight(), 20, 20);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, -10, getWidth()-1, getHeight()-1, 20, 20);
        super.paintBorder(g);
    }
}
