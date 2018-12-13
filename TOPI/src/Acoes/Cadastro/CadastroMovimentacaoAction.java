package Acoes.Cadastro;

import Dao.MovimentacaoDao;
import Dao.UsuarioDao;
import Modelos.Movimentacao;
import Telas.Cadastros.CadastroMovimentacaoInternalFrame;
import Utils.UtilConnection;
import Utils.UtilFile;
import Utils.UtilLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroMovimentacaoAction implements ActionListener {

    public static final String COD_SALVAR_MOVIMENTACAO = "SM";
    public static final String COD_BUSCAR_MOVIMENTACAO = "BM";

    private CadastroMovimentacaoInternalFrame movimentacaoInternalFrame;

    public CadastroMovimentacaoAction(CadastroMovimentacaoInternalFrame movimentacaoInternalFrame) {
        this.movimentacaoInternalFrame = movimentacaoInternalFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        Connection conexao = UtilConnection.getConnection();
        try {
            MovimentacaoDao movimentacaoDao = new MovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            switch (action) {
                case COD_SALVAR_MOVIMENTACAO:
                    Movimentacao movimentacao = movimentacaoInternalFrame.getObject();

                    if (movimentacao == null) {
                        return;
                    }

                    movimentacao.setCdUsuario(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)));
                    
                    if (movimentacaoDao.getObject(movimentacao) == null){
                        movimentacaoDao.insert(movimentacao);
                        JOptionPane.showMessageDialog(null, "Movimentação inserida com sucesso!");
                    } else {
                        movimentacaoDao.update(movimentacao);
                        JOptionPane.showMessageDialog(null, "Movimentação atualizada com sucesso!");
                    }
                    
                    movimentacaoInternalFrame.resetFiels();
                    movimentacaoInternalFrame.enableTxtCodigo();
                    
                    UtilLog.escreverLog("salvou movimentação");
                    break;
                case COD_BUSCAR_MOVIMENTACAO:
                    Integer codigoMov = movimentacaoInternalFrame.getCodigoEdicao();
                    
                    if (codigoMov == null){
                        return;
                    }
                    
                    Movimentacao movimentacaoEdit = movimentacaoDao.getObject(new Movimentacao(codigoMov));
                    
                    if(movimentacaoEdit != null){
                        movimentacaoInternalFrame.popularObjeto(movimentacaoEdit);
                        movimentacaoInternalFrame.disableTxtCodigo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Movimentação não encontrada!");
                    }
                    
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMovimentacaoAction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroMovimentacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
