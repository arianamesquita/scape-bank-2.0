package controller;

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
        conta.set
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
