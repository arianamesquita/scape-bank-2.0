package model;

/**
 * @author ArianaMesquita
 * classe que cria PessoaJuridica;
 */
public class PessoaJuridica extends Pessoa {

    
    private String cpnj;

    /**
     *
     * @param id = parametro do construtor da classe PessoaJuridica que recebe id;
     * @param nome = parametro do construtor da classe PessoaJuridica que recebe nome;
     * @param endereco = parametro do construtor da classe PessoaJuridica que recebe endereço;
     * @param telefone = parametro do construtor da classe PessoaJuridica que recebe telefone;
     * @param rendaAtual = parametro do construtor da classe PessoaJuridica que recebe renda atual;
     * @param cpnj = parametro do construtor da classe PessoaJuridica que recebe cnpj;
     */
    public PessoaJuridica(int id, String nome, String endereco, String telefone, double rendaAtual, String cpnj) {
        super(id, nome, endereco, telefone, rendaAtual);
        this.cpnj = cpnj;
    }


    public PessoaJuridica () { }

    /**
     *
     * @return método da classe PessoaJuridica que retorna cnpj;
     */
    public String getCpnj() {
        return cpnj;
    }

    /**
     * cadastra cnpj;
     * @param cpnj = parametro do método setCpnj que recebe cnpj;
     */
    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }
    
}
