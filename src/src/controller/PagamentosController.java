package controller;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import DataBase.ContaDAO.TransacaoDAO;
import model.Conta;
import view.AreaPagamentoGUI;
import view.viewAdds.PagamentosField;

public class PagamentosController {

    private AreaPagamentoGUI areaPagamentoGUI;
    private PagamentosField pagamentosField;
    private Conta conta;

    public PagamentosController(){
        this.pagamentosField = new PagamentosField();
        this.areaPagamentoGUI =  new AreaPagamentoGUI(pagamentosField);

        getAreaPagamentoGUI().setVisible(true);

    }

    public void initController(){
        pagamentosField.getOk().addActionListener( e-> enviarPix());
    }


    public void enviarPix(){

        conta.setIdTransacao(geraId());
        conta.setSenhaConta(confirmSenhaConta().toString());
        conta.setTipoTransacao("pix");
        conta.setDataTransacao(new Date(0));
        conta.setValorTransacao(pagamentosField.getValorField().getText());
        conta.setNumeroContaDestino(pagamentosField.getDestinField().getText());
        conta.setId(36480); //pegar o id da Conta conectada.


        TransacaoDAO dao = new TransacaoDAO();

        try{
            dao.criar(conta);
        } catch (Exception ex){
            Logger.getLogger(PagamentosController.class.getName()).log(Level.SEVERE, null, ex); 
        }

    }



    public AreaPagamentoGUI getAreaPagamentoGUI() {
        return areaPagamentoGUI;
    }
    public void setAreaPagamentoGUI(AreaPagamentoGUI areaPagamentoGUI) {
        this.areaPagamentoGUI = areaPagamentoGUI;
    }
    public PagamentosField getPagamentosField() {
        return pagamentosField;
    }
    public void setPagamentosField(PagamentosField pagamentosField) {
        this.pagamentosField = pagamentosField;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }


    private int geraId() {
        int count = 0;
        for (Conta conta2 : new TransacaoDAO().getTransacoes()) {
            if (count < conta2.getId()) {
                count = conta2.getId();
            }
        }
        return count + 1;
    }

    private char[] confirmSenhaConta(){

        JPasswordField password = new JPasswordField();
        password.setEchoChar('*');

        JLabel texto = new JLabel("Digite a senha da conta:");

        JPanel entSenha = new JPanel();
        entSenha.add(texto);
        entSenha.add(password);

        JOptionPane.showMessageDialog(null, entSenha, "Acesso seguro", JOptionPane.PLAIN_MESSAGE);

        char[] senha = password.getPassword();

        return senha;

    }

    
}
