package Acoes.Relatorio;

import Dao.MovimentacaoDao;
import Dao.TipoMovimentacaoDao;
import Modelos.TipoMovimentacao;
import Telas.Relatorios.RelatorioTipoMovimentacaoInternalFrame;
import Utils.UtilConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RelatorioTipoMovimentacaoAction implements ActionListener {

    public static final String COD_EXCLUIR_TIPO_MOVIMENTACAO = "ETM";

    private final RelatorioTipoMovimentacaoInternalFrame relatorioTipoMovimentacao;

    public RelatorioTipoMovimentacaoAction(RelatorioTipoMovimentacaoInternalFrame relatorioTipoMovimentacao) {
        this.relatorioTipoMovimentacao = relatorioTipoMovimentacao;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case COD_EXCLUIR_TIPO_MOVIMENTACAO:                
                int row = this.relatorioTipoMovimentacao.getSelectedRow();

                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um tipo de movimentação para deletar!");
                    return;
                }

                int opDeletar = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Deletar", JOptionPane.OK_CANCEL_OPTION);

                if (opDeletar == JOptionPane.OK_OPTION) {
                    try (Connection conexao = UtilConnection.getConnection()) {
                        Integer codigoTipoMovimentacao = (Integer) this.relatorioTipoMovimentacao.getTableModel().getValueAt(row, 0);
                        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(conexao);

                        if (movimentacaoDao.getList("codigo_tipo_movimentacao = " + codigoTipoMovimentacao, null).size() > 0) {
                            JOptionPane.showMessageDialog(null, "Não é possível deletar este tipo de movimentação, pois existem movimentações relacionadas!");
                            return;
                        }

                        TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
                        TipoMovimentacao tipoMovimentacao = new TipoMovimentacao(codigoTipoMovimentacao);
                        tipoMovimentacaoDao.delete(tipoMovimentacao);
                        relatorioTipoMovimentacao.getListTipoMovimentacoes().remove(tipoMovimentacao);
                        DefaultTableModel tb = (DefaultTableModel) this.relatorioTipoMovimentacao.getTableModel();
                        tb.removeRow(row);

                    } catch (SQLException e) {
                        Logger.getLogger(RelatorioTipoMovimentacaoAction.class.getName()).log(Level.SEVERE, null, e);
                    }
                }                
                break;
        }

    }

}
