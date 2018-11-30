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

        jLblLogin = new javax.swing.JLabel();
        jTxtLogin = new javax.swing.JTextField();
        jLblSenha = new javax.swing.JLabel();
        jTxtSenha = new javax.swing.JPasswordField();
        jLblConfirmarSenha = new javax.swing.JLabel();
        jTxtConfirmarSenha = new javax.swing.JPasswordField();
        jBtnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar conta");
        setResizable(false);

        jLblLogin.setText("Login");

        jLblSenha.setText("Senha");

        jLblConfirmarSenha.setText("Confirmar senha");

        jBtnCadastrar.setBackground(java.awt.Color.lightGray);
        jBtnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_black_18dp.png"))); // NOI18N
        jBtnCadastrar.setText("Cadastrar");
        jBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnCadastrar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblSenha)
                            .addComponent(jLblConfirmarSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblLogin)
                    .addComponent(jTxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblSenha)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblConfirmarSenha)
                    .addComponent(jTxtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCadastrar)
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
    private javax.swing.JLabel jLblLogin;
    private javax.swing.JLabel jLblSenha;
    private javax.swing.JPasswordField jTxtConfirmarSenha;
    private javax.swing.JTextField jTxtLogin;
    private javax.swing.JPasswordField jTxtSenha;
    // End of variables declaration//GEN-END:variables
}
