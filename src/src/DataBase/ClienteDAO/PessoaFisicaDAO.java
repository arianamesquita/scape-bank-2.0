package DataBase.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.PessoaFisica;

public class PessoaFisicaDAO  implements InterfaceDAO {





    @Override
    public void criar(Object object) {
        PessoaFisica pessoaFisica = (PessoaFisica) object;
        Conexao conexao = null;
        String query =  "INSERT INTO cliente (id, nome, endereco, telefone, cnpj, funcionarioResponsavel, rendaAtual, cpf) "+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            conexao.setPstmt(conexao.getConnection().prepareStatement(query));
            conexao.getPstmt().setInt(1, pessoaFisica.getId());
            conexao.getPstmt().setString(2, pessoaFisica.getNome());
            conexao.getPstmt().setString(3, pessoaFisica.getEndereco());
            conexao.getPstmt().setString(4, pessoaFisica.getTelefone());
            conexao.getPstmt().setString(5, null);
            conexao.getPstmt().setString(6, null);
            conexao.getPstmt().setDouble(7, pessoaFisica.getRendaAtual());
            conexao.getPstmt().setString(8, pessoaFisica.getCpf());

            conexao.getPstmt().executeUpdate();
            conexao.getPstmt().close();

            conexao.Desconecta();
            System.out.println("Dados inseridos com sucesso na tabela pessoa fisica.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela pessoa: " + e.getMessage());
        }
    }

    public Object ler(int id) {
        return null;
    }


    public void atualizar(Object objeto) {

    }


    public void deletar(int id) {

    }


    public List listarTodos() {
        return null;
    }


}
