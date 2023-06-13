package DataBase.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.PessoaFisica;

public class PessoaFisicaDAO  implements InterfaceDAO<PessoaFisica> {

    @Override
    public void criar(PessoaFisica obT) {
        Conexao conexao = null;
        String query =  "INSERT INTO cliente (id, nome, endereco, telefone, cnpj, funcionarioResponsavel, rendaAtual, cpf) "+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(query));
            conexao.getPstmt().setInt(1, 2);
            conexao.getPstmt().setString(2, getNome());
            conexao.getPstmt().setString(3,getEndereco());
            conexao.getPstmt().setString(4, getTelefone());
            conexao.getPstmt().setString(5, null);
            conexao.getPstmt().setString(6, null);
            conexao.getPstmt().setDouble(7, getRendaAtual());
            conexao.getPstmt().setString(8, getCpf());

            conexao.getPstmt().executeUpdate();
            conexao.getPstmt().close();

            conexao.Desconecta();
            System.out.println("Dados inseridos com sucesso na tabela pessoa fisica.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela pessoa: " + e.getMessage());
        }
    }

    @Override
    public void ler(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ler'");
    }

    @Override
    public void atualizar(PessoaFisica objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public List<PessoaFisica> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }












}
