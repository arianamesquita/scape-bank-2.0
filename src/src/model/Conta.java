package model;

import java.sql.Date;

public class Conta {

    public int id;
    public String login;
    public String Senha;
    public String senhaConta;
    public String numeroConta;
    public String numeroCartao;
    public String numeroContaDestino;
    public String tipoTransacao;
    public Date dataTransacao;
    public String valorTransacao;
    public int idTransacao;

    Agencia agencia;
    Emprestimo emprestimo;
    Pagamentos pagamentos;
    Cartao cartao;

    public Conta ( ) {  }
    public Conta(int id, String login, String senha, String senhaConta, String numeroConta, String numeroCartao,
            String numeroContaDestino, String tipoTransacao, Date dataTransacao, String valorTransacao, int idTransacao,
            Agencia agencia, Emprestimo emprestimo, Pagamentos pagamentos, Cartao cartao) {
        this.id = id;
        this.login = login;
        Senha = senha;
        this.senhaConta = senhaConta;
        this.numeroConta = numeroConta;
        this.numeroCartao = numeroCartao;
        this.numeroContaDestino = numeroContaDestino;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.idTransacao = idTransacao;
        this.agencia = agencia;
        this.emprestimo = emprestimo;
        this.pagamentos = pagamentos;
        this.cartao = cartao;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return Senha;
    }
    public void setSenha(String senha) {
        Senha = senha;
    }
    public String getSenhaConta() {
        return senhaConta;
    }
    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public String getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }
    public void setNumeroContaDestino(String numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }
    public String getTipoTransacao() {
        return tipoTransacao;
    }
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    public Date getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public String getValorTransacao() {
        return valorTransacao;
    }
    public void setValorTransacao(String valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
    public int getIdTransacao() {
        return idTransacao;
    }
    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }
    public Agencia getAgencia() {
        return agencia;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    public Pagamentos getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }
    public Cartao getCartao() {
        return cartao;
    }
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }   

    
}
