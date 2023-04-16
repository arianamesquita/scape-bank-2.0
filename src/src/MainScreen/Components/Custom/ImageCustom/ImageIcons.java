package MainScreen.Components.Custom.ImageCustom;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ImageIcons {

    public static Image ImagemJframe(){
        try {
            return javax.imageio.ImageIO.read(new File(Objects.requireNonNull(ImageIcons.class.getResource("gradient2.png")).toURI()));

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static Icon ImagemPesquisar(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("botaopesquisar.png")));
    }
    public static Icon ImagemMenu_Icone(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("menu_icone.png")));
    }
    public static Icon ImagemNotificaoTrue(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("notificacao_cheia.png")));
    }
    public static Icon ImagemNotificacaoFalse(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("S_logo_provisoria.png")));
    }
    public static Icon ImagemSair(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("sair_sistema.png")));
    }
    public static Icon ImagemLogo(){
        return new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource("S_logo_provisoria.png")));
    }
}

