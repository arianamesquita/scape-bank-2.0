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

            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void removeById(int idTransacao){

        String sql = "delete from transacoes where id = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, idTransacao);

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

    public List<Conta> getTransacoes(){

        String sql = "Select * from transacoes";

        List<Conta> transacoes = new ArrayList<Conta>();

        try{

            Conta conta = new Conta();

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            while(rset.next()){

                conta.setIdTransacao(rset.getInt("id"));
                conta.setTipoTransacao(rset.getString("tipoTransacao"));
                conta.setDataTransacao(rset.getDate("dataTransacao"));
                conta.setValorTransacao(rset.getString("valorTransacao"));
                conta.setNumeroContaDestino(rset.getString("numeroContaDestino"));
                conta.setId(rset.getInt("idOrigem"));

                transacoes.add(conta);
            }

            conexao.Desconecta();            
        } catch (Exception e){
            e.printStackTrace();
        }

        return transacoes;
    }
    
}
