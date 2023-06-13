package model;

import java.sql.Date;

public class Cartao {

    public String numeroCartao;
    public Date dataValidade;
    public int cvc;


    public Cartao( ) {   }
    public Cartao(String numeroCartao, Date dataValidade, int cvc) {
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.cvc = cvc;
    }


    public String getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    public Date getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    public int getCvc() {
        return cvc;
    }
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

}
