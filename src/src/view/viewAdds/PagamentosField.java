package view.viewAdds;

import javax.swing.*;

import AccessScreen.Custom.ColorFontPaletas;
import MainScreen.Components.Custom.ColorPaleta;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PagamentosField extends JPanel {

    JLabel valorTransferencia, destinatario;
    JTextField valorField, destinField;

    JButton cancelar, ok;

    public PagamentosField() {
        setLayout(new GridLayout(3, 2, 10, 5));
        setBackground(ColorPaleta.rgbGrey());
        

        this.valorTransferencia = new JLabel("Valor:");
        valorTransferencia.setFont(ColorFontPaletas.font6());
        this.destinatario = new JLabel("Chave pix:");
        destinatario.setFont(ColorFontPaletas.font6());
        this.valorField = new JTextField("Digite o valor da transferência");
        valorField.setFont(ColorFontPaletas.font6());
        this.destinField = new JTextField("Digite a chave pix");
        destinField.setFont(ColorFontPaletas.font6());

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
                if (destinField.getText().equals("Digite a chave pix")) {
                    destinField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (destinField.getText().isEmpty()) {
                    destinField.setText("Digite o número do pix");
                }
            }
        });

        this.cancelar = new JButton("Cancelar");
        cancelar.setBackground(ColorPaleta.buttonsColor());
        this.ok = new JButton("Ok");
        ok.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed (java.awt.event.ActionEvent evt){
                okActionPerformed(evt);
            }
        });
        ok.setBackground(ColorPaleta.buttonsColor());



        add(valorTransferencia);
        add(valorField);
        add(destinatario);
        add(destinField);
        add(cancelar);
        add(ok);

        setVisible(true);
    }
    

    public JLabel getValorTransferencia() {
        return valorTransferencia;
    }
    public void setValorTransferencia(JLabel valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
    public JLabel getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(JLabel destinatario) {
        this.destinatario = destinatario;
    }
    public JTextField getValorField() {
        return valorField;
    }
    public void setValorField(JTextField valorField) {
        this.valorField = valorField;
    }
    public JTextField getDestinField() {
        return destinField;
    }
    public void setDestinField(JTextField destinField) {
        this.destinField = destinField;
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
