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

    private CadastroMovimentacaoInternalFrame movimentacaoInternalFrame;

    public CadastroMovimentacaoAction(CadastroMovimentacaoInternalFrame movimentacaoInternalFrame) {
        this.movimentacaoInternalFrame = movimentacaoInternalFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Movimentacao movimentacao = movimentacaoInternalFrame.getObject();

        if (movimentacao == null) {
            return;
        }

        Connection conexao = UtilConnection.getConnection();
        try {
            MovimentacaoDao movimentacaoDao = new MovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            switch (action) {
                case COD_SALVAR_MOVIMENTACAO:
                    movimentacao.setCdUsuario(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)));
                    movimentacaoDao.insert(movimentacao);
                    movimentacaoInternalFrame.resetFiels();
                    JOptionPane.showMessageDialog(null, "Movimentação inserida com sucesso!");
                    UtilLog.escreverLog("salvou movimentação");
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
