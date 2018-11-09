package Telas;//GEN-FIRST:event_jMnCadastroTipoMovimentacaoMouseClicked
//GEN-LAST:event_jMnCadastroTipoMovimentacaoMouseClicked
import Telas.Cadastros.CadastroUsuarioInternalFrame;
import Telas.Cadastros.CadastroTipoMovimentacaoInternalFrame;
import Telas.Cadastros.CadastroMovimentacaoInternalFrame;
import Telas.Relatorios.RelatorioMovimentacaoInternalFrame;
import Telas.Relatorios.RelatorioTipoMovimentacaoInternalFrame;
import Utils.UtilLog;

public class PrincipalFrame extends javax.swing.JFrame {

    public PrincipalFrame() {
        initComponents();
        UtilLog.escreverLog("entrou no sistema");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        jMnCadastros = new javax.swing.JMenu();
        jMnCadastroTipoMovimentacao = new javax.swing.JMenuItem();
        jMnMovimentacao = new javax.swing.JMenuItem();
        jMnRelatorio = new javax.swing.JMenu();
        jMnTipoMovimentacao = new javax.swing.JMenuItem();
        jMnRelatorioMovimentacao = new javax.swing.JMenuItem();
        jMnPerfil = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");
        setAlwaysOnTop(true);
        setResizable(false);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jMnCadastros.setText("Cadastro");
        jMnCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnCadastrosMouseClicked(evt);
            }
        });
        jMnCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnCadastrosActionPerformed(evt);
            }
        });

        jMnCadastroTipoMovimentacao.setText("Tipo movimentação");
        jMnCadastroTipoMovimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnCadastroTipoMovimentacaoMouseClicked(evt);
            }
        });
        jMnCadastroTipoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnCadastroTipoMovimentacaoActionPerformed(evt);
            }
        });
        jMnCadastros.add(jMnCadastroTipoMovimentacao);

        jMnMovimentacao.setText("Movimentação");
        jMnMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnMovimentacaoActionPerformed(evt);
            }
        });
        jMnCadastros.add(jMnMovimentacao);

        menu.add(jMnCadastros);

        jMnRelatorio.setText("Relatórios");

        jMnTipoMovimentacao.setText("Tipo Movimentação");
        jMnTipoMovimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnTipoMovimentacaoMouseClicked(evt);
            }
        });
        jMnTipoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnTipoMovimentacaoActionPerformed(evt);
            }
        });
        jMnRelatorio.add(jMnTipoMovimentacao);

        jMnRelatorioMovimentacao.setText("Movimentação");
        jMnRelatorioMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnRelatorioMovimentacaoActionPerformed(evt);
            }
        });
        jMnRelatorio.add(jMnRelatorioMovimentacao);

        menu.add(jMnRelatorio);

        jMnPerfil.setText("Perfil");
        jMnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnPerfilMouseClicked(evt);
            }
        });
        menu.add(jMnPerfil);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jMnCadastrosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jMnCadastrosMouseClicked(java.awt.event.MouseEvent evt) {                                          
       
    }                                         

    private void jMnCadastroTipoMovimentacaoMouseClicked(java.awt.event.MouseEvent evt) {                                                         

    }                                                        

    private void jMnCadastroTipoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        openInternalFrameCadastroTipoMovimentacao();
    }                                                           

    private void jMnMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                
       openInternalFrameCadastroMovimentacao();
    }                                               

    private void jMnRelatorioMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        openInternalFrameRelatorioMovimentacao();
    }                                                        

    private void jMnPerfilMouseClicked(java.awt.event.MouseEvent evt) {                                       
        openInternalFrameCadastroUsuario();
    }                                      

    private void jMnTipoMovimentacaoMouseClicked(java.awt.event.MouseEvent evt) {                                                 
      openInternalFrameRelatorioTipoMovimentacao();
    }                                                

    private void jMnTipoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        openInternalFrameRelatorioTipoMovimentacao();
    }                                                   

    private void openInternalFrameRelatorioTipoMovimentacao(){
        RelatorioTipoMovimentacaoInternalFrame relatorioTipoMovimentacaoInternalFrame = new RelatorioTipoMovimentacaoInternalFrame();
        relatorioTipoMovimentacaoInternalFrame.setVisible(true);
        jDesktopPane.add(relatorioTipoMovimentacaoInternalFrame);
    }
    
    private void openInternalFrameCadastroUsuario() {
        CadastroUsuarioInternalFrame usuarioInternalFrame = new CadastroUsuarioInternalFrame();
        usuarioInternalFrame.setVisible(true);
        jDesktopPane.add(usuarioInternalFrame);
    }

    private void openInternalFrameCadastroTipoMovimentacao() {
        CadastroTipoMovimentacaoInternalFrame tipoMovimentacao = new CadastroTipoMovimentacaoInternalFrame();
        tipoMovimentacao.setVisible(true);
        jDesktopPane.add(tipoMovimentacao);
    }
    
    private void openInternalFrameCadastroMovimentacao(){
        CadastroMovimentacaoInternalFrame movimentacaoInternalFrame = new CadastroMovimentacaoInternalFrame();
        movimentacaoInternalFrame.setVisible(true);
        jDesktopPane.add(movimentacaoInternalFrame);
    }
    
    private void openInternalFrameRelatorioMovimentacao(){
        RelatorioMovimentacaoInternalFrame relatorioMovimentacaoInternalFrame = new RelatorioMovimentacaoInternalFrame();
        relatorioMovimentacaoInternalFrame.setVisible(true);
        jDesktopPane.add(relatorioMovimentacaoInternalFrame);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuItem jMnCadastroTipoMovimentacao;
    private javax.swing.JMenu jMnCadastros;
    private javax.swing.JMenuItem jMnMovimentacao;
    private javax.swing.JMenu jMnPerfil;
    private javax.swing.JMenu jMnRelatorio;
    private javax.swing.JMenuItem jMnRelatorioMovimentacao;
    private javax.swing.JMenuItem jMnTipoMovimentacao;
    private javax.swing.JMenuBar menu;
    // End of variables declaration                   
}
