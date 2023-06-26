package model;

import java.sql.Date;

/**
 * @author ArianaMesquita
 * classe que cria Emprestimo;
 */
public class Emprestimo {

    public float emprestimoPrestacao;
    public int emprestimoPrazo;
    public Date emprestimoData;


    public Emprestimo( ) {   }

    /**
     *
     * @param emprestimoPrestacao = parametro do construtor da classe Emprestimo que recebe prestação de empréstimo;
     * @param emprestimoPrazo = parametro do construtor da classe Emprestimo que recebe prazo de empréstimo;
     * @param emprestimoData = parametro do construtor da classe Emprestimo que recebe data de empréstimo;
     */
    public Emprestimo(float emprestimoPrestacao, int emprestimoPrazo, Date emprestimoData) {
        this.emprestimoPrestacao = emprestimoPrestacao;
        this.emprestimoPrazo = emprestimoPrazo;
        this.emprestimoData = emprestimoData;
    }

    /**
     *
     * @return método da classe Emprestimo que retorna prestação de empréstimo;
     */
    public float getEmprestimoPrestacao() {
        return emprestimoPrestacao;
    }

    /**
     * cadastra prestação de empréstimo;
     * @param emprestimoPrestacao = parametro do método setEmprestimoPrestacao que recebe prestação de empréstimo;
     */
    public void setEmprestimoPrestacao(float emprestimoPrestacao) {
        this.emprestimoPrestacao = emprestimoPrestacao;
    }

    /**
     *
     * @return método da classe Emprestimo que retorna prazo de emprestimo;
     */
    public int getEmprestimoPrazo() {
        return emprestimoPrazo;
    }

    /**
     * cadastra prazo de empréstimo;
     * @param emprestimoPrazo = parametro do método setEmprestimoPrazo que recebe prazo de empréstimo;
     */
    public void setEmprestimoPrazo(int emprestimoPrazo) {
        this.emprestimoPrazo = emprestimoPrazo;
    }

    /**
     *
     * @return método da classe Emprestimo que retorna data do empréstimo;
     */
    public Date getEmprestimoData() {
        return emprestimoData;
    }

    /**
     * cadastra data de empréstimo;
     * @param emprestimoData = parametro do método setEmprestimoData que recebe data de empréstimo;
     */
    public void setEmprestimoData(Date emprestimoData) {
        this.emprestimoData = emprestimoData;
    }

}
