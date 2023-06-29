package DataBase.ContaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.ClienteDAO.PessoaFisicaDAO;
import model.Agencia;
import model.Conta;
import model.Funcionario;
import model.Pagamentos;
import model.PessoaFisica;

public class ContaDAO {

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset;

    public void criarConta(Conta conta) {

        String sql = "insert into conta(id, numeroConta, numeroCartao, login, senha, numeroAgencia, idFuncionario," + 
                        "idCliente, chavePix, validadeCartao, cvc, senhaConta) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, geraId());
            pstm.setString(2, geraNumConta());
            pstm.setString(3, geraNumCartao());
            pstm.setString(4, conta.getLogin());
            pstm.setString(5, conta.getSenha());
            pstm.setInt(6, 1);
            //conta.getAgencia().getBanco().getCodigo()
            pstm.setInt(7, 1);
            //conta.getFuncionario().getId()
            pstm.setInt(8, conta.getCliente().getId());
            pstm.setString(9, geraChavePix(conta.getCliente()));
            pstm.setString(10, geraDataValidadeCartao());
            pstm.setInt(11, geraCVC());
            pstm.setString(12, conta.getSenhaConta());

            pstm.execute();

            if(pstm.getUpdateCount()>0){
                System.out.println("Salvo com sucesso!");
            } else 
                System.out.println("Não foi possível inserir!");

            conexao.Desconecta();
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void removeById(int id){

        String sql = "delete from conta where id = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
            
            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");

            conexao.Desconecta();
        } catch (Exception e){
            e.printStackTrace();
        } 
    
    }
    public void atualizar(Conta conta) throws SQLException{
        Conexao conexao = null;
        String sql = "UPDATE conta SET login = ?, senhaConta = ? WHERE id = ?";

        conexao = Factory.creatConnectionToMySQL();
        conexao.Conecta();
        conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
        conexao.getPstmt().setString(1, conta.getLogin());
        conexao.getPstmt().setString(2, conta.getSenhaConta());
        conexao.getPstmt().setInt(3, conta.getId());

        conexao.getPstmt().executeUpdate();
        conexao.Desconecta();
    }

    public void update(Conta conta){

        String sql = "update conta set numeroCartao = ?, login = ?, senhaConta = ?, " + 
                    "chavePix = ?, senhaConta = ?) values" + 
                     "(?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, conta.getNumeroCartao());
            pstm.setString(2, conta.getLogin());
            pstm.setString(3, conta.getSenha());
            pstm.setString(4, conta.getPagamentos().getChavePix());
            pstm.setString(5, conta.getSenhaConta());

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

    public List<Conta> getContas(){

        String sql = "Select * from conta";

        List<Conta> contas = new ArrayList<Conta>();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                
                Conta conta = new Conta();
                Agencia agencia = new Agencia();
                Funcionario funcionario = new Funcionario();
                PessoaFisica cliente = new PessoaFisica();
                Pagamentos pagamentos = new Pagamentos();

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
                pagamentos.setChavePix(rset.getString("chavePix"));
                conta.setPagamentos(pagamentos);

                contas.add(conta);
            }
           
        } catch (Exception e){
            e.printStackTrace();
        }

        conexao.Desconecta(); 
        return contas;
    }

    public Conta searchById(int id){

        String sql = "Select * from conta where id = ?";

        Conta conta = new Conta();

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            pstm.setInt(1, id);

            rset = pstm.executeQuery();

            while(rset.next()){
                
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

            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        conexao.Desconecta(); 

        return conta;
    }

    public String searchByChavePix(String chavePix){

        String sql = "Select numeroConta from conta where chavePix = ?";

        String numConta = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);
            pstm.setString(1, chavePix);

            rset = pstm.executeQuery();
            
            while(rset.next()){
                numConta = rset.getString("numeroConta");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        conexao.Desconecta(); 

        return numConta;
    }

    public void deleteChavePix(Conta conta){

        String sql = "update conta set chavePix = null where id = ?";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, conta.getId());

            pstm.execute();
            
            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");

        } catch (Exception e){
            e.printStackTrace();
        } 
        conexao.Desconecta();

    }

    public void criaChavePix(Conta conta){

        String sql = "update conta set chavePix = ? where id = ?";
        PessoaFisicaDAO pessoaFisica = new PessoaFisicaDAO();

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, geraChavePix(pessoaFisica.ler(conta.getCliente().getId())));
            pstm.setInt(2, conta.getId());

            pstm.execute();
            
            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
        conexao.Desconecta();

    }

    public static String geraNumConta() {
        List<Conta> contas = new ContaDAO().getContas();
        String numConta = null;
        if (contas.isEmpty()){
            Random ran = new Random();
            int number = ran.nextInt(0,999);
            int digito = ran.nextInt(0, 9);
            numConta = ("000" + number + "-" + digito);
        }
        for (Conta conta : contas) {
            do{
                Random ran = new Random();
                int number = ran.nextInt(0,999);
                int digito = ran.nextInt(0, 9);
                numConta = ("000" + number + "-" + digito);
            } while (numConta.equals(conta.getNumeroConta()));
        }
        return numConta;
    }

    public static String geraNumCartao() {
        List<Conta> contas = new ContaDAO().getContas();
        String numCartao = null;
        if (contas.isEmpty()){
            Random ran = new Random();
            int number1 = ran.nextInt(0,9999);
            int number2 = ran.nextInt(0,9999);
            int number3 = ran.nextInt(0,9999);
            int number4 = ran.nextInt(0,9999);
            numCartao = (number1 + " " + number2 + " " + number3 + " " + number4);
        }
        for (Conta conta : contas) {
            do{
                Random ran = new Random();
                int number1 = ran.nextInt(0,9999);
                int number2 = ran.nextInt(0,9999);
                int number3 = ran.nextInt(0,9999);
                int number4 = ran.nextInt(0,9999);
                numCartao = (number1 + " " + number2 + " " + number3 + " " + number4);
            } while (numCartao.equals(conta.getNumeroCartao()));
        }
        return numCartao;
    }

    public static int geraId() {
        int count = 0;
        List<Conta> contas = new ContaDAO().getContas();
        for (Conta conta : contas) {
            if(count < conta.getId()){
                count = conta.getId();
            }
        }
       
        return count + 1;
    }

    public static String geraDataValidadeCartao() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 4);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String data = s.format(c.getTime());      
        return data;
    }

    public static int geraCVC() {
        int cvc = 0;
        List<Conta> contas = new ContaDAO().getContas();
        if (contas.isEmpty()){
            Random ran = new Random();
            cvc = ran.nextInt(0,999);
        }
        for (Conta conta : contas) {
            do{
            Random ran = new Random();
            cvc = ran.nextInt(0,999);
            } while (cvc == conta.getCvc());
        }
        return cvc;
    }

    public static String geraChavePix(PessoaFisica pessoaFisica){

        Random ran = new Random();
        String chavePix = null;
        int opcao = ran.nextInt(1,3);
        if (opcao == 1){
            chavePix = pessoaFisica.getDocIdentificacao();
        } else chavePix = pessoaFisica.getTelefone();

        return chavePix;
    }

}
