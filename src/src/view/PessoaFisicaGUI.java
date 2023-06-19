package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainScreen.Components.CustomJTextField.JtextField;
import controller.EnderecoController;
import controller.Service;

public class PessoaFisicaGUI extends JPanel {
    private JLabel nomeLabel, cpfLabel, telefoneLabel, rendaAtual, enderecoLabel;
    private JTextField nomeTextField, rendaAtualTextField;
    private JFormattedTextField cpfFormattedTextField, telefoneFormattedTextField;
    private JButton salvar, cancelar;
    private EnderecoController enderecoController;

    public PessoaFisicaGUI() {
        nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField();
        nomeTextField.setHorizontalAlignment(JtextField.CENTER);

        cpfLabel = new JLabel("CPF:");
        cpfFormattedTextField = Service.createFormattedTextField("###.###.###-##", '_');
        cpfFormattedTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        telefoneLabel = new JLabel("Telefone:");
        telefoneFormattedTextField = Service.createFormattedTextField("(##) #####-####", '_');
        telefoneFormattedTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        rendaAtual = new JLabel("Renda Atual:");
        rendaAtualTextField = new JTextField();
        rendaAtualTextField.setHorizontalAlignment(JtextField.CENTER);

        enderecoLabel = new JLabel("Endereço:");

        salvar = new JButton("salvar");
        cancelar = new JButton("Cancelar");

        enderecoController = new EnderecoController();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 2, 5, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(nomeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        add(nomeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(cpfLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        add(cpfFormattedTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(telefoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        add(telefoneFormattedTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(rendaAtual, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        add(rendaAtualTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        add(enderecoLabel, gbc);

    
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(enderecoController.getEgGui(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(new JLabel(), gbc); // Espaço vazio para preencher a última célula
        JPanel panel = new JPanel(getLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx =1.0;
        panel.add(cancelar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weightx =1.0;
        panel.add(new JLabel(), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(salvar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx =0;
        add(panel, gbc);

    }

    public JLabel getNomeLabel() {
        return nomeLabel;
    }

    public void setNomeLabel(JLabel nomeLabel) {
        this.nomeLabel = nomeLabel;
    }

    public JLabel getCpfLabel() {
        return cpfLabel;
    }

    public void setCpfLabel(JLabel cpfLabel) {
        this.cpfLabel = cpfLabel;
    }

    public JLabel getTelefoneLabel() {
        return telefoneLabel;
    }

    public void setTelefoneLabel(JLabel telefoneLabel) {
        this.telefoneLabel = telefoneLabel;
    }

    public JLabel getRendaAtual() {
        return rendaAtual;
    }

    public void setRendaAtual(JLabel rendaAtual) {
        this.rendaAtual = rendaAtual;
    }

    public JLabel getEnderecoLabel() {
        return enderecoLabel;
    }

    public void setEnderecoLabel(JLabel enderecoLabel) {
        this.enderecoLabel = enderecoLabel;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }

    public JTextField getRendaAtualTextField() {
        return rendaAtualTextField;
    }

    public void setRendaAtualTextField(JTextField rendaAtualTextField) {
        this.rendaAtualTextField = rendaAtualTextField;
    }

    public JFormattedTextField getCpfFormattedTextField() {
        return cpfFormattedTextField;
    }

    public void setCpfFormattedTextField(JFormattedTextField cpfFormattedTextField) {
        this.cpfFormattedTextField = cpfFormattedTextField;
    }

    public JFormattedTextField getTelefoneFormattedTextField() {
        return telefoneFormattedTextField;
    }

    public void setTelefoneFormattedTextField(JFormattedTextField telefoneFormattedTextField) {
        this.telefoneFormattedTextField = telefoneFormattedTextField;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public void setSalvar(JButton salvar) {
        this.salvar = salvar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public EnderecoController getEnderecoController() {
        return enderecoController;
    }

    public void setEnderecoController(EnderecoController enderecoController) {
        this.enderecoController = enderecoController;
    }
    
}
