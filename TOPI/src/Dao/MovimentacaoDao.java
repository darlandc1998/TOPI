
package Dao;

import Enums.EnumRepetirMovimentacao;
import Modelos.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MovimentacaoDao {
        
    private final Connection conexao;

    public MovimentacaoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void insert(Movimentacao movimentacao) throws SQLException {
        try (PreparedStatement ps = conexao.prepareStatement("insert into movimentacao (descricao, situacao, data, valor, repetir,codigo_tipo_movimentacao, codigo_usuario) values (?,?,?,?,?,?,?)")) {
            ps.setString(1, movimentacao.getDescricao());
            ps.setString(2, movimentacao.getSituacao());
            ps.setTimestamp(3, new java.sql.Timestamp(movimentacao.getData().getTime()));
            ps.setDouble(4, movimentacao.getValor());
            ps.setString(5, movimentacao.getRepetir().getKey());
            ps.setInt(6, movimentacao.getCdTipoMovimentacao());
            ps.setInt(7, movimentacao.getCdUsuario());
            ps.executeUpdate();
        }
    }
    
    public void update(Movimentacao movimentacao) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("update movimentacao set descricao = ?, situacao = ?, data = ?, valor = ?, repetir = ?,codigo_tipo_movimentacao = ?, codigo_usuario = ? where codigo = ?")) {
            ps.setString(1, movimentacao.getDescricao());
            ps.setString(2, movimentacao.getSituacao());
            ps.setTimestamp(3, new java.sql.Timestamp(movimentacao.getData().getTime()));
            ps.setDouble(4, movimentacao.getValor());
            ps.setString(5, movimentacao.getRepetir().getKey());
            ps.setInt(6, movimentacao.getCdTipoMovimentacao());
            ps.setInt(7, movimentacao.getCdUsuario());
            ps.setInt(8, movimentacao.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public void delete(Movimentacao movimentacao) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("delete from movimentacao where codigo = ?")) {
            ps.setInt(1, movimentacao.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public List<Movimentacao> getList() throws SQLException{
        List<Movimentacao> movimentacoes = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select * from movimentacao");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setCodigo(rs.getInt("codigo"));
                movimentacao.setCdUsuario(rs.getInt("codigo_usuario"));
                movimentacao.setCdTipoMovimentacao(rs.getInt("codigo_tipo_movimentacao"));
                movimentacao.setData(rs.getTimestamp("data"));
                movimentacao.setDescricao(rs.getString("descricao"));
                movimentacao.setRepetir(EnumRepetirMovimentacao.ANUALMENTE);
                movimentacao.setSituacao(rs.getString("situacao"));
                movimentacao.setValor(rs.getDouble("valor"));
                movimentacoes.add(movimentacao);
            }
        } finally {
            ps.close();           
        }        
        return movimentacoes;
    }
    
    public Movimentacao getObject(Movimentacao movimentacao) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select * from movimentacao where codigo = ?");
        ps.setInt(1, movimentacao.getCodigo());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()){
                Movimentacao movimentacaoQuery = new Movimentacao();
                movimentacaoQuery.setCodigo(rs.getInt("codigo"));
                movimentacaoQuery.setCdUsuario(rs.getInt("codigo_usuario"));
                movimentacaoQuery.setCdTipoMovimentacao(rs.getInt("codigo_tipo_movimentacao"));
                movimentacaoQuery.setData(rs.getTimestamp("data"));
                movimentacaoQuery.setDescricao(rs.getString("descricao"));
                movimentacaoQuery.setRepetir(EnumRepetirMovimentacao.ANUALMENTE);
                movimentacaoQuery.setSituacao(rs.getString("situacao"));
                movimentacaoQuery.setValor(rs.getDouble("valor"));
                return movimentacaoQuery;
            }
        } finally {
            ps.close();           
        }        
        return null;
    }
    
}
