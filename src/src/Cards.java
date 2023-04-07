import javax.swing.*;
import java.awt.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Cards extends JPanel {

    public Cards(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setLayout(null);
        setOpaque(false);
        Component component = new PaintCards(x,y,width,height);
        add(component);
        System.out.println("cards selecionado");
        setVisible(true);
    }
    private static class PaintCards extends JPanel {

        private PaintCards(int x, int y, int width, int height) {
            setBounds(0, 0, width, height);
            setLayout(null);
            setOpaque(false);
            setVisible(true);


        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);


            int count = 0;
            int count2 = 0;
            for (int i = 0; i < 6; i++)
            {
                g.setColor(Color.gray);
                g.fillRoundRect(count2,  count, 400, 150, 40, 40);
                count = count + 200;
                if (i == 2)
                {
                    count2 = count2 + 500;
                    count = 0;
                }
            }
            g.dispose();
        }
    }
    public static void main(String[] args) {
        JFrame   frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(frame.getMaximumSize());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.add(new Cards(100, 0, 900, 550));
        frame.setVisible(true);
    }
}


