package MainScreen.Components.CustomJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jbutton extends JButton{
    Color backgorund,clicked,entered;
    public Jbutton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5,0,5,0));
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(getClicked());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(getClicked());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(getBackgorund());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getEntered());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackgorund());
            }
        });

    }
    public void setColors(Color background,Color entered, Color clicked){
        this.clicked = clicked;
        this.backgorund = background;
        this.entered=entered;
        setBackground(background);
    }

    public Color getBackgorund() {
        return backgorund;
    }

    public void setBackgorund(Color backgorund) {
        this.backgorund = backgorund;
    }

    public Color getClicked() {
        return clicked;
    }

    public void setClicked(Color clicked) {
        this.clicked = clicked;
    }

    public Color getEntered() {
        return entered;
    }

    public void setEntered(Color entered) {
        this.entered = entered;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width-2, height-2, 30, 30);

        super.paintComponent(g);
    }

}

