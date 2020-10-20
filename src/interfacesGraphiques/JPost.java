package interfacesGraphiques;

import static com.usthb.modeles.ClientFacebook.commenter;
import static com.usthb.modeles.ClientFacebook.epingler;
import static com.usthb.modeles.ClientFacebook.getClient;
import static com.usthb.modeles.ClientFacebook.getCommentaires;
import static com.usthb.modeles.ClientFacebook.getPost;
import static com.usthb.modeles.ClientFacebook.masquerPost;
import static com.usthb.modeles.ClientFacebook.partager;
import static com.usthb.modeles.ClientFacebook.reagir;
import static com.usthb.modeles.ClientFacebook.supprimerPost;
import com.usthb.modeles.Commentaire;
import com.usthb.modeles.Post;
import com.usthb.modeles.Reaction;
import static interfacesGraphiques.MurFen.afficherFilActu;
import static interfacesGraphiques.MurFen.afficherGrp;
import static interfacesGraphiques.MurFen.afficherMur;
import static interfacesGraphiques.MurFen.getContainer;
import static interfacesGraphiques.MurFen.getUser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.netbeans.lib.awtextra.AbsoluteLayout;
 
 
public class JPost extends JPanel {
 
 
    private int code;
    private HashMap<String,Reaction> ensReactions;
    private boolean etat;
    private final byte type;
    private String client=getClient();
    private boolean sudo;
    private boolean peutEpingler;
    private boolean actu;
    private JTextArea message;
    private JLabel username,epingler,commenter,supprimer,action,reagir,partager,nbReact,visibilite; 
    private JScrollPane scroll,scroll2;
    private JSeparator jSeparator1,jSeparator2;
   
    private Post post;
    private static int y=160;
   
    
    //Réactions
    private JPanel reactions;//Container des réactions
    private JLabel like,love,haha,sad,angry;
   
   //Commentaires
    private JPanel commentaires;
    private JLabel posterCommentaire;
    private JTextField commentaire;
     
    //visibilité
    private JPanel visible;
    private JLabel prive,amis,listeAmis,publique;
    private JScrollPane scroll3;
    String visiblePar="";
    
    public JPost(Post post,byte type){
        this.type=type;  // 0:FIL ACTU 1:MUR 2:GROUPE (NOT ADMIN) 3:GROUPE (ADMIN)
        this.post=post; 
        sudo= (client.equals(post.getPoster()) || type==3);  //A LE DROIT DE SUPPRIMER OU D'EPINGLER
        peutEpingler= type==3 || (type==1 & client.equals(post.getPoster()));
        actu= (type==0);
        initCommentaires();
        initReactions();
        initVisibilite();
        init(post);
        
    }
   
    private void initCommentaires(){
       commentaires=new JPanel();
       posterCommentaire=new JLabel("Commenter");
       commentaire=new JTextField();
       
       commentaires.setVisible(false);
       commentaires.setBounds(30,10,380,140);
       commentaires.setBackground(Color.WHITE);
       commentaires.setLayout(new AbsoluteLayout());
   
       commentaire.setFont(new Font("Century Gothic", 0, 12));
       commentaires.add(commentaire,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,80,250, 40));
       
       posterCommentaire.setFont(new Font("Century Gothic", 1, 14));
       posterCommentaire.setForeground(new Color(51,51,51));
       posterCommentaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
       posterCommentaire.setHorizontalAlignment(SwingConstants.CENTER);
       commentaires.add(posterCommentaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(260,80, 90, 40));
       
       
       posterCommentaire.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPosterCommentaireMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
   }
    
    private void initReactions(){
        ensReactions = post.getReactions();
        reactions= new JPanel();
        like=new JLabel();
        love=new JLabel();
        haha=new JLabel();
        sad=new JLabel();
        angry=new JLabel();
       
        reactions.setVisible(false);
        reactions.setBounds(100,300,240,100);
        reactions.setBackground(Color.WHITE);
        reactions.setLayout(new AbsoluteLayout());
       
        like.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px_3.png")));
        love.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Love_20px_4.png")));
        haha.setIcon(new ImageIcon(getClass().getResource("/images/icons8_LOL_20px_4.png")));
        sad.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Sad_20px.png")));
        angry.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Angry_20px_1.png")));
         
        like.setToolTipText("J'aime");
        love.setToolTipText("J'adore");
        haha.setToolTipText("Haha");
        sad.setToolTipText("Triste");
        angry.setToolTipText("En colère");
       
       
        like.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        love.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        haha.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        sad.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        angry.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                   
       
        reactions.add(like,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,0,50,50));
        reactions.add(love,new org.netbeans.lib.awtextra.AbsoluteConstraints(55,0,50,50));
        reactions.add(haha,new org.netbeans.lib.awtextra.AbsoluteConstraints(105,0,50,50));
        reactions.add(sad,new org.netbeans.lib.awtextra.AbsoluteConstraints(155,0,50,50));
        reactions.add(angry,new org.netbeans.lib.awtextra.AbsoluteConstraints(205,0,50,50));
       
     
       
         like.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jJaimeMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
        love.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jJadoreMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
        haha.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jGaiMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
        sad.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jTristeMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
        angry.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jEnColereMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
       
    }
   
    
   private void initVisibilite(){
        visible=new JPanel(); 
        prive=new JLabel("Moi uniquement");
        amis=new JLabel("Amis");
        listeAmis=new JLabel("Amis et leurs amis");
        publique=new JLabel("Public");
        
        
        visible.setBounds(120,300,120,150);
        visible.setBackground(new Color(252, 250, 251));
        visible.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        visible.setLayout(new AbsoluteLayout());
        
       
        prive.setFont(new Font("Century Gothic", 0, 11));
        prive.setHorizontalAlignment(SwingConstants.CENTER);
        prive.setForeground(Color.BLACK);
        visible.add(prive,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,5,100,15));
        
        amis.setFont(new Font("Century Gothic", 0, 11));
        amis.setHorizontalAlignment(SwingConstants.CENTER);
        amis.setForeground(Color.BLACK);
        visible.add(amis,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,30,100,15));
    
        listeAmis.setFont(new Font("Century Gothic", 0, 11));
        listeAmis.setHorizontalAlignment(SwingConstants.CENTER);
        listeAmis.setForeground(Color.BLACK);
        visible.add(listeAmis,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,55,100,15));
    
        publique.setFont(new Font("Century Gothic", 0, 11));
        publique.setHorizontalAlignment(SwingConstants.CENTER);
        publique.setForeground(Color.BLACK);
        visible.add(publique,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,80,100,15));
        
        
         prive.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPriveMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
         amis.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jAmisMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
         listeAmis.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jListeAmisMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
         publique.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPubliqueMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
        
    }
  
   
    private void init(Post post){
        client= getClient();
        code = post.getCodePost();
        etat=post.isEpinglee();
        username=new JLabel(post.getPoster());
        message= new JTextArea(post.getContenu());
        message.setLineWrap(true);
        commenter=new JLabel();
        reagir=new JLabel();
        partager=new JLabel();
        nbReact=new JLabel();
        jSeparator1=new JSeparator();
        jSeparator2=new JSeparator();
        epingler=new JLabel();
        epingler.setVisible(false);
        supprimer=new JLabel();
        supprimer.setVisible(false);
        scroll=new JScrollPane();
        scroll2=new JScrollPane();
        scroll3=new JScrollPane();
        visibilite=new JLabel();
       
        this.setBackground(new java.awt.Color(252, 250, 251));
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        this.setLayout(new AbsoluteLayout());
        MurFen.getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,y,400,160));
        y+=180;
       
        this.add(commentaires,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,10,380,150));
        this.add(reactions,new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50,250,60));
        
        this.add(scroll3,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 180,190));
        this.add(visible,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20,120, 50));
        visible.setVisible(false);
        scroll3.setVisible(false);
        scroll3.setViewportView(visible);
        
        visibilite.setFont(new Font("Century Gothic", 0, 14));
        visibilite.setForeground(new Color(51,51,51));
        switch(post.getNiveauVisibilite()){
            case privé:
                visibilite.setText("Moi uniquement");
                break;
            case amis :
                visibilite.setText("Amis");
                break;
            case listeamis:
                visibilite.setText("Amis et leurs amis");
                break;
            case publique: 
                visibilite.setText("Public");
                break;
        }
        this.add(visibilite,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 20));
        
        username.setFont(new Font("Century Gothic", 1, 14));
        username.setForeground(new Color(255, 153, 0));
        this.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 20));
       
       
        if(!actu){  //VERIFIER SI LE POST APPRATIENT AU MUR OU AU FIL D'ACTUALITE
               
                epingler.setVisible(true);
                if(etat)
                    epingler.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Unpin_2_20px.png")));
                else
                if(peutEpingler)
                    epingler.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Pin_20px_2.png")));
                else
                epingler.setVisible(false);
                epingler.setCursor(new Cursor(Cursor.HAND_CURSOR));
                this.add(epingler, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 20, 20));
        }
       
       
        if(actu || sudo){
            supprimer.setVisible(true);
            supprimer.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Trash_20px.png")));
            supprimer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 20, 20));
        }
       
       
        jSeparator2.setBackground(new Color(237, 237, 237));
        jSeparator2.setForeground(new Color(255, 102, 0));
        this.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 10));
       
       
        message.setFont(new Font("Century Gothic", 0, 12));
        message.setEditable(false);
        this.add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 50));
        this.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 50));
        scroll2.setViewportView(message);
       
       
        jSeparator1.setBackground(new Color(237, 237, 237));
        jSeparator1.setForeground(new Color(255, 102, 0));
        this.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 10));
       
       
        commenter.setFont(new Font("Century Gothic", 1, 12));
        commenter.setForeground(new Color(102,102,102));
        commenter.setHorizontalAlignment(SwingConstants.CENTER);
        commenter.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Comments_20px.png"))); // NOI18N
        commenter.setText("  Commenter");
        this.add(commenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, 20));
        commenter.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       
        nbReact.setFont(new Font("Century Gothic", 0, 12));
        nbReact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbReact.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Heart_Outline_10px_2.png"))); // NOI18N
        nbReact.setText(Integer.toString(ensReactions.size()));
        this.add(nbReact, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 50, 10));
 
        reagir.setForeground(new Color(102,102,102));
        reagir.setFont(new java.awt.Font("Century Gothic", 1, 12));
        reagir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(post.aReagis(client))
            switch(ensReactions.get(client)){
                case jaime:
                    reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px_3.png")));
                    reagir.setText("J'aime");
                    reagir.setForeground(new Color(0,0,205));
                    break;
                case jadore:
                    reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Love_20px_4.png")));
                    reagir.setText("J'adore");
                    reagir.setForeground(new Color(242,112,131));
                    break;
                case gai:
                    reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_LOL_20px_4.png")));
                    reagir.setText("Haha");
                    reagir.setForeground(new Color(240,186,21));
                    break;
                case triste:
                    reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Sad_20px.png")));
                    reagir.setText("Triste");
                    reagir.setForeground(new Color(240,186,21));
                    break;
                case encolère:
                    reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Angry_20px_1.png")));
                    reagir.setText("Grrr");
                    reagir.setForeground(new Color(247,126,92));
                    break;
            }
           
        else{
            reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px.png"))); // NOI18N
            reagir.setText("  Réagir");
        }
        this.add(reagir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 20));
        reagir.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        partager.setForeground(new Color(102,102,102));
        partager.setFont(new Font("Century Gothic", 1, 12));
        partager.setHorizontalAlignment(SwingConstants.CENTER);
        partager.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Share_20px_4.png"))); // NOI18N
        partager.setText("  partager");
        this.add(partager, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 90, 20));
        partager.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        action= new JLabel("Publication supprimée.");
        action.setFont(new Font("Century Gothic", 1, 14));
        action.setHorizontalAlignment(SwingConstants.CENTER);
        
        username.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     usernameMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         partager.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPartagerMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
     
         commenter.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jCommenterMouseClicked(evt);
            }
        }
        );
     
         
         reagir.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jReagirMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
         epingler.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jEpinglerMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
          supprimer.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jSupprimerMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
          
          this.addMouseListener(new MouseAdapter(){
             @Override
            public void mouseClicked(MouseEvent evt) {
                jThisMouseClicked(evt);
            }
        }
        );
       
       
    }
 
    private void jThisMouseClicked(MouseEvent evt){
        visible.setVisible(false);
        scroll3.setVisible(false);
    }
   
  private void jEpinglerMouseClicked(MouseEvent evt) throws IOException{
        if(peutEpingler){
            epingler(post.getCodePost());
            etat=!etat;
            if(etat)
                epingler.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Unpin_2_20px.png")));
            else
                epingler.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Pin_20px_2.png")));
        }
        
 
  }
 
  private void jSupprimerMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         if(!actu){
             if(type!=1) //Si ce n'est pas un profil et pas une actu alors c'est publié dans un groupe
                supprimerPost(code,getUser()); 
             else
                supprimerPost(code,null);
             
                this.removeAll();
                this.add(action,new org.netbeans.lib.awtextra.AbsoluteConstraints(80,50, 200, 50));
                this.updateUI();}
          else{
                masquerPost(code);
                this.removeAll();
                action.setText("Publication masquée.");
                this.add(action,new org.netbeans.lib.awtextra.AbsoluteConstraints(80,50, 200, 50));
                this.updateUI();}
  }
 
 
  private void jPartagerMouseClicked(MouseEvent evt) throws IOException{
     
        if(visible.isVisible()){
            visible.setVisible(false);
            scroll3.setVisible(false);
        }
        else{
            visible.setVisible(true);
            scroll3.setVisible(true);
        }
     
  }
 
 
  private void jCommenterMouseClicked(MouseEvent evt){
         afficherCommentaires();
  }
  
   private void jPosterCommentaireMouseClicked(MouseEvent evt) throws IOException{
      String c=commentaire.getText().trim();
       if(!c.isEmpty()) 
             commenter(code,c);
        commentaire.setText("");
        afficherCommentaires();
  }
  
 
 
  private void jReagirMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
      reactions.setVisible(!reactions.isVisible());
    }
 
   
 
  private void jJaimeMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.jaime);
         
  }
 
  private void jJadoreMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.jadore);
  }
 
  private void jTristeMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.triste);
  }
 
  private void jGaiMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.gai);
  }
 
   private void jEnColereMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.encolère);
  }
 
  private void updateReactions(Reaction react) throws IOException, InterruptedException{
        if(post.aReagis(client) && ensReactions.get(client).equals(react)){
           ensReactions.remove(client);
           reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px.png"))); // NOI18N
           reagir.setText("  Réagir");
           reagir.setForeground(new Color(102,102,102));
        }
        else{
        ensReactions.put(client,react);
        switch(react){
                case jaime:
                    reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px_3.png")));
                    reagir.setText("J'aime");
                    reagir.setForeground(new Color(0,0,205));
                    break;
                case jadore:
                    reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Love_20px_4.png")));
                    reagir.setText("J'adore");
                    reagir.setForeground(new Color(242,112,131));
                    break;
                case gai:
                    reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_LOL_20px_4.png")));
                    reagir.setText("Haha");
                    reagir.setForeground(new Color(240,186,21));
                    break;
                case triste:
                    reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Sad_20px.png")));
                    reagir.setText("Triste");
                    reagir.setForeground(new Color(240,186,21));
                    break;
                case encolère:
                    reagir.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Angry_20px_1.png")));
                    reagir.setText("Grrr");
                    reagir.setForeground(new Color(247,126,92));
                    break;
            }
        }
            reagir(react,code,null);
            nbReact.setText(Integer.toString(ensReactions.size()));
    
   }

       
  private void jPriveMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
     visible.setVisible(false);
     scroll3.setVisible(false);
     visiblePar="privé";
     partager(post.getCodePost(), visiblePar); 
     updatePosts();
           
  }
  
  private void jAmisMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
    visible.setVisible(false);
    scroll3.setVisible(false);
    visiblePar="amis";
     partager(post.getCodePost(), visiblePar); 
     updatePosts();
           
     
  }
  
  private void jListeAmisMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     visible.setVisible(false);
     scroll3.setVisible(false);
     visiblePar="listeamis";
     partager(post.getCodePost(), visiblePar); 
     updatePosts();      
    
  }
  
  private void jPubliqueMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
     visible.setVisible(false);
     scroll3.setVisible(false);
     visiblePar="publique";
     partager(post.getCodePost(), visiblePar); 
     updatePosts();     
    
  }
  
  private void usernameMouseClicked(MouseEvent evt) throws IOException, InterruptedException{
    afficherMur(username.getText());
  }
  
  
  private void updatePosts() throws InterruptedException{
      switch(type){
          case 0:
              afficherFilActu();
              break;
          case 1:
              afficherMur(client);
              break;
          case 2:
              afficherMur(getUser());
              break;
          case 3: 
              afficherMur(getUser());
              break;
      }
  }
  
 private void afficherCommentaires(){
      ArrayList<Commentaire> liste=null;
      getContainer().removeAll();
        try {
             JCommentaire.reinitialiserY();
             liste = getCommentaires(code);
             y=20;
             JPost jPost = new JPost(post,type);
             supprimer.setVisible(false);
             getContainer().add(commentaires,new org.netbeans.lib.awtextra.AbsoluteConstraints(40,110,400,180));
             commentaires.setVisible(true);
             int i=0;
             for(Commentaire c:liste){
                if(c.isVisible())
                    new JCommentaire(c,i,sudo);
                i++;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
        }
         getContainer().updateUI();

  }
 
  public static void afficherPost(int code) throws IOException, ClassNotFoundException{
      JPost p=new JPost(getPost(code),(byte)1);
      p.afficherCommentaires();
    }
 
  public static void reinitialiserY(int y){
      JPost.y=y;
  }
 
}