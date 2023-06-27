package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.FuncionarioDAO;
import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import model.Funcionario;
import view.FuncionarioGUI;

public class FuncionarioController implements ActionListener {
    private EnderecoController enderecoController;
    private FuncionarioGUI funcionarioGUI;
    private Funcionario funcionario;

    public FuncionarioController() {
        this.funcionario = new Funcionario();
        this.enderecoController = new EnderecoController();
        this.funcionarioGUI = new FuncionarioGUI(enderecoController.getEnderecoGUI());
        enderecoController.setEndereco(
                "Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");
        setFuncionario(new Funcionario(0, "digite o seu nome", enderecoController.getEndereco(), null,
                0, "digite seu cargo", 0, "digite seu cpf"));
        getFuncionarioGUI().getSalvar().addActionListener(this);
    }

    public void addFocusListener() {
        getFuncionarioGUI().getNomeTextField()
                .addFocusListener(new createFocusListenerTextField(getFuncionarioGUI().getNomeTextField()));
        getEnderecoController().setEndereco(getFuncionario().getEndereco());
        getFuncionarioGUI().getTelefoneFormattedTextField().addFocusListener(
                new createFocusListenerFormatField(getFuncionarioGUI().getTelefoneFormattedTextField()));
        getFuncionarioGUI().getSalarioLabelTextField()
                .addFocusListener(new createFocusListenerTextField(getFuncionarioGUI().getSalarioLabelTextField()));
        getFuncionarioGUI().getCargoTextField()
                .addFocusListener(new createFocusListenerTextField(getFuncionarioGUI().getCargoTextField()));
        getFuncionarioGUI().getCodBancoJTextField()
                .addFocusListener(new createFocusListenerTextField(getFuncionarioGUI().getCodBancoJTextField()));
        getFuncionarioGUI().getCpfFormattedTextField()
                .addFocusListener(new createFocusListenerFormatField(getFuncionarioGUI().getCpfFormattedTextField()));
        getFuncionarioGUI().repaint();
    }

    private void Salvar() {
        String nome = getFuncionarioGUI().getNomeTextField().getText();
        String endereco = getEnderecoController().getEndereco();
        String Telefone = getFuncionarioGUI().getTelefoneFormattedTextField().getText().replace("(", "")
                .replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble(getFuncionarioGUI().getsalarioLabelTextField().getText());
        String cpf = getFuncionarioGUI().getCpfFormattedTextField().getText().replace(".", "").replace("-", "");
        String cargo = getFuncionarioGUI().getCargoTextField().getText();
        int codBanco = Integer.parseInt(getFuncionarioGUI().getCodBancoJTextField().getText());

        Funcionario funcionario = new Funcionario(geraId(), nome, endereco, Telefone, rendaAtual, cargo, codBanco, cpf);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            funcionarioDAO.criar(funcionario);
            JOptionPane.showMessageDialog(getFuncionarioGUI(), "pessoa gravada com sucesso");

        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        getFuncionarioGUI().removeAll();
        getFuncionarioGUI().repaint();
    }

    private int geraId() {
        int count = 0;
        for (Funcionario funcionario : new FuncionarioDAO().listarTodos()) {
            if (count < funcionario.getId()) {
                count = funcionario.getId();
            }
        }
        return count + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getFuncionarioGUI().getSalvar()) {
            Salvar();

        }
    }

    public FuncionarioGUI getFuncionarioGUI() {
        return funcionarioGUI;
    }

    public void setFuncionarioGUI(FuncionarioGUI funcionarioGUI) {

        this.funcionarioGUI = funcionarioGUI;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {

        this.funcionario = funcionario;
        getFuncionarioGUI().getNomeTextField().setText(funcionario.getNome());
        getEnderecoController().setEndereco(funcionario.getEndereco());
        getFuncionarioGUI().getTelefoneFormattedTextField().setText(funcionario.getTelefone());
        getFuncionarioGUI().getsalarioLabelTextField().setText(String.valueOf(funcionario.getRendaAtual()));
        getFuncionarioGUI().getCargoTextField().setText(funcionario.getCargo());
        getFuncionarioGUI().getCodBancoJTextField().setText(String.valueOf(funcionario.getCodigoBanco()));
        getFuncionarioGUI().getCpfFormattedTextField().setText(funcionario.getDocIdentificacao());
        addFocusListener();

    }

    public EnderecoController getEnderecoController() {
        return enderecoController;
    }

    public void setEnderecoController(EnderecoController enderecoController) {
        this.enderecoController = enderecoController;
    }

}
