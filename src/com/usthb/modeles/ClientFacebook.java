package com.usthb.modeles;
 
import interfacesGraphiques.ConnexionFen;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
 
 
public class ClientFacebook {
   
    private static Socket socket=null;
    private static ObjectInputStream in=null;
    private static ObjectOutputStream out=null;
   
    private static String client=null;
   
    public static byte seConnecter(String username,String password) throws IOException, ClassNotFoundException, InterruptedException{
       
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             in=new ObjectInputStream(socket.getInputStream());
             out=new ObjectOutputStream(socket.getOutputStream());
             out.writeByte(1);
             out.flush();
             out.writeObject(username);
             out.flush();
             if(!in.readBoolean())
                 return 1;
           
             
             out.writeObject(password);
             out.flush();
             if(!in.readBoolean()) return 2;
             
             client= username;
             return 0;
             
             
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return 3;
    }
 
    public static byte inscrireAbonne(String nom, String prenom, String date, String categorie, String username, String password, String fonction, String specialite, String nivEtude) throws UnknownHostException, IOException {
       
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(2);
            out.flush();
           
            out.writeObject(username);
            out.flush();
           
            if(!in.readBoolean()) return 1;
           
            out.writeObject(nom);
            out.flush();
            out.writeObject(prenom);
            out.flush();
            out.writeObject(date);
            out.flush();
            out.writeObject(categorie);
            out.flush();
            out.writeObject(password);
            out.flush();
            out.writeObject(fonction);
            out.flush();
            out.writeObject(specialite);
            out.flush();
            out.writeObject(nivEtude);
            out.flush();
           
            return 0;
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return 2;
     
    }
   
    public static void seDeconnecter() throws IOException{
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(3);
             out.flush();
             out.writeObject(client);
             out.flush();
             client=null;
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
    }
   
   
    public static ArrayList<Notification> getNotifications() throws IOException, ClassNotFoundException {
           try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(4);
             out.flush();
             out.writeObject(client);
             out.flush();
             return (ArrayList<Notification>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
       return null;
    }
   
    public static ArrayList<Invitation> getInvitations() throws ClassNotFoundException, IOException{
           try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(5);
             out.flush();
             out.writeObject(client);
             out.flush();
             return (ArrayList<Invitation>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
       return null;  
       
    }
   
   
    public static void ajouter(String ami, String message) throws IOException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(6);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.writeObject(ami);
             out.flush();
             out.writeObject(message);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
    }
   
    public static void lireNotification(int indice) throws  IOException{
       try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(7);
             out.flush();
             
             out.writeObject(client);
             out.flush();
             
             out.write(indice);
             out.flush();
             
       }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
   }
   
   public static void accepterInvitation(int indice) throws UnknownHostException, IOException{
       try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(8);
             out.flush();
             
             out.writeObject(client);
             out.flush();
             
             out.write(indice);
             out.flush();
             
             
       }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
   }
   
   public static void refuserInvitation(int indice) throws UnknownHostException, IOException {
       try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(9);
             out.flush();
             
             out.writeObject(client);
             out.flush();
             
             out.write(indice);
             out.flush();
             
             
       }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
   }
   
   
   public static ArrayList<Post> afficherActu() throws IOException, ClassNotFoundException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(10);
             out.flush();
             out.writeObject(client);
             out.flush();
             return (ArrayList<Post>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
       return null;
    }
   
   
     public static void reagir(Reaction react,int codePost,Integer indice) throws IOException {//abo => abonné ayant réagi, poster=>abonné ayant posté le post p
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(11);
             out.flush();
             
             out.writeObject(client);
             out.flush();
             
             out.writeObject(react);
             out.flush();
             
             out.write(codePost);
             out.flush();
             
             out.writeObject(indice);
             out.flush();
             
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
           
        }
       
  public static ArrayList<Post> afficherMur(String user) throws IOException, ClassNotFoundException{
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(12);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.writeObject(user);
             out.flush();
             return (ArrayList<Post>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
       return null;
    }
   
 
      public static void epingler(int codePost) throws IOException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(13);
             out.flush();
             out.write(codePost);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
     
 
      public static void supprimerPost(int codePost,String groupName) throws IOException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(14);
             out.flush();
             out.write(codePost);
             out.flush();
             out.writeObject(groupName);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
     
      public static void masquerPost(int codePost) throws IOException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(15);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.write(codePost);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
     
     
       public static byte btnAjouter(String name,boolean isGroupe) throws IOException {
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(16);
             out.flush();
             out.writeObject(client);
             out.flush();
             
             out.writeObject(name);
             out.flush();
             
             out.writeBoolean(isGroupe);
             out.flush();
             return in.readByte();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return 4;
    }
     
      //PUBLIER SUR MUR
       
        public static void publier(String contenu,String visibilite) throws IOException {
            try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(17);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.writeObject(contenu);
             out.flush();
             out.writeObject(visibilite);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
        
        //PUBLIER DANS UN GROUPE
       
        public static void publier(String contenu,String visibilite,String groupName) throws IOException {
            try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(34);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.writeObject(contenu);
             out.flush();
             out.writeObject(visibilite);
             out.flush();
             out.writeObject(groupName);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
        
        
        
        public static boolean creerGroupe(String groupName) throws IOException{
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            out= new ObjectOutputStream(socket.getOutputStream());
            in= new ObjectInputStream(socket.getInputStream());
           
            out.writeByte(18);
            out.flush();
           
            out.writeObject(client);
            out.flush();
            out.writeObject(groupName);
            out.flush();
            
            return in.readBoolean();
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return false;
     
    }
        
    public static void rejoindreGroupe(String username,String groupName) throws IOException{
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(19);
            out.flush();
           
            out.writeObject(username);
            out.flush();
            out.writeObject(groupName);
            out.flush();
            
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
     
    }
    
    public static boolean estMembre(String groupName) throws IOException{
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(20);
            out.flush();
           
            out.writeObject(client);
            out.flush();
            
            out.writeObject(groupName);
            out.flush();
            
            return in.readBoolean();
            
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return false;
     
    }
    
    public static HashMap<String,String> getInfos(String username) throws IOException, ClassNotFoundException{
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(21);
            out.flush();
            
            out.writeObject(username);
            out.flush();
           
            return (HashMap<String,String>) in.readObject();
            
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new HashMap<String,String>();
     
    }
    
   
        
    public static ArrayList<String> getListeAmis(String username) throws ClassNotFoundException, IOException{
         try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(22);
            out.flush();
            
            out.writeObject(username);
            out.flush();
            
            return (ArrayList<String>) in.readObject();
           
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new ArrayList<String>();
    }
   
    
       public static ArrayList<String> getListeGroupes(String username) throws ClassNotFoundException, IOException{
         try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(35);
            out.flush();
            
            out.writeObject(username);
            out.flush();
            
            return (ArrayList<String>) in.readObject();
           
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new ArrayList<>();
    }
   

      public static ArrayList<Post> afficherGrp(String user) throws IOException, ClassNotFoundException{
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             out.writeByte(26);
             out.flush();
             out.writeObject(client);
             out.flush();
             out.writeObject(user);
             out.flush();
             return (ArrayList<Post>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
       
       return new ArrayList<>();
    }
       
        
       
     
        //METHODES COMMENTAIRES
       
    public static void commenter(int codePost,String comment) throws IOException { //abo => abonné qui va commenter, poster=>abonn? qui a post? le post p
          try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(23);
            out.flush();
            out.writeObject(client);
            out.flush();
            out.write(codePost);
            out.flush();
            out.writeObject(comment);
            out.flush();
            
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
    
    public static ArrayList<Commentaire> getCommentaires(Integer codePost) throws ClassNotFoundException, IOException{
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(24);
            out.flush();
            
            out.writeObject(codePost);
            out.flush();
            
            return (ArrayList<Commentaire>) in.readObject();
           
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return null;
    }
    
    public static ArrayList<String> getListeMembres(String groupName) throws IOException, ClassNotFoundException{
       
        try{
            socket= new Socket(InetAddress.getLocalHost(),2018);
            in= new ObjectInputStream(socket.getInputStream());
            out= new ObjectOutputStream(socket.getOutputStream());
           
            out.writeByte(25);
            out.flush();

            out.writeObject(groupName);
            out.flush();
            
            return (ArrayList<String>) in.readObject();
            
        }catch(UnknownHostException e){
            System.out.println(e + " Unknown Host");
        }catch(IOException e){
            System.out.println(e + " IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new ArrayList<String>();
     
    }
       
    //supprimer un commentaire    
    public static void supprimerCommentaire(int codePost,int indice) throws IOException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(27);
             out.flush();
             
             out.write(codePost);
             out.flush();
             
             out.write(indice);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
    public static ArrayList<String> rechercher(String recherche) throws IOException, ClassNotFoundException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(28);
             out.flush();
             
             out.writeObject(recherche);
             out.flush();
             
             return (ArrayList<String>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new ArrayList<String>();
    }
    
        public static void accepterMembre(String username,String groupName) throws IOException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(29);
             out.flush();
             
             out.writeObject(username);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
            }
        }
        
    
        public static void ajouterAdmin(String username,String groupName) throws IOException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(30);
             out.flush();
             
             out.writeObject(username);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        }
        
        public static int[] getInfosGroupe(String groupName) throws IOException, ClassNotFoundException { //commentaire de user
        
            int[] tab = new int[2];
            try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(31);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
             String s=(String) in.readObject();
             String[] tabs = s.split("\n");
             
             tab[0]=Integer.valueOf(tabs[0]);
             tab[1]=Integer.valueOf(tabs[1]);
             return tab;
             
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return tab;
        }        
        
    public static ArrayList<String> getListeAttente(String groupName) throws IOException, ClassNotFoundException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(32);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
             return (ArrayList<String>) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return new ArrayList<String>();
    }
   
    
       public static void partager(int codePost,String visibilite) throws IOException, IOException {
          try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(33);
             out.flush();
             
             out.writeObject(client);
             out.flush();
             
             out.write(codePost);
             out.flush();
             
             out.writeObject(visibilite);
             out.flush();
             
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
    }
       
       public static boolean estEnLigne(String username) throws IOException{
              try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(36);
             out.flush();
             
             out.writeObject(username);
             out.flush();
             
             return in.readBoolean();
             
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
        }
        return false;
       }
       
        public static void refuserMembre(String username,String groupName) throws IOException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(37);
             out.flush();
             
             out.writeObject(username);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
            }
        }
        
        public static Post getPost(int code) throws IOException, ClassNotFoundException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(38);
             out.flush();
             
             out.write(code);
             out.flush();
             
             return (Post) in.readObject();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
            }
        return null;
        }
        
        public static boolean estAdmin(String username,String groupName) throws IOException, ClassNotFoundException { //commentaire de user
        try{
             socket = new Socket(InetAddress.getLocalHost(),2018);
             out=new ObjectOutputStream(socket.getOutputStream());
             in=new ObjectInputStream(socket.getInputStream());
             
             out.writeByte(20);
             out.flush();
             
             out.writeObject(username);
             out.flush();
             
             out.writeObject(groupName);
             out.flush();
             
             return in.readBoolean();
             
        }catch(UnknownHostException e){
            System.out.println(e + "Unknown Host");
        }catch(IOException e){
            System.out.println(e + "IOException");
        }finally{
            in.close();
            out.close();
            socket.close();
            }
        return true;
        }
    
       
    public static void main(String[] args) {
       
      new ConnexionFen().setVisible(true);
    
    }
   
    public static String getClient(){
        return client;
    }
   
    public static void setClient(String abo){
        client=abo;
    }
 
   
   
   
}