package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AccessScreen.Custom.ColorFontPaletas;
import MainScreen.Components.MenuComponent.MenuOpcoes.PaintMenu;

public class ComprovanteGUI extends JPanel{
  
    private JLabel labels, labels2;
    PaintMenu paintMenu;

    JLabel[] labelSet = new JLabel[10];

    int lblX = 0, lblWidth = 300, lblHeight = 120;
    int lblX2 = 300;
	int spaceBetween = 22;


    public ComprovanteGUI() {   }
    public ComprovanteGUI(String numeroConta, String numeroContaDestino, String tipoTransacao,
                         String valorTransacao, int idTransacao){
        

        setLayout(null);

        String[] textos = {"Comprovante de Transferência", "ID da transação:", "Valor:", "Tipo de transferencia:",
                            "Destino", "Nome: ", "CPF: ", "Tipo de Conta:", "Origem", "Nome :", "Instituição:",
                            "ScapeBank S.A. - Instituição de Pagamento:", "CNPJ 24.888.069/0001-24"};

        this.labels = new JLabel();
        for(int i = 0; i < 13; i++){
            labels = new JLabel(textos[i]);
            labels.setFont(ColorFontPaletas.font6());
            labels.setBounds(lblX, spaceBetween * i, lblWidth, lblHeight);
            labels.setVisible(true);
            add(labels);
        }


        String[] preenche = {" ", Integer.toString(idTransacao), valorTransacao, tipoTransacao, " ", 
                            numeroContaDestino, " ", " ", " ", numeroConta};
        this.labels2 = new JLabel();
        for(int i = 0; i < 10; i++){
            labels2 = new JLabel(preenche[i]);
            labels2.setFont(ColorFontPaletas.font6());
            labels2.setBounds(lblX2, spaceBetween * i, lblWidth, lblHeight);
            labels2.setVisible(true);
            add(labels2);
        }

        setVisible(true);

    }
    public JLabel getLabels() {
        return labels;
    }
    public void setLabels(JLabel labels) {
        this.labels = labels;
    }
    public JLabel getLabels2() {
        return labels2;
    }
    public void setLabels2(JLabel labels2) {
        this.labels2 = labels2;
    }

    
    
}
