package interfacesGraphiques;


import static com.usthb.modeles.ClientFacebook.getListeAttente;
import static com.usthb.modeles.ClientFacebook.lireNotification;
import com.usthb.modeles.Notification;
import com.usthb.modeles.NotificationType;
import static interfacesGraphiques.JPost.afficherPost;
import static interfacesGraphiques.MurFen.afficherGrp;
import static interfacesGraphiques.MurFen.afficherMur;
import static interfacesGraphiques.MurFen.getContainer;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class JNotif extends JPanel{
    
 private JLabel username,info;
 private Notification notif;
 private final int indice;
 private static int y=20;
    
    public JNotif(Notification notif,int indice){
        this.notif=notif;
        this.indice=indice;
        init(notif);
    }
     
     
     private void init(Notification notif){
         
         username=new JLabel(notif.getPoster());
         username.setFont(new Font("Century Gothic", 1, 14));
         username.setForeground(Color.BLACK);
         info=new JLabel(notif.getType().getType()+notif.getInformation());
         info.setFont(new Font("Century Gothic",0,14));
         info.setForeground(Color.BLACK);
        
         
         this.setLayout(new AbsoluteLayout());
         getContainer().add(this,new org.netbeans.lib.awtextra.AbsoluteConstraints(20 ,y, 420, 50));
         y+=70;
         
         this.add(username,new org.netbeans.lib.awtextra.AbsoluteConstraints(10 ,10, 100, 30));
         username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
         this.add(info,new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10,280, 30));
          
         if(!notif.getEtat())
             this.setBackground(new Color(204,204,255));
         else 
             this.setBackground(new Color(237, 237, 237));
         
         username.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                  try {
                     if(!notif.getType().equals(NotificationType.groupe))
                        afficherMur(username.getText());
                     else
                         afficherGrp(username.getText(),true);
                 } catch (InterruptedException | ClassNotFoundException ex) {
                     Logger.getLogger(JNotif.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
                 
                 
         this.addMouseListener(new java.awt.event.MouseAdapter(){
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 try {
                     jNotifMouseClicked(evt);
                 } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                     Logger.getLogger(JNotif.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        );
         
      }
    
     
     public static void reinitialiserY(){
         y=20;
     }
     
    private  void  jNotifMouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException, ClassNotFoundException{
        lireNotification(indice);
        String str;
        Integer code;
        switch(notif.getType()){
            case publication:
                code= (Integer) notif.getInfo();
                afficherPost(code);
                break;
            case commentaire:
                code= (Integer) notif.getInfo();
                afficherPost(code);
                break;
            case reaction:
              code= (Integer) notif.getInfo();
              afficherPost(code);
                break;
            case invitation:
                str= (String) notif.getInfo();
                afficherMur(str);
                break;
            case groupe:
                str= (String) notif.getInfo();
                afficherGrp(str,true);
                break;
            case demande:
                str= (String) notif.getInfo();
                afficherGrp(str,false);
                    try {
                        getContainer().removeAll();
                        JAbonne.reinitialiserY(30);
                        ArrayList<String> liste = getListeAttente(str);
                        String[] tab= new String[3];
                    for (String ami:liste) {
                            tab=ami.split("\n");
                            JAbonne jAbonne = new JAbonne(tab[0],tab[1],tab[2],(byte) 2);
                    }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(MurFen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    getContainer().updateUI();
                break;
            case partage:
              code= (Integer) notif.getInfo();
              afficherPost(code);
                break;
                
                
                
                
                
        }
     }
    
}
