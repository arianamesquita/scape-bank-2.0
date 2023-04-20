package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conecta {

	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://containers-us-west-181.railway.app:7682/?user=root"; //ajustado para novo teste
		

		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, "root", "RzbUN31XmK9QvBX2JbWC");
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
