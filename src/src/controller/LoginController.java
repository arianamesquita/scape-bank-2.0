package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.ContaDAO.ContaDAO;
import model.Conta;
import view.LoginGUI;
import view.TelaPrincipalView;

public class LoginController implements ActionListener{

    private LoginGUI loginGUI;


    public LoginController(){
        loginGUI = new LoginGUI();
        addActionListener();

    }
private void verificaUser() {
    List<Conta> listuser = new ContaDAO().getContas();
    String login = getLoginGUI().getCadastroGUI().getJTF().getText();
    char[] password = getLoginGUI().getCadastroGUI().getJPF().getPassword();
    String passwordString = new String(password);
    boolean usuarioEncontrado = false;

    for (Conta conta : listuser) {
        if (conta.getLogin().equals(login)) {
            usuarioEncontrado = true;
            if( conta.getSenhaConta().equals(passwordString)){
            
            getLoginGUI().dispose();
            new TelaPrincipalView(conta);
            break;
            }else JOptionPane.showMessageDialog(loginGUI, "senha incorreta");
        
        }
    }

    if (!usuarioEncontrado) {
        JOptionPane.showMessageDialog(loginGUI, "Usuário incorreto!");
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
        getLoginGUI().getContaController().getContaGUI().getCancelar().addActionListener(this);

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
            getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().setVisible(true);
            getLoginGUI().repaint();   
          

        } else if (e.getSource() == getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().getCancelar()) {
            getLoginGUI().remove(getLoginGUI().getPanelCadastro());
        
            getLoginGUI().add(getLoginGUI().getCadastroGUI(), BorderLayout.CENTER);
            getLoginGUI().getCadastroGUI().setVisible(true);
            getLoginGUI().repaint();

        }else if (e.getSource() == getLoginGUI().getContaController().getContaGUI().getCancelar()) {
            getLoginGUI().getContaController().getContaGUI().setVisible(false);
            getLoginGUI().getPessoaFisicaController().apaga();
            getLoginGUI().getPessoaFisicaController().getPessoaFisicaGUI().setVisible(true);
            getLoginGUI().repaint();

        }

    }
    
    
}
