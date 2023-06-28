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

/**
 * Classe responsável por acessar e manipular os dados dos funcionários no banco de dados.
 */
public class FuncionarioDAO implements InterfaceDAO<Funcionario> {

    /**
     * Cria um novo registro de funcionário no banco de dados.
     *
     * @param objeto o objeto Funcionario a ser criado
     */
    @Override
    public void criar(Funcionario objeto) {
        Conexao conexao = null;
        String query = "INSERT INTO funcionario (id, nomeFuncionario, endereco, telefone, cargo, codigoBanco, cpf, salario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(query));
            conexao.getPstmt().setInt(1, objeto.getId());
            conexao.getPstmt().setString(2, objeto.getNome());
            conexao.getPstmt().setString(3, objeto.getEndereco());
            conexao.getPstmt().setString(4, objeto.getTelefone());
            conexao.getPstmt().setString(5, objeto.getCargo());
            conexao.getPstmt().setInt(6, objeto.getCodigoBanco());
            conexao.getPstmt().setString(7, objeto.getDocIdentificacao());
            conexao.getPstmt().setDouble(8, objeto.getRendaAtual());

            conexao.getPstmt().executeUpdate();
            System.out.println("Dados inseridos com sucesso na tabela funcionario.");
        } catch (SQLException e) {

            System.out.println("Erro ao inserir dados na tabela funcionario: " + e.getMessage());

        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

    /**
     * Lê um funcionário do banco de dados com base no ID fornecido.
     *
     * @param id o ID do funcionário a ser lido
     * @return o objeto Funcionario correspondente ao ID, ou null se não for encontrado
     */
    @Override
    public Funcionario ler(int id) {
        Conexao conexao = null;
        Funcionario pessoa = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setInt(1, id);
            conexao.setResultSet(conexao.getPstmt().executeQuery());

            if (conexao.getResultSet().next()) {
                int pessoaId = conexao.getResultSet().getInt("id");
                String nome = conexao.getResultSet().getString("nomeFuncionario");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double salario = conexao.getResultSet().getDouble("salario");
                String cpf = conexao.getResultSet().getString("cpf");
                String cargo = conexao.getResultSet().getString("cargo");
                int codigoBanco = conexao.getResultSet().getInt("codigoBanco");
                pessoa = new Funcionario(pessoaId, nome, endereco, telefone, salario, cargo, codigoBanco, cpf);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }

        return pessoa;

    }

    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     *
     * @param objeto o objeto Funcionario com os novos dados
     */
    @Override
    public void atualizar(Funcionario objeto) {
        Conexao conexao = null;
        // (int id, String nome, String endereco, String telefone, double salario,
        // String cargo,int codigoBanco,String cpf)

        String sql = "UPDATE funcionario SET nomeFuncionario = ?, endereco = ?, telefone = ?, salario = ?, cargo = ?, codigoBanco = ?  WHERE id = ?";
        ;

        try {

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setString(1, objeto.getNome());
            conexao.getPstmt().setString(2, objeto.getEndereco());
            conexao.getPstmt().setString(3, objeto.getTelefone());
            conexao.getPstmt().setDouble(4, objeto.getRendaAtual());
            conexao.getPstmt().setString(5, objeto.getCargo());
            conexao.getPstmt().setInt(6, objeto.getCodigoBanco());

            conexao.getPstmt().setInt(7, objeto.getId());

            conexao.getPstmt().executeUpdate();

            System.out.println("funcionario atualizada com sucesso");
        } catch (SQLException e) {
            System.out.println("não foi possivel atualizar erro:\n" + e);
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

    /**
     * Deleta um funcionário do banco de dados com base no ID fornecido.
     *
     * @param id o ID do funcionário a ser deletado
     */
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

    /**
     * Lista todos os funcionários registrados no banco de dados.
     *
     * @return uma lista de objetos Funcionario com todos os funcionários registrados
     */
    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> listaPessoas = new ArrayList<>();

        String sql = "SELECT * FROM funcionario";

        Conexao conexao = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.setResultSet(conexao.getPstmt().executeQuery());

            while (conexao.getResultSet().next()) {
                int id = conexao.getResultSet().getInt("id");
                String nome = conexao.getResultSet().getString("nomeFuncionario");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double salario = conexao.getResultSet().getDouble("salario");
                String cpf = conexao.getResultSet().getString("cpf");
                String Cargo = conexao.getResultSet().getString("cargo");
                int codigoBanco = conexao.getResultSet().getInt("codigoBanco");

                listaPessoas.add(new Funcionario(id, nome, endereco, telefone, salario, Cargo, codigoBanco, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
            ;
        }

        return listaPessoas;
    }

}
