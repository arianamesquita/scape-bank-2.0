package AccessScreen.FrameComponents.CadastroComponents;

import MainScreen.Components.Custom.ColorPaleta;
import MainScreen.Components.CustomJButton.Jbutton;
import MainScreen.Components.CustomJTextField.JtextField;
import MainScreen.Components.CustomJframe.Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Cadastro extends JPanel {
    private final int x, y, width, height;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public Cadastro(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        setBounds(getX(), getY(), getWidth(), getHeight());
        setOpaque(false);
        setLayout(null);
        setVisible(true);

    }

    void addEndereco_Decalque(){
        Endereco endereco = new Endereco();
        for (int i = 0; i < endereco.getJtexts().length; i++) {
            add(endereco.getJtexts()[i]);
            add(endereco.getLabels()[i]);

        }
        PaintCards paintCards = new PaintCards(getWidth(), getWidth());
        add(paintCards);

    }
    void addPessoa_Decalque(){
        Pessoal pessoal = new Pessoal();
        for (int i = 0; i <pessoal.getJtexts().length ; i++) {
            add(pessoal.getJtexts()[i]);
            add(pessoal.getLabels()[i]);
        }
        PaintCards paintCards = new PaintCards(getWidth(), getWidth());
        add(paintCards);
    }
    void InicializarJtext(JtextField[] jtexts){
        for (int i = 0; i < jtexts.length ; i++) {
            jtexts[i]= new JtextField();
            jtexts[i].setVisible(true);

        }
    }

    void InicializarJlabel(JLabel[] jLabels ){
        for (int i = 0; i < jLabels.length ; i++) {
            jLabels[i]= new JLabel("");
            jLabels[i].setVisible(true);

        }
    }

    void setTextJtext(JtextField[] jtexts,String[][] texts){
        int count = 0;
        for (int i = 0; i < jtexts.length; i++) {
            jtexts[i].setText(texts[i][1]);

        }
    }

    void setTextJlabel(JLabel[] jLabels,String[][] texts){
        int count = 0;
        for (JLabel label:jLabels) {
            label.setText(texts[count][0]);
            count++;
        }
    }


    void addEstilizacaoJtexts(JtextField[] jtexts){
        for (JtextField jtext:jtexts) {
            jtext.setBackground(ColorPaleta.White());
            jtext.setForeground(ColorPaleta.darkgrayColor());
            jtext.setFont(new Font("Arial", Font.BOLD, 15));
            jtext.setHorizontalAlignment(JTextField.CENTER);
        }
    }
    void addFocuslistenerJtext(JtextField[] jtexts,String[][] texts){
        int count = 0;

        for (JtextField jtext:jtexts) {
            int finalCount = count;
            jtext.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (jtext.getText().equals(texts[finalCount][1])||jtext.getText().equals(texts[finalCount][2])){
                        jtext.setText("");
                        jtext.setBackground(ColorPaleta.White());
                        jtext.setForeground(ColorPaleta.darkgrayColor());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (jtext.getText().equals("")){
                        jtext.setText(texts[finalCount][2]);
                        jtext.setBackground(Color.red);
                        jtext.setForeground(Color.white);

                    } else if (jtext.getText().equals(texts[finalCount][2])) {
                        jtext.setText(texts[finalCount][1]);

                    }

                }
            });
            count++;

        }

    }
    void  setBoundsJtext(JtextField[] jtexts,int x, int y){
        int count = y;
        for (JtextField jtext:jtexts){
            jtext.setBounds(x, count, 300, 50);
            count=count+75;
        }

    }

    void setBoundsJlabel(JLabel[]labels,int x,int y){
        int count = y;
        for (JLabel label:labels) {
            label.setBounds(x, count, 140, 50);
            label.setVerticalTextPosition(SwingConstants.CENTER);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            count= count+75;
        }
    }

    public class Endereco {
        private JtextField[] jtexts;
        private JLabel[] labels;
        private  final String[][] texts = {{"Cep:","digite o seu cep","Cep incorreto 000.000.00"},
                           {"Número:","digite o numero de seu endereço","numero incorreto 00"},
                           {"Bairro:"," digite o seu bairro","bairro incorreto"},
                           {"Estado:","digite seu estado","estado incorreto"},
                           {"Lougradouro:","digite seu lougradouro","lougradouro incorreto"},
                           {"Cidade/Município:","digite o nome da sua cidade","cidade incorreta"}};



        public Endereco(){

            jtexts = new JtextField[texts.length];
            labels = new JLabel[texts.length];


            InicializarJtext(getJtexts());
            setTextJtext(getJtexts(), getTexts());
            addEstilizacaoJtexts(getJtexts());
            addFocuslistenerJtext(getJtexts(), getTexts());
            setBoundsJtext(getJtexts(),140,35);


            InicializarJlabel(getLabels());
            setTextJlabel(getLabels(), getTexts());
            setBoundsJlabel(getLabels(),10,35);

        }


        public JtextField[] getJtexts() {
            return jtexts;
        }

        public void setJtexts(JtextField[] jtexts) {
            this.jtexts = jtexts;
        }

        public JLabel[] getLabels() {
            return labels;
        }

        public void setLabels(JLabel[] labels) {
            this.labels = labels;
        }

        public String[][] getTexts() {
            return texts;
        }

    }
    private class Pessoal{
        JtextField[] jtexts;
        JLabel[]labels;
        String[][] text={{"Nome:","Digite seu nome","Nome incorreto!!"},
                        {"Data de Nascimento:","Digite a sua data de nascimento","Data incorreta"},
                        {"CPF:","Digite o seu cpf","CPF incorreto!!"},
                        {"Rg:","digite o numero do seu rg","Rg incorreto!!"},
                        {"Email:","Digite seu email","Email incorreto!!"}};

        public Pessoal() {
            this.jtexts = new JtextField[getText().length];
            this.labels = new JLabel[getText().length];
            Endereco endereco = new Endereco();
            InicializarJtext(getJtexts());
            setTextJtext(getJtexts(), getText());
            addEstilizacaoJtexts(getJtexts());
            addFocuslistenerJtext(getJtexts(), getText());
            setBoundsJtext(getJtexts(),145,75);

            InicializarJlabel(getLabels());
            setTextJlabel(getLabels(), getText());
            setBoundsJlabel(getLabels(),10,75);

        }

        public JtextField[] getJtexts() {
            return jtexts;
        }

        public void setJtexts(JtextField[] jtexts) {
            this.jtexts = jtexts;
        }

        public JLabel[] getLabels() {
            return labels;
        }

        public void setLabels(JLabel[] labels) {
            this.labels = labels;
        }

        public String[][] getText() {
            return text;
        }

        public void setText(String[][] text) {
            this.text = text;
        }
    }
    private static class renda{

    }
    private static class PaintCards extends JPanel {

        /**
         * construtor da sub-class PaintCards
         * @param width — largura do JPanel.
         * @param height — comprimento do JPanel.
         */
        private int width, height;
        public PaintCards(int width, int height) {
            this.width = width;
            this.height =height;
            setBounds(0, 0, getWidth(), getHeight());
            setLayout(null);
            setOpaque(false);
            setVisible(true);
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

        /**
         * Método da sub-class PaintCards usado para realizar os desenhos dos cards.
         * @param g  the <code>Graphics</code> context in which to paint
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(ColorPaleta.rgbGrey());
            g.fillRoundRect(0,  0, getWidth(), getHeight(), 40, 40);
            g.dispose();
        }
    }



    public static void main(String[] args) {
        Jframe frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(1300,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Cadastro cadastro = new Cadastro(200, 100, 500, 500);
        cadastro.addPessoa_Decalque();
        frame.add(cadastro );

        frame.setVisible(true);
    }

}
