package com.usthb.modeles;

import java.io.Serializable;

public class Notification implements Serializable{
	
	private StringBuilder information;
	private NotificationType type;
	private String poster;	//LE USERNAME DE CELUI DONT ON RECOIT LA NOTIFICATION
	private boolean etat; 			//true=>lue, false=>non lue
        private Object info;
	
	//CONSTRUCTEUR
	public Notification(String poster,StringBuilder information,String type,Object info) {
		this.poster = poster; 
		this.information=information;
		this.type=NotificationType.valueOf(type.toLowerCase());
                this.info=info;
                this.etat=false;
	}
	
	//SETTERS AND GETTERS
	public String getInformation() {
		return information.toString();
	}

	public void setInformation(StringBuilder information) {
		this.information = information;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	} 

	public Object getInfo(){
            return info;
        }
}
