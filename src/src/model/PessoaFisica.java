package model;

/**
 * @author ArianaMesquita
 * classse que cria PessoaFisica;
 */
public class PessoaFisica extends Pessoa {

    private String cpf;


    public PessoaFisica () {  }

    /**
     *
     * @param cpf = parametro do construtor da classe PessoaFisica que recebe cpf;
     */
    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @param id = parametro do construtor da classe PessoaFisica que recebe id;
     * @param nome = parametro do construtor da classe PessoaFisica que recebe nome;
     * @param endereco = parametro do construtor da classe PessoaFisica que recebe endereço;
     * @param telefone = parametro do construtor da classe PessoaFisica que recebe telefone;
     * @param rendaAtual = parametro do construtor da classe PessoaFisica que recebe renda atual;
     * @param cpf = parametro do construtor da classe PessoaFisica que recebe cpf;
     */
    public PessoaFisica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpf) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cpf = cpf;
    }

    /**
     *
     * @return método da classe PessoaFisica que retorna cpf;
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf parametro do método setCpf que recebe cpf;
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
