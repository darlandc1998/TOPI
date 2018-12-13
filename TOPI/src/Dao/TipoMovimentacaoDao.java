
package Dao;

import Modelos.TipoMovimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoMovimentacaoDao {
    
    private final Connection conexao;

    public TipoMovimentacaoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void insert(TipoMovimentacao tipoMovimentacao) throws SQLException {
        try (PreparedStatement ps = conexao.prepareStatement("insert into tipo_movimentacao (descricao, observacao, codigo_usuario) values (?,?,?)")) {
            ps.setString(1, tipoMovimentacao.getDescricao());
            ps.setString(2, tipoMovimentacao.getObservacao());
            ps.setInt(3, tipoMovimentacao.getCdUsuario());
            ps.executeUpdate();
        }
    }
    
    public void update(TipoMovimentacao tipoMovimentacao) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("update tipo_movimentacao set descricao = ?, observacao = ?, codigo_usuario = ? where codigo = ?")) {
            ps.setString(1, tipoMovimentacao.getDescricao());
            ps.setString(2, tipoMovimentacao.getObservacao());
            ps.setInt(3, tipoMovimentacao.getCdUsuario());
            ps.setInt(4, tipoMovimentacao.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public void delete(TipoMovimentacao tipoMovimentacao) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("delete from tipo_movimentacao where codigo = ?")) {
            ps.setInt(1, tipoMovimentacao.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public List<TipoMovimentacao> getList() throws SQLException{
        return getList(null, null);
    }
    
    public List<TipoMovimentacao> getList(String pWhere, String pOrderBy) throws SQLException{
        String where = pWhere != null ? " where " + pWhere : "";
        String orderBy = pOrderBy != null ? " order by "+pOrderBy : "";
        
        List<TipoMovimentacao> tipoMovimentacoes = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select * from tipo_movimentacao "+where + orderBy);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                tipoMovimentacoes.add(new TipoMovimentacao(rs.getInt("codigo"),rs.getString("descricao"),rs.getString("observacao"), rs.getInt("codigo_usuario")));
            }
        } finally {
            ps.close();           
        }        
        return tipoMovimentacoes;
    }
    
    public TipoMovimentacao getObject(TipoMovimentacao tipoMovimentacao) throws SQLException{
        
        if (tipoMovimentacao.getCodigo() == null){
            return null;
        }
        
        PreparedStatement ps = conexao.prepareStatement("select * from tipo_movimentacao where codigo = ?");
        ps.setInt(1, tipoMovimentacao.getCodigo());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()){
                return new TipoMovimentacao(rs.getInt("codigo"),rs.getString("descricao"),rs.getString("observacao"), rs.getInt("codigo_usuario"));
            }
        } finally {
            ps.close();           
        }        
        return null;
    }
    
    
}
