package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.ContaDAO.ContaDAO;
import model.Conta;
import view.LoginGUI;
import view.TelaPrincipalView;

public class LoguinController implements ActionListener{

    private LoginGUI loginGUI;


    public LoguinController(){
        loginGUI = new LoginGUI();
        addActionListener();
    }
    private void verificaUser(){
        List<Conta> listuser = new ContaDAO().getContas();
        for (Conta conta : listuser) {
            if(conta.getLogin().equals(getLoginGUI().getCadastroGUI().getJTF().getText())){
                char[] password = getLoginGUI().getCadastroGUI().getJPF().getPassword();
                String passwordString = new String(password);
                if(conta.getSenha().equals(passwordString)){
                    getLoginGUI().dispose();
                    new TelaPrincipalView(conta);

                }else{JOptionPane.showMessageDialog(loginGUI,"senha incorreta!!");}

            } else{
                JOptionPane.showMessageDialog(loginGUI,"usuario incorreto!!");
            }
            
        }
    }


    public LoginGUI getLoginGUI() {
        return loginGUI;
    }

    public void setLoginGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }


        private void addActionListener() {
        getLoginGUI().getCadastroGUI().getButton()[0].addActionListener(this);
        getLoginGUI().getCadastroGUI().getButton()[1].addActionListener(this);
        getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().getCancelar().addActionListener(this);

    }
        @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == getLoginGUI().getCadastroGUI().getButton()[0]) {
            verificaUser();
            
        } else if (e.getSource() == getLoginGUI().getCadastroGUI().getButton()[1]) {
            getLoginGUI().getPessoaFisicaController().updateInterface();
            getLoginGUI().remove(getLoginGUI().getCadastroGUI());
            getLoginGUI().add(getLoginGUI().getPanelCadastro(), BorderLayout.CENTER);
            getLoginGUI().getPanelCadastro().setVisible(true);
            getLoginGUI().setMinimumSize(new Dimension(1200, 650));
         
            getLoginGUI().repaint();   
            getLoginGUI().setSize(getLoginGUI().getMinimumSize());

        } else if (e.getSource() == getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().getCancelar()) {
            getLoginGUI().remove(getLoginGUI().getPanelCadastro());
             getLoginGUI().setMinimumSize(new Dimension(1400, 700));
            getLoginGUI().add(getLoginGUI().getCadastroGUI(), BorderLayout.CENTER);

            getLoginGUI().getCadastroGUI().setVisible(true);
            getLoginGUI().repaint();

        }

    }
    
    
}
