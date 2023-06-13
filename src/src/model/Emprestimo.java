package model;

import java.sql.Date;

public class Emprestimo {

    public float emprestimoPrestacao;
    public int emprestimoPrazo;
    public Date emprestimoData;


    public Emprestimo( ) {   }
    public Emprestimo(float emprestimoPrestacao, int emprestimoPrazo, Date emprestimoData) {
        this.emprestimoPrestacao = emprestimoPrestacao;
        this.emprestimoPrazo = emprestimoPrazo;
        this.emprestimoData = emprestimoData;
    }


    public float getEmprestimoPrestacao() {
        return emprestimoPrestacao;
    }
    public void setEmprestimoPrestacao(float emprestimoPrestacao) {
        this.emprestimoPrestacao = emprestimoPrestacao;
    }
    public int getEmprestimoPrazo() {
        return emprestimoPrazo;
    }
    public void setEmprestimoPrazo(int emprestimoPrazo) {
        this.emprestimoPrazo = emprestimoPrazo;
    }
    public Date getEmprestimoData() {
        return emprestimoData;
    }
    public void setEmprestimoData(Date emprestimoData) {
        this.emprestimoData = emprestimoData;
    }

}
