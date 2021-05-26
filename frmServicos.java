package Visual;

import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import proj.ConectaBD;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Dimension;
import proj.ConectaBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Dimension;
import proj.ConectaBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Dimension;
import proj.ConectaBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import proj.ConectaBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
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

public class frmServicos extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmServicos() throws ClassNotFoundException {
        this.setLocation(200, 150);
        initComponents();
        conecta = ConectaBD.conectabd();
        listaServicos();
    }

    public void listaServicos() {

        String sql = "Select * from ministerios order by cod Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tblServicos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void cadastrarServicos() {
        String sql = "Insert into ministerios(servicos,salas,horario,responsavel,telefones,regularidade,local,data )values(?,?,?,?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtServicos.getText());
            pst.setString(2, txtSalas.getText());
            pst.setString(3, txtHorario.getText());
            pst.setString(4, txtResponsavel.getText());
            pst.setString(5, txtTelefones.getText());
            pst.setString(6, txtRegularidade.getText());
            pst.setString(7, txtLocal.getText());
            pst.setString(8, txtData.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
            listaServicos();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisarServicos() {
        String sql = "Select * from ministerios where servicos like ?";
        try {
            pst = conecta.prepareCall(sql);
            pst.setString(1, txtPesquisando.getText() + "%");
            rs = pst.executeQuery();
            tblServicos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraServicos() {
        int seleciona = tblServicos.getSelectedRow();
        txtCod.setText(tblServicos.getModel().getValueAt(seleciona, 0).toString());
        txtServicos.setText(tblServicos.getModel().getValueAt(seleciona, 1).toString());
        txtSalas.setText(tblServicos.getModel().getValueAt(seleciona, 2).toString());
        txtHorario.setText(tblServicos.getModel().getValueAt(seleciona, 3).toString());
        txtResponsavel.setText(tblServicos.getModel().getValueAt(seleciona, 4).toString());
        txtTelefones.setText(tblServicos.getModel().getValueAt(seleciona, 5).toString());
        txtRegularidade.setText(tblServicos.getModel().getValueAt(seleciona, 6).toString());
        txtLocal.setText(tblServicos.getModel().getValueAt(seleciona, 7).toString());
        txtData.setText(tblServicos.getModel().getValueAt(seleciona, 8).toString());

    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela CADASTRO DOS MINISTERIOS DA IGREJA GETSÊMANI.pdf");

        String sql = "Select * from ministerios";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("MINISTERIOS DA IGREJA GETSÊMANI\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(9);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("MINISTERIOS DA IGREJA GETSÊMANI"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(9);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Servicos");
            tabela.addCell("Salas");
            tabela.addCell("Horario");
            tabela.addCell("Responsavel");
            tabela.addCell("Telefones");
            tabela.addCell("Regularidade");
            tabela.addCell("Local");
            tabela.addCell("Data");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("cod")));
                tabela.addCell(rs.getString("servicos"));
                tabela.addCell(rs.getString("salas"));
                tabela.addCell(rs.getString("horario"));
                tabela.addCell(rs.getString("responsavel"));
                tabela.addCell(rs.getString("telefones"));
                tabela.addCell(rs.getString("regularidade"));
                tabela.addCell(rs.getString("local"));
                tabela.addCell(rs.getString("data"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela CADASTRO DOS MINISTERIOS DA IGREJA GETSÊMANI.pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limpaCampos() {
        txtCod.setText("");
        txtServicos.setText("");
        txtPesquisando.setText("");
        txtHorario.setText("");
        txtSalas.setText("");
        txtTelefones.setText("");
        txtResponsavel.setText("");
        txtRegularidade.setText("");
        txtLocal.setText("");
        txtData.setText("");
    }

    public void editarServicos() {
        String sql = "Update ministerios set servicos= ? , salas = ? , responsavel = ?,horario = ?, telefones = ?, regularidade = ?,local = ?, data = ? where cod = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtServicos.getText());
            pst.setString(2, txtSalas.getText());
            pst.setString(3, txtResponsavel.getText());
            pst.setString(4, txtHorario.getText());
            pst.setString(5, txtTelefones.getText());
            pst.setString(6, txtRegularidade.getText());
            pst.setString(7, txtLocal.getText());
            pst.setString(8, txtData.getText());

            pst.setInt(9, Integer.parseInt(txtCod.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Atualizado", JOptionPane.INFORMATION_MESSAGE);
            listaServicos();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void deletaServicos() {
        String sql = "Delete from ministerios where cod = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCod.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso", "Removido", JOptionPane.INFORMATION_MESSAGE);
            listaServicos();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesquisando = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtServicos = new javax.swing.JTextField();
        txtSalas = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtTelefones = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        txtRegularidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ministerios da Igreja Getsêmani");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        jLabel1.setText("Pesquisando :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 130, -1));

        txtPesquisando.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisandoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtPesquisandoMouseReleased(evt);
            }
        });
        txtPesquisando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisandoActionPerformed(evt);
            }
        });
        txtPesquisando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisandoKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisando, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 585, -1));

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 805, 95));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cod : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 57, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ministerio : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sala : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Responsavel :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Telefone :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        txtCod.setBackground(new java.awt.Color(0, 51, 51));
        txtCod.setEnabled(false);
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 44, -1));
        getContentPane().add(txtServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 152, -1));
        getContentPane().add(txtSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 33, -1));
        getContentPane().add(txtResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 128, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 120, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 250, 120, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 290, 120, -1));

        try {
            txtTelefones.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefones, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Hora :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("       ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 62, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("CADASTRO DOS MINISTERIOS DA IGREJA GETSÊMANI");
        jLabel8.setAutoscrolls(true);
        jLabel8.setDoubleBuffered(true);
        jLabel8.setFocusCycleRoot(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Data:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Regularidade :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));
        getContentPane().add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 77, -1));
        getContentPane().add(txtRegularidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 77, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Local:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 59, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrarServicos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarServicos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deletaServicos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPesquisandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisandoActionPerformed

    }//GEN-LAST:event_txtPesquisandoActionPerformed

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
        mostraServicos();
    }//GEN-LAST:event_tblServicosMouseClicked

    private void txtPesquisandoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisandoMouseClicked

    }//GEN-LAST:event_txtPesquisandoMouseClicked

    private void txtPesquisandoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisandoMouseReleased

    }//GEN-LAST:event_txtPesquisandoMouseReleased

    private void txtPesquisandoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisandoKeyReleased
        pesquisarServicos();
    }//GEN-LAST:event_txtPesquisandoKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmServicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmServicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmServicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtPesquisando;
    private javax.swing.JTextField txtRegularidade;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtSalas;
    private javax.swing.JTextField txtServicos;
    private javax.swing.JFormattedTextField txtTelefones;
    // End of variables declaration//GEN-END:variables
}
