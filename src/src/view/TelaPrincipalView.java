package view;

import AccessScreen.FrameComponents.CadastroComponents.Cadastro;
import MainScreen.Components.CardsComponent.Cards;
import MainScreen.Components.CustomJButton.Jbutton;
import MainScreen.Components.CustomJTextField.JtextField;
import MainScreen.Components.CustomJframe.Jframe;
import MainScreen.Components.MenuComponent.MenuOpcoes;
import MainScreen.Components.MenuSuperiorComponent.MenuSuperior;
import controller.CartaoCreditoController;
import controller.PagamentosController;
import view.viewAdds.EmprestimoField;
import view.viewAdds.PagamentosField;
import view.viewAdds.PixField;

import javax.swing.*;


import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class TelaPrincipalView extends Jframe {

    private PixField pixField;
    private AreaPixGui areaPixGui;
    private PagamentosField pagamentosField;
    private AreaPagamentoGUI areaPagamentoGUI;
    private EmprestimoField empField;
    private AreaEmprestimoGUI areaEmprestimoGUI;
    private Cards cards;
    private CartaoCreditoController cartaoCreditoController;
    private PagamentosController pagamentosController;

    public TelaPrincipalView(){    

        setTitle("Scape Bank");
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setResizable(true);

        this.pixField = new PixField();
        this.pagamentosField = new PagamentosField();
        this.areaPixGui = new AreaPixGui(pixField);
        this.areaPagamentoGUI = new AreaPagamentoGUI(pagamentosField);
        this.empField = new EmprestimoField();
        this.areaEmprestimoGUI = new AreaEmprestimoGUI(empField);
        this.cartaoCreditoController = new CartaoCreditoController();
        this.pagamentosController = new PagamentosController();


        Jbutton[] buttons = new Jbutton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i]= new Jbutton();
            buttons[i].setVisible(true);
        }

        MenuOpcoes menuPrincipais= new MenuOpcoes(20,160,300,570,buttons);
        String[] text = {"Extrato -->","Empréstimo -->","Saldo -->","Cartões -->","Pix -->","Pagamentos -->"};
        JButton[] buttonsCards;
        buttonsCards = new JButton[text.length];
        for (int i = 0; i < text.length; i++) {
            buttonsCards[i]= new JButton("oi");
            buttonsCards[i].setVisible(true);
        }
        this.cards = new Cards(buttonsCards, text, 400, 160);
        buttons[1].addActionListener(e -> {
            setInvisible();

            cards.setVisible(true);

            setSize(getSize().width,getSize().height+1);
            setSize(getSize().width,getSize().height-1);
            repaint();});


        buttons[2].addActionListener(e -> {
            setInvisible();

            areaPixGui.setVisible(true);

            setSize(getSize().width,getSize().height+1);
            setSize(getSize().width,getSize().height-1);
            repaint();});
        buttons[3].addActionListener(e -> {
            setInvisible();

            pagamentosController.getAreaPagamentoGUI().setVisible(true);
                    
            setSize(getSize().width,getSize().height+1);
            setSize(getSize().width,getSize().height-1);
            repaint();});

        buttons[4].addActionListener(e -> {
            setInvisible();

            areaEmprestimoGUI.setVisible(true);

            setSize(getSize().width,getSize().height+1);
            setSize(getSize().width,getSize().height-1);
            repaint();});

        buttons[5].addActionListener(e -> {
            setInvisible();

            cartaoCreditoController.getCartaoCreditoGUI().setBounds(650, 250, 700, 570);
            cartaoCreditoController.getCartaoCreditoGUI().setVisible(true);

            setSize(getSize().width,getSize().height+1);
            setSize(getSize().width,getSize().height-1);
            repaint();});


        JtextField searchField = new JtextField();
        searchField.setVisible(true);

        JButton[] buttons2 = new JButton[5];
        buttons2[0] = new JButton("");
        buttons2[1] = new JButton("");
        buttons2[2] = new JButton("");
        buttons2[3] = new JButton("");
        buttons2[4] = new JButton("");
        MenuSuperior menuSuperior = new MenuSuperior(0, 0, getWidth(), 100, searchField, buttons2);
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

          

        add(areaPixGui);
        add(pagamentosController.getAreaPagamentoGUI());
        add(areaEmprestimoGUI);
        add(cartaoCreditoController.getCartaoCreditoGUI());

        add(menuPrincipais);
        add(menuSuperior);
        add(cards);

        setInvisible();
        cards.setVisible(true);
        setVisible(true);
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
    public void setInvisible(){

    areaPixGui.setVisible(false);
    areaEmprestimoGUI.setVisible(false);
    cards.setVisible(false);
    cartaoCreditoController.getCartaoCreditoGUI().setVisible(false);
    pagamentosController.getAreaPagamentoGUI().setVisible(false);

    }
}