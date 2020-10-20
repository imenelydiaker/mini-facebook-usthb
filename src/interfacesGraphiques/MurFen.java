package interfacesGraphiques;

import com.usthb.modeles.*;
import static com.usthb.modeles.ClientFacebook.afficherActu;
import static com.usthb.modeles.ClientFacebook.ajouter;
import static com.usthb.modeles.ClientFacebook.btnAjouter;
import static com.usthb.modeles.ClientFacebook.getNotifications;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static com.usthb.modeles.ClientFacebook.getInfos;
import static com.usthb.modeles.ClientFacebook.getInfosGroupe;
import static com.usthb.modeles.ClientFacebook.getInvitations;
import static com.usthb.modeles.ClientFacebook.getListeAmis;
import static com.usthb.modeles.ClientFacebook.getListeAttente;
import static com.usthb.modeles.ClientFacebook.getListeMembres;
import static com.usthb.modeles.ClientFacebook.rechercher;
import static com.usthb.modeles.ClientFacebook.rejoindreGroupe;
import static com.usthb.modeles.ClientFacebook.seDeconnecter;
import static interfacesGraphiques.JPost.reinitialiserY;
import java.util.HashMap;
import javax.swing.JOptionPane;



public class MurFen extends javax.swing.JFrame {
    private static String client;

    boolean maximized=false;
    
    public MurFen(){
        client=ClientFacebook.getClient();
        initComponents();
        this.setLocationRelativeTo(null);
        filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1.png")));
        afficherFilActu();
    }
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pere = new javax.swing.JPanel();
        plus = new javax.swing.JPanel();
        apropos = new javax.swing.JLabel();
        deconnexion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();
        creerGroupe = new javax.swing.JPanel();
        groupNameMur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        creerGroupeMur = new javax.swing.JLabel();
        aPropos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        infosMur = new javax.swing.JPanel();
        messageInvit = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageInvitation = new javax.swing.JTextField();
        envoyer = new javax.swing.JLabel();
        sexe = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        dateDeNaissance = new javax.swing.JLabel();
        specialite = new javax.swing.JLabel();
        fonction = new javax.swing.JLabel();
        niveauEtude = new javax.swing.JLabel();
        amis = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        demandes = new javax.swing.JLabel();
        ajouter = new javax.swing.JLabel();
        barre = new javax.swing.JPanel();
        filActu = new javax.swing.JLabel();
        profil = new javax.swing.JLabel();
        notifications = new javax.swing.JLabel();
        listeAmis = new javax.swing.JLabel();
        invitations = new javax.swing.JLabel();
        recherche = new javax.swing.JTextField();
        loupe = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        groupes = new javax.swing.JLabel();
        about = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mon mur");
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pere.setBackground(new java.awt.Color(224, 224, 224));
        pere.setVisible(true);
        pere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pereMouseClicked(evt);
            }
        });
        pere.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plus.setBackground(new java.awt.Color(153, 153, 153));
        plus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        plus.setVisible(false);

        apropos.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        apropos.setForeground(new java.awt.Color(255, 255, 255));
        apropos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_About_32px_5.png"))); // NOI18N
        apropos.setText("A propos");
        apropos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apropos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aproposMouseClicked(evt);
            }
        });
        plus.add(apropos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, 31));

        deconnexion.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        deconnexion.setForeground(new java.awt.Color(255, 255, 255));
        deconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Logout_Rounded_Up_32px_1.png"))); // NOI18N
        deconnexion.setText("  Déconnexion");
        deconnexion.setToolTipText("");
        deconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexionMouseClicked(evt);
            }
        });
        plus.add(deconnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));
        plus.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 10));

        pere.add(plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 220, 100));

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        creerGroupe.setBackground(new java.awt.Color(251, 251, 251));
        creerGroupe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        creerGroupe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        creerGroupe.setVisible(false);

        groupNameMur.setBackground(new java.awt.Color(251, 251, 251));
        groupNameMur.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        groupNameMur.setForeground(new java.awt.Color(51, 51, 51));
        creerGroupe.add(groupNameMur, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 250, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nom du groupe");
        creerGroupe.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, -1));

        jPanel5.setBackground(new java.awt.Color(213, 98, 71));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        creerGroupe.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, 30));

        creerGroupeMur.setBackground(new java.awt.Color(213, 98, 71));
        creerGroupeMur.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        creerGroupeMur.setForeground(new java.awt.Color(255, 255, 255));
        creerGroupeMur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creerGroupeMur.setText("Créer le groupe");
        creerGroupeMur.setOpaque(true);
        creerGroupeMur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creerGroupeMurMouseClicked(evt);
            }
        });
        creerGroupe.add(creerGroupeMur, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 130, 30));

        container.add(creerGroupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 440, 100));

        aPropos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("KERBOUA Imene Lydia");
        aPropos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 179, 32));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("ZEGHOUD Sofiane");
        aPropos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 144, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("L2 ISIL B G2");
        aPropos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("161631097093");
        aPropos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("161631100045");
        aPropos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 130, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Cette application a été créée par:");
        aPropos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 20));

        container.add(aPropos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 310, 320));

        jScrollPane1.setViewportView(container);

        pere.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 510, 490));

        infosMur.setVisible(false);
        infosMur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 98, 71)));
        infosMur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        messageInvit.setVisible(false);
        messageInvit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 98, 71)));
        messageInvit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Entrez le message à envoyer:");
        messageInvit.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        messageInvitation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(messageInvitation);

        messageInvit.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 30));

        envoyer.setBackground(new java.awt.Color(213, 98, 71));
        envoyer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        envoyer.setForeground(new java.awt.Color(255, 255, 255));
        envoyer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        envoyer.setText("Envoyer");
        envoyer.setOpaque(true);
        envoyer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                envoyerMouseClicked(evt);
            }
        });
        messageInvit.add(envoyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, 20));

        infosMur.add(messageInvit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, 110));

        sexe.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        sexe.setForeground(new java.awt.Color(51, 51, 51));
        sexe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infosMur.add(sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, 30));

        nom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(51, 51, 51));
        nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomMouseClicked(evt);
            }
        });
        infosMur.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 30));

        dateDeNaissance.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        dateDeNaissance.setForeground(new java.awt.Color(51, 51, 51));
        dateDeNaissance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infosMur.add(dateDeNaissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 30));

        specialite.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        specialite.setForeground(new java.awt.Color(51, 51, 51));
        specialite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infosMur.add(specialite, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 30));

        fonction.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fonction.setForeground(new java.awt.Color(51, 51, 51));
        fonction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infosMur.add(fonction, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 30));

        niveauEtude.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        niveauEtude.setForeground(new java.awt.Color(51, 51, 51));
        niveauEtude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infosMur.add(niveauEtude, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 180, 30));

        amis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        amis.setForeground(new java.awt.Color(51, 51, 51));
        amis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amisMouseClicked(evt);
            }
        });
        infosMur.add(amis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 180, 30));

        user.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        user.setForeground(new java.awt.Color(102, 102, 102));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        infosMur.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 120, 20));

        demandes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                demandesMouseClicked(evt);
            }
        });
        infosMur.add(demandes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 100, 20));

        ajouter.setBackground(new java.awt.Color(213, 98, 71));
        ajouter.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ajouter.setText("Ajouter");
        ajouter.setOpaque(true);
        ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajouterMouseClicked(evt);
            }
        });
        infosMur.add(ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 200, 40));

        pere.add(infosMur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 260, 490));

        getContentPane().add(pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 490));

        barre.setBackground(new java.awt.Color(153, 153, 153));
        barre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barreMouseClicked(evt);
            }
        });
        barre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filActu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filActu.setForeground(new java.awt.Color(102, 102, 102));
        filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png"))); // NOI18N
        filActu.setToolTipText("Fil d'actualité");
        filActu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filActu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filActuMouseClicked(evt);
            }
        });
        barre.add(filActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, -1));

        profil.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        profil.setForeground(new java.awt.Color(255, 255, 255));
        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png"))); // NOI18N
        profil.setText(client);
        profil.setToolTipText("Mon mur");
        profil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilMouseClicked(evt);
            }
        });
        barre.add(profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 50));

        notifications.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        notifications.setForeground(new java.awt.Color(102, 102, 102));
        notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png"))); // NOI18N
        notifications.setToolTipText("Notifications");
        notifications.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsMouseClicked(evt);
            }
        });
        barre.add(notifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 30));

        listeAmis.setBackground(new java.awt.Color(153, 153, 255));
        listeAmis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        listeAmis.setForeground(new java.awt.Color(102, 102, 102));
        listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png"))); // NOI18N
        listeAmis.setToolTipText("Liste d'amis");
        listeAmis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listeAmis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeAmisMouseClicked(evt);
            }
        });
        barre.add(listeAmis, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 40, 30));

        invitations.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        invitations.setForeground(new java.awt.Color(102, 102, 102));
        invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png"))); // NOI18N
        invitations.setToolTipText("Invitations");
        invitations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invitations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invitationsMouseClicked(evt);
            }
        });
        barre.add(invitations, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 40, 30));

        recherche.setBackground(new java.awt.Color(153, 153, 153));
        recherche.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        recherche.setForeground(new java.awt.Color(255, 255, 255));
        recherche.setToolTipText("");
        recherche.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        barre.add(recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 200, 30));

        loupe.setBackground(new java.awt.Color(40, 47, 60));
        loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png"))); // NOI18N
        loupe.setToolTipText("Rechercher");
        loupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loupe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loupeMouseClicked(evt);
            }
        });
        barre.add(loupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 30, 30));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_32px_1.png"))); // NOI18N
        close.setToolTipText("Quitter");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        barre.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png"))); // NOI18N
        groupes.setToolTipText("Groupes");
        groupes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupesMouseClicked(evt);
            }
        });
        barre.add(groupes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, 30));

        about.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        about.setForeground(new java.awt.Color(102, 102, 102));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Expand_Arrow_32px.png"))); // NOI18N
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
        });
        barre.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 40, -1));

        getContentPane().add(barre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        getAccessibleContext().setAccessibleParent(pere);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionMouseClicked
        try {
             seDeconnecter();
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
       new ConnexionFen().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_deconnexionMouseClicked

    private void notificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsMouseClicked
       infosMur.setVisible(false);
       notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1.png")));
        defaultIcons((byte)1);
       ArrayList<Notification> notifs=null;
       container.removeAll();
        try {
            JNotif.reinitialiserY();
            notifs = getNotifications();
              
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=notifs.size()-1;i>=0;i--){
             new JNotif(notifs.get(i),i);
           }
        container.updateUI();

    }//GEN-LAST:event_notificationsMouseClicked

    private void filActuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filActuMouseClicked
        plus.setVisible(false);
        filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1.png")));
        defaultIcons((byte)0);
        afficherFilActu();
    }//GEN-LAST:event_filActuMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        try {
            seDeconnecter();
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void pereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pereMouseClicked
       plus.setVisible(false);
    }//GEN-LAST:event_pereMouseClicked

    private void invitationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invitationsMouseClicked
        plus.setVisible(false);
        invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Male_32px.png"))); 
        defaultIcons((byte)2);
        afficherInvitations();
    }//GEN-LAST:event_invitationsMouseClicked

    private void profilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilMouseClicked
       plus.setVisible(false);
        defaultIcons((byte)5);
       profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1_1.png")));
        try {
            afficherMur(client);
        } catch (InterruptedException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profilMouseClicked

    private void listeAmisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeAmisMouseClicked
         try {
              infosMur.setVisible(false);
              listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1.png")));
               defaultIcons((byte)3);
             afficherAmis(getListeAmis(client),(byte) 0);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_listeAmisMouseClicked

    private void loupeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loupeMouseClicked
        plus.setVisible(false);
        String s = recherche.getText().trim();
        if(s.isEmpty()) return;
        infosMur.setVisible(false); 
        recherche.setText("");
        loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_2.png")));
        defaultIcons((byte)6);
        container.removeAll();
            try {
            JAbonne.reinitialiserY(30);
            ArrayList<String> result= rechercher(s);
            Thread.sleep(100);
            String[] tab;
            for (String ami:result) {
            tab=ami.split("\n");
            JAbonne jAbonne = new JAbonne(tab[0],tab[1],tab[2],(byte)0);
            }
            
            
            } catch (IOException | ClassNotFoundException | InterruptedException  ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
            }
            container.updateUI();
    }//GEN-LAST:event_loupeMouseClicked

    private void barreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barreMouseClicked
      plus.setVisible(false);
    }//GEN-LAST:event_barreMouseClicked

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
       plus.setVisible(!plus.isVisible()); 
    }//GEN-LAST:event_aboutMouseClicked

    private void demandesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_demandesMouseClicked
        plus.setVisible(false); 
        ArrayList<String> liste = null;
        container.removeAll();
        try {
            JAbonne.reinitialiserY(30);
            liste = getListeAttente(user.getText());
            String[] tab= new String[3];
        for (String ami:liste) {
                tab=ami.split("\n");
                JAbonne jAbonne = new JAbonne(tab[0],tab[1],tab[2],(byte) 2);
        }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        container.updateUI();
    }//GEN-LAST:event_demandesMouseClicked

    private void groupesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupesMouseClicked
        plus.setVisible(false);
        groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_1.png")));
         defaultIcons((byte)4);
        ArrayList<String> liste = null;
         infosMur.setVisible(false);
        container.removeAll();
        try {
            container.add(creerGroupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20,20, 440, 100));
            creerGroupe.setVisible(true);
            JAbonne.reinitialiserY(150);
            liste = ClientFacebook.getListeGroupes(client);
        for (String grp:liste) {
                JAbonne jAbonne = new JAbonne(grp,"*","*",(byte)0);
        }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        container.updateUI();
        creerGroupe.setVisible(true);
        container.updateUI();
    }//GEN-LAST:event_groupesMouseClicked

    private void creerGroupeMurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creerGroupeMurMouseClicked
      try {
          boolean b;
           String s=groupNameMur.getText().trim();
           if(s.isEmpty()) return;
           groupNameMur.setText("");
              b=ClientFacebook.creerGroupe(s);
              if(!b)
                 JOptionPane.showMessageDialog(null, "Nom de groupe déjà existant !","Groupe non créé", JOptionPane.ERROR_MESSAGE);
              else{
                  plus.setVisible(false);
                  ArrayList<String> liste = null;
                  container.removeAll();
                  try {
                      container.add(creerGroupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(40,20, 440, 100));
                      creerGroupe.setVisible(true);
                      JAbonne.reinitialiserY(150);
                      liste = ClientFacebook.getListeGroupes(client);
                  for (String grp:liste) {
                          JAbonne jAbonne = new JAbonne(grp,"*","*",(byte)0);
                  }
                  } catch (IOException | ClassNotFoundException ex) {
                      Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  container.updateUI();
              }
                           
      } catch (IOException ex) {
          Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_creerGroupeMurMouseClicked

    private void amisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amisMouseClicked
         try {
             byte type=0;
             ArrayList<String> liste;
             if(amis.getText().startsWith("A"))  //POUR AFFICHER LES AMIS D'UN ABONNE
                liste =getListeAmis(getUser());
             else{                                //POUR AFFICHER LES MEMBRES D'UN GROUPE
                liste= getListeMembres(nom.getText());
                if(btnAjouter(getUser(), true)==3)
                    type=1;
                 }
          
             afficherAmis(liste,type);
            
               
             
         } catch (IOException ex) {
             Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_amisMouseClicked

    private void aproposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aproposMouseClicked
        container.removeAll();
        plus.setVisible(false);
        container.add(aPropos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 310, 320));
        container.updateUI();
    }//GEN-LAST:event_aproposMouseClicked

    private void nomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomMouseClicked
        try {
            if(amis.getText().startsWith("A"))
                afficherMur(user.getText());
            else
                afficherGrp(user.getText(),true);
        } catch (InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nomMouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        try {
            if(amis.getText().startsWith("A"))
                afficherMur(user.getText());
            else
                afficherGrp(user.getText(),true);
        } catch (InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userMouseClicked

    private void ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajouterMouseClicked
        plus.setVisible(false);
        try {
            infosMur.setVisible(true);
            String s=ajouter.getText();
            switch(s){
                case "Supprimer":
                ajouter(user.getText(),""); //Le seruveur va automatiquement supprimer l'ami
                    
                    //Recharger le mur
                    if(amis.getText().startsWith("A"))
                    afficherMur(user.getText());
                    else
                    afficherGrp(user.getText(),true);
                    
                break;
                case "Accepter l'invitation":
                ajouter(user.getText(),""); //Le seruveur va automatiquement accepter l'invitation
                    
                    //Recharger le mur
                    if(amis.getText().startsWith("A"))
                    afficherMur(user.getText());
                    else
                    afficherGrp(user.getText(),true);
                    
                ajouter.setText("Amis");
                break;
                case "Annuler l'invitation":
                ajouter(user.getText(),"");  //Le seruveur va automatiquement annuler l'invitation
                ajouter.setText("Ajouter");
                break;
                case "Ajouter"://Ajouter un truc pour lire le message à envoyer
                messageInvit.setVisible(true);
                break;
                case "Rejoindre":
                rejoindreGroupe(client,user.getText()); //Le seruveur va automatiquement envoyer demande
                ajouter.setText("Demande Envoyée");
                break;
                case "Quitter le groupe": //Le seruveur va automatiquement vous faire quitter du groupe
                rejoindreGroupe(client,user.getText());
                demandes.setVisible(false);
                    
                    //Recharger le mur
                    if(amis.getText().startsWith("A"))
                    afficherMur(user.getText());
                    else
                    afficherGrp(user.getText(),true);
                    
                break;
                case "Annuler la demande":  //Le seruveur va automatiquement annuler la demande
                rejoindreGroupe(client,user.getText());
                ajouter.setText("Demande Annulée");
                break;

            }
                

        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ajouterMouseClicked

    private void envoyerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_envoyerMouseClicked
        try {
            ajouter(user.getText(),messageInvitation.getText());
            messageInvitation.setText("");
            ajouter.setText("Invitation envoyée");
            messageInvit.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_envoyerMouseClicked

 
 
  public static void afficherMur(String username) throws InterruptedException{
    try {
        container.removeAll();
        
        HashMap<String,String> infos = getInfos(username);
        
        
        //INITIALISER LES INFOS
        nom.setText(infos.get("nom"));
        dateDeNaissance.setText(infos.get("date"));
        sexe.setText(infos.get("sexe"));
        niveauEtude.setText("Niveau: "+infos.get("niveau etudes"));
        specialite.setText("Specialité: "+infos.get("specialite"));
        fonction.setText("Fonction: "+infos.get("fonction"));
        amis.setText("Amis: "+infos.get("nombre amis"));
        user.setText(username);
        demandes.setVisible(false);
        infosMur.setVisible(true);
        messageInvit.setVisible(false);
        messageInvitation.setText("");
        
         //client
        if(username.equals(client)){
            user.setVisible(false);
            ajouter.setVisible(false);
        }
        else {
            user.setVisible(true);
            ajouter.setVisible(true);
            
            Thread.sleep(100);
            byte b=btnAjouter(username,false);
            switch(b){
                case 0: 
                    ajouter.setText("Ajouter");
                    break;
                case 1:
                    ajouter.setText("Accepter l'invitation");
                    break;
                case 2: 
                    ajouter.setText("Annuler l'invitation");
                    break;
                case 3:
                    ajouter.setText("Supprimer");
                    break;
            }
        }
        
        if(username.equals(client)){
            new JPublier((byte)1);
            reinitialiserY(160);
        }else 
            reinitialiserY(20);
        
        ArrayList<Post> posts = ClientFacebook.afficherMur(username);
        
        for(Post p:posts){
            JPost jPost = new JPost(p,(byte) 1);
           }
        container.updateUI();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
  
  
  public static void afficherGrp(String groupName,boolean afficherPosts) throws InterruptedException, ClassNotFoundException{
    try {
        container.removeAll();
        user.setText(groupName);
        nom.setText(groupName);
        sexe.setText("");
        fonction.setText("");
        specialite.setText("");
        niveauEtude.setText("");
        dateDeNaissance.setText("");
        messageInvit.setVisible(false);
        messageInvitation.setText("");
        infosMur.setVisible(true);
        ajouter.setVisible(true);
        int[] infos=getInfosGroupe(groupName);
        amis.setText("Membres: "+infos[0]);
        demandes.setVisible(false);
        byte type=2;
        Thread.sleep(100);
        switch(btnAjouter(groupName,true)){
            case 0:
                reinitialiserY(20);
                ajouter.setText("Rejoindre");
                break;
            case 1:
                reinitialiserY(20);
                ajouter.setText("Annuler la demande");
                break;
            case 2:
                new JPublier(groupName);
                reinitialiserY(160);
                ajouter.setText("Quitter le groupe");
                break;
            case 3:
                type=3;
                new JPublier(groupName);
                reinitialiserY(160);
                ajouter.setText("Quitter le groupe");
                demandes.setText("Demandes: "+infos[1]);
                demandes.setVisible(true);
                break;
                
                
        }
        if(!afficherPosts) return;
        
        ArrayList<Post> posts = ClientFacebook.afficherGrp(groupName);
        for(Post p:posts){
            JPost jPost = new JPost(p,type);
           }
        container.updateUI();
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
  private void afficherAmis(ArrayList<String> liste,byte type) throws ClassNotFoundException{
        plus.setVisible(false);
        container.removeAll();
        try {
            JAbonne.reinitialiserY(30);
            String[] tab= new String[3];
        for (String ami:liste) {
                tab=ami.split("\n");
                JAbonne jAbonne = new JAbonne(tab[0],tab[1],tab[2],type);
        }
        } catch (IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        container.updateUI();
  }

  private void afficherInvitations(){
      ArrayList<Invitation> invits = null;
        container.removeAll();
        try {
            infosMur.setVisible(false);
            JInvit.reinitialiserY();
            invits=getInvitations();
        
        for(int i=invits.size()-1;i>=0;i--){
            if(invits.get(i).getEtat().getEtat().equalsIgnoreCase("Invitation envoyée")) {        
                 JInvit jInvit = new JInvit(invits.get(i),i);}
           }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        container.updateUI();
  }
   
  public static void afficherFilActu(){
      ArrayList<Post> posts = null;
        container.removeAll();
        try {
             infosMur.setVisible(false);
             reinitialiserY(160);
             posts = afficherActu();
        
            new JPublier((byte)0);
            for(Post p:posts){
                JPost jPost = new JPost(p,(byte)0);
        }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
        container.updateUI();
  }
  
    public static String getUser(){
        return user.getText();
    }
  
 
    public static JPanel getContainer(){
        return container;
    }
  
    private void defaultIcons(byte i){
        
        switch(i) {
            case 0://fil d'actu
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 1://notifications
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 2://invitations
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 3://listeAmis
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 4://groupe
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 5://profil
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 loupe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Search_32px_1.png")));
                 break;
            case 6: 
                 filActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px_1_1.png")));
                 profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Male_User_32px_1.png")));
                 notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Notification_32px_1_1.png")));
                 invitations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_User_Group_Man_Man_32px.png")));
                 listeAmis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_People_32px_1_1.png")));
                 groupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_Groups_32px_2.png")));
                 break;
        }
    }  
    
    
    
    /**
     * @param args the command line arguments
     */
    
    /*public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }}/
        //</editor-fold>
           
        /* Create and display the form */
       
        
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aPropos;
    private javax.swing.JLabel about;
    private static javax.swing.JLabel ajouter;
    private static javax.swing.JLabel amis;
    private javax.swing.JLabel apropos;
    private javax.swing.JPanel barre;
    private javax.swing.JLabel close;
    private static javax.swing.JPanel container;
    private javax.swing.JPanel creerGroupe;
    private javax.swing.JLabel creerGroupeMur;
    private static javax.swing.JLabel dateDeNaissance;
    private javax.swing.JLabel deconnexion;
    private static javax.swing.JLabel demandes;
    private javax.swing.JLabel envoyer;
    private javax.swing.JLabel filActu;
    private static javax.swing.JLabel fonction;
    private javax.swing.JTextField groupNameMur;
    private javax.swing.JLabel groupes;
    private static javax.swing.JPanel infosMur;
    private javax.swing.JLabel invitations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel listeAmis;
    private javax.swing.JLabel loupe;
    private static javax.swing.JPanel messageInvit;
    private static javax.swing.JTextField messageInvitation;
    private static javax.swing.JLabel niveauEtude;
    private static javax.swing.JLabel nom;
    private javax.swing.JLabel notifications;
    private static javax.swing.JPanel pere;
    private javax.swing.JPanel plus;
    private javax.swing.JLabel profil;
    private javax.swing.JTextField recherche;
    private static javax.swing.JLabel sexe;
    private static javax.swing.JLabel specialite;
    private static javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

    
}
