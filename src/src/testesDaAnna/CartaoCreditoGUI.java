package testesDaAnna;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Service;

public class CartaoCreditoGUI extends JPanel   {
    
    private ImageIcon cartaofrente = Service.getImage("https://i.imgur.com/J1ZqKc8.png");
    private ImageIcon cartaoverso = Service.getImage("https://i.imgur.com/fdoxCYl.png");
    private Color cor1 = Color.BLACK;
    private Color cor2 = Color.pink;
    private Color cor3 = Color.darkGray;
    private JLabel cartaofrenteLabel,cartaoVersoLabel,numeroCartaoLabel, nomeCartaoLabel,validadeCartaoLabel,scapeCardLabel,numeroContaLabel,codigoSegurancaLabel;
    
    public CartaoCreditoGUI(){
        setLayout(null);
        cartaofrenteLabel = new JLabel();
        cartaofrenteLabel.setBounds(0, 0, 350, 226);
        cartaofrenteLabel.setBackground(cor1);
        cartaofrenteLabel.setOpaque(false);
        cartaofrenteLabel.setIcon(cartaofrente);
        cartaofrenteLabel.setVisible(true);
        
        cartaoVersoLabel = new JLabel();
        cartaoVersoLabel.setIcon(cartaoverso);
        cartaoVersoLabel.setBounds(0, 0, 350, 226);
        cartaoVersoLabel.setBackground(cor1);
        cartaoVersoLabel.setVisible(true);
        
        numeroCartaoLabel = new JLabel();
        numeroCartaoLabel.setBounds(42, 130, 270, 30);
        numeroCartaoLabel.setForeground(cor2);
        numeroCartaoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numeroCartaoLabel.setVisible(true);

        nomeCartaoLabel = new JLabel();
        int a = nomeCartaoLabel.getText().length()*4;
        nomeCartaoLabel.setBounds(90-a, 163, 130, 30);
        nomeCartaoLabel.setForeground(cor2);
        nomeCartaoLabel.setFont(new Font("Arial", Font.BOLD, 19));
        nomeCartaoLabel.setVisible(true);

        validadeCartaoLabel = new JLabel();
        validadeCartaoLabel.setBounds(188, 163, 140, 30);
        validadeCartaoLabel.setForeground(cor2);
        validadeCartaoLabel.setFont(new Font("Arial", Font.BOLD, 19));
        validadeCartaoLabel.setVisible(true);

        scapeCardLabel = new JLabel();
        scapeCardLabel.setBounds(10, 10, 140, 30);
        scapeCardLabel.setForeground(cor2);
        scapeCardLabel.setFont(new Font("Arial", Font.BOLD, 21));
        scapeCardLabel.setVisible(true);

        numeroContaLabel = new JLabel();
        numeroContaLabel.setBounds(110, 115, 200, 30);
        numeroContaLabel.setForeground(cor2);
        numeroContaLabel.setFont(new Font("Arial", Font.BOLD, 19));
        numeroContaLabel.setVisible(true);

        codigoSegurancaLabel = new JLabel();
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


    public ImageIcon getCartaofrente() {
        return cartaofrente;
    }


    public void setCartaofrente(ImageIcon cartaofrente) {
        this.cartaofrente = cartaofrente;
    }


    public ImageIcon getCartaoverso() {
        return cartaoverso;
    }


    public void setCartaoverso(ImageIcon cartaoverso) {
        this.cartaoverso = cartaoverso;
    }


    public Color getCor1() {
        return cor1;
    }


    public void setCor1(Color cor1) {
        this.cor1 = cor1;
    }


    public Color getCor2() {
        return cor2;
    }


    public void setCor2(Color cor2) {
        this.cor2 = cor2;
    }


    public Color getCor3() {
        return cor3;
    }


    public void setCor3(Color cor3) {
        this.cor3 = cor3;
    }


    public JLabel getCartaofrenteLabel() {
        return cartaofrenteLabel;
    }


    public void setCartaofrenteLabel(JLabel cartaofrenteLabel) {
        this.cartaofrenteLabel = cartaofrenteLabel;
    }


    public JLabel getCartaoVersoLabel() {
        return cartaoVersoLabel;
    }


    public void setCartaoVersoLabel(JLabel cartaoVersoLabel) {
        this.cartaoVersoLabel = cartaoVersoLabel;
    }


    public JLabel getNumeroCartaoLabel() {
        return numeroCartaoLabel;
    }


    public void setNumeroCartaoLabel(JLabel numeroCartaoLabel) {
        this.numeroCartaoLabel = numeroCartaoLabel;
    }


    public JLabel getNomeCartaoLabel() {
        return nomeCartaoLabel;
    }


    public void setNomeCartaoLabel(JLabel nomeCartaoLabel) {
        this.nomeCartaoLabel = nomeCartaoLabel;
    }


    public JLabel getValidadeCartaoLabel() {
        return validadeCartaoLabel;
    }


    public void setValidadeCartaoLabel(JLabel validadeCartaoLabel) {
        this.validadeCartaoLabel = validadeCartaoLabel;
    }


    public JLabel getScapeCardLabel() {
        return scapeCardLabel;
    }


    public void setScapeCardLabel(JLabel scapeCardLabel) {
        this.scapeCardLabel = scapeCardLabel;
    }


    public JLabel getNumeroContaLabel() {
        return numeroContaLabel;
    }


    public void setNumeroContaLabel(JLabel numeroContaLabel) {
        this.numeroContaLabel = numeroContaLabel;
    }


    public JLabel getCodigoSegurancaLabel() {
        return codigoSegurancaLabel;
    }


    public void setCodigoSegurancaLabel(JLabel codigoSegurancaLabel) {
        this.codigoSegurancaLabel = codigoSegurancaLabel;
    }


  
}
