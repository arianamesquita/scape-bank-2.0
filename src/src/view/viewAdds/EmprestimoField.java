package view.viewAdds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EmprestimoField extends JPanel {

    JLabel valorOfertado, valorSaque, vOferta;
    JTextField vSaqueField;

    JButton cancelar, aceitar;

    public EmprestimoField(){
        setLayout(new GridLayout(3,3));

        this.valorSaque = new JLabel("Valor desejado:");
        this.valorOfertado = new JLabel("Valor ofertado:");
        this.vOferta = new JLabel();
        this.vSaqueField = new JTextField("Digite o valor desejado");

        valorSaque.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorSaque.getText().equals("Digite o valor da transferência")) {
                    valorSaque.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorSaque.getText().isEmpty()) {
                    valorSaque.setText("Digite o valor da transferência");
                }
            }
        });

        this.cancelar = new JButton("Cancelar");
        this.aceitar = new JButton("Aceitar");

        add(valorOfertado);
        add(valorSaque);
        add(vOferta);
        add(vSaqueField);
        add(cancelar);
        add(aceitar);

        setVisible(true);

    }

}
