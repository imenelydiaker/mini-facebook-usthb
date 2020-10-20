package com.usthb.modeles;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
 
public class Post implements Serializable{
    private static int cpt=0; //numéro séquentiel automatique
    private final Integer codePost;
    private String contenu;
    private final String poster; //celui qui a posté
    private Visibilite niveauVisibilite;
    private int nombrePartage; //nombre de partages
    private boolean epinglee;//non épinglé = false | épinglé = true
    private ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>(); //la clé est le code du commentaire
    private HashMap<String,Reaction> reactions = new HashMap<String,Reaction>(); //la clé est le username de l'abonn� qui a r�agi au post
   
    //CONSTRUCTEUR
    public Post(String poster,String contenu, String visibilite) {
        codePost=cpt++;
                this.poster=poster;
        this.contenu=contenu;
        this.niveauVisibilite=Visibilite.valueOf(visibilite.toLowerCase());
       
    }
   
    //GETTERS AND SETTERS
    public static int getCpt() {
        return cpt;
    }
    public Integer getCodePost() {
        return codePost;
    }
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public Visibilite getNiveauVisibilite() {
        return niveauVisibilite;
    }
    public void setNiveauVisibilite(Visibilite niveauVisibilite) {
        this.niveauVisibilite = niveauVisibilite;
    }
    public int getNombrePartage() {
        return nombrePartage;
    }
    public void setNombrePartage(int nombrePartage) {
        this.nombrePartage = nombrePartage;
    }
        public int getNombreReaction() {
        return reactions.size();
    }
    public boolean isEpinglee() {
        return epinglee;
    }
    public void setEpinglee(boolean epinglee) {
        this.epinglee = epinglee;
        }
    public String getPoster() {
        return poster;
    }
    
    public static void setCompteur(int i){
        cpt=i;
    }
   
    //methode d'affichage
   
       
    public boolean visible(Visibilite v){
            return v.ordinal()>=niveauVisibilite.ordinal();
        }
       
    //METHODES REACTIONS
   
    public void ajouterReaction(String user,Reaction react) {
        reactions.put(user,react);
    }
   
    public void supprimerReaction(String user) {
                reactions.remove(user);
    }
 
    //METHODES COMMENTAIRES
    
    public void ajouterCommentaire(Commentaire c) {
        commentaires.add(c);
    }
    public void supprimerCommentaire(int indice) { //commentaire de user
            commentaires.get(indice).supprimer();
    }
   
        public HashMap<String, Reaction> getReactions(){
            return reactions;
        }
       
        public boolean aReagis(String user){
            return reactions.containsKey(user);
        }
       
        public boolean memeReaction(String user,Reaction react){
            return reactions.get(user).equals(react);
        }
       
        public Commentaire getComment(int indice){
            return commentaires.get(indice);
        }
        
        public ArrayList<Commentaire> getComments(){
            return commentaires;
        }
        
       
   
}