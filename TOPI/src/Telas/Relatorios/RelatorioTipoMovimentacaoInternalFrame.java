package Telas.Relatorios;

import Acoes.Relatorio.RelatorioTipoMovimentacaoAction;
import Dao.TipoMovimentacaoDao;
import Dao.UsuarioDao;
import Modelos.TipoMovimentacao;
import Utils.UtilConnection;
import Utils.UtilFile;
import Utils.UtilLog;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class RelatorioTipoMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    private List<TipoMovimentacao> listTipoMovimentacoes;
    
    public RelatorioTipoMovimentacaoInternalFrame() {  
        
        RelatorioTipoMovimentacaoAction relatorioTipoMovimentacaoAction = new RelatorioTipoMovimentacaoAction(this);
        
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setSize(100, 100);
        
        
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false); 
        
        initComponents();
        
        jBtnExcluir.addActionListener(relatorioTipoMovimentacaoAction);
        jBtnExcluir.setActionCommand(RelatorioTipoMovimentacaoAction.COD_EXCLUIR_TIPO_MOVIMENTACAO);
        popularTabela();
        UtilLog.escreverLog("abriu tela de relatório do tipo de movimentação");
    }
    
    private void popularTabela(){
        Connection conexao = UtilConnection.getConnection();
        try {
            DefaultTableModel tb = (DefaultTableModel) jTbTipoMovimentacao.getModel();
            TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            setListTipoMovimentacoes(tipoMovimentacaoDao.getList("codigo_usuario = "+usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)),"descricao"));
            getListTipoMovimentacoes().forEach((tipo) -> {
                tb.addRow(new Object[]{tipo.getDescricao(), tipo.getObservacao()});
            });
        } catch (SQLException e) {
            Logger.getLogger(RelatorioTipoMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioTipoMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<TipoMovimentacao> getListTipoMovimentacoes() {
        return listTipoMovimentacoes;
    }

    public void setListTipoMovimentacoes(List<TipoMovimentacao> listTipoMovimentacoes) {
        this.listTipoMovimentacoes = listTipoMovimentacoes;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTbTipoMovimentacao = new javax.swing.JTable();
        jBtnExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTbTipoMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbTipoMovimentacao);

        jBtnExcluir.setBackground(java.awt.Color.lightGray);
        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_delete_forever_black_18dp.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbTipoMovimentacao;
    // End of variables declaration//GEN-END:variables
}
