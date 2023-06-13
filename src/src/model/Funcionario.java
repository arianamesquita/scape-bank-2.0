package model;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {

    public String cargo;
    public int codigoBanco;


    public Funcionario () {  }
    public Funcionario(String cargo, int codigoBanco) {
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
    }
    public Funcionario(int id, String nome, String endereco, String telefone, double rendaAtual, String cargo,
            int codigoBanco) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
    }


    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getCodigoBanco() {
        return codigoBanco;
    }
    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

}
