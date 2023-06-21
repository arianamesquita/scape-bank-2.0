package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AccessScreen.FrameComponents.FrameComponents;
import MainScreen.Components.CustomJframe.Jframe;
import controller.PessoaFisicaController;

public class LoginGUI extends Jframe implements ActionListener {
    private JPanel panelCadastro;
    private PessoaFisicaController pessoaFisicaController;
    private FrameComponents cadastroGUI;

    public LoginGUI() {

        setTitle("Scape Bank");
        setLayout(null);
        setExtendedState(MAXIMIZED_HORIZ);
        setResizable(false);

        this.panelCadastro = new JPanel();
        panelCadastro.setLayout(new BoxLayout(panelCadastro, BoxLayout.Y_AXIS));
        panelCadastro.setBounds(0, 0, 600, 500);
        panelCadastro.setVisible(false);

        this.pessoaFisicaController = new PessoaFisicaController();
        panelCadastro.add(new JLabel("cadastro de usuario:"));
        pessoaFisicaController.getPessoaFisicaGUI().setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panelCadastro.add(pessoaFisicaController.getPessoaFisicaGUI());

        cadastroGUI = new FrameComponents();
        addActionListener();


        add(cadastroGUI);
        add(panelCadastro);
        setSize(cadastroGUI.getSize());
        setVisible(true);

    }
    private void addActionListener(){
        cadastroGUI.getButton()[1].addActionListener(this);
        pessoaFisicaController.getPessoaFisicaGUI().getCancelar().addActionListener(this);
        pessoaFisicaController.getPessoaFisicaGUI().getSalvar().addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getCadastroGUI().getButton()[1]) {
            getPessoaFisicaController().updateInterface();
            getCadastroGUI().setVisible(false);
            setSize(getPanelCadastro().getSize());
            getPanelCadastro().setVisible(true);
            

        } else if (e.getSource() == getPessoaFisicaController().getPessoaFisicaGUI().getCancelar()) {
            getCadastroGUI().setVisible(true);
            setSize(getCadastroGUI().getSize());
            getPanelCadastro().setVisible(false);
        

        } else if (e.getSource() == getPessoaFisicaController().getPessoaFisicaGUI().getSalvar()) {
            getPessoaFisicaController().Salvar();

            while (!getPessoaFisicaController().isCadastrado()) {
            }
            if(getPessoaFisicaController().isCadastrado()){
            getCadastroGUI().setVisible(true);
            setSize(getCadastroGUI().getSize());
            getPanelCadastro().setVisible(false);
            getPessoaFisicaController().setCadastrado(false);
        }
         

        }

    }
    public static void main(String[] args) {
        new LoginGUI();
    }

}
