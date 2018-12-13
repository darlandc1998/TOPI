package Telas.Cadastros;

import Acoes.Cadastro.CadastroTipoMovimentacaoAction;
import Modelos.TipoMovimentacao;
import Utils.UtilLog;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class CadastroTipoMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    public CadastroTipoMovimentacaoInternalFrame(){
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
        jBtnBuscar.addActionListener(tipoMovimentacaoAction);
        jBtnBuscar.setActionCommand(CadastroTipoMovimentacaoAction.COD_BUSCAR_TIPO_MOVIMENTACAO);       
               
        UtilLog.escreverLog("abriu tela do cadastro tipo de movimentação");
        
    }
   
    public TipoMovimentacao getObject(){
        String codigo = jTxtCodigo.getText();
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
        tipoMovimentacao.setCodigo(codigo != null && !codigo.trim().isEmpty() ? Integer.parseInt(codigo) : null);
        tipoMovimentacao.setDescricao(descricao);
        tipoMovimentacao.setObservacao(observacao);
        return tipoMovimentacao;
    }
    
    public Integer getCodigoEdicao(){
        String cod = jTxtCodigo.getText();
        
        if (cod.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite um código para buscar o tipo de movimentação!", null, JOptionPane.WARNING_MESSAGE);
            return null;
        }
            
        
        return Integer.parseInt(cod);
    }
    
    public void resetFields(){
        jTxtDescricao.setText(null);
        jTxtObservacao.setText(null);
        jTxtCodigo.setText(null);
    }
    
    public void disableTxtCodigo(){
        jTxtCodigo.setEditable(false);
        jTxtCodigo.setEnabled(false);
    }
    
    public void enabledTxtCodigo(){
        jTxtCodigo.setEditable(true);
        jTxtCodigo.setEnabled(true);
    }
    
    public void popularObjeto(TipoMovimentacao tipoMovimentacao){
        
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
        jLblCodigo = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();

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

        jLblCodigo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblCodigo.setText("Código");

        jBtnBuscar.setBackground(new java.awt.Color(0, 102, 102));
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_search_white_18dp.png"))); // NOI18N
        jBtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPnlTipoMovimentacaoLayout = new javax.swing.GroupLayout(jPnlTipoMovimentacao);
        jPnlTipoMovimentacao.setLayout(jPnlTipoMovimentacaoLayout);
        jPnlTipoMovimentacaoLayout.setHorizontalGroup(
            jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlTipoMovimentacaoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlTipoMovimentacaoLayout.createSequentialGroup()
                        .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                        .addComponent(jLblDescricao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblDescricaoObrigatorio))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                        .addComponent(jLblObservacao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblObservacaoObrigatoria))
                                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPnlTipoMovimentacaoLayout.createSequentialGroup()
                        .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblCodigo)
                            .addGroup(jPnlTipoMovimentacaoLayout.createSequentialGroup()
                                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnBuscar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPnlTipoMovimentacaoLayout.setVerticalGroup(
            jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlTipoMovimentacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPnlTipoMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(34, 34, 34))
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

    private void jBtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBuscarMouseClicked
        
    }//GEN-LAST:event_jBtnBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLblCodigo;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblDescricaoObrigatorio;
    private javax.swing.JLabel jLblObservacao;
    private javax.swing.JLabel jLblObservacaoObrigatoria;
    private javax.swing.JPanel jPnlTipoMovimentacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JTextArea jTxtObservacao;
    // End of variables declaration//GEN-END:variables
}
