package MainScreen.Components.MenuSuperiorComponent;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import MainScreen.Components.Custom.ImageCustom.ImageIcons;
import view.CustomComponents.JtextField;

public class MenuSuperior extends JPanel {

    private final int x, y, width, height;
    private JtextField searchField;
    private JButton[] button;

    public MenuSuperior(int x, int y, int width, int height, JtextField z, JButton[] button) {
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
       this.searchField = z;
       this.button = button;

       setBounds(getX(),getY(),getWidth(),getHeight());
       setLayout(null);
       ButtonSearch(getSearchField());
       ButtonLogo(getButton()[0]);
       SearchIcon(getButton()[1]);
       ExitSystem(getButton()[2]);
       NotificationIcon(getButton()[3]);
       MenuIcon(getButton()[4]);
       addButton();
       add(getSearchField());
       addPaintMenu();
       setVisible(true);
    }
   void addButton() {
      for (JButton button : getButton()) {
         add(button);
      }
   }
   
   
   /** 
    * @return JButton[]
    */
   public JButton[] getButton() {
      return button;
   }
   public void setButton(JButton[] button) {
      this.button = button;
   }

   public JtextField getSearchField() {
      return searchField;
   }
   public void setSearchField(JtextField searchField) {
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
           g.setColor(ColorPaleta.rgbgray2Color());
           g.fillRect(0, 0, getWidth(), getHeight());
           g.dispose();
       }
    }

    public void ButtonLogo(JButton buttonLogo){
        buttonLogo.setIcon(ImageIcons.ImagemLogo());
        buttonLogo.setBounds(10, 0, 60, 80);
        buttonLogo.setBorderPainted(false);
        buttonLogo.setOpaque(true);
        buttonLogo.setBackground(ColorPaleta.rgbgray2Color());
        buttonLogo.setVisible(true);       
    }
    public void ButtonSearch(JtextField text){
      text.setBounds(120, 18, 600, 45);
      text.setBackground(ColorPaleta.White());
      text.setForeground(ColorPaleta.darkgrayColor());
      text.setFont(new Font("Arial", Font.BOLD, 16));
      text.setText("Pesquisar..");
      text.setVisible(true);
    }
    public void SearchIcon (JButton buttonLogo){
      buttonLogo.setIcon(ImageIcons.ImagemPesquisar());
      buttonLogo.setBounds(730, 18, 45, 45);
      buttonLogo.setBorderPainted(false);
      buttonLogo.setOpaque(true);
      buttonLogo.setBackground(ColorPaleta.rgbgray2Color());
      buttonLogo.setVisible(true);
    }
    public void ExitSystem (JButton buttonExit){
      buttonExit.setIcon(ImageIcons.ImagemSair());
      buttonExit.setBounds(1220, 15, 50, 50);
      buttonExit.setBorderPainted(false);
      buttonExit.setOpaque(true);
      buttonExit.setBackground(ColorPaleta.rgbgray2Color());
      buttonExit.setVisible(true);
    }
    public void NotificationIcon(JButton notiButton){
      notiButton.setIcon(ImageIcons.ImagemNotificaoTrue());
      notiButton.setBounds(1165, 15, 50, 50);
      notiButton.setBorderPainted(false);
      notiButton.setOpaque(true);
      notiButton.setBackground(ColorPaleta.rgbgray2Color());
      notiButton.setVisible(true);
    }
    public void MenuIcon(JButton menuButton){
      menuButton.setIcon(ImageIcons.ImagemMenu_Icone());
      menuButton.setBounds(1105, 15, 50, 50);
      menuButton.setBorderPainted(false);
      menuButton.setOpaque(true);
      menuButton.setBackground(ColorPaleta.rgbgray2Color());
      menuButton.setVisible(true);
    }
    
}
