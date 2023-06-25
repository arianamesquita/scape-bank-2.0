package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import view.CustomComponents.Jbutton;
import view.CustomComponents.JtextField;
import view.CustomComponents.PaintMenu;

public class ContaGUI extends JPanel {

    private JLabel loginLabel, conLoginLabel, senhaLabel, conSenhaLabel;
    private JtextField loginField, conLoginField, senhaField, conSenhaField;
    private Jbutton salvar, cancelar, atualizar;
    private PaintMenu paintMenu;

    public ContaGUI() {
        Font fonte = new Font("Arial", Font.PLAIN, 15);
        setLayout(new BorderLayout());
        setBackground(ColorPaleta.rgbgray2Color());
        paintMenu = new PaintMenu();
        paintMenu.setBackground(getBackground());
        paintMenu.setLayout(new GridBagLayout());
        paintMenu.setOpaque(false);
        paintMenu.setRounded(20);

        this.loginLabel = new JLabel("login:");
        loginLabel.setFont(fonte);

        this.loginField = new JtextField();
        loginField.setHorizontalAlignment(JtextField.CENTER);

        this.conLoginLabel = new JLabel("confirme seu login:");
        conLoginLabel.setFont(fonte);

        this.conLoginField = new JtextField();
        conLoginField.setHorizontalAlignment(JtextField.CENTER);

        this.senhaLabel = new JLabel("senha:");
        senhaLabel.setFont(fonte);

        this.senhaField = new JtextField();
        senhaField.setHorizontalAlignment(JtextField.CENTER);

        this.conSenhaLabel = new JLabel("confirme sua senha:");
        conSenhaLabel.setFont(fonte);

        this.conSenhaField = new JtextField();
        conSenhaField.setHorizontalAlignment(JtextField.CENTER);

        this.salvar = new Jbutton("salvar");
        salvar.setColors(Color.gray);

        this.cancelar = new Jbutton("cancelar");

        JPanel panelnorth = new JPanel(new GridBagLayout());
        panelnorth.setOpaque(false);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 1.0;
        gbc1.gridwidth = 2;
        gbc1.insets = new Insets(5, 10, 5, 5);
        gbc1.ipady= 20;



        gbc1.gridx = 1;
        gbc1.gridy = 0;
        panelnorth.add(loginField, gbc1);

        
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        panelnorth.add(conLoginField, gbc1);

        gbc1.weightx = 0;
        gbc1.gridwidth = 1;

        gbc1.gridx = 0;
        gbc1.gridy = 0;
        panelnorth.add(loginLabel, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        panelnorth.add(conLoginLabel, gbc1);


        JPanel panelcenter = new JPanel(new GridBagLayout());
        panelcenter.setOpaque(false);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 1.0;
        gbc2.gridwidth = 2;
        gbc2.insets = new Insets(5, 10, 5, 5);
        gbc2.ipady = 20;
     

        gbc2.gridx = 1;
        gbc2.gridy = 0;
        panelcenter.add(senhaField, gbc2);

        gbc2.gridx = 1;
        gbc2.gridy = 1;
        panelcenter.add(conSenhaField, gbc2);

        gbc2.weightx = 0;
        gbc2.gridwidth = 1;

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panelcenter.add(senhaLabel, gbc2);

        gbc2.gridx = 0;
        gbc2.gridy = 1;
        panelcenter.add(conSenhaLabel, gbc2);

        JPanel panelsouth = new JPanel(new GridBagLayout());
        panelsouth.setOpaque(false);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(5, 10, 5, 5);
        gbc3.weightx = 1.0;
       

        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.gridwidth = 1;
        panelsouth.add(cancelar, gbc3);

        gbc3.gridx = 1;
        gbc3.gridy = 0;
        panelsouth.add(new JLabel(), gbc3);

        gbc3.gridx = 2;
        gbc3.gridy = 0;
        panelsouth.add(salvar, gbc3);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 2.0;
        gbc.gridwidth = 1;



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        paintMenu.add(panelnorth, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        paintMenu.add(panelcenter, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        paintMenu.add(panelsouth, gbc);

        add(paintMenu, BorderLayout.CENTER);
        setOpaque(false);

        setVisible(true);

    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(JLabel loginLabel) {
        this.loginLabel = loginLabel;
    }

    public JLabel getConLoginLabel() {
        return conLoginLabel;
    }

    public void setConLoginLabel(JLabel conLoginLabel) {
        this.conLoginLabel = conLoginLabel;
    }

    public JLabel getSenhaLabel() {
        return senhaLabel;
    }

    public void setSenhaLabel(JLabel senhaLabel) {
        this.senhaLabel = senhaLabel;
    }

    public JLabel getConSenhaLabel() {
        return conSenhaLabel;
    }

    public void setConSenhaLabel(JLabel conSenhaLabel) {
        this.conSenhaLabel = conSenhaLabel;
    }

    public JtextField getLoginField() {
        return loginField;
    }

    public void setLoginField(JtextField loginField) {
        this.loginField = loginField;
    }

    public JtextField getConLoginField() {
        return conLoginField;
    }

    public void setConLoginField(JtextField conLoginField) {
        this.conLoginField = conLoginField;
    }

    public JtextField getSenhaField() {
        return senhaField;
    }

    public void setSenhaField(JtextField senhaField) {
        this.senhaField = senhaField;
    }

    public JtextField getConSenhaField() {
        return conSenhaField;
    }

    public void setConSenhaField(JtextField conSenhaField) {
        this.conSenhaField = conSenhaField;
    }

    public Jbutton getSalvar() {
        return salvar;
    }

    public void setSalvar(Jbutton salvar) {
        this.salvar = salvar;
    }

    public Jbutton getCancelar() {
        return cancelar;
    }

    public void setCancelar(Jbutton cancelar) {
        this.cancelar = cancelar;
    }

    public Jbutton getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(Jbutton atualizar) {
        this.atualizar = atualizar;
    }

    public PaintMenu getPaintMenu() {
        return paintMenu;
    }

    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }

}
