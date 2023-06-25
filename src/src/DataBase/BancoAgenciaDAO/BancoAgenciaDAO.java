package DataBase.BancoAgenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import model.Agencia;
import model.Banco;

public class BancoAgenciaDAO{

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset = null;

    public void criarAgencia(Agencia agencia) {

        String sql = "insert into bancoAgencia(codigoBanco, numeroAgencia, enderecoAgencia," +
                        "telefoneAgencia) values (?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(2, agencia.getBanco().getCodigo());
            pstm.setString(3, geraNumAgencia());
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

    public void criarBanco(Banco banco) {

        String sql = "insert into bancoAgencia(nomeBanco, codigoBanco) values (?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, banco.getNome());
            pstm.setInt(2, geraCodBanco());

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
        String sql = "delete from bancoAgencia where codigoBanco = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, codigoBanco);

            pstm.execute();

            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void removeByNumAgencia(String numAgencia){
        String sql = "delete from bancoAgencia where numeroAgencia = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, numAgencia);

            pstm.execute();

            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void update (Agencia agencia){
        String sql = "update bancoAgencia set enderecoAgencia = ?, telefoneAgencia = ? where numeroAgencia = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, agencia.getEndereco());
            pstm.setString(2, agencia.getTelefone());
            pstm.setString(3, agencia.getNumeroAgencia());

            pstm.execute();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");

            conexao.Desconecta();
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

    public List<Banco> getBancos(){

        String sql = "select nomeBanco, codigoBanco from bancoAgencia;";

        List<Banco> bancos = new ArrayList<Banco>();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Banco banco = new Banco();

                banco.setNome(rset.getString("nomeBanco"));
                banco.setCodigo(rset.getInt("codigoBanco"));

                bancos.add(banco);
            }

            conexao.Desconecta();            
        } catch (Exception e){
            e.printStackTrace();
        }

        return bancos;
    }

    public Agencia searchByCode(String numAgencia){

        String sql = "Select * from bancoAgencia where numeroAgencia = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Banco banco = new Banco();
        Agencia agencia = new Agencia();

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            pstm.setString(1, numAgencia);
            rset = pstm.executeQuery();

            if (rset.next()) {
                banco.setCodigo(rset.getInt("codigoBanco"));
                banco.setNome(rset.getString("nomeBanco"));
                agencia.setBanco(banco);
                agencia.setEndereco(rset.getString("enderecoAgencia"));
                agencia.setNumeroAgencia(rset.getString("numeroAgencia"));
                agencia.setTelefone(rset.getString("telefoneAgencia"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return agencia;

    }

    public static int geraCodBanco() {
        int count = 0;
        List<Banco> bancos = new BancoAgenciaDAO().getBancos();
        int codigoBanco = 0;
        for (Banco banco : bancos) {
            if(count < banco.getCodigo()){
                count = banco.getCodigo();
            }
            codigoBanco = count + 1;
        }
        return codigoBanco;
    }

    public static String geraNumAgencia() {
        List<Agencia> agencias = new BancoAgenciaDAO().getAgencias();
        String numeroAg = null;
        for (Agencia agencia : agencias) {
            do{
                Random ran = new Random();
                int number = ran.nextInt(0,999);
                numeroAg = ("000" + number);
            } while (numeroAg.equals(agencia.getNumeroAgencia()));
        }
        return numeroAg;
    }



}
