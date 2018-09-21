
package Acoes;

import Modelos.TipoMovimentacao;
import Telas.Cadastros.CadastroTipoMovimentacaoInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class CadastroTipoMovimentacaoAction implements ActionListener {
    
     public static final String COD_SALVAR_TIPO_MOVIMENTACAO = "SM";
    
    private CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame;

    public CadastroTipoMovimentacaoAction(CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame) {
        this.tipoMovimentacaoInternalFrame = tipoMovimentacaoInternalFrame;    
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoInternalFrame.getObject();
        
        if (tipoMovimentacao == null){
            return;
        }
        
        switch(action){
            case COD_SALVAR_TIPO_MOVIMENTACAO:
                System.out.println("Tipo Movimentação = "+tipoMovimentacao.toString());
                tipoMovimentacaoInternalFrame.resetFields();
                JOptionPane.showMessageDialog(null,"Tipo de movimentação inserida com sucesso!");
                break;
        }
    
    }
    
}
