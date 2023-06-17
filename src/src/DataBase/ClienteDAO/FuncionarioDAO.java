package DataBase.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.Funcionario;
import model.PessoaJuridica;

public class FuncionarioDAO implements InterfaceDAO<Funcionario>{
//(int id, String nome, String endereco, String telefone, double rendaAtual, String cargo,int codigoBanco)
    @Override
    public void criar(Funcionario objeto) {
        Conexao conexao = null;
        String query = "INSERT INTO funcionario (id, nomeFuncionario, endereco, telefone, cargo, codigoBanco, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(query));
            conexao.getPstmt().setInt(1, objeto.getId());
            conexao.getPstmt().setString(2, objeto.getNome());
            conexao.getPstmt().setString(3, objeto.getEndereco());
            conexao.getPstmt().setString(4, objeto.getTelefone());
            conexao.getPstmt().setDouble(5, objeto.rendaAtual);
            conexao.getPstmt().setString(6, objeto.getCargo());
            conexao.getPstmt().setInt(7, objeto.getCodigoBanco());

            conexao.getPstmt().executeUpdate();
            System.out.println("Dados inseridos com sucesso na tabela pessoa fisica.");
        } catch (SQLException e) {

            System.out.println("Erro ao inserir dados na tabela pessoa: " + e.getMessage());

        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

    @Override
    public Funcionario ler(int id) {
        Conexao conexao = null;
        PessoaJuridica pessoa = null;
           // public PessoaJuridica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpnj) 
           


        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setInt(1, id);
            conexao.setResultSet(conexao.getPstmt().executeQuery());

            if (conexao.getResultSet().next()) {
                int pessoaId = conexao.getResultSet().getInt("id");
                String nome = conexao.getResultSet().getString("nome");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double rendaAtual = conexao.getResultSet().getDouble("rendaAtual");
                String cnpj = conexao.getResultSet().getString("cnpj");
                pessoa = new PessoaJuridica(pessoaId, nome, endereco, telefone, rendaAtual, cnpj);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }

        return pessoa;

    }

    @Override
    public void atualizar(Funcionario objeto) {
        Conexao conexao = null;

        String sql = "UPDATE funcionario SET nome = ?, endereco = ?, telefone = ?, rendaAtual = ? WHERE id = ?";;

        try {

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setString(1, objeto.getNome());
            conexao.getPstmt().setString(2, objeto.getEndereco());
            conexao.getPstmt().setString(3, objeto.getTelefone());
            conexao.getPstmt().setDouble(4, objeto.getRendaAtual());
            conexao.getPstmt().setInt(5, objeto.getId());

            conexao.getPstmt().executeUpdate();

            System.out.println("pessoa juridica atualizada com sucesso");
        } catch (SQLException e) {
            System.out.println("não foi possivel atualizar erro:\n" + e);
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";

        Conexao conexao = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setInt(1, id);
            conexao.getPstmt().execute();
            if (conexao.getPstmt().getUpdateCount() > 0) {
               System.out.println("Removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "NÃ£o foi possi­vel remover!!");
            }
        } catch (Exception e) {
            System.out.println("erro:\n" + e);
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }
    @Override
    public List<Funcionario> listarTodos() {
        List<PessoaJuridica> listaPessoas = new ArrayList<>();
       
        String sql = "SELECT * FROM funcionario";

        Conexao conexao = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();    
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.setResultSet(conexao.getPstmt().executeQuery());
            
            while (conexao.getResultSet().next()) {
                int id = conexao.getResultSet().getInt("id");
                String nome  = conexao.getResultSet().getString("nome");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double rendaAtual = conexao.getResultSet().getDouble("rendaAtual");
                String cpf = conexao.getResultSet().getString("cnpj");
         
                
                listaPessoas.add(new PessoaJuridica(id, nome, endereco, telefone, rendaAtual, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();;
        }

        return listaPessoas;
    }
    
}
