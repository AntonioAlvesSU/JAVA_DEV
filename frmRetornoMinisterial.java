
package Visual;

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
 /* @author GUTO
 */
public class frmRetornoMinisterial extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    
    public frmRetornoMinisterial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomerm = new javax.swing.JTextField();
        codigorm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pesqrm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablerm = new javax.swing.JTable();
        btncadrm = new javax.swing.JButton();
        btneditrm = new javax.swing.JButton();
        btndeletrm = new javax.swing.JButton();
        btnlimprm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ft1datarm = new javax.swing.JFormattedTextField();
        sit1rm = new javax.swing.JTextField();
        lid1rm = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ft2datarm = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        sit2rm = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lid2rm = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ft3datarm = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        sit3rm = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lid3rm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ftrv2rm = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        sitrv2rm = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        ftrv1rm = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        sitrv1rm = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        ftrv3rm = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        sitrv3rm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chrmsim = new javax.swing.JCheckBox();
        chrmnao = new javax.swing.JCheckBox();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nomerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 180, 20));

        codigorm.setEnabled(false);
        getContentPane().add(codigorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 30, 20));

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("RETORNO MINISTERIAL :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" CODIGO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" NOME:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RETORNO DO VOLUNT??RIO :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel11.setText(" PESQUISAR :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));
        getContentPane().add(pesqrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 330, 20));

        tablerm.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablerm);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 740, 90));

        btncadrm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        btncadrm.setText("CADASTRAR");
        getContentPane().add(btncadrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 120, 30));

        btneditrm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        btneditrm.setText("EDITAR");
        getContentPane().add(btneditrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 120, 30));

        btndeletrm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        btndeletrm.setText("DELETAR");
        getContentPane().add(btndeletrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 120, 30));

        btnlimprm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        btnlimprm.setText("LIMPAR");
        getContentPane().add(btnlimprm, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 120, 30));

        jLabel10.setText("DATA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel15.setText("SITUA????O :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 10));

        jLabel16.setText("LIDER :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        try {
            ft1datarm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ft1datarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 60, 30));
        getContentPane().add(sit1rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 340, 30));
        getContentPane().add(lid1rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 100, 30));

        jLabel17.setText("DATA:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        try {
            ft2datarm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ft2datarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 60, 30));

        jLabel18.setText("SITUA????O :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 10));
        getContentPane().add(sit2rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 340, 30));

        jLabel19.setText("LIDER :");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));
        getContentPane().add(lid2rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 100, 30));

        jLabel20.setText("DATA:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        try {
            ft3datarm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ft3datarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 60, 30));

        jLabel21.setText("SITUA????O :");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, 10));
        getContentPane().add(sit3rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 340, 30));

        jLabel22.setText("LIDER :");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));
        getContentPane().add(lid3rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("RETORNO DO MINIST??RIO :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        jLabel23.setText("DATA:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        try {
            ftrv2rm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftrv2rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 60, 30));

        jLabel24.setText("SITUA????O :");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, 10));
        getContentPane().add(sitrv2rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 340, 30));

        jLabel25.setText("DATA:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        try {
            ftrv1rm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftrv1rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 60, 30));

        jLabel26.setText("SITUA????O :");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, 10));
        getContentPane().add(sitrv1rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 340, 30));

        jLabel27.setText("DATA:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        try {
            ftrv3rm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("  ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftrv3rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 60, 30));

        jLabel28.setText("SITUA????O :");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, 10));
        getContentPane().add(sitrv3rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 340, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("VOLUNT??RIO PARA EVENTOS EXPOR??TICOS :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        chrmsim.setText("SIM");
        getContentPane().add(chrmsim, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        chrmnao.setText("N??O");
        getContentPane().add(chrmnao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadrm;
    private javax.swing.JButton btndeletrm;
    private javax.swing.JButton btneditrm;
    private javax.swing.JButton btnlimprm;
    private javax.swing.JCheckBox chrmnao;
    private javax.swing.JCheckBox chrmsim;
    private javax.swing.JTextField codigorm;
    private javax.swing.JFormattedTextField ft1datarm;
    private javax.swing.JFormattedTextField ft2datarm;
    private javax.swing.JFormattedTextField ft3datarm;
    private javax.swing.JFormattedTextField ftrv1rm;
    private javax.swing.JFormattedTextField ftrv2rm;
    private javax.swing.JFormattedTextField ftrv3rm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lid1rm;
    private javax.swing.JTextField lid2rm;
    private javax.swing.JTextField lid3rm;
    private javax.swing.JTextField nomerm;
    private javax.swing.JTextField pesqrm;
    private javax.swing.JTextField sit1rm;
    private javax.swing.JTextField sit2rm;
    private javax.swing.JTextField sit3rm;
    private javax.swing.JTextField sitrv1rm;
    private javax.swing.JTextField sitrv2rm;
    private javax.swing.JTextField sitrv3rm;
    private javax.swing.JTable tablerm;
    // End of variables declaration//GEN-END:variables
}
