package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import DataBase.ClienteDAO.PessoaJuridicaDAO;

public class TesteMain {
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(new BorderLayout());
       PessoaJuridicaController pfController = new PessoaJuridicaController();

        frame.add(pfController.getPessoaJuridicaGUI(),BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
        pfController.setPessoaJuridica(new PessoaJuridicaDAO().ler(2));
        new PessoaJuridicaDAO().deletar(1);
                new PessoaJuridicaDAO().deletar(2);

       
        


    }
    
}
