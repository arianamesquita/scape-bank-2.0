package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import testesDaAnna.PagamentosField;

public class AreaPagamentoGUI extends JPanel{

    PagamentosField pagamentosField;
    PaintMenu paintMenu;


    public AreaPagamentoGUI(PagamentosField pagamentosField) {

        this.pagamentosField = pagamentosField;

        setBounds(400, 160, 700, 570);
        setLayout(null);
        pagamentosField.setBounds(60, 150, 250, 200);

        
        paintMenu = new PaintMenu();
        paintMenu.setBackground(ColorPaleta.rgbgray2Color());
        paintMenu.setLayout(null);
        paintMenu.setBounds(2, 2, 700, 550);
        paintMenu.setOpaque(false);
        
        
        paintMenu.add(pagamentosField);
        add(paintMenu);
        setOpaque(false);
        setVisible(true);
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
