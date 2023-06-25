package view.CustomComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jbutton extends JButton implements MouseListener {
    private Color backgorund, clicked, entered;
    private int rounded = 20;

    public Jbutton(String text, Icon icon) {
        super(text, icon);
        setConfig();
    }

    public Jbutton(Action a) {
        super(a);
        setConfig();
    }

    public Jbutton(String text) {
        super(text);
        setConfig();
    }

    public Jbutton(Icon icon) {
        super(icon);
        setConfig();
    }

    public Jbutton() {
        setConfig();

    }

    private void setConfig() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 0, 5, 0));
        setColors(Color.gray);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(this);
    }

    public void setColors(Color background) {
        this.backgorund = background;

        // Ajustar a cor 'entered' para ser mais clara que a cor de fundo
        float[] hsbValues = Color.RGBtoHSB(background.getRed(), background.getGreen(), background.getBlue(), null);
        float brightness = hsbValues[2];
        Color entered = Color.getHSBColor(hsbValues[0], hsbValues[1], Math.min(brightness + 0.2f, 1.0f));

        // Ajustar a cor 'clicked' para ser mais escura que a cor de fundo
        Color clicked = background.darker();

        this.entered = entered;
        this.clicked = clicked;
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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - 2, height - 2, getRounded(), getRounded());

        super.paintComponent(g);
    }

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

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }

}
