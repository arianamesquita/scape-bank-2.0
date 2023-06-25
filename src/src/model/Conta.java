package model;

import java.sql.Date;

/**
 * @author ArianaMesquita
 * classe que cria Conta
 */

public class Conta {

    public int id;
    public String login;
    public String senha;
    public String senhaConta;
    public String numeroConta;
    public String numeroCartao;
    public String validadeCartao;
    public int cvc;
    public String numeroContaDestino;
    public String tipoTransacao;
    public Date dataTransacao;
    public String valorTransacao;
    public int idTransacao;

    Agencia agencia;
    Emprestimo emprestimo;
    Pagamentos pagamentos;
    Funcionario funcionario;
    Cartao cartao;
    PessoaFisica cliente;


    public Conta ( ) {  }

    /**
     *
     * @param id = parametro do construtor da classe conta que recebe um id;
     * @param login = parametro do construtor da classe conta que recebe login;
     * @param senha = parametro do construtor da classe conta que recebe senha;
     * @param senhaConta = parametro do construtor da classe conta que recebe senha da conta;
     * @param numeroConta = parametro do construtor da classe conta que recebe número da conta;
     * @param numeroCartao = parametro do construtor da classe conta que recebe número do cartão;
     * @param validadeCartao = parametro do construtor da classe conta que recebe validade do cartão;
     * @param cvc = parametro do construtor da classe conta que recebe cvc;
     * @param numeroContaDestino = parametro do construtor da classe conta que recebe número da conta destino;
     * @param tipoTransacao = parametro do construtor da classe conta que recebe tipo de transação;
     * @param dataTransacao = parametro do construtor da classe conta que recebe data da transação;
     * @param valorTransacao = parametro do construtor da classe conta que recebe valor da transação;
     * @param idTransacao = parametro do construtor da classe conta que recebe id de transação;
     * @param agencia = parametro do construtor da classe conta que recebe agencia;
     * @param emprestimo = parametro do construtor da classe conta que recebe empréstimo;
     * @param pagamentos = parametro do construtor da classe conta que recebe pagamentos;
     * @param cartao = parametro do construtor da classe conta que recebe cartão;
     * @param funcionario = parametro do construtor da classe conta que recebe funcionário;
     * @param cliente = parametro do construtor da classe conta que recebe cliente;
     */
    public Conta(int id, String login, String senha, String senhaConta, String numeroConta, String numeroCartao,
            String validadeCartao, int cvc, String numeroContaDestino, String tipoTransacao, Date dataTransacao, 
            String valorTransacao, int idTransacao, Agencia agencia, Emprestimo emprestimo, Pagamentos pagamentos,
            Cartao cartao, Funcionario funcionario, PessoaFisica cliente) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.senhaConta = senhaConta;
        this.numeroConta = numeroConta;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.cvc = cvc;
        this.numeroContaDestino = numeroContaDestino;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.idTransacao = idTransacao;
        this.agencia = agencia;
        this.emprestimo = emprestimo;
        this.pagamentos = pagamentos;
        this.cartao = cartao;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    /**
     *
     * @param id = parametro do construtor da classe conta que recebe um id;
     * @param senhaConta = parametro do construtor da classe conta que recebe senha da conta;
     * @param numeroConta = parametro do construtor da classe conta que recebe número da conta;
     * @param numeroContaDestino = parametro do construtor da classe conta que recebe número da conta destino;
     * @param tipoTransacao = parametro do construtor da classe conta que recebe tipo de transação;
     * @param dataTransacao = parametro do construtor da classe conta que recebe data da transação;
     * @param valorTransacao = parametro do construtor da classe conta que recebe valor da transação;
     * @param idTransacao = parametro do construtor da classe conta que recebe id de transação;
     * @param agencia = parametro do construtor da classe conta que recebe agencia;
     * @param pagamentos = parametro do construtor da classe conta que recebe pagamentos;
     * @param cliente = parametro do construtor da classe conta que recebe cliente;
     */
    public Conta(int id, String senhaConta, String numeroConta, String numeroContaDestino, String tipoTransacao,
            Date dataTransacao, String valorTransacao, int idTransacao, Agencia agencia, Pagamentos pagamentos, 
            PessoaFisica cliente){
        this.id = id;
        this.senhaConta = senhaConta;
        this.numeroConta = numeroConta;
        this.numeroContaDestino = numeroContaDestino;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.idTransacao = idTransacao;
        this.agencia = agencia;
        this.pagamentos = pagamentos;
        this.cliente = cliente;
    }

    /**
     *
     * @return método da classe Conta que retorna Id;
     */
    public int getId() {
        return id;
    }

    /**
     * cadastra id;
     * @param id = parametro do método setId que recebe id;
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return método da classe Conta que retorna Login;
     */
    public String getLogin() {
        return login;
    }

    /**
     * cadastra Login;
     * @param login = parametro do método setLogin que recebe Login;
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return método da classe Conta que retorna Senha;
     */
    public String getSenha() {
        return senha;
    }

    /**
     * cadastra senha;
     * @param senha = parametro do método setSenha que recebe Senha;
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return método da classe Conta que retorna Senha da conta;
     */
    public String getSenhaConta() {
        return senhaConta;
    }

    /**
     * cadastra senha da conta;
     * @param senhaConta = parametro do método setSenhaConta que recebe Senha da conta;
     */
    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }

    /**
     *
     * @return método da classe Conta que retorna número da conta;
     */
    public String getNumeroConta() {
        return numeroConta;
    }

    /**
     * cadastra número da conta;
     * @param numeroConta = parametro do método setNumeroConta que recebe número da conta;
     */
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     *
     * @return método da classe Conta que retorna número do cartão;
     */
    public String getNumeroCartao() {
        return numeroCartao;
    }

    /**
     * cadastra número de cartão;
     * @param numeroCartao = parametro do método setNumeroCartao que recebe número de cartão;
     */
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    /**
     *
     * @return método da classe Conta que retorna número de conta destino;
     */
    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }

    /**
     * cadastra número de conta destino;
     * @param numeroContaDestino = parametro do método setNumeroContaDestino que recebe número de conta destino;
     */
    public void setNumeroContaDestino(String numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    /**
     *
     * @return método da classe Conta que retorna tipo de transação;
     */
    public String getTipoTransacao() {
        return tipoTransacao;
    }

    /**
     * cadastra tipo de transação;
     * @param tipoTransacao = parametro do método setTipoTransacao que recebe o tipo de transação;
     */
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    /**
     *
     * @return método da classe Conta que retorna data de transação;
     */
    public Date getDataTransacao() {
        return dataTransacao;
    }

    /**
     * cadastra data de transação;
     * @param dataTransacao = parametro do método setDataTransacao que recebe data de transação;
     */
    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    /**
     *
     * @return método da classe Conta que retorna valor de transação;
     */
    public String getValorTransacao() {
        return valorTransacao;
    }

    /**
     * cadastra valor da transação;
     * @param valorTransacao = parametro do método setValorTransacao que recebe valor de transação;
     */
    public void setValorTransacao(String valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    /**
     *
     * @return método da classe Conta que retorna id de transação;
     */
    public int getIdTransacao() {
        return idTransacao;
    }

    /**
     * cadastra id de transação;
     * @param idTransacao = parametro do método setIdTransacao que recebe id de transação;
     */
    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    /**
     *
     * @return método da classe Conta que retorna agência;
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * cadastra agencia;
     * @param agencia = parametro do método setAgencia que recebe agência;
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     *
     * @return método da classe Conta que retorna empréstimo;
     */
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    /**
     * cadastra emprestimo;
     * @param emprestimo = parametro do método setEmprestimo que recebe empréstimo;
     */
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     *
     * @return método da classe Conta que retorna pagamentos;
     */
    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    /**
     * cadastra pagamentos;
     * @param pagamentos = parametro do método setEmprestimo que recebe pagamentos;
     */
    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

    /**
     *
     * @return método da classe Conta que retorna cartão;
     */
    public Cartao getCartao() {
        return cartao;
    }

    /**
     * cadastra cartão;
     * @param cartao = parametro do método setCartao que recebe cartão;
     */
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    /**
     *
     * @return método da classe Conta que retorna fucionário;
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * cadastra funcionário;
     * @param funcionario = parametro do método setFuncionario que recebe funcionário;
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     *
     * @return método da classe Conta que retorna cliente;
     */
    public PessoaFisica getCliente() {
        return cliente;
    }

    /**
     * cadastra cliente;
     * @param cliente = parametro do método setCliente que recebe cliente;
     */
    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return método da classe Conta que retorna validade do cartão;
     */
    public String getValidadeCartao() {
        return validadeCartao;
    }

    /**
     * cadastra validade do cartão;
     * @param validadeCartao = parametro do método setValidadeCartao que recebe validade do cartão;
     */
    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    /**
     *
     * @return método da classe Conta que retorna cvc;
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * cadastra cvc;
     * @param cvc = parametro do método setCvc que recebe cvc;
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    /**
     *
     * @return método da classe Conta que retorna a classe Conta;
     */
    @Override
    public String toString() {
        return "Conta - id = " + id +
                ", numeroConta = " + numeroConta +
                ", numeroCartao = " + numeroCartao +
                ", validadeCartao = " + validadeCartao +
                ", cvc = " + cvc +
                ", numeroContaDestino = " + numeroContaDestino +
                ", tipoTransacao = " + tipoTransacao +
                ", dataTransacao = " + dataTransacao +
                ", valorTransacao = " + valorTransacao +
                ", idTransacao = " + idTransacao +
                ", agencia = " + agencia +
                ", funcionario = " + funcionario +
                ", cliente = " + cliente;
    }

}
