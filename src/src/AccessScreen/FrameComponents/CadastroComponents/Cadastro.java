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
    private  int x, y, width, height;
    private  Jbutton[] buttons;
    private  Jbutton[] buttons2;

    public User_e_Senha user_senha;
    public PaintCards paintCards;
    public InfoPessoal pessoal;
    public Endereco endereco;
    public Jbutton[] getButtons() {
        return buttons;
    }

    public Cadastro(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 500;
        this.height = 550;
        this.buttons = new Jbutton[3];
        this.buttons2 = new Jbutton[3];
        this.user_senha = new User_e_Senha();
        this.paintCards = new PaintCards(getWidth(), getHeight());
        this.pessoal = new InfoPessoal();
        this.endereco = new Endereco();

        setBounds(getX(), getY(), getWidth(), getHeight());
        setOpaque(false);
        setLayout(null);
        setVisible(true);
    }

    public void addAtualizarCadastro(){
        addButton();
        User_e_Senha user_senha = new User_e_Senha();
        PaintCards paintCards = new PaintCards(500, 500);
        InfoPessoal pessoal = new InfoPessoal();
        Endereco endereco = new Endereco();
        addPessoa_Decalque(pessoal);
        add(paintCards);
        final int[] count = {0};
        getButtons()[0].addActionListener(e -> {
            setBoundsbutton(getButtons(), 0);
            setColorButton(getButtons(), 0);
            remove(paintCards);
            removeEndereco_Decalque(endereco);
            removeUser_senha_decalque(user_senha);
            addPessoa_Decalque(pessoal);
            remove(getButtons2()[2]);
            remove(getButtons2()[1]);
            add(getButtons2()[1]);
            count[0]=0;
            add(paintCards);
            repaint();
        });
        getButtons()[1].addActionListener(e -> {
            setBoundsbutton(getButtons(), 1);
            setColorButton(getButtons(), 1);
            remove(paintCards);
            removePessoa_Decalque(pessoal);
            removeUser_senha_decalque(user_senha);
            addEndereco_Decalque(endereco);
            remove(getButtons2()[2]);
            remove(getButtons2()[1]);
            add(getButtons2()[1]);
            count[0]=1;
            add(paintCards);
            repaint();

        });
        getButtons()[2].addActionListener(e -> {
            setBoundsbutton(getButtons(), 2);
            setColorButton(getButtons(), 2);
            remove(paintCards);
            removeEndereco_Decalque(endereco);
            removePessoa_Decalque(pessoal);
            addUser_senha_decalque(user_senha);

            remove(getButtons2()[2]);
            remove(getButtons2()[1]);
            add(getButtons2()[2]);
            count[0]=2;
            add(paintCards);
            repaint();

        });
        addActionButton(count);
    }

    public void addCadastro(){

        addButton2();
        User_e_Senha user_senha = new User_e_Senha();
        PaintCards paintCards = new PaintCards(500, 500);
        InfoPessoal pessoal = new InfoPessoal();
        Endereco endereco = new Endereco();
        addPessoa_Decalque(pessoal);
        add(paintCards);
        final int[] count = {0};
        getButtons2()[0].addActionListener(e -> {

            if (count[0]==0){
                System.out.println("b");
            } else if (count[0]==1) {
                getButtons()[0].doClick();
                setBoundsbutton(getButtons(), 0);
                setColorButton2(getButtons(), 0);
                remove(paintCards);
                removeEndereco_Decalque(endereco);
                removeUser_senha_decalque(user_senha);
                addPessoa_Decalque(pessoal);
                remove(getButtons2()[2]);
                remove(getButtons2()[1]);
                add(getButtons2()[1]);
                add(paintCards);
                repaint();
                count[0]=0;
            } else if (count[0]==2) {
                remove(getButtons2()[2]);
                add(getButtons2()[1]);
                setBoundsbutton(getButtons(), 1);
                setColorButton2(getButtons(), 1);
                remove(paintCards);
                removePessoa_Decalque(pessoal);
                removeUser_senha_decalque(user_senha);
                addEndereco_Decalque(endereco);
                remove(getButtons2()[2]);
                remove(getButtons2()[1]);
                add(getButtons2()[1]);
                add(paintCards);
                repaint();
                count[0]=1;
            }
        });
        //proximo
        getButtons2()[1].addActionListener(e -> {


            if (count[0]==0){
                setBoundsbutton(getButtons(), 1);
                setColorButton2(getButtons(), 1);
                remove(paintCards);
                removePessoa_Decalque(pessoal);
                removeUser_senha_decalque(user_senha);
                addEndereco_Decalque(endereco);
                remove(getButtons2()[2]);
                remove(getButtons2()[1]);
                add(getButtons2()[1]);
                add(paintCards);
                repaint();
                count[0]=1;
            } else if (count[0]==1) {

                remove(getButtons2()[1]);
                add(getButtons2()[2]);
                setBoundsbutton(getButtons(), 2);
                setColorButton2(getButtons(), 2);
                remove(paintCards);
                removeEndereco_Decalque(endereco);
                removePessoa_Decalque(pessoal);
                addUser_senha_decalque(user_senha);
                remove(getButtons2()[2]);
                remove(getButtons2()[1]);
                add(getButtons2()[2]);
                add(paintCards);
                repaint();
                count[0]=2;
            } else if (count[0]==2) {
                System.out.println("a");
            }
        });


    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        width = 500;
        height = 550;
        super.setBounds(x, y, width, height);
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

    public void setButtons(Jbutton[] buttons) {
        this.buttons = buttons;
    }

    public Jbutton[] getButtons2() {
        return buttons2;
    }

    public void setButtons2(Jbutton[] buttons2) {
        this.buttons2 = buttons2;
    }

    public User_e_Senha getUser_senha() {
        return user_senha;
    }

    public void setUser_senha(User_e_Senha user_senha) {
        this.user_senha = user_senha;
    }

    public PaintCards getPaintCards() {
        return paintCards;
    }

    public void setPaintCards(PaintCards paintCards) {
        this.paintCards = paintCards;
    }

    public InfoPessoal getPessoal() {
        return pessoal;
    }

    public void setPessoal(InfoPessoal pessoal) {
        this.pessoal = pessoal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private void addButton(){
        setEstilizacaoButtons(getButtons(),getButtons2());
        setBoundsbutton(getButtons(),0);

        for (Jbutton button:getButtons()) {
            add(button);
        }
        add(getButtons2()[0]);
        add(getButtons2()[1]);
    }
    private void addButton2(){
        setEstilizacaoButtons(getButtons(),getButtons2());
        setBoundsbutton(getButtons(),0);
        setColorButton2(getButtons(), 0);

        for (Jbutton button:getButtons()) {
            add(button);
        }
        add(getButtons2()[0]);
        add(getButtons2()[1]);
    }

    private void addActionButton(final int[]count){
        getButtons2()[0].addActionListener(e -> {

            if (count[0]==0){
                System.out.println("b");
            } else if (count[0]==1) {
                getButtons()[0].doClick();
                count[0]=0;
            } else if (count[0]==2) {
                remove(getButtons2()[2]);
                add(getButtons2()[1]);
                getButtons()[1].doClick();
                count[0]=1;
            }
        });
        //proximo
        getButtons2()[1].addActionListener(e -> {


            if (count[0]==0){
                getButtons()[1].doClick();
                count[0]=1;
            } else if (count[0]==1) {

                remove(getButtons2()[1]);
                add(getButtons2()[2]);
                getButtons()[2].doClick();
                count[0]=2;
            } else if (count[0]==2) {
                System.out.println("a");
            }
        });
    }
    private void setColorButton(Jbutton[]buttons, int n){
        for (int i = 0; i < buttons.length; i++) {
            if (i==n){
                buttons[i].setColors(Color.DARK_GRAY,Color.lightGray,ColorPaleta.blackColor());
                continue;
            }
            buttons[i].setColors(ColorPaleta.rgbgray2Color(), Color.lightGray, ColorPaleta.rgbgray2Color());

        }
    }
    private void setColorButton2(Jbutton[]buttons, int n){
        for (int i = 0; i < buttons.length; i++) {
            if (i==n){
                buttons[i].setColors(Color.DARK_GRAY,Color.DARK_GRAY,Color.DARK_GRAY);
                continue;
            }
            buttons[i].setColors(ColorPaleta.rgbgray2Color(), ColorPaleta.rgbgray2Color(), ColorPaleta.rgbgray2Color());

        }
    }
    public void addEndereco_Decalque(Endereco endereco){

        for (int i = 0; i < endereco.getJtexts().length; i++) {
            add(endereco.getJtexts()[i]);
            add(endereco.getLabels()[i]);
        }
    }
    public void removeEndereco_Decalque(Endereco endereco){

        for (int i = 0; i < endereco.getJtexts().length; i++) {
            remove(endereco.getJtexts()[i]);
            remove(endereco.getLabels()[i]);
        }
    }

    private void setEstilizacaoButtons(Jbutton[] buttons,Jbutton[]buttons2){
    String[] text = {"informações pessoais","endereço","usuario"};
    String[] text2 = {"voltar","próximo","finalizar"};
    int count = 0;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i]= new Jbutton();
            buttons[i].setVisible(true);
            buttons2[i] = new Jbutton();
            buttons2[i].setVisible(true);
        }
        for (Jbutton button:buttons) {
            button.setText(text[count]);
            button.setColors(ColorPaleta.rgbgray2Color(), Color.lightGray, ColorPaleta.blackColor());
            button.setForeground(ColorPaleta.White());
            count++;
        }
        count=0;
       for (Jbutton button:buttons2) {
            button.setText(text2[count]);
            button.setColors(Color.DARK_GRAY, Color.lightGray, ColorPaleta.blackColor());
            button.setForeground(ColorPaleta.White());
            count++;
        }
       buttons2[0].setBounds(40, 500, 160, 50);
       buttons2[1].setBounds(300, 500, 160, 50);
       buttons2[2].setBounds(300, 500, 160, 50);
        setColorButton(buttons, 0);

    }
    private void setBoundsbutton(Jbutton[] buttons ,int n){
        int count = 10;

        for (int i = 0; i < buttons.length; i++) {
            if ( n == i){
                buttons[i].setBounds(count, 0, 160, 60);
                count = count+160;
                continue;
            }
            buttons[i].setBounds(count, 0, 160, 50);
            count=count+160;
        }
    }

    public void addUser_senha_decalque(User_e_Senha user_senha){

        for (int i = 0; i < user_senha.getSenhatext().length; i++) {
            add(user_senha.getUserjtexts()[i]);
            add(user_senha.getUserlabels()[i]);

            add(user_senha.getSenhajtexts()[i]);
            add(user_senha.getSenhalabels()[i]);

            add(user_senha.getLegendaJlabels()[i]);
        }
    }
    public void removeUser_senha_decalque(User_e_Senha user_senha){

        for (int i = 0; i < user_senha.getSenhatext().length; i++) {
            remove(user_senha.getUserjtexts()[i]);
            remove(user_senha.getUserlabels()[i]);

            remove(user_senha.getSenhajtexts()[i]);
            remove(user_senha.getSenhalabels()[i]);

            remove(user_senha.getLegendaJlabels()[i]);
        }
    }
    public void addPessoa_Decalque(InfoPessoal pessoal){

        for (int i = 0; i <pessoal.getJtexts().length ; i++) {
            add(pessoal.getJtexts()[i]);
            add(pessoal.getLabels()[i]);
        }
    }
    public void removePessoa_Decalque(InfoPessoal pessoal){

        for (int i = 0; i <pessoal.getJtexts().length ; i++) {
            remove(pessoal.getJtexts()[i]);
            remove(pessoal.getLabels()[i]);
        }
    }
    private void InicializarJtext(JtextField[] jtexts){
        for (int i = 0; i < jtexts.length ; i++) {
            jtexts[i]= new JtextField();
            jtexts[i].setVisible(true);

        }
    }

    private void InicializarJlabel(JLabel[] jLabels ){
        for (int i = 0; i < jLabels.length ; i++) {
            jLabels[i]= new JLabel("");
            jLabels[i].setVisible(true);

        }
    }
    private void setTextsJtexts(JtextField[] jtexts, String[][] texts){
        int count = 0;
        for (JtextField jtext:jtexts) {
            jtext.setText(texts[count][1]);
            count++;
        }
    }

    private void setTextsJLabels(JLabel[] jLabels, String[][] texts){
        int count = 0;
        for (JLabel label:jLabels) {
            label.setText(texts[count][0]);
            count++;
        }
    }

    private void addStylizationJtextFields(JtextField[] jtexts){
        for (JtextField jtext:jtexts) {
            jtext.setBackground(ColorPaleta.White());
            jtext.setForeground(ColorPaleta.darkgrayColor());
            jtext.setFont(new Font("Arial", Font.BOLD, 15));
            jtext.setHorizontalAlignment(JTextField.CENTER);
        }
    }

    private void addFocusListenerJtextFields(JtextField[] jtexts, String[][] texts){
        for (int i = 0; i < jtexts.length; i++){
            int finalI = i;
            jtexts[i].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (jtexts[finalI].getText().equals(texts[finalI][1])||jtexts[finalI].getText().equals(texts[finalI][2])){
                        jtexts[finalI].setText("");
                        jtexts[finalI].setBackground(ColorPaleta.White());
                        jtexts[finalI].setForeground(ColorPaleta.darkgrayColor());
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (jtexts[finalI].getText().isEmpty()){
                        jtexts[finalI].setText(texts[finalI][2]);
                        jtexts[finalI].setBackground(Color.red);
                        jtexts[finalI].setForeground(Color.white);
                    } else if (jtexts[finalI].getText().equals(texts[finalI][2])) {
                        jtexts[finalI].setText(texts[finalI][1]);
                    }

                }
            });
        }
    }

    private void setBoundsJtextFields(JtextField[] jtexts, int x, int y, int spacing){
        int count = y;
        for (JtextField jtext:jtexts){
            jtext.setBounds(x, count, 300, 50);
            count=count+ spacing;
        }
    }

    private void setBoundsJLabels(JLabel[]labels, int x, int y, int spacing){
        int count = y;
        for (JLabel label:labels) {
            label.setBounds(x, count, 140, 50);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            count= count+ spacing;
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
            setTextsJtexts(getJtexts(), getTexts());
            addStylizationJtextFields(getJtexts());
            addFocusListenerJtextFields(getJtexts(), getTexts());
            setBoundsJtextFields(getJtexts(),145,55+20,70);


            InicializarJlabel(getLabels());
            setTextsJLabels(getLabels(), getTexts());
            setBoundsJLabels(getLabels(),10,55+20,70);

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

    public class InfoPessoal {
        JtextField[] jtexts;
        JLabel[]labels;
        String[][] text={{"Nome:","Digite seu nome","Nome incorreto!!"},
                        {"Data de Nascimento:","Digite a sua data de nascimento","Data incorreta"},
                        {"CPF:","Digite o seu cpf","CPF incorreto!!"},
                        {"Rg:","Digite o numero do seu rg","Rg incorreto!!"},
                        {"Email:","Digite seu email","Email incorreto!!"},
                        {"Renda atual:","Digite a sua renda atual","Renda atual incorreta!!"}};

        public InfoPessoal() {
            this.jtexts = new JtextField[getText().length];
            this.labels = new JLabel[getText().length];
            Endereco endereco = new Endereco();
            InicializarJtext(getJtexts());
            setTextsJtexts(getJtexts(), getText());
            addStylizationJtextFields(getJtexts());
            addFocusListenerJtextFields(getJtexts(), getText());
            setBoundsJtextFields(getJtexts(),145,55+20,70);

            InicializarJlabel(getLabels());
            setTextsJLabels(getLabels(), getText());
            setBoundsJLabels(getLabels(),10,55+20,70);

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

    public class User_e_Senha {
        private JtextField[] userjtexts;
        private JLabel[] userlabels;
        private JtextField[] senhajtexts;
        private JLabel[] senhalabels;
        private JLabel[] legendaJlabels;
        private  final String[][] usuariotext = {{"usuario:","digite o nome do seu usuario","usuario incorreto"},
                {"confirmar usuario:","confirme o seu usuario","usuario está diferente"}};
        private  final String[][] senhatext = {{"Senha:","Digite a sua senha","Senha incorreto"},
                {"confirmar Senha:","Confirme a sua senha","Senha está diferente"}};

        private  final String[][] legendatext = {{"<html><font color=#000000  face=arial><i><b> Cadastrar usuario:","",""},
                {"<html><font color=#000000  face=arial><i><b> Cadastrar senha:","",""}};

        public User_e_Senha() {
            this.userjtexts= new JtextField[this.usuariotext.length];
            this.userlabels = new JLabel[this.usuariotext.length];
            this.senhajtexts = new JtextField[this.senhatext.length];
            this.senhalabels = new JLabel[this.senhatext.length];
            this.legendaJlabels = new JLabel[this.legendatext.length];

            InicializarJtext(getUserjtexts());
            setTextsJtexts(getUserjtexts(), getUsuariotext());
            addStylizationJtextFields(getUserjtexts());
            addFocusListenerJtextFields(getUserjtexts(), getUsuariotext());
            setBoundsJtextFields(getUserjtexts(), 140, 95+40, 75);

            InicializarJlabel(getUserlabels());
            setTextsJLabels(getUserlabels(), getUsuariotext());
            setBoundsJLabels(getUserlabels(), 10, 95+40, 75);


            InicializarJtext(getSenhajtexts());
            setTextsJtexts(getSenhajtexts(), getSenhatext());
            addStylizationJtextFields(getSenhajtexts());
            addFocusListenerJtextFields(getSenhajtexts(), getSenhatext());
            setBoundsJtextFields(getSenhajtexts(), 145, 305+40, 80);

            InicializarJlabel(getSenhalabels());
            setTextsJLabels(getSenhalabels(), getSenhatext());
            setBoundsJLabels(getSenhalabels(), 10, 305+40, 80);

            InicializarJlabel(getLegendaJlabels());
            setTextsJLabels(getLegendaJlabels(),getLegendatext());
            setBoundsJLabels(getLegendaJlabels(), 20, 35+40, 200);
        }

        public JLabel[] getLegendaJlabels() {
            return legendaJlabels;
        }

        public void setLegendaJlabels(JLabel[] legendaJlabels) {
            this.legendaJlabels = legendaJlabels;
        }

        public String[][] getLegendatext() {
            return legendatext;
        }

        public JtextField[] getUserjtexts() {
            return userjtexts;
        }

        public void setUserjtexts(JtextField[] userjtexts) {
            this.userjtexts = userjtexts;
        }

        public JLabel[] getUserlabels() {
            return userlabels;
        }

        public void setUserlabels(JLabel[] userlabels) {
            this.userlabels = userlabels;
        }

        public JtextField[] getSenhajtexts() {
            return senhajtexts;
        }

        public void setSenhajtexts(JtextField[] senhajtexts) {
            this.senhajtexts = senhajtexts;
        }

        public JLabel[] getSenhalabels() {
            return senhalabels;
        }

        public void setSenhalabels(JLabel[] senhalabels) {
            this.senhalabels = senhalabels;
        }

        public String[][] getUsuariotext() {
            return usuariotext;
        }

        public String[][] getSenhatext() {
            return senhatext;
        }
    }

    public static class PaintCards extends JPanel {
        private int width, height;

        public PaintCards(int width, int height) {
            this.width = width;
            this.height = height;
            setBounds(0, 25, getWidth(), getHeight());
            setLayout(null);
            setOpaque(false);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(ColorPaleta.rgbGrey());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            g.dispose();
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

    }

    public static void main(String[] args) {
        Jframe frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(1300,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Cadastro cadastro1 = new Cadastro(10, 50);
        cadastro1.addAtualizarCadastro();
        frame.add(cadastro1);
        cadastro1 = new Cadastro(550, 50);
        cadastro1.addCadastro();
        frame.add(cadastro1);
        frame.setVisible(true);
    }
}