package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import DataBase.ClienteDAO.PessoaFisicaDAO;
import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import model.PessoaFisica;
import view.LoginGUI;
import view.PessoaFisicaGUI;
import view.TelaPrincipalView;

public class PessoaFisicaController {
    private PessoaFisicaGUI pessoaFisicaGUI;
    private EnderecoController enderecoController;
    private PessoaFisica pessoaFisica;
    private LoginGUI loginGUI;
    private TelaPrincipalView ePrincipalView;


    public PessoaFisicaController() {
        this.pessoaFisica = new PessoaFisica();
        this.enderecoController = new EnderecoController();
        this.pessoaFisicaGUI = new PessoaFisicaGUI(enderecoController.getEnderecoGUI());
        enderecoController.setEndereco(
                "Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");
        setPessoaFisica(
                new PessoaFisica(0, "digite seu nome", enderecoController.getEndereco(), null, 0, null));

        pessoaFisicaGUI.getSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Salvar();
            }
       

        });
        pessoaFisicaGUI.getAtualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            atualizar();
            }
            
        });

    }
    public void atualizar(){
        JDialog dialog = new JDialog(getLoginGUI(), "Salvando...", true);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        dialog.add(progressBar);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(pessoaFisicaGUI);

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                String nome = pessoaFisicaGUI.getNomeTextField().getText();
                String endereco = getEnderecoController().getEndereco();
                String telefone = pessoaFisicaGUI.getTelefoneFormattedTextField().getText().replaceAll("[()-]", "");
                double rendaAtual = Double.parseDouble(pessoaFisicaGUI.getRendaAtualTextField().getText());
                String cpf = pessoaFisicaGUI.getCpfFormattedTextField().getText().replaceAll("[.-]", "");
                progressBar.setValue(25);


                PessoaFisica pessoaFisica = new PessoaFisica(getPessoaFisica().getId(), nome, endereco, telefone, rendaAtual, cpf);
                setPessoaFisica(pessoaFisica);
                PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                progressBar.setValue(50);
                try {

                    pessoaFisicaDAO.atualizar(pessoaFisica);

                    progressBar.setValue(75);
                    pessoaFisicaGUI.repaint();
                    progressBar.setValue(100);

                    JOptionPane.showMessageDialog(progressBar," usuario atualizado com sucesso");

                    setPessoaFisica(pessoaFisica);
                    getePrincipalView().setInvisible();
                    getePrincipalView().getCards().setVisible(true);
                    getePrincipalView().getPessoaFisicaController().setPessoaFisica(pessoaFisica);
                    
            
                } catch (SQLException e) {
                    Logger.getLogger(PessoaFisicaController.class.getName()).log(Level.SEVERE,
                            "Erro ao inserir dados na tabela pessoa", e);
                    JOptionPane.showMessageDialog(getPessoaFisicaGUI(),
                            "erro: dados informados corretamente tende denovo");
                    updateInterface();
                    setErroAll();
                    getPessoaFisicaGUI().repaint();
                }

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

    public void addFocusListener() {
        getPessoaFisicaGUI().getNomeTextField()
                .addFocusListener(new createFocusListenerTextField(getPessoaFisicaGUI().getNomeTextField()));
        getEnderecoController().setEndereco(getPessoaFisica().getEndereco());
        getPessoaFisicaGUI().getTelefoneFormattedTextField().addFocusListener(
                new createFocusListenerFormatField(getPessoaFisicaGUI().getTelefoneFormattedTextField()));
        getPessoaFisicaGUI().getRendaAtualTextField()
                .addFocusListener(new createFocusListenerTextField(getPessoaFisicaGUI().getRendaAtualTextField()));
        getPessoaFisicaGUI().getCpfFormattedTextField()
                .addFocusListener(new createFocusListenerFormatField(getPessoaFisicaGUI().getCpfFormattedTextField()));
        getPessoaFisicaGUI().repaint();
    }

    public void Salvar() {
        JDialog dialog = new JDialog(getLoginGUI(), "Salvando...", true);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        dialog.add(progressBar);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(pessoaFisicaGUI);

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                String nome = pessoaFisicaGUI.getNomeTextField().getText();
                String endereco = getEnderecoController().getEndereco();
                String telefone = pessoaFisicaGUI.getTelefoneFormattedTextField().getText().replaceAll("[()-]", "");
                double rendaAtual = Double.parseDouble(pessoaFisicaGUI.getRendaAtualTextField().getText());
                String cpf = pessoaFisicaGUI.getCpfFormattedTextField().getText().replaceAll("[.-]", "");
                progressBar.setValue(25);

                PessoaFisica pessoaFisica = new PessoaFisica(geraId(), nome, endereco, telefone, rendaAtual, cpf);
                setPessoaFisica(pessoaFisica);
                PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                progressBar.setValue(50);
                try {
                    pessoaFisicaDAO.criar(pessoaFisica);
                    progressBar.setValue(75);


                    progressBar.setValue(100);

                    pessoaFisicaGUI.repaint();
                    getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().setVisible(false);
                    getLoginGUI().getContaController().getContaGUI().setVisible(true);
                    getLoginGUI().getContaController().setPessoaFisica(getPessoaFisica());
                    getLoginGUI().getContaController().setLoginGUI(getLoginGUI());
                    getLoginGUI().getContaController().updateInterface();

                } catch (SQLException e) {
                    Logger.getLogger(PessoaFisicaController.class.getName()).log(Level.SEVERE,
                            "Erro ao inserir dados na tabela pessoa", e);
                    JOptionPane.showMessageDialog(getPessoaFisicaGUI(),
                            "erro: dados informados corretamente tende denovo");
                    updateInterface();
                    setErroAll();
                    getPessoaFisicaGUI().repaint();
                }

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
    public void apagar(){
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        try {
            pessoaFisicaDAO.deletar(getPessoaFisica().getId());
            
        } catch (Exception e) {
            Logger.getLogger(PessoaFisicaController.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }

    public void updateInterface() {

        getEnderecoController().setEndereco(
                "Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");
        getEnderecoController().updateInterface();
        setPessoaFisica(
                new PessoaFisica(0, "digite seu nome", enderecoController.getEndereco(), null, 0, null));
        addFocusListener();
        setBackgroundAll();
        getPessoaFisicaGUI().repaint();

    }

    private int geraId() {
        int count = 0;
        for (PessoaFisica psFisica : new PessoaFisicaDAO().listarTodos()) {
            if (count < psFisica.getId()) {
                count = psFisica.getId();
            }
        }
        return count + 1;
    }

    public void setErroAll() {
        getPessoaFisicaGUI().getNomeTextField().setBackground(Color.red);
        getEnderecoController().setErroAll();
        getPessoaFisicaGUI().getTelefoneFormattedTextField().setBackground(Color.red);
        getPessoaFisicaGUI().getRendaAtualTextField().setBackground(Color.red);
        getPessoaFisicaGUI().getCpfFormattedTextField().setBackground(Color.red);
        getPessoaFisicaGUI().repaint();
    }

    public void setBackgroundAll() {
        getPessoaFisicaGUI().getNomeTextField().setBackground(Color.white);
        getEnderecoController().setBackgroundAll();
        getPessoaFisicaGUI().getTelefoneFormattedTextField().setBackground(Color.white);
        getPessoaFisicaGUI().getRendaAtualTextField().setBackground(Color.white);
        getPessoaFisicaGUI().getCpfFormattedTextField().setBackground(Color.white);
        getPessoaFisicaGUI().repaint();
    }

    public void setAtualizar(boolean aflag) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.ipady = 15;
        gbc.gridwidth=1;
        gbc.gridx = 1;
        gbc.gridy = 0;

       
        if (aflag) {
            getPessoaFisicaGUI().getPanelsouth().add(new JLabel(), gbc);
            getPessoaFisicaGUI().getSalvar().setVisible(aflag);
            getPessoaFisicaGUI().getCancelar().setVisible(aflag);
        } else {
            getPessoaFisicaGUI().getPanelsouth().add(getPessoaFisicaGUI().getAtualizar(), gbc);
            getPessoaFisicaGUI().getSalvar().setVisible(aflag);
            getPessoaFisicaGUI().getCancelar().setVisible(aflag);
        }

    }

    public void apaga() {
        new PessoaFisicaDAO().deletar(getPessoaFisica().getId());
        updateInterface();
    }

    public PessoaFisicaGUI getPessoaFisicaGUI() {
        return pessoaFisicaGUI;
    }

    public void setPessoaFisicaGUI(PessoaFisicaGUI pessoaFisicaGUI) {
        this.pessoaFisicaGUI = pessoaFisicaGUI;
    }

    public EnderecoController getEnderecoController() {
        return enderecoController;
    }

    public void setEnderecoController(EnderecoController enderecoController) {
        this.enderecoController = enderecoController;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        getPessoaFisicaGUI().getNomeTextField().setText(pessoaFisica.getNome());
        getEnderecoController().setEndereco(pessoaFisica.getEndereco());
        getPessoaFisicaGUI().getTelefoneFormattedTextField().setText(pessoaFisica.getTelefone());
        getPessoaFisicaGUI().getRendaAtualTextField().setText(String.valueOf(pessoaFisica.getRendaAtual()));
        getPessoaFisicaGUI().getCpfFormattedTextField().setText(pessoaFisica.getDocIdentificacao());
        addFocusListener();
        getPessoaFisicaGUI().repaint();
    }


    public LoginGUI getLoginGUI() {
        return loginGUI;
    }

    public void setLoginGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }
    public TelaPrincipalView getePrincipalView() {
        return ePrincipalView;
    }
    public void setePrincipalView(TelaPrincipalView ePrincipalView) {
        this.ePrincipalView = ePrincipalView;
    }

}
