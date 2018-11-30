package Acoes.Cadastro;

import Dao.UsuarioDao;
import Modelos.Usuario;
import Telas.LoginFrame;
import Telas.PrincipalFrame;
import Utils.UtilConnection;
import Utils.UtilFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginAction implements ActionListener {

    public static final String CD_LOGAR = "LO";

    private LoginFrame loginFrame;

    public LoginAction(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Usuario usuario = loginFrame.getObject();

        if (usuario == null || !action.equals(CD_LOGAR)) {
            return;
        }

        try (Connection conexao = UtilConnection.getConnection()) {
            UsuarioDao usuarioDao = new UsuarioDao(conexao);

            if (usuarioDao.existsUserLogin(usuario)) {
                UtilFile.gravarArquivo(UtilFile.USER, usuario.getLogin());
                loginFrame.dispose();
                new PrincipalFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
