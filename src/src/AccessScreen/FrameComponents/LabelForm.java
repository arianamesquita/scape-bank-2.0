package AccessScreen.FrameComponents;

import java.awt.Color;
import java.awt.Font;
/**
 * Classe que cria os construtores para para a classe FrameComponents.
 * 
 * Um dos construtores recebe os componentes que criam os labels.
 * O segundo construtor recebe os componentes que criam as imagens.
 * 
 */
public class LabelForm {


    String text;
    String imageName;
    Color color;
    Font font;

    int x;
    int y;
    int width;
    int height;


/**
 * Construtor para criar os labels com imagens, recebe o parâmetro imagem e define a posição (x e y)
 * e a dimensão da imagem na tela definindo largura e altura (width e height).
 * 
 * @param imageName
 * @param x
 * @param y
 * @param width
 * @param height
 */
    public LabelForm(String imageName, int x, int y, int width, int height) {
        this.imageName = imageName;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
/**
 * Construtor que cria os labels com textos recebendo como parâmetros a String com o texto a ser utilizado,
 * a fonte e cor definida, a posição na tela (x e y) e a dimensão do label na tela definindo largura e 
 * altura (width e height).
 * @param text
 * @param font
 * @param color
 * @param x
 * @param y
 * @param width
 * @param height
 */
    public LabelForm(String text, Font font, Color color, int x, int y, int width, int height) {
        this.text = text;
        this.font = font;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

/**
 * Função para retornar o texto informado pelo construtor.
 * 
 * @return
 */
    public String getText() {
        return text;
    }
/**
 * Função que define o texto a ser retornado quando chamado.
 * 
 * @param text
 */
    public void setText(String text) {
        this.text = text;
    }

/**
 * Função que retorna a imagem definida pelo construtor.
 * 
 * @return
 */
    public String getImageName() {
        return imageName;
    }
/**
 * Função que define a imagem a ser retornada quando chamada.
 * 
 * @param imageName
 */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    } 

/**
 * Função que retorna a posição horizontal que o label deve ocupar na tela.
 * 
 * @return
 */
    public int getX() {
        return x;
    }
/**
 * Função que define a posição horizontal que o label deve ocupar na tela.
 * 
 * @param x
 */
    public void setX(int x) {
        this.x = x;
    }

/**
 * Função que retorna a posição vertical que o label deve ocupar na tela.
 * 
 * @return
 */
    public int getY() {
        return y;
    }
/**
 * Função que define a posição vertical que o label deve ocupar na tela.
 * 
 * @param y
 */
    public void setY(int y) {
        this.y = y;
    }

/**
 * Função que retorna a largura (width) que o label deve ocupar na tela.
 * 
 * @return
 */
    public int getWidth() {
        return width;
    }
/**
 * Função que define a largura (width) que o label deve ocupar na tela.
 * @param width
 */
    public void setWidth(int width) {
        this.width = width;
    }

/**
 * Função que retorna a altura (height) que o label deve ocupar na tela.
 * 
 * @return
 */
    public int getHeight() {
        return height;
    }
/**
 * Função que define a altura (height) que o label deve ocupar na tela.
 * 
 * @param height
 */
    public void setHeight(int height) {
        this.height = height;
    }

/**
 * Função que retorna a cor a ser utilizada no label.
 * 
 * @return
 */
    public Color getColor() {
        return color;
    }
/**
 * Função que define a cor a ser utilizada no label.
 * 
 * @param color
 */
    public void setColor(Color color) {
        this.color = color;
    }

/**
 * Função que retorna a fonte a ser utilizada nos textos do label.
 * 
 * @return
 */
    public Font getFont() {
        return font;
    }
/**
 * Função que define a fonte a ser utilizada nos textos do label.
 * @param font
 */
    public void setFont(Font font) {
        this.font = font;
    }
    
}
