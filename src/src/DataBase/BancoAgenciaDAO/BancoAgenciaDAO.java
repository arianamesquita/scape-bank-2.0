package DataBase.BancoAgenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import DataBase.Conexao;
import DataBase.Factory;
import DataBase.InterfaceDAO;
import model.Agencia;

public class BancoAgenciaDAO implements InterfaceDAO<Agencia>{

    @Override
    public void criar(Agencia obT) {

        String sql = "insert into bancoAgencia(nomeBanco, codigoBanco, numeroAgencia, enderecoAgencia, telefoneAgencia)" +
                        "values (?,?,?,?,?)";

        Conexao conexao;
        PreparedStatement pstm;

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setString(1, sql);
        }

    }

    @Override
    public void ler(int id) {

    }

    @Override
    public void atualizar(Agencia objeto) {

    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public List<Agencia> listarTodos() {

    }
    



}
