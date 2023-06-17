package DataBase;

import DataBase.ClienteDAO.FuncionarioDAO;
import model.Funcionario;

public class mainTeste {
	public static void main(String[] args) {
		Funcionario func1 = new Funcionario(1, "pedro1", "ensereco1","telefone1",1000.0,"cargo1",1,"111111111");
		Funcionario func2 = new Funcionario(2, "pedro2", "ensereco2","telefone2",2000.0,"cargo2",1,"222222222");
		Funcionario func3 = new Funcionario(3, "pedro3", "ensereco3","telefone3",3000.0,"cargo3",1,"333333333");
		Funcionario func4 = new Funcionario(1, "pedro4", "ensereco4","telefone4",4000.0,"cargo4",1,"111111111");

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		display();
		funcionarioDAO.criar(func1);
		funcionarioDAO.criar(func2);
		funcionarioDAO.criar(func3);
		display();
		System.out.println(funcionarioDAO.ler(2));
		display();
		funcionarioDAO.atualizar(func4);
		display();
		for (Funcionario funcionario : new FuncionarioDAO().listarTodos()) {
			System.out.println(funcionario);
			
		}
		display();
		funcionarioDAO.deletar(1);
		funcionarioDAO.deletar(2);
		funcionarioDAO.deletar(3);


	}
	public static void display(){
		System.out.println("-----------------------------------------------------------------------------------");
	}



}
