package model;

/**
 * @author ArianaMesquita
 * classe que cria banco;
 */
public class Banco {

    
    public String nome;
    public int codigo;


    public Banco () {  }

    /**
     *
     * @param nome = parametro do construtor da classe banco que recebe o nome do banco;
     * @param codigo = parametro do construtor da classe banco que recebe o codigo do banco;
     */
    public Banco(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    /**
     *
     * @return methodo da class banco que retorna nome do banco;
     */
    public String getNome() {
        return nome;
    }

    /**
     * cadastra nome do banco;
     * @param nome = parametro do metodo setNome que recebe nome do banco;
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return metodo da classe banco que retorna codigo;
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * cadastra codigo do banco;
     * @param codigo = parametro do metodo setCodigo que recebe codigo do banco;
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
