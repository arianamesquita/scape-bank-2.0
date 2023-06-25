package DataBase.ContaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void criarConta(Conta conta) {

        String sql = "insert into conta(id, numeroConta, numeroCartao, login, senha, numeroAgencia, idFuncionario," + 
                        "idCliente, chavePix) values (?,?,?,?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, geraId());
            pstm.setString(2, geraNumConta());
            pstm.setString(3, geraNumCartao());
            pstm.setString(4, conta.getLogin());
            pstm.setString(5, conta.getSenha());
            pstm.setInt(6, conta.getAgencia().getBanco().getCodigo());
            pstm.setInt(7, conta.getFuncionario().getId());
            pstm.setInt(8, conta.getCliente().getId());
            pstm.setString(9, conta.getPagamentos().getChavePix());


            pstm.execute();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");

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

            rset = pstm.executeQuery();

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

}
