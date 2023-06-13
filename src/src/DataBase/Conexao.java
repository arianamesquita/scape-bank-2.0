package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {

    private String user;
    private String senha;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String stringConexao;
    private PreparedStatement pstmt;

    public Conexao(String local,String porta, String bd,  String user, String senha) {
        this.stringConexao = "jdbc:mysql://"+ local +":" + porta +"/"+ bd;
        this.user = user;
        this.senha = senha;
    }

    public void Conecta(){
        try {
            Class.forName(getDriver());
            setConnection(DriverManager.getConnection(getStringConexao(), getUser(), getSenha()));
            JOptionPane.showMessageDialog(null, "banco de dados conectado com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possível conectar ao banco de dados erro:\n"+e);
        }
    }
    public void Desconecta(){
        try {
            if (getResultSet() != null){
                getResultSet().close();
            }

            if (getStatement() != null){
                getStatement().close();
            }
            getConnection().close();
            JOptionPane.showMessageDialog(null, "banco de dados desconectado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possível desconectar o banco de dados erro:\n"+e);
        }
    }

    public void ExecuteQuery(String stringSQL){
        try {
            setResultSet(getStatement().executeQuery(stringSQL));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possível executar a Query erro:\n"+e);

        }
    }
    public void ConfigUser(String user, String senha) {
        setUser(user);
        setSenha(senha);
    }

    public String getStringConexao() {
        return stringConexao;
    }

    public void setStringConexao(String stringConexao) {
        this.stringConexao = stringConexao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getDriver() {
        return "com.mysql.cj.jdbc.Driver";
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }

}