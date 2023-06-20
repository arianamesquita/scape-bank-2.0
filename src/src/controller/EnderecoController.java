package controller;

import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import view.EnderecoGUI;

public class EnderecoController {
    private EnderecoGUI enderecoGUI;
    private String endereco ;
   

    public EnderecoController() {
        this.enderecoGUI = new EnderecoGUI();
    }

    private void addFocusListeners() {
        getEnderecoGUI().getRuaTextField()
                .addFocusListener(new createFocusListenerTextField(getEnderecoGUI().getRuaTextField()));
        getEnderecoGUI().getNumeroTextField()
                .addFocusListener(new createFocusListenerFormatField(getEnderecoGUI().getNumeroTextField()));
        getEnderecoGUI().getBairroTextField()
                .addFocusListener(new createFocusListenerTextField(getEnderecoGUI().getBairroTextField()));
        getEnderecoGUI().getComplementoTextField()
                .addFocusListener(new createFocusListenerTextField(getEnderecoGUI().getComplementoTextField()));
        getEnderecoGUI().getEstadoTextField()
                .addFocusListener(new createFocusListenerTextField(getEnderecoGUI().getEstadoTextField()));
        getEnderecoGUI().getCidadeTextField()
                .addFocusListener(new createFocusListenerTextField(getEnderecoGUI().getCidadeTextField()));
        getEnderecoGUI().getCepTextField()
                .addFocusListener(new createFocusListenerFormatField(getEnderecoGUI().getCepTextField()));

    }

    public String getEndereco() {
        StringBuilder current = new StringBuilder();
        String concat = "- -";

        current
                .append(getEnderecoGUI().getRuaTextField().getText()).append(concat)
                .append(getEnderecoGUI().getNumeroTextField().getText()).append(concat)
                .append(getEnderecoGUI().getBairroTextField().getText()).append(concat)
                .append(getEnderecoGUI().getComplementoTextField().getText()).append(concat)
                .append(getEnderecoGUI().getEstadoTextField().getText()).append(concat)
                .append(getEnderecoGUI().getCidadeTextField().getText()).append(concat)
                .append(getEnderecoGUI().getCepTextField().getText());

        this.endereco = String.valueOf(current);
        return endereco;
    }

    public void setEndereco(String endereco) {
        String[] current = endereco.split("- -");
        getEnderecoGUI().getRuaTextField().setText(current[0]);
        getEnderecoGUI().getNumeroTextField().setText(current[1]);
        getEnderecoGUI().getBairroTextField().setText(current[2]);
        getEnderecoGUI().getComplementoTextField().setText(current[3]);
        getEnderecoGUI().getEstadoTextField().setText(current[4]);
        getEnderecoGUI().getCidadeTextField().setText(current[5]);
        getEnderecoGUI().getCepTextField().setText(current[6]);
        addFocusListeners();
        getEnderecoGUI().repaint();
        this.endereco = endereco;
    }


    public EnderecoGUI getEnderecoGUI() {
        return enderecoGUI;
    }

    public void setEnderecoGUI(EnderecoGUI enderecoGUI) {
        this.enderecoGUI = enderecoGUI;
    }


}
