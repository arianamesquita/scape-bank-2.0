package model;

public class PessoaFisica extends Pessoa {

    public String cpf;


    public PessoaFisica () {  } 
    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }
    public PessoaFisica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpf) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
