
package Acoes;

import Modelos.Movimentacao;
import Telas.Cadastros.CadastroMovimentacaoInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


public class CadastroMovimentacaoAction implements ActionListener{
    
   public static final String COD_SALVAR_MOVIMENTACAO = "SM";

    private CadastroMovimentacaoInternalFrame movimentacaoInternalFrame;
    
    public CadastroMovimentacaoAction(CadastroMovimentacaoInternalFrame movimentacaoInternalFrame) {
        this.movimentacaoInternalFrame = movimentacaoInternalFrame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       String action = e.getActionCommand();
        Movimentacao movimentacao = movimentacaoInternalFrame.getObject();
       
        if (movimentacao == null){
            return;
        }
        
        switch(action){
            case COD_SALVAR_MOVIMENTACAO:
                System.out.println("Movimentação = "+movimentacao.toString());
                movimentacaoInternalFrame.resetFiels();
                JOptionPane.showMessageDialog(null,"Movimentação inserida com sucesso!");
                break;
        }
    }
    
}
