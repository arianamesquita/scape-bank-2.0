package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import DataBase.ContaDAO.ContaDAO;
import DataBase.ContaDAO.TransacaoDAO;
import model.Conta;
import view.AreaPagamentoGUI;
import view.ComprovanteGUI;
import view.viewAdds.PagamentosField;

public class PagamentosController {

    private AreaPagamentoGUI areaPagamentoGUI;
    private PagamentosField pagamentosField;
    private Conta conta;
    ComprovanteGUI comprovanteGUI;

    public PagamentosController(){
        this.pagamentosField = new PagamentosField();
        this.areaPagamentoGUI =  new AreaPagamentoGUI(pagamentosField);

        initController();
        getAreaPagamentoGUI().setVisible(true);
    }

    public void initController(){
        pagamentosField.getOk().addActionListener(e-> enviarPix());
    }


    public void enviarPix(){
        
        ContaDAO numConta = new ContaDAO();
        TransacaoDAO dao = new TransacaoDAO();

        conta.setIdTransacao(geraId());
        conta.setSenhaConta(confirmSenhaConta());
        conta.setTipoTransacao("Pix");
        conta.setDataTransacao(Date.valueOf(LocalDate.now()));
        conta.setValorTransacao(pagamentosField.getValorField().getText());
        String chavePix = pagamentosField.getDestinField().getText();
        conta.setNumeroContaDestino(numConta.searchByChavePix(chavePix));


        try{
            dao.criar(conta);
        } catch (Exception ex){
            Logger.getLogger(PagamentosController.class.getName()).log(Level.SEVERE, null, ex); 
        }
        mostrarComprovante(conta.getIdTransacao());
        //areaPagamentoGUI.add(comprovanteGUI);
        //getComprovanteGUI().setVisible(true);

    }

    public void mostrarComprovante(int id){
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Conta transacao = transacaoDAO.getTransacaoById(id);

        comprovanteGUI = new ComprovanteGUI(transacao.getNumeroConta(), transacao.getNumeroContaDestino(), 
                "pix", transacao.getValorTransacao(), transacao.getIdTransacao());
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
    public ComprovanteGUI getComprovanteGUI() {
        return comprovanteGUI;
    }
    public void setComprovanteGUI(ComprovanteGUI comprovanteGUI) {
        this.comprovanteGUI = comprovanteGUI;
    }


    private int geraId() {
        int count = 0;
        List<Conta> transacoes = new TransacaoDAO().getTransacoes();
        for (Conta conta : transacoes) {
            if (count < conta.getIdTransacao()) {
                count = conta.getIdTransacao();
            }
        }
        return count + 1;
    }

    public String confirmSenhaConta(){
        ContaDAO contaDAO = new ContaDAO();
        String password;
        Conta conta = contaDAO.searchById(getConta().getId());
        do {
            password = JOptionPane.showInputDialog(areaPagamentoGUI, "Digite a senha da conta:",
                     "Acesso seguro", JOptionPane.QUESTION_MESSAGE);
            if (password.equals(conta.getSenhaConta())){
                System.out.println("Senha conferida!");
            } else {
                System.out.println("Senha errada! Tente novamente!");
            }
        }while(!password.equals(conta.getSenhaConta()));
        return password;
    }

    
}
