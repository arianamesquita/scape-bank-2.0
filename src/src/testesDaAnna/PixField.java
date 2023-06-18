package testesDaAnna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PixField extends JPanel {

    JLabel chavePix, valor;
    JTextField nomeField, valorField;
    JButton cancelar, ok;

    public PixField() {
        setLayout(new GridLayout(3, 3));

        this.chavePix = new JLabel("Chave pix:");
        this.valor = new JLabel("Valor:");
        this.nomeField = new JTextField("Digite a chave Pix do destinatário", 40);
        this.valorField = new JTextField("Digite o valor da transferencia");
        nomeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nomeField.getText().equals("digitea o chave Pix do destinatário:")) {
                    nomeField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nomeField.getText().isEmpty()) {
                    nomeField.setText("digitea o chave Pix do destinatário:");
                }

            }
        });
        valorField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorField.getText().equals("digite o valor da transferencia:")) {
                    valorField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorField.getText().isEmpty()) {
                    valorField.setText("digite o valor da transferencia:");
                }
            }
        });
        this.cancelar = new JButton("Cancelar");
        this.ok = new JButton("Ok");
        chavePix.setForeground(Color.pink);

        add(chavePix);
        add(nomeField);
        add(valor);
        add(valorField);
        add(cancelar);
        add(ok);

        setVisible(true);

    }

}
