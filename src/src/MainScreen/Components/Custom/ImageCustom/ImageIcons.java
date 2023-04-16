package MainScreen.Components.Custom.ImageCustom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.imageio.IIOImage;

public class ImageIcons {

    public static Image ImageJframe(){
        try{
         final Image backgroundImage = javax.imageio.ImageIO.read(new File(getClass().getResource("gradient2.png")).toURI());
        return backgroundImage;
     } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
}
