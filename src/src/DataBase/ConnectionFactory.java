package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

    public static Connection connection = null;
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DBNAME = "railway";
	private final static String URL = "jdbc:mysql://containers-us-west-181.railway.app:7682/" + DBNAME;
	private final static String LOGIN = "root";
	private final static String SENHA = "RzbUN31XmK9QvBX2JbWC";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectado!");
		}catch(ClassNotFoundException erro) {
			JOptionPane.showMessageDialog(null, "Driver nao encontrado \n"+ erro.toString());
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"Problemas na conexao com a fonte de dados \n"+ erro.toString());
		}
		return connection;
	}
	
	public void close() {
		try {
			connection.close();
			System.out.println("Desconectado");			
		}catch(SQLException erro) {
			System.out.println(erro.toString());
		}
	}
    
}
