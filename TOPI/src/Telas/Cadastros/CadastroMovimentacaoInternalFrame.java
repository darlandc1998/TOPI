/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Cadastros;

import Acoes.CadastroMovimentacaoAction;
import Enums.EnumRepetirMovimentacao;
import Modelos.Movimentacao;
import java.awt.Container;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class CadastroMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    
   
    public CadastroMovimentacaoInternalFrame() {
        CadastroMovimentacaoAction movimentacaoInternalFrame = new CadastroMovimentacaoAction(this);
        
        
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setSize(100, 100);
        
        
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false); 
        
        initComponents();
        
        jBtnSalvar.addActionListener(movimentacaoInternalFrame);
        jBtnSalvar.setActionCommand(CadastroMovimentacaoAction.COD_SALVAR_MOVIMENTACAO);
        
        addMasks();
    }

    public Movimentacao getObject(){
        String descricao = jTxtDescricao.getText();
        Double valor = Double.parseDouble(jTxtValor.getText().replace(".", "").replace(",", "."));
        String data = jTxtData.getText();
        
        String messageError = null;
        
        if (data.trim().length() < 10){
            messageError = "Insira uma data para efetuar o cadastro!";            
        }
        
        if (valor <= 0){
            messageError = "Insira um valor para efetuar o cadastro!";     
        }
        
        if (descricao.trim().isEmpty()){
             messageError = "Insira uma descrição para efetuar o cadastro!";   
        }
        
        if (messageError != null){
            JOptionPane.showMessageDialog(null, messageError, null, JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(valor);
        movimentacao.setDescricao(descricao);
        movimentacao.setCdTipoMovimentacao(1);
        movimentacao.setData(new Date(data));
        movimentacao.setRepetir(EnumRepetirMovimentacao.values()[jCbxRepetir.getSelectedIndex()]);
        //Tipo movimentação será pego dos cadastros, porém como não há dados reais, foi inserido alguns para teste.
        movimentacao.setSituacao(jCbxTipoMovimentacao.getItemAt(jCbxTipoMovimentacao.getSelectedIndex()));
        return movimentacao;
    }
    
    public void resetFiels(){
        jTxtData.setText(null);
        jTxtDescricao.setText(null);
        jTxtValor.setValue(0.00);
        jCbxRepetir.setSelectedIndex(0);
        jCbxTipoMovimentacao.setSelectedIndex(0);
    }
    
    private void addMasks() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(jTxtData);
            
            DecimalFormat dFormat = new DecimalFormat("#,###,###.00") ;
            NumberFormatter formatter = new NumberFormatter(dFormat) ;
            formatter.setFormat(dFormat) ;
            formatter.setAllowsInvalid(false) ; 
            jTxtValor.setFormatterFactory(new DefaultFormatterFactory ( formatter ));
            jTxtValor.setValue(0.00);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSituacao = new javax.swing.ButtonGroup();
        jLblDescricao = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jCbxTipoMovimentacao = new javax.swing.JComboBox<>();
        jLblTipoMovimentacao = new javax.swing.JLabel();
        jRbnBeneficio = new javax.swing.JRadioButton();
        jRbnDespesa = new javax.swing.JRadioButton();
        jLblValor = new javax.swing.JLabel();
        jCbxRepetir = new javax.swing.JComboBox<>();
        jLblRepetir = new javax.swing.JLabel();
        jLblData = new javax.swing.JLabel();
        jBtnSalvar = new javax.swing.JButton();
        jTxtData = new javax.swing.JFormattedTextField();
        jTxtValor = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(188, 51, 67));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Movimentação");

        jLblDescricao.setText("Descrição");

        jCbxTipoMovimentacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentação", "Vale Transporte" }));

        jLblTipoMovimentacao.setText("Tipo");

        btnGroupSituacao.add(jRbnBeneficio);
        jRbnBeneficio.setText("Benefício");

        btnGroupSituacao.add(jRbnDespesa);
        jRbnDespesa.setSelected(true);
        jRbnDespesa.setText("Despesa");

        jLblValor.setText("Valor");

        jCbxRepetir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diariamente", "Semanalmente", "Mensalmente", "Anualmente" }));

        jLblRepetir.setText("Repetir");

        jLblData.setText("Data");

        jBtnSalvar.setBackground(java.awt.Color.lightGray);
        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_black_18dp.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblDescricao)
                            .addComponent(jLblTipoMovimentacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCbxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRbnDespesa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRbnBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblData)
                            .addComponent(jLblRepetir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbxRepetir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtData))
                        .addGap(18, 18, 18)
                        .addComponent(jLblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDescricao)
                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTipoMovimentacao)
                    .addComponent(jRbnDespesa)
                    .addComponent(jRbnBeneficio))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblData)
                    .addComponent(jTxtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblValor)
                    .addComponent(jTxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblRepetir)
                    .addComponent(jCbxRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupSituacao;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCbxRepetir;
    private javax.swing.JComboBox<String> jCbxTipoMovimentacao;
    private javax.swing.JLabel jLblData;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblRepetir;
    private javax.swing.JLabel jLblTipoMovimentacao;
    private javax.swing.JLabel jLblValor;
    private javax.swing.JRadioButton jRbnBeneficio;
    private javax.swing.JRadioButton jRbnDespesa;
    private javax.swing.JFormattedTextField jTxtData;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JFormattedTextField jTxtValor;
    // End of variables declaration//GEN-END:variables
}
