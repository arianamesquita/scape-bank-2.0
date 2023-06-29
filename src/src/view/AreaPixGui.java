package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import view.viewAdds.PixField;

public class AreaPixGui extends JPanel{

    PixField pixField;
    PaintMenu paintMenu;
    ComprovanteGUI comprovante;

    public AreaPixGui(PixField pixField) {

        this.pixField = pixField;
        this.comprovante = new ComprovanteGUI();

        setBounds(400, 160, 700, 570);
        setLayout(null);
        pixField.setBounds(60, 20, 600, 120);
        

        comprovante.setBounds(180, 50, 600, 600);
        comprovante.setOpaque(false);
        comprovante.setVisible(true);

        
        paintMenu = new PaintMenu();
        paintMenu.setBackground(ColorPaleta.rgbgray2Color());
        paintMenu.setLayout(null);
        paintMenu.setBounds(2, 2, 1500, 550);
        paintMenu.setOpaque(false);
        

        paintMenu.add(comprovante);
        paintMenu.add(pixField);

        add(paintMenu);

        setOpaque(false);
        setVisible(true);
    }

    


    public PixField getPixField() {
        return pixField;
    }
    public void setPixField(PixField pixField) {
        this.pixField = pixField;
    }
    public PaintMenu getPaintMenu() {
        return paintMenu;
    }
    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }
    public ComprovanteGUI getComprovante() {
        return comprovante;
    }
    public void setComprovante(ComprovanteGUI comprovante) {
        this.comprovante = comprovante;
    }


    public class PaintMenu extends JPanel{
    private int rounded = 10;
  
    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), getRounded(), getRounded());
        super.paint(g);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }
    
    }
    
}
