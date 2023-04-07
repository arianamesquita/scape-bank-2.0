package MainScreen.Components.MenuComponent;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipais extends JPanel
{
   static int xs, ys, widths, heights;
    JButton[] buttons ;
    public MenuPrincipais(int x, int y, int width, int height, JButton[] buttons) {
        this.buttons =buttons;
        MenuPrincipais.xs = x;
        MenuPrincipais.ys = y;
        MenuPrincipais.widths = width;
        MenuPrincipais.heights = height;
        addBottons();
        addPaintMenu();
        setBounds(x,y,width,height);
        setLayout(null);
        setVisible(true);
    }
    public void addPaintMenu(){
        Component menup = new PaintMenu();
        add(menup);
    }
    public void addBottons(){
        Buttons buttons1 = new Buttons(buttons);

        for (JButton botton: buttons1.retornar()){
            add(botton);
        }
    }

    private static class PaintMenu extends JPanel {



        public PaintMenu() {


            setBounds(0,0,widths,heights);
            setLayout(null);
            setVisible(true);
        }
        @Override
        public void paint(Graphics g) {

            g.setColor(Color.darkGray);
            g.fillRoundRect(0, 0, widths, heights, 20, 20);
            g.setColor(Color.gray);
            g.fillRoundRect(10, 10, widths-20, (int) (heights*0.2727272727), 20, 20);
            g.dispose();

        }
    }
    private static class Buttons {
        JButton[]buttons;
        String[] txt = {"menu Principal ->","pix->", "pagamento->","emprestimos->", "cartões->"};

        public Buttons(JButton[] buttons) {
            this.buttons = buttons;
            InicializaButoons();
            setButtonsBound();
        }

        void InicializaButoons()
        {
            int caunt = 0;
            for (String s:txt) {
                buttons[caunt].setText(s);
                caunt++;
            }
        }
        void setButtonsBound(){
            int caunt = 0;
            for (JButton botton:buttons) {
                botton.setBounds(10, ys+20+caunt, widths-20, (int) (0.0909090909*heights));
                caunt= (int) (0.10*heights+caunt);

            }
        }
        public JButton[] retornar() {

            return buttons;
        }
    }


}





