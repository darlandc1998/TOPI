package Telas.Relatorios;

import Acoes.Relatorio.RelatorioMovimentacaoAction;
import Dao.MovimentacaoDao;
import Dao.UsuarioDao;
import Modelos.Movimentacao;
import Utils.UtilConnection;
import Utils.UtilDate;
import Utils.UtilFile;
import Utils.UtilLog;
import Utils.UtilNumeric;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RelatorioMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    private List<Movimentacao> listMovimentacoes;
    
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
        popularTabela();
        UtilLog.escreverLog("abriu tela do relatório de movimentação");
    }

    private void popularTabela() {
        Connection conexao = UtilConnection.getConnection();
        try {
            DefaultTableModel tb = (DefaultTableModel) jTbMovimentacao.getModel();
            MovimentacaoDao movimentacaoDao = new MovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            
            setListMovimentacoes(movimentacaoDao.getList("codigo_usuario = "+usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)),"data desc"));
            
            Double saldo = 0d;
            
            for (Movimentacao mov: getListMovimentacoes()){
                tb.addRow(new Object[]{mov.getCodigo(), mov.getTipoMovimentacaoDescricao(), mov.getSituacao().equals("D") ? "Despesa" : "Receita",mov.getDescricao(), UtilDate.getDateFormatted(mov.getData()), UtilNumeric.getValueFormattedMoney(mov.getValor())});
                saldo = saldo + (mov.getSituacao().equals("D") ? (mov.getValor() * -1) : mov.getValor());
            }
            
            jTxtSaldo.setText(UtilNumeric.getValueFormattedMoney(saldo));
        } catch (SQLException e) {
            Logger.getLogger(RelatorioMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            
        }
    }

    public List<Movimentacao> getListMovimentacoes() {
        return listMovimentacoes;
    }

    public void setListMovimentacoes(List<Movimentacao> listMovimentacoes) {
        this.listMovimentacoes = listMovimentacoes;
    }
    
    public int getSelectedRow(){
        return jTbMovimentacao.getSelectedRow();
    }
    
    public TableModel getTableModel(){
        return jTbMovimentacao.getModel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTbMovimentacao = new javax.swing.JTable();
        jLblSaldo = new javax.swing.JLabel();
        jTxtSaldo = new javax.swing.JLabel();
        jBtnExcluir = new javax.swing.JButton();

        setTitle("Relatório Movimentação");

        jTbMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Situação", "Descrição", "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbMovimentacao);

        jLblSaldo.setText("Saldo: R$");

        jTxtSaldo.setText("125.000,00");

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
                .addComponent(jTxtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jTxtSaldo))
                    .addComponent(jBtnExcluir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JLabel jLblSaldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbMovimentacao;
    private javax.swing.JLabel jTxtSaldo;
    // End of variables declaration//GEN-END:variables
}
