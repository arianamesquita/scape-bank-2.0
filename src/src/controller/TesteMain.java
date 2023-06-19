package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TesteMain {
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(new BorderLayout());
        CartaoCreditoController creditoController = new CartaoCreditoController();
        frame.add(creditoController.getCartaoCreditoGUI(),BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);

       
        


    }
    
}
