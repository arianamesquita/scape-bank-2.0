package MainScreen.Components;

import AccessScreen.FrameComponents.CadastroComponents.Cadastro;
import MainScreen.Components.CardsComponent.Cards;
import MainScreen.Components.CustomJButton.Jbutton;
import MainScreen.Components.CustomJTextField.JtextField;
import MainScreen.Components.CustomJframe.Jframe;
import MainScreen.Components.MenuComponent.MenuOpcoes;
import MainScreen.Components.MenuSuperiorComponent.MenuSuperior;
import controller.PagamentosController;
import model.Conta;
import view.AreaEmprestimoGUI;
import view.AreaPagamentoGUI;
import view.AreaPixGui;
import view.viewAdds.EmprestimoField;
import view.viewAdds.PagamentosField;
import view.viewAdds.PixField;

import javax.swing.*;


import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/**
 * class para teste de alguns objetos
 * @author pedro
 * @version 1.0
 */
public class TesteMain {

    static Jframe frame;

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        Jbutton[] buttons = new Jbutton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i]= new Jbutton();
            buttons[i].setVisible(true);
        }
        Cadastro cadastro = new Cadastro(500,160);

        MenuOpcoes menuPrincipais= new MenuOpcoes(20,160,300,570,buttons);
        String[] text = {"Extrato -->","Empréstimo -->","Saldo -->","Cartões -->","Pix -->","Pagamentos -->"};
        JButton[] buttonsCards;
        buttonsCards = new JButton[text.length];
        for (int i = 0; i < text.length; i++) {
            buttonsCards[i]= new JButton("oi");
            buttonsCards[i].setVisible(true);
        }
        Cards cards = new Cards(buttonsCards, text, 400, 160);
        buttons[1].addActionListener(e -> {
            frame.add(cards);
            frame.remove(cadastro);
            frame.repaint();
        });
        buttons[2].addActionListener(e -> {
                  frame.add(cadastro);

            PixField pixField = new PixField();
            AreaPixGui areaPixGui = new AreaPixGui(pixField);

            frame.remove(cards);
            frame.add(areaPixGui);
            frame.setSize(frame.getSize().width,frame.getSize().height+1);
            frame.setSize(frame.getSize().width,frame.getSize().height-1);
            frame.repaint();});
        buttons[3].addActionListener(e -> {
                  frame.add(cadastro);

            PagamentosField pagamentosField = new PagamentosField();
            AreaPagamentoGUI areaPagamentoGUI = new AreaPagamentoGUI(pagamentosField);
                    
            PagamentosController p = new PagamentosController(new Conta(), new AreaPagamentoGUI(new PagamentosField()));
            p.initController();

            frame.remove(cards);
            frame.add(areaPagamentoGUI);
            frame.setSize(frame.getSize().width,frame.getSize().height+1);
            frame.setSize(frame.getSize().width,frame.getSize().height-1);
            frame.repaint();});

        buttons[4].addActionListener(e -> {
                frame.add(cadastro);

            EmprestimoField empField = new EmprestimoField();
            AreaEmprestimoGUI areaEmprestimoGUI = new AreaEmprestimoGUI(empField);

            frame.remove(cards);
            frame.add(areaEmprestimoGUI);
            frame.setSize(frame.getSize().width,frame.getSize().height+1);
            frame.setSize(frame.getSize().width,frame.getSize().height-1);
            frame.repaint();});

        buttons[5].addActionListener(e -> JOptionPane.showMessageDialog(null, "Cartões"));
        addActionListener(buttonsCards);
        JtextField searchField = new JtextField();
        searchField.setVisible(true);


        JButton[] buttons2 = new JButton[5];
        buttons2[0] = new JButton("");
        buttons2[1] = new JButton("");
        buttons2[2] = new JButton("");
        buttons2[3] = new JButton("");
        buttons2[4] = new JButton("");
        MenuSuperior menuSuperior = new MenuSuperior(0, 0, frame.getWidth(), 100, searchField, buttons2);
        searchField.setHorizontalAlignment(JTextField.CENTER);
        searchField.addFocusListener(new FocusListener(){
                public void focusGained(FocusEvent e){
                if (searchField.getText().equals("Pesquisar..")){
                    searchField.setText("");
                    searchField.setBackground(Color.white);
                }
            }
            public void focusLost(FocusEvent e){
                if (searchField.getText().isEmpty()){
                    searchField.setText("Pesquisar..");
                }
            }
        });





        frame.add(menuPrincipais);
        frame.add(menuSuperior);
        frame.add(cards);
        frame.setVisible(true);
    }
   public static void addActionListener(JButton[]buttons){

        for (JButton button : buttons) {
            switch (button.getText()){
                case " "-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir extrato"));
                case "  "-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir emprestimo"));
                case "   "-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir saldo"));
                case "    "-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir cartoes"));
                case "     "-> button.addActionListener(e -> {
                    System.out.println("puta");

                        }
                );
                case "      "-> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "pagar contas"));
                default -> System.out.println("erro -> 1");
            }

        }
    }
}