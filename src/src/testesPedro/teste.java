package testesPedro;

import MainScreen.Components.CustomJTextField.JtextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class teste extends JFrame
{
    Conexao conexao = new Conexao();
    DefaultListModel<Object> model;
    int enter = 0;


    JtextField jcb;
    JList<Object> list;
    static String[] palavra= {"1","2","3"};

    public teste()
    {
        conexao.conecta();
        list.setVisible(true);
        model= new DefaultListModel<>();
        list.setModel(model);






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
        setVisible(true);

    }
    private void PesquisarNome(ActionEvent event){
        list.setVisible(false);
        enter = 1;
    }
    private void PesquizarnomeKeyreelease(MouseEvent event){
        if (enter ==0){
            ListadePesquisa();
        }else enter=0;
    }
    private void ListaMousepressed(MouseEvent event){
        MostrarPesquisa();
        list.setVisible(true);
    }
    public void ListadePesquisa(){
        try{
        conexao.ExecutaSql("SELECT * FROM estados where nome like '"+jcb.getText()+"%' ORDER BY nome");
        model.removeAllElements();
        int count = 0;
        while (conexao.resultSet.next()& count <4){
            model.addElement(conexao.resultSet.getString("nome"));
            count++;
        }
            list.setVisible(count >= 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar dados"+e);}
    }
    public void MostrarPesquisa(){
        int linha = list.getSelectedIndex();
        if (linha>=0){
            conexao.ExecutaSql("SELECT *FROM municipios where nome like'"+
                    ""+jcb.getText()+"%' ORDER BY nome LIMITE "+ linha+" ,1");
            ResultadoPesquisa();
        }
    }

    public void  ResultadoPesquisa(){
        try {
            conexao.resultSet.first();
            JOptionPane.showMessageDialog(null
            , "nome:"+conexao.resultSet.getString(": ")+"\nUf:"
            +conexao.resultSet.getString("uf")+"\nregiao: "+conexao.resultSet.getString("regiao"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new teste();
    }}