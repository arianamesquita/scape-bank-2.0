package testesDaAnna;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartaoCreditoGUI extends JPanel   {
    
    ImageIcon cartaofrente = getImage("https://i.imgur.com/J1ZqKc8.png");
    ImageIcon cartaoverso = getImage("https://i.imgur.com/fdoxCYl.png");
    Color cor1 = Color.BLACK;
    Color cor2 = Color.pink;
    Color cor3 = Color.darkGray;
    JLabel cartaofrenteLabel,cartaoVersoLabel,numeroCartaoLabel, nomeCartaoLabel,validadeCartaoLabel,scapeCardLabel,numeroContaLabel,codigoSegurancaLabel;
    
    public CartaoCreditoGUI(){
        setLayout(null);
        cartaofrenteLabel = new JLabel();
        cartaofrenteLabel.setBounds(0, 0, 350, 226);
        cartaofrenteLabel.setBackground(cor1);
        cartaofrenteLabel.setOpaque(false);
        cartaofrenteLabel.setIcon(cartaofrente);
        cartaofrenteLabel.setVisible(true);
        cartaofrenteLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(cartaofrenteLabel);
                remove(cartaofrenteLabel);
                remove(numeroCartaoLabel);
                remove(nomeCartaoLabel);
                remove(validadeCartaoLabel);
                scapeCardLabel.setBounds(100,50,140,30);
                numeroContaLabel.setVisible(true);
                add(numeroContaLabel);
                add(codigoSegurancaLabel);
                add(cartaoVersoLabel);

                atualizar();
                atualizar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        cartaoVersoLabel = new JLabel();
        cartaoVersoLabel.setIcon(cartaoverso);
        cartaoVersoLabel.setBounds(0, 0, 350, 226);
        cartaoVersoLabel.setBackground(cor1);
        cartaoVersoLabel.setVisible(true);
        cartaoVersoLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(cartaoVersoLabel);
                remove(numeroContaLabel);
                remove(codigoSegurancaLabel);
                scapeCardLabel.setBounds(10, 10, 140, 30);

                add(scapeCardLabel);
                add(validadeCartaoLabel);
                add(numeroCartaoLabel);
                add(nomeCartaoLabel);
                add(cartaofrenteLabel);


                atualizar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        numeroCartaoLabel = new JLabel("1234     1234     1234     1234");
        numeroCartaoLabel.setBounds(42, 130, 270, 30);
        numeroCartaoLabel.setForeground(cor2);
        numeroCartaoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numeroCartaoLabel.setVisible(true);

        nomeCartaoLabel = new JLabel("PEDRO");
        int a = nomeCartaoLabel.getText().length()*4;
        nomeCartaoLabel.setBounds(90-a, 163, 130, 30);
        nomeCartaoLabel.setForeground(cor2);
        nomeCartaoLabel.setFont(new Font("Arial", Font.BOLD, 19));
        nomeCartaoLabel.setVisible(true);

        validadeCartaoLabel = new JLabel("27/02");
        validadeCartaoLabel.setBounds(188, 163, 140, 30);
        validadeCartaoLabel.setForeground(cor2);
        validadeCartaoLabel.setFont(new Font("Arial", Font.BOLD, 19));
        validadeCartaoLabel.setVisible(true);

        scapeCardLabel = new JLabel("Scape Card");
        scapeCardLabel.setBounds(10, 10, 140, 30);
        scapeCardLabel.setForeground(cor2);
        scapeCardLabel.setFont(new Font("Arial", Font.BOLD, 21));
        scapeCardLabel.setVisible(true);

        numeroContaLabel = new JLabel("546465-5");
        numeroContaLabel.setBounds(110, 115, 200, 30);
        numeroContaLabel.setForeground(cor2);
        numeroContaLabel.setFont(new Font("Arial", Font.BOLD, 19));
        numeroContaLabel.setVisible(true);

        codigoSegurancaLabel = new JLabel("123");
        codigoSegurancaLabel.setBounds(290, 115, 200, 30);
        codigoSegurancaLabel.setForeground(cor2);
        codigoSegurancaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        codigoSegurancaLabel.setVisible(true);

       

        add(scapeCardLabel);
        add(validadeCartaoLabel);
        add(numeroCartaoLabel);
        add(nomeCartaoLabel);
        add(cartaofrenteLabel);
        setOpaque(false);
        setVisible(true);

    }


    public void atualizar(){
        setSize(801,600);
        setSize(800,600);
        setVisible(true);
 
    }

    public ImageIcon getImage(String imageURL){
        URL url;
        try {
            url = new URL(imageURL);
            return new ImageIcon(url);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }
  
}
