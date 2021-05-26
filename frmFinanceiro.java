
package Visual;

import java.awt.Frame;
import proj.ConectaBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class frmFinanceiro extends javax.swing.JInternalFrame {

   Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    
    public frmFinanceiro() throws ClassNotFoundException {
        this.setLocation(20,100);
        initComponents();
        conecta = ConectaBD.conectabd();
       }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDespesa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableEventos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtEventos = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        txtTaxa = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JFormattedTextField();
        txtDate = new javax.swing.JFormattedTextField();
        txtEntrada = new javax.swing.JFormattedTextField();
        txtSaida = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCodi = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        ref = new javax.swing.JLabel();
        txtCodig = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodd = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableDespesas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableCaixa = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSaldo = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(51, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("                   FINANCEIRO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Controle Financeiro : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ENTRADA : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SAÌDA :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("FLUXO DE CAIXA :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Eventos do Grupo voluntarios :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 11, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("DESPESAS :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("VALOR :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DATA :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));
        getContentPane().add(txtDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("PESQUISANDO :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 643, -1));

        jInternalFrame1.setBackground(new java.awt.Color(51, 204, 255));
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("                   FINANCEIRO");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Controle Financeiro : ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("ENTRADA : ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("SAÌDA :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("SALDO :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("FLUXO DE CAIXA :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Eventos do Grupo voluntarios :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("EVENTOS : ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("TAXA INSCRIÇÃO : ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("DATA :");

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("DESPESAS :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("VALOR :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("DATA :");

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("PESQUISANDO :");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel14))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22)
                        .addGap(4, 4, 4)
                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel24)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel25)
                        .addGap(4, 4, 4)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(4, 4, 4)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel14)
                .addGap(11, 11, 11)
                .addComponent(jLabel19)
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel20))
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21))
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel22))
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(16, 16, 16)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel26))
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 343, 0, 0));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("PESQUISANDO :");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscaKeyReleased(evt);
            }
        });
        getContentPane().add(txtbusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 643, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CALCULADORA ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, 30));

        TableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableEventosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableEventos);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 620, 90));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("CADASTRO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("DELETAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("LIMPAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("PESQUISANDO : ");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(txtpesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 620, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Eventos : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Data : ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Hora:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Taxa : ");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));
        getContentPane().add(txtEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 190, -1));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 50, -1));

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("      ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 60, -1));

        try {
            txtTaxa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$  ##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTaxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 60, -1));

        try {
            txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$  ##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 91, -1));

        try {
            txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 70, -1));

        try {
            txtEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$  ##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 80, -1));

        try {
            txtSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$  ##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 80, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Codigo : ");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtCodi.setBackground(new java.awt.Color(0, 0, 0));
        txtCodi.setEnabled(false);
        getContentPane().add(txtCodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 59, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("CADASTRO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("EDITAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("DELETAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("LIMPAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("CADASTRO");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("EDITAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText("DELETAR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setText("LIMPAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Nome :");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 200, -1));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("SALDO EVENTOS");
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, -1, -1));

        ref.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ref.setText("CODIGO : ");
        getContentPane().add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txtCodig.setBackground(new java.awt.Color(0, 0, 0));
        txtCodig.setEnabled(false);
        getContentPane().add(txtCodig, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 40, -1));

        jLabel4.setText("CODIGO : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        txtCodd.setBackground(new java.awt.Color(0, 0, 0));
        txtCodd.setEnabled(false);
        getContentPane().add(txtCodd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 40, -1));

        TableDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDespesasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableDespesas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 620, 90));

        TableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCaixaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableCaixa);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 400, 620, 90));

        tblSaldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblSaldo);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 620, 90));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("SALDO F. CAIXA");
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, -1, -1));

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setText("SALDO FINANCEIRO");
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Calculadora form = null;
        try{
            form = new Calculadora();
            
        }catch(ClassCastException ex){
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cadastroEventos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyReleased
        pesquisaEventos();
    }//GEN-LAST:event_txtpesquisaKeyReleased

    private void TableEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEventosMouseClicked
        mostraItem();
        
    }//GEN-LAST:event_TableEventosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteEventos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        editarEventos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        cadastroFinanceiro();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyReleased
        pesquisaDespesas();
    }//GEN-LAST:event_txtbuscaKeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        limparDespesas();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        deleteDespesas();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        editarDespesas();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cadastroCaixa();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        pesquisaCaixa();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCaixa();
       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        deleteCaixa();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        editarCaixa();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void TableDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDespesasMouseClicked
        mostraDespesas();
    }//GEN-LAST:event_TableDespesasMouseClicked

    private void TableCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCaixaMouseClicked
        mostracaixa();
    }//GEN-LAST:event_TableCaixaMouseClicked
    public void cadastroEventos(){
        String sql = "Insert into financeiro (eventos,data,hora,taxa_insc) values(?,?,?,?)";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1,txtEventos.getText());
            pst.setString(2,txtData.getText());
            pst.setString(3,txtHora.getText());
            pst.setString(4,txtTaxa.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
            listaEventos();
        } 
        catch(SQLException error){
            JOptionPane.showMessageDialog(null,error);
        }
    }
    public void listaEventos(){
       String sql = "Select * from financeiro order by codi Asc";
         try{
             pst = conecta.prepareStatement(sql);
             rs = pst.executeQuery();
             TableEventos.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(SQLException error){
             
             JOptionPane.showMessageDialog(null, error);
             
         } 
    }
    public void pesquisaEventos(){
         String sql ="Select * from financeiro where eventos like ?";
         try{
             pst = conecta.prepareCall(sql);
             pst.setString(1,txtpesquisa.getText()+"%");
             rs = pst.executeQuery();
             TableEventos.setModel(DbUtils.resultSetToTableModel(rs));
             
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null,error);
         }
    }
    public void mostraItem(){
        int seleciona = TableEventos.getSelectedRow();
        txtCodi.setText(TableEventos.getModel().getValueAt(seleciona,0).toString());
        txtEventos.setText(TableEventos.getModel().getValueAt(seleciona,1).toString());
        txtData.setText(TableEventos.getModel().getValueAt(seleciona,2).toString());
        txtHora.setText(TableEventos.getModel().getValueAt(seleciona,3).toString());
        txtTaxa.setText(TableEventos.getModel().getValueAt(seleciona,4).toString());
       
       
        
     }
     public void limparCampos(){
         txtCodi.setText("");
         txtEventos.setText("");
         txtData.setText("");
         txtHora.setText("");
         txtTaxa.setText("");
     }
     public void editarEventos(){
         String sql = "Update financeiro set eventos = ?,data = ?,hora = ?,taxa_insc = ? where codi = ? ";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setString(1,txtEventos.getText());
             pst.setString(2,txtData.getText());
             pst.setString(3,txtHora.getText());
             pst.setString(4,txtTaxa.getText());
             pst.setInt(5,Integer.parseInt(txtCodi.getText()));
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso!");
           listaEventos();            
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
     }
     }
     public void deleteEventos(){
         String sql = "Delete from financeiro where codi = ?";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setInt(1, Integer.parseInt(txtCodi.getText()));
             pst.execute();
             listaEventos();
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
         }
     }
     public void cadastroFinanceiro(){
        String sql = "Insert into financeiro1 (despesas,valor,data) values(?,?,?)";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1,txtDespesa.getText());
            pst.setString(2,txtValor.getText());
            pst.setString(3,txtDate.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
            listaDespesas();
        } 
        catch(SQLException error){
            JOptionPane.showMessageDialog(null,error);
        }
    }
    public void listaDespesas(){
       String sql = "Select * from financeiro1 order by codig Asc";
         try{
             pst = conecta.prepareStatement(sql);
             rs = pst.executeQuery();
             TableDespesas.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(SQLException error){
             
             JOptionPane.showMessageDialog(null, error);
             
         } 
    }
    public void pesquisaDespesas(){
         String sql ="Select * from financeiro1 where despesas like ?";
         try{
             pst = conecta.prepareCall(sql);
             pst.setString(1,txtbusca.getText()+"%");
             rs = pst.executeQuery();
             TableDespesas.setModel(DbUtils.resultSetToTableModel(rs));
             
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null,error);
         }
    }
    public void mostraDespesas(){
        int seleciona = TableDespesas.getSelectedRow();
       txtCodig.setText(TableDespesas.getModel().getValueAt(seleciona,0).toString());
       txtDespesa.setText(TableDespesas.getModel().getValueAt(seleciona,1).toString());
        txtDate.setText(TableDespesas.getModel().getValueAt(seleciona,2).toString());
        txtValor.setText(TableDespesas.getModel().getValueAt(seleciona,3).toString());
        
        
     }
     public void limparDespesas(){
         txtCodig.setText("");
         txtDespesa.setText("");
         txtValor.setText("");
         txtDate.setText("");
         
     }
     public void editarDespesas(){
         String sql = "Update financeiro1 set despesas = ?,valor = ?,data = ? where codig = ? ";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setString(1,txtDespesa.getText());
             pst.setString(2,txtValor.getText());
             pst.setString(3,txtDate.getText());
             pst.setInt(4,Integer.parseInt(txtCodig.getText()));
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso!");
           listaDespesas();            
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
     }
     }
     public void deleteDespesas(){
         String sql = "Delete from financeiro1 where codig = ?";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setInt(1, Integer.parseInt(txtCodig.getText()));
             pst.execute();
             listaDespesas();
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
         }
     }
     public void cadastroCaixa(){
        String sql = "Insert into financeiro2 (nome,entrada,saida) values(?,?,?)";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1,txtNome.getText());
            pst.setString(2,txtEntrada.getText());
            pst.setString(3,txtSaida.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
            listaCaixa();
        } 
        catch(SQLException error){
            JOptionPane.showMessageDialog(null,error);
        }
    }
    public void listaCaixa(){
       String sql = "Select * from financeiro2 order by codd Asc";
         try{
             pst = conecta.prepareStatement(sql);
             rs = pst.executeQuery();
             TableCaixa.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(SQLException error){
             
             JOptionPane.showMessageDialog(null, error);
             
         } 
    }
    public void pesquisaCaixa(){
         String sql ="Select * from financeiro2 where nome like ?";
         try{
             pst = conecta.prepareCall(sql);
             pst.setString(1,txtBuscar.getText()+"%");
             rs = pst.executeQuery();
             TableCaixa.setModel(DbUtils.resultSetToTableModel(rs));
             
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null,error);
         }
    }
    public void mostracaixa(){
        int seleciona = TableCaixa.getSelectedRow();
        txtCodd.setText(TableCaixa.getModel().getValueAt(seleciona,0).toString());
        txtNome.setText(TableCaixa.getModel().getValueAt(seleciona,1).toString());
        txtEntrada.setText(TableCaixa.getModel().getValueAt(seleciona,2).toString());
        txtSaida.setText(TableCaixa.getModel().getValueAt(seleciona,3).toString());
        
        
     }
     public void limparCaixa(){
         txtCodd.setText("");
         txtNome.setText("");
         txtEntrada.setText("");
         txtSaida.setText("");
         }
     public void editarCaixa(){
         String sql = "Update financeiro2 set nome = ?,entrada = ?,saida = ? where codd = ? ";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setString(1,txtNome.getText());
             pst.setString(2,txtEntrada .getText());
             pst.setString(3,txtSaida.getText());
             pst.setInt(4,Integer.parseInt(txtCodd.getText()));
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso!");
           listaCaixa();            
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
     }
     }
     public void deleteCaixa(){
         String sql = "Delete from financeiro2 where codd = ?";
         try{
             pst = conecta.prepareStatement(sql);
             pst.setInt(1, Integer.parseInt(txtCodd.getText()));
             pst.execute();
             listaCaixa();
         }
         catch(SQLException error){
             JOptionPane.showMessageDialog(null, error);
             
         }
     }
     public void saldoEventos(){
         String sql ="update financeiro set total_parcial= ?, taxa_insc= ? where codi = ?";
                 try{
                     pst = conecta.prepareStatement(sql);
                     pst.setInt(1, Integer.parseInt(txtCodi.getText()));
                     pst.execute();
                     listaEventos();
                    }
                 catch(SQLException error){
                     JOptionPane.showMessageDialog(null, error);
                   
                 }
     }
     public void saldoFinanceiro(){
         String sql ="update financeiro1 set total_parcial= ?, valor= ? where codig = ?";
         try{
                     pst = conecta.prepareStatement(sql);
                     pst.setInt(1, Integer.parseInt(txtCodig.getText()));
                     pst.execute();
                     listaDespesas();
             
         }
                catch(SQLException error){
                    JOptionPane.showMessageDialog(null, error);
                }
     }
     public void saldoCaixa(){
         String sql ="update financeiro2 set total_parcial= ?, valor= ? where codig = ?";
         
     }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCaixa;
    private javax.swing.JTable TableDespesas;
    private javax.swing.JTable TableEventos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel ref;
    private javax.swing.JTable tblSaldo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodd;
    private javax.swing.JTextField txtCodi;
    private javax.swing.JTextField txtCodig;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtDespesa;
    private javax.swing.JFormattedTextField txtEntrada;
    private javax.swing.JTextField txtEventos;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtSaida;
    private javax.swing.JFormattedTextField txtTaxa;
    private javax.swing.JFormattedTextField txtValor;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
}
