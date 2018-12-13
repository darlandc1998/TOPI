package Acoes.Cadastro;

import Dao.TipoMovimentacaoDao;
import Dao.UsuarioDao;
import Modelos.TipoMovimentacao;
import Telas.Cadastros.CadastroTipoMovimentacaoInternalFrame;
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

public class CadastroTipoMovimentacaoAction implements ActionListener {

    public static final String COD_SALVAR_TIPO_MOVIMENTACAO = "SM";
    public static final String COD_BUSCAR_TIPO_MOVIMENTACAO = "BM";

    private CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame;

    public CadastroTipoMovimentacaoAction(CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame) {
        this.tipoMovimentacaoInternalFrame = tipoMovimentacaoInternalFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Connection conexao = UtilConnection.getConnection();
        try {
            TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            switch (action) {
                case COD_SALVAR_TIPO_MOVIMENTACAO:
                    tipoMovimentacaoInternalFrame.enabledTxtCodigo();
                    TipoMovimentacao tipoMovimentacao = tipoMovimentacaoInternalFrame.getObject();

                    if (tipoMovimentacao == null) {
                        return;
                    }

                    tipoMovimentacao.setCdUsuario(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)));
                    
                    if (tipoMovimentacaoDao.getObject(tipoMovimentacao) == null){                        
                        tipoMovimentacaoDao.insert(tipoMovimentacao);
                        JOptionPane.showMessageDialog(null, "Tipo de movimentação inserida com sucesso!");
                    } else {
                        tipoMovimentacaoDao.update(tipoMovimentacao);
                        JOptionPane.showMessageDialog(null, "Tipo de movimentação atualizada com sucesso!");
                    }
                    
                    tipoMovimentacaoInternalFrame.resetFields();                    
                    UtilLog.escreverLog("salvou tipo de movimentação");
                    break;
                case COD_BUSCAR_TIPO_MOVIMENTACAO:
                    Integer codigo = tipoMovimentacaoInternalFrame.getCodigoEdicao();
                    
                    if (codigo == null){
                        return;
                    }
                    
                    TipoMovimentacao tipoMovimentacaoEdit = tipoMovimentacaoDao.getObject(new TipoMovimentacao(codigo));
                    if (tipoMovimentacaoEdit != null){
                        tipoMovimentacaoInternalFrame.popularObjeto(tipoMovimentacaoEdit);
                        tipoMovimentacaoInternalFrame.disableTxtCodigo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo de movimentação não encontrada!");
                    }
                    
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroMovimentacaoAction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroTipoMovimentacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
