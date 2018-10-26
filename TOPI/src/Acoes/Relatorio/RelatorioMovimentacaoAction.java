package Acoes.Relatorio;

import Telas.Relatorios.RelatorioMovimentacaoInternalFrame;
import Utils.UtilLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioMovimentacaoAction implements ActionListener {
    
    public static final String COD_EXCLUIR_MOVIMENTACAO = "EM";

    private RelatorioMovimentacaoInternalFrame relatorioMovimentacao;

    public RelatorioMovimentacaoAction(RelatorioMovimentacaoInternalFrame relatorioMovimentacao) {
        this.relatorioMovimentacao = relatorioMovimentacao;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        
        switch (action) {
            case COD_EXCLUIR_MOVIMENTACAO:
                UtilLog.escreverLog("excluiu movimentação");
                break;
        }
        
    }
    
}
