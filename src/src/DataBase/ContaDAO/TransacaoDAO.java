package DataBase.ContaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import model.Conta;

public class TransacaoDAO {

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset = null;

    public void criar(Conta conta) {

        String sql = "insert into transacoes(id, tipoTransacao, dataTransacao, valorTransacao, numeroContaDestino,"+
                        "idOrigem) values (?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, conta.getIdTransacao());
            pstm.setString(2, conta.getTipoTransacao());
            pstm.setDate(3, conta.getDataTransacao());
            pstm.setString(4, conta.getValorTransacao());
            pstm.setString(5, conta.getNumeroContaDestino());
            pstm.setInt(6, conta.getId());

            pstm.execute();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
        conexao.Desconecta();
    }

    public void removeById(int idTransacao){

        String sql = "delete from transacoes where id = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, idTransacao);

            pstm.execute();
        

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
        conexao.Desconecta();
    
    }

    public List<Conta> getTransacoes(){

        String sql = "Select * from transacoes";

        List<Conta> transacoes = new ArrayList<Conta>();

        try{

            Conta conta = new Conta();

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){

                conta.setIdTransacao(rset.getInt("id"));
                conta.setTipoTransacao(rset.getString("tipoTransacao"));
                conta.setDataTransacao(rset.getDate("dataTransacao"));
                conta.setValorTransacao(rset.getString("valorTransacao"));
                conta.setNumeroContaDestino(rset.getString("numeroContaDestino"));
                conta.setId(rset.getInt("idOrigem"));

                transacoes.add(conta);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        conexao.Desconecta();  
        return transacoes;
    }

    public Conta getTransacaoById(int id){

        Conta conta = new Conta();
        String sql = "Select * from transacoes where id = ?";

        try{

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

            rset = pstm.executeQuery();

            while(rset.next()){

                conta.setIdTransacao(rset.getInt("id"));
                conta.setTipoTransacao(rset.getString("tipoTransacao"));
                conta.setDataTransacao(rset.getDate("dataTransacao"));
                conta.setValorTransacao(rset.getString("valorTransacao"));
                conta.setNumeroContaDestino(rset.getString("numeroContaDestino"));
                conta.setId(rset.getInt("idOrigem"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        conexao.Desconecta();  
        return conta;
    }

    public List<Conta> getTransacoesConta (Conta conta){

        String sql = "Select valorTransacao, numeroContaDestino, idOrigem from transacoes where " +
                        "numeroContaDestino = ? or idOrigem = ?";
        List<Conta> transacoes = new ArrayList<Conta>();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            pstm.setString(1, conta.getNumeroConta());
            pstm.setInt(2, conta.getId());
            pstm.execute();

            rset = pstm.executeQuery();

            while(rset.next()){

                conta.setValorTransacao(rset.getString("valorTransacao"));
                conta.setNumeroContaDestino(rset.getString("numeroContaDestino"));
                conta.setId(rset.getInt("idOrigem"));

                transacoes.add(conta);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        conexao.Desconecta();  
        return transacoes;

    }

    public float getSaldoConta(Conta conta){

        List<Conta> transacoes = getTransacoesConta(conta);
        float saldo = 0;
        System.out.println(transacoes);
        for (Conta conta2 : transacoes) {
            if(conta2.getNumeroConta().equals(conta.getNumeroContaDestino())){
                saldo += Float.parseFloat(conta2.getValorTransacao());
            } else saldo -= Float.parseFloat(conta2.getValorTransacao());            
        }

        return saldo;
    }
}
