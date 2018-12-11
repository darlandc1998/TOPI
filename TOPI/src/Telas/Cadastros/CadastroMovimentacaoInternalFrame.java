/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Cadastros;

import Acoes.Cadastro.CadastroMovimentacaoAction;
import Dao.TipoMovimentacaoDao;
import Dao.UsuarioDao;
import Enums.EnumRepetirMovimentacao;
import Modelos.Movimentacao;
import Modelos.TipoMovimentacao;
import Utils.UtilConnection;
import Utils.UtilFile;
import Utils.UtilLog;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class CadastroMovimentacaoInternalFrame extends javax.swing.JInternalFrame {

    private List<TipoMovimentacao> listTipoMovimentacoes;
   
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
        addTipoMovimentacoes();
        
        UtilLog.escreverLog("abriu tela do cadastro movimentação");
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
        movimentacao.setCdTipoMovimentacao(getListTipoMovimentacoes().get(jCbxTipoMovimentacao.getSelectedIndex()).getCodigo());
        movimentacao.setData(new Date(data));
        movimentacao.setRepetir(EnumRepetirMovimentacao.values()[jCbxRepetir.getSelectedIndex()]);
        movimentacao.setSituacao(jRbnDespesa.isSelected() ? "D" : "R");
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
            
        } catch (ParseException e) {
            UtilLog.escreverExcecao(e);
        }

    }
    
    private void addTipoMovimentacoes(){
        Connection conexao = UtilConnection.getConnection();
        try {
            TipoMovimentacaoDao tipoMovimentacaoDao = new TipoMovimentacaoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            setListTipoMovimentacoes(tipoMovimentacaoDao.getList("codigo_usuario = "+usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER)),"descricao"));
            getListTipoMovimentacoes().forEach((tipo) -> {
                jCbxTipoMovimentacao.addItem(tipo.getDescricao());
            });            
        } catch (SQLException e) {
            Logger.getLogger(CadastroTipoMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroMovimentacaoInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        btnGroupSituacao = new javax.swing.ButtonGroup();
        jPnlMovimentacao = new javax.swing.JPanel();
        jLblDescricao = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jLblTipoMovimentacao = new javax.swing.JLabel();
        jCbxTipoMovimentacao = new javax.swing.JComboBox<>();
        jRbnDespesa = new javax.swing.JRadioButton();
        jRbnBeneficio = new javax.swing.JRadioButton();
        jLblData = new javax.swing.JLabel();
        jTxtData = new javax.swing.JFormattedTextField();
        jLblValor = new javax.swing.JLabel();
        jTxtValor = new javax.swing.JFormattedTextField();
        jLblRepetir = new javax.swing.JLabel();
        jCbxRepetir = new javax.swing.JComboBox<>();
        jBtnSalvar = new javax.swing.JButton();
        jLblDescricaoObrigatorio = new javax.swing.JLabel();
        jLblTipoObrigatorio = new javax.swing.JLabel();
        jLblValorObrigatorio = new javax.swing.JLabel();
        jLblDataObrigatoria = new javax.swing.JLabel();
        jLblRepetirObrigatorio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(188, 51, 67));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Movimentação");

        jPnlMovimentacao.setBackground(new java.awt.Color(245, 245, 245));

        jLblDescricao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblDescricao.setText("Descrição");

        jLblTipoMovimentacao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblTipoMovimentacao.setText("Tipo");

        jCbxTipoMovimentacao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        btnGroupSituacao.add(jRbnDespesa);
        jRbnDespesa.setSelected(true);
        jRbnDespesa.setText("Despesa");

        btnGroupSituacao.add(jRbnBeneficio);
        jRbnBeneficio.setText("Receita");

        jLblData.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblData.setText("Data");

        jLblValor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblValor.setText("Valor");

        jLblRepetir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblRepetir.setText("Repetir");

        jCbxRepetir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jCbxRepetir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Repete", "Diariamente", "Semanalmente", "Mensalmente", "Anualmente" }));

        jBtnSalvar.setBackground(new java.awt.Color(0, 153, 102));
        jBtnSalvar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jBtnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_white_18dp.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jLblDescricaoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblDescricaoObrigatorio.setText("*");

        jLblTipoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblTipoObrigatorio.setText("*");

        jLblValorObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblValorObrigatorio.setText("*");

        jLblDataObrigatoria.setForeground(new java.awt.Color(255, 0, 0));
        jLblDataObrigatoria.setText("*");

        jLblRepetirObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblRepetirObrigatorio.setText("*");

        javax.swing.GroupLayout jPnlMovimentacaoLayout = new javax.swing.GroupLayout(jPnlMovimentacao);
        jPnlMovimentacao.setLayout(jPnlMovimentacaoLayout);
        jPnlMovimentacaoLayout.setHorizontalGroup(
            jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jRbnDespesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRbnBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jLblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblDescricaoObrigatorio))
                    .addComponent(jTxtDescricao)
                    .addComponent(jTxtValor)
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jLblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblValorObrigatorio))
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jLblRepetir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblRepetirObrigatorio))
                    .addComponent(jCbxRepetir, 0, 304, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jLblTipoMovimentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblTipoObrigatorio))
                    .addComponent(jCbxTipoMovimentacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                        .addComponent(jLblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblDataObrigatoria))
                    .addComponent(jTxtData)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPnlMovimentacaoLayout.setVerticalGroup(
            jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMovimentacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbnBeneficio)
                    .addComponent(jRbnDespesa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDescricao)
                    .addComponent(jLblTipoMovimentacao)
                    .addComponent(jLblDescricaoObrigatorio)
                    .addComponent(jLblTipoObrigatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblValor)
                    .addComponent(jLblData)
                    .addComponent(jLblValorObrigatorio)
                    .addComponent(jLblDataObrigatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblRepetir)
                    .addComponent(jLblRepetirObrigatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbxRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLblDataObrigatoria;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblDescricaoObrigatorio;
    private javax.swing.JLabel jLblRepetir;
    private javax.swing.JLabel jLblRepetirObrigatorio;
    private javax.swing.JLabel jLblTipoMovimentacao;
    private javax.swing.JLabel jLblTipoObrigatorio;
    private javax.swing.JLabel jLblValor;
    private javax.swing.JLabel jLblValorObrigatorio;
    private javax.swing.JPanel jPnlMovimentacao;
    private javax.swing.JRadioButton jRbnBeneficio;
    private javax.swing.JRadioButton jRbnDespesa;
    private javax.swing.JFormattedTextField jTxtData;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JFormattedTextField jTxtValor;
    // End of variables declaration//GEN-END:variables
}
