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

    private CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame;

    public CadastroTipoMovimentacaoAction(CadastroTipoMovimentacaoInternalFrame tipoMovimentacaoInternalFrame) {
        this.tipoMovimentacaoInternalFrame = tipoMovimentacaoInternalFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoInternalFrame.getObject();

        if (tipoMovimentacao == null) {
            return;
        }

        Connection conexao = UtilConnection.getConnection();
        try {
            TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            switch (action) {
                case COD_SALVAR_TIPO_MOVIMENTACAO:
                    tipoMovimentacao.setCdUsuario(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)));
                    tipoMovimentacaoDao.insert(tipoMovimentacao);
                    tipoMovimentacaoInternalFrame.resetFields();
                    JOptionPane.showMessageDialog(null, "Tipo de movimentação inserida com sucesso!");
                    UtilLog.escreverLog("salvou tipo de movimentação");
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
