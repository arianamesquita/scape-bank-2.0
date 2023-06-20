package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import testesDaAnna.CartaoCreditoGUI;

public class CartaoCreditoController implements MouseListener {

    private CartaoCreditoGUI cartaoCreditoGUI;

    public CartaoCreditoController() {
        this.cartaoCreditoGUI = new CartaoCreditoGUI();
        setInfoCard();

    }
    public void setInfoCard(){
               
        getCartaoCreditoGUI().getNumeroCartaoLabel().setText("1234     1234     1234     1234");
        getCartaoCreditoGUI().getNomeCartaoLabel().setText("pedro H.J.F");
        getCartaoCreditoGUI().getValidadeCartaoLabel().setText("02/30");
        getCartaoCreditoGUI().getNumeroContaLabel().setText("12345678-9");
        getCartaoCreditoGUI().getCodigoSegurancaLabel().setText("142");
        getCartaoCreditoGUI().getNomeCartaoLabel().setBounds(90 - getCartaoCreditoGUI().getNomeCartaoLabel().getText().length() * 4, 161, 128, 30);

        addMouseListener();
    }

    private void addMouseListener() {
        getCartaoCreditoGUI().getFrentPanel().addMouseListener(this);
        getCartaoCreditoGUI().getVersoPanel().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == getCartaoCreditoGUI().getFrentPanel()) {
            getCartaoCreditoGUI().getFrentPanel().setVisible(false);
            getCartaoCreditoGUI().getVersoPanel().setVisible(true);
            getCartaoCreditoGUI().repaint();

        } else if (e.getSource() == getCartaoCreditoGUI().getVersoPanel()) {
            getCartaoCreditoGUI().getFrentPanel().setVisible(true);
            getCartaoCreditoGUI().getVersoPanel().setVisible(false);
            getCartaoCreditoGUI().repaint();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public CartaoCreditoGUI getCartaoCreditoGUI() {
        return cartaoCreditoGUI;
    }

    public void setCartaoCreditoGUI(CartaoCreditoGUI cartaoCreditoGUI) {
        this.cartaoCreditoGUI = cartaoCreditoGUI;
    }

}
