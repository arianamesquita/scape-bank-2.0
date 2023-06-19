package controller;

import controller.Service.createFocusListenerFormatField;
import controller.Service.createFocusListenerTextField;
import view.EnderecoGUI;

public class EnderecoController {
    private EnderecoGUI egGui;
    private String endereco ;
   

    public EnderecoController() {
        this.egGui = new EnderecoGUI();
    }

    private void addFocusListeners() {
        getEgGui().getRuaTextField()
                .addFocusListener(new createFocusListenerTextField(getEgGui().getRuaTextField()));
        getEgGui().getNumeroTextField()
                .addFocusListener(new createFocusListenerFormatField(getEgGui().getNumeroTextField()));
        getEgGui().getBairroTextField()
                .addFocusListener(new createFocusListenerTextField(getEgGui().getBairroTextField()));
        getEgGui().getComplementoTextField()
                .addFocusListener(new createFocusListenerTextField(getEgGui().getComplementoTextField()));
        getEgGui().getEstadoTextField()
                .addFocusListener(new createFocusListenerTextField(getEgGui().getEstadoTextField()));
        getEgGui().getCidadeTextField()
                .addFocusListener(new createFocusListenerTextField(getEgGui().getCidadeTextField()));
        getEgGui().getCepTextField()
                .addFocusListener(new createFocusListenerFormatField(getEgGui().getCepTextField()));

    }

    public String getEndereco() {
        StringBuilder current = new StringBuilder();
        String concat = "- -";

        current
                .append(getEgGui().getRuaTextField().getText()).append(concat)
                .append(getEgGui().getNumeroTextField().getText()).append(concat)
                .append(getEgGui().getBairroTextField().getText()).append(concat)
                .append(getEgGui().getComplementoTextField().getText()).append(concat)
                .append(getEgGui().getEstadoTextField().getText()).append(concat)
                .append(getEgGui().getCidadeTextField().getText()).append(concat)
                .append(getEgGui().getCepTextField().getText());

        this.endereco = String.valueOf(current);
        return endereco;
    }

    public void setEndereco(String endereco) {
        String[] current = endereco.split("- -");
        getEgGui().getRuaTextField().setText(current[0]);
        getEgGui().getNumeroTextField().setText(current[1]);
        getEgGui().getBairroTextField().setText(current[2]);
        getEgGui().getComplementoTextField().setText(current[3]);
        getEgGui().getEstadoTextField().setText(current[4]);
        getEgGui().getCidadeTextField().setText(current[5]);
        getEgGui().getCepTextField().setText(current[6]);
        addFocusListeners();
        getEgGui().repaint();
        this.endereco = endereco;
    }


    public EnderecoGUI getEgGui() {
        return egGui;
    }

    public void setEgGui(EnderecoGUI egGui) {
        this.egGui = egGui;
    }


}
