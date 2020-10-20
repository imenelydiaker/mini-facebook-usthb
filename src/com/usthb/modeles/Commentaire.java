package com.usthb.modeles;
 
import java.io.Serializable;
import java.util.HashMap;
 
public class Commentaire implements Serializable{
    private String username;
    private StringBuilder information;
    private final int codePost;
    private HashMap<String,Reaction> reactions = new HashMap<String,Reaction>(); //la cl� est le username de l'abonn� qui a r�agi au post
    private boolean visible=true;
    
    public Commentaire(String username,StringBuilder information,int codePost){
        this.codePost= codePost;
        this.username=username;
        this.information=information;
     }
   
    public int getCodePost(){
        return codePost;
    }
   
    public String getUser(){
        return username;
    }
   
    public void modifier(String info){
        information=new StringBuilder(info);
       
    }
   
    public String getComment(){
        return information.toString();
    }
    //METHODES REACTIONS
   
    public void ajouterReaction(String user,Reaction react) {
    reactions.put(user,react);
    }
   
    public void supprimerReaction(String user) {
        reactions.remove(user);
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
   
    public boolean isVisible(){
        return visible;
    }
    
    public void supprimer(){
        visible=false;
    }
     
     
   
}