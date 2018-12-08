package Telas.Cadastros;

import Acoes.Cadastro.CadastroUsuarioAction;
import Dao.UsuarioDao;
import Modelos.Usuario;
import Utils.UtilConnection;
import Utils.UtilFile;
import Utils.UtilLog;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        UtilLog.escreverLog("abriu tela do cadastro usuário");
        carregarPerfil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnSalvar = new javax.swing.JButton();
        jLblNome = new javax.swing.JLabel();
        jTxtNomeCliente = new javax.swing.JTextField();
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
        jLblRendaMensal = new javax.swing.JLabel();
        jTxtRendaMensal = new javax.swing.JFormattedTextField();
        jLblNomeObrigatorio = new javax.swing.JLabel();
        jLblSobrenomeObrigatorio = new javax.swing.JLabel();
        jLblCpfObrigatorio = new javax.swing.JLabel();
        jLblEmailObrigatorio = new javax.swing.JLabel();
        jLblSexoObrigatorio = new javax.swing.JLabel();
        jLblDataNascimentoObrigatorio = new javax.swing.JLabel();
        jLblEstadoCivilObrigatorio = new javax.swing.JLabel();
        jLblRendaMensalObrigatorio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.MatteBorder(null));
        setTitle("Usuário");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jBtnSalvar.setBackground(new java.awt.Color(0, 153, 102));
        jBtnSalvar.setForeground(new java.awt.Color(255, 255, 255));
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

        jLblNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblNome.setText("Nome");

        jTxtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeClienteActionPerformed(evt);
            }
        });

        jLblSobrenome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblSobrenome.setText("Sobrenome");

        jLblEmail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblEmail.setText("Email");

        jLblDataNascimento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblDataNascimento.setText("Dt. Nascimento");

        jLblSexo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblSexo.setText("Sexo");

        groupSexo.add(jRbnMasculino);
        jRbnMasculino.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRbnMasculino.setSelected(true);
        jRbnMasculino.setText("Masculino");

        groupSexo.add(jRbnFeminino);
        jRbnFeminino.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRbnFeminino.setText("Feminino");

        jLblCpf.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblCpf.setText("Cpf");

        jLblEstadoCivil.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblEstadoCivil.setText("Estado Civil");

        jCbxEstadoCivil.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jCbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Divorciado" }));

        jLblRendaMensal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLblRendaMensal.setText("Renda Mensal");

        jLblNomeObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblNomeObrigatorio.setText("*");

        jLblSobrenomeObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblSobrenomeObrigatorio.setText("*");

        jLblCpfObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblCpfObrigatorio.setText("*");

        jLblEmailObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblEmailObrigatorio.setText("*");

        jLblSexoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblSexoObrigatorio.setText("*");

        jLblDataNascimentoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblDataNascimentoObrigatorio.setText("*");

        jLblEstadoCivilObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblEstadoCivilObrigatorio.setText("*");

        jLblRendaMensalObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jLblRendaMensalObrigatorio.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblNomeObrigatorio))
                                    .addComponent(jTxtNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblCpf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblCpfObrigatorio))
                                    .addComponent(jTxtCpf))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jRbnMasculino)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRbnFeminino))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblSexo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblSexoObrigatorio)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblDataNascimento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblDataNascimentoObrigatorio))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblEmail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblEmailObrigatorio))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblSobrenome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblSobrenomeObrigatorio))
                                .addComponent(jTxtSobrenome)
                                .addComponent(jTxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                .addComponent(jTxtDtNascimento)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblEstadoCivil)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblEstadoCivilObrigatorio)))
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLblRendaMensal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblRendaMensalObrigatorio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE))
                                .addComponent(jTxtRendaMensal)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNome)
                    .addComponent(jLblSobrenome)
                    .addComponent(jLblNomeObrigatorio)
                    .addComponent(jLblSobrenomeObrigatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEmail)
                    .addComponent(jLblCpf)
                    .addComponent(jLblCpfObrigatorio)
                    .addComponent(jLblEmailObrigatorio))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblSexo)
                            .addComponent(jLblSexoObrigatorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbnMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRbnFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblDataNascimento)
                            .addComponent(jLblDataNascimentoObrigatorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblEstadoCivil)
                        .addComponent(jLblEstadoCivilObrigatorio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLblRendaMensalObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(489, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeClienteActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed

    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalvarMouseClicked

    }//GEN-LAST:event_jBtnSalvarMouseClicked

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
        } catch (ParseException e) {
            UtilLog.escreverExcecao(e);
        }

    }
    
    public void carregarPerfil(){
        Connection conexao = UtilConnection.getConnection();
        try {
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            Usuario usuario = usuarioDao.getObject(new Usuario(usuarioDao.getIdUserByEmail(UtilFile.lerArquivo(UtilFile.USER))));
            jTxtNomeCliente.setText(usuario.getNome());
            jTxtSobrenome.setText(usuario.getSobrenome());
            jTxtEmail.setText(usuario.getEmail());
            jTxtCpf.setText(usuario.getCpf());
            jTxtDtNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(usuario.getDtNascimento()));
            jRbnMasculino.setSelected(usuario.getSexo().equals("M"));
            jRbnFeminino.setSelected(usuario.getSexo().equals("F"));
            jTxtRendaMensal.setText(usuario.getRendaMensal().toString());            
        } catch (Exception e) {
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroUsuarioInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupSexo;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCbxEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblCpf;
    private javax.swing.JLabel jLblCpfObrigatorio;
    private javax.swing.JLabel jLblDataNascimento;
    private javax.swing.JLabel jLblDataNascimentoObrigatorio;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblEmailObrigatorio;
    private javax.swing.JLabel jLblEstadoCivil;
    private javax.swing.JLabel jLblEstadoCivilObrigatorio;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JLabel jLblNomeObrigatorio;
    private javax.swing.JLabel jLblRendaMensal;
    private javax.swing.JLabel jLblRendaMensalObrigatorio;
    private javax.swing.JLabel jLblSexo;
    private javax.swing.JLabel jLblSexoObrigatorio;
    private javax.swing.JLabel jLblSobrenome;
    private javax.swing.JLabel jLblSobrenomeObrigatorio;
    private javax.swing.JPanel jPanel1;
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
