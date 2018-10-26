package Acoes.Relatorio;

import Telas.Relatorios.RelatorioTipoMovimentacaoInternalFrame;
import Utils.UtilLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RelatorioTipoMovimentacaoAction implements ActionListener{
    
    public static final String COD_EXCLUIR_TIPO_MOVIMENTACAO = "ETM";
    
    private RelatorioTipoMovimentacaoInternalFrame relatorioTipoMovimentacao;

    public RelatorioTipoMovimentacaoAction(RelatorioTipoMovimentacaoInternalFrame relatorioTipoMovimentacao) {
        this.relatorioTipoMovimentacao = relatorioTipoMovimentacao;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case COD_EXCLUIR_TIPO_MOVIMENTACAO:
                UtilLog.escreverLog("excluiu tipo de movimentação");
                break;
        }
        
    }
    
}
