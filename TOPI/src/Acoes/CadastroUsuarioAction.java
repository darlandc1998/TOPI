package Acoes;

import Modelos.Usuario;
import Telas.Cadastros.CadastroUsuarioInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Usuario cliente = clienteFrame.getObject();
        
        if (cliente == null){
            return;
        }
        
        switch (action) {
            case COD_SALVAR_CLIENTE:
                System.out.println("Cliente = " + cliente.toString());
                clienteFrame.resetFields();
                JOptionPane.showMessageDialog(null,"Informações inseridas com sucesso!");
                break;
        }

    }

}
