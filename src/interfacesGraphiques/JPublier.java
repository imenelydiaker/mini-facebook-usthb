package interfacesGraphiques;

import com.usthb.modeles.ClientFacebook;
import static com.usthb.modeles.ClientFacebook.getClient;
import static com.usthb.modeles.ClientFacebook.publier;
import static interfacesGraphiques.MurFen.afficherFilActu;
import static interfacesGraphiques.MurFen.afficherGrp;
import static interfacesGraphiques.MurFen.afficherMur;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class JPublier extends JPanel{
  
    private JTextField publication;
    private JLabel poster,visible,username;
    private JPanel posterPane;
    private JSeparator jSeparator;
    private final byte type;  // 0:FIL ACTU 1:MUR 
    //visibilité
    private JPanel visibilite;
    private JLabel prive,amis,listeAmis,publique,groupe;
    private String visiblePar="";
    private JScrollPane scroll;
    
    
    public JPublier(byte type){
        this.type=type;
        initVisibilite();
        initPublier(); 
        
    }
    
    public JPublier(String groupName){
        type=0;
        initVisibilite(groupName);
        initPublier(groupName);
        
    }
    
  
    private void initVisibilite(){
        visibilite=new JPanel();
        prive=new JLabel("Moi uniquement");
        amis=new JLabel("Amis");
        listeAmis=new JLabel("Amis et leurs amis");
        publique=new JLabel("Public");
        
        visibilite.setVisible(false);
        visibilite.setBounds(120,300,120,150);
        visibilite.setBackground(new java.awt.Color(252, 250, 251));
        visibilite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        visibilite.setLayout(new AbsoluteLayout());
       
        prive.setFont(new java.awt.Font("Century Gothic", 0, 11));
        prive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prive.setForeground(Color.BLACK);
        visibilite.add(prive,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,5,100,15));
        
        amis.setFont(new java.awt.Font("Century Gothic", 0, 11));
        amis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amis.setForeground(Color.BLACK);
        visibilite.add(amis,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,30,100,15));
    
        listeAmis.setFont(new java.awt.Font("Century Gothic", 0, 11));
        listeAmis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listeAmis.setForeground(Color.BLACK);
        visibilite.add(listeAmis,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,55,100,15));
    
        publique.setFont(new java.awt.Font("Century Gothic", 0, 11));
        publique.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        publique.setForeground(Color.BLACK);
        visibilite.add(publique,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,80,100,15));
        
      
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
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
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
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
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
    
    
    private void initPublier(){
        publication = new JTextField();
        poster=new JLabel("Publier");
        visible=new JLabel("Visibilité");
        scroll=new JScrollPane();
        posterPane=new JPanel();
        username=new JLabel(getClient());
        jSeparator=new JSeparator();
        
        this.setBackground(new Color(252, 250, 251));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        this.setLayout(new AbsoluteLayout());
        MurFen.getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,20,400,120));
       
     
        scroll.setVisible(false);
        this.add(scroll,new org.netbeans.lib.awtextra.AbsoluteConstraints(120,30,250,70));
        scroll.add(visibilite,new org.netbeans.lib.awtextra.AbsoluteConstraints(120,30,200,50));
        scroll.setViewportView(visibilite);
        
        posterPane.setBounds(40,70,80,25);
        posterPane.setLayout(new AbsoluteLayout());
        posterPane.setBackground(new java.awt.Color(213,98,71));
        this.add(posterPane,new org.netbeans.lib.awtextra.AbsoluteConstraints(260,90,80,25));
        
        publication.setBounds(40,20,400,100);
        publication.setFont(new java.awt.Font("Century Gothic", 0, 14));
        publication.setForeground(Color.BLACK);
        this.add(publication,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,40,380,40));
       
        poster.setFont(new java.awt.Font("Century Gothic", 0, 15));
        poster.setForeground(new java.awt.Color(255,255,255));
        poster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posterPane.add(poster,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,80,25));
       
        username.setFont(new java.awt.Font("Century Gothic", 1, 14));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setForeground(new java.awt.Color(255, 153, 0));
        this.add(username,new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 20)); 
        
        visible.setFont(new java.awt.Font("Century Gothic",0, 14));
        visible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visible.setForeground(new java.awt.Color(51,51,51));
        this.add(visible,new org.netbeans.lib.awtextra.AbsoluteConstraints(180,10,120,20));
       
        jSeparator.setBackground(new java.awt.Color(237, 237, 237));
        jSeparator.setForeground(new java.awt.Color(255, 102, 0));
        this.add(jSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, 10));
        
        poster.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPosterMouseClicked(evt);
                 } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
        
        username.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     afficherMur(username.getText());
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
        
        
       
       visible.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jVisibleParMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
    }
    
    
      private void initVisibilite(String groupName){
         visibilite=new JPanel();
         publique=new JLabel("Public");
         groupe=new JLabel(groupName);
         
        visibilite.setVisible(false);
        visibilite.setBounds(120,100,120,40);
        visibilite.setBackground(new java.awt.Color(252, 250, 251));
        visibilite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        visibilite.setLayout(new AbsoluteLayout());
       
        groupe.setFont(new java.awt.Font("Century Gothic", 0, 11));
        groupe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupe.setForeground(Color.BLACK);
        visibilite.add(groupe,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,5,100,15));
        
        publique.setFont(new java.awt.Font("Century Gothic", 0, 11));
        publique.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        publique.setForeground(Color.BLACK);
        visibilite.add(publique,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,25,100,15));
        
        publique.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPubliqueMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
        
         groupe.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jGroupeMouseClicked(evt, groupName);
                 } catch (IOException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
    }
    
    
    
    
     private void initPublier(String groupName){
        publication = new JTextField();
        poster=new JLabel("Publier");
        visible=new JLabel("Visibilité");
        scroll=new JScrollPane();
        posterPane=new JPanel();
        username=new JLabel(getClient());
        jSeparator=new JSeparator();
        
        this.setBackground(new Color(252, 250, 251));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        this.setLayout(new AbsoluteLayout());
        MurFen.getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,20,400,120));
       
        this.add(visibilite,new org.netbeans.lib.awtextra.AbsoluteConstraints(140,50,160,50));
 
        posterPane.setBounds(40,70,80,25);
        posterPane.setLayout(new AbsoluteLayout());
        posterPane.setBackground(new java.awt.Color(204,204,204));
        posterPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        this.add(posterPane,new org.netbeans.lib.awtextra.AbsoluteConstraints(260,90,80,25));
        
        publication.setBounds(40,20,400,100);
        publication.setFont(new java.awt.Font("Century Gothic", 0, 14));
        publication.setForeground(Color.BLACK);
        this.add(publication,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,40,380,40));
       
        poster.setFont(new java.awt.Font("Century Gothic", 0, 15));
        poster.setForeground(new java.awt.Color(51,51,51));
        poster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posterPane.add(poster,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,80,25));
       
        username.setFont(new java.awt.Font("Century Gothic", 1, 14));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setForeground(new java.awt.Color(255, 153, 0));
        this.add(username,new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 20)); 
        
        visible.setFont(new java.awt.Font("Century Gothic",0, 14));
        visible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visible.setForeground(new java.awt.Color(51,51,51));
        this.add(visible,new org.netbeans.lib.awtextra.AbsoluteConstraints(180,10,120,20));
       
        jSeparator.setBackground(new java.awt.Color(237, 237, 237));
        jSeparator.setForeground(new java.awt.Color(255, 102, 0));
        this.add(jSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 10));
        
        poster.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jPosterMouseClicked(evt,groupName);
                 } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                     Logger.getLogger(JPublier.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
       visible.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jVisibleParMouseClicked(evt);
                 } catch (IOException | InterruptedException ex) {
                     Logger.getLogger(JPost.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
       
    }
    
    
  private void jPriveMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     visibilite.setVisible(false);
     scroll.setVisible(false);
     visiblePar="privé";
     visible.setText("Moi uniquement");
  }
  
  private void jAmisMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     visibilite.setVisible(false);
     scroll.setVisible(false);
     visiblePar="amis";
     visible.setText("Amis");
  }
  
  private void jListeAmisMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     visibilite.setVisible(false);
     scroll.setVisible(false);
     visiblePar="listeamis";
     visible.setText("Amis et leurs amis");
  }
  
  private void jPubliqueMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
     visibilite.setVisible(false);
     scroll.setVisible(false);
     visiblePar="publique";
     visible.setText("Public");
  }
  
   private void jPosterMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException, ClassNotFoundException{
       String p=publication.getText().trim();
       if(!visiblePar.isEmpty() && !p.isEmpty()){
             publier(p, visiblePar);
             visiblePar="";
             Thread.sleep(30);
             if(type==0)  
                   afficherFilActu();
               else
                   afficherMur(getClient());
        }
  }   
  
  
  private void jPosterMouseClicked(java.awt.event.MouseEvent evt, String groupName) throws IOException, InterruptedException, ClassNotFoundException{
        if(!visiblePar.isEmpty() && !publication.getText().isEmpty()){
                publier(publication.getText(),visiblePar,groupName);
                publication.setText("");
                Thread.sleep(100);
                afficherGrp(groupName,true);
        }
  }
 

   private void jVisibleParMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException{
       if(visibilite.isVisible()){
            scroll.setVisible(false);
            visibilite.setVisible(false);}
       else{
           scroll.setVisible(true);
           visibilite.setVisible(true);
       }
       
  }
 
  
  private void jGroupeMouseClicked(java.awt.event.MouseEvent evt , String groupName) throws IOException, InterruptedException{
     visibilite.setVisible(false);
     scroll.setVisible(false);
     visiblePar="groupe";
     visible.setText(groupName);
  }
 
    
}
