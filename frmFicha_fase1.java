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

public class frmFicha_fase1 extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmFicha_fase1() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 10);
        conecta = ConectaBD.conectabd();
        listafrmFicha_fase1();
    }

    public void pesquisarfrmFicha_fase1() {
        String sql = "Select * from fich_ind_acomp where nome like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPesqfa.getText() + "%");
            rs = pst.executeQuery();
            TBable1Fa.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void listafrmFicha_fase1() {

        String sql = "Select * from fich_ind_acomp order by codigo_3 Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            TBable1Fa.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void deletefrmFicha_fase1() {
        String sql = "Delete from fich_ind_acomp where codigo_3 = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigofa.getText()));
            pst.execute();
            listafrmFicha_fase1();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void cadastrarfrmFicha_fase1() throws SQLException {

        String sql = "Insert into fich_ind_acomp (nome,data_entrev,email_fich_ind,min_ind,tel_fich_ind,cont_lider,endereco,feed_back,est_civil,filho,min_paix,m_dom_esp1,m_dom_esp2,m_dom_esp3,m_est_pessoal,poss_min1,poss_min2,poss_min3,poss_min4,poss_min5,m_disp,horario,gost_sab_min_get,part_min_outra,q_outra,part_min_get,q_get ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNomeFa.getText());
            pst.setString(2, txtEntrevistaFa.getText());
            pst.setString(3, txtEmailFa.getText());
            pst.setString(4, txtMindFa.getText());
            pst.setString(5, txtTelefoneFa.getText());
            pst.setString(6, txtClidFa.getText());
            pst.setString(7, txtEnderecoFa.getText());
            pst.setString(8, txtFeedbackfa.getText());
            pst.setString(9, txtECivFa.getText());
            pst.setString(10, txtFilhosFa.getText());
            pst.setString(11, txtMPaiMinFa.getText());
            pst.setString(12, txtMDEspFa1.getText());
            pst.setString(13, txtMDEspFa2.getText());
            pst.setString(14, txtMDEspFa3.getText());
            pst.setString(15, txtMePessFa.getText());
            pst.setString(16, txtPossMnIgrFa1.getText());
            pst.setString(17, txtPossMnIgrFa2.getText());
            pst.setString(18, txtPossMnIgrFa3.getText());
            pst.setString(19, txtPossMnIgrFa4.getText());
            pst.setString(20, txtPossMnIgrFa5.getText());
            pst.setString(21, txtMdispFa.getText());
            pst.setString(22, txtHorariofa.getText());
            pst.setString(23, txtGsMinIgrFa.getText());
            pst.setString(24, txtFpoutIgFa.getText());
            pst.setString(25, txtFpoutIgQuFa.getText());
            pst.setString(26, txtFpIgFa.getText());
            pst.setString(27, txtFpIgQuFa.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listafrmFicha_fase1();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {
        int seleciona = TBable1Fa.getSelectedRow();
        txtCodigofa.setText(TBable1Fa.getModel().getValueAt(seleciona, 0).toString());
        txtNomeFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 1).toString());
        txtEntrevistaFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 2).toString());
        txtEmailFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 3).toString());
        txtMindFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 4).toString());
        txtTelefoneFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 5).toString());
        txtClidFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 6).toString());
        txtEnderecoFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 7).toString());
        txtFeedbackfa.setText(TBable1Fa.getModel().getValueAt(seleciona, 8).toString());
        txtECivFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 9).toString());
        txtFilhosFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 10).toString());
        txtMPaiMinFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 11).toString());
        txtMDEspFa1.setText(TBable1Fa.getModel().getValueAt(seleciona, 12).toString());
        txtMDEspFa2.setText(TBable1Fa.getModel().getValueAt(seleciona, 13).toString());
        txtMDEspFa3.setText(TBable1Fa.getModel().getValueAt(seleciona, 14).toString());
        txtMePessFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 15).toString());
        txtPossMnIgrFa1.setText(TBable1Fa.getModel().getValueAt(seleciona, 16).toString());
        txtPossMnIgrFa2.setText(TBable1Fa.getModel().getValueAt(seleciona, 17).toString());
        txtPossMnIgrFa3.setText(TBable1Fa.getModel().getValueAt(seleciona, 18).toString());
        txtPossMnIgrFa4.setText(TBable1Fa.getModel().getValueAt(seleciona, 19).toString());
        txtPossMnIgrFa5.setText(TBable1Fa.getModel().getValueAt(seleciona, 20).toString());
        txtMdispFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 21).toString());
        txtHorariofa.setText(TBable1Fa.getModel().getValueAt(seleciona, 22).toString());
        txtGsMinIgrFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 23).toString());
        txtFpoutIgFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 24).toString());
        txtFpoutIgQuFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 25).toString());
        txtFpIgFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 26).toString());
        txtFpIgQuFa.setText(TBable1Fa.getModel().getValueAt(seleciona, 27).toString());
    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase1).pdf");

        String sql = "Select * from fich_ind_acomp";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO - SERVIÇO VOLUNTÁRIO(Fase1)\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(28);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("FICHA INDIVIDUAL DE ACOMPANHAMENTO"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(28);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Nome");
            tabela.addCell("Entrevista");
            tabela.addCell("Email");
            tabela.addCell("M-indicado");
            tabela.addCell("Telefone");
            tabela.addCell("Lider-Cont");
            tabela.addCell("Endereco");
            tabela.addCell("Feedback");
            tabela.addCell("Civil");
            tabela.addCell("Filhos");
            tabela.addCell("Paixão-Min");
            tabela.addCell("D.Espirituais1");
            tabela.addCell("D.Espirituais2");
            tabela.addCell("D.Espirituais3");
            tabela.addCell("Estilo-P");
            tabela.addCell("Ministerios1");
            tabela.addCell("Ministerios2");
            tabela.addCell("Ministerios3");
            tabela.addCell("Ministerios4");
            tabela.addCell("Ministerios5");
            tabela.addCell("Disponimilidade");
            tabela.addCell("Horario");
            tabela.addCell("Infor-Ministerio");
            tabela.addCell("Ministerio-outra Igreja");
            tabela.addCell("Qual_outra Igreja");
            tabela.addCell("Ministerio-Gete");
            tabela.addCell("Qual_Gete");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo_3")));
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("data_entrev"));
                tabela.addCell(rs.getString("email_fich_ind"));
                tabela.addCell(rs.getString("min_ind"));
                tabela.addCell(rs.getString("tel_fich_ind"));
                tabela.addCell(rs.getString("cont_lider"));
                tabela.addCell(rs.getString("endereco"));
                tabela.addCell(rs.getString("feed_back"));
                tabela.addCell(rs.getString("est_civil"));
                tabela.addCell(rs.getString("filho"));
                tabela.addCell(rs.getString("min_paix"));
                tabela.addCell(rs.getString("m_dom_esp1"));
                tabela.addCell(rs.getString("m_dom_esp2"));
                tabela.addCell(rs.getString("m_dom_esp3"));
                tabela.addCell(rs.getString("m_est_pessoal"));
                tabela.addCell(rs.getString("poss_min1"));
                tabela.addCell(rs.getString("poss_min2"));
                tabela.addCell(rs.getString("poss_min3"));
                tabela.addCell(rs.getString("poss_min4"));
                tabela.addCell(rs.getString("poss_min5"));
                tabela.addCell(rs.getString("m_disp"));
                tabela.addCell(rs.getString("horario"));
                tabela.addCell(rs.getString("gost_sab_min_get"));
                tabela.addCell(rs.getString("part_min_outra"));
                tabela.addCell(rs.getString("q_outra"));
                tabela.addCell(rs.getString("part_min_get"));
                tabela.addCell(rs.getString("q_get"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela FICHA INDIVIDUAL DE ACOMPANHAMENTO(Fase1).pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {

        txtCodigofa.setText("");
        txtNomeFa.setText("");
        txtEntrevistaFa.setText("");
        txtEmailFa.setText("");
        txtMindFa.setText("");
        txtTelefoneFa.setText("");
        txtClidFa.setText("");
        txtEnderecoFa.setText("");
        txtFeedbackfa.setText("");
        txtECivFa.setText("");
        txtFilhosFa.setText("");
        txtMPaiMinFa.setText("");
        txtMDEspFa1.setText("");
        txtMDEspFa2.setText("");
        txtMDEspFa3.setText("");
        txtMePessFa.setText("");
        txtPossMnIgrFa1.setText("");
        txtPossMnIgrFa2.setText("");
        txtPossMnIgrFa3.setText("");
        txtPossMnIgrFa4.setText("");
        txtPossMnIgrFa5.setText("");
        txtMdispFa.setText("");
        txtHorariofa.setText("");
        txtGsMinIgrFa.setText("");
        txtFpoutIgFa.setText("");
        txtFpoutIgQuFa.setText("");
        txtFpIgFa.setText("");
        txtFpIgQuFa.setText("");
    }

    public void editarfrmFicha_fase1() {
        String sql = "Update fich_ind_acomp set nome = ?,data_entrev = ?,email_fich_ind = ?,min_ind = ?,tel_fich_ind = ?,cont_lider = ?,endereco = ?,feed_back = ?,est_civil = ?,filho = ?,min_paix = ?,m_dom_esp1 = ?,m_dom_esp2 = ?,m_dom_esp3 = ?,m_est_pessoal = ?,poss_min1 = ?,poss_min2 = ?,poss_min3 = ?,poss_min4 = ?,poss_min5 = ?,m_disp = ?,horario = ?,gost_sab_min_get = ?,part_min_outra = ?,q_outra = ?,part_min_get = ?,q_get = ?  where codigo_3 = ? ";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNomeFa.getText());
            pst.setString(2, txtEntrevistaFa.getText());
            pst.setString(3, txtEmailFa.getText());
            pst.setString(4, txtMindFa.getText());
            pst.setString(5, txtTelefoneFa.getText());
            pst.setString(6, txtClidFa.getText());
            pst.setString(7, txtEnderecoFa.getText());
            pst.setString(8, txtFeedbackfa.getText());
            pst.setString(9, txtECivFa.getText());
            pst.setString(10, txtFilhosFa.getText());
            pst.setString(11, txtMPaiMinFa.getText());
            pst.setString(12, txtMDEspFa1.getText());
            pst.setString(13, txtMDEspFa2.getText());
            pst.setString(14, txtMDEspFa3.getText());
            pst.setString(15, txtMePessFa.getText());
            pst.setString(16, txtPossMnIgrFa1.getText());
            pst.setString(17, txtPossMnIgrFa2.getText());
            pst.setString(18, txtPossMnIgrFa3.getText());
            pst.setString(19, txtPossMnIgrFa4.getText());
            pst.setString(20, txtPossMnIgrFa5.getText());
            pst.setString(21, txtMdispFa.getText());
            pst.setString(22, txtHorariofa.getText());
            pst.setString(23, txtGsMinIgrFa.getText());
            pst.setString(24, txtFpoutIgFa.getText());
            pst.setString(25, txtFpoutIgQuFa.getText());
            pst.setString(26, txtFpIgFa.getText());
            pst.setString(27, txtFpIgQuFa.getText());
            pst.setInt(28, Integer.parseInt(txtCodigofa.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            listafrmFicha_fase1();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmailFa = new javax.swing.JTextField();
        txtEnderecoFa = new javax.swing.JTextField();
        txtECivFa = new javax.swing.JTextField();
        txtFilhosFa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMindFa = new javax.swing.JTextField();
        txtClidFa = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMPaiMinFa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMDEspFa1 = new javax.swing.JTextField();
        txtMDEspFa3 = new javax.swing.JTextField();
        txtMDEspFa2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMePessFa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPossMnIgrFa1 = new javax.swing.JTextField();
        txtPossMnIgrFa2 = new javax.swing.JTextField();
        txtPossMnIgrFa3 = new javax.swing.JTextField();
        txtPossMnIgrFa5 = new javax.swing.JTextField();
        txtPossMnIgrFa4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMdispFa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHorariofa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtGsMinIgrFa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtFpoutIgFa = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtFpoutIgQuFa = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtFpIgFa = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtFpIgQuFa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBable1Fa = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtCodigofa = new javax.swing.JTextField();
        txtFeedbackfa = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtNomeFa = new javax.swing.JTextField();
        txtPesqfa = new javax.swing.JTextField();
        txtTelefoneFa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtEntrevistaFa = new javax.swing.JFormattedTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Fase_1_Informações");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(914, 2423));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FICHA INDIVIDUAL DE ACOMPANHAMENTO - SERVIÇO VOLUNTÁRIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 0, -1, 31));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("NOME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 88, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("E-MAIL:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 55, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("TEL.:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 141, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("END.:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 142, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("ESTADO CIVIL :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 142, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("FILHOS :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 141, -1, -1));
        getContentPane().add(txtEmailFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 113, 160, -1));
        getContentPane().add(txtEnderecoFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 141, 159, -1));
        getContentPane().add(txtECivFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 141, 121, -1));
        getContentPane().add(txtFilhosFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 140, 165, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("DATA ENTREVISTA :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 88, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("MINISTÉRIO INDICADO :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 114, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("CONTATO LÍDER :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 115, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("FEEDBACK DO MINISTÉRIO INDICADO :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 168, -1, -1));
        getContentPane().add(txtMindFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 113, 143, -1));
        getContentPane().add(txtClidFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 114, 129, -1));

        jLabel12.setBackground(new java.awt.Color(51, 204, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fase_1 :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 60, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("1 - MINHA PAIXÃO MINISTÉRIAL É :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, -1, -1));
        getContentPane().add(txtMPaiMinFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 204, 82, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("2 - MEUS DONS ESPERITUAIS SÃO :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, -1, -1));

        txtMDEspFa1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtMDEspFa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 230, 82, -1));

        txtMDEspFa3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtMDEspFa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 230, 82, -1));

        txtMDEspFa2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtMDEspFa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 230, 82, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("3 - MEU ESTILO PESSOAL É :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 205, -1, -1));
        getContentPane().add(txtMePessFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 204, 132, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("4 - POSSÍVEIS MINISTÉRIOS QUE ME INTERESSAM EM NOSSA IGREJA :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 269, -1, -1));

        txtPossMnIgrFa1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtPossMnIgrFa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 303, 90, -1));

        txtPossMnIgrFa2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtPossMnIgrFa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 303, 90, -1));

        txtPossMnIgrFa3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtPossMnIgrFa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 303, 90, -1));

        txtPossMnIgrFa5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtPossMnIgrFa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 303, 90, -1));

        txtPossMnIgrFa4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(txtPossMnIgrFa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 303, 90, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("5 - MINHA DISPONIMILIDADE É :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 332, -1, -1));
        getContentPane().add(txtMdispFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 331, 116, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("HORÁRIO :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 332, -1, -1));
        getContentPane().add(txtHorariofa, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 331, 118, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("6 - GOSTARIA DE SABER MAIS SOBRE OS SEGUINTES MINISTÉRIOS DA IGREJA:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 358, 516, -1));
        getContentPane().add(txtGsMinIgrFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 357, 137, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("A - JÁ FEZ PARTE DE ALGUM MINISTÉRIO EM OUTRA IGREJA ?");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 384, -1, -1));
        getContentPane().add(txtFpoutIgFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 383, 51, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("QUAL ?");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 383, -1, -1));
        getContentPane().add(txtFpoutIgQuFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 383, 192, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setText("B - JÁ FEZ PARTE DE ALGUM MINISTÉRIO NA GETSÊMANI ?");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        getContentPane().add(txtFpIgFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 409, 74, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setText("QUAL ?");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 409, -1, -1));
        getContentPane().add(txtFpIgQuFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 409, 192, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 133, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton3.setText("DELETAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 133, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton4.setText("LIMPAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 133, -1));

        TBable1Fa.setModel(new javax.swing.table.DefaultTableModel(
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
        TBable1Fa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBable1FaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBable1Fa);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 473, 1030, 99));

        jLabel69.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel69.setText("PESQUISAR :");
        getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 448, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel70.setText("CODIGO :");
        getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));

        txtCodigofa.setBackground(new java.awt.Color(51, 204, 255));
        txtCodigofa.setEnabled(false);
        getContentPane().add(txtCodigofa, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 87, 30, -1));
        getContentPane().add(txtFeedbackfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 167, 606, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("1:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 234, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("2:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 234, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("3:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 234, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("5:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 307, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("4:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 307, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("3:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 307, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("2:");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 307, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("1:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 307, -1, -1));
        getContentPane().add(txtNomeFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 87, 226, -1));

        txtPesqfa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqfaKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesqfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 437, 460, 30));
        getContentPane().add(txtTelefoneFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 130, -1));

        try {
            txtEntrevistaFa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtEntrevistaFa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 70, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBable1FaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBable1FaMouseClicked
        mostraItem();
    }//GEN-LAST:event_TBable1FaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            cadastrarfrmFicha_fase1();
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarfrmFicha_fase1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deletefrmFicha_fase1();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPesqfaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqfaKeyReleased
        pesquisarfrmFicha_fase1();
    }//GEN-LAST:event_txtPesqfaKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmFicha_fase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFicha_fase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmFicha_fase1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBable1Fa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField txtClidFa;
    private javax.swing.JTextField txtCodigofa;
    private javax.swing.JTextField txtECivFa;
    private javax.swing.JTextField txtEmailFa;
    private javax.swing.JTextField txtEnderecoFa;
    private javax.swing.JFormattedTextField txtEntrevistaFa;
    private javax.swing.JTextField txtFeedbackfa;
    private javax.swing.JTextField txtFilhosFa;
    private javax.swing.JTextField txtFpIgFa;
    private javax.swing.JTextField txtFpIgQuFa;
    private javax.swing.JTextField txtFpoutIgFa;
    private javax.swing.JTextField txtFpoutIgQuFa;
    private javax.swing.JTextField txtGsMinIgrFa;
    private javax.swing.JTextField txtHorariofa;
    private javax.swing.JTextField txtMDEspFa1;
    private javax.swing.JTextField txtMDEspFa2;
    private javax.swing.JTextField txtMDEspFa3;
    private javax.swing.JTextField txtMPaiMinFa;
    private javax.swing.JTextField txtMdispFa;
    private javax.swing.JTextField txtMePessFa;
    private javax.swing.JTextField txtMindFa;
    private javax.swing.JTextField txtNomeFa;
    private javax.swing.JTextField txtPesqfa;
    private javax.swing.JTextField txtPossMnIgrFa1;
    private javax.swing.JTextField txtPossMnIgrFa2;
    private javax.swing.JTextField txtPossMnIgrFa3;
    private javax.swing.JTextField txtPossMnIgrFa4;
    private javax.swing.JTextField txtPossMnIgrFa5;
    private javax.swing.JTextField txtTelefoneFa;
    // End of variables declaration//GEN-END:variables

}
