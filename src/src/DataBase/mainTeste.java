package DataBase;



import DataBase.ClienteDAO.PessoaFisicaDAO;
import model.PessoaFisica;

public class mainTeste {
    public static void main(String[] args) {
		   
		PessoaFisica pFisica = new PessoaFisica(4, "pedro uma grande gostosa", "um ai", "61 985439393", 2.2, "70718430259");

    PessoaFisicaDAO pFisicaDAO = new PessoaFisicaDAO();
    pFisicaDAO.deletar(1);
    


		
	}
    
}
