package model;

import java.io.Serializable;

/**
 * @author ArianaMesquita
 * classe que cria Pessoa
 */
abstract class Pessoa implements Serializable {

    protected int id;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected double rendaAtual;


    public Pessoa () { }

    /**
     *
     * @param id = parametro do construtor da classe Pessoa que recebe um id;
     * @param nome = parametro do construtor da classe Pessoa que recebe um nome;
     * @param endereco = parametro do construtor da classe Pessoa que recebe um endereço;
     * @param telefone = parametro do construtor da classe Pessoa que recebe um telefone;
     * @param rendaAtual = parametro do construtor da classe Pessoa que recebe renda atual;
     */
    public Pessoa(int id, String nome, String endereco, String telefone, double rendaAtual) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rendaAtual = rendaAtual;
    }

    /**
     *
     * @return método da classe Pessoa que retorna id;
     */
    public int getId() {
        return id;
    }

    /**
     * cadastra id;
     * @param id = parametro do metodo setId que recebe id;
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return método da classe Pessoa que retorna nome;
     */
    public String getNome() {
        return nome;
    }

    /**
     * cadastra nome de funcionário;
     * @param nome = parametro do metodo setNome que recebe nome;
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return método da classe Pessoa que retorna endereço;
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * cadastra endereço;
     * @param endereco = parametro do metodo setEndereco que recebe endereço;
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return método da classe Pessoa que retorna telefone;
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * cadastra telefone;
     * @param telefone = parametro do metodo setTelefone que recebe telefone;
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return método da classe Pessoa que retorna renda atual;
     */
    public double getRendaAtual() {
        return rendaAtual;
    }

    /**
     * cadastra renda atual;
     * @param rendaAtual = parametro do metodo setRendaAtual que recebe renda atual;
     */
    public void setRendaAtual(double rendaAtual) {
        this.rendaAtual = rendaAtual;
    }

    /**
     *
     * @return método da classe Pessoa que retorna a classe Pessoa;
     */
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
                + ", rendaAtual=" + rendaAtual + "]";
    }
    public abstract String getDocIdentificacao();

    public abstract void setDocIdentificacao(String identificacao);

}
