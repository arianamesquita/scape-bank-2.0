package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaJuridicaDAO;
import model.PessoaJuridica;
import view.PessoaJuridicaGUI;

public class PessoaJuridicaController implements ActionListener {
    private PessoaJuridicaGUI pessoaJuridicaGUI;

    public PessoaJuridicaController() {
        this.pessoaJuridicaGUI = new PessoaJuridicaGUI();
        pessoaJuridicaGUI.getSalvar().addActionListener(this);

    }

    private void Salvar() {
        String nome =getPessoaJuridicaGUI() .getNomeTextField().getText();
        String endereco =getPessoaJuridicaGUI() .getEnderecoController().getEndereco();
        String Telefone =getPessoaJuridicaGUI() .getTelefoneFormattedTextField().getText().replace("(", "").replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble( getPessoaJuridicaGUI().getRendaAtualTextField().getText());
        String cnpj =getPessoaJuridicaGUI() .getcnpJFormattedTextField().getText().replace(".", "").replace("-", "").
        replace("/", "");

        PessoaJuridica pessoaJuridica = new PessoaJuridica(geraId(), nome, endereco, Telefone, rendaAtual, cnpj);
        PessoaJuridicaDAO pJuridicaDAO = new PessoaJuridicaDAO();
        pJuridicaDAO.criar(pessoaJuridica);

        JOptionPane.showMessageDialog(getPessoaJuridicaGUI() , "pessoa gravada com sucesso");
       getPessoaJuridicaGUI() .removeAll();
       getPessoaJuridicaGUI() .repaint();
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

}
