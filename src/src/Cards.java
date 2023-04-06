import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Cards extends JPanel {

    public Cards() {
        PaintCards paintCards = new PaintCards(400,0);
    }

    private static class PaintCards extends JPanel {

        private PaintCards(int x, int y) {
            setBounds(x, y, 900, 800);
            setLayout(null);
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
                g.fillRoundRect(count2, 180 + count, 400, 150, 40, 40);
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
}


