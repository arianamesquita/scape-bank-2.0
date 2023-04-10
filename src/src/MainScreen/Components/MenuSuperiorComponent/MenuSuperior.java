package MainScreen.Components.MenuSuperiorComponent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuSuperior extends JPanel {

    private final int x, y, width, height;
    private JTextField searchField;
    private JButton[] button;

    public MenuSuperior(int x, int y, int width, int height, JTextField z, JButton[] button) {
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
       this.searchField = z;
       this.button = button;
       addPaintMenu();
       setBounds(getX(),getY(),getWidth(),getHeight());
       setLayout(null);
       ButtonSearch(getSearchField());
       add(getSearchField());
       ButtonLogo(getButton()[0]);
       SearchIcon(getButton()[1]);
       addButton();
       setVisible(true);
    }
   void addButton() {
      for (JButton button : getButton()) {
         add(button);
      }
   }

    
    public JButton[] getButton() {
      return button;
   }
   public void setButton(JButton[] button) {
      this.button = button;
   }

   public JTextField getSearchField() {
      return searchField;
   }
   public void setSearchField(JTextField searchField) {
      this.searchField = searchField;
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

    public void ButtonLogo(JButton buttonLogo){
        Icon logo = new ImageIcon(getClass().getResource("S_logo_provisoria.png"));
        Color rgbgrey = new Color(199,188,161);    
        buttonLogo = new JButton(logo);
        buttonLogo.setBounds(20, 1, 100, 100);
        buttonLogo.setBorderPainted(false);
        buttonLogo.setOpaque(true);
        buttonLogo.setBackground(rgbgrey);
        buttonLogo.setVisible(true);       
    }
    public void ButtonSearch(JTextField text){
      text.setBounds(160, 25, 500, 45);
      text.setBackground(Color.white);
      text.setForeground(Color.BLACK);
      text.setFont(new Font("Arial", Font.BOLD, 20));
      text.setText("Pesquisar..");
      text.setVisible(true);
    }
    public void SearchIcon (JButton buttonLogo){
      Icon logo = new ImageIcon(getClass().getResource("botaopesquisar.png"));
      Color rgbgrey = new Color(199,188,161);    
      buttonLogo.setIcon(logo);
      buttonLogo.setBounds(670, 25, 45, 45);
      buttonLogo.setBorderPainted(false);
      buttonLogo.setOpaque(true);
      buttonLogo.setBackground(rgbgrey);
      buttonLogo.setVisible(true);
    }
    
}