package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import AccessScreen.Custom.ColorFontPaletas;
import view.CustomComponents.JFormattedTextFieldCustom;

public class Service {

    public static class createFocusListenerTextField implements FocusListener {
        private JTextField textField;
        private String hint;

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
    public static class createFocusListenerTextField2 implements FocusListener {
        private JTextField textField;
        private String hint;

        public createFocusListenerTextField2(JTextField textField) {
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
                getTextField().setBackground(ColorFontPaletas.lightGray());
                getTextField().setForeground(ColorFontPaletas.darkGray());
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getTextField().getText().isEmpty()) {
                getTextField().setText(getHint());
                getTextField().setBackground(Color.red);
                getTextField().setForeground(Color.black);
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
                getfTextField().setText("");
                getfTextField().setBackground(Color.white);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getfTextField().getText().equals(getHint()) || getfTextField().getText().isEmpty()) {
                getfTextField().setText("getHint()");
                getfTextField().setBackground(Color.red);
            }
        }

    }

    public static class CreateFocusListenerPasswordField implements FocusListener {
        private JPasswordField jPasswordField;
        private String hint;

        public CreateFocusListenerPasswordField(JPasswordField jPasswordField) {
            this.jPasswordField = jPasswordField;
            this.hint = String.valueOf(getJPasswordField().getPassword());
        }

        public JPasswordField getJPasswordField() {
            return jPasswordField;
        }

        public String getHint() {
            return hint;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (String.valueOf(getJPasswordField().getPassword()).equals(getHint())) {
                getJPasswordField().setText("");
                getJPasswordField().setBackground(ColorFontPaletas.lightGray());
                getJPasswordField().setForeground(ColorFontPaletas.darkGray());
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (String.valueOf(getJPasswordField().getPassword()).isEmpty()) {
                getJPasswordField().setText(getHint());
                getJPasswordField().setBackground(Color.RED);
                getJPasswordField().setForeground(Color.black);
            }
        }
    }

    public static JFormattedTextFieldCustom createFormattedTextField(String mask, char placeholder) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter(placeholder);
            return new JFormattedTextFieldCustom(formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return new JFormattedTextFieldCustom();
        }
    }

    public static ImageIcon getImage(String imageURL) {
        URL url;
        try {
            url = new URL(imageURL);
            return new ImageIcon(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
