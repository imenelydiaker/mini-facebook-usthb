package interfacesGraphiques;

import static com.usthb.modeles.ClientFacebook.accepterInvitation;
import static com.usthb.modeles.ClientFacebook.refuserInvitation;
import com.usthb.modeles.Invitation;
import static interfacesGraphiques.MurFen.afficherMur;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class JInvit extends JPanel {
 private JLabel username, message,accepter,refuser,reponse;
 private Invitation inv;
 private int indice;
 private static int y=20;

 public JInvit(Invitation inv,int indice){
     this.indice=indice;
     this.inv=inv;
     init(inv);
 }   
 
 private void init(Invitation inv){
     username= new JLabel(inv.getEmetteur());
     username.setFont(new Font("Century Gothic", 1, 14));
     username.setForeground(Color.BLACK);
     
     message=new JLabel(inv.getMessage());
     message.setFont(new Font("Century Gothic", 0, 14));
     message.setForeground(Color.BLACK);
     
     
     this.setBackground(new java.awt.Color(252, 250, 251));
     this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
     this.setLayout(new AbsoluteLayout());
     MurFen.getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(90,y,300, 120));
     y+=150;
    
     this.add(username,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,10, 120, 30));
     username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
     
     this.add(message,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,40, 250, 30));
     message.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
     
     accepter=new JLabel("Accepter");
     accepter.setFont(new Font("Century Gothic", 0, 14));
     accepter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 164, 0), 2, true));
     accepter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
     accepter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     this.add(accepter,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,80, 120, 30));
     
     refuser=new JLabel("Refuser");
     refuser.setFont(new Font("Century Gothic", 0, 14));
     refuser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 2, true));
     refuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     this.add(refuser,new org.netbeans.lib.awtextra.AbsoluteConstraints(150 ,80, 120, 30));
     
     refuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     accepter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     username.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     
     reponse=new JLabel();
     reponse.setFont(new Font("Century Gothic", 1, 14));
     reponse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     this.add(reponse,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,80, 250, 30));
     
     
     accepter.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jAccepterMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JInvit.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JInvit.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
      
     refuser.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jRefuserMouseClicked(evt);
                 } catch (IOException ex) {
                     Logger.getLogger(JInvit.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(JInvit.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
     
     username.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jVoirMurMouseClicked(evt);
                 } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                     Logger.getLogger(JInvit.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
        
      }
     
  public static void reinitialiserY(){
         y=20;
     }
 
  
  private void jAccepterMouseClicked(java.awt.event.MouseEvent evt) throws IOException, UnknownHostException, InterruptedException{
         accepterInvitation(indice);
         this.remove(accepter);
         this.remove(refuser);
         reponse.setText("Invitation acceptée.");
         MurFen.getContainer().updateUI();
     }
  
  private void  jRefuserMouseClicked(java.awt.event.MouseEvent evt) throws IOException, UnknownHostException, InterruptedException{
         refuserInvitation(indice);
         this.remove(accepter);
         this.remove(refuser);
         reponse.setText("Invitation refusée.");
         MurFen.getContainer().updateUI();
  }
  
  
  private void jVoirMurMouseClicked(java.awt.event.MouseEvent evt) throws IOException, ClassNotFoundException, InterruptedException{
        afficherMur(username.getText());
  }
 
}
