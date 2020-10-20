/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraphiques;

import static com.usthb.modeles.ClientFacebook.inscrireAbonne;
import static com.usthb.modeles.ClientFacebook.seConnecter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ITEC
 */
public class InscriptionFen extends javax.swing.JFrame {

    /**
     * Creates new form InscriptionFen
     */
    public InscriptionFen() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtPrenom = new javax.swing.JTextField();
        txtFonction = new javax.swing.JTextField();
        txtSpecialite = new javax.swing.JTextField();
        categorieH = new javax.swing.JRadioButton();
        categorieF = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNiveauEtude = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        spPassword = new javax.swing.JSeparator();
        spPasswordBis = new javax.swing.JSeparator();
        txtPasswordBis = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        lblPasswordBis = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnInscrire = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        msgErreur1 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtCategorie = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mdpBisF = new javax.swing.JLabel();
        nomF = new javax.swing.JLabel();
        prenomF = new javax.swing.JLabel();
        catF = new javax.swing.JLabel();
        dateF = new javax.swing.JLabel();
        userF = new javax.swing.JLabel();
        mdpF = new javax.swing.JLabel();
        dateNaissance = new com.toedter.calendar.JDateChooser();
        close = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setTitle("Inscription");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrenom.setBackground(new java.awt.Color(102, 102, 102));
        txtPrenom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrenom.setForeground(new java.awt.Color(240, 240, 240));
        txtPrenom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prénom*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(240, 240, 240))); // NOI18N
        txtPrenom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrenomMouseClicked(evt);
            }
        });
        txtPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 220, 50));

        txtFonction.setBackground(new java.awt.Color(102, 102, 102));
        txtFonction.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFonction.setForeground(new java.awt.Color(240, 240, 240));
        txtFonction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fonction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        txtFonction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFonctionMouseClicked(evt);
            }
        });
        txtFonction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFonctionActionPerformed(evt);
            }
        });
        jPanel1.add(txtFonction, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 220, 50));

        txtSpecialite.setBackground(new java.awt.Color(102, 102, 102));
        txtSpecialite.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSpecialite.setForeground(new java.awt.Color(240, 240, 240));
        txtSpecialite.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Spécialité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        txtSpecialite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSpecialiteMouseClicked(evt);
            }
        });
        txtSpecialite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpecialiteActionPerformed(evt);
            }
        });
        jPanel1.add(txtSpecialite, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 220, 50));

        categorieH.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(categorieH);
        categorieH.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        categorieH.setForeground(new java.awt.Color(204, 204, 204));
        categorieH.setText("Homme");
        jPanel1.add(categorieH, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        categorieF.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(categorieF);
        categorieF.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        categorieF.setForeground(new java.awt.Color(204, 204, 204));
        categorieF.setText("Femme");
        jPanel1.add(categorieF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jPanel2.setBackground(new java.awt.Color(213, 98, 71));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Left_50px.png"))); // NOI18N
        jLabel2.setText("Précédent");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 520));

        txtNiveauEtude.setBackground(new java.awt.Color(102, 102, 102));
        txtNiveauEtude.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNiveauEtude.setForeground(new java.awt.Color(240, 240, 240));
        txtNiveauEtude.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Niveau d'étude", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        txtNiveauEtude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNiveauEtudeMouseClicked(evt);
            }
        });
        txtNiveauEtude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNiveauEtudeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNiveauEtude, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 220, 50));

        txtUsername.setBackground(new java.awt.Color(102, 102, 102));
        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setBorder(null);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUsernameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtUsernameMouseReleased(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 220, 30));

        spPassword.setBackground(new java.awt.Color(240, 240, 240));
        spPassword.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(spPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 220, 10));

        spPasswordBis.setBackground(new java.awt.Color(240, 240, 240));
        spPasswordBis.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(spPasswordBis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 220, 10));

        txtPasswordBis.setBackground(new java.awt.Color(102, 102, 102));
        txtPasswordBis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPasswordBis.setForeground(new java.awt.Color(240, 240, 240));
        txtPasswordBis.setBorder(null);
        txtPasswordBis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordBisMouseClicked(evt);
            }
        });
        txtPasswordBis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordBisActionPerformed(evt);
            }
        });
        jPanel1.add(txtPasswordBis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 220, 30));

        txtPassword.setBackground(new java.awt.Color(102, 102, 102));
        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(240, 240, 240));
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 220, 30));

        lblPasswordBis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPasswordBis.setForeground(new java.awt.Color(240, 240, 240));
        lblPasswordBis.setText("Confirmer mot de passe*");
        jPanel1.add(lblPasswordBis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 220, 30));

        lblUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(240, 240, 240));
        lblUsername.setText("Nom d'utilisateur*");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 220, 30));

        lblPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(240, 240, 240));
        lblPassword.setText("Mot de passe*");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 220, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("(*) Champs Obligatoires");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 160, -1));

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));
        jSeparator1.setForeground(new java.awt.Color(240, 240, 240));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 10, 430));

        jPanel3.setBackground(new java.awt.Color(213, 98, 71));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInscrire.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnInscrire.setForeground(new java.awt.Color(240, 240, 240));
        btnInscrire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInscrire.setText("S'inscrire");
        btnInscrire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInscrire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInscrireMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInscrireMouseEntered(evt);
            }
        });
        jPanel3.add(btnInscrire, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 230, 50));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, 20));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, 20));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, 20));

        msgErreur1.setBackground(new java.awt.Color(51, 51, 60));
        msgErreur1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        msgErreur1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(msgErreur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 240, 20));

        txtNom.setBackground(new java.awt.Color(102, 102, 102));
        txtNom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNom.setForeground(new java.awt.Color(240, 240, 240));
        txtNom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nom*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(240, 240, 240))); // NOI18N
        txtNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomMouseClicked(evt);
            }
        });
        jPanel1.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, 50));

        txtCategorie.setBackground(new java.awt.Color(45, 50, 60));
        txtCategorie.setForeground(new java.awt.Color(204, 204, 204));
        txtCategorie.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catégorie*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(240, 240, 240))); // NOI18N
        jPanel1.add(txtCategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 220, 70));

        jLabel1.setBackground(new java.awt.Color(45, 50, 60));
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date de naissance*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(240, 240, 240))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 220, 70));

        mdpBisF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        mdpBisF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(mdpBisF, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 20, 30));

        nomF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        nomF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(nomF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 20, 30));

        prenomF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        prenomF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(prenomF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 20, 30));

        catF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        catF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(catF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 20, 30));

        dateF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        dateF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(dateF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 20, 30));

        userF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        userF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(userF, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 20, 30));

        mdpF.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        mdpF.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(mdpF, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 20, 30));

        dateNaissance.setAutoscrolls(true);
        dateNaissance.setMaxSelectableDate(new java.util.Date(1104537661000L));
        dateNaissance.setMinSelectableDate(new java.util.Date(-1640992355000L));
        jPanel1.add(dateNaissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 190, 20));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_32px_1.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 30, -1));

        jSeparator2.setBackground(new java.awt.Color(45, 50, 60));
        jSeparator2.setForeground(new java.awt.Color(45, 50, 60));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 220, 0));

        jSeparator3.setBackground(new java.awt.Color(240, 240, 240));
        jSeparator3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 220, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 520));

        setSize(new java.awt.Dimension(852, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFonctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFonctionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFonctionActionPerformed

    private void txtSpecialiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecialiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpecialiteActionPerformed

    private void txtNiveauEtudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNiveauEtudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNiveauEtudeActionPerformed

    private void txtPrenomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrenomMouseClicked
        txtPrenom.setText("");
    }//GEN-LAST:event_txtPrenomMouseClicked

    private void txtFonctionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFonctionMouseClicked
        txtFonction.setText("");
    }//GEN-LAST:event_txtFonctionMouseClicked

    private void txtSpecialiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSpecialiteMouseClicked
        txtSpecialite.setText("");
    }//GEN-LAST:event_txtSpecialiteMouseClicked

    private void txtNiveauEtudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNiveauEtudeMouseClicked
        txtNiveauEtude.setText("");
    }//GEN-LAST:event_txtNiveauEtudeMouseClicked

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked

    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtPasswordBisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordBisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordBisActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPasswordBisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordBisMouseClicked
        txtPasswordBis.setText("");
    }//GEN-LAST:event_txtPasswordBisMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       this.dispose();
       new ConnexionFen().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtUsernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseReleased

    private void txtUsernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseExited

    @SuppressWarnings("empty-statement")
    private void btnInscrireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInscrireMouseClicked
          String  nom= txtNom.getText().trim(),
        prenom= txtPrenom.getText().trim(),
        username= txtUsername.getText().replaceAll("\\s",""),
        password=new String(txtPassword.getPassword()),
        passwordBis=new String(txtPasswordBis.getPassword());
        String fonction=txtFonction.getText().trim();
        String specialite=txtSpecialite.getText().trim();
        String niveauEtude=txtNiveauEtude.getText().trim();
        String date="";
        if(dateNaissance.getDate()!=null)
        date = new String(dateNaissance.getDate().toString().substring(4,10)+dateNaissance.getDate().toString().substring(23));
        String categorie="";
        if(categorieH.isSelected())
            categorie="Homme";
        else
            if(categorieF.isSelected())
             categorie="Femme";
       
 
        if(nom.isEmpty() || prenom.isEmpty() || username.isEmpty()
            || password.isEmpty() || passwordBis.isEmpty() || categorie.isEmpty() || date.isEmpty())
        {
 
            msgErreur1.setText("Remplissez les champs obligatoires");
 
            if(nom.isEmpty())
               // txtPrenom.setForeground(Color.RED);
                nomF.setText("*");
            else
               // txtPrenom.setForeground(Color.LIGHT_GRAY);
                nomF.setText("");
           
            if(prenom.isEmpty())
                //txtPrenom.setForeground(Color.RED);
               prenomF.setText("*");
            else
                //txtPrenom.setForeground(Color.LIGHT_GRAY);
                   prenomF.setText("");
 
            if(username.isEmpty())
                //lblUsername.setForeground(Color.RED);
                userF.setText("*");
            else
                //lblUsername.setForeground(Color.LIGHT_GRAY);
                userF.setText("");
 
            if(password.isEmpty())
                //lblPassword.setForeground(Color.RED);
                mdpF.setText("*");
            else
                //lblPassword.setForeground(Color.LIGHT_GRAY);
                mdpF.setText("");
 
            if(passwordBis.isEmpty())
                //lblPasswordBis.setForeground(Color.RED);
                mdpBisF.setText("*");
            else
                //lblPasswordBis.setForeground(Color.LIGHT_GRAY);
                mdpBisF.setText("");
           
            if(categorie.isEmpty())
                catF.setText("*");
            else
                catF.setText("");
           
            if(date.isEmpty())
                dateF.setText("*");
            else
                dateF.setText("");
           
           
        }else{
            if(!password.equals(passwordBis)){
                msgErreur1.setText("Mots de passe différents");
            }else{
               
                   
               
               
                try {
                    switch(inscrireAbonne(nom,prenom,date,
                            categorie ,username,password,txtFonction.getText(),
                            txtSpecialite.getText(),txtNiveauEtude.getText())) {
                       
                        case 0:
                            Thread.sleep(100);
                            seConnecter(username,password);
                            new MurFen().setVisible(true);
                            this.dispose();
                            break;
                            
                        case 1:
                            msgErreur1.setText("Username déjà existant");
                            break;
                            
                        case 2:
                            msgErreur1.setText("Problème connexion");
                            break;
                           
                    }
                } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                    Logger.getLogger(InscriptionFen.class.getName()).log(Level.SEVERE, null, ex);
                }
       
            }
             
    }
    }//GEN-LAST:event_btnInscrireMouseClicked
    
    
    private void txtNomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomMouseClicked

    private void txtPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void btnInscrireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInscrireMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInscrireMouseEntered

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InscriptionFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscriptionFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscriptionFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscriptionFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
*/

        
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnInscrire;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel catF;
    private javax.swing.JRadioButton categorieF;
    private javax.swing.JRadioButton categorieH;
    private javax.swing.JLabel close;
    private javax.swing.JLabel dateF;
    private com.toedter.calendar.JDateChooser dateNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordBis;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel mdpBisF;
    private javax.swing.JLabel mdpF;
    private javax.swing.JLabel msgErreur1;
    private javax.swing.JLabel nomF;
    private javax.swing.JLabel prenomF;
    private javax.swing.JSeparator spPassword;
    private javax.swing.JSeparator spPasswordBis;
    private javax.swing.JLabel txtCategorie;
    private javax.swing.JTextField txtFonction;
    private javax.swing.JTextField txtNiveauEtude;
    private javax.swing.JTextField txtNom;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordBis;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtSpecialite;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel userF;
    // End of variables declaration//GEN-END:variables

}