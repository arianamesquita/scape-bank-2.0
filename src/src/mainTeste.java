

import DataBase.BancoAgenciaDAO.BancoAgenciaDAO;
import DataBase.ContaDAO.ContaDAO;
import model.Agencia;
import model.Conta;
import view.LoginGUI;


public class mainTeste {
	public static void main(String[] args) {

		//new LoginGUI();


		ContaDAO contaDAO = new ContaDAO();
		/*Conta conta = new Conta();
		conta.setLogin("arianameskita");
		conta.setSenha("12345678");
		Pagamentos pagamentos = new Pagamentos();
		pagamentos.setChavePix("00055599974");
		conta.setPagamentos(pagamentos);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.ler(1);
		conta.setFuncionario(funcionario);
		BancoAgenciaDAO bancoAgenciaDAO = new BancoAgenciaDAO();
		Agencia agencia = bancoAgenciaDAO.searchByCode("1");
		conta.setAgencia(agencia);
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		PessoaFisica pessoaFisica = pessoaFisicaDAO.ler(1);
		conta.setCliente(pessoaFisica);
		conta.setSenhaConta("123456");*/


		//System.out.println(ContaDAO.geraCVC());
		
		
	}



}
