package view.viewAdds;

import javax.swing.*;

import AccessScreen.Custom.ColorFontPaletas;
import MainScreen.Components.Custom.ColorPaleta;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PixField extends JPanel {

    JLabel pixJLabel, valor;
    JTextField chavePix, valorPix;
    JButton cancelar, ok;

    public PixField() {
        setLayout(new GridLayout(3, 2, 10, 5));
        setBackground(ColorPaleta.rgbGrey());

        this.pixJLabel = new JLabel("Chave pix:");
        pixJLabel.setFont(ColorFontPaletas.font6());
        this.valor = new JLabel("Valor:");
        valor.setFont(ColorFontPaletas.font6());
        this.chavePix = new JTextField("Digite a chave Pix do destinatário", 40);
        chavePix.setFont(ColorFontPaletas.font6());
        this.valorPix = new JTextField("Digite o valor da transferencia");
        valorPix.setFont(ColorFontPaletas.font6());
        chavePix.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (chavePix.getText().equals("digitea o chave Pix do destinatário:")) {
                    chavePix.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (chavePix.getText().isEmpty()) {
                    chavePix.setText("digitea o chave Pix do destinatário:");
                }

            }
        });
        valorPix.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorPix.getText().equals("digite o valor da transferencia:")) {
                    valorPix.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorPix.getText().isEmpty()) {
                    valorPix.setText("digite o valor da transferencia:");
                }
            }
        });
        this.cancelar = new JButton("Cancelar");
        cancelar.setBackground(ColorPaleta.buttonsColor());
        this.ok = new JButton("Ok");
        ok.setBackground(ColorPaleta.buttonsColor());
        ok.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed (java.awt.event.ActionEvent evt){
                okActionPerformed(evt);
            }
        });

        add(pixJLabel);
        add(chavePix);
        add(valor);
        add(valorPix);
        add(cancelar);
        add(ok);

        setVisible(true);

    }

    public JLabel getpixJLabel() {
        return pixJLabel;
    }
    public void setpixJLabel(JLabel pixJLabel) {
        this.pixJLabel = pixJLabel;
    }
    public JLabel getValor() {
        return valor;
    }
    public void setValor(JLabel valor) {
        this.valor = valor;
    }
    public JTextField getchavePix() {
        return chavePix;
    }
    public void setchavePix(JTextField chavePix) {
        this.chavePix = chavePix;
    }
    public JTextField getValorPix() {
        return valorPix;
    }
    public void setValorPix(JTextField valorPix) {
        this.valorPix = valorPix;
    }
    public JButton getCancelar() {
        return cancelar;
    }
    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }
    public JButton getOk() {
        return ok;
    }
    public void setOk(JButton ok) {
        this.ok = ok;
    }
    public void okActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okActionPerformed
    

}
