package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import DataBase.ContaDAO.TransacaoDAO;
import model.Conta;
import testesDaAnna.PagamentosField;
import view.AreaPagamentoGUI;

public class PagamentosController {

    private AreaPagamentoGUI areaPagamentoGUI;
    private PagamentosField pagamentosField;
    private Conta conta;

    public PagamentosController(){
        this.areaPagamentoGUI =  new AreaPagamentoGUI(pagamentosField);
        getPagamentosField().setVisible(true);

    }


    public void enviarPix(){

        conta.setIdTransacao(geraId());
        conta.setSenhaConta(confirmSenhaConta().toString());
        conta.setTipoTransacao("pix");
        conta.setValorTransacao(pagamentosField.getValorField().getText());
        conta.setNumeroContaDestino(pagamentosField.getDestinField().getText());

        
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
