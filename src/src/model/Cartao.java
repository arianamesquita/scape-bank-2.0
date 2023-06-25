package model;

import java.sql.Date;

/**
 * @author ArianaMesquita
 * classe que cria cartão
 */

public class Cartao {

    public String numeroCartao;
    public Date dataValidade;
    public int cvc;


    public Cartao( ) {   }

    /**
     *
     * @param numeroCartao = parametro do construtor da classe cartão que recebe um numero de cartão;
     * @param dataValidade = parametro do construtor da classe cartão que recebe uma data;
     * @param cvc = parametro do construtor da classe cartão que recebe um cvc de cartão;
     */
    public Cartao(String numeroCartao, Date dataValidade, int cvc) {
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.cvc = cvc;
    }

    /**
     *
     * @return método da classe cartão que retorna um númeero de cartão;
     */
    public String getNumeroCartao() {
        return numeroCartao;
    }

    /**
     * cadastra um número de cartão;
     * @param numeroCartao = parametro do método setNumeroCartao que recebe numero do cartão;
     */
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    /**
     *
     * @return método da classe cartão que retorna uma data de validade;
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * cadastra uma data de validade;
     * @param dataValidade = parametro do método setDataValidade que recebe data de validade;
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     *
     * @return método da classe cartão que retorna um cvc de cartão;
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * cadastra um cvc de cartão;
     * @param cvc = parametro do método setCvc que recebe um cvc de cartão;
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

}
