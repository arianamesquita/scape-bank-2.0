package view;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Service;
import view.CustomComponents.JtextField;

public class EnderecoGUI extends JPanel {
    private JLabel ruaLabel, numeroLabel, bairroLabel, estadoLabel, cidadeLabel, complementoLabel, cepLabel;
    private JtextField ruaTextField, bairroTextField, estadoTextField, cidadeTextField, complementoTextField;
    private JFormattedTextField numeroTextField, cepTextField;

    public EnderecoGUI() {
        setLayout(new GridBagLayout());
         Font fonte = new Font("Arial", Font.PLAIN, 15);
        ruaLabel = new JLabel("Rua:");
        ruaLabel.setFont(fonte);
        ruaTextField = new JtextField();
        //ruaLabel.setHorizontalAlignment(JLabel.CENTER);
        ruaTextField.setHorizontalAlignment(JTextField.CENTER);


        numeroLabel = new JLabel("Número:");
        numeroLabel.setFont(fonte);
        numeroTextField = Service.createFormattedTextField("###", '_');
        //numeroLabel.setHorizontalAlignment(JLabel.CENTER);
        numeroTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        bairroLabel = new JLabel("Bairro:");
        bairroLabel.setFont(fonte);
        bairroTextField = new JtextField();
        //bairroLabel.setHorizontalAlignment(JLabel.CENTER);
        bairroTextField.setHorizontalAlignment(JTextField.CENTER);

        complementoLabel = new JLabel("Complemento:");
        complementoLabel.setFont(fonte);
        complementoTextField = new JtextField();
       // complementoLabel.setHorizontalAlignment(JLabel.CENTER);
        complementoTextField.setHorizontalAlignment(JTextField.CENTER);

        estadoLabel = new JLabel("Estado:");
        estadoLabel.setFont(fonte);
        estadoTextField = new JtextField();
       // estadoLabel.setHorizontalAlignment(JLabel.CENTER);
        estadoTextField.setHorizontalAlignment(JTextField.CENTER);

        cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setFont(fonte);
        cidadeTextField = new JtextField();
       // cidadeLabel.setHorizontalAlignment(JLabel.CENTER);
        cidadeTextField.setHorizontalAlignment(JTextField.CENTER);

        cepLabel = new JLabel("CEP:");
        cepLabel.setFont(fonte);
        cepTextField = Service.createFormattedTextField("#####-###", '_');
        //cepLabel.setHorizontalAlignment(JLabel.CENTER);
        cepTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 3, 5, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        add(ruaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ruaTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(numeroLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(numeroTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        add(bairroLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bairroTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        add(complementoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(complementoTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        add(estadoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(estadoTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        add(cidadeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cidadeTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        add(cepLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cepTextField, gbc);
        setOpaque(false);

    }


    
    public JLabel getRuaLabel() {
        return ruaLabel;
    }

    public void setRuaLabel(JLabel ruaLabel) {
        this.ruaLabel = ruaLabel;
    }

    public JLabel getNumeroLabel() {
        return numeroLabel;
    }

    public void setNumeroLabel(JLabel numeroLabel) {
        this.numeroLabel = numeroLabel;
    }

    public JLabel getBairroLabel() {
        return bairroLabel;
    }

    public void setBairroLabel(JLabel bairroLabel) {
        this.bairroLabel = bairroLabel;
    }

    public JLabel getEstadoLabel() {
        return estadoLabel;
    }

    public void setEstadoLabel(JLabel estadoLabel) {
        this.estadoLabel = estadoLabel;
    }

    public JLabel getCidadeLabel() {
        return cidadeLabel;
    }

    public void setCidadeLabel(JLabel cidadeLabel) {
        this.cidadeLabel = cidadeLabel;
    }

    public JLabel getComplementoLabel() {
        return complementoLabel;
    }

    public void setComplementoLabel(JLabel complementoLabel) {
        this.complementoLabel = complementoLabel;
    }

    public JLabel getCepLabel() {
        return cepLabel;
    }

    public void setCepLabel(JLabel cepLabel) {
        this.cepLabel = cepLabel;
    }

    public JTextField getRuaTextField() {
        return ruaTextField;
    }

 

    public void setRuaTextField(JtextField ruaTextField) {
        this.ruaTextField = ruaTextField;
    }



    public void setBairroTextField(JtextField bairroTextField) {
        this.bairroTextField = bairroTextField;
    }



    public void setEstadoTextField(JtextField estadoTextField) {
        this.estadoTextField = estadoTextField;
    }



    public void setCidadeTextField(JtextField cidadeTextField) {
        this.cidadeTextField = cidadeTextField;
    }



    public void setComplementoTextField(JtextField complementoTextField) {
        this.complementoTextField = complementoTextField;
    }



    public JTextField getBairroTextField() {
        return bairroTextField;
    }



    public JTextField getEstadoTextField() {
        return estadoTextField;
    }

 

    public JTextField getCidadeTextField() {
        return cidadeTextField;
    }



    public JTextField getComplementoTextField() {
        return complementoTextField;
    }

   

    public JFormattedTextField getNumeroTextField() {
        return numeroTextField;
    }

    public void setNumeroTextField(JFormattedTextField numeroTextField) {
        this.numeroTextField = numeroTextField;
    }

    public JFormattedTextField getCepTextField() {
        return cepTextField;
    }

    public void setCepTextField(JFormattedTextField cepTextField) {
        this.cepTextField = cepTextField;
    }

}
