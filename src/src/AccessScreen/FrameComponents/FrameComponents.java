package AccessScreen.FrameComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
         * o título na barra superior, o estilo de layout, o ícone da imagem na barra superior,
         * o tamanho do frame com largura e altura (width e height), a posição relativa na tela e 
         * se o tamanho dela é ajustável à tela.
         * 
         */
        ImageIcon imageIcon7 = new ImageIcon(getClass().getResource("S_color_page.png"));
        frame = new Jframe();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setIconImage(imageIcon7.getImage());
        frame.setSize(1300,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        /**
         * Definindo as fontes e cores que serão utilizadas nos labels de textos.
         * 
         */
        Font font1 = new Font("Broadway", Font.PLAIN, 80);
        Font font2 = new Font("Century Gothic", Font.BOLD, 24);
        Font font3 = new Font("Century Gothic", Font.PLAIN, 55);
        Font font4 = new Font("Century Gothic", Font.BOLD, 18);

        Color color1 = new Color(27,27,47); //#1B1B2F
        Color color2 = new Color(0,63,92); //#1B1B2F
        Color color3 = new Color(33,33,33); //#212121

        /**
         * Criando um vetor que envia os parâmetros para o construtor da classe LabelForm. 
         * 
         */
        LabelForm[] labelText = new LabelForm[7];
        labelText[0] = new LabelForm("cape", font1, color1, 200, 25, 400, 250);
        labelText[1] = new LabelForm("ank", font1, color1, 275, 180, 400, 200);
        labelText[2] = new LabelForm("<html><center>Conheça o banco do futuro!<br>"
                                +"<br>A forma mais fácil de enviar, gastar, guardar e investir!!", 
                                font2, color2, 90, 300, 500, 300);                            
        labelText[3] = new LabelForm("Login", font3, color3, 750, 120, 300, 200);
        labelText[4] = new LabelForm("<html><center>Entre com seus dados corretamente"+ 
                                "<br> para acessar o sistema.", font4, color3, 665, 240, 500, 100);
        labelText[5] = new LabelForm("Usuário: ", font4, color3, 660, 300, 500, 100);
        labelText[6] = new LabelForm("Senha: ", font4, color3, 660, 340, 500, 100);

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
            frame.add(labels); //adiciona o label de fontes na tela inial, ou seja, no frame criado para ela.
        }


        /**
         * Definindo as cores e fontes que serão utilizados nos botões abaixo.
         * 
         */
        Color lightGray = new Color(192, 192, 192);
        Color black = new Color(0,0,0);
        Color darkGray = new Color(64,64,64);

        Font font5 = new Font("Century Gothic", Font.BOLD, 16);
        Font font6 = new Font("Century Gothic", Font.BOLD, 12);
        Font font7 = new Font("BankGothic Lt BT", Font.ITALIC, 16);

        /**
         * Iniciando a criação dos botões definindo um vetor para os botões e enviando os parâmetros para 
         * o construtor da classe LabelForm.
         * 
         */
        LabelForm[] labelButton = new LabelForm[3];
        labelButton[0] = new LabelForm("Login", font5, lightGray, 840, 460, 160,
                                        30);
        labelButton[1] = new LabelForm("Primeiro Acesso", font5, lightGray, 660, 460, 
                                        160, 30);
        labelButton[2] = new LabelForm("<html><u>Esqueci minha senha.", font6,lightGray, 720,
                                         410, 175, 24);  

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
            button[k].setForeground(black);
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
        JCB.setBackground(lightGray);
        JCB.setForeground(black);
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
        labelImage[0] = new LabelForm("financeiro.png", 510, 80, 150, 150);
        labelImage[1] = new LabelForm("S_color.png", 80, 45, 150, 200);
        labelImage[2] = new LabelForm("B_color.png", 160, 180, 150, 200);
        labelImage[3] = new LabelForm("gradient_plugin.png", 600, 80, 460, 450);
        labelImage[4] = new LabelForm("hands2.png", 1050, 80, 250, 450);
        labelImage[5] = new LabelForm("gray-dient.png", 77, 80, 575, 450);


        /**
         * Laço de repetição que define cada label do vetor com as informações parametrizadas para cada imagem
         * através do vetor da classe LabelForm utilizados acima.
         * 
         */
        for(int j = 0; j < 6; j++){
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(labelImage[j].getImageName()));
            labels2[j] = new JLabel();
            labels2[j].setIcon(imageIcon);
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
        LabelForm textField = new LabelForm("Digite seu nome de usuário.", font7, darkGray, 740, 340,
                                             260, 24);
        JTF = new JTextField(textField.getText());
        JTF.setBounds(textField.getX(),textField.getY(),textField.getWidth(),textField.getHeight());
        JTF.setForeground(textField.getColor());
        JTF.setFont(textField.getFont());
        JTF.setBackground(lightGray);
        JTF.setVisible(true);
        frame.add(JTF); //adiciona o textField ou campo de texto na tela inicial, ou seja, no frame criado para ela.

        /**
         * Chamando o construtor para organizar os parâmetros do passwordField (campo de senha), desta forma
         * qualquer fica mais fácil fazer as modificações caso sejam necessárias.
         * 
         */
        LabelForm passField = new LabelForm("Digite a sua senha.", font7, darkGray, 740, 380, 
                                            260, 24);
        JPF = new JPasswordField(passField.getText());
        JPF.setBounds(passField.getX(),passField.getY(),passField.getWidth(),passField.getHeight());
        JPF.setForeground(passField.getColor());
        JPF.setFont(passField.getFont());
        JPF.setBackground(lightGray);
        JPF.setVisible(true);
        JPF.setEchoChar('\u0000'); //define o char que aparece quando a senha for digitada sem o checkBox.
        frame.add(JPF); //adiciona o passwordField ou campo de senha na tela inicial, ou seja, no frame criado para ela.
               

        frame.setVisible(true); //libera as informações adicionadas no frame da tela inicial para serem visíveis.
    }
}
