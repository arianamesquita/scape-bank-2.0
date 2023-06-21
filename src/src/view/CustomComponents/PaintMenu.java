package view.CustomComponents;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import testesDaAnna.PagamentosField;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel paintMenu = new JPanel();
        frame.setLayout(null);
        //paintMenu.setBackground(Color.red);
        //paintMenu.setLayout(new BorderLayout());
        PagamentosField pagamentosField = new PagamentosField();
        pagamentosField.setSize(200, 200);
        paintMenu.setBounds(100, 100, 800, 800);
        paintMenu.setOpaque(false);
        PaintMenu painel = new PaintMenu();
        painel.setLayout(new BorderLayout());
        painel.setBounds(500, 200, 300, 300);
        painel.setSize(400, 400);
    
        painel.add(paintMenu, BorderLayout.CENTER);
        frame.add(painel);
        paintMenu.add(pagamentosField, BorderLayout.WEST);
        frame.setVisible(true);
    }
}

