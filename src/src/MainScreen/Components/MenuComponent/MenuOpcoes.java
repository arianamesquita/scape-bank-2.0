package MainScreen.Components.MenuComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


/**
 * class para objeto do tipo MenuOpcoes, onde serão contidos, valores e métodos para o mesmo
 * @author pedro
 * @version 1.0
 */
public class MenuOpcoes extends JPanel
{
   private final int x, y, width, height;
     private  final JButton[] buttons ;

    /**
     * Construtor da class MenuOpcoes.
     * @param x — posição (x).
     * @param y — posição (y).
     * @param width — largura.
     * @param height — comprimento.
     * @param buttons — botões a serem adicionados
     */
    public MenuOpcoes(int x, int y, int width, int height, JButton[] buttons) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttons = buttons;
        addButtons();     addLabel();
        addPaintMenu();
   
        setBounds(getX(),getY(),getWidth(),getHeight());
        setLayout(null);
        setVisible(true);
    }
    void addLabel(){
        JlabelUser jlabelUser = new JlabelUser();
        for (JLabel label : jlabelUser.getLabels()) {
            add(label);
            
        }
    }

    /**
     * Método da class MenuOpcoes que retorna a posição x.
     * @return — retornar o valor do atributo x.
     */
    public int getX() {
        return x;
    }

    /**
     * Método da class MenuOpcoes que retorna a posição y.
     * @return — retornar o valor do atributo y.
     */
    public int getY() {
        return y;
    }

    /**
     * Método da class MenuOpcoes que retorna a largura.
     * @return — retornar o valor do atributo width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Método da class MenuOpcoes que retorna a comprimento.
     * @return — retornar o valor do atributo height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Método da class MenuOpcoes que retorna os botões.
     * @return — retornar o valor do atributo buttons.
     */
    public JButton[] getButtons() {
        return buttons;
    }

    /**
     * Método da class MenuOpcoes usado para adicionar os elementos gríficos do objeto.
     */
    public void addPaintMenu(){
        Component component = new PaintMenu(getWidth(),getHeight());
        add(component);
    }

    /**
     * Método da class MenuOpcoes usado para adicionar os botoes do objeto.
     */
    public void addButtons(){
        ButtonsMenu buttonsMenu = new ButtonsMenu(getX(),getY(),getWidth(),getHeight(),getButtons());
        for (JButton button: buttonsMenu.getButtons()){
            add(button);
        }
    }

    /**
     * Subclass PaintMenu para objeto do tipo MenuOpcoes, onde serão geradas os elementos gráficos do objeto.
     * @author pedro
     * @version 1.0
     */
    private static class PaintMenu extends JPanel {
        int width,height;

        /**
         * Construtor da Subclass PaintMenu.
         * @param width — largura.
         * @param height — comprimento.
         */
        public PaintMenu(int width, int height) {
            this.width = width;
            this.height = height;

            setBounds(0,0,getWidth(),getHeight());
            setLayout(null);
            setVisible(true);
        }

        /**
         * Método da Subclass PaintMenu que retorna a largura.
         * @return — retorna o atributo width.
         */
        @Override
        public int getWidth() {
            return width;
        }

        /**
         * Método da SubClass que retorna o comprimento.
         * @return — retorna o atributo height
         */
        @Override
        public int getHeight() {
            return height;
        }

        /**
         * Método da Subclass que gera o elementos gráficos.
         * @param g  the <code>Graphics</code> context in which to paint
         */
        @Override
        public void paint(Graphics g) {
            Color rgbgrey = new Color(199,188,161);    
            g.setColor(rgbgrey);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            g.setColor(Color.white);
            g.fillRoundRect(10, 10, getWidth()-20, (int) (getHeight()*0.2727272727), 20, 20);
            g.dispose();
        }
    }


    /**
     * Subclass ButtonsMenu para objeto do tipo MenuOpcoes, onde serão gerados os botões do objeto.
     * @author pedro
     * @version 1.0
     */
    private static class ButtonsMenu {
        private  final int x,y,width,height;
        private final JButton[]buttons;
        private String[] text = {"image","Menu Principal ->","Pix->", "Pagamentos->","Empréstimos->", "Cartões->"};

        /**
         * Construtor da Subclass ButtonsMenu, usado para gerar o objeto.
         * @param x — posição (x).
         * @param y — posição (y).
         * @param width — largura.
         * @param height — comprimento.
         * @param buttons — botões.
         */
        public ButtonsMenu(int x, int y, int width, int height, JButton[] buttons) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.buttons = buttons;

            setTextButtons(getButtons(),getText());
            setButtonsBound(getButtons());
        }

        /**
         * Método da Subclass ButtonsMenu que retorna a posição x.
         * @return — retornar o valor do atributo x.
         */
        public int getX() {
            return x;
        }

        /**
         * Método da Subclass ButtonsMenu que retorna a posição y.
         * @return — retornar o valor do atributo y.
         */
        public int getY() {
            return y;
        }

        /**
         * Método da Subclass ButtonsMenu que retorna a largura.
         * @return — retornar o valor do atributo width.
         */
        public int getWidth() {
            return width;
        }

        /**
         * Método da Subclass ButtonsMenu que retorna o comprimento.
         * @return — retornar o valor do atributo height.
         */
        public int getHeight() {
            return height;
        }

        /**
         * Método da Subclass ButtonsMenu que retorna os textos inseridos nos botões.
         * @return — retornar o valor do atributo text.
         */
        public String[] getText() {
            return text;
        }

        /**
         * Método da Subclass ButtonsMenu que dar valor ao atributo text.
         * @param text  — textos há serem inseridos nos botões.
         */
        public void setText(String[] text) {
            this.text = text;
        }

        /**
         * Método da Subclass ButtonsMenu que insere textos nos botões.
         * @param buttons — botões há serem manipulados.
         * @param text — textos a serem inseridos nos botões.
         */
        void setTextButtons(JButton[]buttons, String[] text)
        {
            int count = 0;
            for (String s: text) {
                buttons[count].setText(s);
                count++;
            }
        }
        void setBoundsImage(JButton button){
            Icon logo = new ImageIcon(Objects.requireNonNull(getClass().getResource("avatar.png")));
            button.setIcon(logo);
            button.setBounds(10,20,50,50);
            button.setBackground(Color.white);
            button.setBorderPainted(false);
            button.setText("");
            button.setVisible(true);


        }

        /**
         * Método da Subclass ButtonsMenu que insere a dimensão dos botões.
         * @param buttons — botões a serem manipulados.
         */
        void setButtonsBound(JButton[]buttons){
            int count = 0;
            for (JButton button :buttons) {
                if(button.getText().equals(getText()[0])){
                    setBoundsImage(button);
                    continue;
                }
                button.setBounds(10, getY()+20+ count, getWidth()-20, (int) (0.0909090909*getHeight()));
                count = (int) (0.10*getHeight()+ count);
                Color buttonsMenu = new Color(101,100,124);    
                button.setBackground(buttonsMenu);
                button.setForeground(Color.white);
                Font consolasButton = new Font("Century Gothic", 50, 18);
                button.setFont(consolasButton);
            }
        }

        /**
         * Método da Subclass ButtonsMenu que retorna os botões da class.
         * @return — retornar o valor do atributo buttons.
         */
        public JButton[] getButtons() {
            return buttons;
        }
    

    }
    private class JlabelUser{
        private JLabel[] labels;

        public JlabelUser() {
            this.labels = new JLabel[2];
            String[] text = {"pedro ferreira","<html> conta: 999999.99-8 <br> agencia: 0404 <br> banco:006</html>"};
            setText(text,getLabels());
            setBounds(getLabels());

        }

        public JLabel[] getLabels() {
            return labels;
        }

        public void setLabels(JLabel[] labels) {
            this.labels = labels;
        }

        void setText(String[] text, JLabel[]labels){
            int count = 0;
            for (String string : text) {
                labels[count] = new JLabel(string);
                count++;
            }

        }
        void setBounds(JLabel[] labels){

            Font arialButton = new Font("Arial", 50, 18);
            int count = 0;
            for (JLabel jLabel : labels) {
                jLabel.setBounds(70,30+count,jLabel.getText().length()*11,(int) (jLabel.getText().length()*1.2));
                jLabel.setFont(arialButton);
                jLabel.setBackground(Color.BLACK);
                jLabel.setVisible(true);
                count= count+20;
            }

        }
        
    }


}
