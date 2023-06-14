package DataBase.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.PessoaFisica;

public class PessoaFisicaDAO implements InterfaceDAO<PessoaFisica> {

    @Override
    public void criar(PessoaFisica obT) {
        Conexao conexao = null;
        String query = "INSERT INTO cliente (id, nome, endereco, telefone, cnpj, funcionarioResponsavel, rendaAtual, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(query));
            conexao.getPstmt().setInt(1, obT.getId());
            conexao.getPstmt().setString(2, obT.getNome());
            conexao.getPstmt().setString(3, obT.getEndereco());
            conexao.getPstmt().setString(4, obT.getTelefone());
            conexao.getPstmt().setString(5, null);
            conexao.getPstmt().setString(6, null);
            conexao.getPstmt().setDouble(7, obT.getRendaAtual());
            conexao.getPstmt().setString(8, obT.getCpf());

            conexao.getPstmt().executeUpdate();
            conexao.getPstmt().close();

            conexao.Desconecta();
            System.out.println("Dados inseridos com sucesso na tabela pessoa fisica.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela pessoa: " + e.getMessage());
        }
    }

    @Override
    public PessoaFisica ler(int id) {
        Conexao conexao;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
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
                double rendaAtual = conexao.getResultSet().getDouble("renda_atual");
                String cpf = conexao.getResultSet().getString("cpf");

                pessoa = new PessoaFisica(pessoaId, nome, endereco, telefone, rendaAtual, cpf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.Desconecta();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }

        return pessoa;
    }

    @Override
    public void atualizar(PessoaFisica objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(int id) {

        String sql = "DELETE FROM cliente WHERE id = ?";

        Conexao conexao;

        try {
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();

            conexao.setPstmt(conexao.getConnection().prepareStatement(sql));

            conexao.getPstmt().setInt(1, id);

            conexao.getPstmt().execute();
            if (conexao.getPstmt().getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                conexao.getPstmt().close();
                conexao.Desconecta();
            } else {
                JOptionPane.showMessageDialog(null, "NÃ£o foi possi­vel remover!!");
                conexao.Desconecta();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<PessoaFisica> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

}
