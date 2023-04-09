package MainScreen.Components;

import MainScreen.Components.CardsComponent.Cards;
import MainScreen.Components.CustomJframe.Jframe;
import MainScreen.Components.MenuComponent.MenuOpcoes;

import javax.swing.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 * class para teste de alguns objetos
 * @author pedro
 * @version 1.0
 */
public class TesteMain {

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
        for (int i = 0; i < 5; i++) {
            buttons[i]= new JButton();
            buttons[i].setVisible(true);
        }
        MenuOpcoes menuPrincipais= new MenuOpcoes(20,160,300,570,buttons);

        JButton[] buttonsCards;
        String[] text = {"Extrato","emprestimo","saldo","cartoes","pix","limite"};
        buttonsCards = new JButton[text.length];
        for (int i = 0; i < text.length; i++) {
            buttonsCards[i]= new JButton("oi");
            buttonsCards[i].setVisible(true);
        }

        Cards cards = new Cards(buttonsCards, text, 400, 170);


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
        addActionListener(buttonsCards);



        frame.add(menuPrincipais);
        frame.add(cards);
        frame.setVisible(true);
    }
   public static void addActionListener(JButton[]buttons){

        for (JButton button : buttons) {
            switch (button.getText()){
                case "Extrato"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir extrato"));
                case "emprestimo"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir emprestimo"));
                case "saldo"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir saldo"));
                case "cartoes"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir cartoes"));
                case "pix"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir pix"));
                case "limite"-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "ver limite disponivel"));
                default -> System.out.println("erro -> 1");
            }

        }
    }
}