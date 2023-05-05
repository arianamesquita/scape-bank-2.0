package testesPedro;

import MainScreen.Components.CustomJTextField.JtextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class teste extends JFrame {
    Conexao conexao = new Conexao();
    DefaultListModel<String> model;
    int enter = 0;

    JtextField jcb;
    Jlist list;

    public teste() {

        setTitle("Scape Bank");
        setLayout(null);
        setSize(500,500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        conexao.conecta();
        model = new DefaultListModel<>();
        list = new Jlist();
        list.setBounds(10, 50, 200, 100);
        list.setBackground(Color.lightGray);
        list.setForeground(Color.darkGray);
        list.setModel(model);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MostrarPesquisa();
                list.setVisible(true);
                super.mousePressed(e);
            }
        });
        list.setVisible(false);



        jcb = new JtextField();
        jcb.setBounds(10, 10, 200, 40);
        jcb.setBackground(Color.white);
        jcb.setForeground(Color.darkGray);
        jcb.setVisible(true);
        jcb.addActionListener(e -> {
            list.setVisible(false);
            enter = 1;
        });
        jcb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (enter==0){
                    ListadePesquisa();
                }else enter=0;
                super.keyReleased(e);
            }
        });
        add(jcb);
        add(list);

        setVisible(true);
    }



    public void ListadePesquisa() {

        try {
            conexao.ExecutaSql("SELECT * FROM estados where nome like '" + jcb.getText() + "%' ORDER BY nome");
            model.removeAllElements();
            int count = 0;
            while (conexao.resultSet.next() & count < 4) {
                model.addElement(conexao.resultSet.getString("nome"));
                count++;
            }
            list.setVisible(count >= 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar dados" + e);
        }
    }

    public void MostrarPesquisa() {
        int linha = list.getSelectedIndex();
        if (linha >= 0) {
            conexao.ExecutaSql("SELECT * FROM municipios where nome '" +
                    "" + jcb.getText() + "%' ORDER BY nome LIMITE " + linha + " ,1");
            ResultadoPesquisa();
        }
    }

    public void ResultadoPesquisa() {
        try {
            conexao.resultSet.first();
            JOptionPane.showMessageDialog(null, "nome:" + conexao.resultSet.getString(": ") + "\nUf:"
                    + conexao.resultSet.getString("uf") + "\nregiao: " + conexao.resultSet.getString("regiao"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new teste();
    }
}