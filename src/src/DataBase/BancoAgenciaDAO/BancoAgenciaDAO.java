package DataBase.BancoAgenciaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import model.Agencia;
import model.Banco;

public class BancoAgenciaDAO{

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset = null;

    public void criar(Agencia agencia) {

        String sql = "insert into bancoAgencia(nomeBanco, codigoBanco, numeroAgencia, enderecoAgencia, telefoneAgencia)" +
                        "values (?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, agencia.getBanco().getNome());
            pstm.setInt(2, agencia.getBanco().getCodigo());
            pstm.setString(3, agencia.getNumeroAgencia());
            pstm.setString(4, agencia.getEndereco());
            pstm.setString(5, agencia.getTelefone());

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

    public void removeById(int codigoBanco){
        String sql = "delete from bancoAgencia where id = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, codigoBanco);

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

    public void update (Agencia agencia){
        String sql = "update bancoAgencia set enderecoAgencia = ?, telefoneAgencia = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, agencia.getEndereco());
            pstm.setString(2, agencia.getTelefone());

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

    public List<Agencia> getAgencias(){

        String sql = "select * from bancoAgencia";

        List<Agencia> agencias = new ArrayList<Agencia>();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Agencia agencia = new Agencia();
                Banco banco = new Banco();

                banco.setNome(rset.getString("nomeBanco"));
                banco.setCodigo(rset.getInt("codigoBanco"));
                agencia.setBanco(banco);
                agencia.setEndereco(rset.getString("enderecoAgencia"));
                agencia.setNumeroAgencia(rset.getString("numeroAgencia"));
                agencia.setTelefone(rset.getString("telefoneAgencia"));

                agencias.add(agencia);
            }

            conexao.Desconecta();            
        } catch (Exception e){
            e.printStackTrace();
        }

        return agencias;
    }
}
