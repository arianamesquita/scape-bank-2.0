package MainScreen.Components.CardsComponent;


import javax.swing.*;
import java.awt.*;

public class Cards extends JPanel {
    private JButton[]buttons;
    private String[]text;
   private int x,  y,  width, height;
   private int[][]ints;

    public Cards(JButton[] buttons, String[] text, int x, int y) {
        this.buttons = buttons;
        this.text = text;
        this.x = x;
        this.y = y;
        this.ints =new int[][] {{0, 0}, {0, 200}, {0, 400}, {500, 0}, {500, 200}, {500, 400}};

        setBounds();
        setLayout(null);
        setOpaque(false);
        addButtons();
        addPaintCards();
            setVisible(true);
    }


    public void setBounds() {
        int width = 400; int height=0;

            for (int i = 0; i < getText().length; i++) {
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

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getInts() {
        return ints;
    }

    public void setInts(int[][] ints) {
        this.ints = ints;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    void addButtons(){
        ButtonsCards buttonsCards = new ButtonsCards(getButtons(),text, ints);
        setButtons(buttonsCards.getButtons());
        for (JButton button:getButtons()) {
            add(button);
        }
    }
    void addPaintCards(){
       PaintCards paintCards = new PaintCards(getText().length,getWidth(),getHeight());
        add(paintCards);

    }
    private static class PaintCards extends JPanel {
        private final int quantidade;
        public PaintCards(int quantidade, int width, int height) {
            this.quantidade = quantidade;
            setBounds(0, 0, width, height);
            setLayout(null);
            setOpaque(false);
            setVisible(true);
        }

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

    private static class ButtonsCards{
        JButton[]buttons;

        public ButtonsCards(JButton[] buttons,String[]text, int[][]posicion) {
            this.buttons = buttons;
            setTextButtons(getButtons(), text);
            setBoundsButtons(getButtons(), posicion);
        }
        void InicializarButtons(JButton[] buttons,String[] text){
            int count = 0;
            for (String s:text)
            {
                buttons[count]=new JButton(s);
                count++;
            }
        }

        public JButton[] getButtons() {
            return buttons;
        }

        void setTextButtons(JButton[] buttons, String[] text){
            int count = 0;
            for (String s:text)
            {
                buttons[count].setText(s);
                count++;
            }
        }
        void setBoundsButtons(JButton[] buttons,int[][]ints){
            int count = 0;
            for (JButton button:buttons) {

                button.setBounds(ints[count][0]+280,ints[count][1]+120,100,30);
                count++;
            }
        }

        public void setButtons(JButton[] buttons) {
            this.buttons = buttons;
        }

    }
}


