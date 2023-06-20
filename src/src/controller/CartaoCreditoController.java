package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import testesDaAnna.CartaoCreditoGUI;

public class CartaoCreditoController implements MouseListener {

    private CartaoCreditoGUI cartaoCreditoGUI;

    public CartaoCreditoController() {
        this.cartaoCreditoGUI = new CartaoCreditoGUI();
        addMouseListener();
        getCartaoCreditoGUI().getNumeroCartaoLabel().setText("1234     1234     1234     1234");
    }

    private void addMouseListener(){
        getCartaoCreditoGUI().getCartaofrenteLabel().addMouseListener(this);
        getCartaoCreditoGUI().getCartaoVersoLabel().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == getCartaoCreditoGUI().getCartaofrenteLabel()) {
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getCartaofrenteLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getCartaofrenteLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getNumeroCartaoLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getNomeCartaoLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getValidadeCartaoLabel());
            getCartaoCreditoGUI().getScapeCardLabel().setBounds(100, 50, 140, 30);
            getCartaoCreditoGUI().getNumeroContaLabel().setVisible(true);
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getNumeroContaLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getCodigoSegurancaLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getCartaoVersoLabel());

            getCartaoCreditoGUI().atualizar();

        } else if (e.getSource() == getCartaoCreditoGUI().getCartaoVersoLabel()) {

            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getCodigoSegurancaLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getCartaoVersoLabel());
            getCartaoCreditoGUI().remove(getCartaoCreditoGUI().getNumeroContaLabel());

            getCartaoCreditoGUI().getScapeCardLabel().setBounds(10, 10, 140, 30);

            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getCartaofrenteLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getCartaofrenteLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getNumeroCartaoLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getNomeCartaoLabel());
            getCartaoCreditoGUI().add(getCartaoCreditoGUI().getValidadeCartaoLabel());
            getCartaoCreditoGUI().atualizar();
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
