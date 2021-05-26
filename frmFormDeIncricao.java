package Visual;

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

public class frmFormDeIncricao extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmFormDeIncricao() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 10);
        conecta = ConectaBD.conectabd();
        listaFormDeIncricao();
    }

    public void cadastrarFormDeIncricao() throws SQLException {

        String sql = "Insert into form_inc_svg(nome,endereco,number,bairro,cep,cel,email,filho,membro_get_temp,qual,get_min_temp,qual_outra,outra_min_temp,civil,escolaridade,memb_outra_igreja,aux_min_get) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNomefi.getText());
            pst.setString(2, txtEnderecofi.getText());
            pst.setString(3, txtNumerofi.getText());
            pst.setString(4, txtBairrofi.getText());
            pst.setString(5, txtCepfi.getText());
            pst.setString(6, txtCelfi.getText());
            pst.setString(7, txtEmailfi.getText());
            pst.setString(8, txtFilhosfi.getText());
            pst.setString(9, txtTempo_1_fi.getText());
            pst.setString(10, txtQual_1_fi.getText());
            pst.setString(11, txtTempo_2_fi.getText());
            pst.setString(12, txtQual_2_fi.getText());
            pst.setString(13, txtTempo_3_fi.getText());
            pst.setString(14, txtCivilfi.getText());
            pst.setString(15, txtEscolaridadefi.getText());
            pst.setString(16, txtMemb_outra_igreja_fi.getText());
            pst.setString(17, txtMembro_Get_fi.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listaFormDeIncricao();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void listaFormDeIncricao() {

        String sql = "Select * from form_inc_svg order by codigo_1 Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            TbformInscfi.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }

    }

    public void pesquisarFormDeIncricao() {
        String sql = "Select * from form_inc_svg where nome like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPesquisafi.getText() + "%");
            rs = pst.executeQuery();
            TbformInscfi.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {

        int seleciona = TbformInscfi.getSelectedRow();
        txtCodigofi.setText(TbformInscfi.getModel().getValueAt(seleciona, 0).toString());
        txtNomefi.setText(TbformInscfi.getModel().getValueAt(seleciona, 1).toString());
        txtEnderecofi.setText(TbformInscfi.getModel().getValueAt(seleciona, 2).toString());
        txtNumerofi.setText(TbformInscfi.getModel().getValueAt(seleciona, 3).toString());
        txtBairrofi.setText(TbformInscfi.getModel().getValueAt(seleciona, 4).toString());
        txtCepfi.setText(TbformInscfi.getModel().getValueAt(seleciona, 5).toString());
        txtCelfi.setText(TbformInscfi.getModel().getValueAt(seleciona, 6).toString());
        txtEmailfi.setText(TbformInscfi.getModel().getValueAt(seleciona, 7).toString());
        txtFilhosfi.setText(TbformInscfi.getModel().getValueAt(seleciona, 8).toString());
        txtTempo_1_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 9).toString());
        txtQual_1_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 10).toString());
        txtTempo_2_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 11).toString());
        txtQual_2_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 12).toString());
        txtTempo_3_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 13).toString());
        txtCivilfi.setText(TbformInscfi.getModel().getValueAt(seleciona, 14).toString());
        txtEscolaridadefi.setText(TbformInscfi.getModel().getValueAt(seleciona, 15).toString());
        txtMemb_outra_igreja_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 16).toString());
        txtMembro_Get_fi.setText(TbformInscfi.getModel().getValueAt(seleciona, 17).toString());
    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1, 30, 20, 20, 30);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela FORMULÁRIO DE INSCRIÇÃO.pdf");

        String sql = "Select * from form_inc_svg";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("FORMULÁRIO DE INSCRIÇÃO - SERVIÇO VOLUNTÁRIO GETSÊMANI\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(18);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("Relatório de Atendimento"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(18);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Nome");
            tabela.addCell("Endereco");
            tabela.addCell("Numero");
            tabela.addCell("Bairro");
            tabela.addCell("cep");
            tabela.addCell("Cel");
            tabela.addCell("Email");
            tabela.addCell("Filhos");
            tabela.addCell("TempoMG");
            tabela.addCell("QualAMG");
            tabela.addCell("TempoAMG");
            tabela.addCell("QualAMOI");
            tabela.addCell("TempoAMOI");
            tabela.addCell("Civil");
            tabela.addCell("Escolaridade");
            tabela.addCell("Memb_outra_igreja");
            tabela.addCell("Membro_Get");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo_1")));
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("endereco"));
                tabela.addCell(rs.getString("number"));
                tabela.addCell(rs.getString("bairro"));
                tabela.addCell(rs.getString("cep"));
                tabela.addCell(rs.getString("cel"));
                tabela.addCell(rs.getString("email"));
                tabela.addCell(rs.getString("filho"));
                tabela.addCell(rs.getString("membro_get_temp"));
                tabela.addCell(rs.getString("qual"));
                tabela.addCell(rs.getString("get_min_temp"));
                tabela.addCell(rs.getString("qual_outra"));
                tabela.addCell(rs.getString("outra_min_temp"));
                tabela.addCell(rs.getString("civil"));
                tabela.addCell(rs.getString("escolaridade"));
                tabela.addCell(rs.getString("memb_outra_igreja"));
                tabela.addCell(rs.getString("aux_min_get"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela FORMULÁRIO DE INSCRIÇÃO.pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {
        txtCodigofi.setText("");
        txtNomefi.setText("");
        txtEnderecofi.setText("");
        txtNumerofi.setText("");
        txtBairrofi.setText("");
        txtCepfi.setText("");
        txtCelfi.setText("");
        txtEmailfi.setText("");
        txtFilhosfi.setText("");
        txtTempo_1_fi.setText("");
        txtQual_1_fi.setText("");
        txtTempo_2_fi.setText("");
        txtQual_2_fi.setText("");
        txtTempo_3_fi.setText("");
        txtCivilfi.setText("");
        txtEscolaridadefi.setText("");
        txtMemb_outra_igreja_fi.setText("");
        txtMembro_Get_fi.setText("");
    }

    public void editarFormDeIncricao() {
        String sql = "Update form_inc_svg set nome = ?,endereco = ?,number = ?,bairro = ?,cep = ?,cel = ?,email = ?,filho = ?,membro_get_temp = ?,qual = ?,get_min_temp = ?,qual_outra = ?,outra_min_temp = ?,civil = ?,escolaridade = ?,memb_outra_igreja = ?,aux_min_get = ? where codigo_1 = ? ";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtNomefi.getText());
            pst.setString(2, txtEnderecofi.getText());
            pst.setString(3, txtNumerofi.getText());
            pst.setString(4, txtBairrofi.getText());
            pst.setString(5, txtCepfi.getText());
            pst.setString(6, txtCelfi.getText());
            pst.setString(7, txtEmailfi.getText());
            pst.setString(8, txtFilhosfi.getText());
            pst.setString(9, txtTempo_1_fi.getText());
            pst.setString(10, txtQual_1_fi.getText());
            pst.setString(11, txtTempo_2_fi.getText());
            pst.setString(12, txtQual_2_fi.getText());
            pst.setString(13, txtTempo_3_fi.getText());
            pst.setString(14, txtCivilfi.getText());
            pst.setString(15, txtEscolaridadefi.getText());
            pst.setString(16, txtMemb_outra_igreja_fi.getText());
            pst.setString(17, txtMembro_Get_fi.getText());
            pst.setInt(18, Integer.parseInt(txtCodigofi.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            listaFormDeIncricao();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void deleteFormDeIncricao() {
        String sql = "Delete from form_inc_svg where codigo_1 = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigofi.getText()));
            pst.execute();
            listaFormDeIncricao();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCodigofi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomefi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEnderecofi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumerofi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBairrofi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCelfi = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmailfi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCivilfi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFilhosfi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEscolaridadefi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTempo_1_fi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMembro_Get_fi = new javax.swing.JTextField();
        txtTempo_2_fi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtQual_1_fi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMemb_outra_igreja_fi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtQual_2_fi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTempo_3_fi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtPesquisafi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbformInscfi = new javax.swing.JTable();
        txtCepfi = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulario de Incrição");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORMULÁRIO DE INSCRIÇÃO - SERVIÇO VOLUNTÁRIO GETSÊMANI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 11, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("CODIGO : ");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 66, -1, -1));

        txtCodigofi.setBackground(new java.awt.Color(0, 153, 255));
        txtCodigofi.setEnabled(false);
        getContentPane().add(txtCodigofi, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 65, 33, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("NOME : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 66, -1, -1));
        getContentPane().add(txtNomefi, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 65, 567, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("ENDEREÇO : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 97, -1, -1));
        getContentPane().add(txtEnderecofi, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 96, 452, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Nº :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 97, -1, -1));
        getContentPane().add(txtNumerofi, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 96, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("BAIRRO :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 128, -1, -1));
        getContentPane().add(txtBairrofi, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 127, 262, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("CEP.:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 128, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("CEL.:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 128, -1, -1));

        try {
            txtCelfi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCelfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 127, 163, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("E-MAIL :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 159, -1, -1));
        getContentPane().add(txtEmailfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 158, 380, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("ESTADO CIVIL :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));
        getContentPane().add(txtCivilfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("FILHOS :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));
        getContentPane().add(txtFilhosfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 192, 180, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("ESCOLARIDADE :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));
        getContentPane().add(txtEscolaridadefi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 344, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("MEMBRO DA GETSÊMANI A A QUNATO TEMPO ?");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 276, -1, -1));
        getContentPane().add(txtTempo_1_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 190, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("JÁ AUXILIOU EM ALGUM MINISTÉRIO NA GETSÊMANI ?");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 317, -1, -1));
        getContentPane().add(txtMembro_Get_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 130, 30));
        getContentPane().add(txtTempo_2_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 110, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("POR QUANTO TEMPO ?");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 346, -1, -1));
        getContentPane().add(txtQual_1_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 345, 120, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("QUAL ?");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 346, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("JÁ AUXILIOU EM ALGUM MINISTÉRIO EM OUTRA IGREJA ?");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 379, -1, -1));
        getContentPane().add(txtMemb_outra_igreja_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 130, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("QUAL ?");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 407, -1, -1));
        getContentPane().add(txtQual_2_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 406, 120, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("POR QUANTO TEMPO ?");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 407, -1, -1));
        getContentPane().add(txtTempo_3_fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 406, 90, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 180, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 220, 130, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton3.setText("DELETAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 260, 130, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton4.setText("LIMPAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 130, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel19.setText("PESQUISAR :");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        txtPesquisafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisafiActionPerformed(evt);
            }
        });
        txtPesquisafi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisafiKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisafi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 652, -1));

        TbformInscfi.setModel(new javax.swing.table.DefaultTableModel(
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
        TbformInscfi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbformInscfiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbformInscfi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 1170, 98));

        try {
            txtCepfi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(" #####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCepfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 122, 90, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 130, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("AREA DE AFINIDADE: ");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 90, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            cadastrarFormDeIncricao();
        } catch (SQLException ex) {
            Logger.getLogger(frmFormDeIncricao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarFormDeIncricao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteFormDeIncricao();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPesquisafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisafiActionPerformed
        pesquisarFormDeIncricao();
    }//GEN-LAST:event_txtPesquisafiActionPerformed

    private void TbformInscfiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbformInscfiMouseClicked
        mostraItem();
    }//GEN-LAST:event_TbformInscfiMouseClicked

    private void txtPesquisafiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisafiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisafiKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmFormDeIncricao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFormDeIncricao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmFormDeIncricao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbformInscfi;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtBairrofi;
    private javax.swing.JFormattedTextField txtCelfi;
    private javax.swing.JFormattedTextField txtCepfi;
    private javax.swing.JTextField txtCivilfi;
    private javax.swing.JTextField txtCodigofi;
    private javax.swing.JTextField txtEmailfi;
    private javax.swing.JTextField txtEnderecofi;
    private javax.swing.JTextField txtEscolaridadefi;
    private javax.swing.JTextField txtFilhosfi;
    private javax.swing.JTextField txtMemb_outra_igreja_fi;
    private javax.swing.JTextField txtMembro_Get_fi;
    private javax.swing.JTextField txtNomefi;
    private javax.swing.JTextField txtNumerofi;
    private javax.swing.JTextField txtPesquisafi;
    private javax.swing.JTextField txtQual_1_fi;
    private javax.swing.JTextField txtQual_2_fi;
    private javax.swing.JTextField txtTempo_1_fi;
    private javax.swing.JTextField txtTempo_2_fi;
    private javax.swing.JTextField txtTempo_3_fi;
    // End of variables declaration//GEN-END:variables
}
