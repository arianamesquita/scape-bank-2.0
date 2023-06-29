package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainScreen.Components.Custom.ColorPaleta;
import controller.Service;
import view.CustomComponents.Jbutton;
import view.CustomComponents.PaintMenu;

public class MenuOpcoes extends JPanel {

    private PaintMenu paintMenu;
    private PaintMenu infoPessoal;
    private JLabel foto, saldo, nome, conta, agencia;

    private Jbutton menuprincipal, extrato, pix, pagamento, emprestimo, cartao;
    private Icon logo;

    public MenuOpcoes() {


        setBackground(ColorPaleta.rgbgray2Color());
        this.paintMenu = new PaintMenu();
        paintMenu.setBackground(getBackground());
        paintMenu.setLayout(new GridBagLayout());
        paintMenu.setOpaque(false);
        paintMenu.setRounded(20);

        this.logo = Service.getImage("https://i.imgur.com/cfN3kuW.png");

        this.foto = new JLabel();
        foto.setIcon(logo);
        foto.setOpaque(false);
  
        saldo = new JLabel("saldo: R$ 00,00");
        nome = new JLabel("nome: pedrofeereira");
        conta = new JLabel("conta: 95222-22");
        agencia = new JLabel("agencia:000");

        infoPessoal = new PaintMenu();
        infoPessoal.setBackground(Color.white);
        infoPessoal.setLayout(new GridBagLayout());
        infoPessoal.setOpaque(false);
        infoPessoal.setRounded(20);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(saldo, gbc);
   
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(conta, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(agencia,gbc);


        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 1.5;

    
        gbc1.anchor = GridBagConstraints.NORTHWEST;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        infoPessoal.add(foto, gbc1);


        gbc1.anchor= GridBagConstraints.EAST;
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        infoPessoal.add(panel, gbc1);

        menuprincipal = new Jbutton("Menu Principal->");
        menuprincipal.setColors(ColorPaleta.buttonsColor());
        extrato = new Jbutton("Exrato->");
        extrato.setColors(ColorPaleta.buttonsColor());
        pix = new Jbutton("Pix->");
        pix.setColors(ColorPaleta.buttonsColor());
        pagamento = new Jbutton("Pagamentos->");
        pagamento.setColors(ColorPaleta.buttonsColor());
        emprestimo = new Jbutton("Emprestimo->");
        emprestimo.setColors(ColorPaleta.buttonsColor());
        cartao = new Jbutton("Cartão->");
        cartao.setColors(ColorPaleta.buttonsColor());

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 10, 5, 5);
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.anchor = GridBagConstraints.NORTH;
        JPanel souPanel = new JPanel(new GridBagLayout());
        souPanel.setOpaque(false);
        gbc2.weightx=1.5;
        gbc2.weighty=1.5;
        gbc2.ipady = 20;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        souPanel.add(menuprincipal, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        souPanel.add(extrato, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        souPanel.add(pix, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        souPanel.add(pagamento, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        souPanel.add(emprestimo, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 5;
        souPanel.add(cartao, gbc2);
        
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(5, 10, 5, 5);
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.anchor = GridBagConstraints.NORTH;
        gbc3.weightx = 1.5;
        gbc3.weighty=1.0;
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        paintMenu.add(infoPessoal,gbc3);
        gbc3.anchor = GridBagConstraints.SOUTH;
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        paintMenu.add(souPanel,gbc3);
     

        setLayout(new BorderLayout());

        add(paintMenu, BorderLayout.CENTER);
        setOpaque(false);
        setVisible(true);

    }

    public PaintMenu getPaintMenu() {
        return paintMenu;
    }

    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }

    public PaintMenu getInfoPessoal() {
        return infoPessoal;
    }

    public void setInfoPessoal(PaintMenu infoPessoal) {
        this.infoPessoal = infoPessoal;
    }

    public JLabel getFoto() {
        return foto;
    }

    public void setFoto(JLabel foto) {
        this.foto = foto;
    }

    public JLabel getSaldo() {
        return saldo;
    }

    public void setSaldo(JLabel saldo) {
        this.saldo = saldo;
    }

    public JLabel getNome() {
        return nome;
    }

    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getConta() {
        return conta;
    }

    public void setConta(JLabel conta) {
        this.conta = conta;
    }

    public JLabel getAgencia() {
        return agencia;
    }

    public void setAgencia(JLabel agencia) {
        this.agencia = agencia;
    }

    public Jbutton getMenuprincipal() {
        return menuprincipal;
    }

    public void setMenuprincipal(Jbutton menuprincipal) {
        this.menuprincipal = menuprincipal;
    }

    public Jbutton getExtrato() {
        return extrato;
    }

    public void setExtrato(Jbutton extrato) {
        this.extrato = extrato;
    }

    public Jbutton getPix() {
        return pix;
    }

    public void setPix(Jbutton pix) {
        this.pix = pix;
    }

    public Jbutton getPagamento() {
        return pagamento;
    }

    public void setPagamento(Jbutton pagamento) {
        this.pagamento = pagamento;
    }

    public Jbutton getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Jbutton emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Jbutton getCartao() {
        return cartao;
    }

    public void setCartao(Jbutton cartao) {
        this.cartao = cartao;
    }

    public Icon getLogo() {
        return logo;
    }

    public void setLogo(Icon logo) {
        this.logo = logo;
    }

}
