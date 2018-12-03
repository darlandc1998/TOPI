package Acoes.Cadastro;

import Dao.UsuarioDao;
import Modelos.Usuario;
import Telas.Cadastros.CadastroUsuarioConta;
import Utils.UtilConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroLoginAction implements ActionListener {

    public static final String COD_CADASTRAR_USUARIO = "SU";

    private CadastroUsuarioConta frameCadastroLogin;

    public CadastroLoginAction(CadastroUsuarioConta frameCadastroLogin) {
        this.frameCadastroLogin = frameCadastroLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Usuario usuario = frameCadastroLogin.getObject();

        if (usuario == null || !action.equals(COD_CADASTRAR_USUARIO)) {
            return;
        }

        Connection conexao = UtilConnection.getConnection();
        try {
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            if (!usuarioDao.existsUser(usuario)) {
                usuarioDao.createLogin(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                frameCadastroLogin.dispose();                
            } else {
                JOptionPane.showMessageDialog(null, "Login já cadastrado!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMovimentacaoAction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroLoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
