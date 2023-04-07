import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Main {

    static Jframe frame;

    public static void main(String[] args) {

        frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(frame.getMaximumSize());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setResizable(false);

        JButton[] buttons = new JButton[5];
        for (int i = 0; i < 5; i++)
        {
            buttons[i]= new JButton("oi");
            buttons[i].setBounds(100,100,200,30);
            buttons[i].setVisible(true);
        }
        MenuPrincipais menuPrincipais= new MenuPrincipais(20,160,300,570,buttons);

        JButton[]jbuttons;
        String[] text = {"Extrato","emprestimo","saldo","cartoes","pix","limite"};
        jbuttons= new JButton[text.length];
        for (int i = 0; i < text.length; i++) {
            jbuttons[i]= new JButton("oi");
            jbuttons[i].setVisible(true);
        }

        Cards cards = new Cards(jbuttons, text, 400, 170, 900, 550);


        buttons[0].addActionListener(e -> {
            frame.add(cards);
            frame.repaint();
        });
        buttons[1].addActionListener(e -> {
            frame.remove(cards);

            frame.repaint();});
        buttons[2].addActionListener(e -> JOptionPane.showMessageDialog(null, "pagamento"));
        buttons[3].addActionListener(e -> JOptionPane.showMessageDialog(null, "emprestimo"));
        buttons[4].addActionListener(e -> JOptionPane.showMessageDialog(null, "cartoes"));
        jbuttons[0].addActionListener(e -> JOptionPane.showMessageDialog(null, "olá"));

        frame.add(menuPrincipais);
        frame.add(cards);
        frame.setVisible(true);
    }
}