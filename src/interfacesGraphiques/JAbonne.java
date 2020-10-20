package interfacesGraphiques;
 
import com.usthb.modeles.ClientFacebook;
import static com.usthb.modeles.ClientFacebook.accepterMembre;
import static com.usthb.modeles.ClientFacebook.ajouter;
import static com.usthb.modeles.ClientFacebook.ajouterAdmin;
import static com.usthb.modeles.ClientFacebook.btnAjouter;
import static com.usthb.modeles.ClientFacebook.estAdmin;
import static com.usthb.modeles.ClientFacebook.getClient;
import static com.usthb.modeles.ClientFacebook.refuserMembre;
import static com.usthb.modeles.ClientFacebook.rejoindreGroupe;
import static interfacesGraphiques.MurFen.afficherGrp;
import static interfacesGraphiques.MurFen.afficherMur;
import static interfacesGraphiques.MurFen.getUser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteLayout;
 
public class JAbonne extends JPanel {
 private JLabel boutonUn,refuser,boutonDeux;
 private JSeparator jSeparator2;
 private JScrollPane scroll;
 private static int y=30;
 private JLabel jNom,jPrenom,jName;
 private String name;
 private boolean isGroupe,demande;
 private byte type;
 
   
    public JAbonne(String name,String nom,String prenom,byte type) throws IOException, ClassNotFoundException{
        this.type=type;  // 0: NOTHING 1:POUR L'ADMIN QUAND IL VEUT SUPPRIMER UN MEMBRE 2: LES DEMANDES
        demande= type==1;
        this.name=name;
        isGroupe= nom.equals("*") || prenom.equals("*");
        this.demande=demande;
        if(!isGroupe){
            this.jNom= new JLabel(nom);
            this.jPrenom=new JLabel(prenom);
        }
          
        init();
    }
   
    private void init() throws IOException, ClassNotFoundException{
        jName=new JLabel(name);
        boutonUn=new JLabel();
        jSeparator2 = new JSeparator();
        scroll=new JScrollPane();
        boutonDeux = new JLabel();
        
       
        this.setBackground(new java.awt.Color(252, 250, 251));
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        this.setLayout(new AbsoluteLayout());
        MurFen.getContainer().add(scroll,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,y,450,110));
        MurFen.getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,y,400,70));
        y+=130;
        scroll.setViewportView(this);
       
        jName.setFont(new Font("Century Gothic", 0, 16));
        jName.setForeground(new Color(51,51,51));
       
        boutonUn.setFont(new Font("Century Gothic", 0, 14));
        boutonUn.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(boutonUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 150, 30));
       
        boutonDeux.setText("Ajouter admin");
        boutonDeux.setFont(new Font("Century Gothic", 0, 14)); 
        boutonDeux.setHorizontalAlignment(SwingConstants.CENTER);
        boutonDeux.setVisible(false);
        this.add(boutonDeux, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 55, 150, 30));
            
        boutonDeux.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boutonUn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        if(isGroupe){
            this.add(jName,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,20,170,30));
            switch(btnAjouter(name,true)){
                case 0:
                    boutonUn.setText("Rejoindre");
                    break;
                case 1:
                    boutonUn.setText("Demande envoyée");
                    break;
                case 2:
                    boutonUn.setText("Membre");
                    boutonUn.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Checkmark_10px.png")));
                    break;
                case 3:
                    boutonUn.setText("Admin");
                    break;
            }
        }else{
        this.add(jName,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,60,180,30));
        this.add(jNom,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,15,90,30));
        jNom.setFont(new Font("Century Gothic", 0, 14));
        jNom.setForeground(new Color(51,51,51));
       
        this.add(jPrenom,new org.netbeans.lib.awtextra.AbsoluteConstraints(110,15,90,30));
        jPrenom.setFont(new Font("Century Gothic", 0, 14));
        jPrenom.setForeground(new Color(51,51,51));
        if(!name.equals(getClient())){
            switch (type) {
                case 0:
                    OUTER:
                    switch (btnAjouter(name,false)) {
                        case 0:
                            boutonUn.setText("Ajouter");
                            break;
                        case 1:
                            boutonUn.setText("Accepter l'invitation");
                            break ;
                        case 2:
                            boutonUn.setText("Invitation envoyée");
                            break ;
                        case 3:
                            boutonUn.setText("Amis");
                            boutonUn.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Checkmark_10px.png")));
                            boutonDeux.setVisible(true);
                            if(ClientFacebook.estEnLigne(name)){
                                boutonDeux.setText("En ligne");
                                boutonDeux.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Record_10px.png")));
                            }else{
                                boutonDeux.setText("Déconnecté");
                                boutonDeux.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Record_10px_1.png")));
                            }         break;
                    }
                    break;
                case 1:
                    boutonUn.setText("Banir");
                    if(estAdmin(name,getUser())) break;
                    boutonDeux.setText("Ajouter admin");
                    boutonDeux.setBorder(new LineBorder(new java.awt.Color(220, 220, 220), 2, true));
                    boutonDeux.setVisible(true);
                    break;
                case 2:
                    boutonUn.setText("Accepter");
                    boutonUn.setBorder(new LineBorder(new java.awt.Color(255, 164, 0), 2, true));
                    boutonDeux.setText("Refuser");
                    boutonDeux.setBorder(new LineBorder(new java.awt.Color(220, 220, 220), 2, true));
                    boutonDeux.setVisible(true);
                    break;
                default:
                    break;
            }
 
         }    
        }
          
        boutonDeux.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
          public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jBoutonDeuxMouseClicked(evt);
                 } catch (InterruptedException | ClassNotFoundException | IOException ex) {
                     Logger.getLogger(JAbonne.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
                }
                );
         
     
       
         this.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jAbonneMouseClicked(evt);
                 } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                     Logger.getLogger(JAbonne.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
         
         boutonUn.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jBoutonMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JAbonne.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
    }
 public static void reinitialiserY(int y){
       JAbonne.y=y ;
  }    
 
private void jBoutonMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
        switch(boutonUn.getText()){
            case "Ajouter":
                ajouter(name,"Hey there!");
                boutonUn.setText("Invitation envoyée");
                //AMELIORER CA EN OUVRANT UN PANEL QUI DEMANDE DE REMPLIR LE MESSAGE
                //JOptionPane
                break;
            case "Accepter l'invitation":
                ajouter(name,"");
                boutonUn.setText("Amis");
                break;
            case "Rejoindre":
                rejoindreGroupe(getClient(),name);
                boutonUn.setText("Demande envoyée");
                break;
            case "Accepter":
                accepterMembre(name,getUser());
                boutonUn.setText("Membre");
                boutonDeux.setVisible(false);
                break;
            case "Banir":
                rejoindreGroupe(name,getUser());
                boutonUn.setText("Membre bani");
                boutonDeux.setVisible(false);
                break;
        }
         
}

private void jAbonneMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException, ClassNotFoundException{
    if(isGroupe)
        afficherGrp(name,true);
    else
        afficherMur(name);
}

private void jBoutonDeuxMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException, ClassNotFoundException{
   switch(boutonDeux.getText()){
        case "Ajouter admin":
            ajouterAdmin(name, getUser());
            boutonDeux.setText("Admin");
            boutonUn.setVisible(false);
            break;
        case "Refuser":
            refuserMembre(name,getUser());
            boutonDeux.setText("Demande refusée");
            boutonUn.setVisible(false);
            break;
   }
}



}