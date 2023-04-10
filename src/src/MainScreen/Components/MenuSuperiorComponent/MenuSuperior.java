package MainScreen.Components.MenuSuperiorComponent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuSuperior extends JPanel {

    private final int x, y, width, height;

    public MenuSuperior(int x, int y, int width, int height) {
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
       addPaintMenu();
       setBounds(getX(),getY(),getWidth(),getHeight());
       setLayout(null);
       setVisible(true);
    }

    public int getX() {
       return x;
    }

    public int getY() {
       return y;
    }

    public int getWidth() {
       return width;
    }

    public int getHeight() {
       return height;
    }

    public void addPaintMenu(){
       Component component = new PaintMenu(getWidth(),getHeight());
       add(component);
    }

    private static class PaintMenu extends JPanel {
       int width,height;

       public PaintMenu(int width, int height) {
           this.width = width;
           this.height = height;

           setBounds(0,0,getWidth(),getHeight());
           setLayout(null);
           setVisible(true);
       }


       @Override
       public int getWidth() {
           return width;
       }


       @Override
       public int getHeight() {
           return height;
       }


       @Override
       public void paint(Graphics g) {
           Color rgbgrey = new Color(199,188,161);    
           g.setColor(rgbgrey);
           g.fillRect(0, 0, getWidth(), getHeight());
           g.dispose();
       }
    }
    
    private JButton buttonLogo;

    public void ButtonLogo(){
        Icon logo = new ImageIcon(getClass().getResource("SP_logo_provisoria.jpg"));
        buttonLogo = new JButton(" ", logo);
        add(buttonLogo);        
    }
    
}
