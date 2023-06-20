package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaFisicaDAO;
import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import model.PessoaFisica;
import view.PessoaFisicaGUI;

public class PessoaFisicaController implements ActionListener {
    private PessoaFisicaGUI pessoaFisicaGUI;
    private EnderecoController enderecoController;
    PessoaFisica pessoaFisica;

    public PessoaFisicaController() {
        this.pessoaFisica = new PessoaFisica();
        this.enderecoController = new EnderecoController();
        this.pessoaFisicaGUI = new PessoaFisicaGUI(enderecoController.getEnderecoGUI());
        enderecoController.setEndereco(
                "Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");
        setPessoaFisica(
                new PessoaFisica(0, "digite seu nome", enderecoController.getEndereco(), null, 0, null));
        getPessoaFisicaGUI().getSalvar().addActionListener(this);

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

    private void Salvar() {
        String nome = pessoaFisicaGUI.getNomeTextField().getText();
        String endereco = getEnderecoController().getEndereco();
        String Telefone = pessoaFisicaGUI.getTelefoneFormattedTextField().getText().replace("(", "").replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble(pessoaFisicaGUI.getRendaAtualTextField().getText());
        String cpf = pessoaFisicaGUI.getCpfFormattedTextField().getText().replace(".", "").replace("-", "");

        PessoaFisica pessoaFisica = new PessoaFisica(geraId(), nome, endereco, Telefone, rendaAtual, cpf);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        try {
            pessoaFisicaDAO.criar(pessoaFisica);
            JOptionPane.showMessageDialog(pessoaFisicaGUI, "pessoa gravada com sucesso");
        } catch (Exception e) {
            Logger.getLogger(PessoaFisicaController.class.getName()).log(Level.SEVERE, null, e);
        }

        pessoaFisicaGUI.removeAll();
        pessoaFisicaGUI.repaint();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pessoaFisicaGUI.getSalvar()) {
            Salvar();

        }
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
        getPessoaFisicaGUI().getCpfFormattedTextField().setText(pessoaFisica.getCpf());
        addFocusListener();
    }

}
