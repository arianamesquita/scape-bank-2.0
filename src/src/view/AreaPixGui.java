package view;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import view.CustomComponents.Jbutton;
import view.viewAdds.PixField;

public class AreaPixGui extends JPanel{

    Jbutton gerenciarChavesPix, celular, cpf, chaveAleatoria, deletarChavePix;
    JLabel chavePixAtual, chavePixLabel;
    PixField pixField;
    PaintMenu paintMenu;
    ComprovanteGUI comprovante;

    public AreaPixGui(PixField pixField) {

        this.pixField = pixField;
        this.comprovante = new ComprovanteGUI();

        setBounds(400, 160, 700, 570);
        setLayout(null);
        pixField.setBounds(60, 80, 600, 120);
        
        this.gerenciarChavesPix = new Jbutton("Gerenciar Chaves Pix");
        gerenciarChavesPix.setBackground(ColorPaleta.buttonsColor());
        gerenciarChavesPix.setBounds(60, 15, 600, 45);
        gerenciarChavesPix.setVisible(true);
        gerenciarChavesPix.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed (java.awt.event.ActionEvent evt){
                gerenciarChavesPixActionPerformed(evt);
            }
        });
        this.celular = new Jbutton("Adicionar telefone");
        celular.setBackground(ColorPaleta.buttonsColor());
        celular.setBounds(60, 75, 300, 45);
        celular.setVisible(false);
        this.cpf = new Jbutton("Adicionar CPF");
        cpf.setBackground(ColorPaleta.buttonsColor());
        cpf.setBounds(375, 75, 285, 45);
        cpf.setVisible(false);
        this.chaveAleatoria = new Jbutton("Adicionar Chave Aleatória");
        chaveAleatoria.setBackground(ColorPaleta.buttonsColor());
        chaveAleatoria.setBounds(60, 135, 300, 45);
        chaveAleatoria.setVisible(false);
        this.deletarChavePix = new Jbutton("Deletar chave pix");
        deletarChavePix.setBackground(ColorPaleta.buttonsColor());
        deletarChavePix.setBounds(375, 135, 285, 45);
        deletarChavePix.setVisible(false);
        this.chavePixAtual = new JLabel("Chave pix atual: ");
        chavePixAtual.setBackground(ColorPaleta.buttonsColor());
        chavePixAtual.setBounds(60, 200, 285, 45);
        chavePixAtual.setVisible(false);
        this.chavePixLabel = new JLabel();
        chavePixLabel.setBackground(ColorPaleta.buttonsColor());
        chavePixLabel.setBounds(375, 200, 285, 45);
        chavePixLabel.setVisible(false);

        comprovante.setBounds(180, 90, 600, 600);
        comprovante.setOpaque(false);
        comprovante.setVisible(true);

        
        paintMenu = new PaintMenu();
        paintMenu.setBackground(ColorPaleta.rgbgray2Color());
        paintMenu.setLayout(null);
        paintMenu.setBounds(2, 2, 1500, 550);
        paintMenu.setOpaque(false);
        
        paintMenu.add(gerenciarChavesPix);
        paintMenu.add(deletarChavePix);
        paintMenu.add(celular);
        paintMenu.add(cpf);
        paintMenu.add(chaveAleatoria);
        paintMenu.add(comprovante);
        paintMenu.add(chavePixAtual);
        paintMenu.add(chavePixLabel);
        paintMenu.add(pixField);

        add(paintMenu);

        setOpaque(false);
        setVisible(true);
    }

    


    public PixField getPixField() {
        return pixField;
    }
    public void setPixField(PixField pixField) {
        this.pixField = pixField;
    }
    public PaintMenu getPaintMenu() {
        return paintMenu;
    }
    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }
    public ComprovanteGUI getComprovante() {
        return comprovante;
    }
    public void setComprovante(ComprovanteGUI comprovante) {
        this.comprovante = comprovante;
    }
    public Jbutton getGerenciarChavesPix() {
        return gerenciarChavesPix;
    }
    public void setGerenciarChavesPix(Jbutton gerenciarChavesPix) {
        this.gerenciarChavesPix = gerenciarChavesPix;
    }
    public void gerenciarChavesPixActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_gerenciarChavesPixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gerenciarChavesPixActionPerformed
    public Jbutton getCelular() {
        return celular;
    }
    public void setCelular(Jbutton celular) {
        this.celular = celular;
    }
    public Jbutton getCpf() {
        return cpf;
    }
    public void setCpf(Jbutton cpf) {
        this.cpf = cpf;
    }
    public Jbutton getChaveAleatoria() {
        return chaveAleatoria;
    }
    public void setChaveAleatoria(Jbutton chaveAleatoria) {
        this.chaveAleatoria = chaveAleatoria;
    }
    public Jbutton getDeletarChavePix() {
        return deletarChavePix;
    }
    public void setDeletarChavePix(Jbutton deletarChavePix) {
        this.deletarChavePix = deletarChavePix;
    }
    public JLabel getChavePixAtual() {
        return chavePixAtual;
    }
    public void setChavePixAtual(JLabel chavePixAtual) {
        this.chavePixAtual = chavePixAtual;
    }
    public JLabel getChavePixLabel() {
        return chavePixLabel;
    }
    public void setChavePixLabel(JLabel chavePixLabel) {
        this.chavePixLabel = chavePixLabel;
    }
    

    public class PaintMenu extends JPanel{
    private int rounded = 10;
  
    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), getRounded(), getRounded());
        super.paint(g);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }
    
    }

    
}
