package model;

public class Agencia {


    public String numeroAgencia;
    public String endereco;
    public String telefone;

    Banco banco;

    
    public Agencia ( ) {  }
    public Agencia(String numeroAgencia, String endereco, String telefone, Banco banco) {
        this.numeroAgencia = numeroAgencia;
        this.endereco = endereco;
        this.telefone = telefone;
        this.banco = banco;
    }


    public String getNumeroAgencia() {
        return numeroAgencia;
    }
    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
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
    public Banco getBanco() {
        return banco;
    }
    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    @Override
    public String toString() {
        return "numeroAgencia = " + numeroAgencia + 
                ", endereco=" + endereco +
                ", telefone=" + telefone + 
                ", banco=" + banco;
    }

}
