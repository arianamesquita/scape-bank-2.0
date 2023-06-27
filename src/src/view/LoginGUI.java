package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AccessScreen.FrameComponents.FrameComponents;
import MainScreen.Components.CustomJframe.Jframe;
import controller.ContaController;
import controller.PessoaFisicaController;

public class LoginGUI extends Jframe  {
    private JPanel panelCadastro;
    private PessoaFisicaController pessoaFisicaController;
    private FrameComponents cadastroGUI;
    private ContaController contaController;

    public LoginGUI() {

        setTitle("Scape Bank");
        setLayout(new BorderLayout());
        setExtendedState(MAXIMIZED_HORIZ);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panelCadastro = new JPanel();
        panelCadastro.setOpaque(false);
        panelCadastro.setLayout(new GridBagLayout());

        panelCadastro.setVisible(false);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setVisible(true);

        JLabel label = new JLabel("cadastro de usuario:");
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(label);

        this.contaController = new ContaController();
        contaController.getContaGUI().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(contaController.getContaGUI());
        contaController.getContaGUI().setVisible(false);

        this.pessoaFisicaController = new PessoaFisicaController();
        pessoaFisicaController.setLoginGUI(this);
        pessoaFisicaController.getPessoaFisicaGUI().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(pessoaFisicaController.getPessoaFisicaGUI());
        pessoaFisicaController.getPessoaFisicaGUI().setVisible(true);

        RainbowPanel rainbowPanel = new RainbowPanel();
        rainbowPanel.setBackground(Color.BLACK);
        rainbowPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.9;
        gbc.weighty = 2.0;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelCadastro.add(rainbowPanel, gbc);

        gbc.weightx = 1.1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelCadastro.add(panel, gbc);

        cadastroGUI = new FrameComponents();
        cadastroGUI.setOpaque(false);
      

        add(cadastroGUI, BorderLayout.CENTER);
        cadastroGUI.setVisible(true);
      

        repaint();
        setSize(cadastroGUI.getSize());
        setSize(getMinimumSize());
        setVisible(true);
  

    }



    public JPanel getPanelCadastro() {
        return panelCadastro;
    }

    public void setPanelCadastro(JPanel panelCadastro) {
        this.panelCadastro = panelCadastro;
    }

    public PessoaFisicaController getPessoaFisicaController() {
        return pessoaFisicaController;
    }

    public void setPessoaFisicaController(PessoaFisicaController pessoaFisicaController) {
        this.pessoaFisicaController = pessoaFisicaController;
    }

    public FrameComponents getCadastroGUI() {
        return cadastroGUI;
    }

    public void setCadastroGUI(FrameComponents cadastroGUI) {
        this.cadastroGUI = cadastroGUI;
    }



    public ContaController getContaController() {
        return contaController;
    }



    public void setContaController(ContaController contaController) {
        this.contaController = contaController;
    }

    


}
