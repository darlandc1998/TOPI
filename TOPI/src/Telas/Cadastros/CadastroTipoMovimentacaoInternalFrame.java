/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Cadastros;

import Acoes.Cadastro.CadastroTipoMovimentacaoAction;
import Dao.TipoMovimentacaoDao;
import Modelos.TipoMovimentacao;
import Utils.UtilConnection;
import Utils.UtilLog;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class CadastroTipoMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    private Integer codigo;
   
    public CadastroTipoMovimentacaoInternalFrame(){
        iniciar();
    }
    
    public CadastroTipoMovimentacaoInternalFrame(Integer codigo) {
        this.codigo = codigo;
        iniciar();
    }
    
    private void iniciar(){        
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
        
        if (codigo != null){
           try (Connection conexao = UtilConnection.getConnection()){
               TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
               popularObjeto(tipoMovimentacaoDao.getObject(new TipoMovimentacao(codigo)));
           } catch(SQLException ex){
               Logger.getLogger(CadastroTipoMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        UtilLog.escreverLog("abriu tela do cadastro tipo de movimentação");
        
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
        tipoMovimentacao.setCodigo(codigo);
        tipoMovimentacao.setDescricao(descricao);
        tipoMovimentacao.setObservacao(observacao);
        return tipoMovimentacao;
    }
    
    public void resetFields(){
        jTxtDescricao.setText(null);
        jTxtObservacao.setText(null);
    }
    
    private void popularObjeto(TipoMovimentacao tipoMovimentacao){
        
        if (tipoMovimentacao == null){
            return;
        }
        
        jTxtDescricao.setText(tipoMovimentacao.getDescricao());
        jTxtObservacao.setText(tipoMovimentacao.getObservacao());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlTipoMovimentacao = new javax.swing.JPanel();
        jBtnSalvar = new javax.swing.JButton();
        jLblObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtObservacao = new javax.swing.JTextArea();
        jLblDescricao = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jLblDescricaoObrigatorio = new javax.swing.JLabel();
        jLblObservacaoObrigatoria = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Tipo Movimentação");

        jPnlTipoMovimentacao.setBackground(new java.awt.Color(245, 245, 245));

        jBtnSalvar.setBackground(new java.awt.Color(0, 153, 102));
        jBtnSalvar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jBtnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_white_18dp.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");

        jLblObservacao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblObservacao.setText("Observação");

        jTxtObservacao.setColumns(20);
        jTxtObservacao.setRows(5);
        jScrollPane1.setViewportView(jTxtObservacao);

        jLblDescricao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblDescricao.setText("Descrição");

        jLblDescricaoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblDescricaoObrigatorio.setText("*");

        jLblObservacaoObrigatoria.setBackground(new java.awt.Color(255, 0, 0));
        jLblObservacaoObrigatoria.setForeground(new java.awt.Color(255, 0, 0));
        jLblObservacaoObrigatoria.setText("*");

        javax.swing.GroupLayout jPnlTipoMovimentacaoLayout = new javax.swing.GroupLayout(jPnlTipoMovimentacao);
        jPnlTipoMovimentacao.setLayout(jPnlTipoMovimentacaoLayout);
        jPnlTipoMovimentacaoLayout.setHorizontalGroup(
            jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                        .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                .addComponent(jLblDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLblDescricaoObrigatorio))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                .addComponent(jLblObservacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLblObservacaoObrigatoria))
                            .addComponent(jTxtDescricao, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPnlTipoMovimentacaoLayout.setVerticalGroup(
            jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDescricao)
                    .addComponent(jLblDescricaoObrigatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblObservacao)
                    .addComponent(jLblObservacaoObrigatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlTipoMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlTipoMovimentacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblDescricaoObrigatorio;
    private javax.swing.JLabel jLblObservacao;
    private javax.swing.JLabel jLblObservacaoObrigatoria;
    private javax.swing.JPanel jPnlTipoMovimentacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JTextArea jTxtObservacao;
    // End of variables declaration//GEN-END:variables
}
