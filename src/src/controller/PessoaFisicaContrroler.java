package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaFisicaDAO;
import model.PessoaFisica;
import view.PessoaFisicaGUI;

public class PessoaFisicaContrroler implements ActionListener {
    private PessoaFisicaGUI pessoaFisicaGUI;

    public PessoaFisicaContrroler() {
        this.pessoaFisicaGUI = new PessoaFisicaGUI();
        getPessoaFisicaGUI().getSalvar().addActionListener(this);

    }

    private void Salvar() {
        String nome = pessoaFisicaGUI.getNomeTextField().getText();
        String endereco = pessoaFisicaGUI.getEnderecoController().getEndereco();
        String Telefone = pessoaFisicaGUI.getTelefoneFormattedTextField().getText().replace("(", "").replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble(pessoaFisicaGUI.getRendaAtualTextField().getText());
        String cpf = pessoaFisicaGUI.getCpfFormattedTextField().getText().replace(".", "").replace("-", "");

        PessoaFisica pessoaFisica = new PessoaFisica(geraId(), nome, endereco, Telefone, rendaAtual, cpf);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.criar(pessoaFisica);

        JOptionPane.showMessageDialog(pessoaFisicaGUI, "pessoa gravada com sucesso");
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
    return count+1;
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

}
