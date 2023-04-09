package MainScreen.Components.CardsComponent;


import javax.swing.*;
import java.awt.*;

/**
 * class para objeto do tipo Cards, onde serão contidos, valores e métodos para o mesmo
 * @author pedro
 * @version 1.0
 */
public class Cards extends JPanel
{
    private JButton[]buttons;
    private String[]text;
   private int x,  y,  width, height;
   private int[][]ints;

    /**
     * construtor da class Cards
     * @param buttons — botôes que serão adicionados ao objeto.
     * @param text - texto que será adicionado aos botões.
     * @param x - posição x.
     * @param y - posição y.
     */
    public Cards(JButton[] buttons, String[] text, int x, int y) {
        this.buttons = buttons;
        this.text = text;
        this.x = x;
        this.y = y;

        setInts(new int[][] {{0, 0}, {0, 200}, {0, 400}, {500, 0}, {500, 200}, {500, 400}});
        setBounds(getText().length);
        setLayout(null);
        setOpaque(false);
        addButtons();
        addPaintCards();
            setVisible(true);
    }

    /**
     * Método da class Cards usado para definir o tamanho do objeto a partir da quantidade de cards a serem criados.
     * @param quantDeCards — quantidade de cards a ser criados.
     */
    public void setBounds(int quantDeCards) {
        int width = 400; int height=0;

            for (int i = 0; i < quantDeCards; i++) {
                if (i==0){
                    height=150;
                } else if (i<=2) {
                    height= height+200;

                }else width = 900;

            }
        super.setBounds(getX(), getY(), width, height);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Método usado para retornar o valor de x.
     * @return — retorna a posição x.
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Método da class Cards usado para dar valor ao atributo X.
     * @param x— Posição de x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Método da class Cards que retorna o valor de Y.
     * @return — retorna o valor de Y.
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Método da class Cards que define valor para o atributo Y.
     * @param y — define a posição y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Método da class Cards que retorna o valor da Largura.
     * @return — retorna o valor de width.
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Método da class Cards usado para dar valor ao atributo width.
     * @param width— define a largura do objeto.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Método da class Cards que retorna o valor do comprimento.
     * @return — retorna o valor de height.
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Método da class Cards usado para dar valor ao atributo height.
     * @param height— define o comprimento do objeto.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Método da class Cards que retorna o valor das posições x e y dos cards.
     * @return — retorna o valor de x e y .
     */
    public int[][] getInts() {
        return ints;
    }

    /**
     * Método da class Cards usado para dar valor ao atributo ints.
     * @param ints— guarda as posições x e y dos cards.
     */
    public void setInts(int[][] ints) {
        this.ints = ints;
    }

    /**
     * Método da class Cards usado para retornar os valores do atributo text.
     * @return — retorna text.
     */
    public String[] getText() {
        return text;
    }

    /**
     * Método da class Cards usado para definir o valor do atributo text.
     * @param text — parametro usado para dar valor as Strings.
     */
    public void setText(String[] text) {
        this.text = text;
    }

    /**
     * Método da class Cards usado para dar valor ao atributo buttons
     * @param buttons — dar valor aos buttons.
     */
    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    /**
     * Método da class Cards que retorna o valores do atributo buttons.
     * @return - retorna button[].
     */
    public JButton[] getButtons() {
        return buttons;
    }

    /**
     * Método da class Cards que adiciona todos os botões gerados.
     * Deve ser adicionado antes do método addPaintCards.
     */
    void addButtons(){
        ButtonsCards buttonsCards = new ButtonsCards(getButtons(),getText(), getInts());
        setButtons(buttonsCards.getButtons());
        for (JButton button:getButtons()) {
            add(button);
        }
    }

    /**
     * Método da class Cards que adiciona os desenhos para os cards gerados.
     * Deve ser usado depois do método addButtons.
     */
    void addPaintCards(){
        PaintCards paintCards = new PaintCards(getText().length,getWidth(),getHeight());
        add(paintCards);

    }

    /**
     * Subclass da class Cards, cria desenhos para cards, onde terá contida valores e métodos do mesmo.
     * @author pedro
     */
    private static class PaintCards extends JPanel {
        private final int quantidade;

        /**
         * construtor da sub-class PaintCards
         * @param quantidade — quantidade de cards a ser criados
         * @param width — largura do JPanel.
         * @param height — comprimento do JPanel.
         */
        public PaintCards(int quantidade, int width, int height) {
            this.quantidade = quantidade;
            setBounds(0, 0, width, height);
            setLayout(null);
            setOpaque(false);
            setVisible(true);
        }

        /**
         * Método da sub-class PaintCards usado para realizar os desenhos dos cards.
         * @param g  the <code>Graphics</code> context in which to paint
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            int count = 0;
            int count1 = 0;

            for (int i = 0; i < quantidade; i++)
            {
                g.setColor(Color.gray);
                g.fillRoundRect(count1,  count, 400, 150, 40, 40);
                count = count + 200;

                if (i == 2) {
                    count1 = count1 + 500;
                    count = 0;
                }
            }
            g.dispose();
        }
    }

    /**
     * Subclass da class Cards, que manipula os Botões do objeto, onde terá contida valores e métodos do mesmo.
     * @author pedro
     */
    private static class ButtonsCards{
        JButton[]buttons;

        /**
         * Construtor da Subclass ButtonsCards usado para criar os botões do objeto.
         * @param buttons — botões a serem manipulados.
         * @param text — textos há serem adicionados nos botões.
         * @param posicao — Posições x e y dos botões.
         */
        public ButtonsCards(JButton[] buttons,String[]text, int[][] posicao) {
            this.buttons = buttons;
            setTextButtons(getButtons(), text);
            setBoundsButtons(getButtons(), posicao);
        }

        /**
         * Método da Subclass ButtonsCards usado para inicializar os Botões.
         * @param buttons — botões a serem instanciados.
         * @param text — textos a serem colocados nos botões.
         */
        void InicializarButtons(JButton[] buttons,String[] text){
            int count = 0;
            for (String s:text)
            {
                buttons[count]=new JButton(s);
                count++;
            }
        }

        /**
         * Método da Subclass ButtonsCards que retorna os botões;
         * @return — retorna os botões do mesmo
         */
        public JButton[] getButtons() {
            return buttons;
        }

        /**
         * Método da Subclass ButtonsCards usado para definir o texto dos botões.
         * @param buttons — botões a serem manipulados.
         * @param text — Texto a ser inserido nos Botões.
         */
        void setTextButtons(JButton[] buttons, String[] text){
            int count = 0;
            for (String s:text)
            {
                buttons[count].setText(s);
                count++;
            }
        }

        /**
         * Método da Subclass ButtonsCards usado para definir a dimensão do botão.
         * @param buttons — botões a serem manipulados
         * @param ints — posições x e y.
         */
        void setBoundsButtons(JButton[] buttons,int[][]ints){
            int count = 0;
            for (JButton button:buttons) {

                button.setBounds(ints[count][0]+280,ints[count][1]+120,100,30);
                count++;
            }
        }

        /**
         * Método da Subclass ButtonsCards que define valor ao atributos da mesma.
         * @param buttons — Botões a serem adicionados.
         */
        public void setButtons(JButton[] buttons) {
            this.buttons = buttons;
        }
    }
}