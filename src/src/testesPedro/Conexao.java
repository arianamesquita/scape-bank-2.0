package testesPedro;

import javax.swing.*;
import java.sql.*;

public class Conexao {
    final private String url ="jdbc:mysql://localhost:3306/?user=root";
    final  private String driver = "com.mysql.cj.jdbc.Driver";
    final  private  String usuario ="root";
    final  private String senha= "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultSet;

    public void conecta(){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("conexao realizada");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "driver não localizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao conectar com o servidor mysql");
        }
    }
    public void Desconecta(){
        try {
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao fechar a conexão com o banco de dadors");
        }
    }
    public void  ExecutaSql(String sql){
        try {
            statement = conexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possivel executar o comando sql"+" "+e+"\no comando passado foi"+sql);
        }
    }

    public static void main(String[] args) {
        Conexao conexao1 = new Conexao();
        conexao1.conecta();
    }



}
