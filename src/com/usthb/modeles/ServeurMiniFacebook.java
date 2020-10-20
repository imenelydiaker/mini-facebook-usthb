package com.usthb.modeles;
 
import interfacesGraphiques.InterfaceServeur;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 
class ServeurMiniFacebook {
   
        //TOUS LES ABONNES
        private static HashMap<String,Abonne> baseAbonnes= new HashMap<String,Abonne>(); //la cl? est le username de l'abonn?
       
        //TOUS LES GROUPES
        private static HashMap<String,Groupe> baseGroupes= new HashMap<String,Groupe>(); //la cl? est le nom du groupe
     
        //TOUS LES POSTS
        private static HashMap<Integer,Post> basePosts= new HashMap<Integer,Post>();//la clé est la le codePost
       
        
        //methode qui retourne l'abonné à partir d'un username
        private static Abonne getAbonne(String username) {
            return baseAbonnes.get(username);
        }
       
       //methode qui retourne le groupe à partir du nom du groupe
        private static Groupe getGroupe(String groupName) {
            return baseGroupes.get(groupName);
        }
       
      //methode qui retourne le poste à partir du code post
        private static Post getPost(Integer codePost) {
            return basePosts.get(codePost);
        }
       
       
        //méthode qui vérifie si un abonné existe dans la base
        private static boolean userExiste(String username) {
            return baseAbonnes.containsKey(username);
        }
        
        //méthode qui vérifie si un groupe existe dans la base 
        private static boolean groupeExiste(String groupName) {
            return baseGroupes.containsKey(groupName);
        }
       
        //méthode qui vérifie si un poste existe dans la base
        private static boolean postExiste(int codePost) {
            return basePosts.containsKey(codePost);
        }
       
       
              /***************REQUETES*****************/
       
       
       
                /************ABONNES***********/
       
        private static Abonne inscrireAbonne(Abonne abo){ 
            baseAbonnes.put(abo.getUsername(),abo);
            return abo;
        }
       
       
        private static void supprimerAbonne(String user) {//désactiver le compte
            baseAbonnes.remove(user);
        }
       
        private static boolean estEnLigne(String username){
            return getAbonne(username).isOnline();
        }
       
       
        private static void quitterGroupe(String user,String grp){
           Abonne abo=getAbonne(user);
           Groupe g = getGroupe(grp);
           if(g==null) return;
            g.supprimerMembre(user);
            abo.quitterGroupe(grp);
            if(g.nbrAdmins()==0){
                for(String s:g.getMembres()){
                    g.ajouterAdmin(s);      //SI IL N'Y A PLUS D'ADMINS ALORS AJOUTER UN ADMIN PARMIS LES MEMBRES
                    return;
                }
            }
            
           //SUPPRIMER LES POSTES DU GROUPE DU FIL D'ACTU
            
           ArrayList<Integer> actu= abo.getActu();
           
           actu.removeAll(g.getMur());
        }
       
       private static void rejoindreGroupe(String user,String grp){
           Groupe g=getGroupe(grp);
           if(g==null) return;
           g.rejoindre(user);
           if(g.nbrAdmins()!=0){
                ArrayList<String> admins = g.getAdmins();
                for(String a:admins){
                    notifier(a,user,grp,"demande",grp);
                }
           }
           else{                             //Si il n'y a pas d'admins (et donc pas de membres du tout)
               accepterMembre(user,grp);     // alors accepter directement la demande
               g.ajouterAdmin(user);         //et ajouter la personne comme admin
           }
        }
       
       private static void accepterMembre(String user,String grp){
           Abonne abo = getAbonne(user);
           Groupe g=getGroupe(grp);
            if(g==null) return;
            g.ajouterMembre(user);
            abo.ajouterGroupe(grp);
            
            //Ajouter les posts du groupe au fil d'actu
            
            ArrayList<Integer> actu= abo.getActu();
           
            actu.addAll(g.getMur());

            Collections.sort(actu);
            
            notifier(user, grp, " votre demande.", "groupe",grp);
            
       }
       
       private static byte etatMembre(String user,String grp){ //l'etat d'un membre par rapport à un groupe
           Groupe g=getGroupe(grp);
           if(g==null) return 4;                    //Erreur
           if(g.adminExiste(user)) return 3;        //admin
           if(g.membreExiste(user)) return 2;       //membre
           if(g.demandeEnvoyée(user)) return 1;     //demande envoyée
           return 0;                                //pas membre
       }
       
       
       private static void ajouter(String user,String ami,String message) {  //ajouter qlqn
          Abonne abo=getAbonne(ami);
          abo.ajouterInvitation(new Invitation(user,message));
          
        }
       
       private static void refuserInvitation(String user1,int indice){  //refuser l'invitation de quelqu'un
           getAbonne(user1).refuserInvitation(indice);  //Le user envoie l'indice de l'invitation dans son tableau d'invitations
       }                                               //complexité O(1)
 
       
       private static void accepterInvitation(String user1,int indice){  //refuser l'invitation de quelqu'un
           
         //Le user envoie l'indice de l'invitation dans son tableau d'invitations
         //complexité O(1)
                                             
          Abonne abo1=getAbonne(user1),
                 abo2=getAbonne(abo1.accepterInvitation(indice));
          if(abo2==null) return;
          abo1.ajouterAmi(abo2.getUsername());
          abo2.ajouterAmi(user1);
          
          //AJOUTER LES POSTES DU FIL D'ACTU
            
          ArrayList<Integer> actu= abo1.getActu();
          
          for(Integer code:abo2.getMur()){
              if(!getPost(code).getNiveauVisibilite().equals(Visibilite.privé))
                  actu.add(code);
          }
          
          Collections.sort(actu);
          
          actu = abo2.getActu();
          
          for(Integer code:abo1.getMur()){
              if(!getPost(code).getNiveauVisibilite().equals(Visibilite.privé))
                  actu.add(code);
          }
          
          Collections.sort(actu);
          
          notifier(abo2.getUsername(),user1," votre invitation.","invitation",user1);
        }
       
       private static void accepterInvitation(String user1,String user2){
           //Accepter invitation, le user envoie username du 2eme abonné
           //cas d'acceptation invitation via un jAbonne
         
          Abonne abo1=getAbonne(user1),
                 abo2=getAbonne(user2);
          if(abo2==null) return;
          abo1.accepterInvitation(user2);
          abo1.ajouterAmi(user2);
          abo2.ajouterAmi(user1);
          
         //AJOUTER LES POSTES DU FIL D'ACTU
            
          ArrayList<Integer> actu= abo1.getActu();
          
          for(Integer code:abo2.getMur()){
              if(!getPost(code).getNiveauVisibilite().equals(Visibilite.privé))
                  actu.add(code);
          }
          
          Collections.sort(actu);
          
          actu = abo2.getActu();
          
          for(Integer code:abo1.getMur()){
              if(!getPost(code).getNiveauVisibilite().equals(Visibilite.privé))
                  actu.add(code);
          }
          
          Collections.sort(actu);
          
          notifier(user2,user1," votre invitation.","invitation",user1);
        }
       
       
 
      private static void supprimerAmi(String user,String ami){//supprimer qlqn de sa liste d'ami
           Abonne abo1=getAbonne(user);
           Abonne abo2=getAbonne(ami);
           abo1.supprimerAmi(ami);
           abo2.supprimerAmi(user);
            
            //SUPPRIMER LES POSTES DU FIL D'ACTU
            
           ArrayList<Integer> actu= abo1.getActu();
           
           actu.removeAll(abo2.getMur());
           
           actu = abo2.getActu();
           
           actu.removeAll(abo1.getMur());
        }
       
       
                /************GROUPES************/
       
        private static Groupe creerGroupe(String createur,String groupName){
            Abonne abo=getAbonne(createur);
            Groupe grp=new Groupe(createur,groupName);
            baseGroupes.put(groupName, grp);
            abo.ajouterGroupe(groupName);
            return grp;
        }
       
           
                         /*****POSTS*****/
        private static Post creerPost(String poster,String contenu, String visibilite){
            Post p=new Post(poster, contenu, visibilite);
            basePosts.put(p.getCodePost(), p);
            return p;
        }
               
                     /*********AUTRES METHODES UTILES**********/
       
        public static boolean checkPassword(String user,String password){ //vérifier si c'est le bon mort de passe
            return getAbonne(user).getPassword().equals(password);
           
        }
               
        private static void notifier(String recepteur ,String emetteur,String information,String type,Object info){
            //envoyer une notification à quelqu'un
            getAbonne(recepteur).ajouterNotification(new Notification(emetteur,new StringBuilder(information),type,info));
        }
       
        private static void alerterAmis(String user,Integer codePost){ 
            //envoyer des notifications aux amis de l'abonné
            
            ArrayList<String> listeAmis = getAbonne(user).getAmis();
            for(String recepteur: listeAmis) {
              notifier(recepteur,user," un nouveau statut.","publication",codePost);
            }
        }
        
        private static void alerterMembres(String grp,String user,Integer codePost){ 
            //envoyer des notifications aux membres d'un groupe
            ArrayList<String> membres = getGroupe(grp).getMembres();
            for(String recepteur: membres) {
              if(!user.equals(recepteur))
                notifier(recepteur,user," un nouveau statut dans "+grp+".","publication",codePost);
            }
        }
        
        
     //SE CONNECTER & SE DECONNECTER
       private static void seConnecter(String user) {
                getAbonne(user).setOnline(true);
        }
       
        private static void seDeconnecter(String user) {
            getAbonne(user).setOnline(false);
        }
        
        
    //PUBLIER SUR MUR
        private static int publier(String user,String contenu,String visibilite) {
            Abonne abo=getAbonne(user);
                Post p=creerPost(user,contenu,visibilite);//créer le poste
                int code=p.getCodePost();
            abo.ajouterPost(code); //ajouter le post au mur de celui qui l'a posté
            abo.ajouterActu(code);//l'ajouter le post au fil d'actualité aussi 
            if(!visibilite.toLowerCase().equals("privé")) {
                alerterAmis(user,code); //alerter les amis d'abo de la publication d'un certain contenu  
                ajouterActu(abo.getAmis(),p.getCodePost());//ajouter le post au fil d'actualité de ses amis
            }  
            return p.getCodePost();
        }
       
        
    //PUBLIER DANS UN GROUPE
        
        private static void publier(String user,String contenu, String grp,String visibilite) {//publier dans groupe
            Groupe g=getGroupe(grp);
            if(g==null) return;
            Post p =creerPost(user," a publié dans "
                    +grp+":\n"+contenu,visibilite);
            g.ajouterPost(p.getCodePost()); //ajouter le post au mur du groupe 
            alerterMembres(grp,user,p.getCodePost()); //alerter les membres du groupe
            ajouterActu(g.getMembres(),p.getCodePost()); //ajouter le post au fil d'actualité des membres   
        }
        
        private static void ajouterActu(ArrayList<String> users,int codePost){
            for(String user:users){
                getAbonne(user).ajouterActu(codePost);
            }
        }
      
        
     //EPINGLER & DESEPINGLER
        private static void epingler(Post p) {
            p.setEpinglee(true);
        }
        private static void desepingler(Post p) {
            p.setEpinglee(false);
        }
       
        
     //RECHERCHER UN ABONNE
        private static ArrayList<Post> rechercher(String chercheur,String recherche) {
         /* chercheur==celui qui fait la recherche \ recherche==celui qu'on recherche(recherché)
          * La recherche permet d'afficher le mur de l'abonné recherché et ceci suivant la visibilité accordée
          */
            Abonne abo1=getAbonne(chercheur),
                 abo2=getAbonne(recherche);
          ArrayList<Integer> codes= abo2.getMur(); //on réccupère le mur de l'abonné recherché
          ArrayList<Post> mur= new ArrayList<>();
          Post p;
         
          Visibilite v= Visibilite.publique;
             // on cherche la visibilité accordée
              if(chercheur.equals(recherche)) v= Visibilite.privé; 
               else if(abo2.sontAmis(chercheur)) v= Visibilite.amis;
                else if(abo2.ontAmisCommuns(abo1)) v=Visibilite.listeamis;
          int k=0;
          for(int i:codes){
              p=getPost(i);
              if(p!=null && p.visible(v)){ //afficher les postes du mur suivant la visibilité accordée (v)
                  if(!p.isEpinglee())
                     mur.add(k,p);
                  else{
                     mur.add(0,p);
                     k++;
                  }
              }
          }
               return mur; //retourner les postes à afficher
               
        }  
        
    //RECHERCHER UN GROUPE   
    private static ArrayList<Post> rechercherGroupe(String user,String recherche){
         Groupe grp = getGroupe(recherche);
         ArrayList<Integer> codes = grp.getMur();
         ArrayList<Post> mur = new ArrayList<>();
         Post p;
         
         Visibilite v;
         if(grp.membreExiste(user))
             v= Visibilite.groupe;
         else
             v= Visibilite.publique;
         
          int k=0;
          for(int i:codes){
              p=getPost(i);
              if(p!=null && p.visible(v)){
                  if(!p.isEpinglee())
                     mur.add(k,p);
                  else{
                     mur.add(0,p);
                     k++;
                  }
              }
          }
          return mur;
           
        }
     
    
    //REAGIR A UN POST
        private static void reagir(String user,Reaction react,int codePost) {
         //abo => abonné ayant réagi, poster=>abonné ayant posté le post p
            Post p = getPost(codePost);
            if(p==null) return;
            boolean reagis=p.aReagis(user);
            if(reagis && p.memeReaction(user,react))
               p.supprimerReaction(user); //supprimer la réaction de l'ensemble des réactions au post
            else{
                p.ajouterReaction(user,react);
                if(!reagis && !user.equals(p.getPoster())) 
                    notifier(p.getPoster(),user," à votre publication.","reaction", codePost);//alerter le poster seulement de la réaction d'abo à son post
            }
        }
       
     //REAGIR A UN COMMENTAIRE   complexité O(1)
        private static void reagir(String user,Reaction react,int codePost,int indice) {
            Post p = getPost(codePost);
            if(p==null) return;
            Commentaire c = p.getComment(indice);
            if(c==null) return;
            boolean reagis=c.aReagis(user);
            if(reagis && c.memeReaction(user,react))
               p.supprimerReaction(user); //supprimer la réaction de l'ensemble des réactions au commentaire
            else{
                c.ajouterReaction(user,react);
                if(!reagis && !user.equals(c.getUser()))
                    notifier(c.getUser(),user," à votre commentaire.","reaction",codePost);//alerter le poster seulement de la réaction d'abo à son post
            }
        }
       
       
        //METHODES COMMENTAIRES
       
    private static void commenter(String user,int codePost,String comment) { 
         Post p=getPost(codePost);
         if(p==null) return;
         p.ajouterCommentaire(new Commentaire(user,new StringBuilder(comment),codePost));  
         //alerter le poster si ce n'est pas lui qui a commenté a publication
         if(!user.equals(p.getPoster()))
            notifier(p.getPoster(),user," votre publication.","commentaire",codePost);
             
        }
       
    //supprimer un commentaire
       
    private static void supprimerCommentaire(int codePost,int indice) { //commentaire de user
       Post p = getPost(codePost);
        if(p==null) return;
        p.supprimerCommentaire(indice);
                   
        }
       

    //partager un post  
 
       
    private static void partager(String user,int codePost, String visibilite) {
        Post p = getPost(codePost);
        if(p==null) return;
        String user2=p.getPoster();
        int code;
         if(user.equals(user2))
             code = publier(user,"a partagé sa propre publication\n"+p.getContenu(),visibilite);
         else{
             code = publier(user,"a partagé la publication de "
                        +user2+":\n"+p.getContenu(),visibilite);
             notifier(user2,user," votre publication.","partage",Integer.valueOf(code));
         }
        }    
 
    private static void lireNotification(String user,int indice){
        ArrayList<Notification> notifs= getAbonne(user).getNotifications();
        notifs.get(indice).setEtat(true);
    }
   
   
     private static ArrayList<Post> filActu(String user){
        Abonne abo=getAbonne(user);
        ArrayList<Integer> codes = abo.getActu();
        ArrayList<Post> actu = new ArrayList<>();
        Post p;
        for(int i:codes){
           p=getPost(i);
            if(p!=null)
                actu.add(0,p);
        }
        return actu;
    }
     
     private static void supprimerPost(int codePost,String groupName){
         if(groupName==null){
         Abonne abo= getAbonne(getPost(codePost).getPoster());
         abo.supprimerPost(codePost); //Supprimer post du mur de l'abo
         supprimerActu(abo.getAmis(),codePost); //Supprimer post du fil d'actu de ses amis
         }
         else{
         Groupe grp= getGroupe(groupName);
         grp.supprimerPost(codePost); //Supprimer le post du mur du groupe
         supprimerActu(grp.getMembres(),codePost); //Supprimer post du fil d'actu de ses membres
         }
         basePosts.remove(codePost); //enfin le supprimer le base de données
     }
     
     private static void supprimerActu(ArrayList<String> users,int codePost){
         for(String user:users){
             getAbonne(user).supprimerActu(codePost);
         }
     }
 
   
    private static byte etatAmis(String user,String ami){
        Abonne abo=getAbonne(user);
        Abonne abo2=getAbonne(ami);
        boolean check1=abo.invitationEnvoyee(ami),
                check2=abo2.invitationEnvoyee(user);
       
       
        if(abo2.sontAmis(user))
            return 3;
        else if(check1||check2 ){
                if(check1)
                    return 1;  //Si abonné 2 a envoyé à Abonné 1 (client)
                else
                    return 2;   //Si abonné 1 (client) a envoyé à Abonné 2
             }
        else
            return 0;
           
    }
    
      private static ArrayList<String> search(String recherche){
        ArrayList<String> result= new ArrayList<>();
        recherche=recherche.replaceAll("\\s","").toLowerCase();
        
        //Rechercher dans la base d'abonnés
        for(Abonne abo:baseAbonnes.values()){
            if(abo.isNamed(recherche))
                result.add(abo.toString());
        }
        
        //Rechercher dans la base de groupes
        for(Groupe grp:baseGroupes.values()){
            if(grp.isNamed(recherche))
                result.add(grp.getGroupName()+"\n*\n*");
        }
        
        //Trier les résultats par ordre alphabetique 
        Collections.sort(result, String.CASE_INSENSITIVE_ORDER);
        return result;
       
    }

    private static void refuserMembre(String user,String grp){
      //Refuser la demande d'un membre
      Groupe g=getGroupe(grp);
        if(g==null) return;
          g.refuserMembre(user);
        }
    
    private static void sauvegarderDonnees() throws FileNotFoundException, IOException{

      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Donnees\\abonnes.bin"));
      os.writeObject(baseAbonnes);
      
      os = new ObjectOutputStream(new FileOutputStream("Donnees\\groupes.bin"));
      os.writeObject(baseGroupes);
      
      os = new ObjectOutputStream(new FileOutputStream("Donnees\\posts.bin"));
      os.writeObject(basePosts);
      
      os.close();
    }
    
    private static void chargerDonnees() throws FileNotFoundException, IOException, ClassNotFoundException{
        
      ObjectInputStream is = new ObjectInputStream(new FileInputStream("Donnees\\abonnes.bin"));
      baseAbonnes = (HashMap<String,Abonne>) is.readObject();
      Abonne.setCompteur(baseAbonnes.size());
      
      is = new ObjectInputStream(new FileInputStream("Donnees\\groupes.bin"));
      baseGroupes = (HashMap<String,Groupe>) is.readObject();
      
      is = new ObjectInputStream(new FileInputStream("Donnees\\posts.bin"));
      basePosts = (HashMap<Integer,Post>) is.readObject();
      Post.setCompteur(Collections.max(basePosts.keySet())+1);
      
      is.close();
    }
    ////////////////////////////LE MAIN////////////////////////////////////////////////////
   
    private static boolean actif=true;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
      
        ServerSocket socket=null;
        Socket serveur=null;
        ObjectInputStream in=null;
        ObjectOutputStream out=null;
       
        byte choix;
        String username,password,ami,message,visibilite,groupe;
        ArrayList<String> result;
        Abonne abo,abo2;
        Groupe grp;
        Post p;
        int indice,code;
        Integer ind;
        boolean check;
        
       
        new InterfaceServeur().setVisible(true);
     
    while(true){
        while(!actif){ //ATTENDRE ORDRE POUR ALLUMER SERVEUR
            try{
            socket=new ServerSocket(2018);
            serveur = socket.accept();
            out=new ObjectOutputStream(serveur.getOutputStream());
            in=new ObjectInputStream(serveur.getInputStream());
            actif= in.readByte()==0;
            }catch(IOException e){
                System.out.println(e+" Impossible de se connecter");
            }finally{
                in.close();
                out.close();
                socket.close();
                serveur.close();
 
            }
        }
        
        
        //CHARGER LES DONNEES A PARTIR DU FICHIER
        System.out.println("Chargement des données...");
        chargerDonnees();
        System.out.println("Serveur allumé");
        
        
        while(actif){
            try{
                socket=new ServerSocket(2018);
                serveur = socket.accept();
                out=new ObjectOutputStream(serveur.getOutputStream());
                in=new ObjectInputStream(serveur.getInputStream());
 
 
                    choix = in.readByte();
                    switch(choix){
 
                    case 1 :     //LA CONNEXION
                        username=(String)in.readObject();
 
                        check=userExiste(username); //Si username n'existe pas
                        out.writeBoolean(check);    //Envoyer message d'erreur disant que le username n'existe pas
                        out.flush();
                        if(!check) break;
 
 
                        password=(String) in.readObject();
 
                        check=checkPassword(username,password); //Si password ne correspond pas
                        out.writeBoolean(check);               //Envoyer message d'erreur disant que le mdp érroné
                        out.flush();
                        if(!check) break;
 
                        seConnecter(username);
                    break;
                   
                    case 2:     //L'INSCRIPTION
                        username=(String) in.readObject();
 
                        check = !userExiste(username); //Si le username existe déjà
                        out.writeBoolean(check);       //Envoyer message d'erreur disant que le username déjà pris
                        out.flush();
                        if(!check) break;
                       
                        abo= new Abonne((String)in.readObject(),
                                        (String)in.readObject(),
                                        (String)in.readObject(),
                                        (String)in.readObject(),
                                        username,
                                        (String)in.readObject(),
                                        (String)in.readObject(),
                                        (String)in.readObject(),
                                        (String)in.readObject());
                        inscrireAbonne(abo);
                    break;
                   
                    case 3:  //LA DECONNEXION
                        username=(String) in.readObject();
                       
                        seDeconnecter(username);
                        break;
                   
                    case 4:  //ENVOYER LA LISTE DE NOTIFICATIONS
                        username=(String) in.readObject();
                        out.writeObject(getAbonne(username).getNotifications());
                        out.flush();
                        break;
                   
                    case 5:  //ENVOYER LA LISTE D'INVITATIONS
                        username=(String) in.readObject();
                        out.writeObject(getAbonne(username).getInvitations());
                        out.flush();
                        break;                    
                   
                    case 6:  //AJOUTER  (CORRESPOND AU BOUTON AJOUTER)
                        username=(String) in.readObject();
                        ami=(String) in.readObject();
                        message=(String) in.readObject();
                        switch(etatAmis(username,ami)){
                            case 0: //Si ils ne sont pas amis
                                ajouter(username,ami,message);
                                break;
                            case 1: //Si client a reçu invition de la part de ami
                                accepterInvitation(username,ami);
                                break;
                            case 2: //Si client a envoyé invitation à ami
                                getAbonne(ami).annulerInvitation(username);
                                break;
                            case 3: //Si ils sont amis
                                supprimerAmi(username,ami);
                                break;
                        }
                       
                        break;
                       
                    case 7:  //LIRE UNE NOTIFICATION
                        username=(String) in.readObject();
                        indice=in.read();
                        lireNotification(username,indice);
                        break;
                       
                   case 8: //ACCEPTER INVITATION
                        username=(String) in.readObject();
                        indice= in.read();
                        accepterInvitation(username,indice);
                        break;
                       
                     case 9: //REFUSER INVITATION
                        username=(String) in.readObject();
                        indice=in.read();
                        refuserInvitation(username,indice);
                        break;    
                       
                     case 10: //ENVOYER LA LISTE DES POSTS DU FIL D'ACTUALITES
                        username=(String) in.readObject();
                        ArrayList<Post> posts=filActu(username);
                        out.writeObject(posts);
                        out.flush();
                        break;
                       
                     case 11: //REAGIR A UN POST OU A UN COMMENTAIRE
                         username=(String) in.readObject();
                         Reaction react=(Reaction) in.readObject();
                         code=in.read();
                         ind=(Integer) in.readObject();
                         if(ind==null)
                             reagir(username, react, code);
                         else
                             reagir(username, react, code, ind);
                         break;
                         
                     case 12: //ENVOYER LA LISTE DES POSTS DU MUR DE QUELQU'UN
                        username=(String) in.readObject();
                        ami=(String) in.readObject();
                        ArrayList<Post> mur=rechercher(username,ami);
                        out.writeObject(mur);
                        out.flush();
                        break;
                        
                     case 13://EPINGLER UN POST
                         indice=in.read(); //indice=codePost
                         p=getPost(indice);
                         if(p==null) break;
                         
                         if(!p.isEpinglee())
                             epingler(p);
                         else
                             desepingler(p);
                         System.out.println(getPost(indice).isEpinglee());
                         break;
                         
                     case 14://SUPPRIMER UN POST
                         indice=in.read(); //indice=codePost
                         groupe= (String) in.readObject(); //Si c'est un groupe ou pas
                         supprimerPost(indice,groupe);
                         break;
                         
                     case 15://MASQUER UN POST
                         username= (String) in.readObject();
                         indice = in.read();
                         getAbonne(username).supprimerActu(indice);
                         break;
                         
                     case 16: //CE QUE AFFICHE LE BOUTON AJOUTER
                         username= (String) in.readObject();
                         ami= (String) in.readObject();
                         if(in.readBoolean())
                             out.writeByte(etatMembre(username,ami));
                         else
                             out.writeByte(etatAmis(username,ami));
                         out.flush();
                         break;
                         
                     case 17://PUBLIER SUR LE MUR
                         username= (String) in.readObject();
                         message=(String) in.readObject();
                         visibilite=(String) in.readObject();
                         publier(username, message, visibilite);
                         break;
                         
                      case 18:  //CREER UN GROUPE
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         check=!groupeExiste(groupe);
                         out.writeBoolean(check);
                         out.flush();
                         if(!check) break;
                         creerGroupe(username,groupe);
                         break;
                         
                      case 19:  //REJOINDRE OU QUITTER UN GROUPE (CORRESPOND AU BOUTON)
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         switch(etatMembre(username,groupe)){
                             case 0: //Si il n'est pas membre
                                 rejoindreGroupe(username, groupe);
                                 break;
                             case 1: //Si demande déjà envoyée
                                 getGroupe(groupe).supprimerDemande(username);
                                 break;
                             case 2: //Si membre
                                 quitterGroupe(username, groupe);
                                 break;
                             case 3: //Si admin
                                 quitterGroupe(username, groupe);
                                 break;
                             
                                }
                         break;
                         
                      case 20:  //VERIFIER SI MEMBRE EST ADMIN
                          username= (String) in.readObject();
                          groupe= (String) in.readObject();
                          
                          out.writeBoolean(etatMembre(username, groupe)==3);
                          out.flush();
                         
                         break;
                         
                      case 21:  //ENVOYER LES INFOS D'UN MEMBRE
                         ami= (String) in.readObject();
                         abo= getAbonne(ami);
                         out.writeObject(abo.getInfos());
                         out.flush();
                         break;
                         
                      case 22: //ENVOYER LA LISTE D'AMIS
                         username=(String) in.readObject();
                         result=new ArrayList<>();
                         for(String user:getAbonne(username).getAmis()){
                             result.add(getAbonne(user).toString());
                         }
                         out.writeObject(result);
                         out.flush();
                         break;
                      case 23: //AJOUTER UN COMMENTAIRE A UN POSTE
                         username=(String) in.readObject();
                         indice=in.read();
                         message=(String)in.readObject();
                         commenter(username,indice,message);
                         break;
                      case 24: //ENVOYER LA LISTE DES COMMENTAIRES   
                         Integer i=(Integer) in.readObject();
                         ArrayList<Commentaire> comments=getPost(i).getComments();
                         out.writeObject(comments);
                         out.flush();
                         break;
                      case 25: //ENVOYER LES MEMBRES D'UN GROUPE
                          groupe= (String) in.readObject();
                          result=new ArrayList<>();
                          for(String user:getGroupe(groupe).getMembres()){
                              result.add(getAbonne(user).toString());
                          }
                          out.writeObject(result);
                          out.flush();
                         break;
                      case 26: //AFFICHER POSTES D'UN GROUPE
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         out.writeObject(rechercherGroupe(username, groupe));
                         out.flush(); 
                         break;
                      case 27: //SUPPRIMER COMMENTAIRERS
                         code= in.read();
                         indice=in.read();
                         supprimerCommentaire(code,indice);
                         break;
                      case 28: //FAIRE UNE RECHERCHE
                         message= (String) in.readObject();
                         out.writeObject(search(message));
                         out.flush();
                         break;
                      case 29: //ACCEPTER UN MEMBRE
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         accepterMembre(username,groupe);
                         break;
                      case 30: //AJOUTER UN ADMIN
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         getGroupe(groupe).ajouterAdmin(username);
                         break;
                      case 31: //RECCUPERER LES INFOS D'UN GROUPE
                          groupe=(String) in.readObject();
                          out.writeObject(getGroupe(groupe).getInfos());
                          out.flush();
                          break;
                      case 32: //ENVOYER LISTE DEMANDES:
                          groupe=(String) in.readObject();
                          result =new ArrayList<String>();
                          ArrayList<String> liste= getGroupe(groupe).getListeAttente();
                          for(String s: liste){
                              result.add(getAbonne(s).toString());
                          }
                          out.writeObject(result);
                          out.flush();
                          break;
                     case 33 : //PARTAGER UN POST
                          username= (String) in.readObject();
                          code=in.read();
                          message=(String) in.readObject();
                          partager(username, code, message);
                          break;     
                      case 34 : //PUBLIER DANS UN GROUPE
                          username= (String) in.readObject();
                          message=(String) in.readObject();
                          visibilite=(String) in.readObject();
                          groupe=(String) in.readObject();
                          publier(username,message, groupe, visibilite);
                          break;  
                      case 35 : //ENVOYER LA LISTE DES GROUPES
                          username=(String) in.readObject();
                          out.writeObject(getAbonne(username).getGroupes());
                          out.flush();
                          break;
                      case 36: //VERIFIER SI UN ABONNE EST EN LIGNE
                          username=(String)in.readObject();
                          out.writeBoolean(estEnLigne(username));
                          out.flush();
                          break;
                      case 37: //REFUSER MEMBRE GROUPE
                         username= (String) in.readObject();
                         groupe= (String) in.readObject();
                         refuserMembre(username,groupe);
                         break;
                      case 38: //ENVOYER UN SEUL POST
                         code= in.read();
                         out.writeObject(getPost(code));
                         out.flush();
                         break;
                      case 39: //ETEINDRE LE SERVEUR
                          actif=false;
                          break;
                        
                          
                }
 
                   
            }catch(IOException e){
                System.out.println(e+" Impossible de se connecter");
            }finally{
                in.close();
                out.close();
                socket.close();
                serveur.close();
 
            }
       
       
       
        }
        //SAUVEGARDER LES DONNEES DANS LE FICHIER
        System.out.println("Données entrain d'être sauvegardées...");
        sauvegarderDonnees();
        System.out.println("Données sauvegardées");
        System.out.println("Serveur Eteint");
    }
    }
   
}