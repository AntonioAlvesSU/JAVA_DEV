package Visual;

import proj.ConectaBD;
import java.sql.*;
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

public class frmRelAtendimento extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmRelAtendimento() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 10);
        conecta = ConectaBD.conectabd();
        listaRelAtendimento();
    }

    public void cadastrarRelAtendimento() {
        String sql = "Insert into vol_atendimento (data,culto,supervisor,memb1,memb2,memb3,memb4,memb5,memb6,med_atend_equip,alg_inf_s_repass,med_acomp_set_get,set_proc,mem_falt,dificul_pass_inf,sit_atipica,quant_abord,quant_captac) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtDatafa.getText());
            pst.setString(2, txtCultofa.getText());
            pst.setString(3, txtSupervisorafa.getText());
            pst.setString(4, txtMembro1fa.getText());
            pst.setString(5, txtMembro2fa.getText());
            pst.setString(6, txtMembro3fa.getText());
            pst.setString(7, txtMembro4fa.getText());
            pst.setString(8, txtMembro5fa.getText());
            pst.setString(9, txtMembro6fa.getText());
            pst.setString(10, txtMed_Atend_Equipfa.getText());
            pst.setString(11, txtAlg_Inf_S_Repassfa.getText());
            pst.setString(12, txtMed_Acomp_Set_Getfa.getText());
            pst.setString(13, txtSet_Procfa.getText());
            pst.setString(14, txtMem_Faltfa.getText());
            pst.setString(15, txtDificult_Pass_Inffa.getText());
            pst.setString(16, txtSit_Atipica1fa.getText());
            pst.setString(17, txtQuant_Abordfa.getText());
            pst.setString(18, txtQuant_Captacfa.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            listaRelAtendimento();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void listaRelAtendimento() {

        String sql = "Select * from vol_atendimento order by codigo_2 Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tbministeriofa.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }

    }

    public void pesquisarRelAtendimento() {
        String sql = "Select * from vol_atendimento where culto like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPesq_fa.getText() + "%");
            rs = pst.executeQuery();
            tbministeriofa.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostraItem() {
        int seleciona = tbministeriofa.getSelectedRow();
        txtCodigofa.setText(tbministeriofa.getModel().getValueAt(seleciona, 0).toString());
        txtDatafa.setText(tbministeriofa.getModel().getValueAt(seleciona, 1).toString());
        txtCultofa.setText(tbministeriofa.getModel().getValueAt(seleciona, 2).toString());
        txtSupervisorafa.setText(tbministeriofa.getModel().getValueAt(seleciona, 3).toString());
        txtMembro1fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 4).toString());
        txtMembro2fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 5).toString());
        txtMembro3fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 6).toString());
        txtMembro4fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 7).toString());
        txtMembro5fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 8).toString());
        txtMembro6fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 9).toString());
        txtMed_Atend_Equipfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 10).toString());
        txtAlg_Inf_S_Repassfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 11).toString());
        txtMed_Acomp_Set_Getfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 12).toString());
        txtSet_Procfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 13).toString());
        txtMem_Faltfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 14).toString());
        txtDificult_Pass_Inffa.setText(tbministeriofa.getModel().getValueAt(seleciona, 15).toString());
        txtSit_Atipica1fa.setText(tbministeriofa.getModel().getValueAt(seleciona, 16).toString());
        txtQuant_Abordfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 17).toString());
        txtQuant_Captacfa.setText(tbministeriofa.getModel().getValueAt(seleciona, 18).toString());

    }

    public void GerarPdf() throws FileNotFoundException, DocumentException, SQLException, IOException {
        Date date = new Date();
        date.toString();
        Document document = new Document(PageSize.A1, 30, 20, 20, 30);
        OutputStream outputStream = new FileOutputStream("C:/Users/Public/Gração de PDF´s/Tabela Atendimentos.pdf");

        String sql = "Select * from vol_atendimento";
        try {
            pst = conecta.prepareCall(sql);
            rs = pst.executeQuery();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph paragrafo = new Paragraph("MINISTÉRIOS DE VOLUNTÁRIOS\n\n");
            date.toString();
            document.add(new Paragraph(new Date().toString()));
            document.add(paragrafo);
            PdfPTable tabela = new PdfPTable(19);
            PdfPCell cabecalho = new PdfPCell(new Paragraph("Relatório de Atendimento"));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBorder(PdfPCell.NO_BORDER);
            cabecalho.setBackgroundColor(new BaseColor(100, 150, 200));
            cabecalho.setColspan(19);
            tabela.setWidthPercentage(100);
            tabela.getDefaultCell().setUseAscender(true);
            tabela.getDefaultCell().setUseDescender(true);
            tabela.addCell(cabecalho);
            tabela.addCell("Codigo");
            tabela.addCell("Data");
            tabela.addCell("Culto");
            tabela.addCell("Supervisor");
            tabela.addCell("Membro1              ");
            tabela.addCell("Membro2              ");
            tabela.addCell("Membro3              ");
            tabela.addCell("Membro4              ");
            tabela.addCell("Membro5              ");
            tabela.addCell("Membro6              ");
            tabela.addCell("1-Media Atendimento ");
            tabela.addCell("2-Inf_S/_Repassar ");
            tabela.addCell("3-Media Setores");
            tabela.addCell("4-Set_Procuardos");
            tabela.addCell("5-Faltas ");
            tabela.addCell("6-Informação s/ repassar");
            tabela.addCell("7-Situação Atipica");
            tabela.addCell("8-Abordagens");
            tabela.addCell("9-Captacões ");

            while (rs.next()) {
                tabela.addCell(Integer.toString(rs.getInt("codigo_2")));
                tabela.addCell(rs.getString("data"));
                tabela.addCell(rs.getString("culto"));
                tabela.addCell(rs.getString("supervisor"));
                tabela.addCell(rs.getString("memb1"));
                tabela.addCell(rs.getString("memb2"));
                tabela.addCell(rs.getString("memb2"));
                tabela.addCell(rs.getString("memb3"));
                tabela.addCell(rs.getString("memb4"));
                tabela.addCell(rs.getString("memb5"));
                tabela.addCell(rs.getString("memb6"));
                tabela.addCell(rs.getString("med_atend_equip"));
                tabela.addCell(rs.getString("alg_inf_s_repass"));
                tabela.addCell(rs.getString("med_acomp_set_get"));
                tabela.addCell(rs.getString("mem_falt"));
                tabela.addCell(rs.getString("dificul_pass_inf"));
                tabela.addCell(rs.getString("sit_atipica"));
                tabela.addCell(rs.getString("quant_abord"));
                tabela.addCell(rs.getString("quant_captac"));

            }

            document.add(tabela);
            Desktop.getDesktop().open(new File("C:/Users/Public/Gração de PDF´s/Tabela Atendimentos.pdf"));

        } catch (DocumentException ex) {
            Logger.getLogger(frmCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public void limparCampos() {
        txtCodigofa.setText("");
        txtDatafa.setText("");
        txtCultofa.setText("");
        txtSupervisorafa.setText("");
        txtMembro1fa.setText("");
        txtMembro2fa.setText("");
        txtMembro3fa.setText("");
        txtMembro4fa.setText("");
        txtMembro5fa.setText("");
        txtMembro6fa.setText("");
        txtMed_Atend_Equipfa.setText("");
        txtAlg_Inf_S_Repassfa.setText("");
        txtMed_Acomp_Set_Getfa.setText("");
        txtSet_Procfa.setText("");
        txtMem_Faltfa.setText("");
        txtDificult_Pass_Inffa.setText("");
        txtSit_Atipica1fa.setText("");
        txtQuant_Abordfa.setText("");
        txtQuant_Captacfa.setText("");
    }

    public void editarRelAtendimento() {
        String sql = "Update vol_atendimento set data = ?,culto = ?,supervisor = ?,memb1 = ?,memb2 = ?,memb3 = ?,memb4 = ?,memb5 = ?,memb6 = ?,med_atend_equip = ?,alg_inf_s_repass = ?,med_acomp_set_get = ?,set_proc = ?,mem_falt = ?,dificul_pass_inf = ?,sit_atipica = ?,quant_abord = ?,quant_captac = ?  where codigo_2 = ? ";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtDatafa.getText());
            pst.setString(2, txtCultofa.getText());
            pst.setString(3, txtSupervisorafa.getText());
            pst.setString(4, txtMembro1fa.getText());
            pst.setString(5, txtMembro2fa.getText());
            pst.setString(6, txtMembro3fa.getText());
            pst.setString(7, txtMembro4fa.getText());
            pst.setString(8, txtMembro5fa.getText());
            pst.setString(9, txtMembro6fa.getText());
            pst.setString(10, txtMed_Atend_Equipfa.getText());
            pst.setString(11, txtAlg_Inf_S_Repassfa.getText());
            pst.setString(12, txtMed_Acomp_Set_Getfa.getText());
            pst.setString(13, txtSet_Procfa.getText());
            pst.setString(14, txtMem_Faltfa.getText());
            pst.setString(15, txtDificult_Pass_Inffa.getText());
            pst.setString(16, txtSit_Atipica1fa.getText());
            pst.setString(17, txtQuant_Abordfa.getText());
            pst.setString(18, txtQuant_Captacfa.getText());
            pst.setInt(19, Integer.parseInt(txtCodigofa.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            listaRelAtendimento();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void deleteRelAtendimento() {
        String sql = "Delete from vol_atendimento where codigo_2 = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigofa.getText()));
            pst.execute();
            listaRelAtendimento();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDatafa = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSupervisorafa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMembro1fa = new javax.swing.JTextField();
        txtMembro2fa = new javax.swing.JTextField();
        txtMembro4fa = new javax.swing.JTextField();
        txtMembro3fa = new javax.swing.JTextField();
        txtMembro5fa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtMed_Atend_Equipfa = new javax.swing.JTextField();
        txtAlg_Inf_S_Repassfa = new javax.swing.JTextField();
        txtMed_Acomp_Set_Getfa = new javax.swing.JTextField();
        txtSet_Procfa = new javax.swing.JTextField();
        txtMem_Faltfa = new javax.swing.JTextField();
        txtDificult_Pass_Inffa = new javax.swing.JTextField();
        txtSit_Atipica1fa = new javax.swing.JTextField();
        txtQuant_Abordfa = new javax.swing.JTextField();
        txtQuant_Captacfa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbministeriofa = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodigofa = new javax.swing.JTextField();
        txtCultofa = new javax.swing.JTextField();
        txtMembro6fa = new javax.swing.JTextField();
        txtPesq_fa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MINISTÉRIOS DE VOLUNTÁRIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("DATA :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        try {
            txtDatafa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDatafa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 84, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("CULTO : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("SUPERVISOR : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));
        getContentPane().add(txtSupervisorafa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 182, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("EQUIPE :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        getContentPane().add(txtMembro1fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 80, -1));
        getContentPane().add(txtMembro2fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 80, -1));
        getContentPane().add(txtMembro4fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 90, -1));
        getContentPane().add(txtMembro3fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 80, -1));
        getContentPane().add(txtMembro5fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 90, -1));

        jLabel6.setBackground(new java.awt.Color(102, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("RELATÓRIO DE ATENDIMENTO :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("3 - EM MÉDIA, QUANTOS ACOMPANHAMENTOS A SETORES DA IGREJA FORAM FEITOS NESTE DIA ?");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("1 - EM MÉDIA , QUANTOS ATENDIMENTOS VOCÊ E SUA EQUIPE FIZERAM NESTE DIA?");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("2 - ALGUMA INFORMAÇÃO DEIXOU DE SER REPASSADA ? SE SIM , POR QUÊ?");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("4 - QUAIS FORAM OS SETORES MAIS PROCURADOS ?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("5 - FALTOU ALGUM MEMBRO DA EQUIPE ? SE SIM , HOUVE JUSTIFICATIVA?");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("6 - VOCÊ TEVE DIFICULDADE EM FORNECER ALGUMA INFORMAÇÃO ? SE SIM, EXPLIQUE O MOTIVO.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("7 - HOUVE ALGUMA SITUAÇÃO ATÍPICA QUE MEREÇA SER MENCIONADA ?");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("8 - QUANTAS ABORDAGENS ?");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("9 - QUANTAS CAPTAÇÕES?");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 220, 120, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 120, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton3.setText("DELETAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 120, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton4.setText("LIMPAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, 120, -1));
        getContentPane().add(txtMed_Atend_Equipfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 784, -1));
        getContentPane().add(txtAlg_Inf_S_Repassfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 784, -1));
        getContentPane().add(txtMed_Acomp_Set_Getfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 784, -1));
        getContentPane().add(txtSet_Procfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 784, -1));
        getContentPane().add(txtMem_Faltfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 784, -1));
        getContentPane().add(txtDificult_Pass_Inffa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 784, -1));
        getContentPane().add(txtSit_Atipica1fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 784, -1));
        getContentPane().add(txtQuant_Abordfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 100, -1));
        getContentPane().add(txtQuant_Captacfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 150, -1));

        tbministeriofa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbministeriofa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbministeriofaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbministeriofa);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 1380, 110));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel16.setText("PESQUISAR :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 110, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("CODIGO :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 118, -1, -1));

        txtCodigofa.setBackground(new java.awt.Color(0, 153, 204));
        txtCodigofa.setEnabled(false);
        getContentPane().add(txtCodigofa, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 117, 20, -1));
        getContentPane().add(txtCultofa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 140, -1));
        getContentPane().add(txtMembro6fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 90, -1));

        txtPesq_fa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesq_faKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesq_fa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 430, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/page_white_acrobat.png"))); // NOI18N
        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrarRelAtendimento();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarRelAtendimento();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteRelAtendimento();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbministeriofaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbministeriofaMouseClicked
        mostraItem();
    }//GEN-LAST:event_tbministeriofaMouseClicked

    private void txtPesq_faKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq_faKeyReleased
        pesquisarRelAtendimento();
    }//GEN-LAST:event_txtPesq_faKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            GerarPdf();
        } catch (DocumentException ex) {
            Logger.getLogger(frmRelAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmRelAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmRelAtendimento.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbministeriofa;
    private javax.swing.JTextField txtAlg_Inf_S_Repassfa;
    private javax.swing.JTextField txtCodigofa;
    private javax.swing.JTextField txtCultofa;
    private javax.swing.JFormattedTextField txtDatafa;
    private javax.swing.JTextField txtDificult_Pass_Inffa;
    private javax.swing.JTextField txtMed_Acomp_Set_Getfa;
    private javax.swing.JTextField txtMed_Atend_Equipfa;
    private javax.swing.JTextField txtMem_Faltfa;
    private javax.swing.JTextField txtMembro1fa;
    private javax.swing.JTextField txtMembro2fa;
    private javax.swing.JTextField txtMembro3fa;
    private javax.swing.JTextField txtMembro4fa;
    private javax.swing.JTextField txtMembro5fa;
    private javax.swing.JTextField txtMembro6fa;
    private javax.swing.JTextField txtPesq_fa;
    private javax.swing.JTextField txtQuant_Abordfa;
    private javax.swing.JTextField txtQuant_Captacfa;
    private javax.swing.JTextField txtSet_Procfa;
    private javax.swing.JTextField txtSit_Atipica1fa;
    private javax.swing.JTextField txtSupervisorafa;
    // End of variables declaration//GEN-END:variables
}
