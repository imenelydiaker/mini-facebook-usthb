package com.usthb.modeles;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
 
import javax.swing.JOptionPane;
 
public class Groupe implements Serializable{
     //ajouter la liste des administrateurs du groupe
     private String groupName="";
     private ArrayList<String> admins = new ArrayList<String>();
     private ArrayList<String> membres = new ArrayList<String>();
     private ArrayList<String> listeAttente = new ArrayList<String>();
     private ArrayList<Integer> mur = new ArrayList<Integer>();
     
   
    public Groupe(String createur,String groupName) {
        ajouterMembre(createur);
        ajouterAdmin(createur);
        this.groupName=groupName;
       
    }
 
    public String getGroupName() {
        return groupName;
    }
 
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
 
   
    //METHODES MEMBRES
   
   
    public void ajouterMembre(String user) {
        listeAttente.remove(user);
        membres.add(user);
    }
    
    public void refuserMembre(String user){
        listeAttente.remove(user);
    }
    
    public void rejoindre(String user){
        listeAttente.add(user);
    }
    
    public boolean demandeEnvoyée(String user){
        return listeAttente.contains(user);
    }
    public void supprimerDemande(String user){
        listeAttente.remove(user);
    }
    public ArrayList<String> getListeAttente(){
        return listeAttente;
    }
   
    public void supprimerMembre(String user) {
            admins.remove(user);
            membres.remove(user);
    }
   
   
    public boolean membreExiste(String username) { //vérifie si un abonné est membre du groupe
        return membres.contains(username);
    }
   
    public  void ajouterAdmin(String user) {
        admins.add(user);
    }
    
    public boolean adminExiste(String user){
        return admins.contains(user);
    }
    
    public ArrayList<String> getAdmins(){
        return admins;
    }
    
    public ArrayList<String> getMembres(){
        return membres;
    }
    
    public int nbrMembres(){
        return membres.size();
    }
    
    public int nbrAdmins(){
        return admins.size();
    }
 
 
        // METHODES MUR
   
    public void ajouterPost(int p) {
            mur.add(p);
    }
               
      
    
        //NOTIFIER LES MEMBRES DU GROUPE
 
    ArrayList<Integer> getMur() {
        return mur;
    }
   

    public boolean isNamed(String name){
           String n=groupName.toLowerCase();
           if(n.replaceAll("\\s","").startsWith(name))
               return true;
           for(String s:n.split(" ")){
               if(name.startsWith(s))
                   return true;
           }
           return false;
    }
    
    public void supprimerPost(Integer codePost){
        mur.remove(codePost);
    }
    public String getInfos(){
        return membres.size()+"\n"+listeAttente.size();
    }
 
   
}