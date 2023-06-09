package DataBase.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.PessoaFisica;

public class PessoaFisicaDAO implements InterfaceDAO<PessoaFisica> {

    /**
     * Cria um novo registro de PessoaFisica no banco de dados.
     *
     * @param objeto O objeto PessoaFisica a ser criado.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    @Override
    public void criar(PessoaFisica objeto) throws SQLException {

        Conexao conexao = null;
        String query = "INSERT INTO cliente (id, nome, endereco, telefone, cnpj, funcionarioResponsavel, rendaAtual, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        conexao = Factory.creatConnectionToMySQL();
        conexao.Conecta();
        conexao.setPstmt(conexao.getConnection().prepareStatement(query));
        conexao.getPstmt().setInt(1, geraId());
        conexao.getPstmt().setString(2, objeto.getNome());
        conexao.getPstmt().setString(3, objeto.getEndereco());
        conexao.getPstmt().setString(4, objeto.getTelefone());
        conexao.getPstmt().setString(5, null);
        conexao.getPstmt().setString(6, null);
        conexao.getPstmt().setDouble(7, objeto.getRendaAtual());
        conexao.getPstmt().setString(8, objeto.getDocIdentificacao());
        conexao.getPstmt().executeUpdate();
        conexao.Desconecta();
    }

    /**
     * Retorna um objeto PessoaFisica com base no ID fornecido.
     *
     * @param id O ID do objeto a ser lido.
     * @return O objeto PessoaFisica correspondente ao ID, ou null se não encontrado.
     */
    @Override
    public PessoaFisica ler(int id) {
        Conexao conexao = null;
        PessoaFisica pessoa = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            String sql = "SELECT * FROM cliente WHERE id = ?";
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.getPstmt().setInt(1, id);
            conexao.setResultSet(conexao.getPstmt().executeQuery());

            if (conexao.getResultSet().next()) {
                int pessoaId = conexao.getResultSet().getInt("id");
                String nome = conexao.getResultSet().getString("nome");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double rendaAtual = conexao.getResultSet().getDouble("rendaAtual");
                String cpf = conexao.getResultSet().getString("cpf");

                pessoa = new PessoaFisica(pessoaId, nome, endereco, telefone, rendaAtual, cpf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }

        return pessoa;

    }

    /**
     * Atualiza um registro de PessoaFisica no banco de dados com base no objeto fornecido.
     *
     * @param objeto O objeto PessoaFisica a ser atualizado.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    @Override
    public void atualizar(PessoaFisica objeto) throws SQLException {
        Conexao conexao = null;
 
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, rendaAtual = ? WHERE id = ?";

        conexao = Factory.creatConnectionToMySQL();
        conexao.Conecta();
        conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
        conexao.getPstmt().setString(1, objeto.getNome());
        conexao.getPstmt().setString(2, objeto.getEndereco());
        conexao.getPstmt().setString(3, objeto.getTelefone());
        conexao.getPstmt().setDouble(4, objeto.getRendaAtual());
        conexao.getPstmt().setInt(5, objeto.getId());

        conexao.getPstmt().executeUpdate();
        conexao.Desconecta();
    }

    /**
     * Deleta um registro de PessoaFisica do banco de dados com base no ID fornecido.
     *
     * @param id O ID do objeto a ser deletado.
     */
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

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
                System.out.println("Não foi possi­vel remover!!");
            }
        } catch (Exception e) {
            System.out.println("erro:\n" + e);
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

    /**
     * Retorna uma lista de todos os registros de PessoaFisica do banco de dados.
     *
     * @return Uma lista contendo todos os objetos PessoaFisica.
     */
    @Override
    public List<PessoaFisica> listarTodos() {
        List<PessoaFisica> listaPessoas = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        Conexao conexao = null;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));
            conexao.setResultSet(conexao.getPstmt().executeQuery());

            while (conexao.getResultSet().next()) {
                int id = conexao.getResultSet().getInt("id");
                String nome = conexao.getResultSet().getString("nome");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double rendaAtual = conexao.getResultSet().getDouble("rendaAtual");
                String cpf = conexao.getResultSet().getString("cpf");

                listaPessoas.add(new PessoaFisica(id, nome, endereco, telefone, rendaAtual, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
            ;
        }

        return listaPessoas;
    }

    /**
     * Gera um novo ID para uma PessoaFisica.
     *
     * @return O novo ID gerado.
     */
    public static int geraId() {
        int count = 0, idPF = 0;
        List<PessoaFisica> pessoasFisicas = new PessoaFisicaDAO().listarTodos();

        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (count < pessoaFisica.getId()) {
                count = pessoaFisica.getId();
            }
        }
        idPF = count + 1;
        return idPF;
    }

}
