package Telas.Cadastros;

import Acoes.CadastroUsuarioAction;
import Modelos.Usuario;
import java.awt.Container;
import java.awt.Dialog;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class CadastroUsuarioInternalFrame extends javax.swing.JInternalFrame {

    public CadastroUsuarioInternalFrame() {
        CadastroUsuarioAction clienteAction = new CadastroUsuarioAction(this);

        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setSize(100, 100);

        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false);

        initComponents();

        jBtnSalvar.addActionListener(clienteAction);
        jBtnSalvar.setActionCommand(CadastroUsuarioAction.COD_SALVAR_CLIENTE);// Salvar Usuario

        addMasks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSexo = new javax.swing.ButtonGroup();
        jTxtNomeCliente = new javax.swing.JTextField();
        jLblNome = new javax.swing.JLabel();
        jBtnSalvar = new javax.swing.JButton();
        jLblSobrenome = new javax.swing.JLabel();
        jTxtSobrenome = new javax.swing.JTextField();
        jLblEmail = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLblDataNascimento = new javax.swing.JLabel();
        jTxtDtNascimento = new javax.swing.JFormattedTextField();
        jLblSexo = new javax.swing.JLabel();
        jRbnMasculino = new javax.swing.JRadioButton();
        jRbnFeminino = new javax.swing.JRadioButton();
        jLblCpf = new javax.swing.JLabel();
        jTxtCpf = new javax.swing.JTextField();
        jLblEstadoCivil = new javax.swing.JLabel();
        jCbxEstadoCivil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCbxProfissao = new javax.swing.JComboBox<>();
        jLblRendaMensal = new javax.swing.JLabel();
        jTxtRendaMensal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.MatteBorder(null));
        setTitle("Usuário");
        setToolTipText("");

        jTxtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeClienteActionPerformed(evt);
            }
        });

        jLblNome.setText("Nome");

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/baseline_save_black_18dp.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSalvarMouseClicked(evt);
            }
        });
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jLblSobrenome.setText("Sobrenome");

        jLblEmail.setText("Email");

        jLblDataNascimento.setText("Dt. Nascimento");

        jLblSexo.setText("Sexo");

        groupSexo.add(jRbnMasculino);
        jRbnMasculino.setSelected(true);
        jRbnMasculino.setText("Masculino");

        groupSexo.add(jRbnFeminino);
        jRbnFeminino.setText("Feminino");

        jLblCpf.setText("Cpf");

        jLblEstadoCivil.setText("Estado Civil");

        jCbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Divorciado" }));

        jLabel2.setText("Profissão");

        jCbxProfissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedreiro", "Carpinteiro", "Programador" }));

        jLblRendaMensal.setText("Renda Mensal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblEmail)
                    .addComponent(jLblNome)
                    .addComponent(jLblSobrenome)
                    .addComponent(jLblDataNascimento)
                    .addComponent(jLblCpf)
                    .addComponent(jLblEstadoCivil)
                    .addComponent(jLblRendaMensal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtEmail)
                    .addComponent(jTxtNomeCliente)
                    .addComponent(jTxtSobrenome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtRendaMensal)
                            .addComponent(jCbxEstadoCivil, javax.swing.GroupLayout.Alignment.LEADING, 0, 157, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCbxProfissao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRbnMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRbnFeminino))
                            .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNome)
                    .addComponent(jTxtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblSobrenome)
                    .addComponent(jTxtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEmail)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDataNascimento)
                    .addComponent(jTxtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblSexo)
                    .addComponent(jRbnMasculino)
                    .addComponent(jRbnFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCpf)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEstadoCivil)
                    .addComponent(jCbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jCbxProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblRendaMensal)
                    .addComponent(jTxtRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalvarMouseClicked

    }//GEN-LAST:event_jBtnSalvarMouseClicked

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed

    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jTxtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeClienteActionPerformed

    public Usuario getObject() {
        String nmCliente = jTxtNomeCliente.getText();
        String sobrenomeCliente = jTxtSobrenome.getText();
        String emailCliente = jTxtEmail.getText();
        String dtNascimento = jTxtDtNascimento.getText();
        String cpf = jTxtCpf.getText();
        Double rendaMensal = Double.parseDouble(jTxtRendaMensal.getText().replace(".", "").replace(",", "."));

        String messageError = null;

        if (rendaMensal <= 0){
            messageError = "Insira uma renda mensal para efetuar seu cadastro";
        }
        
        if (cpf.trim().isEmpty()){
             messageError = "Insira um cpf para efetuar seu cadastro";
        }
        
        if (dtNascimento.trim().length() < 10){
             messageError = "Insira uma data de nascimento para efetuar seu cadastro";
        }
        
        if (emailCliente.trim().isEmpty()){
            messageError = "Insira um email para efetuar seu cadastro";
        }
        
        if (sobrenomeCliente.trim().isEmpty()){
            messageError = "Insira um sobrenome para efetuar seu cadastro";
        }
        
        if (nmCliente.trim().isEmpty()){
             messageError = "Insira um nome para efetuar seu cadastro";
        }
        
        if (messageError != null) {
            JOptionPane.showMessageDialog(null, messageError, null, JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Usuario cliente = new Usuario();
        cliente.setNome(nmCliente);
        cliente.setSobrenome(sobrenomeCliente);
        cliente.setEmail(emailCliente);
        cliente.setDtNascimento(new Date(dtNascimento));
        cliente.setSexo(jRbnMasculino.isSelected() ? "M" : "F");
        cliente.setCpf(cpf);
        cliente.setEstadoCivil(jCbxEstadoCivil.getItemAt(jCbxEstadoCivil.getSelectedIndex()));
        cliente.setProfissao(jCbxProfissao.getItemAt(jCbxProfissao.getSelectedIndex()));
        cliente.setRendaMensal(rendaMensal);
        return cliente;
    }

    public void resetFields() {
        jTxtNomeCliente.setText(null);
        jTxtSobrenome.setText(null);
        jTxtEmail.setText(null);
        jTxtDtNascimento.setText(null);
        jTxtCpf.setText(null);
        jCbxEstadoCivil.setSelectedIndex(0);
        jCbxProfissao.setSelectedIndex(0);
        jTxtRendaMensal.setValue(0.00);
    }

    private void addMasks() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(jTxtDtNascimento);

            DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
            NumberFormatter formatter = new NumberFormatter(dFormat);
            formatter.setFormat(dFormat);
            formatter.setAllowsInvalid(false);
            jTxtRendaMensal.setFormatterFactory(new DefaultFormatterFactory(formatter));
            jTxtRendaMensal.setValue(0.00);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupSexo;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCbxEstadoCivil;
    private javax.swing.JComboBox<String> jCbxProfissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblCpf;
    private javax.swing.JLabel jLblDataNascimento;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblEstadoCivil;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JLabel jLblRendaMensal;
    private javax.swing.JLabel jLblSexo;
    private javax.swing.JLabel jLblSobrenome;
    private javax.swing.JRadioButton jRbnFeminino;
    private javax.swing.JRadioButton jRbnMasculino;
    private javax.swing.JTextField jTxtCpf;
    private javax.swing.JFormattedTextField jTxtDtNascimento;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNomeCliente;
    private javax.swing.JFormattedTextField jTxtRendaMensal;
    private javax.swing.JTextField jTxtSobrenome;
    // End of variables declaration//GEN-END:variables
}
