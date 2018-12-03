package Acoes.Cadastro;

import Dao.UsuarioDao;
import Modelos.Usuario;
import Telas.Cadastros.CadastroUsuarioInternalFrame;
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

public class CadastroUsuarioAction implements ActionListener {

    public static final String COD_SALVAR_CLIENTE = "SC";

    private CadastroUsuarioInternalFrame clienteFrame;

    public CadastroUsuarioAction(CadastroUsuarioInternalFrame clienteFrame) {
        this.clienteFrame = clienteFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        Usuario usuario = clienteFrame.getObject();

        if (usuario == null) {
            return;
        }

        Connection conexao = UtilConnection.getConnection();
        try {
            UsuarioDao usuarioDao = new UsuarioDao(conexao);            
            switch (action) {
                case COD_SALVAR_CLIENTE:
                    usuario.setCodigo(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)));
                    usuarioDao.update(usuario);
                    JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");
                    UtilLog.escreverLog("salvou usuário");
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
