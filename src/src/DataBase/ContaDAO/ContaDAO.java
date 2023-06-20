package DataBase.ContaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import model.Agencia;
import model.Conta;
import model.Funcionario;
import model.PessoaFisica;

public class ContaDAO {

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset = null;

    public void criar(Conta conta) {

        String sql = "insert into conta(numeroConta, numeroCartao, login, senha, codigoBanco, idFuncionario," + 
                        "idCliente) values (?,?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, conta.getNumeroConta());
            pstm.setString(2, conta.getNumeroCartao());
            pstm.setString(3, conta.getLogin());
            pstm.setString(4, conta.getSenha());
            pstm.setInt(5, conta.getAgencia().getBanco().getCodigo());
            pstm.setInt(6, conta.getFuncionario().getId());
            pstm.setInt(7, conta.getCliente().getId());

            pstm.execute();

            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void removeById(String numeroConta){

        String sql = "delete from conta where numeroConta = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, numeroConta);

            pstm.execute();
            
            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    
    }

    public void update(Conta conta){

        String sql = "update conta set numeroConta = ?, numeroCartao = ?, login = ?, senha = ?, " + 
                     "codigoBanco = ?, idFuncionario = ?, idCliente = ?) values" + 
                     "(?,?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, conta.getNumeroConta());
            pstm.setString(2, conta.getNumeroCartao());
            pstm.setString(3, conta.getLogin());
            pstm.setString(4, conta.getSenha());
            pstm.setInt(5, conta.getAgencia().getBanco().getCodigo());
            pstm.setInt(6, conta.getFuncionario().getId());
            pstm.setInt(7, conta.getCliente().getId());
            pstm.setString(8, conta.getPagamentos().getChavePix());

            pstm.execute();
            
            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 

    }

    public List<Conta> getContas(){

        String sql = "Select * from conta";

        List<Conta> contas = new ArrayList<Conta>();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            while(rset.next()){
                
                Conta conta = new Conta();
                Agencia agencia = new Agencia();
                Funcionario funcionario = new Funcionario();
                PessoaFisica cliente = new PessoaFisica();

                conta.setId(rset.getInt("id"));
                conta.setLogin(rset.getString("login"));
                conta.setSenha(rset.getString("senha"));
                conta.setSenhaConta(rset.getString("senhaConta"));
                conta.setNumeroConta(rset.getString("numeroConta"));
                conta.setNumeroCartao(rset.getString("numeroCartao"));
                conta.setValidadeCartao(rset.getString("validadeCartao"));
                conta.setCvc(rset.getInt("cvc"));
                agencia.setNumeroAgencia(rset.getString("numeroAgencia"));
                conta.setAgencia(agencia);
                funcionario.setId(rset.getInt("idFuncionario"));
                conta.setFuncionario(funcionario);
                cliente.setId(rset.getInt("idCliente"));
                conta.setCliente(cliente);

                contas.add(conta);
            }
            conexao.Desconecta();            
        } catch (Exception e){
            e.printStackTrace();
        }

        return contas;
    }



}
