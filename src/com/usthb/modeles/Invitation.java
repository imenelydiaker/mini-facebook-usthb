package com.usthb.modeles;
 
import java.io.Serializable;
 
public class Invitation implements Serializable{
    private final String emetteur;
    private final String message;
    private InvitationEtat etat;
   
    public Invitation(String emetteur,String message) {
        this.emetteur = emetteur;
        this.message = message;
        etat =InvitationEtat.valueOf("instance");
    }
 
    public InvitationEtat getEtat() {
        return etat;
    }
 
    public void setEtat(InvitationEtat etat) {
        this.etat = etat;
    }
 
    public String getMessage() {
        return message;
    }
 
 
        public String getEmetteur(){
            return emetteur;
        }
 
    public boolean invitationEnInstance() {
        return String.valueOf(etat).equals("instance");
    }

    @Override
    public boolean equals(Object o){
        Invitation n = (Invitation) o;
        return emetteur.equals(n.emetteur) && etat.equals(n.etat);
    }
}