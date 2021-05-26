
package Visual;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class frmRedeSocial extends javax.swing.JInternalFrame {
    
    public void frmFacebook() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.facebook.com/"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    } 
    public void frmInstagram() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.instagram.com/?hl=pt-br"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void frmTwitter() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.twitter.com/login?lang=pt"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void frmWhatsApp() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.whatsapp.com"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void frmCultoAoVivo() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.youtube.com/c/getsemaniaovivo/live"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void frmInforGet() throws URISyntaxException{
        Desktop d =Desktop.getDesktop();
        try {
            d.browse(new URI("https://getsemani.com.br/novosite/reunioes.php"));
        } catch (IOException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    public frmRedeSocial() {
        initComponents();
       this.setLocation(200,80);
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 204, 255));
        setClosable(true);
        setForeground(new java.awt.Color(0, 0, 0));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/group.png"))); // NOI18N
        jLabel1.setText("Acesso A Redes Sociais : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 135, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 5)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Whatsapp.png"))); // NOI18N
        jButton1.setText("WhatsApp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.ipady = -16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 20, 0, 41);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 5)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/facebook.png"))); // NOI18N
        jButton2.setText("Facebook");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = -78;
        gridBagConstraints.ipady = -25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 33, 0, 0);
        getContentPane().add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 5)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Twiter.png"))); // NOI18N
        jButton3.setText("Twitter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -54;
        gridBagConstraints.ipady = -11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 33, 0, 0);
        getContentPane().add(jButton3, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 5)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("E:\\Guto\\BKP\\Voluntarios\\Instagram.png")); // NOI18N
        jButton4.setText("Instagram");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -62;
        gridBagConstraints.ipady = -12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 0);
        getContentPane().add(jButton4, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("E:\\Guto\\BKP\\Voluntarios\\images.png")); // NOI18N
        jButton5.setText("CULTO AO VIVO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 58, 0);
        getContentPane().add(jButton5, gridBagConstraints);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/newspaper.png"))); // NOI18N
        jButton6.setText("InforGet");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 169, 0, 0);
        getContentPane().add(jButton6, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            frmFacebook();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            frmWhatsApp();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            frmTwitter();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            frmInstagram();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try {
            frmCultoAoVivo();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            frmInforGet();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmRedeSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
