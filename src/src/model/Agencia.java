package model;

/**
 * @author  ariana mesquita
 * classe que cria agencia
 */
public class Agencia {


    public String numeroAgencia;
    public String endereco;
    public String telefone;

    Banco banco;

    
    public Agencia ( ) {  }

    /**
     *
     * @param numeroAgencia = parametro do construtor da classe agencia que recebe um numero de agência;
     * @param endereco = parametro do construtor da classe agencia que recebe um endereço;
     * @param telefone = parametro do construtor da classe agencia que recebe um numero de telefone;
     * @param banco = parametro do construtor da classe agencia que recebe o nome do banco;
     */
    public Agencia(String numeroAgencia, String endereco, String telefone, Banco banco) {
        this.numeroAgencia = numeroAgencia;
        this.endereco = endereco;
        this.telefone = telefone;
        this.banco = banco;
    }

    /**
     *
     * @return methodo da class agencia que retorna numero de agencia;
     *
     */
    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    /**
     *cadastro de numero agencia;
     * @param numeroAgencia = parametro do metodo setNumeroAgencia que recebe numero agencia;
     */
    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    /**
     *
     * @return metodo da class agencia que retorna endereco;
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * cadastra endereco;
     * @param endereco = parametro do metodo setEndereco que recebe endereco;
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return metodo da classe agencia que retorna o numero telefone;
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * cadastra numero de telefone;
     * @param telefone = parametro do metodo setTelefone que recebe numero de telefone;
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return metodo da classe agencia que retorna o nome do banco;
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * cadastra nome do banco
     * @param banco = parametro do metodo setBanco que recebe nome do banco;
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    /**
     *
     * @return metodo da classe agencia que retorna a classe agencia;
     */
    @Override
    public String toString() {
        return "numeroAgencia = " + numeroAgencia + 
                ", endereco=" + endereco +
                ", telefone=" + telefone + 
                ", banco=" + banco;
    }

}
