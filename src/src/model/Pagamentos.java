package model;

/**
 * @author ArianaMesquita
 * classe que cria Pagamentos;
 */
public class Pagamentos {

    public String chavePix;

    public Pagamentos ( ) {   }

    /**
     *
     * @param chavePix = parametro do construtor da classe Pagamentos que recebe uma chave pix;
     */
    public Pagamentos(String chavePix) {
        this.chavePix = chavePix;
    }

    /**
     *
     * @return método da classe Pagamentos que retorna chave pix;
     */
    public String getChavePix() {
        return chavePix;
    }

    /**
     * cadastra chave pix;
     * @param chavePix = parametro do método setChavePix que recebe uma chave pix;
     */
    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

}
