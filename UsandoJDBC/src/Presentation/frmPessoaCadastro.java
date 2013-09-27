/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DominModel.*;
import DataAccess.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alisson 02
 */
public class frmPessoaCadastro extends javax.swing.JInternalFrame {

    public frmPessoaCadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtDataNascimento = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtBairro1 = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cbxUF = new javax.swing.JComboBox();
        lblPais = new javax.swing.JLabel();
        txtBairro2 = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Pessoas");
        setName("frmPessoaCadastrar"); // NOI18N

        lblNome.setText("Nome:");

        lblDataNascimento.setText("Data de Nascimento:");

        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alisson 02\\Documents\\Icones\\Salvar.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblEmail.setText("Email:");

        lblEndereco.setText("Endereço:");

        lblBairro.setText("Bairro:");

        lblCidade.setText("Cidade:");

        lblTelefone.setText("Telefone:");

        lblEstado.setText("Estado:");

        cbxUF.setEditable(true);
        cbxUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblPais.setText("País:");

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alisson 02\\Documents\\Icones\\Apagar.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPais)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEndereco)
                                    .addComponent(lblBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblEmail))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addComponent(txtNome))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCidade)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblDataNascimento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(lblEstado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxUF, 0, 1, Short.MAX_VALUE))))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(cbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPais)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disposeOnClosed() {  
    this.dispose();  
    }
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        if( JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar dos dados?") == 0)
        {
            try{
               //Calendar calendario = GregorianCalendar.getInstance();
               Calendar cal = Calendar.getInstance();
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
 	       cal.setTime(sdf.parse(txtDataNascimento.getText())); 
                
                
               pessoa.setNome(txtNome.getText());               
               pessoa.setDataNascimento(cal.getTime());
               
               pessoaDAO.Salvar(pessoa);
               JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
            }
            catch (Exception ex)
            {
               JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar os dados! " + ex.getMessage()); 
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Cadastro cancelado pelo usuario");
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if( JOptionPane.showConfirmDialog(rootPane, "Deseja realemente Cancelar?") == 0)
        {
            disposeOnClosed();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxUF;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairro1;
    private javax.swing.JTextField txtBairro2;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
