package controller;
import java.sql.*;
import javax.swing.JOptionPane;

import DataBase.ClienteDAO.PessoaFisicaDAO;
import DataBase.ContaDAO.TransacaoDAO;
import model.Conta;
import model.PessoaFisica;

public class VerificadorNotificacoes implements Runnable {

    private boolean parar;
    private Connection connection;
    private int idOrigem;

    public VerificadorNotificacoes(int idOrigem) {
        this.idOrigem = idOrigem;
        parar = false;
        // Configurar a conexão com o banco de dados
        String url = "jdbc:mysql://containers-us-west-181.railway.app:7682/railway";
        String username = "root";
        String password = "RzbUN31XmK9QvBX2JbWC";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!parar) {
                // Consultar notificações com valor falso (FALSE) para o idOrigem específico
                 
                String query = "SELECT * FROM transacoes WHERE idOrigem = ? AND notify = FALSE";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, idOrigem);
                    ResultSet resultSet = statement.executeQuery();

                    // Verificar se há notificações pendentes
                    if (resultSet.next()) {
                        System.out.println("procurando...");
                        // Obter os dados da notificação
                        int id = resultSet.getInt("id");
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Conta transacao = transacaoDAO.getTransacaoById(id);
        PessoaFisica pessoaFisica = new PessoaFisicaDAO().ler(transacao.getCliente().getId());
        
        String text = "Comprovante de Transferência" + "\n" + "ID da transação:" + transacao.getIdTransacao() +
                     "\nValor:" + transacao.getValorTransacao() + "\nTipo de transferencia:"  + "Pix" +
                            "\nDestino" + transacao.getNumeroContaDestino() + "\nNome: " + 
                            pessoaFisica.getNome() + "\nCPF: " + pessoaFisica.getDocIdentificacao() 
                            + "\nTipo de Conta:" + "Conta-corrente" + "\nOrigem" + transacao.getNumeroConta() +
                            "\n Nome :" + pessoaFisica.getDocIdentificacao() + "\nInstituição:" +
                            "\nScapeBank S.A. - Instituição de Pagamento:" + "\nCNPJ 24.888.069/0001-24";

         int resposta = JOptionPane.showConfirmDialog(null, "Você recebeu uma transferência. Deseja abrir?", "Pergunta", JOptionPane.YES_NO_OPTION);

        // Verificar a resposta do usuário
        if (resposta == JOptionPane.YES_OPTION) {
            // O usuário clicou em "Sim"
           
            JOptionPane.showMessageDialog(null, text);
        } else {
            // O usuário clicou em "Não" ou fechou a caixa de diálogo
            // Nada acontece neste caso
        }
                        // Exibir a notificação em um JOptionPane
                
                        // Atualizar o valor da coluna "notify" para verdadeiro (TRUE)
                        String updateQuery = "UPDATE transacoes SET notify = TRUE WHERE id = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                            updateStatement.setInt(1, id);
                            updateStatement.executeUpdate();
                        }
                    }
                }

                // Aguardar um intervalo de tempo antes de verificar novamente
                Thread.sleep(1000); // 1 segundo
            }

            // Fechar a conexão com o banco de dados
            connection.close();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void pararVerificacao() {
        parar = true;
    }


}
