package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainScreen.Components.Custom.ColorPaleta;
import controller.Service;
import view.CustomComponents.JFormattedTextFieldCustom;
import view.CustomComponents.Jbutton;
import view.CustomComponents.JtextField;
import view.CustomComponents.PaintMenu;

public class PessoaFisicaGUI extends JPanel {
    private JLabel nomeLabel, cpfLabel, telefoneLabel, rendaAtual, enderecoLabel;
    private JtextField nomeTextField, rendaAtualTextField;
    private JFormattedTextFieldCustom cpfFormattedTextField, telefoneFormattedTextField;
    private Jbutton salvar, cancelar;
    private EnderecoGUI enderecoGUI;
    private view.CustomComponents.PaintMenu paintMenu;

    public PessoaFisicaGUI(EnderecoGUI enderecoGUI) {
        Font fonte = new Font("Arial", Font.PLAIN, 15);
        setLayout(new BorderLayout());
        setBackground(ColorPaleta.rgbgray2Color());

        paintMenu = new PaintMenu();
        paintMenu.setBackground(getBackground());
        paintMenu.setLayout(new GridBagLayout());
        paintMenu.setOpaque(false);
        paintMenu.setRounded(20);
        nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(fonte);
        nomeTextField = new JtextField();
        nomeTextField.setHorizontalAlignment(JtextField.CENTER);

        cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(fonte);
        cpfFormattedTextField = Service.createFormattedTextField("###.###.###-##", '_');
        cpfFormattedTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(fonte);
        telefoneFormattedTextField = Service.createFormattedTextField("(##) #####-####", '_');
        telefoneFormattedTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        rendaAtual = new JLabel("Renda Atual:");
        rendaAtual.setFont(fonte);
        rendaAtualTextField = new JtextField();
        rendaAtualTextField.setHorizontalAlignment(JtextField.CENTER);

        enderecoLabel = new JLabel("Endereço:");

        salvar = new Jbutton("salvar");
        cancelar = new Jbutton("Cancelar");

        this.enderecoGUI = enderecoGUI;

   

        JPanel panelnorth = new JPanel(new GridBagLayout());
        panelnorth.setOpaque(false);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 10, 5, 5);
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 0;
        gbc1.gridwidth = 1;
        panelnorth.add(nomeLabel, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.gridwidth = 2;
        panelnorth.add(nomeTextField, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.weightx = 0;
        gbc1.gridwidth = 1;
        panelnorth.add(cpfLabel, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 1;
        gbc1.weightx = 1.0;
        gbc1.gridwidth = 2;
        panelnorth.add(cpfFormattedTextField, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.weightx = 0;
        gbc1.gridwidth = 1;
        panelnorth.add(telefoneLabel, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 2;
        gbc1.weightx = 1.0;
        gbc1.gridwidth = 2;
        panelnorth.add(telefoneFormattedTextField, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 3;
        gbc1.weightx = 0;
        gbc1.gridwidth = 1;
        panelnorth.add(rendaAtual, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 3;
        gbc1.weightx = 1.0;
        gbc1.gridwidth = 2;
        panelnorth.add(rendaAtualTextField, gbc1);

        JPanel panelcenter = new JPanel(new GridBagLayout());
        panelcenter.setOpaque(false);
         
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
           gbc2.insets = new Insets(5, 10, 5, 5);
   
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.weightx = 0;
        gbc2.gridwidth = 1;
        panelcenter.add(enderecoLabel, gbc2);

    
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.weightx = 1.0;
        gbc2.gridwidth = 2;

        panelcenter.add(enderecoGUI, gbc2);

   
        JPanel panelsouth = new JPanel(new GridBagLayout());
        panelsouth.setOpaque(false);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(5, 10, 5, 5);
      

        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.gridwidth = 1;
        gbc3.weightx =1.0;
        panelsouth.add(cancelar, gbc3);

        gbc3.gridx = 1;
        gbc3.gridy = 0;
        gbc3.weightx = 1.0;
        gbc3.weightx =1.0;
        panelsouth.add(new JLabel(), gbc3);

        gbc3.gridx = 2;
        gbc3.gridy = 0;
        panelsouth.add(salvar, gbc3);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.NORTH;
        paintMenu.add(panelnorth, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;

        gbc.anchor = GridBagConstraints.CENTER;
        paintMenu.add(panelcenter, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        paintMenu.add(panelsouth, gbc);
         
         


    
        add(paintMenu, BorderLayout.CENTER);
        setOpaque(false);

        setVisible(true);

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



    public JTextField getRendaAtualTextField() {
        return rendaAtualTextField;
    }



    public void setNomeTextField(JtextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }

    public void setRendaAtualTextField(JtextField rendaAtualTextField) {
        this.rendaAtualTextField = rendaAtualTextField;
    }

    public view.CustomComponents.PaintMenu getPaintMenu() {
        return paintMenu;
    }

    public void setPaintMenu(view.CustomComponents.PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }

    public JFormattedTextField getCpfFormattedTextField() {
        return cpfFormattedTextField;
    }



    public void setCpfFormattedTextField(JFormattedTextFieldCustom cpfFormattedTextField) {
        this.cpfFormattedTextField = cpfFormattedTextField;
    }

    public void setTelefoneFormattedTextField(JFormattedTextFieldCustom telefoneFormattedTextField) {
        this.telefoneFormattedTextField = telefoneFormattedTextField;
    }

    public JFormattedTextField getTelefoneFormattedTextField() {
        return telefoneFormattedTextField;
    }


    public JButton getSalvar() {
        return salvar;
    }

    public void setSalvar(Jbutton salvar) {
        this.salvar = salvar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(Jbutton cancelar) {
        this.cancelar = cancelar;
    }

    public EnderecoGUI getEnderecoGUI() {
        return enderecoGUI;
    }

    public void setEnderecoGUI(EnderecoGUI enderecoGUI) {
        this.enderecoGUI = enderecoGUI;
    }
    
}
