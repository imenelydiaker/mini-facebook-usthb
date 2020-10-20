package com.usthb.modeles;

public enum InvitationEtat {
	acceptée("Invitation acceptée"),
	refusée("Invitation refusée"),
	instance("Invitation envoyée");
	
	private String etat="";
	
	InvitationEtat(String etat){
		this.setEtat(etat);
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
