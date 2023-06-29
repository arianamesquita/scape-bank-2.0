package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaFisicaDAO;
import DataBase.ContaDAO.ContaDAO;
import DataBase.ContaDAO.TransacaoDAO;
import model.Conta;
import model.PessoaFisica;
import view.AreaPixGui;
import view.viewAdds.PixField;

public class PixController {

    private AreaPixGui areaPixGui;
    private PixField pixField;
    private Conta conta;

    public PixController() {
        this.pixField = new PixField();
        this.areaPixGui = new AreaPixGui(pixField);

        initController();
        getAreaPixGui().setVisible(true);
    }

    public void initController() {
        pixField.getOk().addActionListener(e -> enviarPix());

    }

    public void enviarPix() {

        ContaDAO numConta = new ContaDAO();
        TransacaoDAO dao = new TransacaoDAO();

        conta.setIdTransacao(geraId());
        conta.setSenhaConta(confirmSenhaConta());
        conta.setTipoTransacao("Pix");
        conta.setDataTransacao(Date.valueOf(LocalDate.now()));
        conta.setValorTransacao(pixField.getValorPix().getText());
        String chavePix = pixField.getchavePix().getText();
        conta.setNumeroContaDestino(numConta.searchByChavePix(chavePix));

        try {
            dao.criar(conta);
            mostrarComprovante(conta.getIdTransacao());
        } catch (Exception ex) {
            Logger.getLogger(PixController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarComprovante(int id) {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Conta transacao = transacaoDAO.getTransacaoById(id);
        PessoaFisica pessoaFisica = new PessoaFisicaDAO().ler(transacao.getCliente().getId());

        String text = "Comprovante de Transferência" + "\n" + "ID da transação:" + transacao.getIdTransacao() +
                "\nValor:" + transacao.getValorTransacao() + "\nTipo de transferencia:" + "Pix" +
                "\nDestino" + transacao.getNumeroContaDestino() + "\nNome: " +
                pessoaFisica.getNome() + "\nCPF: " + pessoaFisica.getDocIdentificacao()
                + "\nTipo de Conta:" + "Conta-corrente" + "\nOrigem" + transacao.getNumeroConta() +
                "\n Nome :" + pessoaFisica.getDocIdentificacao() + "\nInstituição:" +
                "\nScapeBank S.A. - Instituição de Pagamento:" + "\nCNPJ 24.888.069/0001-24";

        JOptionPane.showMessageDialog(areaPixGui.getComprovante(), text);

        areaPixGui.getComprovante().setVisible(true);
        areaPixGui.repaint();
    }

    public AreaPixGui getAreaPixGui() {
        return areaPixGui;
    }
    public void setAreaPixGui(AreaPixGui areaPixGui) {
        this.areaPixGui = areaPixGui;
    }
    public PixField getPixField() {
        return pixField;
    }
    public void setPixField (PixField pixField) {
        this.pixField = pixField;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    private int geraId() {
        int count = 0;
        List<Conta> transacoes = new TransacaoDAO().getTransacoes();
        for (Conta conta : transacoes) {
            if (count < conta.getIdTransacao()) {
                count = conta.getIdTransacao();
            }
        }
        return count + 1;
    }

    public String confirmSenhaConta() {
        ContaDAO contaDAO = new ContaDAO();
        String password;
        Conta conta = contaDAO.searchById(getConta().getId());
        do {
            password = JOptionPane.showInputDialog(areaPixGui, "Digite a senha da conta:",
                    "Acesso seguro", JOptionPane.QUESTION_MESSAGE);
            if (password.equals(conta.getSenhaConta())) {
                System.out.println("Senha conferida!");
            } else {
                System.out.println("Senha errada! Tente novamente!");
            }
        } while (!password.equals(conta.getSenhaConta()));
        return password;
    }

}
