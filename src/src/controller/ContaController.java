package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import DataBase.ContaDAO.ContaDAO;
import controller.Service.createFocusListenerTextField;
import model.Conta;
import model.Pagamentos;
import model.PessoaFisica;
import view.ContaGUI;
import view.LoginGUI;

public class ContaController implements ActionListener {

    private Conta conta;
    private PessoaFisica pessoaFisica;
    private Pagamentos pagamentos;
    private ContaGUI contaGUI;
    private LoginGUI loginGUI;

    public ContaController() {
        this.contaGUI = new ContaGUI();
    }

    public ContaController(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;

    }

    public void updateInterface() {
        addListeners();
    }

    private void salvaInformacoes() {

        JDialog dialog = new JDialog(getLoginGUI(), "Salvando...", true);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        dialog.add(progressBar);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(getContaGUI());

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
             
               conta = new Conta();
               pagamentos = new Pagamentos();
               progressBar.setValue(25);
                conta.setLogin(getContaGUI().getLoginField().getText());
                conta.setSenha(null);
                conta.setSenhaConta( getContaGUI().getSenhaField().getText());
                conta.setCliente(getPessoaFisica());
                pagamentos.setChavePix(null);
                conta.setPagamentos(pagamentos);
                progressBar.setValue(50);
        
                System.out.println("Criando conta...");
                ContaDAO contaDAO = new ContaDAO();
               
                try {
                      System.out.println("2");
                    contaDAO.criarConta(conta);
                    progressBar.setValue(75);
                   

                } catch (Exception e) {
                    Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
                }
                listar();
         progressBar.setValue(100);

        getLoginGUI().add(getLoginGUI().getCadastroGUI(), BorderLayout.CENTER);
        getLoginGUI().remove(getLoginGUI().getPanelCadastro());
        getLoginGUI().getCadastroGUI().setVisible(true);
    getLoginGUI().repaint();
    
                return null;
            }

            @Override
            protected void done() {
                dialog.dispose();
            }
        };

        worker.execute();
        dialog.setVisible(true);
    }

    

    private void atualizar() {
        conta.setCartao(null);
        conta.setLogin(null);
        conta.setSenha(null);
        pagamentos.setChavePix(null);
        conta.setPagamentos(pagamentos);
        conta.setSenhaConta(null);
        System.out.println("Atualizando a conta...");
        ContaDAO contaDAO = new ContaDAO();
        try {
            contaDAO.update(conta);
            ;
        } catch (Exception e) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
        }
        listar();
    }

    private void deletar() {
        conta.setId(0);

        System.out.println("Deletando a conta...");
        ContaDAO contaDAO = new ContaDAO();
        try {
            contaDAO.removeById(conta.getId());
            ;
        } catch (Exception e) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
        }
        listar();
    }

    private void setTextField() {
        getContaGUI().getLoginField().setText("digite seu login");
        getContaGUI().getConLoginField().setText("confirme seu login");
        getContaGUI().getSenhaField().setText("digite sua senha");
        getContaGUI().getConSenhaField().setText("comfirme sua senha");

    }

    private void listar() {
        ContaDAO dao = new ContaDAO();

        String[] colunas = { "id", "numeroConta", "numeroCartao", "login", "senha", "numeroAgencia", "idFuncionario",
                "idCliente", "chavePix", "validadeCartao", "cvc", "senhaConta" };
        DefaultTableModel tableModel = new DefaultTableModel(null, colunas);

        // DefaultTableModel dados = (DefaultTableModel); //aqui na frente pegaria o
        // modelo da tela

        List<Conta> contas = null;
        try {
            contas = dao.getContas();
        } catch (Exception ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Conta conta : contas) {
            String[] dado = new String[colunas.length];
            dado[0] = Integer.toString(conta.getId());
            dado[1] = conta.getNumeroConta();
            dado[2] = conta.getNumeroCartao();
            dado[3] = conta.getLogin();
            dado[4] = conta.getSenha();
            dado[5] = conta.getAgencia().getNumeroAgencia();
            dado[6] = Integer.toString(conta.getFuncionario().getId());
            dado[7] = Integer.toString(conta.getCliente().getId());
            dado[8] = conta.getPagamentos().getChavePix();
            dado[9] = conta.getValidadeCartao();
            dado[10] = Integer.toString(conta.getCvc());
            dado[11] = conta.getSenhaConta();
            // dados.addRow(dado); ---> linha comentada ali em cima.
        }

        // setvisible
    }

    private boolean verificaUser() {
        List<Conta> listuser = new ContaDAO().getContas();
        for (Conta conta : listuser) {
            if (!conta.getLogin().equals(getContaGUI().getLoginField().getText())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(getContaGUI(), "usuario já existe");
                return false;
            }

        }
        return false;
    }

    private void addListeners() {
        getContaGUI().getSalvar().addActionListener(this);
        setTextField();
        addFocusListener();
    }

    private void addFocusListener() {
        getContaGUI().getLoginField()
                .addFocusListener(new createFocusListenerTextField(getContaGUI().getLoginField()));

        getContaGUI().getConLoginField().addFocusListener(
                new createFocusListenerTextField(getContaGUI().getConLoginField()));
        getContaGUI().getSenhaField()
                .addFocusListener(new createFocusListenerTextField(getContaGUI().getSenhaField()));
        getContaGUI().getConSenhaField()
                .addFocusListener(new createFocusListenerTextField(getContaGUI().getConSenhaField()));
        getContaGUI().repaint();
    }

    private boolean verificaIgual() {
        if (getContaGUI().getLoginField().getText().equals(getContaGUI().getConLoginField().getText())) {

            if (getContaGUI().getSenhaField().getText().equals(getContaGUI().getConSenhaField().getText())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(contaGUI, "as senhas estão diferentes digite novamente!");
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(contaGUI, "os logins estão diferentes digite novamente!");
            return false;
        }
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

    public ContaGUI getContaGUI() {
        return contaGUI;
    }

    public void setContaGUI(ContaGUI contaGUI) {
        this.contaGUI = contaGUI;

    }

    public LoginGUI getLoginGUI() {
        return loginGUI;
    }

    public void setLoginGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getContaGUI().getSalvar() && verificaIgual()) {
            if (verificaUser()) {
                salvaInformacoes();
            }

        }
    }

}
