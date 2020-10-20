package com.usthb.modeles;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
 
 
public class Abonne implements Serializable{
   
 private static int cpt=0;
 private final Integer codeAbonne;
 private String nom,prenom;
 private String dateN;
 private Categorie cat;
 private String username;
 private String password;
 private String specialite="",nivEtude="",fonction="";
 private ArrayList<String> listeAmis = new ArrayList<String>();
 private ArrayList<Invitation> ensInvitations = new ArrayList<Invitation>(); //l'abonné est la clé
 private ArrayList<Integer> mur = new ArrayList<Integer>();
 private ArrayList<Notification> ensNotifications = new ArrayList<Notification>();
 private ArrayList<String> ensGroupes = new ArrayList<String>(); //la clé est le nom du groupe
 private ArrayList<Integer> actu = new ArrayList<Integer>();
 private int online=0;
 
 //CONSTRUCTEUR
 public Abonne(String nom, String prenom, String dateN, String cat,String username,String password,String fonction,String specialite,String nivEtude){
     
     codeAbonne=cpt++;
     this.nom = nom;
     this.prenom = prenom;
     this.dateN = dateN;
     this.cat = Categorie.valueOf(cat.toLowerCase());
     this.username = username;
     this.password = password;
     this.specialite = specialite;
     this.nivEtude = nivEtude;
     this.fonction = fonction;
 
}
 
     //SETTERS AND GETTERS
    public Integer getCode() {
        return codeAbonne;
    }
   
    public Categorie getCategorie() {
        return cat;
    }
   
    public String getPrenom() {
        return prenom;
    }
   
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
   
    public String getNom() {
        return nom;
    }
   
    public void setNom(String nom) {
        this.nom = nom;
    }
   
    public String getDateNaissance() {
        return dateN;
    }
   
    public void setDateNaissance(String dateN) {
        this.dateN = dateN;
    }
   
    public String getUsername() {
        return username;
    }
   
    public void setUsername(String username) {
       
        this.username = username;
    }
   
    public String getPassword() {
        return password;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getSpecialite() {
        return specialite;
    }
   
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
   
    public String getNivEtude() {
        return nivEtude;
    }
   
    public void setNivEtude(String nivEtude) {
        this.nivEtude = nivEtude;
    }
   
    public String getFonction() {
        return fonction;
    }
   
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    public static void setCompteur(int i){
        cpt=i;
    }
    public boolean isOnline() {
        return online!=0;
    }
   
    public void setOnline(boolean on) {
        if(on)
            online++;
        else
            online--;
    }
   
        public ArrayList getNotifications(){
            return ensNotifications;
        }
       
       
       
        //METHODES
   
    //LISTE D'AMIS
       
     
        
        
        public ArrayList<String> getAmis(){
            return listeAmis;
        }
   
    public boolean sontAmis(String ami) {
        return listeAmis.contains(ami);
    }
   
    public boolean ontAmisCommuns(Abonne user) {
        for(String ami: listeAmis) {
            if(user.listeAmis.contains(ami)) return true;
        }
        return false;
    }
 

        public void supprimerAmi(String ami){
            listeAmis.remove(ami);
        }
       
        public void ajouterAmi(String ami){
            listeAmis.add(ami);
        }
       
        
       
 
    //LISTE D'INVITATIONS
   
        public ArrayList<Invitation> getInvitations(){
            return ensInvitations;
        }
       
        public void ajouterInvitation(Invitation inv){
            ensInvitations.add(inv);
        }
       
        public void refuserInvitation(int indice){
            Invitation inv=ensInvitations.get(indice);
            if(inv!=null)
                    inv.setEtat(InvitationEtat.refusée);
        }
           
       
        public String accepterInvitation(int indice){
            Invitation inv=ensInvitations.get(indice);
            if(inv==null) return "";                //Pour que GetAbonne("") retourne null et donc sort de la methode
                    inv.setEtat(InvitationEtat.acceptée);
            return inv.getEmetteur();
        }
        public void accepterInvitation(String user){
            Invitation inv= new Invitation(user,"");
            for(Invitation i:ensInvitations){
                if(inv.equals(i)){
                    i.setEtat(InvitationEtat.acceptée);
                    break;
                }
            }
        }
        public boolean invitationEnvoyee(String user){  
            return ensInvitations.contains(new Invitation(user,""));
        }
        
        public void annulerInvitation(String user){
            ensInvitations.remove(new Invitation(user,""));
        }
     
   
    // METHODES MUR
   
    public void ajouterPost(int p) {
        mur.add(p);
    }
   
    public void supprimerPost(Integer p) {//l'abonné supprime le post qu'il veut de son mur
        mur.remove(p);
    }
   
   
    public ArrayList<Integer> getMur(){
            return mur;
        }


    //METHODES NOTIFICATIONS
   
    public void ajouterNotification(Notification notif) {
        ensNotifications.add(notif);
    }
  
   
    //METHODES GROUPES
   
    public void ajouterGroupe(String grp) {
        ensGroupes.add(grp);
    }
   
    
   
    public void quitterGroupe(String grp) {
        ensGroupes.remove(grp);
    }
   
   
    public ArrayList<String> getGroupes(){
       return ensGroupes;
    }
    
           //METHODES FIL D'ACTUALITES
       
        public void ajouterActu(int p){
           actu.add(p);
        }
        public void supprimerActu(Integer p){
            actu.remove(p);
        }
        public ArrayList<Integer> getActu(){
            return actu;
        }
        
        public HashMap<String,String> getInfos(){
            HashMap<String,String> infos= new HashMap<String,String>();
            infos.put("nom",nom+" "+prenom);
            infos.put("date",dateN);
            infos.put("niveau etudes",nivEtude);
            infos.put("fonction",fonction);
            infos.put("specialite",specialite);
            infos.put("nombre amis", String.valueOf(listeAmis.size()));
            if(cat==Categorie.homme)
                infos.put("sexe","Homme");
            else
                infos.put("sexe","Femme");
            
            return infos;
        }
 
        public boolean isNamed(String name){
        String n=(nom+prenom).replaceAll("\\s","").toLowerCase(),
               p=(prenom+nom).replaceAll("\\s","").toLowerCase(),
               u=username.toLowerCase();
        if(u.startsWith(name) || n.startsWith(name) ||  p.startsWith(name))
            return true;
        n=(nom+" "+prenom+" "+username).toLowerCase();  //LES NOMS ET PRENOMS PEUVENT CONETENIR DES ESPACES
        for(String s:n.split(" ")){
            if(name.startsWith(s))
                return true;
        }
        return false;
    }
        
 @Override
    public String toString(){
        return username+"\n"+nom+"\n"+prenom;
    }
   
}