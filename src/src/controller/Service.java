package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Service {
    
    public static class createFocusListenerTextField implements FocusListener {
        private  JTextField textField;
        private  String hint;

        public createFocusListenerTextField(JTextField textField) {
            this.textField = textField;
            this.hint = textField.getText();
        }

        public JTextField getTextField() {
            return textField;
        }

        public String getHint() {
            return hint;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getTextField().getText().equals(getHint())) {
                getTextField().setText("");
                getTextField().setBackground(Color.white);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getTextField().getText().isEmpty()) {
                getTextField().setText(getHint());
                getTextField().setBackground(Color.red);
            }
        }
    }

    public static class createFocusListenerFormatField implements FocusListener {
        private final JFormattedTextField fTextField;
        private final String hint;

        public createFocusListenerFormatField(JFormattedTextField fTextField) {
            this.fTextField = fTextField;
            this.hint = fTextField.getText();

            fTextField.addFocusListener(this);
        }

        public JFormattedTextField getfTextField() {
            return fTextField;
        }

        public String getHint() {
            return hint;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getfTextField().getText().equals(getHint())) {
                getfTextField().setText(getHint());
                getfTextField().setBackground(Color.white);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getfTextField().getText().equals(getHint())) {
                getfTextField().setText(getHint());
                getfTextField().setBackground(Color.red);
            }
        }

    }
        public static JFormattedTextField createFormattedTextField(String mask, char placeholder) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter(placeholder);
            return new JFormattedTextField(formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }
    
}
