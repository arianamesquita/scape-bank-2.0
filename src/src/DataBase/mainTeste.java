package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class mainTeste {
    public static void main(String[] args) {

		//Menu menu = new Menu();
		
		Connection conn = null;
		String sql = "select * from aluno";
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sql);
			
/*  		ResultSet resultSet = pstm.executeQuery();
			System.out.println("Nome  CPF   Curso");
			System.out.println("------  ---------------------------------------");
			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String cpf = resultSet.getString("cpf");
				String curso = resultSet.getString("curso");
				
				System.out.println(nome+"   "+ cpf + "   "+curso);
			}
			
			resultSet.close();*/
			if (pstm.getUpdateCount()>0)
			   JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
			else
			   JOptionPane.showMessageDialog(null,"Nao foi possivel criar!!");

			pstm.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}
