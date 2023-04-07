package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conecta {

	public static void main(String[] args) {
		
		
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://127.0.0.1:3308/?user=administrator";
		

		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, "administrator", "@Ari1#Ped2");
			JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
			connection.close();	
		} catch (ClassNotFoundException erro) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado!\n"
					+ erro.toString());
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados\n"
					+ erro.toString());
		}
		
	}
}
