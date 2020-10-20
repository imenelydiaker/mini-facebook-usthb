package interfacesGraphiques;

import static com.usthb.modeles.ClientFacebook.getClient;
import static com.usthb.modeles.ClientFacebook.reagir;
import static com.usthb.modeles.ClientFacebook.supprimerCommentaire;
import com.usthb.modeles.Commentaire;
import com.usthb.modeles.Reaction;
import static interfacesGraphiques.MurFen.getContainer;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class JCommentaire extends JPanel{

 private JLabel username,info,supprimer,reagir,nbReact;
 private JScrollPane scroll;
 private Commentaire commentaire;
 private String client=getClient();
 private int codePost;
 private int indice;
 private boolean sudo;
 private static int y=300;
    
  //Réactions
    private JPanel reactions;//Container des réactions
    private JLabel like,love,haha,sad,angry;
    private HashMap<String,Reaction> ensReactions;
   
 
    public JCommentaire(Commentaire commentaire,int indice,boolean sudo){
        this.sudo= (sudo || client.equals(commentaire.getUser()));
        this.commentaire=commentaire;
        codePost=commentaire.getCodePost();
        this.indice=indice;
        initReactions();
        init(commentaire);
    }
    
       private void initReactions(){
        ensReactions = commentaire.getReactions();
        reactions= new JPanel();
        like=new JLabel();
        love=new JLabel();
        haha=new JLabel();
        sad=new JLabel();
        angry=new JLabel();
       
        reactions.setVisible(false);
        reactions.setBounds(100,300,200,100);
        reactions.setBackground(Color.WHITE);
        reactions.setLayout(new AbsoluteLayout());
       
        like.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_20px_3.png")));
        love.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Love_20px_4.png")));
        haha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_LOL_20px_4.png")));
        sad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Sad_20px.png")));
        angry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Angry_20px_1.png")));
         
        like.setToolTipText("J'aime");
        love.setToolTipText("J'adore");
        haha.setToolTipText("Haha");
        sad.setToolTipText("Triste");
        angry.setToolTipText("En colère");
       
       
        like.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        love.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        haha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        angry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   
       
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
   
     
     private void init(Commentaire commentaire){
         
         username=new JLabel(commentaire.getUser()+":   ");
         username.setFont(new Font("Century Gothic", 1, 14));
         username.setForeground(Color.BLACK);
         
         info=new JLabel(commentaire.getComment());
         info.setFont(new Font("Century Gothic",0,14));
         info.setForeground(Color.BLACK);
        
         supprimer=new JLabel();
         supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_10px.png")));
         supprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         supprimer.setVisible(sudo);
         scroll=new JScrollPane();
         
         this.setLayout(new AbsoluteLayout());
         this.setBackground(new Color(204,204,204));
         getContainer().add(scroll,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,y, 470, 60));
         getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,y, 450, 50));
         y+=80;
         scroll.setViewportView(this);
         
         this.add(reactions,new org.netbeans.lib.awtextra.AbsoluteConstraints(25 ,10, 300, 40));
         
         this.add(username,new org.netbeans.lib.awtextra.AbsoluteConstraints(10 ,10, 80, 30));
         this.add(info,new org.netbeans.lib.awtextra.AbsoluteConstraints(100 ,10, 240, 30));
         this.add(supprimer,new org.netbeans.lib.awtextra.AbsoluteConstraints(430 ,10, 15, 30));
         username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
         
        reagir=new JLabel("Réagir");
        reagir.setForeground(new Color(123,123,123));
        reagir.setFont(new java.awt.Font("Century Gothic",0, 11));
        reagir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(commentaire.aReagis(client))
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
            reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_10px.png"))); // NOI18N
            reagir.setText("Réagir");
        }
        reagir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(reagir,new org.netbeans.lib.awtextra.AbsoluteConstraints(330 ,10,80, 30));
                
        nbReact=new JLabel(); 
        nbReact.setFont(new java.awt.Font("Century Gothic", 0, 11));
        nbReact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbReact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Heart_Outline_10px_2.png"))); // NOI18N
        nbReact.setText(Integer.toString(ensReactions.size()));
        this.add(nbReact, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));
                 
         supprimer.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jSupprimerCommentaireMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JNotif.class.getName()).log(Level.SEVERE, null, ex);
                 }
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
          
      }
    
     
     public static void reinitialiserY(){
         y=300;
     }
     
    private  void  jSupprimerCommentaireMouseClicked(java.awt.event.MouseEvent evt) throws IOException{
        supprimerCommentaire(codePost,indice); 
        this.remove(username);
        this.remove(supprimer);
        this.remove(reagir);
        this.remove(nbReact);
        info.setText("Commentaire supprimé.");
        this.updateUI();
        
     }
    
   private void jReagirMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     reactions.setVisible(!reactions.isVisible());
   }
 
     
  private void jJaimeMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.jaime);
         
  }
 
  private void jJadoreMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.jadore);
  }
 
  private void jTristeMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.triste);
  }
 
  private void jGaiMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.gai);
  }
 
   private void jEnColereMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
         reactions.setVisible(false);
         updateReactions(Reaction.encolère);
  }
 
  private void updateReactions(Reaction react) throws IOException, InterruptedException{
        if(commentaire.aReagis(client) && ensReactions.get(client).equals(react)){
           ensReactions.remove(client);
           reagir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Facebook_Like_10px.png"))); // NOI18N
           reagir.setText("  Réagir");
           reagir.setForeground(new Color(123,123,123));
        }
        else{
        ensReactions.put(client,react);
        switch(react){
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
        }
            reagir(react,commentaire.getCodePost(),indice);
            nbReact.setText(Integer.toString(ensReactions.size()));
    
   }

     
    
}


