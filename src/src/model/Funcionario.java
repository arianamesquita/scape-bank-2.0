package model;

/**
 * @author ArianaMesquita
 * @author Pedro-jferreira
 * classe que cria Funcionario
 */

public class Funcionario extends PessoaFisica {

    private String cargo;
    private int codigoBanco;


    public Funcionario () {  }

    /**
     *
     * @param cargo = parametro do construtor da classe Funcionario que recebe cargo;
     * @param codigoBanco = parametro do construtor da classe Funcionario que recebe código do banco;
     */
    public Funcionario(String cargo, int codigoBanco) {
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
    }

    /**
     *
     * @param id = parametro do construtor da classe Funcionario que recebe id;
     * @param nome = parametro do construtor da classe Funcionario que recebe nome;
     * @param endereco = parametro do construtor da classe Funcionario que recebe endereço;
     * @param telefone = parametro do construtor da classe Funcionario que recebe telefone;
     * @param salario = parametro do construtor da classe Funcionario que recebe salário;
     * @param cargo = parametro do construtor da classe Funcionario que recebe cargo;
     * @param codigoBanco = parametro do construtor da classe Funcionario que recebe código do banco;
     * @param cpf = parametro do construtor da classe Funcionario que recebe cpf;
     */
    public Funcionario(int id, String nome, String endereco, String telefone, double salario, String cargo,
            int codigoBanco,String cpf) {
        super(id, nome, endereco, telefone, salario,cpf);
        this.cargo = cargo;
        this.codigoBanco = codigoBanco;
        
    }

    /**
     *
     * @return método da classe Funcionario que retorna cargo;
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * registra cargo;
     * @param cargo = parametro do método setCargo que recebe cargo;
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return método da classe Funcionario que retorna código de banco;
     */
    public int getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * cadastra código de banco;
     * @param codigoBanco = parametro do método setCodigoBanco que recebe código de banco;
     */
    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }


}
