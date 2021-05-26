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

public class frmFicha_fase2 extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmFicha_fase2() throws ClassNotFoundException {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(100, 10);
        conecta = ConectaBD.conectabd();
        listafrmFicha_fase2();
    }

    public void pesquisarfrmFicha_fase2() {
        String sql = "Select * from fich_acomp_fas2 where nome like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPesq_fa2.getText() + "%");
            rs = pst.executeQuery();
            tblFich_acomp_fa2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void cadastrarfrmFicha_fase2() throws SQLException {

        String sql = "Insert into fich_acomp_fas2 (nome,esc1,esc2,esc3,aux_geral1,aux_geral2,aux_geral3,ens_assist1,ens_assist2,ens_assist3,serv_prof1,serv_prof2,serv_prof3,min_indic1,min_indic2,min_indic3,inc_event_exp,outros_a,outros_b,outros_c,trab_com1,trab_com2,trab_com3,teatro1,teatro2,teatro3,artes1,artes2,artes3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome_fa2.getText());
            pst.setString(2, txtEsc1_fa2.getText());
            pst.setString(3, txtEsc2_fa2.getText());
            pst.setString(4, txtEsc3_fa2.getText());
            pst.setString(5, txtAux_Geral1_fa2.getText());
            pst.setString(6, txtAux_Geral2_fa2.getText());
            pst.setString(7, txtAux_Geral3_fa2.getText());
            pst.setString(8, txtEns_Assist1_fa2.getText());
            pst.setString(9, txtEns_Assist2_fa2.getText());
            pst.setString(10, txtEns_Assist3_fa2.getText());
            pst.setString(11, txtServ_Prof1_fa2.getText());
            pst.setString(12, txtServ_Prof2_fa2.getText());
            pst.setString(13, txtServ_Prof3_fa2.getText());
            pst.setString(14, txtMin_Ind1_fa2.getText());
            pst.setString(15, txtMin_Ind2_fa2.getText());
            pst.setString(16, txtMin_Ind3_fa2.getText());
            pst.setString(17, txtInc_Event_Expo_fa2.getText());
            pst.setString(18, txtOutros1_fa2.getText());
            pst.setString(19, txtOutros2_fa2.getText());
            pst.setString(20, txtOutros3_fa2.getText());
            pst.setString(21, txtTrab_Com1_fa2.getText());
            pst.setString(22, txtTrab_Com2_fa2.getText());
            pst.setString(23, txtTrab_Com3_fa2.getText());
            pst.setString(24, txtTeatro1_fa2.getText());
            pst.setString(25, txtTeatro2_fa2.getText());
            pst.setString(26, txtTeatro3_fa2.getText());
            pst.setString(27, txtArtes1_fa2.getText());
            pst.setString(28, txtArtes2_fa2.getText());
            pst.setString(29, txtArtes3_fa2.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listafrmFicha_fase2();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void editarfrmFicha_fase2() throws SQLException {

        String sql = "Update fich_acomp_fas2 set nome =?,esc1 =?,esc2 =?,esc3 =?,aux_geral1 =?,aux_geral2 =?,aux_geral3 =?,ens_assist1 =?,ens_assist2 =?,ens_assist3 =?,serv_prof1 =?,serv_prof2 =?,serv_prof3 =?,min_indic1 =?,min_indic2 =?,min_indic3 =?,inc_event_exp =?,outros_a =?,outros_b =?,outros_c =?,trab_com1 =?,trab_com2 =?,trab_com3 =?,teatro1 =?,teatro2 =?,teatro3 =?,artes1 =?,artes2 =?,artes3 =? where codigo_4_ID =? ";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNome_fa2.getText());
            pst.setString(2, txtEsc1_fa2.getText());
            pst.setString(3, txtEsc2_fa2.getText());
            pst.setString(4, txtEsc3_fa2.getText());
            pst.setString(5, txtAux_Geral1_fa2.getText());
            pst.setString(6, txtAux_Geral2_fa2.getText());
            pst.setString(7, txtAux_Geral3_fa2.getText());
            pst.setString(8, txtEns_Assist1_fa2.getText());
            pst.setString(9, txtEns_Assist2_fa2.getText());
            pst.setString(10, txtEns_Assist3_fa2.getText());
            pst.setString(11, txtServ_Prof1_fa2.getText());
            pst.setString(12, txtServ_Prof2_fa2.getText());
            pst.setString(13, txtServ_Prof3_fa2.getText());
            pst.setString(14, txtMin_Ind1_fa2.getText());
            pst.setString(15, txtMin_Ind2_fa2.getText());
            pst.setString(16, txtMin_Ind3_fa2.getText());
            pst.setString(17, txtInc_Event_Expo_fa2.getText());
            pst.setString(18, txtOutros1_fa2.getText());
            pst.setString(19, txtOutros2_fa2.getText());
            pst.setString(20, txtOutros3_fa2.getText());
            pst.setString(21, txtTrab_Com1_fa2.getText());
            pst.setString(22, txtTrab_Com2_fa2.getText());
            pst.setString(23, txtTrab_Com3_fa2.getText());
            pst.setString(24, txtTeatro1_fa2.getText());
            pst.setString(25, txtTeatro2_fa2.getText());
            pst.setString(26, txtTeatro3_fa2.getText());
            pst.setString(27, txtArtes1_fa2.getText());
            pst.setString(28, txtArtes2_fa2.getText());
            pst.setString(29, txtArtes3_fa2.getText());
            pst.setInt(30, Integer.parseInt(txtCod_fa2.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listafrmFicha_fase2();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {
        int seleciona = tblFich_acomp_fa2.getSelectedRow();
        txtCod_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 0).toString());
        txtNome_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 1).toString());
        txtEsc1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 2).toString());
        txtEsc2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 3).toString());
        txtEsc3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 4).toString());
        txtAux_Geral1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 5).toString());
        txtAux_Geral2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 6).toString());
        txtAux_Geral3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 7).toString());
        txtEns_Assist1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 8).toString());
        txtEns_Assist2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 9).toString());
        txtEns_Assist3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 10).toString());
        txtServ_Prof1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 11).toString());
        txtServ_Prof2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 12).toString());
        txtServ_Prof3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 13).toString());
        txtMin_Ind1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 14).toString());
        txtMin_Ind2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 15).toString());
        txtMin_Ind3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 16).toString());
        txtInc_Event_Expo_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 17).toString());
        txtOutros1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 18).toString());
        txtOutros2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 19).toString());
        txtOutros3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 20).toString());
        txtTrab_Com1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 21).toString());
        txtTrab_Com2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 22).toString());
        txtTrab_Com3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 23).toString());
        txtTeatro1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 24).toString());
        txtTeatro2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 25).toString());
        txtTeatro3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 26).toString());
        txtArtes1_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 27).toString());
        txtArtes2_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 28).toString());
        txtArtes3_fa2.setText(tblFich_acomp_fa2.getModel().getValueAt(seleciona, 29).toString());
    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase2).pdf");

        String sql = "Select * from fich_acomp_fas2";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO - SERVIÇO VOLUNTÁRIO(Fase2)\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(30);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(30);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Nome");
            tabela.addCell("Esc1");
            tabela.addCell("Esc2");
            tabela.addCell("Esc3");
            tabela.addCell("Aux_Geral1");
            tabela.addCell("Aux_Geral2");
            tabela.addCell("Aux_Geral3");
            tabela.addCell("Ens_Assist1");
            tabela.addCell("Ens_Assist2");
            tabela.addCell("Ens_Assist3");
            tabela.addCell("Serv_Prof1");
            tabela.addCell("Serv_Prof2");
            tabela.addCell("Serv_Prof3");
            tabela.addCell("Min_Ind1");
            tabela.addCell("Min_Ind2");
            tabela.addCell("Min_Ind3");
            tabela.addCell("Inc_Event_Expo");
            tabela.addCell("Outros1");
            tabela.addCell("Outros2");
            tabela.addCell("Outros3");
            tabela.addCell("Trab_Com1");
            tabela.addCell("Trab_Com2");
            tabela.addCell("Trab_Com3");
            tabela.addCell("Teatro1");
            tabela.addCell("Teatro2");
            tabela.addCell("Teatro3");
            tabela.addCell("Artes1");
            tabela.addCell("Artes2");
            tabela.addCell("Artes3");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo_4_ID")));
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("esc1"));
                tabela.addCell(rs.getString("esc2"));
                tabela.addCell(rs.getString("esc3"));
                tabela.addCell(rs.getString("aux_geral1"));
                tabela.addCell(rs.getString("aux_geral2"));
                tabela.addCell(rs.getString("aux_geral3"));
                tabela.addCell(rs.getString("ens_assist1"));
                tabela.addCell(rs.getString("ens_assist2"));
                tabela.addCell(rs.getString("ens_assist3"));
                tabela.addCell(rs.getString("serv_prof1"));
                tabela.addCell(rs.getString("serv_prof2"));
                tabela.addCell(rs.getString("serv_prof3"));
                tabela.addCell(rs.getString("min_indic1"));
                tabela.addCell(rs.getString("min_indic2"));
                tabela.addCell(rs.getString("min_indic3"));
                tabela.addCell(rs.getString("inc_event_exp"));
                tabela.addCell(rs.getString("outros_a"));
                tabela.addCell(rs.getString("outros_b"));
                tabela.addCell(rs.getString("outros_c"));
                tabela.addCell(rs.getString("trab_com1"));
                tabela.addCell(rs.getString("trab_com2"));
                tabela.addCell(rs.getString("trab_com3"));
                tabela.addCell(rs.getString("teatro1"));
                tabela.addCell(rs.getString("teatro2"));
                tabela.addCell(rs.getString("teatro3"));
                tabela.addCell(rs.getString("artes1"));
                tabela.addCell(rs.getString("artes2"));
                tabela.addCell(rs.getString("artes3"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase2).pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {

        txtCod_fa2.setText("");
        txtNome_fa2.setText("");
        txtEsc1_fa2.setText("");
        txtEsc2_fa2.setText("");
        txtEsc3_fa2.setText("");
        txtAux_Geral1_fa2.setText("");
        txtAux_Geral2_fa2.setText("");
        txtAux_Geral3_fa2.setText("");
        txtEns_Assist1_fa2.setText("");
        txtEns_Assist2_fa2.setText("");
        txtEns_Assist3_fa2.setText("");
        txtServ_Prof1_fa2.setText("");
        txtServ_Prof2_fa2.setText("");
        txtServ_Prof3_fa2.setText("");
        txtMin_Ind1_fa2.setText("");
        txtMin_Ind2_fa2.setText("");
        txtMin_Ind3_fa2.setText("");
        txtInc_Event_Expo_fa2.setText("");
        txtOutros1_fa2.setText("");
        txtOutros2_fa2.setText("");
        txtOutros3_fa2.setText("");
        txtTrab_Com1_fa2.setText("");
        txtTrab_Com2_fa2.setText("");
        txtTrab_Com3_fa2.setText("");
        txtTeatro1_fa2.setText("");
        txtTeatro2_fa2.setText("");
        txtTeatro3_fa2.setText("");
        txtArtes1_fa2.setText("");
        txtArtes2_fa2.setText("");
        txtArtes3_fa2.setText("");
    }

    public void listafrmFicha_fase2() {

        String sql = "Select * from fich_acomp_fas2 order by codigo_4_ID Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tblFich_acomp_fa2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void deletefrmFicha_fase2() {
        String sql = "Delete from fich_acomp_fas2 where codigo_4_ID = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCod_fa2.getText()));
            pst.execute();
            listafrmFicha_fase2();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField16 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtCod_fa2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome_fa2 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtPesq_fa2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFich_acomp_fa2 = new javax.swing.JTable();
        jTextField14 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        txtMin_Ind3_fa2 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        txtMin_Ind2_fa2 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        txtMin_Ind1_fa2 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEsc1_fa2 = new javax.swing.JTextField();
        txtEsc2_fa2 = new javax.swing.JTextField();
        txtEsc3_fa2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAux_Geral1_fa2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtAux_Geral2_fa2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAux_Geral3_fa2 = new javax.swing.JTextField();
        Esportes = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtEns_Assist1_fa2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtEns_Assist2_fa2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtEns_Assist3_fa2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtServ_Prof1_fa2 = new javax.swing.JTextField();
        txtServ_Prof2_fa2 = new javax.swing.JTextField();
        txtServ_Prof3_fa2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtTrab_Com1_fa2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtTrab_Com2_fa2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtTrab_Com3_fa2 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtTeatro1_fa2 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtTeatro2_fa2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtTeatro3_fa2 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtInc_Event_Expo_fa2 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTextField43 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtECivFa1 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        txtpesqFa2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1Fa2 = new javax.swing.JTable();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jTextField67 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jTextField68 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jTextField69 = new javax.swing.JTextField();
        Esportes1 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jTextField70 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jTextField71 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jTextField72 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jTextField73 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jTextField76 = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jTextField77 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jTextField78 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jTextField79 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jTextField80 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jTextField81 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jTextField82 = new javax.swing.JTextField();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jTextField85 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        txtECivFa2 = new javax.swing.JTextField();
        jTextField86 = new javax.swing.JTextField();
        jTextField87 = new javax.swing.JTextField();
        jTextField88 = new javax.swing.JTextField();
        jTextField89 = new javax.swing.JTextField();
        jTextField90 = new javax.swing.JTextField();
        jTextField91 = new javax.swing.JTextField();
        jTextField92 = new javax.swing.JTextField();
        jTextField93 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        txtpesqFa3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1Fa3 = new javax.swing.JTable();
        jTextField94 = new javax.swing.JTextField();
        jTextField95 = new javax.swing.JTextField();
        jTextField96 = new javax.swing.JTextField();
        jTextField97 = new javax.swing.JTextField();
        jTextField98 = new javax.swing.JTextField();
        jTextField99 = new javax.swing.JTextField();
        jTextField100 = new javax.swing.JTextField();
        jTextField101 = new javax.swing.JTextField();
        jTextField102 = new javax.swing.JTextField();
        jTextField103 = new javax.swing.JTextField();
        jTextField104 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jTextField105 = new javax.swing.JTextField();
        jTextField106 = new javax.swing.JTextField();
        jTextField107 = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jTextField108 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jTextField109 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jTextField110 = new javax.swing.JTextField();
        Esportes2 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jTextField111 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jTextField112 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jTextField113 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jTextField114 = new javax.swing.JTextField();
        jTextField115 = new javax.swing.JTextField();
        jTextField116 = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jTextField117 = new javax.swing.JTextField();
        jLabel203 = new javax.swing.JLabel();
        jTextField118 = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jTextField119 = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jTextField120 = new javax.swing.JTextField();
        jLabel211 = new javax.swing.JLabel();
        jTextField121 = new javax.swing.JTextField();
        jLabel212 = new javax.swing.JLabel();
        jTextField122 = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        jTextField123 = new javax.swing.JTextField();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jTextField124 = new javax.swing.JTextField();
        jTextField125 = new javax.swing.JTextField();
        jLabel214 = new javax.swing.JLabel();
        jTextField126 = new javax.swing.JTextField();
        jLabel215 = new javax.swing.JLabel();
        txtECivFa3 = new javax.swing.JTextField();
        jTextField127 = new javax.swing.JTextField();
        jTextField128 = new javax.swing.JTextField();
        jTextField129 = new javax.swing.JTextField();
        jTextField130 = new javax.swing.JTextField();
        jTextField131 = new javax.swing.JTextField();
        jTextField132 = new javax.swing.JTextField();
        jTextField133 = new javax.swing.JTextField();
        jTextField134 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel216 = new javax.swing.JLabel();
        txtpesqFa4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1Fa4 = new javax.swing.JTable();
        jTextField135 = new javax.swing.JTextField();
        jTextField136 = new javax.swing.JTextField();
        jTextField137 = new javax.swing.JTextField();
        jTextField138 = new javax.swing.JTextField();
        jTextField139 = new javax.swing.JTextField();
        jTextField140 = new javax.swing.JTextField();
        jTextField141 = new javax.swing.JTextField();
        jTextField142 = new javax.swing.JTextField();
        jTextField143 = new javax.swing.JTextField();
        jTextField144 = new javax.swing.JTextField();
        jTextField145 = new javax.swing.JTextField();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jTextField146 = new javax.swing.JTextField();
        jTextField147 = new javax.swing.JTextField();
        jTextField148 = new javax.swing.JTextField();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jTextField149 = new javax.swing.JTextField();
        jLabel230 = new javax.swing.JLabel();
        jTextField150 = new javax.swing.JTextField();
        jLabel231 = new javax.swing.JLabel();
        jTextField151 = new javax.swing.JTextField();
        Esportes3 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jTextField152 = new javax.swing.JTextField();
        jLabel243 = new javax.swing.JLabel();
        jTextField153 = new javax.swing.JTextField();
        jLabel244 = new javax.swing.JLabel();
        jTextField154 = new javax.swing.JTextField();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jTextField155 = new javax.swing.JTextField();
        jTextField156 = new javax.swing.JTextField();
        jTextField157 = new javax.swing.JTextField();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jTextField158 = new javax.swing.JTextField();
        jLabel274 = new javax.swing.JLabel();
        jTextField159 = new javax.swing.JTextField();
        jLabel275 = new javax.swing.JLabel();
        jTextField160 = new javax.swing.JTextField();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jTextField161 = new javax.swing.JTextField();
        jLabel282 = new javax.swing.JLabel();
        jTextField162 = new javax.swing.JTextField();
        jLabel283 = new javax.swing.JLabel();
        jTextField163 = new javax.swing.JTextField();
        jLabel284 = new javax.swing.JLabel();
        jTextField164 = new javax.swing.JTextField();
        jTextField165 = new javax.swing.JTextField();
        jTextField166 = new javax.swing.JTextField();
        jTextField167 = new javax.swing.JTextField();
        txtOutros1_fa2 = new javax.swing.JTextField();
        txtOutros2_fa2 = new javax.swing.JTextField();
        txtOutros3_fa2 = new javax.swing.JTextField();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        txtArtes1_fa2 = new javax.swing.JTextField();
        jLabel292 = new javax.swing.JLabel();
        txtArtes2_fa2 = new javax.swing.JTextField();
        jLabel293 = new javax.swing.JLabel();
        txtArtes3_fa2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Fase_2_Informações");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField16.setBackground(new java.awt.Color(102, 255, 102));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField16.setText("   Ficha de Acompanhamento :");
        getContentPane().add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 292, -1));

        jTextField1.setBackground(new java.awt.Color(102, 204, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("Fase _2 :");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 4, -1, -1));

        jLabel70.setBackground(new java.awt.Color(51, 255, 255));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel70.setText("CODIGO :");
        getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        txtCod_fa2.setBackground(new java.awt.Color(51, 102, 255));
        txtCod_fa2.setEnabled(false);
        getContentPane().add(txtCod_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 30, -1));

        jLabel2.setBackground(new java.awt.Color(51, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("NOME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 51, -1));
        getContentPane().add(txtNome_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 250, -1));

        jTextField2.setBackground(new java.awt.Color(102, 255, 255));
        jTextField2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField2.setText("Suas Habilidades e Talentos:");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jTextField3.setBackground(new java.awt.Color(51, 255, 255));
        jTextField3.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField3.setText("Escritórios :");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 73, -1, -1));

        jTextField5.setBackground(new java.awt.Color(102, 255, 255));
        jTextField5.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField5.setText("Auxílio Geral :");
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 157, -1, -1));

        jTextField7.setBackground(new java.awt.Color(102, 255, 255));
        jTextField7.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField7.setText("Teatro :");
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        jTextField8.setBackground(new java.awt.Color(51, 255, 255));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField8.setText("Ensino ou Assistência :");
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 247, -1, -1));

        jTextField4.setBackground(new java.awt.Color(102, 255, 255));
        jTextField4.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField4.setText("Trabalho Com :");
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        jTextField9.setBackground(new java.awt.Color(51, 255, 255));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField9.setText("Serviços profissionais :");
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 329, -1, -1));

        jTextField13.setBackground(new java.awt.Color(102, 255, 255));
        jTextField13.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField13.setText("Artes :");
        getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 72, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton8.setText("CADASTRAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton7.setText("EDITAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 70, 133, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton6.setText("DELETAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, 133, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton5.setText("LIMPAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 150, 133, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel71.setText("PESQUISAR :");
        getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 427, -1, -1));

        txtPesq_fa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesq_fa2KeyReleased(evt);
            }
        });
        getContentPane().add(txtPesq_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 424, 359, -1));

        tblFich_acomp_fa2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFich_acomp_fa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFich_acomp_fa2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFich_acomp_fa2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1430, 110));

        jTextField14.setBackground(new java.awt.Color(51, 255, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField14.setText("Outros :");
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jTextField23.setBackground(new java.awt.Color(51, 255, 255));
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField23.setText("Ministérios Indicados :");
        getContentPane().add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        jTextField24.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField24.setText("A:");
        getContentPane().add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 26, -1));

        txtMin_Ind3_fa2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        getContentPane().add(txtMin_Ind3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 82, -1));

        jTextField26.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField26.setText("B:");
        getContentPane().add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 26, -1));

        txtMin_Ind2_fa2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        getContentPane().add(txtMin_Ind2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 82, -1));

        jTextField56.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField56.setText("C:");
        getContentPane().add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 26, -1));

        txtMin_Ind1_fa2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        getContentPane().add(txtMin_Ind1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 82, -1));

        jTextField27.setBackground(new java.awt.Color(51, 255, 255));
        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField27.setText("Incluir para Eventos Exporáticos :");
        getContentPane().add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setText("Digitação");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 104, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Recepcionista");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 104, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Proc. De Textos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 104, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel5.setText("Secretaria");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 104, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel6.setText("Telefonista");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 104, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setText("1:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 131, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel9.setText("2:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 131, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel10.setText("3:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 131, -1, -1));
        getContentPane().add(txtEsc1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 128, 94, -1));
        getContentPane().add(txtEsc2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 128, 94, -1));
        getContentPane().add(txtEsc3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 128, 94, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("Alimentação");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel11.setText("Cuidador De Crianças");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 188, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel12.setText("Manutenção");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 188, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel13.setText("Transporte");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 188, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel14.setText("1:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 215, -1, -1));
        getContentPane().add(txtAux_Geral1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 212, 94, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel15.setText("2:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 215, -1, -1));
        getContentPane().add(txtAux_Geral2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 212, 94, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel16.setText("3:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 215, -1, -1));
        getContentPane().add(txtAux_Geral3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 212, 94, -1));

        Esportes.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Esportes.setText("Esportes");
        getContentPane().add(Esportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel18.setText("Adultos Solteiros");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 270, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel19.setText("Casais");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 270, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel20.setText("Homens");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 270, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel21.setText("Mulheres");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 270, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel22.setText("Dança");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 270, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel23.setText("Faculdade");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel24.setText("Pre_Escola");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel25.setText("Ensino Fundamental");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel26.setText("Ensino Médio");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel27.setText("Linguas");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel28.setText("1:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));
        getContentPane().add(txtEns_Assist1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 94, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel29.setText("2:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));
        getContentPane().add(txtEns_Assist2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 94, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel30.setText("3:");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));
        getContentPane().add(txtEns_Assist3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 94, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel17.setText("Aconselhamento");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 370, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel31.setText("Administração");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 370, -1, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel32.setText("Area financeira");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 370, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel33.setText("Jurídica");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 370, -1, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel34.setText("Marketing");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 370, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel35.setText("Engenharia");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 370, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel36.setText("Esportes");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 370, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel37.setText("Enfermagem");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 370, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel38.setText("Limpeza");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 370, -1, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel39.setText("Computação");
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));

        jLabel40.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel40.setText("Contabilidade");
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 394, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel41.setText("Marceneiro");
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 394, -1, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel42.setText("Rh");
        getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 394, -1, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel43.setText("Saúde Mental");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 394, -1, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel44.setText("Trabalho Social");
        getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 394, -1, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel45.setText("Encanador");
        getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 394, -1, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel46.setText("Televisão");
        getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 394, -1, -1));

        jLabel47.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel47.setText("Eletrecísta");
        getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 394, -1, -1));

        jLabel48.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel48.setText("Vendas");
        getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 394, -1, -1));

        jLabel50.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel50.setText("1:");
        getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 427, -1, -1));
        getContentPane().add(txtServ_Prof1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 424, 94, -1));
        getContentPane().add(txtServ_Prof2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 424, 94, -1));
        getContentPane().add(txtServ_Prof3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 424, 94, -1));

        jLabel51.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel51.setText("3:");
        getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 427, -1, -1));

        jLabel52.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel52.setText("2:");
        getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 427, -1, -1));

        jLabel49.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel49.setText("Deficientes");
        getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jLabel53.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel53.setText("Visita Hospitalar");
        getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        jLabel54.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel54.setText("Mudos");
        getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jLabel55.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel55.setText("Drogados");
        getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, 20));

        jLabel56.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel56.setText("Surdos");
        getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        jLabel57.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel57.setText("Prostitutas");
        getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        jLabel58.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel58.setText("1:");
        getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));
        getContentPane().add(txtTrab_Com1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 95, -1));

        jLabel59.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel59.setText("2:");
        getContentPane().add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));
        getContentPane().add(txtTrab_Com2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 95, -1));

        jLabel60.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel60.setText("3:");
        getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));
        getContentPane().add(txtTrab_Com3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 95, -1));

        jLabel61.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel61.setText("Ator");
        getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, -1));

        jLabel62.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel62.setText("Dança");
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, -1, -1));

        jLabel63.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel63.setText("Mímica");
        getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, -1));

        jLabel64.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel64.setText("Marionetes");
        getContentPane().add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, -1, -1));

        jLabel65.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel65.setText("Poeta");
        getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, -1, -1));

        jLabel66.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel66.setText("1:");
        getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, -1, -1));
        getContentPane().add(txtTeatro1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 93, -1));

        jLabel67.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel67.setText("2:");
        getContentPane().add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, -1, -1));
        getContentPane().add(txtTeatro2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 93, -1));

        jLabel68.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel68.setText("3:");
        getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, -1, -1));
        getContentPane().add(txtTeatro3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 93, -1));

        jLabel69.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel69.setText("Resp.:");
        getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        txtInc_Event_Expo_fa2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        getContentPane().add(txtInc_Event_Expo_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 192, -1));

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Fase_2_Informações");

        jTextField43.setBackground(new java.awt.Color(102, 255, 102));
        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField43.setText("   Ficha de Acompanhamento :");

        jTextField10.setBackground(new java.awt.Color(102, 204, 255));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField10.setText("Fase _2 :");

        jLabel72.setBackground(new java.awt.Color(51, 255, 255));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel72.setText("CODIGO :");

        jLabel73.setBackground(new java.awt.Color(51, 255, 255));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel73.setText("NOME:");

        jTextField11.setBackground(new java.awt.Color(102, 255, 255));
        jTextField11.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField11.setText("Suas Habilidades e Talentos:");

        jTextField12.setBackground(new java.awt.Color(51, 255, 255));
        jTextField12.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField12.setText("Escritórios :");

        jTextField45.setBackground(new java.awt.Color(102, 255, 255));
        jTextField45.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField45.setText("Auxílio Geral :");

        jTextField46.setBackground(new java.awt.Color(102, 255, 255));
        jTextField46.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField46.setText("Teatro :");

        jTextField47.setBackground(new java.awt.Color(51, 255, 255));
        jTextField47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField47.setText("Ensino ou Assistência :");

        jTextField48.setBackground(new java.awt.Color(102, 255, 255));
        jTextField48.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField48.setText("Trabalho Com :");

        jTextField49.setBackground(new java.awt.Color(51, 255, 255));
        jTextField49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField49.setText("Serviços profissionais :");

        jTextField50.setBackground(new java.awt.Color(102, 255, 255));
        jTextField50.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField50.setText("Artes :");

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton9.setText("CADASTRAR");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton10.setText("EDITAR");

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton11.setText("DELETAR");

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton12.setText("LIMPAR");

        jLabel74.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel74.setText("PESQUISAR :");

        jTable1Fa2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1Fa2);

        jTextField51.setBackground(new java.awt.Color(51, 255, 255));
        jTextField51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField51.setText("Outros :");

        jTextField52.setBackground(new java.awt.Color(51, 255, 255));
        jTextField52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField52.setText("Ministérios Indicados :");

        jTextField53.setText("A:");

        jTextField55.setText("B:");

        jTextField59.setText("C:");

        jTextField61.setBackground(new java.awt.Color(51, 255, 255));
        jTextField61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField61.setText("Incluir para Eventos Exporáticos :");

        jTextField62.setBackground(new java.awt.Color(51, 255, 255));
        jTextField62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField62.setText("Obs.:");

        jLabel75.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel75.setText("Digitação");

        jLabel76.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel76.setText("Recepcionista");

        jLabel77.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel77.setText("Proc. De Textos");

        jLabel78.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel78.setText("Secretaria");

        jLabel79.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel79.setText("Telefonista");

        jLabel80.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel80.setText("1:");

        jLabel81.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel81.setText("2:");

        jLabel82.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel82.setText("3:");

        jLabel83.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel83.setText("Alimentação");

        jLabel84.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel84.setText("Cuidador De Crianças");

        jLabel85.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel85.setText("Manutenção");

        jLabel86.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel86.setText("Transporte");

        jLabel87.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel87.setText("1:");

        jLabel88.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel88.setText("2:");

        jLabel89.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel89.setText("3:");

        Esportes1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Esportes1.setText("Esportes");

        jLabel90.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel90.setText("Adultos Solteiros");

        jLabel91.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel91.setText("Casais");

        jLabel92.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel92.setText("Homens");

        jLabel93.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel93.setText("Mulheres");

        jLabel94.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel94.setText("Dança");

        jLabel95.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel95.setText("Faculdade");

        jLabel96.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel96.setText("Pre_Escola");

        jLabel97.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel97.setText("Ensino Fundamental");

        jLabel98.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel98.setText("Ensino Médio");

        jLabel99.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel99.setText("Linguas");

        jLabel100.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel100.setText("1:");

        jLabel101.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel101.setText("2:");

        jLabel102.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel102.setText("3:");

        jLabel103.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel103.setText("Aconselhamento");

        jLabel104.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel104.setText("Administração");

        jLabel105.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel105.setText("Area financeira");

        jLabel106.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel106.setText("Jurídica");

        jLabel107.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel107.setText("Marketing");

        jLabel108.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel108.setText("Engenharia");

        jLabel109.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel109.setText("Esportes");

        jLabel110.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel110.setText("Enfermagem");

        jLabel111.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel111.setText("Limpeza");

        jLabel112.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel112.setText("Computação");

        jLabel113.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel113.setText("Contabilidade");

        jLabel114.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel114.setText("Marceneiro");

        jLabel115.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel115.setText("Rh");

        jLabel116.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel116.setText("Saúde Mental");

        jLabel117.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel117.setText("Trabalho Social");

        jLabel118.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel118.setText("Encanador");

        jLabel119.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel119.setText("Televisão");

        jLabel120.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel120.setText("Eletrecísta");

        jLabel121.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel121.setText("Vendas");

        jLabel122.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel122.setText("1:");

        jLabel123.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel123.setText("3:");

        jLabel124.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel124.setText("2:");

        jLabel125.setText("jLabel49");

        jLabel126.setText("jLabel49");

        jLabel127.setText("jLabel49");

        jLabel128.setText("jLabel49");

        jLabel129.setText("jLabel49");

        jLabel130.setText("jLabel49");

        jLabel131.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel131.setText("1:");

        jLabel132.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel132.setText("2:");

        jLabel133.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel133.setText("3:");

        jLabel134.setText("jLabel49");

        jLabel135.setText("jLabel49");

        jLabel136.setText("jLabel49");

        jLabel137.setText("jLabel49");

        jLabel138.setText("jLabel49");

        jLabel139.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel139.setText("1:");

        jLabel140.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel140.setText("2:");

        jLabel141.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel141.setText("3:");

        jLabel142.setText("Resp.:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(3, 3, 3)
                                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(txtECivFa1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel75)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel76)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel77)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel78)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel79))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel80)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel81)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel82)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel83)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel84)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel85)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel86))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel87)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel88)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel89)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(Esportes1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel90)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel91))
                                            .addComponent(jTextField47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel92)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel93)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel94)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel95)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel96))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel101)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel102)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addGap(301, 301, 301)
                                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel97)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel98)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel99)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                    .addComponent(jButton9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton12))
                                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                    .addComponent(jLabel74)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtpesqFa2))
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(484, 484, 484)
                                        .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel104)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel105)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel106)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel107)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel110)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel112))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel113)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel117)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel118)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel119)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel121))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel122)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel123)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel125)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel126)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel127)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel128)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel129)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel130))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel131)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel132)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel133)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel134)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel135)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel136)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel137)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel138))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel139)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel140)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel141)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel142)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(txtECivFa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel79))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel81)
                                    .addComponent(jLabel82)
                                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel85)
                                    .addComponent(jLabel86))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel87)
                                    .addComponent(jLabel88)
                                    .addComponent(jLabel89)
                                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Esportes1)
                                            .addComponent(jLabel90)
                                            .addComponent(jLabel91)
                                            .addComponent(jLabel92)
                                            .addComponent(jLabel93)
                                            .addComponent(jLabel94)
                                            .addComponent(jLabel95)
                                            .addComponent(jLabel96)
                                            .addComponent(jLabel97)
                                            .addComponent(jLabel98)
                                            .addComponent(jLabel99))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel100)
                                            .addComponent(jLabel101)
                                            .addComponent(jLabel102)
                                            .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(11, 11, 11)
                                .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel104)
                                    .addComponent(jLabel105)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel107)
                                    .addComponent(jLabel108)
                                    .addComponent(jLabel109)
                                    .addComponent(jLabel110)
                                    .addComponent(jLabel111)
                                    .addComponent(jLabel112))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel116)
                                    .addComponent(jLabel117)
                                    .addComponent(jLabel118)
                                    .addComponent(jLabel119)
                                    .addComponent(jLabel120)
                                    .addComponent(jLabel121))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel122)
                                    .addComponent(jLabel124)
                                    .addComponent(jLabel123)
                                    .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel125)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel128)
                                    .addComponent(jLabel129)
                                    .addComponent(jLabel130))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel131)
                                    .addComponent(jLabel132)
                                    .addComponent(jLabel133)
                                    .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel134)
                                    .addComponent(jLabel135)
                                    .addComponent(jLabel136)
                                    .addComponent(jLabel137)
                                    .addComponent(jLabel138))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel139)
                                    .addComponent(jLabel140)
                                    .addComponent(jLabel141)
                                    .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(586, 586, 586)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10)
                                    .addComponent(jButton11)
                                    .addComponent(jButton12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpesqFa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel142)
                            .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 618, 0, 0));

        jInternalFrame2.setClosable(true);
        jInternalFrame2.setIconifiable(true);
        jInternalFrame2.setMaximizable(true);
        jInternalFrame2.setResizable(true);
        jInternalFrame2.setTitle("Fase_2_Informações");

        jTextField83.setBackground(new java.awt.Color(102, 255, 102));
        jTextField83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField83.setText("   Ficha de Acompanhamento :");

        jTextField84.setBackground(new java.awt.Color(102, 204, 255));
        jTextField84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField84.setText("Fase _2 :");

        jLabel143.setBackground(new java.awt.Color(51, 255, 255));
        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel143.setText("CODIGO :");

        jLabel144.setBackground(new java.awt.Color(51, 255, 255));
        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel144.setText("NOME:");

        jTextField86.setBackground(new java.awt.Color(102, 255, 255));
        jTextField86.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField86.setText("Suas Habilidades e Talentos:");

        jTextField87.setBackground(new java.awt.Color(51, 255, 255));
        jTextField87.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField87.setText("Escritórios :");

        jTextField88.setBackground(new java.awt.Color(102, 255, 255));
        jTextField88.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField88.setText("Auxílio Geral :");

        jTextField89.setBackground(new java.awt.Color(102, 255, 255));
        jTextField89.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField89.setText("Teatro :");

        jTextField90.setBackground(new java.awt.Color(51, 255, 255));
        jTextField90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField90.setText("Ensino ou Assistência :");

        jTextField91.setBackground(new java.awt.Color(102, 255, 255));
        jTextField91.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField91.setText("Trabalho Com :");

        jTextField92.setBackground(new java.awt.Color(51, 255, 255));
        jTextField92.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField92.setText("Serviços profissionais :");

        jTextField93.setBackground(new java.awt.Color(102, 255, 255));
        jTextField93.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField93.setText("Artes :");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton13.setText("CADASTRAR");

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton14.setText("EDITAR");

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton15.setText("DELETAR");

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton16.setText("LIMPAR");

        jLabel145.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel145.setText("PESQUISAR :");

        jTable1Fa3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable1Fa3);

        jTextField94.setBackground(new java.awt.Color(51, 255, 255));
        jTextField94.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField94.setText("Outros :");

        jTextField95.setBackground(new java.awt.Color(51, 255, 255));
        jTextField95.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField95.setText("Ministérios Indicados :");

        jTextField96.setText("A:");

        jTextField98.setText("B:");

        jTextField100.setText("C:");

        jTextField102.setBackground(new java.awt.Color(51, 255, 255));
        jTextField102.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField102.setText("Incluir para Eventos Exporáticos :");

        jTextField103.setBackground(new java.awt.Color(51, 255, 255));
        jTextField103.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField103.setText("Obs.:");

        jLabel146.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel146.setText("Digitação");

        jLabel147.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel147.setText("Recepcionista");

        jLabel148.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel148.setText("Proc. De Textos");

        jLabel149.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel149.setText("Secretaria");

        jLabel150.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel150.setText("Telefonista");

        jLabel151.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel151.setText("1:");

        jLabel152.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel152.setText("2:");

        jLabel153.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel153.setText("3:");

        jLabel154.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel154.setText("Alimentação");

        jLabel155.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel155.setText("Cuidador De Crianças");

        jLabel156.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel156.setText("Manutenção");

        jLabel157.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel157.setText("Transporte");

        jLabel158.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel158.setText("1:");

        jLabel159.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel159.setText("2:");

        jLabel160.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel160.setText("3:");

        Esportes2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Esportes2.setText("Esportes");

        jLabel161.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel161.setText("Adultos Solteiros");

        jLabel162.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel162.setText("Casais");

        jLabel163.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel163.setText("Homens");

        jLabel164.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel164.setText("Mulheres");

        jLabel165.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel165.setText("Dança");

        jLabel166.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel166.setText("Faculdade");

        jLabel167.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel167.setText("Pre_Escola");

        jLabel168.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel168.setText("Ensino Fundamental");

        jLabel169.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel169.setText("Ensino Médio");

        jLabel170.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel170.setText("Linguas");

        jLabel171.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel171.setText("1:");

        jLabel172.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel172.setText("2:");

        jLabel173.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel173.setText("3:");

        jLabel174.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel174.setText("Aconselhamento");

        jLabel175.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel175.setText("Administração");

        jLabel176.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel176.setText("Area financeira");

        jLabel177.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel177.setText("Jurídica");

        jLabel178.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel178.setText("Marketing");

        jLabel179.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel179.setText("Engenharia");

        jLabel180.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel180.setText("Esportes");

        jLabel181.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel181.setText("Enfermagem");

        jLabel182.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel182.setText("Limpeza");

        jLabel183.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel183.setText("Computação");

        jLabel184.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel184.setText("Contabilidade");

        jLabel185.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel185.setText("Marceneiro");

        jLabel186.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel186.setText("Rh");

        jLabel187.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel187.setText("Saúde Mental");

        jLabel188.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel188.setText("Trabalho Social");

        jLabel189.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel189.setText("Encanador");

        jLabel190.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel190.setText("Televisão");

        jLabel191.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel191.setText("Eletrecísta");

        jLabel192.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel192.setText("Vendas");

        jLabel193.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel193.setText("1:");

        jLabel194.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel194.setText("3:");

        jLabel195.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel195.setText("2:");

        jLabel196.setText("jLabel49");

        jLabel197.setText("jLabel49");

        jLabel198.setText("jLabel49");

        jLabel199.setText("jLabel49");

        jLabel200.setText("jLabel49");

        jLabel201.setText("jLabel49");

        jLabel202.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel202.setText("1:");

        jLabel203.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel203.setText("2:");

        jLabel204.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel204.setText("3:");

        jLabel205.setText("jLabel49");

        jLabel206.setText("jLabel49");

        jLabel207.setText("jLabel49");

        jLabel208.setText("jLabel49");

        jLabel209.setText("jLabel49");

        jLabel210.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel210.setText("1:");

        jLabel211.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel211.setText("2:");

        jLabel212.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel212.setText("3:");

        jLabel213.setText("Resp.:");

        jInternalFrame3.setClosable(true);
        jInternalFrame3.setIconifiable(true);
        jInternalFrame3.setMaximizable(true);
        jInternalFrame3.setResizable(true);
        jInternalFrame3.setTitle("Fase_2_Informações");

        jTextField124.setBackground(new java.awt.Color(102, 255, 102));
        jTextField124.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField124.setText("   Ficha de Acompanhamento :");

        jTextField125.setBackground(new java.awt.Color(102, 204, 255));
        jTextField125.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField125.setText("Fase _2 :");

        jLabel214.setBackground(new java.awt.Color(51, 255, 255));
        jLabel214.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel214.setText("CODIGO :");

        jLabel215.setBackground(new java.awt.Color(51, 255, 255));
        jLabel215.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel215.setText("NOME:");

        jTextField127.setBackground(new java.awt.Color(102, 255, 255));
        jTextField127.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField127.setText("Suas Habilidades e Talentos:");

        jTextField128.setBackground(new java.awt.Color(51, 255, 255));
        jTextField128.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField128.setText("Escritórios :");

        jTextField129.setBackground(new java.awt.Color(102, 255, 255));
        jTextField129.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField129.setText("Auxílio Geral :");

        jTextField130.setBackground(new java.awt.Color(102, 255, 255));
        jTextField130.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField130.setText("Teatro :");

        jTextField131.setBackground(new java.awt.Color(51, 255, 255));
        jTextField131.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField131.setText("Ensino ou Assistência :");

        jTextField132.setBackground(new java.awt.Color(102, 255, 255));
        jTextField132.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField132.setText("Trabalho Com :");

        jTextField133.setBackground(new java.awt.Color(51, 255, 255));
        jTextField133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField133.setText("Serviços profissionais :");

        jTextField134.setBackground(new java.awt.Color(102, 255, 255));
        jTextField134.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jTextField134.setText("Artes :");

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton17.setText("CADASTRAR");

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton18.setText("EDITAR");

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton19.setText("DELETAR");

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton20.setText("LIMPAR");

        jLabel216.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel216.setText("PESQUISAR :");

        jTable1Fa4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable1Fa4);

        jTextField135.setBackground(new java.awt.Color(51, 255, 255));
        jTextField135.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField135.setText("Outros :");

        jTextField136.setBackground(new java.awt.Color(51, 255, 255));
        jTextField136.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField136.setText("Ministérios Indicados :");

        jTextField137.setText("A:");

        jTextField139.setText("B:");

        jTextField141.setText("C:");

        jTextField143.setBackground(new java.awt.Color(51, 255, 255));
        jTextField143.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField143.setText("Incluir para Eventos Exporáticos :");

        jTextField144.setBackground(new java.awt.Color(51, 255, 255));
        jTextField144.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField144.setText("Obs.:");

        jLabel217.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel217.setText("Digitação");

        jLabel218.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel218.setText("Recepcionista");

        jLabel219.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel219.setText("Proc. De Textos");

        jLabel220.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel220.setText("Secretaria");

        jLabel221.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel221.setText("Telefonista");

        jLabel222.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel222.setText("1:");

        jLabel223.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel223.setText("2:");

        jLabel224.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel224.setText("3:");

        jLabel225.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel225.setText("Alimentação");

        jLabel226.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel226.setText("Cuidador De Crianças");

        jLabel227.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel227.setText("Manutenção");

        jLabel228.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel228.setText("Transporte");

        jLabel229.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel229.setText("1:");

        jLabel230.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel230.setText("2:");

        jLabel231.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel231.setText("3:");

        Esportes3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Esportes3.setText("Esportes");

        jLabel232.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel232.setText("Adultos Solteiros");

        jLabel233.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel233.setText("Casais");

        jLabel234.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel234.setText("Homens");

        jLabel235.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel235.setText("Mulheres");

        jLabel236.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel236.setText("Dança");

        jLabel237.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel237.setText("Faculdade");

        jLabel238.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel238.setText("Pre_Escola");

        jLabel239.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel239.setText("Ensino Fundamental");

        jLabel240.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel240.setText("Ensino Médio");

        jLabel241.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel241.setText("Linguas");

        jLabel242.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel242.setText("1:");

        jLabel243.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel243.setText("2:");

        jLabel244.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel244.setText("3:");

        jLabel245.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel245.setText("Aconselhamento");

        jLabel246.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel246.setText("Administração");

        jLabel247.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel247.setText("Area financeira");

        jLabel248.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel248.setText("Jurídica");

        jLabel249.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel249.setText("Marketing");

        jLabel250.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel250.setText("Engenharia");

        jLabel251.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel251.setText("Esportes");

        jLabel252.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel252.setText("Enfermagem");

        jLabel253.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel253.setText("Limpeza");

        jLabel254.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel254.setText("Computação");

        jLabel255.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel255.setText("Contabilidade");

        jLabel256.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel256.setText("Marceneiro");

        jLabel257.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel257.setText("Rh");

        jLabel258.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel258.setText("Saúde Mental");

        jLabel259.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel259.setText("Trabalho Social");

        jLabel260.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel260.setText("Encanador");

        jLabel261.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel261.setText("Televisão");

        jLabel262.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel262.setText("Eletrecísta");

        jLabel263.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel263.setText("Vendas");

        jLabel264.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel264.setText("1:");

        jLabel265.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel265.setText("3:");

        jLabel266.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel266.setText("2:");

        jLabel267.setText("jLabel49");

        jLabel268.setText("jLabel49");

        jLabel269.setText("jLabel49");

        jLabel270.setText("jLabel49");

        jLabel271.setText("jLabel49");

        jLabel272.setText("jLabel49");

        jLabel273.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel273.setText("1:");

        jLabel274.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel274.setText("2:");

        jLabel275.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel275.setText("3:");

        jLabel276.setText("jLabel49");

        jLabel277.setText("jLabel49");

        jLabel278.setText("jLabel49");

        jLabel279.setText("jLabel49");

        jLabel280.setText("jLabel49");

        jLabel281.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel281.setText("1:");

        jLabel282.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel282.setText("2:");

        jLabel283.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel283.setText("3:");

        jLabel284.setText("Resp.:");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jTextField125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(jTextField124, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel214)
                                .addGap(3, 3, 3)
                                .addComponent(jTextField126, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(txtECivFa3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel217)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel218)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel219)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel220)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel221))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel222)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel223)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel224)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel225)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel226)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel227)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel228))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel229)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField149, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel230)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField150, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel231)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame3Layout.createSequentialGroup()
                                                .addComponent(Esportes3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel232)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel233))
                                            .addComponent(jTextField131, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel234)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel235)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel236)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel237)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel238))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel242)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField152, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel243)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField153, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel244)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField154, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                                .addGap(301, 301, 301)
                                                .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel239)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel240)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel241)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                                    .addComponent(jButton17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton20))
                                                .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                                    .addComponent(jLabel216)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtpesqFa4))
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField139, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField141, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField137, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField140, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField142, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jTextField134, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addGap(484, 484, 484)
                                        .addComponent(jTextField144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jTextField133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel245)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel246)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel247)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel248)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel249)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel250)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel251)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel252)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel253)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel254))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel255)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel256)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel257)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel258)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel259)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel260)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel261)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel262)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel263))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel264)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField155, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel266)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField156, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel265)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField157, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel267)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel268)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel269)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel270)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel271)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel272))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel273)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel274)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel275)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel276)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel277)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel278)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel279)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel280))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel281)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField161, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel282)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel283)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jTextField128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jTextField136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addComponent(jLabel284)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel214)
                    .addComponent(jTextField126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel215)
                    .addComponent(txtECivFa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jTextField137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jTextField128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel217)
                                    .addComponent(jLabel218)
                                    .addComponent(jLabel219)
                                    .addComponent(jLabel220)
                                    .addComponent(jLabel221))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel222)
                                    .addComponent(jLabel223)
                                    .addComponent(jLabel224)
                                    .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel225)
                                    .addComponent(jLabel226)
                                    .addComponent(jLabel227)
                                    .addComponent(jLabel228))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel229)
                                    .addComponent(jLabel230)
                                    .addComponent(jLabel231)
                                    .addComponent(jTextField149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jTextField134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Esportes3)
                                            .addComponent(jLabel232)
                                            .addComponent(jLabel233)
                                            .addComponent(jLabel234)
                                            .addComponent(jLabel235)
                                            .addComponent(jLabel236)
                                            .addComponent(jLabel237)
                                            .addComponent(jLabel238)
                                            .addComponent(jLabel239)
                                            .addComponent(jLabel240)
                                            .addComponent(jLabel241))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel242)
                                            .addComponent(jLabel243)
                                            .addComponent(jLabel244)
                                            .addComponent(jTextField152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField153, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField154, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(11, 11, 11)
                                .addComponent(jTextField133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel245)
                                    .addComponent(jLabel246)
                                    .addComponent(jLabel247)
                                    .addComponent(jLabel248)
                                    .addComponent(jLabel249)
                                    .addComponent(jLabel250)
                                    .addComponent(jLabel251)
                                    .addComponent(jLabel252)
                                    .addComponent(jLabel253)
                                    .addComponent(jLabel254))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel255)
                                    .addComponent(jLabel256)
                                    .addComponent(jLabel257)
                                    .addComponent(jLabel258)
                                    .addComponent(jLabel259)
                                    .addComponent(jLabel260)
                                    .addComponent(jLabel261)
                                    .addComponent(jLabel262)
                                    .addComponent(jLabel263))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel264)
                                    .addComponent(jLabel266)
                                    .addComponent(jLabel265)
                                    .addComponent(jTextField155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField157, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel267)
                                    .addComponent(jLabel268)
                                    .addComponent(jLabel269)
                                    .addComponent(jLabel270)
                                    .addComponent(jLabel271)
                                    .addComponent(jLabel272))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel273)
                                    .addComponent(jLabel274)
                                    .addComponent(jLabel275)
                                    .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel276)
                                    .addComponent(jLabel277)
                                    .addComponent(jLabel278)
                                    .addComponent(jLabel279)
                                    .addComponent(jLabel280))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel281)
                                    .addComponent(jLabel282)
                                    .addComponent(jLabel283)
                                    .addComponent(jTextField161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(586, 586, 586)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton17)
                                    .addComponent(jButton18)
                                    .addComponent(jButton19)
                                    .addComponent(jButton20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpesqFa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel216))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel284)
                            .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField140, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jTextField135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel143)
                                .addGap(3, 3, 3)
                                .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(txtECivFa2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel146)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel147)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel148)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel149)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel150))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel151)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel152)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel153)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel154)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel155)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel156)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel157))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel158)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel159)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel160)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                                                .addComponent(Esportes2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel161)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel162))
                                            .addComponent(jTextField90, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel163)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel164)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel165)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel166)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel167))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel171)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel172)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel173)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                .addGap(301, 301, 301)
                                                .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel168)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel169)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel170)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                    .addComponent(jButton13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton14)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton15)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton16))
                                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                    .addComponent(jLabel145)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtpesqFa3))
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGap(484, 484, 484)
                                        .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel174)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel175)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel176)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel177)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel178)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel179)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel180)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel181)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel182)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel183))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel184)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel185)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel186)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel187)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel188)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel189)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel190)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel191)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel192))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel193)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel195)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField115, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel194)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel196)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel197)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel198)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel199)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel200)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel201))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel202)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField117, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel203)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField118, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel204)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel205)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel206)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel207)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel208)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel209))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel210)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel211)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField121, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel212)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel213)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField123, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 794, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 794, Short.MAX_VALUE)))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel143)
                    .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel144)
                    .addComponent(txtECivFa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel146)
                                    .addComponent(jLabel147)
                                    .addComponent(jLabel148)
                                    .addComponent(jLabel149)
                                    .addComponent(jLabel150))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel151)
                                    .addComponent(jLabel152)
                                    .addComponent(jLabel153)
                                    .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel154)
                                    .addComponent(jLabel155)
                                    .addComponent(jLabel156)
                                    .addComponent(jLabel157))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel158)
                                    .addComponent(jLabel159)
                                    .addComponent(jLabel160)
                                    .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Esportes2)
                                            .addComponent(jLabel161)
                                            .addComponent(jLabel162)
                                            .addComponent(jLabel163)
                                            .addComponent(jLabel164)
                                            .addComponent(jLabel165)
                                            .addComponent(jLabel166)
                                            .addComponent(jLabel167)
                                            .addComponent(jLabel168)
                                            .addComponent(jLabel169)
                                            .addComponent(jLabel170))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel171)
                                            .addComponent(jLabel172)
                                            .addComponent(jLabel173)
                                            .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(11, 11, 11)
                                .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel174)
                                    .addComponent(jLabel175)
                                    .addComponent(jLabel176)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel178)
                                    .addComponent(jLabel179)
                                    .addComponent(jLabel180)
                                    .addComponent(jLabel181)
                                    .addComponent(jLabel182)
                                    .addComponent(jLabel183))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel184)
                                    .addComponent(jLabel185)
                                    .addComponent(jLabel186)
                                    .addComponent(jLabel187)
                                    .addComponent(jLabel188)
                                    .addComponent(jLabel189)
                                    .addComponent(jLabel190)
                                    .addComponent(jLabel191)
                                    .addComponent(jLabel192))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel193)
                                    .addComponent(jLabel195)
                                    .addComponent(jLabel194)
                                    .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel196)
                                    .addComponent(jLabel197)
                                    .addComponent(jLabel198)
                                    .addComponent(jLabel199)
                                    .addComponent(jLabel200)
                                    .addComponent(jLabel201))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel202)
                                    .addComponent(jLabel203)
                                    .addComponent(jLabel204)
                                    .addComponent(jTextField117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel205)
                                    .addComponent(jLabel206)
                                    .addComponent(jLabel207)
                                    .addComponent(jLabel208)
                                    .addComponent(jLabel209))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel210)
                                    .addComponent(jLabel211)
                                    .addComponent(jLabel212)
                                    .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(586, 586, 586)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton13)
                                    .addComponent(jButton14)
                                    .addComponent(jButton15)
                                    .addComponent(jButton16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpesqFa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel145))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel213)
                            .addComponent(jTextField123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 618, 0, 0));

        jTextField165.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField165.setText("A:");
        getContentPane().add(jTextField165, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 26, -1));

        jTextField166.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField166.setText("B:");
        getContentPane().add(jTextField166, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 26, -1));

        jTextField167.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jTextField167.setText("C:");
        getContentPane().add(jTextField167, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 26, -1));
        getContentPane().add(txtOutros1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 54, -1));
        getContentPane().add(txtOutros2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 54, -1));
        getContentPane().add(txtOutros3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 54, -1));

        jLabel285.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel285.setText("Trabalhos Manuais");
        getContentPane().add(jLabel285, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        jLabel286.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel286.setText("Multimidia");
        getContentPane().add(jLabel286, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, -1, -1));

        jLabel287.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel287.setText("Gráficos");
        getContentPane().add(jLabel287, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, -1, -1));

        jLabel288.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel288.setText("Fotografia");
        getContentPane().add(jLabel288, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, -1, -1));

        jLabel289.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel289.setText("Decoração");
        getContentPane().add(jLabel289, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 300, -1, -1));

        jLabel291.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel291.setText("1:");
        getContentPane().add(jLabel291, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, 20, 20));
        getContentPane().add(txtArtes1_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 90, 30));

        jLabel292.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel292.setText("2:");
        getContentPane().add(jLabel292, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 20, -1));
        getContentPane().add(txtArtes2_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 86, 30));

        jLabel293.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel293.setText("3:");
        getContentPane().add(jLabel293, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 320, -1, -1));
        getContentPane().add(txtArtes3_fa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 86, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFich_acomp_fa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFich_acomp_fa2MouseClicked
        mostraItem();
    }//GEN-LAST:event_tblFich_acomp_fa2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            cadastrarfrmFicha_fase2();
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            editarfrmFicha_fase2();
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        deletefrmFicha_fase2();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtPesq_fa2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq_fa2KeyReleased
        pesquisarfrmFicha_fase2();
    }//GEN-LAST:event_txtPesq_fa2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmFicha_fase2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmFicha_fase2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Esportes;
    private javax.swing.JLabel Esportes1;
    private javax.swing.JLabel Esportes2;
    private javax.swing.JLabel Esportes3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1Fa2;
    private javax.swing.JTable jTable1Fa3;
    private javax.swing.JTable jTable1Fa4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField105;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField123;
    private javax.swing.JTextField jTextField124;
    private javax.swing.JTextField jTextField125;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField128;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField130;
    private javax.swing.JTextField jTextField131;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField134;
    private javax.swing.JTextField jTextField135;
    private javax.swing.JTextField jTextField136;
    private javax.swing.JTextField jTextField137;
    private javax.swing.JTextField jTextField138;
    private javax.swing.JTextField jTextField139;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField140;
    private javax.swing.JTextField jTextField141;
    private javax.swing.JTextField jTextField142;
    private javax.swing.JTextField jTextField143;
    private javax.swing.JTextField jTextField144;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField149;
    private javax.swing.JTextField jTextField150;
    private javax.swing.JTextField jTextField151;
    private javax.swing.JTextField jTextField152;
    private javax.swing.JTextField jTextField153;
    private javax.swing.JTextField jTextField154;
    private javax.swing.JTextField jTextField155;
    private javax.swing.JTextField jTextField156;
    private javax.swing.JTextField jTextField157;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JTextField jTextField91;
    private javax.swing.JTextField jTextField92;
    private javax.swing.JTextField jTextField93;
    private javax.swing.JTextField jTextField94;
    private javax.swing.JTextField jTextField95;
    private javax.swing.JTextField jTextField96;
    private javax.swing.JTextField jTextField97;
    private javax.swing.JTextField jTextField98;
    private javax.swing.JTextField jTextField99;
    private javax.swing.JTable tblFich_acomp_fa2;
    private javax.swing.JTextField txtArtes1_fa2;
    private javax.swing.JTextField txtArtes2_fa2;
    private javax.swing.JTextField txtArtes3_fa2;
    private javax.swing.JTextField txtAux_Geral1_fa2;
    private javax.swing.JTextField txtAux_Geral2_fa2;
    private javax.swing.JTextField txtAux_Geral3_fa2;
    private javax.swing.JTextField txtCod_fa2;
    private javax.swing.JTextField txtECivFa1;
    private javax.swing.JTextField txtECivFa2;
    private javax.swing.JTextField txtECivFa3;
    private javax.swing.JTextField txtEns_Assist1_fa2;
    private javax.swing.JTextField txtEns_Assist2_fa2;
    private javax.swing.JTextField txtEns_Assist3_fa2;
    private javax.swing.JTextField txtEsc1_fa2;
    private javax.swing.JTextField txtEsc2_fa2;
    private javax.swing.JTextField txtEsc3_fa2;
    private javax.swing.JTextField txtInc_Event_Expo_fa2;
    private javax.swing.JTextField txtMin_Ind1_fa2;
    private javax.swing.JTextField txtMin_Ind2_fa2;
    private javax.swing.JTextField txtMin_Ind3_fa2;
    private javax.swing.JTextField txtNome_fa2;
    private javax.swing.JTextField txtOutros1_fa2;
    private javax.swing.JTextField txtOutros2_fa2;
    private javax.swing.JTextField txtOutros3_fa2;
    private javax.swing.JTextField txtPesq_fa2;
    private javax.swing.JTextField txtServ_Prof1_fa2;
    private javax.swing.JTextField txtServ_Prof2_fa2;
    private javax.swing.JTextField txtServ_Prof3_fa2;
    private javax.swing.JTextField txtTeatro1_fa2;
    private javax.swing.JTextField txtTeatro2_fa2;
    private javax.swing.JTextField txtTeatro3_fa2;
    private javax.swing.JTextField txtTrab_Com1_fa2;
    private javax.swing.JTextField txtTrab_Com2_fa2;
    private javax.swing.JTextField txtTrab_Com3_fa2;
    private javax.swing.JTextField txtpesqFa2;
    private javax.swing.JTextField txtpesqFa3;
    private javax.swing.JTextField txtpesqFa4;
    // End of variables declaration//GEN-END:variables
}
