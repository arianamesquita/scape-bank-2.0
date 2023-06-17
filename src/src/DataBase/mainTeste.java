package DataBase;

import DataBase.ClienteDAO.PessoaJuridicaDAO;
import model.PessoaJuridica;

public class mainTeste {
	public static void main(String[] args) {
		PessoaJuridica pf1 = new PessoaJuridica(1, "pedro1", "Endereco1", "telefone1", 100.0, "111111111");
		PessoaJuridica pf2 = new PessoaJuridica(2, "pedro2", "Endereco2", "telefone2", 200.0, "222222222");
		PessoaJuridica pf3 = new PessoaJuridica(3, "pedro3", "Endereco3", "telefone3", 300.0, "333333333");
		PessoaJuridica pf4 = new PessoaJuridica(1, "pedro uma grande gostosa", "Endereco4", "telefone4", 400.0, "111111111");

		PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		pessoaJuridicaDAO.criar(pf1);
		pessoaJuridicaDAO.criar(pf2);
		pessoaJuridicaDAO.criar(pf3);
		

		System.out.println(pessoaJuridicaDAO.ler(2));

		

		pessoaJuridicaDAO.atualizar(pf4);

		

		for (PessoaJuridica pessoaJuridica : new PessoaJuridicaDAO().listarTodos()) {
			System.out.println(pessoaJuridica);
		}
		

		pessoaJuridicaDAO.deletar(1);
		pessoaJuridicaDAO.deletar(2);
		pessoaJuridicaDAO.deletar(3);

	}



}
