package DataBase;

import java.io.FileNotFoundException;

import testesDaAnna.TelaDeCartaoDeCredito;

public class mainTeste {
	public static void main(String[] args) {
		try {
			new TelaDeCartaoDeCredito();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
