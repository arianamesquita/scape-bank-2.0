package testesPedro;

import MainScreen.Components.CustomJTextField.JtextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class teste extends JFrame {
    Conexao conexao = new Conexao();
    DefaultListModel<Object> model;
    int enter = 0;

    JtextField jcb;
    JList<Object> list;

    public teste() {

        setTitle("Scape Bank");
        setLayout(null);
        setSize(getMaximumSize());
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        conexao.conecta();
        model = new DefaultListModel<>();
        list = new JList<>();
        list.setBounds(10, 50, 200, 100);
        list.setBackground(Color.white);
        list.setForeground(Color.darkGray);
        list.setVisible(true);
        list.setModel(model);

        jcb = new JtextField();
        jcb.setBounds(10, 10, 200, 40);
        jcb.setBackground(Color.white);
        jcb.setForeground(Color.darkGray);
        jcb.setVisible(true);
        jcb.addActionListener(null);
        add(jcb);

        setVisible(true);
    }

    private void PesquisarNome(ActionEvent event) {
        list.setVisible(false);
        enter = 1;
    }

    private void PesquizarnomeKeyreelease(MouseEvent event) {
        if (enter == 0) {
            ListadePesquisa();
        } else
            enter = 0;
    }

    private void ListaMousepressed(MouseEvent event) {
        MostrarPesquisa();
        list.setVisible(true);
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
            conexao.ExecutaSql("SELECT *FROM municipios where nome like'" +
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