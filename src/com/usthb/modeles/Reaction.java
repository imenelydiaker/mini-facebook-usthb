    package com.usthb.modeles;

public enum Reaction {
	jaime("J'aime"),
	jadore("J'adore"),
	gai("Haha"),
	triste("Triste"),
	encolère("Grrr");
	
	private String type="";
	
	Reaction(String type){
		this.type=type;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
