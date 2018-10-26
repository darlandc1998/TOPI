package Telas.Relatorios;

import Acoes.Relatorio.RelatorioMovimentacaoAction;
import Utils.UtilLog;
import java.awt.Container;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class RelatorioMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

  
    public RelatorioMovimentacaoInternalFrame() {
        
        RelatorioMovimentacaoAction relatorioMovimentacaoAction = new RelatorioMovimentacaoAction(this);
        
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setSize(100, 100);
        
        
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false); 
        
        initComponents();
        
        jBtnExcluir.addActionListener(relatorioMovimentacaoAction);
        jBtnExcluir.setActionCommand(RelatorioMovimentacaoAction.COD_EXCLUIR_MOVIMENTACAO);        
        
        UtilLog.escreverLog("abriu tela do relatório de movimentação");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTbMovimentacao = new javax.swing.JTable();
        jLblSaldo = new javax.swing.JLabel();
        JLblSaldo = new javax.swing.JLabel();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();

        setTitle("Relatório Movimentação");

        jTbMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Descrição", "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbMovimentacao);

        jLblSaldo.setText("Saldo: R$");

        JLblSaldo.setText("125.000,00");

        jBtnEditar.setBackground(java.awt.Color.lightGray);
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_edit_black_18dp.png"))); // NOI18N
        jBtnEditar.setText("Editar");

        jBtnExcluir.setBackground(java.awt.Color.lightGray);
        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_delete_forever_black_18dp.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblSaldo)
                        .addComponent(JLblSaldo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnEditar)
                        .addComponent(jBtnExcluir)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLblSaldo;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JLabel jLblSaldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbMovimentacao;
    // End of variables declaration//GEN-END:variables
}
