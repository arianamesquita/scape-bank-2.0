package model;

public class Funcionario extends Pessoa {

    private String cargo, cpf;
    private int codigoBanco;


    public Funcionario () {  }
    public Funcionario(String cargo, int codigoBanco) {
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
    }
    public Funcionario(int id, String nome, String endereco, String telefone, double salario, String cargo,
            int codigoBanco,String cpf) {
        super(id, nome, endereco, telefone, salario);
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
        this.cpf=cpf;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
