package DataBase.BancoAgenciaDAO;

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
    ResultSet rset;

    /**
     * Cria uma nova agência no banco de dados.
     *
     * @param agencia A agência a ser criada.
     */
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

    /**
     * Cria um novo banco no banco de dados.
     *
     * @param banco O banco a ser criado.
     */
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

    /**
     * Remove um banco do banco de dados com base no código do banco.
     *
     * @param codigoBanco O código do banco a ser removido.
     */
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

    /**
     * Remove uma agência do banco de dados com base no número da agência.
     *
     * @param numAgencia O número da agência a ser removida.
     */
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

    /**
     * Atualiza os dados de uma agência no banco de dados.
     *
     * @param agencia A agência com os dados atualizados.
     */
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

    /**
     * Retorna uma lista de todas as agências do banco de dados.
     *
     * @return Uma lista de agências.
     */
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

    /**
     * Retorna uma lista de todos os bancos do banco de dados.
     *
     * @return Uma lista de bancos.
     */
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

    /**
     * Pesquisa uma agência com base no número da agência.
     *
     * @param numAgencia O número da agência a ser pesquisada.
     * @return A agência encontrada ou null se não encontrada.
     */
    public Agencia searchByCode(String numAgencia){

        String sql = "Select * from bancoAgencia where numeroAgencia = ?";

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
        } 
        conexao.Desconecta();
        return agencia;

    }

    /**
     * Gera um código de banco único para ser usado ao criar um novo banco.
     *
     * @return O código de banco gerado.
     */
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

    /**
     * Gera um número de agência único para ser usado ao criar uma nova agência.
     *
     * @return O número de agência gerado.
     */
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
