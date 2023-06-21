package model;

public class PessoaJuridica extends Pessoa {

    
    private String cpnj;


    public PessoaJuridica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpnj) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cpnj = cpnj;
    }

    public PessoaJuridica () { }

    public String getCpnj() {
        return cpnj;
    }
    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }
    
}
