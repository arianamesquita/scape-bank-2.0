package testesPedro;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    final private String url ="jdbc:mysql://localhost:3306/banco";
    final  private String driver = "com.mysql.cj.jdbc.Driver";
    final  private  String usuario ="root";
    final  private String senha= "Peheje5u$";
    private Connection conexao;
    public PreparedStatement statement;
    public ResultSet resultSet;

    public void conecta(){
        try {
            Class.forName(driver);
            conexao = (Connection) DriverManager.getConnection(url,usuario,senha);
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
            statement = (PreparedStatement) conexao.prepareStatement(sql);
            statement.execute();
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possivel executar o comando sql"+" "+e+"\no comando passado foi"+sql);
        }
    }

    public static void main(String[] args) {
        Conexao conexao1 = new Conexao();
        conexao1.conecta();
        conexao1.ExecutaSql("select * from filmes");
        try {
        while (conexao1.resultSet.next()){
            System.out.println(conexao1.resultSet.getString("titulo")+"\t\t\t"+conexao1.resultSet.getString("genero"));

        }           
        
        conexao1.resultSet.close();
        conexao1.statement.close();
        conexao1.Desconecta();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "deu erro"+e);
                throw new RuntimeException(e);
            }


        }

    }




