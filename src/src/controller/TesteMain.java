package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import MainScreen.Components.CustomJButton.Jbutton;
import MainScreen.Components.MenuComponent.MenuOpcoes.PaintMenu;
import testesDaAnna.PagamentosField;
import view.AreaPagamentoGUI;

public class TesteMain {
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        PaintMenu paintMenu = new PaintMenu();
        frame.setLayout(null);
        paintMenu.setBackground(Color.red);
        paintMenu.setLayout(new FlowLayout());
        JButton button = new JButton("botao");
        paintMenu.setBounds(100, 100, 400, 400);
        paintMenu.setOpaque(false);
    
        frame.add(paintMenu);
        paintMenu.add(button);
        frame.setVisible(true);

       
        


    }
    
}
