
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
import static com.itextpdf.text.pdf.BidiOrder.R;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.text.BadLocationException;
import javax.swing.text.View;

 /* @author GUTO
 */
public class frmHabilidades extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
        
    public frmHabilidades() throws ClassNotFoundException {
        initComponents();
        this.setLocation(250, 10);
        conecta = ConectaBD.conectabd();
        listaNomeHabilits();
        listaNomeGeral();
    }
    
    public void listaNomeHabilits(){
        
        String sql = "select codigo_1, nome from form_inc_svg order by nome Asc";
        //String sql = "select * from habilits";
        //String sql = "select codigo_1,nome from form_inc_svg order by nome Asc";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tablenomehab.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);
        }
    }
    public void listaNomeGeral(){
        
        
        String sql = "select  * from habilits order by hab_id Asc";
        try{
            pst = conecta.prepareStatement(sql);
            rs  = pst.executeQuery();
            tablehabilidade.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (SQLException error) {

            JOptionPane.showMessageDialog(null, error);

        }
    }
    
    public void mostraItem(){
        
        int seleciona = tablenomehab.getSelectedRow();
        codigohab2.setText(tablenomehab.getModel().getValueAt(seleciona, 0).toString());
        nomehab.setText(tablenomehab.getModel().getValueAt(seleciona, 1).toString());
    }
    
    public void mostraItemId(){
        
        int seleciona = tablehabilidade.getSelectedRow();
        codigohab2.setText(tablehabilidade.getModel().getValueAt(seleciona, 0).toString());
        codigohab1.setText(tablehabilidade.getModel().getValueAt(seleciona, 1).toString());
    }
    
    public void pesquisarNome() throws SQLException{
        
        //String sql = "Select codigo_1,nome from form_inc_svg where nome like ?";
        String sql ="select codigo_1,nome from form_inc_svg where nome like ?";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1,pesqnomehab.getText() + "%");
            rs = pst.executeQuery();
            tablenomehab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void pesquisarId() throws SQLException, BadLocationException{
        
        String sql ="select hab_id,codigo_1,* from habilits  where hab_escritorio_op1 like ?";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1,pesqhabilidade_id.getText()+ "%");
            rs = pst.executeQuery();
            tablehabilidade.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
   /* public Vector pesqUserId(String pesq) throws SQLException{
       /* Vector tb = new Vector();
        String url = "select hab_id,codigo_1,* from habilits  where hab_id like '" + pesq + "%'";
        pst.setString(1,pesqhabilidade_id.getText()+ "%");
        rs = pst.executeQuery();
        while(rs.next()){
            Vector rc = new Vector();
            rc.add(rs.getInt("hab_id"));
            rc.add(rs.getInt("codigo_1"));
            tb.add(rc);
        }
        return tb;
        
     
    }*/
    
    public void pesquisar() throws SQLException, BadLocationException{
        
        String sql ="select hab_id,codigo_1,* from habilits  where codigo_1 like ?";
        Integer.parseInt(sql);
        try{
            pst = conecta.prepareStatement(sql);
            
            pst.setString(0,pesqhabilidade_id.getText()+ "%");
            
            rs = pst.executeQuery();
            tablehabilidade.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
            
        }   
    }
            
    public void checkbox() throws SQLException{
        
        String sql = //"Insert into habilits (codigo_1,hab_escritorio_op1,hab_escritorio_op2,hab_escritorio_op3,hab_auxilio_geral_op1,hab_auxilio_geral_op2,hab_auxilio_geral_op3,hab_ensino_assistencia_op1,hab_ensino_assistencia_op2,hab_ensino_assistencia_op3,hab_artes_op1,hab_artes_op2,hab_artes_op3,hab_teatro_op1,hab_teatro_op2,hab_teatro_op3,hab_serv_profissionais_op1,hab_serv_profissionais_op2,hab_serv_profissionais_op3,hab_trabalho_com_op1) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       // "Insert into habilits (hab_escritorio_op1,hab_escritorio_op2,hab_escritorio_op3) values (?,?,?)";
                "Insert into habilidades (hab_escritorio_op1,hab_escritorio_op2,hab_escritorio_op3,hab_auxilio_geral_op1,hab_auxilio_geral_op2,hab_auxilio_geral_op3,hab_ensino_assistencia_op1,hab_ensino_assistencia_op2,hab_ensino_assistencia_op3,hab_artes_op1,hab_artes_op2,hab_artes_op3,hab_teatro_op1,hab_teatro_op2,hab_teatro_op3,hab_serv_profissionais_op1,hab_serv_profissionais_op2,hab_serv_profissionais_op3,hab_trabalho_com_op1) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
           try {
           pst = conecta.prepareStatement(sql);
           //pst.setString(1,chaghab1.getText());
          // pst.setString(2,chaghab2.getText());
        //Escritório
        String texto ="";
        if(chescesc1_hab.isSelected()){
            String chekselecionado = chescesc1_hab.getText();
            texto = chekselecionado;
            pst.setString(4,(chescesc1_hab.getText()));
        }
        if(chescesc2_hab.isSelected()){
           String chekselecionado = chescesc2_hab.getText().toString();
           texto = chekselecionado;  
            pst.setString(5,(chescesc2_hab.getText()));
        }      
        if(chescesc3_hab.isSelected());{
            String chekselecionado = chescesc3_hab.getText().toString();
            texto = chekselecionado; 
            pst.setString(6,(chescesc3_hab.getText()));
        }
        if(chescesc4_hab.isSelected());{
            String chekselecionado = chescesc4_hab.getText().toString();
            texto = chekselecionado;
            pst.setString(5,(chescesc4_hab.getText()));
        }
          //Auxilio Geral
        if(chaghab1.isSelected());{
            String chekselecionado = chaghab1.getText().toString();
            texto = chekselecionado; 
            pst.setString(6,(chaghab1.getText()));
        }
        if(chaghab2.isSelected());{
            String chekselecionado = chaghab2.getText().toString();
            texto = chekselecionado;
            pst.setString(7,(chaghab2.getText()));
        }
        if(chaghab3.isSelected());{
            String chekselecionado = chaghab3.getText().toString();
            texto = chekselecionado;
            pst.setString(8,(chaghab3.getText()));
        }
        if(chaghab4.isSelected());{
            String chekselecionado = chaghab4.getText().toString();
            texto = chekselecionado;
            pst.setString(9,(chaghab4.getText()));
        }
             //Artes
       if(chteatrohab1.isSelected());{
            String chekselecionado = chteatrohab1.getText().toString();
            texto = chekselecionado;
            pst.setString(10,(chteatrohab1.getText()));
        }
        if(chteatrohab2.isSelected());{
            String chekselecionado = chteatrohab2.getText().toString();
            texto = chekselecionado;
            pst.setString(11,(chteatrohab2.getText()));
        }
        if(chteatrohab3.isSelected());{
            String chekselecionado = chteatrohab3.getText().toString();
            texto = chekselecionado;
            pst.setString(12,(chteatrohab3.getText()));
        }
        if(chteatrohab4.isSelected());{
            String chekselecionado = chteatrohab4.getText().toString();
            texto = chekselecionado;
            pst.setString(13,(chteatrohab4.getText()));
        }
        if(chteatrohab5.isSelected());{
            String chekselecionado = chteatrohab5.getText().toString();
            texto = chekselecionado;
            pst.setString(14,(chteatrohab5.getText()));
        }
                //Ensino ou Assistencia
        if(cheashab1.isSelected());{
             String chekselecionado = cheashab1.getText().toString();
             texto = chekselecionado;
             pst.setString(15,(cheashab1.getText()));
        }        
        if(cheashab2.isSelected());{
            String chekselecionado = cheashab2.getText().toString();
            texto = chekselecionado;
            pst.setString(16,(cheashab2.getText()));
        } 
        if(cheashab3.isSelected());{
            String chekselecionado = cheashab3.getText().toString();
            texto = chekselecionado;
            pst.setString(17,(cheashab3.getText()));
        }
        if(cheashab4.isSelected());{
            String chekselecionado = cheashab4.getText().toString();
            texto = chekselecionado;
            pst.setString(18,(cheashab4.getText()));
        }
        if(cheashab5.isSelected());{
            String chekselecionado = cheashab5.getText().toString();
            texto = chekselecionado;
            pst.setString(19,(cheashab5.getText()));
        }
        if(cheashab6.isSelected());{
            String chekselecionado = cheashab6.getText().toString();
            texto = chekselecionado;
            pst.setString(20,(cheashab6.getText()));
        }
        if(cheashab8.isSelected());{
            String chekselecionado = cheashab8.getText().toString();
            texto = chekselecionado;
            pst.setString(21,(cheashab8.getText()));
        }
        if(cheashab9.isSelected());{
            String chekselecionado = cheashab9.getText().toString();
            texto = chekselecionado;
            pst.setString(22,(cheashab9.getText()));
        }
        if(cheashab10.isSelected());{
            String chekselecionado = cheashab10.getText().toString();
            texto = chekselecionado;
            pst.setString(23,(cheashab10.getText()));
        }
        if(cheashab11.isSelected());{
            String chekselecionado = cheashab11.getText().toString();
            texto = chekselecionado;
            pst.setString(24,(cheashab11.getText()));
        }
        if(cheashab7.isSelected());{
            String chekselecionado = cheashab7.getText().toString();
            texto = chekselecionado;
            pst.setString(25,(cheashab7.getText()));
        }
            //Teatro
        if(charthab1.isSelected());{
            String chekselecionado = charthab1.getText().toString();
            texto = chekselecionado;
            pst.setString(26,(charthab1.getText()));
            
        }    
        if(charthab2.isSelected());{
            String chekselecionado = charthab2.getText().toString();
            texto = chekselecionado;
            pst.setString(27,(charthab2.getText()));
        } 
        if(charthab3.isSelected());{
            String chekselecionado = charthab3.getText().toString();
            texto = chekselecionado;
            pst.setString(28,(charthab3.getText()));
        }
        if(charthab4.isSelected());{
            String chekselecionado = charthab4.getText().toString();
            texto = chekselecionado;
            pst.setString(29,(charthab4.getText()));
        }
        if(charthab5.isSelected());{
            String chekselecionado = charthab5.getText().toString();
            texto = chekselecionado;
            pst.setString(30,(charthab5.getText()));
        }
        
        //Serviços profissionais
        if(chsphab1.isSelected());{
            String chekselecionado = chsphab1.getText().toString();
            texto = chekselecionado;
            pst.setString(31,(chsphab1.getText()));
        }
        if(chsphab2.isSelected());{
            String chekselecionado = chsphab2.getText().toString();
            texto = chekselecionado;
            pst.setString(32,(chsphab2.getText()));
        }
        if(chsphab3.isSelected());{
            String chekselecionado = chsphab3.getText().toString();
            texto = chekselecionado;
            pst.setString(33,(chsphab3.getText()));
        }
        if(chsphab4.isSelected());{
            String chekselecionado = chsphab4.getText().toString();
            texto = chekselecionado;
            pst.setString(34,(chsphab4.getText()));
        }
        if(chsphab5.isSelected());{
            String chekselecionado = chsphab5.getText().toString();
            texto = chekselecionado;
            pst.setString(35,(chsphab5.getText()));
        }
        if(chsphab6.isSelected());{
            String chekselecionado = chsphab6.getText().toString();
            texto = chekselecionado;
            pst.setString(36,(chsphab6.getText()));
        }
        if(chsphab7.isSelected());{
            String chekselecionado = chsphab7.getText().toString();
            texto = chekselecionado;
            pst.setString(37,(chsphab7.getText()));
        }
        if(chsphab8.isSelected());{
            String chekselecionado = chsphab8.getText().toString();
            texto = chekselecionado;
            pst.setString(38,(chsphab8.getText()));
        }
        if(chsphab9.isSelected());{
            String chekselecionado = chsphab9.getText().toString();
            texto = chekselecionado;
            pst.setString(39,(chsphab9.getText()));
        }
        if(chsphab10.isSelected());{
            String chekselecionado = chsphab10.getText().toString();
            texto = chekselecionado;
            pst.setString(40,(chsphab10.getText()));
        }
        if(chsphab11.isSelected());{
            String chekselecionado = chsphab11.getText().toString();
            texto = chekselecionado;
            pst.setString(41,(chsphab11.getText()));
        }
        if(chsphab12.isSelected());{
            String chekselecionado = chsphab12.getText().toString();
            texto = chekselecionado;
            pst.setString(42,(chsphab12.getText()));
        }
        if(chsphab13.isSelected());{
            String chekselecionado = chsphab13.getText().toString();
            texto = chekselecionado;
            pst.setString(43,(chsphab13.getText()));
        }
        if(chsphab14.isSelected());{
            String chekselecionado = chsphab14.getText().toString();
            texto = chekselecionado;
            pst.setString(44,(chsphab14.getText()));
        }
        if(chsphab15.isSelected());{
            String chekselecionado = chsphab15.getText().toString();
            texto = chekselecionado;
            pst.setString(45,(chsphab15.getText()));
        }
        if(chsphab16.isSelected());{
            String chekselecionado = chsphab16.getText().toString();
            texto = chekselecionado;
            pst.setString(46,(chsphab16.getText()));
        }
        if(chsphab17.isSelected());{
            String chekselecionado = chsphab17.getText().toString();
            texto = chekselecionado;
            pst.setString(47,(chsphab17.getText()));
        }
        if(chsphab18.isSelected());{
            String chekselecionado = chsphab18.getText().toString();
            texto = chekselecionado;
            pst.setString(48,(chsphab18.getText()));
        }
        if(chsphab19.isSelected());{
            String chekselecionado = chsphab19.getText().toString();
            texto = chekselecionado;
            pst.setString(49,(chsphab19.getText()));
        }
        if(chsphab20.isSelected());{
            String chekselecionado = chsphab20.getText().toString();
            texto = chekselecionado;
            pst.setString(50,(chsphab20.getText()));
        }
        if(chsphab22.isSelected());{
            String chekselecionado = chsphab22.getText().toString();
            texto = chekselecionado;
            pst.setString(51,(chsphab22.getText()));
        }
        if(chsphab23.isSelected());{
            String chekselecionado = chsphab23.getText().toString();
            texto = chekselecionado;
            pst.setString(52,(chsphab23.getText()));
        }
        if(chsphab24.isSelected());{
            String chekselecionado = chsphab24.getText().toString();
            texto = chekselecionado;
            pst.setString(53,(chsphab24.getText()));
        }
        if(chsphab25.isSelected());{
            String chekselecionado = chsphab25.getText().toString();
            texto = chekselecionado;
            pst.setString(54,(chsphab25.getText()));
        }
            //Trabalho com
        if(chtchab1.isSelected());{
            String chekselecionado = chtchab1.getText().toString();
            texto = chekselecionado;
            pst.setString(55,(chtchab1.getText()));
        }
        if(chtchab2.isSelected());{
            String chekselecionado = chtchab2.getText().toString();
            texto = chekselecionado;
            pst.setString(56,(chtchab2.getText()));
        }
        if(chtchab3.isSelected());{
            String chekselecionado = chtchab3.getText().toString();
            texto = chekselecionado;
            pst.setString(57,(chtchab3.getText()));
        }
        if(chtchab4.isSelected());{
            String chekselecionado = chtchab4.getText().toString();
            texto = chekselecionado;
            pst.setString(58,(chtchab4.getText()));
        }
        if(chtchab5.isSelected());{
            String chekselecionado = chtchab4.getText().toString();
            texto = chekselecionado;
            pst.setString(59,(chtchab4.getText()));
        }
        if(chtchab6.isSelected());{
            String chekselecionado = chtchab6.getText().toString();
            texto = chekselecionado;
            pst.setString(60,(chtchab6.getText()));
        }
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
          }catch (SQLException error) {
              JOptionPane.showMessageDialog(null, error);
               } 
     }
    
   
    
    public void cadastroHabilidades(){
        
        
        
        String sql = "Insert into habilidades (hab_id,hab_codhab,hab_escritorio_op1,hab_escritorio_op2,hab_escritorio_op3,hab_auxilio_geral_op1,hab_auxilio_geral_op2,hab_auxilio_geral_op3,hab_ensino_assistencia_op1,hab_ensino_assistencia_op2,hab_ensino_assistencia_op3,hab_artes_op1,hab_artes_op2,hab_artes_op3,hab_serv_profissionais_op1,hab_serv_profissionais_op2,hab_serv_profissionais_op3,hab_trabalho_com_op1) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
           try {
               pst = conecta.prepareStatement(sql);
                              
               pst.setString(5,chaghab1.getText());
               pst.setString(6,chaghab2.getText());
               pst.setString(7,chaghab3.getText());
               pst.setString(8,chaghab4.getText());
               pst.setString(9,chteatrohab1.getText());
               pst.setString(10,chteatrohab2.getText());
               pst.setString(11,chteatrohab3.getText());
               pst.setString(12,chteatrohab4.getText());
               pst.setString(13,chteatrohab5.getText());
               pst.setString(14,cheashab1.getText());
               pst.setString(15,cheashab2.getText());
               pst.setString(16,cheashab3.getText());
               pst.setString(17,cheashab4.getText());
               pst.setString(18,cheashab5.getText());
               pst.setString(19,cheashab6.getText());
               pst.setString(20,cheashab8.getText());
               pst.setString(21,cheashab9.getText());
               pst.setString(22,cheashab10.getText());
               pst.setString(23,cheashab11.getText());
               pst.setString(24,cheashab7.getText());
               pst.setString(25,charthab1.getText());
               pst.setString(26,charthab2.getText());
               pst.setString(27,charthab3.getText());
               pst.setString(28,charthab4.getText());
               pst.setString(29,charthab5.getText());
               pst.setString(31,chsphab1.getText());
               pst.setString(32,chsphab2.getText());
               pst.setString(33,chsphab3.getText());
               pst.setString(34,chsphab4.getText());
               pst.setString(35,chsphab5.getText());
               pst.setString(36,chsphab6.getText());
               pst.setString(37,chsphab7.getText());
               pst.setString(38,chsphab8.getText());
               pst.setString(39,chsphab9.getText());
               pst.setString(40,chsphab10.getText());
               pst.setString(41,chsphab11.getText());
               pst.setString(42,chsphab12.getText());
               pst.setString(43,chsphab13.getText());
               pst.setString(44,chsphab14.getText());
               pst.setString(45,chsphab15.getText());
               pst.setString(46,chsphab16.getText());
               pst.setString(47,chsphab17.getText());
               pst.setString(48,chsphab18.getText());
               pst.setString(49,chsphab19.getText());
               pst.setString(50,chsphab20.getText());
               pst.setString(51,chsphab22.getText());
               pst.setString(52,chsphab23.getText());
               pst.setString(53,chsphab24.getText());
               pst.setString(54,chsphab25.getText());
               pst.setString(55,chtchab1.getText());
               pst.setString(56,chtchab2.getText());
               pst.setString(57,chtchab3.getText());
               pst.setString(58,chtchab4.getText());
               pst.setString(59,chtchab5.getText());
               pst.setString(60,chtchab6.getText());
               pst.execute();
               JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
               pesquisarNome();
               }catch (SQLException error) {
                     JOptionPane.showMessageDialog(null, error);
               }    
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        chaghab1 = new javax.swing.JCheckBox();
        chaghab2 = new javax.swing.JCheckBox();
        chaghab3 = new javax.swing.JCheckBox();
        chaghab4 = new javax.swing.JCheckBox();
        cheashab1 = new javax.swing.JCheckBox();
        cheashab2 = new javax.swing.JCheckBox();
        cheashab3 = new javax.swing.JCheckBox();
        cheashab4 = new javax.swing.JCheckBox();
        cheashab5 = new javax.swing.JCheckBox();
        cheashab6 = new javax.swing.JCheckBox();
        cheashab9 = new javax.swing.JCheckBox();
        cheashab10 = new javax.swing.JCheckBox();
        cheashab11 = new javax.swing.JCheckBox();
        cheashab8 = new javax.swing.JCheckBox();
        nomehab = new javax.swing.JTextField();
        codigohab2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chteatrohab1 = new javax.swing.JCheckBox();
        chteatrohab2 = new javax.swing.JCheckBox();
        chteatrohab3 = new javax.swing.JCheckBox();
        chteatrohab4 = new javax.swing.JCheckBox();
        chteatrohab5 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        charthab1 = new javax.swing.JCheckBox();
        charthab2 = new javax.swing.JCheckBox();
        charthab3 = new javax.swing.JCheckBox();
        charthab4 = new javax.swing.JCheckBox();
        charthab5 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        chsphab1 = new javax.swing.JCheckBox();
        chsphab2 = new javax.swing.JCheckBox();
        chsphab3 = new javax.swing.JCheckBox();
        chsphab4 = new javax.swing.JCheckBox();
        chsphab5 = new javax.swing.JCheckBox();
        chsphab6 = new javax.swing.JCheckBox();
        chsphab7 = new javax.swing.JCheckBox();
        chsphab8 = new javax.swing.JCheckBox();
        chsphab9 = new javax.swing.JCheckBox();
        chsphab10 = new javax.swing.JCheckBox();
        chsphab11 = new javax.swing.JCheckBox();
        chsphab12 = new javax.swing.JCheckBox();
        chsphab13 = new javax.swing.JCheckBox();
        chsphab14 = new javax.swing.JCheckBox();
        chsphab15 = new javax.swing.JCheckBox();
        chsphab16 = new javax.swing.JCheckBox();
        chsphab17 = new javax.swing.JCheckBox();
        chsphab18 = new javax.swing.JCheckBox();
        cheashab7 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        pesqnomehab = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablenomehab = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chtchab1 = new javax.swing.JCheckBox();
        chtchab2 = new javax.swing.JCheckBox();
        chtchab3 = new javax.swing.JCheckBox();
        chtchab4 = new javax.swing.JCheckBox();
        chtchab5 = new javax.swing.JCheckBox();
        chtchab6 = new javax.swing.JCheckBox();
        chsphab19 = new javax.swing.JCheckBox();
        chsphab20 = new javax.swing.JCheckBox();
        chsphab21 = new javax.swing.JCheckBox();
        chsphab22 = new javax.swing.JCheckBox();
        chsphab23 = new javax.swing.JCheckBox();
        chsphab24 = new javax.swing.JCheckBox();
        chsphab25 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablehabilidade = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        pesqhabilidade_id = new javax.swing.JTextField();
        chescesc1_hab = new javax.swing.JCheckBox();
        chescesc2_hab = new javax.swing.JCheckBox();
        chescesc3_hab = new javax.swing.JCheckBox();
        chescesc4_hab = new javax.swing.JCheckBox();
        codigohab1 = new javax.swing.JTextField();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chaghab1.setText("Alimentacao");
        getContentPane().add(chaghab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 99, 20));

        chaghab2.setText("Cuidador de criancas");
        chaghab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaghab2ActionPerformed(evt);
            }
        });
        getContentPane().add(chaghab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 130, 20));

        chaghab3.setText("Manutencao");
        getContentPane().add(chaghab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 99, 20));

        chaghab4.setText("Transporte");
        getContentPane().add(chaghab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 99, 20));

        cheashab1.setText("Esportes");
        getContentPane().add(cheashab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 99, -1));

        cheashab2.setText("Adultos solteiros");
        getContentPane().add(cheashab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 20));

        cheashab3.setText("Casais");
        getContentPane().add(cheashab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 99, 20));

        cheashab4.setText("Homens");
        getContentPane().add(cheashab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 99, 20));

        cheashab5.setText("Mulheres");
        getContentPane().add(cheashab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 99, -1));

        cheashab6.setText("Danca");
        getContentPane().add(cheashab6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 99, 20));

        cheashab9.setText("Ensino Fundamental");
        getContentPane().add(cheashab9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 130, 20));

        cheashab10.setText("Ensino medio");
        getContentPane().add(cheashab10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 100, 30));

        cheashab11.setText("Linguas");
        getContentPane().add(cheashab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 100, 20));

        cheashab8.setText("Pre-escola");
        getContentPane().add(cheashab8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 100, 20));
        getContentPane().add(nomehab, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 200, 40));

        codigohab2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigohab2.setEnabled(false);
        codigohab2.setOpaque(false);
        codigohab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigohab2ActionPerformed(evt);
            }
        });
        getContentPane().add(codigohab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 40, 30));

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText(" HABILIDADES ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 110, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" CODIGOS:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" NOME:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText(" ESCRITÓRIO :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText(" AUXÍLIO GERAL :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText(" ENSINO OU ASSISTÊNCIA :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText(" TEATRO :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, 30));

        chteatrohab1.setText("Decoracao");
        getContentPane().add(chteatrohab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 99, -1));

        chteatrohab2.setText("Fotografia");
        getContentPane().add(chteatrohab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 99, 20));

        chteatrohab3.setText("Graficos");
        getContentPane().add(chteatrohab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 99, 20));

        chteatrohab4.setText("Multimidia");
        getContentPane().add(chteatrohab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 207, 99, -1));

        chteatrohab5.setText("Trabalhos manuais");
        getContentPane().add(chteatrohab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 227, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText(" ARTES :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, 30));

        charthab1.setText("Ator");
        getContentPane().add(charthab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 99, 30));

        charthab2.setText("Danca");
        getContentPane().add(charthab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 99, -1));

        charthab3.setText("Mimica");
        getContentPane().add(charthab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 99, 30));

        charthab4.setText("Marionetes");
        getContentPane().add(charthab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 99, 20));

        charthab5.setText("Poeta");
        getContentPane().add(charthab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 99, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText(" SERVIÇOS PROFISSIONAIS :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        chsphab1.setText("Aconselhamento");
        getContentPane().add(chsphab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 110, -1));

        chsphab2.setText("Administracao");
        getContentPane().add(chsphab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 120, 20));

        chsphab3.setText("Area Financeira");
        getContentPane().add(chsphab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 110, 20));

        chsphab4.setText("Juridica");
        getContentPane().add(chsphab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 99, -1));

        chsphab5.setText("Marketing");
        getContentPane().add(chsphab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 99, -1));

        chsphab6.setText("Computacao");
        getContentPane().add(chsphab6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 99, -1));

        chsphab7.setText("Contabilidade");
        getContentPane().add(chsphab7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 99, -1));

        chsphab8.setText("Engenlharia");
        getContentPane().add(chsphab8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 99, -1));

        chsphab9.setText("Esportes");
        getContentPane().add(chsphab9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 99, -1));

        chsphab10.setText("Enfermagem");
        getContentPane().add(chsphab10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 99, -1));

        chsphab11.setText("Limpeza");
        getContentPane().add(chsphab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 99, -1));

        chsphab12.setText("Saude Mental");
        getContentPane().add(chsphab12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 99, -1));

        chsphab13.setText("RH");
        getContentPane().add(chsphab13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 99, -1));

        chsphab14.setText("Trabalho social");
        getContentPane().add(chsphab14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 99, -1));

        chsphab15.setText("Televisao");
        chsphab15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chsphab15ActionPerformed(evt);
            }
        });
        getContentPane().add(chsphab15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 99, -1));

        chsphab16.setText("vendas");
        getContentPane().add(chsphab16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 99, 20));

        chsphab17.setText("Arquiteto");
        getContentPane().add(chsphab17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 99, 20));

        chsphab18.setText("Encanador");
        getContentPane().add(chsphab18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 99, 20));

        cheashab7.setText("Faculdade");
        getContentPane().add(cheashab7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 99, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel11.setText(" NOME :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        pesqnomehab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqnomehabActionPerformed(evt);
            }
        });
        pesqnomehab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqnomehabKeyReleased(evt);
            }
        });
        getContentPane().add(pesqnomehab, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 180, 30));

        tablenomehab.setModel(new javax.swing.table.DefaultTableModel(
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
        tablenomehab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenomehabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablenomehab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 180, 90));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/accept.png"))); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, 120, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_edit.png"))); // NOI18N
        jButton2.setText("EDITAR");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, 120, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/user_delete.png"))); // NOI18N
        jButton3.setText("DELETAR");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 310, 120, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cancel.png"))); // NOI18N
        jButton4.setText("LIMPAR");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 350, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TRABALHO COM :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, -1, -1));

        chtchab1.setText("Deficientes");
        getContentPane().add(chtchab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, 99, -1));

        chtchab2.setText("Drogados");
        getContentPane().add(chtchab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 99, -1));

        chtchab3.setText("Mudos");
        getContentPane().add(chtchab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 99, -1));

        chtchab4.setText("Surdos");
        getContentPane().add(chtchab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 99, -1));

        chtchab5.setText("Prostitutas");
        getContentPane().add(chtchab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 99, -1));

        chtchab6.setText("Visita Hospitalar");
        getContentPane().add(chtchab6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, -1, -1));

        chsphab19.setText("Eletrecista");
        getContentPane().add(chsphab19, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 99, 20));

        chsphab20.setText("Pintor");
        getContentPane().add(chsphab20, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 99, 20));

        chsphab21.setText("Marceneiro");
        getContentPane().add(chsphab21, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 99, 20));

        chsphab22.setText("Mestre de obras");
        getContentPane().add(chsphab22, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 110, 20));

        chsphab23.setText("Pedreiro");
        getContentPane().add(chsphab23, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 99, 20));

        chsphab24.setText("Tecnico");
        getContentPane().add(chsphab24, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 99, 20));

        chsphab25.setText("Professor(a)");
        getContentPane().add(chsphab25, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, 99, 20));

        tablehabilidade.setModel(new javax.swing.table.DefaultTableModel(
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
        tablehabilidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehabilidadeMouseClicked(evt);
            }
        });
        tablehabilidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablehabilidadeKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablehabilidade);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 1160, 100));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/zoom.png"))); // NOI18N
        jLabel12.setText("PESQUISAR CODIGO_ID:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, -1, -1));

        pesqhabilidade_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqhabilidade_idKeyReleased(evt);
            }
        });
        getContentPane().add(pesqhabilidade_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 330, 30));

        chescesc1_hab.setText("Proc de Textos");
        getContentPane().add(chescesc1_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 157, 110, -1));

        chescesc2_hab.setText("Recepcionista");
        getContentPane().add(chescesc2_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 177, 130, -1));

        chescesc3_hab.setText("Telefonista");
        getContentPane().add(chescesc3_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 197, 99, -1));

        chescesc4_hab.setText("Secretaria");
        getContentPane().add(chescesc4_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 217, 99, -1));

        codigohab1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigohab1.setEnabled(false);
        codigohab1.setOpaque(false);
        codigohab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigohab1ActionPerformed(evt);
            }
        });
        getContentPane().add(codigohab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            checkbox();
        } catch (SQLException ex) {
            Logger.getLogger(frmHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pesqnomehabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqnomehabActionPerformed
       // try {
         //   pesquisarNome();
        //} catch (SQLException ex) {
          //  Logger.getLogger(frmHabilidades.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }//GEN-LAST:event_pesqnomehabActionPerformed

    private void tablenomehabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenomehabMouseClicked
        mostraItem();
    }//GEN-LAST:event_tablenomehabMouseClicked

    private void pesqnomehabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqnomehabKeyReleased
        try {
            // TODO add your handling code here:
            pesquisarNome();
        } catch (SQLException ex) {
            Logger.getLogger(frmHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesqnomehabKeyReleased

    private void chaghab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaghab2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chaghab2ActionPerformed

    private void chsphab15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chsphab15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chsphab15ActionPerformed

    private void tablehabilidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablehabilidadeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablehabilidadeKeyReleased

    private void codigohab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigohab2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigohab2ActionPerformed

    private void codigohab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigohab1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigohab1ActionPerformed

    private void tablehabilidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehabilidadeMouseClicked
        mostraItemId();
    }//GEN-LAST:event_tablehabilidadeMouseClicked

    private void pesqhabilidade_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqhabilidade_idKeyReleased
        try {
            pesquisar();
        } catch (SQLException ex) {
            Logger.getLogger(frmHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(frmHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesqhabilidade_idKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chaghab1;
    private javax.swing.JCheckBox chaghab2;
    private javax.swing.JCheckBox chaghab3;
    private javax.swing.JCheckBox chaghab4;
    private javax.swing.JCheckBox charthab1;
    private javax.swing.JCheckBox charthab2;
    private javax.swing.JCheckBox charthab3;
    private javax.swing.JCheckBox charthab4;
    private javax.swing.JCheckBox charthab5;
    private javax.swing.JCheckBox cheashab1;
    private javax.swing.JCheckBox cheashab10;
    private javax.swing.JCheckBox cheashab11;
    private javax.swing.JCheckBox cheashab2;
    private javax.swing.JCheckBox cheashab3;
    private javax.swing.JCheckBox cheashab4;
    private javax.swing.JCheckBox cheashab5;
    private javax.swing.JCheckBox cheashab6;
    private javax.swing.JCheckBox cheashab7;
    private javax.swing.JCheckBox cheashab8;
    private javax.swing.JCheckBox cheashab9;
    private javax.swing.JCheckBox chescesc1_hab;
    private javax.swing.JCheckBox chescesc2_hab;
    private javax.swing.JCheckBox chescesc3_hab;
    private javax.swing.JCheckBox chescesc4_hab;
    private javax.swing.JCheckBox chsphab1;
    private javax.swing.JCheckBox chsphab10;
    private javax.swing.JCheckBox chsphab11;
    private javax.swing.JCheckBox chsphab12;
    private javax.swing.JCheckBox chsphab13;
    private javax.swing.JCheckBox chsphab14;
    private javax.swing.JCheckBox chsphab15;
    private javax.swing.JCheckBox chsphab16;
    private javax.swing.JCheckBox chsphab17;
    private javax.swing.JCheckBox chsphab18;
    private javax.swing.JCheckBox chsphab19;
    private javax.swing.JCheckBox chsphab2;
    private javax.swing.JCheckBox chsphab20;
    private javax.swing.JCheckBox chsphab21;
    private javax.swing.JCheckBox chsphab22;
    private javax.swing.JCheckBox chsphab23;
    private javax.swing.JCheckBox chsphab24;
    private javax.swing.JCheckBox chsphab25;
    private javax.swing.JCheckBox chsphab3;
    private javax.swing.JCheckBox chsphab4;
    private javax.swing.JCheckBox chsphab5;
    private javax.swing.JCheckBox chsphab6;
    private javax.swing.JCheckBox chsphab7;
    private javax.swing.JCheckBox chsphab8;
    private javax.swing.JCheckBox chsphab9;
    private javax.swing.JCheckBox chtchab1;
    private javax.swing.JCheckBox chtchab2;
    private javax.swing.JCheckBox chtchab3;
    private javax.swing.JCheckBox chtchab4;
    private javax.swing.JCheckBox chtchab5;
    private javax.swing.JCheckBox chtchab6;
    private javax.swing.JCheckBox chteatrohab1;
    private javax.swing.JCheckBox chteatrohab2;
    private javax.swing.JCheckBox chteatrohab3;
    private javax.swing.JCheckBox chteatrohab4;
    private javax.swing.JCheckBox chteatrohab5;
    private javax.swing.JTextField codigohab1;
    private javax.swing.JTextField codigohab2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomehab;
    private javax.swing.JTextField pesqhabilidade_id;
    private javax.swing.JTextField pesqnomehab;
    private javax.swing.JTable tablehabilidade;
    private javax.swing.JTable tablenomehab;
    // End of variables declaration//GEN-END:variables

    

}
