package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainScreen.Components.CardsComponent.Cards;
import MainScreen.Components.CustomJframe.Jframe;
import MainScreen.Components.MenuComponent.MenuOpcoes;
import MainScreen.Components.MenuSuperiorComponent.MenuSuperior;
import controller.CartaoCreditoController;
import controller.PagamentosController;
import controller.PessoaFisicaController;
import view.CustomComponents.Jbutton;
import view.CustomComponents.JtextField;
import view.viewAdds.EmprestimoField;
import view.viewAdds.PagamentosField;
import view.viewAdds.PixField;

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
    private JPanel panelAtulCadastro;
    private PessoaFisicaController pessoaFisicaController;

    public TelaPrincipalView(){    

        setTitle("Scape Bank");
        setLayout(null);
        setSize(1350,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pixField = new PixField();
        this.pagamentosField = new PagamentosField();
        this.areaPixGui = new AreaPixGui(pixField);
        this.areaPagamentoGUI = new AreaPagamentoGUI(pagamentosField);
        this.empField = new EmprestimoField();
        this.areaEmprestimoGUI = new AreaEmprestimoGUI(empField);
        this.cartaoCreditoController = new CartaoCreditoController();
        this.pagamentosController = new PagamentosController();


        
        panelAtulCadastro = new JPanel();
        panelAtulCadastro.setOpaque(false);
        panelAtulCadastro.setLayout(new BoxLayout(panelAtulCadastro, BoxLayout.Y_AXIS));
        panelAtulCadastro.setVisible(true);
        panelAtulCadastro.setBounds(400, 160, 700, 570);

        JLabel label = new JLabel("atualizar informações pessoais");
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        panelAtulCadastro.add(label);

        this.pessoaFisicaController = new PessoaFisicaController();
        pessoaFisicaController.getPessoaFisicaGUI().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelAtulCadastro.add(pessoaFisicaController.getPessoaFisicaGUI());

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

        buttons2[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             setInvisible();
             panelAtulCadastro.setVisible(true);
            }
            
        });

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

          add(panelAtulCadastro);

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
    panelAtulCadastro.setVisible(false);

    }

    public PixField getPixField() {
        return pixField;
    }

    public void setPixField(PixField pixField) {
        this.pixField = pixField;
    }

    public AreaPixGui getAreaPixGui() {
        return areaPixGui;
    }

    public void setAreaPixGui(AreaPixGui areaPixGui) {
        this.areaPixGui = areaPixGui;
    }

    public PagamentosField getPagamentosField() {
        return pagamentosField;
    }

    public void setPagamentosField(PagamentosField pagamentosField) {
        this.pagamentosField = pagamentosField;
    }

    public AreaPagamentoGUI getAreaPagamentoGUI() {
        return areaPagamentoGUI;
    }

    public void setAreaPagamentoGUI(AreaPagamentoGUI areaPagamentoGUI) {
        this.areaPagamentoGUI = areaPagamentoGUI;
    }

    public EmprestimoField getEmpField() {
        return empField;
    }

    public void setEmpField(EmprestimoField empField) {
        this.empField = empField;
    }

    public AreaEmprestimoGUI getAreaEmprestimoGUI() {
        return areaEmprestimoGUI;
    }

    public void setAreaEmprestimoGUI(AreaEmprestimoGUI areaEmprestimoGUI) {
        this.areaEmprestimoGUI = areaEmprestimoGUI;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public CartaoCreditoController getCartaoCreditoController() {
        return cartaoCreditoController;
    }

    public void setCartaoCreditoController(CartaoCreditoController cartaoCreditoController) {
        this.cartaoCreditoController = cartaoCreditoController;
    }

    public PagamentosController getPagamentosController() {
        return pagamentosController;
    }

    public void setPagamentosController(PagamentosController pagamentosController) {
        this.pagamentosController = pagamentosController;
    }
    

}