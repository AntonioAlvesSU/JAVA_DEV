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

public class frmFicha_fase3 extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmFicha_fase3() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 10);
        conecta = ConectaBD.conectabd();
        listafrmficha_fas3();
    }

    public void pesquisarfrmFicha_fase3() {
        String sql = "Select * from frmficha_fas3 where nome like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPes_fa3.getText() + "%");
            rs = pst.executeQuery();
            tblFase_fa3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void cadastrarfrmFicha_fase3() throws SQLException {

        String sql = "Insert into frmficha_fas3 (nome ,retorn_min,data1,data2,data3,situacao1,situacao2,situacao3,lider1,lider2,lider3,retorn_vol1,data4,data5,data6,situacao4,situacao5,situacao6,resp1,comentario1,resp2,comentario2,resp3,resp4) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome_fa3.getText());
            pst.setString(2, txtRet_min_fa3.getText());
            pst.setString(3, txData1_fa3.getText());
            pst.setString(4, txData2_fa3.getText());
            pst.setString(5, txData3_fa3.getText());
            pst.setString(6, txtSituacao1_fa3.getText());
            pst.setString(7, txtSituacao2_fa3.getText());
            pst.setString(8, txtSituacao3_fa3.getText());
            pst.setString(9, txtLider1_fa3.getText());
            pst.setString(10, txtLider2_fa3.getText());
            pst.setString(11, txtLider3_fa3.getText());
            pst.setString(12, txtRet_vol_fa3.getText());
            pst.setString(13, txData4_fa3.getText());
            pst.setString(14, txData5_fa3.getText());
            pst.setString(15, txData6_fa3.getText());
            pst.setString(16, txtSituacao4_fa3.getText());
            pst.setString(17, txtSituacao5_fa3.getText());
            pst.setString(18, txtSituacao6_fa3.getText());
            pst.setString(19, txtResp1__fa3.getText());
            pst.setString(20, txtComent1_fa3.getText());
            pst.setString(21, txtResp2__fa3.getText());
            pst.setString(22, txtComent2_fa3.getText());
            pst.setString(23, txtResp3__fa3.getText());
            pst.setString(24, txtResp4__fa3.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listafrmficha_fas3();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void editarfrmFicha_fase3() throws SQLException {

        String sql = "Update frmficha_fas3 set nome =?,retorn_min =?,data1 =?,data2 =?,data3 =?,situacao1 =?,situacao2 =?,situacao3 =?,lider1 =?,lider2 =?,lider3 =?,retorn_vol1=?,data4=?,data5 =?,data6 =?,situacao4 =?,situacao5 =?,situacao6 =?,resp1 =?,comentario1 =?,resp2 =?,comentario2 =?,resp3 =?,resp4 =? where codigo_5_id=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome_fa3.getText());
            pst.setString(2, txtRet_min_fa3.getText());
            pst.setString(3, txData1_fa3.getText());
            pst.setString(4, txData2_fa3.getText());
            pst.setString(5, txData3_fa3.getText());
            pst.setString(6, txtSituacao1_fa3.getText());
            pst.setString(7, txtSituacao2_fa3.getText());
            pst.setString(8, txtSituacao3_fa3.getText());
            pst.setString(9, txtLider1_fa3.getText());
            pst.setString(10, txtLider2_fa3.getText());
            pst.setString(11, txtLider3_fa3.getText());
            pst.setString(12, txtRet_vol_fa3.getText());
            pst.setString(13, txData4_fa3.getText());
            pst.setString(14, txData5_fa3.getText());
            pst.setString(15, txData6_fa3.getText());
            pst.setString(16, txtSituacao4_fa3.getText());
            pst.setString(17, txtSituacao5_fa3.getText());
            pst.setString(18, txtSituacao6_fa3.getText());
            pst.setString(19, txtResp1__fa3.getText());
            pst.setString(20, txtComent1_fa3.getText());
            pst.setString(21, txtResp2__fa3.getText());
            pst.setString(22, txtComent2_fa3.getText());
            pst.setString(23, txtResp3__fa3.getText());
            pst.setString(24, txtResp4__fa3.getText());
            pst.setInt(25, Integer.parseInt(txtCod_fa3.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listafrmficha_fas3();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {
        int seleciona = tblFase_fa3.getSelectedRow();
        txtCod_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 0).toString());
        txtNome_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 1).toString());
        txtRet_min_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 2).toString());
        txData1_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 3).toString());
        txData2_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 4).toString());
        txData3_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 5).toString());
        txtSituacao1_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 6).toString());
        txtSituacao2_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 7).toString());
        txtSituacao3_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 8).toString());
        txtLider1_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 9).toString());
        txtLider2_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 10).toString());
        txtLider3_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 11).toString());
        txtRet_vol_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 12).toString());
        txData4_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 13).toString());
        txData5_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 14).toString());
        txData6_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 15).toString());
        txtSituacao4_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 16).toString());
        txtSituacao5_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 17).toString());
        txtSituacao6_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 18).toString());
        txtResp1__fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 19).toString());
        txtComent1_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 20).toString());
        txtResp2__fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 21).toString());
        txtComent2_fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 22).toString());
        txtResp3__fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 23).toString());
        txtResp4__fa3.setText(tblFase_fa3.getModel().getValueAt(seleciona, 24).toString());

    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase3).pdf");

        String sql = "Select * from frmficha_fas3";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO - SERVIÇO VOLUNTÁRIO(Fase3)\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(25);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(25);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Nome");
            tabela.addCell("Ret_min");
            tabela.addCell("txData1");
            tabela.addCell("txData2");
            tabela.addCell("txData3");
            tabela.addCell("Situacao1");
            tabela.addCell("Situacao2");
            tabela.addCell("Situacao3");
            tabela.addCell("Lider1");
            tabela.addCell("Lider2");
            tabela.addCell("Lider3");
            tabela.addCell("Ret_vol");
            tabela.addCell("txData4");
            tabela.addCell("txData5");
            tabela.addCell("txData6");
            tabela.addCell("situacão4");
            tabela.addCell("situacão5");
            tabela.addCell("situacão6");
            tabela.addCell("Resp1");
            tabela.addCell("Coment1");
            tabela.addCell("Resp2");
            tabela.addCell("Coment2");
            tabela.addCell("Resp3");
            tabela.addCell("Resp4");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo_5_id")));
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("retorn_min"));
                tabela.addCell(rs.getString("data1"));
                tabela.addCell(rs.getString("data2"));
                tabela.addCell(rs.getString("data3"));
                tabela.addCell(rs.getString("situacao1"));
                tabela.addCell(rs.getString("situacao2"));
                tabela.addCell(rs.getString("situacao3"));
                tabela.addCell(rs.getString("lider1"));
                tabela.addCell(rs.getString("lider2"));
                tabela.addCell(rs.getString("lider3"));
                tabela.addCell(rs.getString("retorn_vol1"));
                tabela.addCell(rs.getString("data4"));
                tabela.addCell(rs.getString("data5"));
                tabela.addCell(rs.getString("data6"));
                tabela.addCell(rs.getString("situacao4"));
                tabela.addCell(rs.getString("situacao5"));
                tabela.addCell(rs.getString("situacao6"));
                tabela.addCell(rs.getString("resp1"));
                tabela.addCell(rs.getString("comentario1"));
                tabela.addCell(rs.getString("resp2"));
                tabela.addCell(rs.getString("comentario2"));
                tabela.addCell(rs.getString("resp3"));
                tabela.addCell(rs.getString("resp4"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase3).pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {

        txtCod_fa3.setText("");
        txtNome_fa3.setText("");
        txtRet_min_fa3.setText("");
        txData1_fa3.setText("");
        txData2_fa3.setText("");
        txData3_fa3.setText("");
        txtSituacao1_fa3.setText("");
        txtSituacao2_fa3.setText("");
        txtSituacao3_fa3.setText("");
        txtLider1_fa3.setText("");
        txtLider2_fa3.setText("");
        txtLider3_fa3.setText("");
        txtRet_vol_fa3.setText("");
        txData4_fa3.setText("");
        txData5_fa3.setText("");
        txData6_fa3.setText("");
        txtSituacao4_fa3.setText("");
        txtSituacao5_fa3.setText("");
        txtSituacao6_fa3.setText("");
        txtResp1__fa3.setText("");
        txtComent1_fa3.setText("");
        txtResp2__fa3.setText("");
        txtComent2_fa3.setText("");
        txtResp3__fa3.setText("");
        txtResp4__fa3.setText("");

    }

    public void listafrmficha_fas3() {

        String sql = "Select * from frmficha_fas3 order by codigo_5_ID Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tblFase_fa3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void deletefrmFicha_fase3() {
        String sql = "Delete from frmficha_fas3 where codigo_5_ID = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCod_fa3.getText()));
            pst.execute();
            listafrmficha_fas3();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField22 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        txData1_fa3 = new javax.swing.JFormattedTextField();
        jTextField35 = new javax.swing.JTextField();
        txtSituacao1_fa3 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        txtLider1_fa3 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        txData2_fa3 = new javax.swing.JFormattedTextField();
        jTextField40 = new javax.swing.JTextField();
        txtSituacao2_fa3 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        txtLider2_fa3 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        txData3_fa3 = new javax.swing.JFormattedTextField();
        jTextField45 = new javax.swing.JTextField();
        txtSituacao3_fa3 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        txtLider3_fa3 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        txtRet_vol_fa3 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        txData4_fa3 = new javax.swing.JFormattedTextField();
        jTextField51 = new javax.swing.JTextField();
        txtSituacao4_fa3 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        txData5_fa3 = new javax.swing.JFormattedTextField();
        jTextField54 = new javax.swing.JTextField();
        txtSituacao5_fa3 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        txData6_fa3 = new javax.swing.JFormattedTextField();
        jTextField57 = new javax.swing.JTextField();
        txtSituacao6_fa3 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        txtComent2_fa3 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        txtComent1_fa3 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txtPes_fa3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFase_fa3 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        txtCod_fa3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome_fa3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtResp1__fa3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtResp2__fa3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtResp3__fa3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtResp4__fa3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtRet_min_fa3 = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Fase_3_Informações");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(51, 153, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("Fase_3");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 57, -1));

        jTextField31.setBackground(new java.awt.Color(51, 255, 255));
        jTextField31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField31.setText("Retorno Ministérial :");
        getContentPane().add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 0, -1, -1));

        jTextField32.setBackground(new java.awt.Color(51, 255, 255));
        jTextField32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField32.setText("Retorno do Ministério :");
        getContentPane().add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jTextField34.setBackground(new java.awt.Color(51, 255, 255));
        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField34.setText(" Data :");
        getContentPane().add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, -1));

        try {
            txData1_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData1_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 80, -1));

        jTextField35.setBackground(new java.awt.Color(51, 255, 255));
        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField35.setText("Situação :");
        getContentPane().add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, 20));
        getContentPane().add(txtSituacao1_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 100, 30));

        jTextField37.setBackground(new java.awt.Color(51, 255, 255));
        jTextField37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField37.setText("Lider :");
        getContentPane().add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));
        getContentPane().add(txtLider1_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 70, -1));

        jTextField39.setBackground(new java.awt.Color(51, 255, 255));
        jTextField39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField39.setText(" Data :");
        getContentPane().add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        try {
            txData2_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData2_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 80, -1));

        jTextField40.setBackground(new java.awt.Color(51, 255, 255));
        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField40.setText("Situação :");
        getContentPane().add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 20));
        getContentPane().add(txtSituacao2_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 100, 30));

        jTextField43.setBackground(new java.awt.Color(51, 255, 255));
        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField43.setText("Lider :");
        getContentPane().add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));
        getContentPane().add(txtLider2_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 70, -1));

        jTextField44.setBackground(new java.awt.Color(51, 255, 255));
        jTextField44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField44.setText(" Data :");
        getContentPane().add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 50, -1));

        try {
            txData3_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData3_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 80, -1));

        jTextField45.setBackground(new java.awt.Color(51, 255, 255));
        jTextField45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField45.setText("Situação :");
        getContentPane().add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, 20));
        getContentPane().add(txtSituacao3_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 100, 30));

        jTextField47.setBackground(new java.awt.Color(51, 255, 255));
        jTextField47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField47.setText("Lider :");
        getContentPane().add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));
        getContentPane().add(txtLider3_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 70, -1));

        jTextField49.setBackground(new java.awt.Color(51, 255, 255));
        jTextField49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField49.setText("Retorno do Voluntário :");
        getContentPane().add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));
        getContentPane().add(txtRet_vol_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 191, -1));

        jTextField50.setBackground(new java.awt.Color(51, 255, 255));
        jTextField50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField50.setText("Data :");
        getContentPane().add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 45, -1));

        try {
            txData4_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData4_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 90, -1));

        jTextField51.setBackground(new java.awt.Color(51, 255, 255));
        jTextField51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField51.setText("Situação :");
        getContentPane().add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));
        getContentPane().add(txtSituacao4_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 110, -1));

        jTextField53.setBackground(new java.awt.Color(51, 255, 255));
        jTextField53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField53.setText("Data :");
        getContentPane().add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 45, -1));

        try {
            txData5_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData5_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 90, -1));

        jTextField54.setBackground(new java.awt.Color(51, 255, 255));
        jTextField54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField54.setText("Situação :");
        getContentPane().add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));
        getContentPane().add(txtSituacao5_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 110, -1));

        jTextField56.setBackground(new java.awt.Color(51, 255, 255));
        jTextField56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField56.setText("Data :");
        getContentPane().add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 45, -1));

        try {
            txData6_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txData6_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, -1));

        jTextField57.setBackground(new java.awt.Color(51, 255, 255));
        jTextField57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField57.setText("Situação :");
        getContentPane().add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));
        getContentPane().add(txtSituacao6_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 110, -1));

        jTextField11.setBackground(new java.awt.Color(102, 255, 51));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setText("Faça uma Avaliação do Treinamento:");
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jTextField12.setBackground(new java.awt.Color(51, 255, 255));
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField12.setText("Material Apicado :");
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jTextField15.setBackground(new java.awt.Color(51, 255, 255));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField15.setText("Comentário : ");
        getContentPane().add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));
        getContentPane().add(txtComent2_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 330, -1));

        jTextField17.setBackground(new java.awt.Color(51, 255, 255));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField17.setText("Você Indicaria para Alguém este Treinamento ?");
        getContentPane().add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));

        jTextField18.setBackground(new java.awt.Color(0, 255, 255));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField18.setText("Na Sua Opinião, o que deveria ser incluído no Curso?");
        getContentPane().add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, -1, -1));

        jTextField14.setBackground(new java.awt.Color(51, 255, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField14.setText("Instrutor :");
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));
        getContentPane().add(txtComent1_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 220, -1));

        jTextField16.setBackground(new java.awt.Color(51, 255, 255));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField16.setText("Comentário : ");
        getContentPane().add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel71.setText("PESQUISAR :");
        getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 358, -1, -1));

        txtPes_fa3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPes_fa3KeyReleased(evt);
            }
        });
        getContentPane().add(txtPes_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 355, 349, -1));

        tblFase_fa3.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFase_fa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFase_fa3MouseClicked(evt);
            }
        });
        tblFase_fa3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblFase_fa3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblFase_fa3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 473, 1220, 100));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton8.setText("CADASTRAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 140, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton7.setText("EDITAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 100, 140, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton6.setText("DELETAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 130, 140, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton5.setText("LIMPAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 160, 140, -1));

        jLabel70.setBackground(new java.awt.Color(51, 255, 255));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel70.setText("CODIGO :");
        getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtCod_fa3.setBackground(new java.awt.Color(102, 153, 255));
        txtCod_fa3.setEnabled(false);
        getContentPane().add(txtCod_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 30, -1));

        jLabel2.setBackground(new java.awt.Color(51, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("NOME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 51, -1));
        getContentPane().add(txtNome_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setText("Regular");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Bom");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Ótimo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel5.setText("Resp:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));
        getContentPane().add(txtResp1__fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel6.setText("Resp:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));
        getContentPane().add(txtResp2__fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 280, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("Resp:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));
        getContentPane().add(txtResp3__fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 320, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setText("Regular");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setText("Ótimo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 50, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setText("Bom");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 40, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel11.setText("Resp:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));
        getContentPane().add(txtResp4__fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 170, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, 140, -1));

        try {
            txtRet_min_fa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtRet_min_fa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 60, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFase_fa3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFase_fa3KeyReleased
        //pesquisarfrmFicha_fase3();
    }//GEN-LAST:event_tblFase_fa3KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            cadastrarfrmFicha_fase3();
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            editarfrmFicha_fase3();
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        deletefrmFicha_fase3();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtPes_fa3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPes_fa3KeyReleased
        pesquisarfrmFicha_fase3();
    }//GEN-LAST:event_txtPes_fa3KeyReleased

    private void tblFase_fa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFase_fa3MouseClicked
        mostraItem();
    }//GEN-LAST:event_tblFase_fa3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmFicha_fase3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmFicha_fase3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTable tblFase_fa3;
    private javax.swing.JFormattedTextField txData1_fa3;
    private javax.swing.JFormattedTextField txData2_fa3;
    private javax.swing.JFormattedTextField txData3_fa3;
    private javax.swing.JFormattedTextField txData4_fa3;
    private javax.swing.JFormattedTextField txData5_fa3;
    private javax.swing.JFormattedTextField txData6_fa3;
    private javax.swing.JTextField txtCod_fa3;
    private javax.swing.JTextField txtComent1_fa3;
    private javax.swing.JTextField txtComent2_fa3;
    private javax.swing.JTextField txtLider1_fa3;
    private javax.swing.JTextField txtLider2_fa3;
    private javax.swing.JTextField txtLider3_fa3;
    private javax.swing.JTextField txtNome_fa3;
    private javax.swing.JTextField txtPes_fa3;
    private javax.swing.JTextField txtResp1__fa3;
    private javax.swing.JTextField txtResp2__fa3;
    private javax.swing.JTextField txtResp3__fa3;
    private javax.swing.JTextField txtResp4__fa3;
    private javax.swing.JFormattedTextField txtRet_min_fa3;
    private javax.swing.JTextField txtRet_vol_fa3;
    private javax.swing.JTextField txtSituacao1_fa3;
    private javax.swing.JTextField txtSituacao2_fa3;
    private javax.swing.JTextField txtSituacao3_fa3;
    private javax.swing.JTextField txtSituacao4_fa3;
    private javax.swing.JTextField txtSituacao5_fa3;
    private javax.swing.JTextField txtSituacao6_fa3;
    // End of variables declaration//GEN-END:variables
}
