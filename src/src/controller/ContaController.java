package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import DataBase.ContaDAO.ContaDAO;
import model.Conta;
import model.Pagamentos;
import model.PessoaFisica;

public class ContaController {

    private Conta conta;
    private PessoaFisica pessoaFisica;
    private Pagamentos pagamentos;

    private void salvaInformacoes(){
        conta.setLogin(null);
        conta.setSenha(null);
        conta.setSenhaConta(null);
        pessoaFisica.setId(0);
        conta.setCliente(pessoaFisica);
        pagamentos.setChavePix(null);
        conta.setPagamentos(pagamentos);
        System.out.println("Criando conta...");
        ContaDAO contaDAO = new ContaDAO();
        try{
            contaDAO.criarConta(conta);;
        } catch (Exception e){
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
        }
        listar();
    }

    private void atualizar(){
        conta.setCartao(null);
        conta.setLogin(null);
        conta.setSenha(null);
        pagamentos.setChavePix(sql);
        conta.setPagamentos(pagamentos);
        conta.setSenhaConta(null);
        System.out.println("Atualizando a conta...");
        ContaDAO contaDAO = new ContaDAO();
        try{
            contaDAO.update(conta);;
        } catch (Exception e){
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
        }
        listar();
    }

    private void deletar() {
        conta.setId(0);

        System.out.println("Deletando a conta...");
        ContaDAO contaDAO = new ContaDAO();
        try{
            contaDAO.removeById(conta.getId());;
        } catch (Exception e){
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, e);
        }
        listar();
    }

    private void listar(){
        ContaDAO dao = new ContaDAO();

        String[] colunas = {"id", "numeroConta", "numeroCartao", "login", "senha", "numeroAgencia", "idFuncionario", 
                        "idCliente", "chavePix", "validadeCartao", "cvc", "senhaConta"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colunas);
        
        //DefaultTableModel dados = (DefaultTableModel); //aqui na frente pegaria o modelo da tela

        List<Conta> contas = null;
        try{
            contas = dao.getContas();
        } catch (Exception ex){
            Logger.getLogger(ContaController.class.getName()).getLog(Level.SEVERE, null, ex);
        }
        
        for (Conta conta : contas) {
            String[] dado = new String [colunas.length];
            dado[0] = Integer.toString(conta.getId());
            dado[1] = conta.getNumeroConta();
            dado[2] = conta.getNumeroCartao();
            dado[3] = conta.getLogin();
            dado[4] = conta.getSenha();
            dado[5] = conta.getAgencia().getNumeroAgencia();
            dado[6] = Integer.toString(conta.getFuncionario().getId());
            dado[7] = Integer.toString(conta.getCliente().getId());
            dado[8] = conta.getPagamentos().getChavePix();
            dado[9] = conta.getValidadeCartao();
            dado[10] = Integer.toString(conta.getCvc());
            dado[11] = conta.getSenhaConta();
            //dados.addRow(dado); ---> linha comentada ali em cima.
        }

        //setvisible
    }

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
