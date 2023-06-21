package view.viewAdds;

import javax.swing.*;

import AccessScreen.Custom.ColorFontPaletas;
import MainScreen.Components.Custom.ColorPaleta;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EmprestimoField extends JPanel {

    JLabel valorOfertado, limiteDisponivel, valorSaque, espacoVazio;
    JTextField vSaqueField;

    JButton cancelar, aceitar;
    private JComboBox<String> vOferta;

    public EmprestimoField(){
        setLayout(new GridLayout(4, 2, 10, 5));
        setBackground(ColorPaleta.rgbGrey());

        String[] ofertas = {"1 x 900", "2 x 450", "3 x 300", "4 x 275"};

        this.valorSaque = new JLabel("Valor desejado:");
        valorSaque.setFont(ColorFontPaletas.font6());
        this.valorOfertado = new JLabel("Valor ofertado:");
        valorOfertado.setFont(ColorFontPaletas.font6());
        this.limiteDisponivel = new JLabel();
        limiteDisponivel.setFont(ColorFontPaletas.font6());
        this.vOferta = new JComboBox<String>(ofertas);
        vOferta.getSelectedIndex();
		vOferta.setForeground(new Color(0, 0, 0));
		vOferta.setBackground(new Color(124,150,171));
        vOferta.setFont(ColorFontPaletas.font6());
        this.espacoVazio = new JLabel();
        this.vSaqueField = new JTextField("Digite o valor desejado");
        vSaqueField.setFont(ColorFontPaletas.font6());

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
        cancelar.setBackground(ColorPaleta.buttonsColor());
        this.aceitar = new JButton("Aceitar");
        aceitar.setBackground(ColorPaleta.buttonsColor());

        add(valorOfertado);
        add(limiteDisponivel);
        add(valorSaque);
        add(vSaqueField);
        add(espacoVazio);
        add(vOferta);
        add(cancelar);
        add(aceitar);

        setVisible(true);

    }

}
