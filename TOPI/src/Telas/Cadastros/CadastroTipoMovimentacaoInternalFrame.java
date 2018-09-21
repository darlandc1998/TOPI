/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Cadastros;

import Acoes.CadastroTipoMovimentacaoAction;
import Acoes.CadastroUsuarioAction;
import Modelos.TipoMovimentacao;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class CadastroTipoMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

   
    public CadastroTipoMovimentacaoInternalFrame() {
        
        CadastroTipoMovimentacaoAction tipoMovimentacaoAction = new CadastroTipoMovimentacaoAction(this);
        
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setSize(100, 100);
        
        
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false); 
        
        initComponents();
        
        jBtnSalvar.addActionListener(tipoMovimentacaoAction);
        jBtnSalvar.setActionCommand(CadastroTipoMovimentacaoAction.COD_SALVAR_TIPO_MOVIMENTACAO);
    }
   
    public TipoMovimentacao getObject(){
        String descricao = jTxtDescricao.getText();
        String observacao = jTxtObservacao.getText();
        
        String messageError = null;
        
        if (observacao.trim().isEmpty()){
            messageError = "Digite uma observação para efetuar cadastro!";
        }
        
        if (messageError != null){
            JOptionPane.showMessageDialog(null, messageError, null, JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
        tipoMovimentacao.setDescricao(descricao);
        tipoMovimentacao.setObservacao(observacao);
        return tipoMovimentacao;
    }
    
    public void resetFields(){
        jTxtDescricao.setText(null);
        jTxtObservacao.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblDescricao = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jLblObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtObservacao = new javax.swing.JTextArea();
        jBtnSalvar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Tipo Movimentação");

        jLblDescricao.setText("Descrição");

        jLblObservacao.setText("Observação");

        jTxtObservacao.setColumns(20);
        jTxtObservacao.setRows(5);
        jScrollPane1.setViewportView(jTxtObservacao);

        jBtnSalvar.setBackground(java.awt.Color.lightGray);
        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_black_18dp.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLblDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblObservacao)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jTxtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDescricao)
                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblObservacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jBtnSalvar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblObservacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JTextArea jTxtObservacao;
    // End of variables declaration//GEN-END:variables
}
