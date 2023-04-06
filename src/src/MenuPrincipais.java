import javax.swing.*;
import java.awt.*;

public class MenuPrincipais extends JPanel
{
    public MenuPrincipais(){
        setBounds(0,0, 400, 800);
        setLayout(null);
        JButton[] buttons = new Buttns().retornar();
        for (JButton botton:buttons){
            add(botton);
        }
        Component menup = new PaintMenu();
        add(menup);
        setVisible(true);
    }
    private static class PaintMenu extends JPanel {

        public PaintMenu(){
            setBounds(0,0, 400, 800);
            setLayout(null);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.darkGray);
            g.fillRoundRect(20, 150, 300, 600, 20, 20);
            g.setColor(Color.gray);
            g.fillRoundRect(30, 160, 280, 200, 20, 20);
            g.dispose();

        }
    }
    private static class Buttns {
        JButton[] buttons;
        String[] txt = {"menu Principal ->","pix->", "pagamento->","emprestimos->", "cartões->"};
        private Buttns(){
            InicializaButoons();
            setButtonsBound();
            buttons[0].addActionListener(e -> JOptionPane.showMessageDialog(null, "hehe component"));

        }
        void InicializaButoons()
        {
            buttons = new JButton[txt.length];
            int caunt = 0;
            for (String s:txt) {
                buttons[caunt]= new JButton(s);
                caunt++;
            }
        }
        void setButtonsBound(){
            int caunt = 0;
            for (JButton botton:buttons) {
                botton.setBounds(30, 370+caunt, 280, 50);
                caunt=caunt+60;

            }
        }
        public JButton[] retornar() {

            return buttons;
        }
    }
}





