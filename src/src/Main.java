import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Main {
    static MenuPrincipais menuOpPrincipais = new MenuPrincipais();
    static Cards cards = new Cards();
    static JFrame frame;
    public static void main(String[] args)
    {


        frame = new JFrame();
        frame.setTitle("Scape Bank");
        frame.setLayout(null);
        frame.setSize(frame.getMaximumSize());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        Component component = new MenuPrincipais();
        frame.add(component);
        frame.add(cards);

        frame.setVisible(true);

    }
    public static void Atualizar(){
        frame.setSize(0,300);
        frame.setSize(frame.getMaximumSize());
    }



}