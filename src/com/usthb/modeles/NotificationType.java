package com.usthb.modeles;

public enum NotificationType {
	publication("a publié"),
	commentaire("a commenté"),
	reaction("a réagi"), 
        invitation("a accepté"),
        groupe("a approuvé"),
        demande("a demandé à joindre "),
        partage("a partagé"); 

	private String type="";
	
	NotificationType(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
