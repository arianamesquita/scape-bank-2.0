package DataBase.PagamentosDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DataBase.Conexao;
import DataBase.Factory;
import model.Conta;
import model.Emprestimo;
import model.Pagamentos;

public class PagamentosDAO {

    Conexao conexao;
    PreparedStatement pstm;
    ResultSet rset = null;

    public void criarPix(Conta conta) {

        String sql = "insert into transacoes(id, tipoTransacao, dataTransacao, valorTransacao, chavePix,"+
                        "idOrigem) values (?,?,?,?,?,?)";

        try{
            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            pstm.setInt(1, conta.getIdTransacao());
            pstm.setString(2, conta.getTipoTransacao());
            pstm.setDate(3, conta.getDataTransacao());
            pstm.setString(4, conta.getValorTransacao());
            pstm.setString(5, conta.getPagamentos().getChavePix());
            pstm.setInt(6, conta.getId());

            pstm.execute();

            conexao.Desconecta();

            if(pstm.getUpdateCount()>0){
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else 
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!");
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public List<Conta> getPagamentos(){

        String sql = "Select * from transacoes where tipoTransacao = pix ";

        List<Conta> pagamentos = new ArrayList<Conta>();

        try{

            Conta conta = new Conta();
            Pagamentos pagamento = new Pagamentos();

            conexao = Factory.creatConnectionToMySQL();
            conexao.Conecta();
            pstm = conexao.getConnection().prepareStatement(sql);

            while(rset.next()){

                conta.setIdTransacao(rset.getInt("id"));
                conta.setTipoTransacao(rset.getString("tipoTransacao"));
                conta.setDataTransacao(rset.getDate("dataTransacao"));
                conta.setValorTransacao(rset.getString("valorTransacao"));
                pagamento.setChavePix(rset.getString("chavePix"));
                conta.setPagamentos(pagamento);
                conta.setId(rset.getInt("idOrigem"));

                pagamentos.add(conta);
            }
            conexao.Desconecta();            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return pagamentos;
    }
    
}
