package model;

import java.io.Serializable;

abstract class Pessoa implements Serializable {

    protected int id;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected double rendaAtual;


    public Pessoa () { }
    public Pessoa(int id, String nome, String endereco, String telefone, double rendaAtual) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rendaAtual = rendaAtual;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public double getRendaAtual() {
        return rendaAtual;
    }
    public void setRendaAtual(double rendaAtual) {
        this.rendaAtual = rendaAtual;
    }
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
                + ", rendaAtual=" + rendaAtual + "]";
    }

}
