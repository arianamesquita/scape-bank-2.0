package testesPedro;

import MainScreen.Components.CustomJTextField.JtextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class teste extends JFrame
    {

        JButton JB1,JB3;
        JLabel JL1,JL2;
        JtextField JCB;
        static String[] palavra= {"1","2","3"};

        public teste()
        {
            setSize(1100, 600);

            setTitle("Scape Bank");
            getContentPane().setBackground(Color.white);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent evt)
                {
                }
            });

            JL1 = new JLabel("$                       $xtrato                       $");
            JL1.setBounds(100, 100, 1000, 50);
            JL1.setForeground(Color.darkGray);
            JL1.setFont(new Font("Arial", Font.BOLD, 50));
            JL1.setVisible(true);String b = " ";
            String text =b.repeat(22) +"operacão"+b.repeat(23+24)+"destino"+b.repeat(24+23)+"transação"+b.repeat(23+25)+"valor"+b.repeat(25);

            JL2 = new JLabel(text);
            JL2.setBounds(50, 220, 1000, 30);
            JL2.setForeground(Color.darkGray);
            JL2.setBackground(Color.CYAN);
            JL2.setOpaque(true);
            JL2.setFont(new Font("Arial", Font.BOLD, 15));
            JL2.setVisible(true);

            JCB = new JtextField();

            JCB.setBounds(50, 250, 1000, 30);
            JCB.setBackground(Color.darkGray);
            JCB.setForeground(Color.lightGray);
            JCB.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {

                    super.keyTyped(e);
                }

                @Override
                public void keyPressed(KeyEvent e) {

                    super.keyPressed(e);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    System.out.println(JCB.getText());
                    super.keyReleased(e);
                }
            });
            JCB.setFont(new Font("Arial", Font.BOLD, 15));
            JCB.setVisible(true);
            JList jList = new JList(palavra);
            jList.setBounds(50, 250, 1000, 30);
            jList.setBackground(Color.CYAN);
            jList.setVisible(true);




            JB1 = new JButton("abrir->");
            JB1.setBounds(760, 500, 100, 40);
            JB1.setBackground(Color.darkGray);
            JB1.setFont(new Font("Arial", Font.BOLD, 20));
            JB1.setForeground(Color.lightGray);
            JB1.setVisible(true);
            JB1.addActionListener(e -> {
            });

            JB3 = new JButton("<- voltar");
            JB3.setBounds(170, 500, 120, 40);
            JB3.setBackground(Color.darkGray);
            JB3.setFont(new Font("Arial", Font.BOLD, 20));
            JB3.setForeground(Color.lightGray);
            JB3.setVisible(true);
            JB3.addActionListener(e ->
            {

            });


            add(JL1);
            add(JL2);
            add(JB1);
            add(JB3);
            getContentPane().add(JCB);

            setVisible(true);

        }

        public static void main(String[] args) {
            new teste();
        }}