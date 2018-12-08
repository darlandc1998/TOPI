package Acoes.Relatorio;

import Dao.MovimentacaoDao;
import Dao.TipoMovimentacaoDao;
import Modelos.Movimentacao;
import Modelos.TipoMovimentacao;
import Telas.Relatorios.RelatorioMovimentacaoInternalFrame;
import Utils.UtilConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RelatorioMovimentacaoAction implements ActionListener {
    
    public static final String COD_EXCLUIR_MOVIMENTACAO = "EM";

    private final RelatorioMovimentacaoInternalFrame relatorioMovimentacao;

    public RelatorioMovimentacaoAction(RelatorioMovimentacaoInternalFrame relatorioMovimentacao) {
        this.relatorioMovimentacao = relatorioMovimentacao;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        
        switch (action) {
            case COD_EXCLUIR_MOVIMENTACAO:
                
                int row = this.relatorioMovimentacao.getSelectedRow();

                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um tipo de movimentação para deletar!");
                    return;
                }

                int opDeletar = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Deletar", JOptionPane.OK_CANCEL_OPTION);
                
                if (opDeletar == JOptionPane.OK_OPTION) {
                    try (Connection conexao = UtilConnection.getConnection()) {
                        Integer codigoMovimentacao = (Integer) this.relatorioMovimentacao.getTableModel().getValueAt(row, 0);
                        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(conexao);
                        Movimentacao movimentacao = new Movimentacao(codigoMovimentacao);
                        
                        movimentacaoDao.delete(movimentacao);
                        this.relatorioMovimentacao.getListMovimentacoes().remove(movimentacao);
                        DefaultTableModel tb = (DefaultTableModel) this.relatorioMovimentacao.getTableModel();
                        tb.removeRow(row);

                    } catch (SQLException e) {
                        Logger.getLogger(RelatorioMovimentacaoAction.class.getName()).log(Level.SEVERE, null, e);
                    }
                } 
                
                break;
        }
        
    }
    
}
