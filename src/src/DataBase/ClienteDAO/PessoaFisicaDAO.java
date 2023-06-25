package DataBase.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.PessoaFisica;

public class PessoaFisicaDAO implements InterfaceDAO<PessoaFisica> {

    @Override
    public void criar(PessoaFisica objeto) {
        Conexao conexao = null;
        String query = "INSERT INTO cliente (id, nome, endereco, telefone, cnpj, funcionarioResponsavel, rendaAtual, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

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
            conexao.getPstmt().setString(8, objeto.getCpf());
            conexao.getPstmt().executeUpdate();
            System.out.println("Dados inseridos com sucesso na tabela pessoa fisica.");
        } catch (SQLException e) {

            System.out.println("Erro ao inserir dados na tabela pessoa: " + e.getMessage());

        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

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

    @Override
    public void atualizar(PessoaFisica objeto) {
        Conexao conexao = null;

        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, rendaAtual = ?, WHERE id = ?";

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

            System.out.println("pessoa fisica atualizada com sucesso");
        } catch (SQLException e) {
            System.out.println("não foi possivel atualizar erro:\n" + e);
        } finally {
            Objects.requireNonNull(conexao).Desconecta();
        }
    }

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
                JOptionPane.showMessageDialog(null, "Removido com sucesso!");
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
                String nome  = conexao.getResultSet().getString("nome");
                String endereco = conexao.getResultSet().getString("endereco");
                String telefone = conexao.getResultSet().getString("telefone");
                double rendaAtual = conexao.getResultSet().getDouble("rendaAtual");
                String cpf = conexao.getResultSet().getString("cpf");
        
                listaPessoas.add(new PessoaFisica(id, nome, endereco, telefone, rendaAtual, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(conexao).Desconecta();;
        }

        return listaPessoas;
    }

    public static int geraId() {
        int count = 0, idPF = 0;
        List<PessoaFisica> pessoasFisicas = new PessoaFisicaDAO().listarTodos();

        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if(count < pessoaFisica.getId()){
                count = pessoaFisica.getId();
            }
        }
        idPF = count + 1;
        return idPF;
    }

}
