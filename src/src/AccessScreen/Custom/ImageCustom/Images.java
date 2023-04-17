package AccessScreen.Custom.ImageCustom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Classe que reune todas as imagens utilizadas na Tela Inicial.
 * 
 */
public class Images {

    public static Image ImagemJframe(){
        try {
            return javax.imageio.ImageIO.read(new File(Objects.requireNonNull(Images.class.getResource("gradient2.png")).toURI()));

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static Icon B_Color(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("B_color.png")));
    }
    public static Icon Financeiro(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("financeiro.png")));
    }
    public static Icon GradientPlugin(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("gradient_plugin.png")));
    }
    public static Icon GrayFrame(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("gray-dient.png")));
    }
    public static Icon Hands(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("hands2.png")));
    }
    public static Icon S_Icon(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("S_color_page.png")));
    }
    public static Icon S_Color(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("S_color.png")));
    }
    
}
