package DataBase;



import DataBase.ClienteDAO.PessoaFisicaDAO;
import model.PessoaFisica;

public class mainTeste {
    public static void main(String[] args) {
		   
		PessoaFisica pFisica = new PessoaFisica(1, "pedro", "um ai", "61 985439393", 2.2, "70718430158");
        PessoaFisicaDAO pDao = new PessoaFisicaDAO();
        pDao.criar(pFisica);


		
	}
    
}
