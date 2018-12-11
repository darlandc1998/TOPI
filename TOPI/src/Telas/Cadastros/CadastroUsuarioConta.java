package Telas.Cadastros;

import Acoes.Cadastro.CadastroLoginAction;
import Modelos.Usuario;
import Utils.UtilLog;
import javax.swing.JOptionPane;


public class CadastroUsuarioConta extends javax.swing.JFrame {

   
    public CadastroUsuarioConta() {
        initComponents();
        UtilLog.escreverLog("entrou na tela de cadastro da conta do usuario");
        
        CadastroLoginAction loginAction = new CadastroLoginAction(this);
        jBtnCadastrar.addActionListener(loginAction);
        jBtnCadastrar.setActionCommand(CadastroLoginAction.COD_CADASTRAR_USUARIO);
    }
    
    public Usuario getObject(){
        
        if (jTxtLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Login obrigatório!");
            return null;
        }
        
        if (jTxtSenha.getText().isEmpty() || jTxtConfirmarSenha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Senhas obrigatórias!");
            return null;
        }
        
        if (!jTxtSenha.getText().equals(jTxtConfirmarSenha.getText())){
            JOptionPane.showMessageDialog(null, "Senhas não conferem!");
            return null;
        }        
        
        Usuario usuario = new Usuario();
        usuario.setLogin(jTxtLogin.getText());
        usuario.setSenha(jTxtSenha.getText());
        return usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroLogin = new javax.swing.JPanel();
        jBtnCadastrar = new javax.swing.JButton();
        jLblLogin = new javax.swing.JLabel();
        jTxtLogin = new javax.swing.JTextField();
        jLblSenha = new javax.swing.JLabel();
        jTxtSenha = new javax.swing.JPasswordField();
        jLblConfirmarSenha = new javax.swing.JLabel();
        jTxtConfirmarSenha = new javax.swing.JPasswordField();
        jLblLoginObrigatorio = new javax.swing.JLabel();
        jLblSenhaObrigatoria = new javax.swing.JLabel();
        jLblConfirmarSenhaObrigatoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar conta");
        setResizable(false);

        jPanelCadastroLogin.setBackground(new java.awt.Color(245, 245, 245));

        jBtnCadastrar.setBackground(new java.awt.Color(0, 153, 102));
        jBtnCadastrar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jBtnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_white_18dp.png"))); // NOI18N
        jBtnCadastrar.setText("Cadastrar");
        jBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarActionPerformed(evt);
            }
        });

        jLblLogin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblLogin.setText("Login");

        jLblSenha.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblSenha.setText("Senha");

        jLblConfirmarSenha.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblConfirmarSenha.setText("Confirmar senha");

        jLblLoginObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblLoginObrigatorio.setText("*");

        jLblSenhaObrigatoria.setForeground(new java.awt.Color(255, 0, 0));
        jLblSenhaObrigatoria.setText("*");

        jLblConfirmarSenhaObrigatoria.setForeground(new java.awt.Color(255, 0, 0));
        jLblConfirmarSenhaObrigatoria.setText("*");

        javax.swing.GroupLayout jPanelCadastroLoginLayout = new javax.swing.GroupLayout(jPanelCadastroLogin);
        jPanelCadastroLogin.setLayout(jPanelCadastroLoginLayout);
        jPanelCadastroLoginLayout.setHorizontalGroup(
            jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLoginLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(jPanelCadastroLoginLayout.createSequentialGroup()
                        .addComponent(jLblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblSenhaObrigatoria))
                    .addGroup(jPanelCadastroLoginLayout.createSequentialGroup()
                        .addComponent(jLblConfirmarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblConfirmarSenhaObrigatoria))
                    .addGroup(jPanelCadastroLoginLayout.createSequentialGroup()
                        .addComponent(jLblLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblLoginObrigatorio))
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jTxtLogin)
                    .addComponent(jTxtConfirmarSenha))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanelCadastroLoginLayout.setVerticalGroup(
            jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblLogin)
                    .addComponent(jLblLoginObrigatorio))
                .addGap(2, 2, 2)
                .addComponent(jTxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblSenha)
                    .addComponent(jLblSenhaObrigatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblConfirmarSenha)
                    .addComponent(jLblConfirmarSenhaObrigatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCadastroLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarActionPerformed
        
    }//GEN-LAST:event_jBtnCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JLabel jLblConfirmarSenha;
    private javax.swing.JLabel jLblConfirmarSenhaObrigatoria;
    private javax.swing.JLabel jLblLogin;
    private javax.swing.JLabel jLblLoginObrigatorio;
    private javax.swing.JLabel jLblSenha;
    private javax.swing.JLabel jLblSenhaObrigatoria;
    private javax.swing.JPanel jPanelCadastroLogin;
    private javax.swing.JPasswordField jTxtConfirmarSenha;
    private javax.swing.JTextField jTxtLogin;
    private javax.swing.JPasswordField jTxtSenha;
    // End of variables declaration//GEN-END:variables
}
