package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaJuridicaDAO;
import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import model.PessoaJuridica;
import view.PessoaJuridicaGUI;

public class PessoaJuridicaController implements ActionListener {
    private PessoaJuridicaGUI pessoaJuridicaGUI;
    private EnderecoController enderecoController;
    private PessoaJuridica pessoaJuridica;

    public PessoaJuridicaController() {
        this.enderecoController = new EnderecoController();
         this.pessoaJuridicaGUI = new PessoaJuridicaGUI(enderecoController.getEnderecoGUI());
         this.pessoaJuridica = new PessoaJuridica();


        enderecoController.setEndereco(
                "Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");

              setPessoaJuridica(
                new PessoaJuridica(0, "digite seu nome", enderecoController.getEndereco(), null, 0, null));
        pessoaJuridicaGUI.getSalvar().addActionListener(this);

    }
        public void addFocusListener() {
        getPessoaJuridicaGUI().getNomeTextField()
                .addFocusListener(new createFocusListenerTextField(getPessoaJuridicaGUI().getNomeTextField()));
        getEnderecoController().setEndereco(getPessoaJuridica().getEndereco());
        getPessoaJuridicaGUI().getTelefoneFormattedTextField().addFocusListener(
                new createFocusListenerFormatField(getPessoaJuridicaGUI().getTelefoneFormattedTextField()));
        getPessoaJuridicaGUI().getRendaAtualTextField()
                .addFocusListener(new createFocusListenerTextField(getPessoaJuridicaGUI().getRendaAtualTextField()));
        getPessoaJuridicaGUI().getCnpJFormattedTextField()
                .addFocusListener(new createFocusListenerFormatField(getPessoaJuridicaGUI().getCnpJFormattedTextField()));
        getPessoaJuridicaGUI().repaint();
    }

    private void Salvar() {
        String nome = getPessoaJuridicaGUI().getNomeTextField().getText();
        String endereco = getEnderecoController().getEndereco();
        String Telefone = getPessoaJuridicaGUI().getTelefoneFormattedTextField().getText().replace("(", "")
                .replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble(getPessoaJuridicaGUI().getRendaAtualTextField().getText());
        String cnpj = getPessoaJuridicaGUI().getcnpJFormattedTextField().getText().replace(".", "").replace("-", "")
                .replace("/", "");

        PessoaJuridica pessoaJuridica = new PessoaJuridica(geraId(), nome, endereco, Telefone, rendaAtual, cnpj);
        PessoaJuridicaDAO pJuridicaDAO = new PessoaJuridicaDAO();
                try {
       pJuridicaDAO.criar(pessoaJuridica);

        JOptionPane.showMessageDialog(getPessoaJuridicaGUI(), "pessoa gravada com sucesso");
        } catch (Exception e) {
            Logger.getLogger(PessoaJuridicaController.class.getName()).log(Level.SEVERE, null, e);
        }
 
        getPessoaJuridicaGUI().removeAll();
        getPessoaJuridicaGUI().repaint();
    }
    

    private int geraId() {
        int count = 0;
        for (PessoaJuridica pessoaJuridica : new PessoaJuridicaDAO().listarTodos()) {
            if (count < pessoaJuridica.getId()) {
                count = pessoaJuridica.getId();
            }
        }
        return count + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pessoaJuridicaGUI.getSalvar()) {
            Salvar();

        }
    }

    public PessoaJuridicaGUI getPessoaJuridicaGUI() {
        return pessoaJuridicaGUI;
    }

    public void setPessoaJuridicaGUI(PessoaJuridicaGUI pessoaJuridicaGUI) {
        this.pessoaJuridicaGUI = pessoaJuridicaGUI;
    }

    public EnderecoController getEnderecoController() {
        return enderecoController;
    }

    public void setEnderecoController(EnderecoController enderecoController) {
        this.enderecoController = enderecoController;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
        getPessoaJuridicaGUI().getNomeTextField().setText(pessoaJuridica.getNome());
        getEnderecoController().setEndereco(pessoaJuridica.getEndereco());
        getPessoaJuridicaGUI().getTelefoneFormattedTextField().setText(pessoaJuridica.getTelefone());
        getPessoaJuridicaGUI().getRendaAtualTextField().setText(String.valueOf(pessoaJuridica.getRendaAtual()));
        getPessoaJuridicaGUI().getCnpJFormattedTextField().setText(pessoaJuridica.getCpnj());
        addFocusListener();
    }

}
