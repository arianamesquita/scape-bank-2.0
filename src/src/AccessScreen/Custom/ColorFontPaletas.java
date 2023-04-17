package AccessScreen.Custom;

import java.awt.Color;
import java.awt.Font;

/**
 * Classe que reúne a padronização de Fontes e Cores utilizadas na Tela Inicial.
 * 
 */
public class ColorFontPaletas {
        
    public static Font font1(){return new Font("Broadway", Font.PLAIN, 80);}
    public static Font font2(){return new Font("Century Gothic", Font.BOLD, 24);}
    public static Font font3(){return new Font("Century Gothic", Font.PLAIN, 55);}
    public static Font font4(){return new Font("Century Gothic", Font.BOLD, 18);}
    public static Font font5(){return new Font("Century Gothic", Font.BOLD, 16);}
    public static Font font6(){return new Font("Century Gothic", Font.BOLD, 12);}
    public static Font font7(){return new Font("BankGothic Lt BT", Font.ITALIC, 16);}

    public static Color color1(){return new Color(27,27,47);} //#1B1B2F
    public static Color color2(){return new Color(0,63,92);} //#1B1B2F
    public static Color color3(){return new Color(33,33,33);} //#212121
    public static Color lightGray(){return new Color(192, 192, 192);}
    public static Color black(){return new Color(0,0,0);}
    public static Color darkGray(){return new Color(64,64,64);}

}
