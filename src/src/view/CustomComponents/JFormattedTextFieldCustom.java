package view.CustomComponents;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class JFormattedTextFieldCustom extends JFormattedTextField {
    private int rounded = 20;

    public JFormattedTextFieldCustom() {

        setOpaque(false);
    }

    public JFormattedTextFieldCustom(Object value) {
        super(value);
        setOpaque(false);

    }

    public JFormattedTextFieldCustom(AbstractFormatter formatter) {
        super(formatter);
        setOpaque(false);
    }

    public JFormattedTextFieldCustom(AbstractFormatterFactory factory) {
        super(factory);
        setOpaque(false);
    }

    public JFormattedTextFieldCustom(MaskFormatter formatter) {
        super(formatter);
        setOpaque(false);
    }

    private Shape shape;

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getRounded(), getRounded());
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getRounded(), getRounded());
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, getRounded(), getRounded());
        }
        return shape.contains(x, y);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }
}
