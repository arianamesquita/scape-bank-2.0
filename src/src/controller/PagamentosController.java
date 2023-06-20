package controller;

import model.Conta;
import model.Pagamentos;
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

int id, String senhaConta, String numeroConta, String numeroContaDestino, String tipoTransacao,
            Date dataTransacao, String valorTransacao, int idTransacao, Agencia agencia, Pagamentos pagamentos, 
            PessoaFisica cliente)

    public void enviarPix(){
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





    
}
