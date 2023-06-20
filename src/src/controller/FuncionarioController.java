package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.FuncionarioDAO;
import model.Funcionario;
import view.FuncionarioGUI;

public class FuncionarioController implements ActionListener {
    private EnderecoController enderecoController;
    private FuncionarioGUI funcionarioGUI;
    private Funcionario funcionario;
    

    public FuncionarioController() {
        this.enderecoController = new EnderecoController();
        enderecoController.setEndereco("Digite a sua rua- -___- -Digite o seu bairro- -Digite o complemento- -Digite o seu estado- -Digite a sua cidade- -_____-___");
        this.funcionarioGUI = new FuncionarioGUI(enderecoController.getEgGui());

        setFuncionario(new Funcionario(0, "digite o seu nome", enderecoController.getEndereco(), "null", 0, null, 0, null));
        getFuncionarioGUI().getSalvar().addActionListener(this);

    }

    private void Salvar() {
        String nome = getFuncionarioGUI().getNomeTextField().getText();
        String endereco = getEnderecoController().getEndereco();
        String Telefone = getFuncionarioGUI().getTelefoneFormattedTextField().getText().replace("(", "").replace(")", "")
                .replace("-", "");
        double rendaAtual = Double.parseDouble(getFuncionarioGUI().getsalarioLabelTextField().getText());
        String cpf = getFuncionarioGUI().getCpfFormattedTextField().getText().replace(".", "").replace("-", "");
        String cargo = getFuncionarioGUI().getCargoTextField().getText();
        int codBanco = Integer.parseInt(getFuncionarioGUI().getCodBancoJTextField().getText());

        Funcionario funcionario = new Funcionario(geraId(), nome, endereco, Telefone, rendaAtual, cargo, codBanco, cpf);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.criar(funcionario);



        JOptionPane.showMessageDialog(getFuncionarioGUI(), "pessoa gravada com sucesso");
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
    return count+1;
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
    }

    public EnderecoController getEnderecoController() {
        return enderecoController;
    }

    public void setEnderecoController(EnderecoController enderecoController) {
        this.enderecoController = enderecoController;
    }


}
