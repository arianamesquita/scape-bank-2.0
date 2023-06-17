package DataBase;



import DataBase.ClienteDAO.PessoaFisicaDAO;
import model.PessoaFisica;

public class mainTeste {
    public static void main(String[] args) {
		  for (PessoaFisica pessoaFisica : new PessoaFisicaDAO().listarTodos()) {
			System.out.println(pessoaFisica);
		  }
	}
    
}
