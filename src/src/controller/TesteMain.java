package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import DataBase.ClienteDAO.PessoaFisicaDAO;

public class TesteMain {
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setVisible(true);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.deletar(0);
        


    }
    
}
