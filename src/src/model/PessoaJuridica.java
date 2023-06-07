package model;

public class PessoaJuridica extends Pessoa{

    
    public String cpnj;


    public PessoaJuridica () {  }
    public PessoaJuridica(String cpnj) {
        this.cpnj = cpnj;
    }
    public PessoaJuridica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpnj) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cpnj = cpnj;
    }


    public String getCpnj() {
        return cpnj;
    }
    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }
    
}
