

<<<<<<< HEAD

import DataBase.ContaDAO.ContaDAO;
import controller.LoguinController;
=======
import DataBase.BancoAgenciaDAO.BancoAgenciaDAO;
import DataBase.ClienteDAO.FuncionarioDAO;
import DataBase.ClienteDAO.PessoaFisicaDAO;
import DataBase.ContaDAO.ContaDAO;
import model.Agencia;
import model.Banco;
import model.Conta;
import model.Funcionario;
import model.Pagamentos;
import model.PessoaFisica;
import view.LoginGUI;
>>>>>>> aef6a342853487f0134fed96f9143eebf291f084


public class mainTeste {
	public static void main(String[] args) {

		//new LoginGUI();


<<<<<<< HEAD
		//BancoAgenciaDAO bancoAgenciaDAO = new BancoAgenciaDAO();
		/*PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome("Ariana Mesquita");
		pessoaFisica.setCpf("00055599974");
		pessoaFisica.setEndereco("Rua 120");
		pessoaFisica.setRendaAtual(2000.00);
		pessoaFisica.setTelefone("64999887755");
		PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();
		pessoaFisicaDao.criar(pessoaFisica);*/
		//ContaDAO contaDAO = new ContaDAO();
		System.out.println(ContaDAO.geraNumCartao());
		LoguinController loguinController = new LoguinController();
=======
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		conta.setLogin("arianameskita");
		conta.setSenha("123456");
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


		contaDAO.criarConta(conta);
		//System.out.println(ContaDAO.geraNumCartao());
>>>>>>> aef6a342853487f0134fed96f9143eebf291f084
		
		
	}



}
