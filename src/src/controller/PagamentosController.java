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
import view.AreaPagamentoGUI;
import view.TelaPrincipalView;
import view.viewAdds.PagamentosField;

public class PagamentosController {

    private AreaPagamentoGUI areaPagamentoGUI;
    private PagamentosField pagamentosField;
    private Conta conta;
    private TelaPrincipalView ePrincipalView;


    public PagamentosController(){
        this.pagamentosField = new PagamentosField();
        this.areaPagamentoGUI =  new AreaPagamentoGUI(pagamentosField);

        initController();
        getAreaPagamentoGUI().setVisible(true);
    }

    public void initController(){
        pagamentosField.getOk().addActionListener(e-> {enviarPix();
        getePrincipalView().updateInfoPessoais();}
        );
    }


    public void enviarPix(){
        
        ContaDAO numConta = new ContaDAO();
        TransacaoDAO dao = new TransacaoDAO();

        conta.setIdTransacao(geraId());
        conta.setSenhaConta(confirmSenhaConta());
        conta.setTipoTransacao("Pagamentos");
        conta.setDataTransacao(Date.valueOf(LocalDate.now()));
        conta.setValorTransacao(pagamentosField.getValorField().getText());
        String chavePix = pagamentosField.getDestinField().getText();
        conta.setNumeroContaDestino(numConta.searchByChavePix(chavePix));


        try{
            dao.criar(conta);
            mostrarComprovante(conta.getIdTransacao());
        } catch (Exception ex){
            Logger.getLogger(PagamentosController.class.getName()).log(Level.SEVERE, null, ex); 
        }


    }

    public void mostrarComprovante(int id){
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Conta transacao = transacaoDAO.getTransacaoById(id);
        PessoaFisica pessoaFisica = new PessoaFisicaDAO().ler(transacao.getCliente().getId());
        
        String text = "Comprovante de Transferência" + "\n" + "ID da transação:" + transacao.getIdTransacao() +
                     "\nValor:" + transacao.getValorTransacao() + "\nTipo de transferencia:"  + "Pagamento" +
                            "\nDestino" + transacao.getNumeroContaDestino() + "\nNome: " + 
                            pessoaFisica.getNome() + "\nCPF: " + pessoaFisica.getDocIdentificacao() 
                            + "\nTipo de Conta:" + "Conta-corrente" + "\nOrigem" + transacao.getNumeroConta() +
                            "\n Nome :" + pessoaFisica.getDocIdentificacao() + "\nInstituição:" +
                            "\nScapeBank S.A. - Instituição de Pagamento:" + "\nCNPJ 24.888.069/0001-24";

        JOptionPane.showMessageDialog(areaPagamentoGUI.getComprovante(), text);

        areaPagamentoGUI.getComprovante().setVisible(true);
        areaPagamentoGUI.repaint();
    }


    public AreaPagamentoGUI getAreaPagamentoGUI() {
        return areaPagamentoGUI;
    }
    public void setAreaPagamentoGUI(AreaPagamentoGUI areaPagamentoGUI) {
        this.areaPagamentoGUI = areaPagamentoGUI;
    }
    public PagamentosField getPagamentosField() {
        return pagamentosField;
    }
    public void setPagamentosField(PagamentosField pagamentosField) {
        this.pagamentosField = pagamentosField;
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

    public String confirmSenhaConta(){
        ContaDAO contaDAO = new ContaDAO();
        String password;
        Conta conta = contaDAO.searchById(getConta().getId());
        do {
            password = JOptionPane.showInputDialog(areaPagamentoGUI, "Digite a senha da conta:",
                     "Acesso seguro", JOptionPane.QUESTION_MESSAGE);
            if (password.equals(conta.getSenhaConta())){
                System.out.println("Senha conferida!");
            } else {
                System.out.println("Senha errada! Tente novamente!");
            }
        }while(!password.equals(conta.getSenhaConta()));
        return password;
    }

    public TelaPrincipalView getePrincipalView() {
        return ePrincipalView;
    }

    public void setePrincipalView(TelaPrincipalView ePrincipalView) {
        this.ePrincipalView = ePrincipalView;
    }

    
}
