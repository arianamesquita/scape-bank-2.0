package AccessScreen.FrameComponents;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import AccessScreen.Custom.ColorFontPaletas;
import AccessScreen.Custom.ImageCustom.Images;
import AccessScreen.CustomJframe.Jframe;

/**
 * 
 * Classe que configura os itens da tela inicial trabalhando com os construtores definidos na classe
 * LabelForm.
 * 
 * Aqui configuramos o frame, os textos, imagens e botões.
 * 
 */
public class FrameComponents extends JFrame {
    
/**
* Inicializando o Jframe.
*/
    static Jframe frame;

/**
 * Criando a classe FrameComponents.
 */
    public FrameComponents(){

        /**
         * Configurações totais do frame acontecem aqui, sendo definido a imagem de fundo da tela,
         * o título na barra superior, o estilo de layout, o tamanho do frame com largura e altura
         * (width e height), a posição relativa na tela e se o tamanho dela é ajustável à tela.
         * 
         */
        frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(1300,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
        /**
         * Criando um vetor que envia os parâmetros para o construtor da classe LabelForm. 
         * 
         */
        LabelForm[] labelText = new LabelForm[7];
        labelText[0] = new LabelForm("cape", ColorFontPaletas.font1(), ColorFontPaletas.color1(), 200, 
                                        25, 400, 250);
        labelText[1] = new LabelForm("ank", ColorFontPaletas.font1(), ColorFontPaletas.color1(), 275,
                                         180, 400, 200);
        labelText[2] = new LabelForm("<html><center>Conheça o banco do futuro!<br>"
                                        +"<br>A forma mais fácil de enviar, gastar, guardar e investir!!", 
                                        ColorFontPaletas.font2(), ColorFontPaletas.color2(), 90, 300, 
                                        500, 300);                            
        labelText[3] = new LabelForm("Login", ColorFontPaletas.font3(), ColorFontPaletas.color3(), 750, 
                                        120, 300, 200);
        labelText[4] = new LabelForm("<html><center>Entre com seus dados corretamente"+ 
                                        "<br> para acessar o sistema.", ColorFontPaletas.font4(), 
                                        ColorFontPaletas.color3(), 665, 240, 500, 100);
        labelText[5] = new LabelForm("Usuário: ", ColorFontPaletas.font4(), ColorFontPaletas.color3(),
                                         660, 300, 500, 100);
        labelText[6] = new LabelForm("Senha: ", ColorFontPaletas.font4(), ColorFontPaletas.color3(), 
                                        660, 340, 500, 100);

        /**
         * Laço de repetição que retorna para o label as informações parametrizadas acima no vetor do LabelForm.
         * 
         */
        JLabel labels = new JLabel();
        for(int i = 0; i < 7; i++){
            labels = new JLabel(labelText[i].getText());
            labels.setFont(labelText[i].getFont());
            labels.setForeground(labelText[i].getColor());
            labels.setBounds(labelText[i].getX(), labelText[i].getY(), labelText[i].getWidth(), labelText[i].getHeight());
            labels.setVisible(true);
            frame.add(labels); //adiciona o label de imagem na tela inial, ou seja, no frame criado para ela.
        }


        /**
         * Iniciando a criação dos botões definindo um vetor para os botões e enviando os parâmetros para 
         * o construtor da classe LabelForm.
         * 
         */
        LabelForm[] labelButton = new LabelForm[3];
        labelButton[0] = new LabelForm("Login", ColorFontPaletas.font5(), ColorFontPaletas.lightGray(),
                                         840, 460, 160, 30);
        labelButton[1] = new LabelForm("Primeiro Acesso", ColorFontPaletas.font5(), ColorFontPaletas.lightGray(),
                                         660, 460, 160, 30);
        labelButton[2] = new LabelForm("<html><u>Esqueci minha senha.", ColorFontPaletas.font6(),
                                        ColorFontPaletas.lightGray(), 720, 410, 175, 24);  

        /**
         * Criando um vetor de botões para as estilizações independentes de alguns deles. Para as estilizações
         * que possuem parâmetros em comum utilizamos o laço de repetição for que vai receber as informações
         * definidas no vetor do LabelForm.
         * 
         */
        JButton[] button = new JButton[3];
        for(int k = 0; k < 3; k++){
            button[k] = new JButton(labelButton[k].getText());
            button[k].setBounds(labelButton[k].getX(), labelButton[k].getY(), labelButton[k].getWidth(),
                                    labelButton[k].getHeight());
            button[k].setBackground(labelButton[k].getColor());
            button[k].setFont(labelButton[k].getFont());
            button[k].setForeground(ColorFontPaletas.black());
            button[k].setVisible(true);
            frame.add(button[k]); //adiciona o label de botões na tela inicial, ou seja, no frame criado para ela.
        }
        button[2].setBorderPainted(false); //deixa o botão de "esqueci minha senha" sem borda definida.
        button[2].setOpaque(false); //deixa o botão de "esqueci minha senha" sem cor definida no fundo.

        /**
         * Inicializando e parametrizando o botão de check ao lado do campo de senha para não mostrar 
         * o que está sendo digitado (CheckBox). Ele não pode ser inicializado após as imagens ou não 
         * aparece quando roda o programa.
         * 
         */
        JCheckBox JCB;
        JCB = new JCheckBox();
        JCB.setBounds(1000, 385, 19, 15);
        JCB.setBackground(ColorFontPaletas.lightGray());
        JCB.setForeground(ColorFontPaletas.black());
        JCB.setVisible(true);
        frame.add(JCB); //adiciona o checkBox na tela inicial, ou seja, no frame criado para ela.


        /**
         * Aqui começamos a criar as imagens definidas na tela inicial criando dois vetores, um para os labels 
         * das imagens porque algumas possuem parâmetros específicos e um vetor para definir as informações de
         * cada imagem que serão parametrizadas através do construtor da classe LabelForm.
         * 
         */
        JLabel[] labels2 = new JLabel[6];
        LabelForm[] labelImage = new LabelForm[6];
        labelImage[0] = new LabelForm(Images.Financeiro(), 510, 80, 150, 150);
        labelImage[1] = new LabelForm(Images.S_Color(), 80, 45, 150, 200);
        labelImage[2] = new LabelForm(Images.B_Color(), 160, 180, 150, 200);
        labelImage[3] = new LabelForm(Images.GradientPlugin(), 600, 80, 460, 450);
        labelImage[4] = new LabelForm(Images.Hands(), 1050, 80, 250, 450);
        labelImage[5] = new LabelForm(Images.GrayFrame(), 77, 80, 575, 450);


        /**
         * Laço de repetição que define cada label do vetor com as informações parametrizadas para cada imagem
         * através do vetor da classe LabelForm utilizados acima.
         * 
         */
        for(int j = 0; j < 6; j++){
            labels2[j] = new JLabel();
            labels2[j].setIcon(labelImage[j].getImage());
            labels2[j].setBounds(labelImage[j].getX(), labelImage[j].getY(), labelImage[j].getWidth(), labelImage[j].getHeight());
            frame.add(labels2[j]); //adiciona o label de imagem na tela inicial, ou seja, no frame criado para ela.
        }
        labels2[4].setOpaque(true); //deixa a imagem com as mãos com o fundo transparente ou não.
        labels2[0].setOpaque(false); //deixa a imagem com o $ com o fundo transparente ou não.


        /**
         * Começando a criação do campo de texto (textField) e do campo de senha (passwordField) inicializando
         * as variáveis utilizadas para cada um deles.
         * 
         */
        JTextField JTF;
        JPasswordField JPF;

        /**
         * Chamando o construtor para organizar os parâmetros do textField (campo de texto), desta forma
         * qualquer fica mais fácil fazer as modificações caso sejam necessárias.
         * 
         */
        LabelForm textField = new LabelForm("Digite seu nome de usuário.", ColorFontPaletas.font7(), 
                                            ColorFontPaletas.darkGray(), 740, 340, 260, 24);
        JTF = new JTextField(textField.getText());
        JTF.setBounds(textField.getX(),textField.getY(),textField.getWidth(),textField.getHeight());
        JTF.setForeground(textField.getColor());
        JTF.setFont(textField.getFont());
        JTF.setBackground(ColorFontPaletas.lightGray());
        JTF.setVisible(true);
        frame.add(JTF); //adiciona o textField ou campo de texto na tela inicial, ou seja, no frame criado para ela.

        /**
         * Chamando o construtor para organizar os parâmetros do passwordField (campo de senha), desta forma
         * qualquer fica mais fácil fazer as modificações caso sejam necessárias.
         * 
         */
        LabelForm passField = new LabelForm("Digite a sua senha.", ColorFontPaletas.font7(), 
                                            ColorFontPaletas.darkGray(), 740, 380, 260, 24);
        JPF = new JPasswordField(passField.getText());
        JPF.setBounds(passField.getX(),passField.getY(),passField.getWidth(),passField.getHeight());
        JPF.setForeground(passField.getColor());
        JPF.setFont(passField.getFont());
        JPF.setBackground(ColorFontPaletas.lightGray());
        JPF.setVisible(true);
        JPF.setEchoChar('\u0000'); //define o char que aparece quando a senha for digitada sem o checkBox.
        frame.add(JPF); //adiciona o passwordField ou campo de senha na tela inicial, ou seja, no frame criado para ela.
               

        frame.setVisible(true); //libera as informações adicionadas no frame da tela inicial para serem visíveis.
    }
}
