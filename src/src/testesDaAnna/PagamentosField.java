package testesDaAnna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PagamentosField extends JPanel {

    JLabel valorTransferencia, destinatario;
    JTextField valorField, destinField;

    JButton cancelar, ok;

    public PagamentosField() {
        setLayout(new GridLayout(3, 3));

        this.valorTransferencia = new JLabel("Valor:");
        this.destinatario = new JLabel("N° do cartão:");
        this.valorField = new JTextField("Digite o valor da transferência");
        this.destinField = new JTextField("Digite o número do cartão");

        valorField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorField.getText().equals("Digite o valor da transferência")) {
                    valorField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorField.getText().isEmpty()) {
                    valorField.setText("Digite o valor da transferência");
                }
            }
        });

        destinField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (destinField.getText().equals("Digite o número do cartão")) {
                    destinField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (destinField.getText().isEmpty()) {
                    destinField.setText("Digite o número do cartão");
                }
            }
        });

        this.cancelar = new JButton("Cancelar");
        this.ok = new JButton("Ok");

        add(valorTransferencia);
        add(valorField);
        add(destinatario);
        add(destinField);
        add(cancelar);
        add(ok);

        setVisible(true);
    }
}