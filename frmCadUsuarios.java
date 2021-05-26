package Visual;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import proj.ConectaBD;
import java.sql.*;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.ProcessBuilder.Redirect.from;
import static java.sql.Timestamp.from;
import static org.postgresql.core.JavaVersion.from;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class frmCadUsuarios extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    Statement statement;

    public frmCadUsuarios() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 80);
        conecta = ConectaBD.conectabd();

        listaUsuarios();
    }

    public void cadastrarUsuarios() {
        String sql = "Insert into usuarios (nome,telefone,endereco,e_mail,data_aniversario) values(?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtTelefone.getText());
            pst.setString(3, txtEndereco.getText());
            pst.setString(5, txtAniversario.getText());
            pst.setString(4, txtEmail.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listaUsuarios();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void listaUsuarios() {

        String sql = "Select * from usuarios order by codigo Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }

    }

    public void pesquisarUsuarios() {
        String sql = "Select * from usuarios where nome like ?";
        try {
            pst = conecta.prepareCall(sql);
            pst.setString(1, txtpesquisar.getText() + "%");
            rs = pst.executeQuery();
            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {
        int seleciona = tblUsuarios.getSelectedRow();
        txtCodigo.setText(tblUsuarios.getModel().getValueAt(seleciona, 0).toString());
        txtNome.setText(tblUsuarios.getModel().getValueAt(seleciona, 1).toString());
        txtTelefone.setText(tblUsuarios.getModel().getValueAt(seleciona, 2).toString());
        txtEndereco.setText(tblUsuarios.getModel().getValueAt(seleciona, 3).toString());
        txtAniversario.setText(tblUsuarios.getModel().getValueAt(seleciona, 4).toString());
        txtEmail.setText(tblUsuarios.getModel().getValueAt(seleciona, 5).toString());

    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date =new Date();
        date.toString();
        Document document = new Document(PageSize.A4_LANDSCAPE, 30, 20, 20, 30);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela Usuarios.pdf");
        
        String sql = "Select * from usuarios";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("Lista de Usuarios\n\n");
            date.toString();
            document.add(new Paragraph (new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(6);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("Lista do Usuarios Banco"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(6);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo       ");
            tabela.addCell("Nome         ");
            tabela.addCell("Telefone           ");
            tabela.addCell("Endereco           ");
            tabela.addCell("Email              ");
            tabela.addCell("Aniversario        ");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo")));
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("telefone"));
                tabela.addCell(rs.getString("endereco"));
                tabela.addCell(rs.getString("e_mail"));
                tabela.addCell(rs.getString("data_aniversario"));
            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela Usuarios.pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtAniversario.setText("");
        txtEmail.setText("");
    }

    public void editarUsuarios() {
        String sql = "Update usuarios set nome = ?,telefone = ?,endereco = ?,e_mail = ?,data_aniversario = ? where codigo = ? ";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtTelefone.getText());
            pst.setString(3, txtEndereco.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtAniversario.getText());
            pst.setInt(6, Integer.parseInt(txtCodigo.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            listaUsuarios();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void deleteUsuario() {
        String sql = "Delete from usuarios where codigo = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigo.getText()));
            pst.execute();
            listaUsuarios();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtpesquisar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAniversario = new javax.swing.JFormattedTextField();
        txtPdf = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Usuários Voluntarios");
        setMinimumSize(new java.awt.Dimension(80, 80));
        setNormalBounds(new java.awt.Rectangle(0, 0, 50, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 818, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CODIGO :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 25));

        txtCodigo.setBackground(new java.awt.Color(51, 51, 255));
        txtCodigo.setEnabled(false);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 70, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Aniverásrio :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 100, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 217, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TELEFONE : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 121, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("E-mail :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 190, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton2.setText("DELETAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 113, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton3.setText("LIMPAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 113, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton4.setText("EDITAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 113, -1));

        txtpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisarActionPerformed(evt);
            }
        });
        txtpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(txtpesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 800, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_green.png"))); // NOI18N
        jLabel6.setText("CADASTRO : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        jLabel7.setText("PESQUISANDO : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("CADASTRO DE USUARARIOS VOLUNTARIOS :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 17, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 141, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("NOME : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("ENDEREÇO : ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        try {
            txtAniversario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("     ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtAniversario, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 90, -1));

        txtPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        txtPdf.setText("PDF");
        txtPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPdfActionPerformed(evt);
            }
        });
        getContentPane().add(txtPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrarUsuarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisarKeyReleased
        pesquisarUsuarios();
    }//GEN-LAST:event_txtpesquisarKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        deleteUsuario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        editarUsuarios();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        mostraItem();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPdfActionPerformed
        try {
            try {
                GerarPdf();
            } catch (SQLException ex) {
                Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JFormattedTextField txtAniversario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JButton txtPdf;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtpesquisar;
    // End of variables declaration//GEN-END:variables

    private void executeSQL(String _Select__from_usuarios_order_by_codigo_As) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class ConexaoBanco {

        public ConexaoBanco() {
        }
    }
}
