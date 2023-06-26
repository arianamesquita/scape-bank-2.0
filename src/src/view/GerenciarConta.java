package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import view.CustomComponents.Jbutton;
import view.CustomComponents.PaintMenu;

public class GerenciarConta extends JPanel{

    private Jbutton atuaUser,atuaLoginSEnha,deletarconta;
    private PaintMenu paintMenu;
    private boolean select = false;
    public GerenciarConta(){
        setLayout(new BorderLayout());
        setBackground(ColorPaleta.rgbgray2Color());
        paintMenu = new PaintMenu();
        paintMenu.setBackground(getBackground());
        paintMenu.setLayout(new GridBagLayout());
        paintMenu.setOpaque(false);
        paintMenu.setRounded(20);

        this.atuaUser = new Jbutton("atualizar informações pessoais");
        atuaUser.setColors(ColorPaleta.buttonsColor());
        this.atuaLoginSEnha= new Jbutton("atualizar Login e Senha");
        atuaLoginSEnha.setColors(ColorPaleta.buttonsColor());
        this.deletarconta = new Jbutton("apagar conta");
        deletarconta.setColors(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.ipady= 20;



        gbc.gridx = 0;
        gbc.gridy = 0;
        paintMenu.add(atuaUser, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        paintMenu.add(atuaLoginSEnha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        paintMenu.add(deletarconta, gbc);

        add(paintMenu, BorderLayout.CENTER);
        setOpaque(false);

        setVisible(true);

    }
    public Jbutton getAtuaUser() {
        return atuaUser;
    }
    public void setAtuaUser(Jbutton atuaUser) {
        this.atuaUser = atuaUser;
    }
    public Jbutton getAtuaLoginSEnha() {
        return atuaLoginSEnha;
    }
    public void setAtuaLoginSEnha(Jbutton atuaLoginSEnha) {
        this.atuaLoginSEnha = atuaLoginSEnha;
    }
    public Jbutton getDeletarconta() {
        return deletarconta;
    }
    public void setDeletarconta(Jbutton deletarconta) {
        this.deletarconta = deletarconta;
    }
    public PaintMenu getPaintMenu() {
        return paintMenu;
    }
    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }
    public boolean isSelect() {
        return select;
    }
    public void setSelect(boolean select) {
        this.select = select;
    }
    
}
