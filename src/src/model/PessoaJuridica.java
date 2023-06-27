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
        setDocIdentificacao(cpnj);;
    }


    public PessoaJuridica () { }


    @Override
    public String getDocIdentificacao() {
       return getCpnj();
    }
    @Override
    public void setDocIdentificacao(String identificacao) {
        setCpnj(identificacao);
    }
    /**
     *
     * @return método da classe PessoaJuridica que retorna cnpj;
     */
    protected String getCpnj() {
        return cpnj;
    }
    /**
     * cadastra cnpj;
     * @param cpnj = parametro do método setCpnj que recebe cnpj;
     */
    protected void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }
    
}
