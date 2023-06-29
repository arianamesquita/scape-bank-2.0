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

import DataBase.ClienteDAO.PessoaFisicaDAO;
import DataBase.ContaDAO.ContaDAO;
import DataBase.ContaDAO.TransacaoDAO;
import MainScreen.Components.CardsComponent.Cards;
import MainScreen.Components.Custom.ColorPaleta;
import MainScreen.Components.CustomJframe.Jframe;
import MainScreen.Components.MenuSuperiorComponent.MenuSuperior;
import controller.CartaoCreditoController;
import controller.ContaController;
import controller.LoginController;
import controller.PagamentosController;
import controller.PessoaFisicaController;
import controller.PixController;
import controller.VerificadorNotificacoes;
import model.Conta;
import view.CustomComponents.Jbutton;
import view.CustomComponents.JtextField;
import view.viewAdds.EmprestimoField;
import view.viewAdds.PagamentosField;
import view.viewAdds.PixField;

public class TelaPrincipalView extends Jframe {
    private Conta conta;

    private PixField pixField;
    private AreaPixGui areaPixGui;
    private PagamentosField pagamentosField;
    private AreaPagamentoGUI areaPagamentoGUI;
    private EmprestimoField empField;
    private AreaEmprestimoGUI areaEmprestimoGUI;
    private Cards cards;
    private CartaoCreditoController cartaoCreditoController;
    private PagamentosController pagamentosController;
    private PixController pixController;
    private JPanel panelAtulCadastro;
    private PessoaFisicaController pessoaFisicaController;
    private GerenciarConta gerenciarConta;
    private ContaController contaController;
    private JButton[] buttons2;
    private view.MenuOpcoes menuOpcoes;

    public TelaPrincipalView(Conta conta) {
        this.conta = conta;
        conta.setCliente(new PessoaFisicaDAO().ler(conta.getCliente().getId()));

       

        setTitle("Scape Bank");
        setLayout(null);
        setSize(1350, 800);
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
        pagamentosController.setConta(getConta());
        this.pixController = new PixController();
        pixController.setConta(getConta());
        this.gerenciarConta = new GerenciarConta();
        this.contaController = new ContaController();
        this.menuOpcoes= new view.MenuOpcoes();
        pagamentosController.setePrincipalView(this);
        pixController.setePrincipalView(this);
        updateInfoPessoais();

        panelAtulCadastro = new JPanel();
        panelAtulCadastro.setOpaque(false);
        panelAtulCadastro.setLayout(new BoxLayout(panelAtulCadastro, BoxLayout.Y_AXIS));
        panelAtulCadastro.setVisible(true);
        panelAtulCadastro.setBounds(400, 160, 700, 570);

        JLabel label = new JLabel("atualizar informações pessoais");
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        panelAtulCadastro.add(label);

        this.contaController = new ContaController();
        contaController.setePrincipalView(this);
        contaController.updateInterface();
        contaController.setAtualizar(false);
        contaController.getContaGUI().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelAtulCadastro.add(contaController.getContaGUI());

        this.pessoaFisicaController = new PessoaFisicaController();
        pessoaFisicaController.setePrincipalView(this);
        pessoaFisicaController.getPessoaFisicaGUI().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelAtulCadastro.add(pessoaFisicaController.getPessoaFisicaGUI());

        Jbutton[] buttons = new Jbutton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new Jbutton();
            buttons[i].setVisible(true);
        }
        
        menuOpcoes.setBounds(20, 160, 300, 570);

        String[] text = { "Extrato -->", "Empréstimo -->", "Saldo -->", "Cartões -->", "Pix -->", "Pagamentos -->" };
        JButton[] buttonsCards;
        buttonsCards = new JButton[text.length];
        for (int i = 0; i < text.length; i++) {
            buttonsCards[i] = new JButton("oi");
            buttonsCards[i].setVisible(true);
        }
        this.cards = new Cards(buttonsCards, text, 400, 160);
        menuOpcoes.getMenuprincipal().addActionListener(e -> {
            setInvisible();

            cards.setVisible(true);

            setSize(getSize().width, getSize().height + 1);
            setSize(getSize().width, getSize().height - 1);
            repaint();
        });

        
        menuOpcoes.getPix().addActionListener(e -> {
            setInvisible();

            pixController.getAreaPixGui().setVisible(true);

            setSize(getSize().width, getSize().height + 1);
            setSize(getSize().width, getSize().height - 1);
            repaint();
        });
        menuOpcoes.getPagamento().addActionListener(e -> {
            setInvisible();

            pagamentosController.getAreaPagamentoGUI().setVisible(true);

            setSize(getSize().width, getSize().height + 1);
            setSize(getSize().width, getSize().height - 1);
            repaint();
        });

        menuOpcoes.getEmprestimo().addActionListener(e -> {
            setInvisible();

            areaEmprestimoGUI.setVisible(true);

            setSize(getSize().width, getSize().height + 1);
            setSize(getSize().width, getSize().height - 1);
            repaint();
        });

        menuOpcoes.getCartao().addActionListener(e -> {
            setInvisible();

            cartaoCreditoController.getCartaoCreditoGUI().setBounds(650, 250, 700, 570);
            cartaoCreditoController.getCartaoCreditoGUI().setVisible(true);

            setSize(getSize().width, getSize().height + 1);
            setSize(getSize().width, getSize().height - 1);
            repaint();
        });

        JtextField searchField = new JtextField();
        searchField.setVisible(true);

        buttons2 = new JButton[5];
        buttons2[0] = new JButton("");
        buttons2[1] = new JButton("");
        buttons2[2] = new JButton("");
        buttons2[3] = new JButton("");
        buttons2[4] = new JButton("");
        MenuSuperior menuSuperior = new MenuSuperior(0, 0, getWidth(), 100, searchField, buttons2);

        gerenciarConta.setBounds(1020, 100, 200, 200);
        gerenciarConta.setBackground(ColorPaleta.buttonsColor());
        buttons2[4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!gerenciarConta.isSelect()) {
                    gerenciarConta.setVisible(true);
                    gerenciarConta.setSelect(true);
                } else {
                    gerenciarConta.setVisible(false);
                    gerenciarConta.setSelect(false);
                }

            }

        });

        searchField.setHorizontalAlignment(JTextField.CENTER);
        searchField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Pesquisar..")) {
                    searchField.setText("");
                    searchField.setBackground(Color.white);
                }
            }

            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Pesquisar..");
                }
            }
        });
        addActionListenergerenciarconta();
        add(gerenciarConta);
        add(panelAtulCadastro);
        add(menuOpcoes);

        add(pixController.getAreaPixGui());
        add(pagamentosController.getAreaPagamentoGUI());
        add(areaEmprestimoGUI);
        add(cartaoCreditoController.getCartaoCreditoGUI());

        add(menuSuperior);
        add(cards);

        setInvisible();
        ativanotify();

        cards.setVisible(true);
        menuOpcoes.setVisible(true);
        setVisible(true);
    }

    public static void addActionListener(JButton[] buttons) {

        for (JButton button : buttons) {
            switch (button.getText()) {
                case " " -> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir extrato"));
                case "  " -> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir emprestimo"));
                case "   " -> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir saldo"));
                case "    " -> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "abrir cartoes"));
                case "     " -> button.addActionListener(e -> {

                });
                case "      " -> button.addActionListener(e -> JOptionPane.showMessageDialog(null, "pagar contas"));
                default -> System.out.println("erro -> 1");
            }

        }
    }
    public void ativanotify(){
           VerificadorNotificacoes verificador = new VerificadorNotificacoes(getConta().getId());
        Thread thread = new Thread(verificador);

        // Iniciar o thread
        thread.start();

        // Aguardar um tempo antes de parar a verificação
        try {
            Thread.sleep(100); // 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Parar a verificação e aguardar o thread finalizar
  
    }

    public void setInvisible() {

        areaPixGui.setVisible(false);
        areaEmprestimoGUI.setVisible(false);
        cards.setVisible(false);
        cartaoCreditoController.getCartaoCreditoGUI().setVisible(false);
        pagamentosController.getAreaPagamentoGUI().setVisible(false);
        pixController.getAreaPixGui().setVisible(false);
        panelAtulCadastro.setVisible(false);
        gerenciarConta.setVisible(false);
        pessoaFisicaController.getPessoaFisicaGUI().setVisible(false);
        contaController.getContaGUI().setVisible(false);

    }

    private void addActionListenergerenciarconta() {
        gerenciarConta.getAtuaUser().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setInvisible();
                buttons2[4].doClick();
                pessoaFisicaController.updateInterface();
                pessoaFisicaController.setPessoaFisica(conta.getCliente());
                pessoaFisicaController.setAtualizar(false);
                panelAtulCadastro.setVisible(true);
                pessoaFisicaController.getPessoaFisicaGUI().setVisible(true);
                contaController.getContaGUI().setVisible(false);
               

            }

        });
        gerenciarConta.getAtuaLoginSEnha().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setInvisible();
                buttons2[4].doClick();
                contaController.updateInterface();
            
                contaController.setAtualizar(false);
                contaController.setConta(getConta());
                contaController.getContaGUI().setVisible(true); 
                panelAtulCadastro.setVisible(true);
               
            }

        });
        gerenciarConta.getDeletarconta().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons2[4].doClick();
                int choice = JOptionPane.showConfirmDialog(null, "Do you really want to delete your account?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    setConta(new ContaDAO().searchById(getConta().getId()));
                    getContaController().setConta(getConta());
                    getPessoaFisicaController()
                    .setPessoaFisica(new PessoaFisicaDAO().ler(getConta().getCliente().getId()));
                    getContaController().deletar();
                    getPessoaFisicaController().apagar();
                    dispose();
                    new LoginController();

                } else {
                    setInvisible();
                    getCards().setVisible(true);
                }
            }

        });

    }
    public void updateInfoPessoais(){
        Conta current = new ContaDAO().searchById(getConta().getId());
        TransacaoDAO trans = new TransacaoDAO();
        menuOpcoes.getSaldo().setText("saldo: R$"+trans.getSaldoConta(current));
        menuOpcoes.getNome().setText("nome :"+current.getLogin());
        menuOpcoes.getConta().setText(current.getNumeroConta());
        menuOpcoes.getAgencia().setText(current.getAgencia().getNumeroAgencia());
        menuOpcoes.repaint();
        setConta(current);
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public JPanel getPanelAtulCadastro() {
        return panelAtulCadastro;
    }

    public void setPanelAtulCadastro(JPanel panelAtulCadastro) {
        this.panelAtulCadastro = panelAtulCadastro;
    }

    public PessoaFisicaController getPessoaFisicaController() {
        return pessoaFisicaController;
    }

    public void setPessoaFisicaController(PessoaFisicaController pessoaFisicaController) {
        this.pessoaFisicaController = pessoaFisicaController;
    }

    public GerenciarConta getGerenciarConta() {
        return gerenciarConta;
    }

    public void setGerenciarConta(GerenciarConta gerenciarConta) {
        this.gerenciarConta = gerenciarConta;
    }

    public ContaController getContaController() {
        return contaController;
    }

    public void setContaController(ContaController contaController) {
        this.contaController = contaController;
    }

    public JButton[] getButtons2() {
        return buttons2;
    }

    public void setButtons2(JButton[] buttons2) {
        this.buttons2 = buttons2;
    }

    public PixController getPixController() {
        return pixController;
    }

    public void setPixController(PixController pixController) {
        this.pixController = pixController;
    }
    

}